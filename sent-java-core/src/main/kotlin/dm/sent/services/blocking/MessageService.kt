// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.messages.ApiResponseOfCancelledMessage
import dm.sent.models.messages.ApiResponseOfMessage
import dm.sent.models.messages.ApiResponseOfMessageActivities
import dm.sent.models.messages.MessageCancelParams
import dm.sent.models.messages.MessageResendParams
import dm.sent.models.messages.MessageRetrieveActivitiesParams
import dm.sent.models.messages.MessageRetrieveStatusParams
import dm.sent.models.messages.MessageSendParams
import dm.sent.models.messages.MessageSendResponse
import java.util.function.Consumer

/**
 * Send a message and follow what happened to it.
 *
 * One endpoint sends on any channel: pass `channel: "sent"` and we pick between SMS, WhatsApp and
 * RCS per recipient using your routing rules, or name a channel to pin it. A send is accepted
 * asynchronously — `POST /v3/messages` returns an id, and delivery is reported through `GET
 * /v3/messages/{id}`, its activities, or a webhook.
 *
 * **A message needs a sender.** What you can send, where, and at what cost is decided by the
 * markets under **Channels** — so a recipient in a country you hold no sender for is refused here
 * rather than queued.
 *
 * **A message can be resent on its id.** `POST /v3/messages/{id}/resend` puts a finished message —
 * typically one BLOCKED for insufficient balance — back through the send pipeline. It is a new
 * attempt, not a free retry: every policy runs again, the message is billed again, and its status
 * webhooks fire again. A FILTERED message is never resendable.
 *
 * **A scheduled message can be called off.** `POST /v3/messages/{id}/cancel` cancels a send you
 * scheduled with `scheduled_at`, as long as it has not been released yet. Cancelling is free, fires
 * `message.cancelled`, and is final — a cancelled message cannot be resent.
 */
interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService

    /**
     * Calls off a message you scheduled with `scheduled_at`, before it is released for sending. The
     * message moves to `CANCELLED`, which is terminal, and it is never sent.
     *
     * **Only a SCHEDULED message can be cancelled.** A message that has already been released —
     * queued, in flight, or finished — returns 409. The release sweeper runs continuously, so a
     * cancellation sent within about a minute of the scheduled instant can lose that race and be
     * refused; cancel with time to spare.
     *
     * **One message per call.** A send to many recipients, or on several channels, becomes one
     * message per recipient × channel, each with its own id; cancel the ones you want stopped.
     * There is no bulk cancellation.
     *
     * **Cancelling is free**, and nothing was charged for the hold in the first place — a scheduled
     * message is only priced and billed at release.
     *
     * **A cancellation fires `message.cancelled`** on your webhook, exactly once, carrying the
     * `scheduled_at` that was called off so a consumer can un-record the send it was expecting.
     * Cancelling the same message again returns this same response and fires no second event.
     * `Idempotency-Key` is honoured.
     *
     * A cancelled message cannot be resent — send a new one.
     *
     * The response is the message itself, in the same shape `GET /v3/messages/{id}` returns, so the
     * `status` you read back is the one now stored on the row, and `scheduled_at` is the time it
     * would have gone out. `GET /v3/messages/{id}` keeps reporting both afterwards.
     *
     * `events` is the message lifecycle as it stood immediately before the cancellation: the
     * CANCELLED entry is written asynchronously and lands a moment later, so read `status` for the
     * outcome. If you need the entry itself, re-fetch the message after a few seconds — `GET
     * /v3/messages/{id}` is cached briefly, so an immediate re-fetch can still show the
     * pre-cancellation state.
     */
    fun cancel(id: String, params: MessageCancelParams): ApiResponseOfCancelledMessage =
        cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: MessageCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfCancelledMessage = cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(params: MessageCancelParams): ApiResponseOfCancelledMessage =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: MessageCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfCancelledMessage

    /**
     * Resends a message you already sent, on the same message id, without rebuilding the request.
     * The typical use is recovering a BLOCKED message — for example one refused for insufficient
     * balance — after the account has been topped up.
     *
     * **A resend bills again.** Each accepted resend is a new delivery attempt and records a new
     * charge against the same message id; a client that resends on every failure is charged on
     * every loop.
     *
     * **Every policy runs again.** The resend goes back through the full send pipeline — consent,
     * balance, KYC and channel quota, template approval, quiet hours and channel health — so it can
     * land on BLOCKED, FILTERED or SCHEDULED again rather than being sent, exactly as a fresh send
     * would. Status webhooks (message.sent, message.blocked, message.filtered, message.failed) fire
     * again for the same message id, so consumers keyed on the id will see repeated transitions.
     *
     * **What can be resent.** A message in a terminal state — DELIVERED, FAILED, READ or BLOCKED —
     * or one stuck at SENT for more than 15 minutes. A FILTERED message can never be resent: the
     * recipient opted out or a routing rule refused the send. A message still in flight (QUEUED,
     * PROCESSED, ROUTED), held for quiet hours (SCHEDULED), or SENT less than 15 minutes ago
     * returns 409. Two concurrent resends of one id are serialised: one is accepted, the other
     * gets 409.
     *
     * The resend keeps the channel the message was originally requested on; the channel cannot be
     * changed on a resend — send a new message instead. `Idempotency-Key` is honoured, so a retried
     * request replays the first accepted response instead of resending twice.
     *
     * The response has the same shape as `POST /v3/messages`: `recipients` has a single entry whose
     * `message_id` is the id you resent.
     */
    fun resend(id: String, params: MessageResendParams): MessageSendResponse =
        resend(id, params, RequestOptions.none())

    /** @see resend */
    fun resend(
        id: String,
        params: MessageResendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageSendResponse = resend(params.toBuilder().id(id).build(), requestOptions)

    /** @see resend */
    fun resend(params: MessageResendParams): MessageSendResponse =
        resend(params, RequestOptions.none())

    /** @see resend */
    fun resend(
        params: MessageResendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageSendResponse

    /**
     * Retrieves the activity log for a specific message. Activities track the message lifecycle
     * including acceptance, processing, sending, delivery, and any errors. A SCHEDULED entry
     * carries scheduled_at, the release instant in UTC as it stood at that moment. Other entries
     * have no scheduled_at key.
     */
    fun retrieveActivities(id: String): ApiResponseOfMessageActivities =
        retrieveActivities(id, MessageRetrieveActivitiesParams.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfMessageActivities =
        retrieveActivities(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
    ): ApiResponseOfMessageActivities = retrieveActivities(id, params, RequestOptions.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        params: MessageRetrieveActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfMessageActivities

    /** @see retrieveActivities */
    fun retrieveActivities(
        params: MessageRetrieveActivitiesParams
    ): ApiResponseOfMessageActivities = retrieveActivities(params, RequestOptions.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        requestOptions: RequestOptions,
    ): ApiResponseOfMessageActivities =
        retrieveActivities(id, MessageRetrieveActivitiesParams.none(), requestOptions)

    /**
     * Retrieves the current status and details of a message by ID. Includes delivery status,
     * timestamps, and error information if applicable. A message that is or was held for a later
     * time (a send you scheduled with scheduled_at, a quiet-hours hold, or a message you cancelled
     * while it was held) is returned as a ScheduledMessageResponse: the same fields plus
     * scheduled_at, the instant it is held for in UTC — or, on a CANCELLED message, the instant
     * that was called off. A message sent immediately has no scheduled_at key.
     */
    fun retrieveStatus(id: String): ApiResponseOfMessage =
        retrieveStatus(id, MessageRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfMessage = retrieveStatus(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
    ): ApiResponseOfMessage = retrieveStatus(id, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MessageRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfMessage

    /** @see retrieveStatus */
    fun retrieveStatus(params: MessageRetrieveStatusParams): ApiResponseOfMessage =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(id: String, requestOptions: RequestOptions): ApiResponseOfMessage =
        retrieveStatus(id, MessageRetrieveStatusParams.none(), requestOptions)

    /**
     * Sends a message to one or more recipients using a template. Supports multi-channel broadcast
     * — when multiple channels are specified (e.g. ["sms", "whatsapp"]), a separate message is
     * created for each (recipient, channel) pair. To choose which of your own numbers a send goes
     * out from, use 'channels': {"sms": [{"from": ["+12125550000", "+14155550000"]}]}. Each channel
     * holds a list of entries, each with 'from' and optionally 'country' and 'strategy'; 'country'
     * and 'strategy' are stored but not acted on yet, so every entry's numbers apply to every
     * recipient on that channel. Every number listed must be an active sender on your account. Like
     * the other account-level preconditions below, that is checked per message rather than when the
     * request is received: the request is still accepted with 202, and each affected message is
     * reported as BLOCKED with error code BUSINESS_029 on GET /messages/{id} and the
     * message.blocked webhook. Each channel's numbers restrict which numbers that channel may use;
     * it does not choose channels — 'channel' does, and the two can be combined. With 'channel'
     * left at auto-detect, a recipient best served by a channel you listed no numbers for still
     * goes out on it. Where several of the listed numbers could serve a recipient, routing prefers
     * the one whose area code matches theirs. Keys: sms, whatsapp, rcs, mms. Returns immediately
     * with per-recipient message IDs for async tracking via webhooks or the GET /messages/{id}
     * endpoint. Sends gated before any delivery attempt do not reject the request — an
     * account-level precondition such as insufficient balance, a template not approved for sending,
     * or free-form content with no open conversation with the contact. The send is accepted with
     * 202 and the affected messages are reported as BLOCKED on GET /messages/{id} and the
     * message.blocked webhook. To send later, set scheduled_at (ISO-8601 with an explicit UTC
     * offset; a value without one is rejected) between 1 minute and 30 days ahead: the response is
     * a ScheduledSendMessageResponse (the same fields plus scheduled_at; status is still QUEUED),
     * each message then moves to SCHEDULED, is held and released at that time (within a few
     * minutes), and a message.scheduled webhook fires once it is held. Balance and template
     * approval are evaluated at release, not at acceptance. Quiet hours are not checked when the
     * request is accepted: if the time falls inside a legally protected quiet-hours window for a
     * recipient, that message is moved to the next allowed time at release and a second
     * message.scheduled webhook reports the new scheduled_at. An account may hold at most 1,000,000
     * scheduled messages at once: a message scheduled past that is reported as BLOCKED (LIMIT_001)
     * instead of being held.
     */
    fun send(): MessageSendResponse = send(MessageSendParams.none())

    /** @see send */
    fun send(
        params: MessageSendParams = MessageSendParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageSendResponse

    /** @see send */
    fun send(params: MessageSendParams = MessageSendParams.none()): MessageSendResponse =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(requestOptions: RequestOptions): MessageSendResponse =
        send(MessageSendParams.none(), requestOptions)

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/messages/{id}/cancel`, but is otherwise the
         * same as [MessageService.cancel].
         */
        @MustBeClosed
        fun cancel(
            id: String,
            params: MessageCancelParams,
        ): HttpResponseFor<ApiResponseOfCancelledMessage> =
            cancel(id, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            params: MessageCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfCancelledMessage> =
            cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: MessageCancelParams): HttpResponseFor<ApiResponseOfCancelledMessage> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: MessageCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfCancelledMessage>

        /**
         * Returns a raw HTTP response for `post /v3/messages/{id}/resend`, but is otherwise the
         * same as [MessageService.resend].
         */
        @MustBeClosed
        fun resend(id: String, params: MessageResendParams): HttpResponseFor<MessageSendResponse> =
            resend(id, params, RequestOptions.none())

        /** @see resend */
        @MustBeClosed
        fun resend(
            id: String,
            params: MessageResendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageSendResponse> =
            resend(params.toBuilder().id(id).build(), requestOptions)

        /** @see resend */
        @MustBeClosed
        fun resend(params: MessageResendParams): HttpResponseFor<MessageSendResponse> =
            resend(params, RequestOptions.none())

        /** @see resend */
        @MustBeClosed
        fun resend(
            params: MessageResendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageSendResponse>

        /**
         * Returns a raw HTTP response for `get /v3/messages/{id}/activities`, but is otherwise the
         * same as [MessageService.retrieveActivities].
         */
        @MustBeClosed
        fun retrieveActivities(id: String): HttpResponseFor<ApiResponseOfMessageActivities> =
            retrieveActivities(id, MessageRetrieveActivitiesParams.none())

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            id: String,
            params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfMessageActivities> =
            retrieveActivities(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            id: String,
            params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
        ): HttpResponseFor<ApiResponseOfMessageActivities> =
            retrieveActivities(id, params, RequestOptions.none())

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            params: MessageRetrieveActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfMessageActivities>

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            params: MessageRetrieveActivitiesParams
        ): HttpResponseFor<ApiResponseOfMessageActivities> =
            retrieveActivities(params, RequestOptions.none())

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfMessageActivities> =
            retrieveActivities(id, MessageRetrieveActivitiesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/messages/{id}`, but is otherwise the same as
         * [MessageService.retrieveStatus].
         */
        @MustBeClosed
        fun retrieveStatus(id: String): HttpResponseFor<ApiResponseOfMessage> =
            retrieveStatus(id, MessageRetrieveStatusParams.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            id: String,
            params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfMessage> =
            retrieveStatus(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            id: String,
            params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
        ): HttpResponseFor<ApiResponseOfMessage> = retrieveStatus(id, params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: MessageRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfMessage>

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: MessageRetrieveStatusParams
        ): HttpResponseFor<ApiResponseOfMessage> = retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfMessage> =
            retrieveStatus(id, MessageRetrieveStatusParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/messages`, but is otherwise the same as
         * [MessageService.send].
         */
        @MustBeClosed
        fun send(): HttpResponseFor<MessageSendResponse> = send(MessageSendParams.none())

        /** @see send */
        @MustBeClosed
        fun send(
            params: MessageSendParams = MessageSendParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageSendResponse>

        /** @see send */
        @MustBeClosed
        fun send(
            params: MessageSendParams = MessageSendParams.none()
        ): HttpResponseFor<MessageSendResponse> = send(params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(requestOptions: RequestOptions): HttpResponseFor<MessageSendResponse> =
            send(MessageSendParams.none(), requestOptions)
    }
}
