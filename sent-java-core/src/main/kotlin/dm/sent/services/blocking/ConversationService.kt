// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListMessagesResponse
import dm.sent.models.conversations.ConversationListParams
import dm.sent.models.conversations.ConversationListResponse
import java.util.function.Consumer

/**
 * Inbound and outbound messages, grouped by the person they are with.
 *
 * A conversation is the thread for one contact across every channel — a reply by SMS and one by
 * WhatsApp belong to the same conversation, because they are the same person talking to you.
 *
 * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
 */
interface ConversationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ConversationService

    /**
     * Retrieves a paginated list of the authenticated customer's messages across all conversations,
     * ordered by created date (most recent first).
     */
    fun list(params: ConversationListParams): ConversationListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ConversationListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListResponse

    /**
     * Retrieves a paginated list of the messages in a single conversation (scoped to the
     * authenticated customer), ordered by created date (most recent first).
     */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams,
    ): ConversationListMessagesResponse = listMessages(id, params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListMessagesResponse =
        listMessages(params.toBuilder().id(id).build(), requestOptions)

    /** @see listMessages */
    fun listMessages(params: ConversationListMessagesParams): ConversationListMessagesResponse =
        listMessages(params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListMessagesResponse

    /**
     * A view of [ConversationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ConversationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/conversations`, but is otherwise the same as
         * [ConversationService.list].
         */
        @MustBeClosed
        fun list(params: ConversationListParams): HttpResponseFor<ConversationListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ConversationListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListResponse>

        /**
         * Returns a raw HTTP response for `get /v3/conversations/{id}`, but is otherwise the same
         * as [ConversationService.listMessages].
         */
        @MustBeClosed
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams,
        ): HttpResponseFor<ConversationListMessagesResponse> =
            listMessages(id, params, RequestOptions.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListMessagesResponse> =
            listMessages(params.toBuilder().id(id).build(), requestOptions)

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            params: ConversationListMessagesParams
        ): HttpResponseFor<ConversationListMessagesResponse> =
            listMessages(params, RequestOptions.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListMessagesResponse>
    }
}
