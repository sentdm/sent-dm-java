// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.conversations

import dm.sent.core.AutoPagerAsync
import dm.sent.core.PageAsync
import dm.sent.core.checkRequired
import dm.sent.services.async.ConversationServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see ConversationServiceAsync.listMessages */
class ConversationListMessagesPageAsync
private constructor(
    private val service: ConversationServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ConversationListMessagesParams,
    private val response: ApiResponseOfConversationMessagesList,
) : PageAsync<ConversationMessagesList.Message> {

    /**
     * Delegates to [ApiResponseOfConversationMessagesList], but gracefully handles missing data.
     *
     * @see ApiResponseOfConversationMessagesList.data
     */
    fun data(): Optional<ConversationMessagesList> = response._data().getOptional("data")

    override fun items(): List<ConversationMessagesList.Message> =
        response.messages().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ConversationListMessagesParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): CompletableFuture<ConversationListMessagesPageAsync> =
        service.listMessages(nextPageParams())

    fun autoPager(): AutoPagerAsync<ConversationMessagesList.Message> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ConversationListMessagesParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfConversationMessagesList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ConversationListMessagesPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationListMessagesPageAsync]. */
    class Builder internal constructor() {

        private var service: ConversationServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ConversationListMessagesParams? = null
        private var response: ApiResponseOfConversationMessagesList? = null

        @JvmSynthetic
        internal fun from(conversationListMessagesPageAsync: ConversationListMessagesPageAsync) =
            apply {
                service = conversationListMessagesPageAsync.service
                streamHandlerExecutor = conversationListMessagesPageAsync.streamHandlerExecutor
                params = conversationListMessagesPageAsync.params
                response = conversationListMessagesPageAsync.response
            }

        fun service(service: ConversationServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ConversationListMessagesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfConversationMessagesList) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [ConversationListMessagesPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationListMessagesPageAsync =
            ConversationListMessagesPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationListMessagesPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ConversationListMessagesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
