// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.messages.MessageRetrieveActivitiesParams
import dm.sent.models.messages.MessageRetrieveActivitiesResponse
import dm.sent.models.messages.MessageRetrieveStatusParams
import dm.sent.models.messages.MessageRetrieveStatusResponse
import dm.sent.models.messages.MessageSendParams
import dm.sent.models.messages.MessageSendResponse
import java.util.function.Consumer

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
     * Retrieves the activity log for a specific message. Activities track the message lifecycle
     * including acceptance, processing, sending, delivery, and any errors.
     */
    fun retrieveActivities(id: String): MessageRetrieveActivitiesResponse =
        retrieveActivities(id, MessageRetrieveActivitiesParams.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageRetrieveActivitiesResponse =
        retrieveActivities(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
    ): MessageRetrieveActivitiesResponse = retrieveActivities(id, params, RequestOptions.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        params: MessageRetrieveActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageRetrieveActivitiesResponse

    /** @see retrieveActivities */
    fun retrieveActivities(
        params: MessageRetrieveActivitiesParams
    ): MessageRetrieveActivitiesResponse = retrieveActivities(params, RequestOptions.none())

    /** @see retrieveActivities */
    fun retrieveActivities(
        id: String,
        requestOptions: RequestOptions,
    ): MessageRetrieveActivitiesResponse =
        retrieveActivities(id, MessageRetrieveActivitiesParams.none(), requestOptions)

    /**
     * Retrieves the current status and details of a message by ID. Includes delivery status,
     * timestamps, and error information if applicable.
     */
    fun retrieveStatus(id: String): MessageRetrieveStatusResponse =
        retrieveStatus(id, MessageRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageRetrieveStatusResponse =
        retrieveStatus(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        id: String,
        params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
    ): MessageRetrieveStatusResponse = retrieveStatus(id, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MessageRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageRetrieveStatusResponse

    /** @see retrieveStatus */
    fun retrieveStatus(params: MessageRetrieveStatusParams): MessageRetrieveStatusResponse =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(id: String, requestOptions: RequestOptions): MessageRetrieveStatusResponse =
        retrieveStatus(id, MessageRetrieveStatusParams.none(), requestOptions)

    /**
     * Sends a message to one or more recipients using a template. Supports multi-channel broadcast
     * — when multiple channels are specified (e.g. ["sms", "whatsapp"]), a separate message is
     * created for each (recipient, channel) pair. Returns immediately with per-recipient message
     * IDs for async tracking via webhooks or the GET /messages/{id} endpoint.
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
         * Returns a raw HTTP response for `get /v3/messages/{id}/activities`, but is otherwise the
         * same as [MessageService.retrieveActivities].
         */
        @MustBeClosed
        fun retrieveActivities(id: String): HttpResponseFor<MessageRetrieveActivitiesResponse> =
            retrieveActivities(id, MessageRetrieveActivitiesParams.none())

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            id: String,
            params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageRetrieveActivitiesResponse> =
            retrieveActivities(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            id: String,
            params: MessageRetrieveActivitiesParams = MessageRetrieveActivitiesParams.none(),
        ): HttpResponseFor<MessageRetrieveActivitiesResponse> =
            retrieveActivities(id, params, RequestOptions.none())

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            params: MessageRetrieveActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageRetrieveActivitiesResponse>

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            params: MessageRetrieveActivitiesParams
        ): HttpResponseFor<MessageRetrieveActivitiesResponse> =
            retrieveActivities(params, RequestOptions.none())

        /** @see retrieveActivities */
        @MustBeClosed
        fun retrieveActivities(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageRetrieveActivitiesResponse> =
            retrieveActivities(id, MessageRetrieveActivitiesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/messages/{id}`, but is otherwise the same as
         * [MessageService.retrieveStatus].
         */
        @MustBeClosed
        fun retrieveStatus(id: String): HttpResponseFor<MessageRetrieveStatusResponse> =
            retrieveStatus(id, MessageRetrieveStatusParams.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            id: String,
            params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageRetrieveStatusResponse> =
            retrieveStatus(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            id: String,
            params: MessageRetrieveStatusParams = MessageRetrieveStatusParams.none(),
        ): HttpResponseFor<MessageRetrieveStatusResponse> =
            retrieveStatus(id, params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: MessageRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageRetrieveStatusResponse>

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: MessageRetrieveStatusParams
        ): HttpResponseFor<MessageRetrieveStatusResponse> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageRetrieveStatusResponse> =
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
