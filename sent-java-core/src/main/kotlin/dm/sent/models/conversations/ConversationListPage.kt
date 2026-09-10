// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.conversations

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.ConversationService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see ConversationService.list */
class ConversationListPage
private constructor(
    private val service: ConversationService,
    private val params: ConversationListParams,
    private val response: ApiResponseOfConversationMessagesList,
) : Page<ConversationMessagesList.Message> {

    /**
     * Delegates to [ApiResponseOfConversationMessagesList], but gracefully handles missing data.
     *
     * @see ApiResponseOfConversationMessagesList.data
     */
    fun data(): Optional<ConversationMessagesList> = response._data().getOptional("data")

    override fun items(): List<ConversationMessagesList.Message> =
        response.messages().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ConversationListParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): ConversationListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ConversationMessagesList.Message> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ConversationListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfConversationMessagesList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ConversationListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationListPage]. */
    class Builder internal constructor() {

        private var service: ConversationService? = null
        private var params: ConversationListParams? = null
        private var response: ApiResponseOfConversationMessagesList? = null

        @JvmSynthetic
        internal fun from(conversationListPage: ConversationListPage) = apply {
            service = conversationListPage.service
            params = conversationListPage.params
            response = conversationListPage.response
        }

        fun service(service: ConversationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ConversationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfConversationMessagesList) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [ConversationListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationListPage =
            ConversationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ConversationListPage{service=$service, params=$params, response=$response}"
}
