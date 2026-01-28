// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.messages.MessageRetrieveParams
import com.sent_dm.api.models.messages.MessageRetrieveResponse
import com.sent_dm.api.models.messages.MessageSendQuickMessageParams
import com.sent_dm.api.models.messages.MessageSendToContactParams
import com.sent_dm.api.models.messages.MessageSendToPhoneParams
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
     * Retrieves comprehensive details about a specific message using the message ID. Returns
     * complete message data including delivery status, channel information, template details,
     * contact information, and pricing. The customer ID is extracted from the authentication token
     * to ensure the message belongs to the authenticated customer.
     */
    fun retrieve(id: String): MessageRetrieveResponse = retrieve(id, MessageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
    ): MessageRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: MessageRetrieveParams): MessageRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): MessageRetrieveResponse =
        retrieve(id, MessageRetrieveParams.none(), requestOptions)

    /**
     * Sends a message to a phone number using the default template. This endpoint is rate limited
     * to 5 messages per customer per day. The customer ID is extracted from the authentication
     * token.
     */
    fun sendQuickMessage(params: MessageSendQuickMessageParams) =
        sendQuickMessage(params, RequestOptions.none())

    /** @see sendQuickMessage */
    fun sendQuickMessage(
        params: MessageSendQuickMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * Sends a message to a specific contact using a template. The message can be sent via SMS or
     * WhatsApp depending on the contact's capabilities. Optionally specify a webhook URL to receive
     * delivery status updates. The customer ID is extracted from the authentication token.
     */
    fun sendToContact(params: MessageSendToContactParams) =
        sendToContact(params, RequestOptions.none())

    /** @see sendToContact */
    fun sendToContact(
        params: MessageSendToContactParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * Sends a message to a phone number using a template. The phone number doesn't need to be a
     * pre-existing contact. The message can be sent via SMS or WhatsApp. Optionally specify a
     * webhook URL to receive delivery status updates. The customer ID is extracted from the
     * authentication token.
     */
    fun sendToPhone(params: MessageSendToPhoneParams) = sendToPhone(params, RequestOptions.none())

    /** @see sendToPhone */
    fun sendToPhone(
        params: MessageSendToPhoneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/messages/{id}`, but is otherwise the same as
         * [MessageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<MessageRetrieveResponse> =
            retrieve(id, MessageRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
        ): HttpResponseFor<MessageRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: MessageRetrieveParams): HttpResponseFor<MessageRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageRetrieveResponse> =
            retrieve(id, MessageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v2/messages/quick-message`, but is otherwise the
         * same as [MessageService.sendQuickMessage].
         */
        @MustBeClosed
        fun sendQuickMessage(params: MessageSendQuickMessageParams): HttpResponse =
            sendQuickMessage(params, RequestOptions.none())

        /** @see sendQuickMessage */
        @MustBeClosed
        fun sendQuickMessage(
            params: MessageSendQuickMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /v2/messages/contact`, but is otherwise the same as
         * [MessageService.sendToContact].
         */
        @MustBeClosed
        fun sendToContact(params: MessageSendToContactParams): HttpResponse =
            sendToContact(params, RequestOptions.none())

        /** @see sendToContact */
        @MustBeClosed
        fun sendToContact(
            params: MessageSendToContactParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /v2/messages/phone`, but is otherwise the same as
         * [MessageService.sendToPhone].
         */
        @MustBeClosed
        fun sendToPhone(params: MessageSendToPhoneParams): HttpResponse =
            sendToPhone(params, RequestOptions.none())

        /** @see sendToPhone */
        @MustBeClosed
        fun sendToPhone(
            params: MessageSendToPhoneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
