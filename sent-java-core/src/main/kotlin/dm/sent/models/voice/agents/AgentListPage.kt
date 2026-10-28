// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.voice.AgentService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see AgentService.list */
class AgentListPage
private constructor(
    private val service: AgentService,
    private val params: AgentListParams,
    private val response: ApiResponseOfVoiceAgentsList,
) : Page<VoiceAgent> {

    /**
     * Delegates to [ApiResponseOfVoiceAgentsList], but gracefully handles missing data.
     *
     * @see ApiResponseOfVoiceAgentsList.data
     */
    fun data(): Optional<VoiceAgentsList> = response._data().getOptional("data")

    override fun items(): List<VoiceAgent> = response.agents().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AgentListParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): AgentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<VoiceAgent> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AgentListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfVoiceAgentsList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AgentListPage].
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

    /** A builder for [AgentListPage]. */
    class Builder internal constructor() {

        private var service: AgentService? = null
        private var params: AgentListParams? = null
        private var response: ApiResponseOfVoiceAgentsList? = null

        @JvmSynthetic
        internal fun from(agentListPage: AgentListPage) = apply {
            service = agentListPage.service
            params = agentListPage.params
            response = agentListPage.response
        }

        fun service(service: AgentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AgentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfVoiceAgentsList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AgentListPage].
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
        fun build(): AgentListPage =
            AgentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "AgentListPage{service=$service, params=$params, response=$response}"
}
