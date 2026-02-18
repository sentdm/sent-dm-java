// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.messages.MessageRetrieveActivitiesParams
import com.sent_dm.api.models.messages.MessageRetrieveActivitiesResponse
import com.sent_dm.api.models.messages.MessageRetrieveStatusParams
import com.sent_dm.api.models.messages.MessageRetrieveStatusResponse
import com.sent_dm.api.models.messages.MessageSendParams
import com.sent_dm.api.models.messages.MessageSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

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
     * IDs for async tracking via webhooks or the GET /messages/{id} endpoint.
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
