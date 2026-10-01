// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.CallService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see CallService.list */
class CallListPage
private constructor(
    private val service: CallService,
    private val params: CallListParams,
    private val response: ApiResponseOfCallsList,
) : Page<Call> {

    /**
     * Delegates to [ApiResponseOfCallsList], but gracefully handles missing data.
     *
     * @see ApiResponseOfCallsList.data
     */
    fun data(): Optional<CallsList> = response._data().getOptional("data")

    override fun items(): List<Call> = response.calls().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): CallListParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): CallListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Call> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CallListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfCallsList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CallListPage].
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

    /** A builder for [CallListPage]. */
    class Builder internal constructor() {

        private var service: CallService? = null
        private var params: CallListParams? = null
        private var response: ApiResponseOfCallsList? = null

        @JvmSynthetic
        internal fun from(callListPage: CallListPage) = apply {
            service = callListPage.service
            params = callListPage.params
            response = callListPage.response
        }

        fun service(service: CallService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CallListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfCallsList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CallListPage].
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
        fun build(): CallListPage =
            CallListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "CallListPage{service=$service, params=$params, response=$response}"
}
