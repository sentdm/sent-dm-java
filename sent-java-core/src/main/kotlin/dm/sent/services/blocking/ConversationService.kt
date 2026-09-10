// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.conversations.ConversationListMessagesPage
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListPage
import dm.sent.models.conversations.ConversationListParams
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
    fun list(): ConversationListPage = list(ConversationListParams.none())

    /** @see list */
    fun list(
        params: ConversationListParams = ConversationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListPage

    /** @see list */
    fun list(params: ConversationListParams = ConversationListParams.none()): ConversationListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ConversationListPage =
        list(ConversationListParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of the messages in a single conversation (scoped to the
     * authenticated customer), ordered by created date (most recent first).
     */
    fun listMessages(id: String): ConversationListMessagesPage =
        listMessages(id, ConversationListMessagesParams.none())

    /** @see listMessages */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListMessagesPage =
        listMessages(params.toBuilder().id(id).build(), requestOptions)

    /** @see listMessages */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
    ): ConversationListMessagesPage = listMessages(id, params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListMessagesPage

    /** @see listMessages */
    fun listMessages(params: ConversationListMessagesParams): ConversationListMessagesPage =
        listMessages(params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(id: String, requestOptions: RequestOptions): ConversationListMessagesPage =
        listMessages(id, ConversationListMessagesParams.none(), requestOptions)

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
        fun list(): HttpResponseFor<ConversationListPage> = list(ConversationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ConversationListParams = ConversationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ConversationListParams = ConversationListParams.none()
        ): HttpResponseFor<ConversationListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ConversationListPage> =
            list(ConversationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/conversations/{id}`, but is otherwise the same
         * as [ConversationService.listMessages].
         */
        @MustBeClosed
        fun listMessages(id: String): HttpResponseFor<ConversationListMessagesPage> =
            listMessages(id, ConversationListMessagesParams.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListMessagesPage> =
            listMessages(params.toBuilder().id(id).build(), requestOptions)

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
        ): HttpResponseFor<ConversationListMessagesPage> =
            listMessages(id, params, RequestOptions.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListMessagesPage>

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            params: ConversationListMessagesParams
        ): HttpResponseFor<ConversationListMessagesPage> =
            listMessages(params, RequestOptions.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationListMessagesPage> =
            listMessages(id, ConversationListMessagesParams.none(), requestOptions)
    }
}
