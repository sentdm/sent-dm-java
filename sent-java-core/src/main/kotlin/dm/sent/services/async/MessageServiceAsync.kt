// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.messages.MessageRetrieveActivitiesParams
import dm.sent.models.messages.MessageRetrieveActivitiesResponse
import dm.sent.models.messages.MessageRetrieveStatusParams
import dm.sent.models.messages.MessageRetrieveStatusResponse
import dm.sent.models.messages.MessageSendParams
import dm.sent.models.messages.MessageSendResponse
import java.util.concurrent.CompletableFuture
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
 */
interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync

    /**
     * Retrieves the activity log for a specific message. Activities track the message lifecycle
     * including acceptance, processing, sending, delivery, and any errors.
     */
    fun retrieveActivities(id: String): CompletableFuture<MessageRetrieveActivitiesResponse> =
        retrieveActivities(id, MessageRetrieveActivitiesParams.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageRetrieveActivitiesResponse> =
        retrieveActivities(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
    ): CompletableFuture<MessageRetrieveActivitiesResponse> =
        retrieveActivities(id, params, RequestOptions.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        params: MessageRetrieveActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageRetrieveActivitiesResponse>

    /** @see retrieveActivities */
    fun retrieveActivities(
        params: MessageRetrieveActivitiesParams
    ): CompletableFuture<MessageRetrieveActivitiesResponse> =
        retrieveActivities(params, RequestOptions.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageRetrieveActivitiesResponse> =
        retrieveActivities(id, MessageRetrieveActivitiesParams.none(), requestOptions)

    /**
     * Retrieves the current status and details of a message by ID. Includes delivery status,
     * timestamps, and error information if applicable.
     */
    fun retrieveStatus(id: String): CompletableFuture<MessageRetrieveStatusResponse> =
        retrieveStatus(id, MessageRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageRetrieveStatusResponse> =
        retrieveStatus(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
    ): CompletableFuture<MessageRetrieveStatusResponse> =
        retrieveStatus(id, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MessageRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageRetrieveStatusResponse>

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MessageRetrieveStatusParams
    ): CompletableFuture<MessageRetrieveStatusResponse> =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageRetrieveStatusResponse> =
        retrieveStatus(id, MessageRetrieveStatusParams.none(), requestOptions)

    /**
     * Sends a message to one or more recipients using a template. Supports multi-channel broadcast
     * — when multiple channels are specified (e.g. ["sms", "whatsapp"]), a separate message is
     * created for each (recipient, channel) pair. Returns immediately with per-recipient message
     * IDs for async tracking via webhooks or the GET /messages/{id} endpoint. Sends gated before
     * any delivery attempt do not reject the request — an account-level precondition such as
     * insufficient balance, a template not approved for sending, or free-form content with no open
     * conversation with the contact. The send is accepted with 202 and the affected messages are
     * reported as BLOCKED on GET /messages/{id} and the message.blocked webhook.
     */
    fun send(): CompletableFuture<MessageSendResponse> = send(MessageSendParams.none())

    /** @see send */
    fun send(
        params: MessageSendParams = MessageSendParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageSendResponse>

    /** @see send */
    fun send(
        params: MessageSendParams = MessageSendParams.none()
    ): CompletableFuture<MessageSendResponse> = send(params, RequestOptions.none())

    /** @see send */
    fun send(requestOptions: RequestOptions): CompletableFuture<MessageSendResponse> =
        send(MessageSendParams.none(), requestOptions)

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/messages/{id}/activities`, but is otherwise the
         * same as [MessageServiceAsync.retrieveActivities].
         */
        fun retrieveActivities(
            id: String
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>> =
            retrieveActivities(id, MessageRetrieveActivitiesParams.none())

        /** @see retrieveActivities */
        fun retrieveActivities(
            id: String,
            params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>> =
            retrieveActivities(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveActivities */
        fun retrieveActivities(
            id: String,
            params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>> =
            retrieveActivities(id, params, RequestOptions.none())

        /** @see retrieveActivities */
        fun retrieveActivities(
            params: MessageRetrieveActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>>

        /** @see retrieveActivities */
        fun retrieveActivities(
            params: MessageRetrieveActivitiesParams
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>> =
            retrieveActivities(params, RequestOptions.none())

        /** @see retrieveActivities */
        fun retrieveActivities(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>> =
            retrieveActivities(id, MessageRetrieveActivitiesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/messages/{id}`, but is otherwise the same as
         * [MessageServiceAsync.retrieveStatus].
         */
        fun retrieveStatus(
            id: String
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>> =
            retrieveStatus(id, MessageRetrieveStatusParams.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            id: String,
            params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>> =
            retrieveStatus(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveStatus */
        fun retrieveStatus(
            id: String,
            params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>> =
            retrieveStatus(id, params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: MessageRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>>

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: MessageRetrieveStatusParams
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>> =
            retrieveStatus(id, MessageRetrieveStatusParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/messages`, but is otherwise the same as
         * [MessageServiceAsync.send].
         */
        fun send(): CompletableFuture<HttpResponseFor<MessageSendResponse>> =
            send(MessageSendParams.none())

        /** @see send */
        fun send(
            params: MessageSendParams = MessageSendParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageSendResponse>>

        /** @see send */
        fun send(
            params: MessageSendParams = MessageSendParams.none()
        ): CompletableFuture<HttpResponseFor<MessageSendResponse>> =
            send(params, RequestOptions.none())

        /** @see send */
        fun send(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MessageSendResponse>> =
            send(MessageSendParams.none(), requestOptions)
    }
}
