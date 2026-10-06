// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.calls.ApiResponseOfCall
import dm.sent.models.calls.ApiResponseOfCallRecordings
import dm.sent.models.calls.CallHangupParams
import dm.sent.models.calls.CallListPageAsync
import dm.sent.models.calls.CallListParams
import dm.sent.models.calls.CallListRecordingsParams
import dm.sent.models.calls.CallRecordParams
import dm.sent.models.calls.CallRetrieveParams
import dm.sent.services.async.calls.ParticipantServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Phone calls from the numbers you hold, driven by your own callback URL.
 *
 * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to do
 * with each call on it, and `POST /v3/channels/voice/tokens` mints a short-lived token that lets a
 * user of your app place and receive calls as that number. When a call arrives or a caller presses
 * a key, a signed question is POSTed to the callback URL and the answer decides the call; `POST
 * /v3/channels/voice/{number}/test` checks the URL answers the way we need before a real call
 * reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The
 * call events themselves (`call.completed` and the rest) arrive through your webhooks.
 *
 * Every call is a record under `/v3/calls`: read it, list its recordings once one is ready, hang it
 * up, start or stop recording, and add, mute or remove conference participants while it is live. A
 * leg to a phone number runs for at most what your balance affords at the destination's rate.
 */
interface CallServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallServiceAsync

    /**
     * Phone calls from the numbers you hold, driven by your own callback URL.
     *
     * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to
     * do with each call on it, and `POST /v3/channels/voice/tokens` mints a short-lived token that
     * lets a user of your app place and receive calls as that number. When a call arrives or a
     * caller presses a key, a signed question is POSTed to the callback URL and the answer decides
     * the call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way we need
     * before a real call reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces
     * the signing secret. The call events themselves (`call.completed` and the rest) arrive through
     * your webhooks.
     *
     * Every call is a record under `/v3/calls`: read it, list its recordings once one is ready,
     * hang it up, start or stop recording, and add, mute or remove conference participants while it
     * is live. A leg to a phone number runs for at most what your balance affords at the
     * destination's rate.
     */
    fun participants(): ParticipantServiceAsync

    /**
     * Retrieves one of your calls by id: the parties, the owning number, the current status with
     * its failure reason, duration, price, recording availability, and a timeline of when the call
     * entered each status.
     */
    fun retrieve(id: String): CompletableFuture<ApiResponseOfCall> =
        retrieve(id, CallRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CallRetrieveParams = CallRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfCall> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CallRetrieveParams = CallRetrieveParams.none(),
    ): CompletableFuture<ApiResponseOfCall> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CallRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfCall>

    /** @see retrieve */
    fun retrieve(params: CallRetrieveParams): CompletableFuture<ApiResponseOfCall> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<ApiResponseOfCall> =
        retrieve(id, CallRetrieveParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of your calls, most recent first. Filter by direction, status, the
     * owning number, and the time the call started (from and to are inclusive). Use the call
     * webhooks for real-time updates; this list is for looking calls up afterwards.
     */
    fun list(): CompletableFuture<CallListPageAsync> = list(CallListParams.none())

    /** @see list */
    fun list(
        params: CallListParams = CallListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CallListPageAsync>

    /** @see list */
    fun list(params: CallListParams = CallListParams.none()): CompletableFuture<CallListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<CallListPageAsync> =
        list(CallListParams.none(), requestOptions)

    /**
     * Ends one of your live calls. The call then ends the way any other call does once the
     * disconnect is reported: an answered call as COMPLETED with call.completed, a call still
     * ringing as NO_ANSWER, REJECTED or FAILED with call.failed. A call that has already ended
     * answers 409, and so does a call with no phone leg, such as one between two app users.
     */
    fun hangup(id: String, params: CallHangupParams): CompletableFuture<Void?> =
        hangup(id, params, RequestOptions.none())

    /** @see hangup */
    fun hangup(
        id: String,
        params: CallHangupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = hangup(params.toBuilder().id(id).build(), requestOptions)

    /** @see hangup */
    fun hangup(params: CallHangupParams): CompletableFuture<Void?> =
        hangup(params, RequestOptions.none())

    /** @see hangup */
    fun hangup(
        params: CallHangupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * Returns pre-signed links to the recordings of one of your calls, each valid until its
     * url_expires_at. A recording appears once the call was recorded, by a connect answer with
     * record set, a startRecording instruction or the recordings command, and the
     * call.recording_ready webhook has been sent; until then, and for a call that was never
     * recorded, the list is empty. A call recorded more than once lists every recording, oldest
     * first, each under the recording_id its call.recording_ready webhook carried.
     */
    fun listRecordings(id: String): CompletableFuture<ApiResponseOfCallRecordings> =
        listRecordings(id, CallListRecordingsParams.none())

    /** @see listRecordings */
    fun listRecordings(
        id: String,
        params: CallListRecordingsParams = CallListRecordingsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfCallRecordings> =
        listRecordings(params.toBuilder().id(id).build(), requestOptions)

    /** @see listRecordings */
    fun listRecordings(
        id: String,
        params: CallListRecordingsParams = CallListRecordingsParams.none(),
    ): CompletableFuture<ApiResponseOfCallRecordings> =
        listRecordings(id, params, RequestOptions.none())

    /** @see listRecordings */
    fun listRecordings(
        params: CallListRecordingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfCallRecordings>

    /** @see listRecordings */
    fun listRecordings(
        params: CallListRecordingsParams
    ): CompletableFuture<ApiResponseOfCallRecordings> =
        listRecordings(params, RequestOptions.none())

    /** @see listRecordings */
    fun listRecordings(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfCallRecordings> =
        listRecordings(id, CallListRecordingsParams.none(), requestOptions)

    /**
     * Starts or stops recording one of your live calls. Use start to begin recording mid-call, or
     * stop to end a recording, whether it was started here or by a connect answer with record set.
     * A call that has already ended answers 409, and so does a call with no phone leg, such as one
     * between two app users, which can't be recorded.
     */
    fun record(id: String): CompletableFuture<Void?> = record(id, CallRecordParams.none())

    /** @see record */
    fun record(
        id: String,
        params: CallRecordParams = CallRecordParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = record(params.toBuilder().id(id).build(), requestOptions)

    /** @see record */
    fun record(
        id: String,
        params: CallRecordParams = CallRecordParams.none(),
    ): CompletableFuture<Void?> = record(id, params, RequestOptions.none())

    /** @see record */
    fun record(
        params: CallRecordParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see record */
    fun record(params: CallRecordParams): CompletableFuture<Void?> =
        record(params, RequestOptions.none())

    /** @see record */
    fun record(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        record(id, CallRecordParams.none(), requestOptions)

    /** A view of [CallServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallServiceAsync.WithRawResponse

        /**
         * Phone calls from the numbers you hold, driven by your own callback URL.
         *
         * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks
         * what to do with each call on it, and `POST /v3/channels/voice/tokens` mints a short-lived
         * token that lets a user of your app place and receive calls as that number. When a call
         * arrives or a caller presses a key, a signed question is POSTed to the callback URL and
         * the answer decides the call; `POST /v3/channels/voice/{number}/test` checks the URL
         * answers the way we need before a real call reaches it, and `POST
         * /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The call events
         * themselves (`call.completed` and the rest) arrive through your webhooks.
         *
         * Every call is a record under `/v3/calls`: read it, list its recordings once one is ready,
         * hang it up, start or stop recording, and add, mute or remove conference participants
         * while it is live. A leg to a phone number runs for at most what your balance affords at
         * the destination's rate.
         */
        fun participants(): ParticipantServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/calls/{id}`, but is otherwise the same as
         * [CallServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ApiResponseOfCall>> =
            retrieve(id, CallRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: CallRetrieveParams = CallRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCall>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: CallRetrieveParams = CallRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCall>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: CallRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCall>>

        /** @see retrieve */
        fun retrieve(
            params: CallRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCall>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCall>> =
            retrieve(id, CallRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/calls`, but is otherwise the same as
         * [CallServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<CallListPageAsync>> =
            list(CallListParams.none())

        /** @see list */
        fun list(
            params: CallListParams = CallListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CallListPageAsync>>

        /** @see list */
        fun list(
            params: CallListParams = CallListParams.none()
        ): CompletableFuture<HttpResponseFor<CallListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CallListPageAsync>> =
            list(CallListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/calls/{id}/hangup`, but is otherwise the same
         * as [CallServiceAsync.hangup].
         */
        fun hangup(id: String, params: CallHangupParams): CompletableFuture<HttpResponse> =
            hangup(id, params, RequestOptions.none())

        /** @see hangup */
        fun hangup(
            id: String,
            params: CallHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            hangup(params.toBuilder().id(id).build(), requestOptions)

        /** @see hangup */
        fun hangup(params: CallHangupParams): CompletableFuture<HttpResponse> =
            hangup(params, RequestOptions.none())

        /** @see hangup */
        fun hangup(
            params: CallHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `get /v3/calls/{id}/recordings`, but is otherwise the
         * same as [CallServiceAsync.listRecordings].
         */
        fun listRecordings(
            id: String
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>> =
            listRecordings(id, CallListRecordingsParams.none())

        /** @see listRecordings */
        fun listRecordings(
            id: String,
            params: CallListRecordingsParams = CallListRecordingsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>> =
            listRecordings(params.toBuilder().id(id).build(), requestOptions)

        /** @see listRecordings */
        fun listRecordings(
            id: String,
            params: CallListRecordingsParams = CallListRecordingsParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>> =
            listRecordings(id, params, RequestOptions.none())

        /** @see listRecordings */
        fun listRecordings(
            params: CallListRecordingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>>

        /** @see listRecordings */
        fun listRecordings(
            params: CallListRecordingsParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>> =
            listRecordings(params, RequestOptions.none())

        /** @see listRecordings */
        fun listRecordings(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>> =
            listRecordings(id, CallListRecordingsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/calls/{id}/recordings`, but is otherwise the
         * same as [CallServiceAsync.record].
         */
        fun record(id: String): CompletableFuture<HttpResponse> =
            record(id, CallRecordParams.none())

        /** @see record */
        fun record(
            id: String,
            params: CallRecordParams = CallRecordParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            record(params.toBuilder().id(id).build(), requestOptions)

        /** @see record */
        fun record(
            id: String,
            params: CallRecordParams = CallRecordParams.none(),
        ): CompletableFuture<HttpResponse> = record(id, params, RequestOptions.none())

        /** @see record */
        fun record(
            params: CallRecordParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see record */
        fun record(params: CallRecordParams): CompletableFuture<HttpResponse> =
            record(params, RequestOptions.none())

        /** @see record */
        fun record(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            record(id, CallRecordParams.none(), requestOptions)
    }
}
