// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.conversations.ApiResponseOfConversationMessagesList
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListParams
import java.util.function.Consumer

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
    fun list(params: ConversationListParams): ApiResponseOfConversationMessagesList =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ConversationListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfConversationMessagesList

    /**
     * Retrieves a paginated list of the messages in a single conversation (scoped to the
     * authenticated customer), ordered by created date (most recent first).
     */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams,
    ): ApiResponseOfConversationMessagesList = listMessages(id, params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        id: String,
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfConversationMessagesList =
        listMessages(params.toBuilder().id(id).build(), requestOptions)

    /** @see listMessages */
    fun listMessages(
        params: ConversationListMessagesParams
    ): ApiResponseOfConversationMessagesList = listMessages(params, RequestOptions.none())

    /** @see listMessages */
    fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfConversationMessagesList

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
        fun list(
            params: ConversationListParams
        ): HttpResponseFor<ApiResponseOfConversationMessagesList> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ConversationListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfConversationMessagesList>

        /**
         * Returns a raw HTTP response for `get /v3/conversations/{id}`, but is otherwise the same
         * as [ConversationService.listMessages].
         */
        @MustBeClosed
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams,
        ): HttpResponseFor<ApiResponseOfConversationMessagesList> =
            listMessages(id, params, RequestOptions.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            id: String,
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfConversationMessagesList> =
            listMessages(params.toBuilder().id(id).build(), requestOptions)

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            params: ConversationListMessagesParams
        ): HttpResponseFor<ApiResponseOfConversationMessagesList> =
            listMessages(params, RequestOptions.none())

        /** @see listMessages */
        @MustBeClosed
        fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfConversationMessagesList>
    }
}
