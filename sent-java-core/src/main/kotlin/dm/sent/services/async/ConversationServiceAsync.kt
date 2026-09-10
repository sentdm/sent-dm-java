// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.conversations.ConversationListMessagesPageAsync
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListPageAsync
import dm.sent.models.conversations.ConversationListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Inbound and outbound messages, grouped by the person they are with.
 *
 * A conversation is the thread for one contact across every channel — a reply by SMS and one by
 * WhatsApp belong to the same conversation, because they are the same person talking to you.
 *
 * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
 */
interface ConversationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ConversationServiceAsync

    /**
     * Retrieves a paginated list of the authenticated customer's messages across all conversations,
     * ordered by created date (most recent first).
     */
    fun list(): CompletableFuture<ConversationListPageAsync> = list(ConversationListParams.none())

    /** @see list */
    fun list(
        params: ConversationListParams = ConversationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationListPageAsync>

    /** @see list */
    fun list(
        params: ConversationListParams = ConversationListParams.none()
    ): CompletableFuture<ConversationListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ConversationListPageAsync> =
        list(ConversationListParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of the messages in a single conversation (scoped to the
     * authenticated customer), ordered by created date (most recent first).
     */
    fun listMessages(id: String): CompletableFuture<ConversationListMessagesPageAsync> =
        listMessages(id, ConversationListMessagesParams.none())

    /** @see listMessages */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationListMessagesPageAsync> =
        listMessages(params.toBuilder().id(id).build(), requestOptions)

    /** @see listMessages */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
    ): CompletableFuture<ConversationListMessagesPageAsync> =
        listMessages(id, params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationListMessagesPageAsync>

    /** @see listMessages */
    fun listMessages(
        params: ConversationListMessagesParams
    ): CompletableFuture<ConversationListMessagesPageAsync> =
        listMessages(params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ConversationListMessagesPageAsync> =
        listMessages(id, ConversationListMessagesParams.none(), requestOptions)

    /**
     * A view of [ConversationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ConversationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/conversations`, but is otherwise the same as
         * [ConversationServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ConversationListPageAsync>> =
            list(ConversationListParams.none())

        /** @see list */
        fun list(
            params: ConversationListParams = ConversationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationListPageAsync>>

        /** @see list */
        fun list(
            params: ConversationListParams = ConversationListParams.none()
        ): CompletableFuture<HttpResponseFor<ConversationListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ConversationListPageAsync>> =
            list(ConversationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/conversations/{id}`, but is otherwise the same
         * as [ConversationServiceAsync.listMessages].
         */
        fun listMessages(
            id: String
        ): CompletableFuture<HttpResponseFor<ConversationListMessagesPageAsync>> =
            listMessages(id, ConversationListMessagesParams.none())

        /** @see listMessages */
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationListMessagesPageAsync>> =
            listMessages(params.toBuilder().id(id).build(), requestOptions)

        /** @see listMessages */
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
        ): CompletableFuture<HttpResponseFor<ConversationListMessagesPageAsync>> =
            listMessages(id, params, RequestOptions.none())

        /** @see listMessages */
        fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationListMessagesPageAsync>>

        /** @see listMessages */
        fun listMessages(
            params: ConversationListMessagesParams
        ): CompletableFuture<HttpResponseFor<ConversationListMessagesPageAsync>> =
            listMessages(params, RequestOptions.none())

        /** @see listMessages */
        fun listMessages(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ConversationListMessagesPageAsync>> =
            listMessages(id, ConversationListMessagesParams.none(), requestOptions)
    }
}
