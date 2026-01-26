// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.messages.MessageRetrieveParams
import com.sent_dm.api.models.messages.MessageRetrieveResponse
import com.sent_dm.api.models.messages.MessageSendQuickMessageParams
import com.sent_dm.api.models.messages.MessageSendToContactParams
import com.sent_dm.api.models.messages.MessageSendToPhoneParams
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
     * Retrieves comprehensive details about a specific message using the message ID. Returns
     * complete message data including delivery status, channel information, template details,
     * contact information, and pricing. The customer ID is extracted from the authentication token
     * to ensure the message belongs to the authenticated customer.
     */
    fun retrieve(
        id: String,
        params: MessageRetrieveParams,
    ): CompletableFuture<MessageRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: MessageRetrieveParams): CompletableFuture<MessageRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageRetrieveResponse>

    /**
     * Sends a message to a phone number using the default template. This endpoint is rate limited
     * to 5 messages per customer per day. The customer ID is extracted from the authentication
     * token.
     */
    fun sendQuickMessage(params: MessageSendQuickMessageParams): CompletableFuture<Void?> =
        sendQuickMessage(params, RequestOptions.none())

    /** @see sendQuickMessage */
    fun sendQuickMessage(
        params: MessageSendQuickMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * Sends a message to a specific contact using a template. The message can be sent via SMS or
     * WhatsApp depending on the contact's capabilities. Optionally specify a webhook URL to receive
     * delivery status updates. The customer ID is extracted from the authentication token.
     */
    fun sendToContact(params: MessageSendToContactParams): CompletableFuture<Void?> =
        sendToContact(params, RequestOptions.none())

    /** @see sendToContact */
    fun sendToContact(
        params: MessageSendToContactParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * Sends a message to a phone number using a template. The phone number doesn't need to be a
     * pre-existing contact. The message can be sent via SMS or WhatsApp. Optionally specify a
     * webhook URL to receive delivery status updates. The customer ID is extracted from the
     * authentication token.
     */
    fun sendToPhone(params: MessageSendToPhoneParams): CompletableFuture<Void?> =
        sendToPhone(params, RequestOptions.none())

    /** @see sendToPhone */
    fun sendToPhone(
        params: MessageSendToPhoneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

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
         * Returns a raw HTTP response for `get /v2/messages/{id}`, but is otherwise the same as
         * [MessageServiceAsync.retrieve].
         */
        fun retrieve(
            id: String,
            params: MessageRetrieveParams,
        ): CompletableFuture<HttpResponseFor<MessageRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: MessageRetrieveParams
        ): CompletableFuture<HttpResponseFor<MessageRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `post /v2/messages/quick-message`, but is otherwise the
         * same as [MessageServiceAsync.sendQuickMessage].
         */
        fun sendQuickMessage(
            params: MessageSendQuickMessageParams
        ): CompletableFuture<HttpResponse> = sendQuickMessage(params, RequestOptions.none())

        /** @see sendQuickMessage */
        fun sendQuickMessage(
            params: MessageSendQuickMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /v2/messages/contact`, but is otherwise the same as
         * [MessageServiceAsync.sendToContact].
         */
        fun sendToContact(params: MessageSendToContactParams): CompletableFuture<HttpResponse> =
            sendToContact(params, RequestOptions.none())

        /** @see sendToContact */
        fun sendToContact(
            params: MessageSendToContactParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /v2/messages/phone`, but is otherwise the same as
         * [MessageServiceAsync.sendToPhone].
         */
        fun sendToPhone(params: MessageSendToPhoneParams): CompletableFuture<HttpResponse> =
            sendToPhone(params, RequestOptions.none())

        /** @see sendToPhone */
        fun sendToPhone(
            params: MessageSendToPhoneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
