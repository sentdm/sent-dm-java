// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.SenderProfileService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see SenderProfileService.list */
class SenderProfileListPage
private constructor(
    private val service: SenderProfileService,
    private val params: SenderProfileListParams,
    private val response: ApiResponseOfSenderProfilesList,
) : Page<SenderProfile> {

    /**
     * Delegates to [ApiResponseOfSenderProfilesList], but gracefully handles missing data.
     *
     * @see ApiResponseOfSenderProfilesList.data
     */
    fun data(): Optional<SenderProfilesList> = response._data().getOptional("data")

    override fun items(): List<SenderProfile> = response.senderProfiles().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): SenderProfileListParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): SenderProfileListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<SenderProfile> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SenderProfileListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfSenderProfilesList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SenderProfileListPage].
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

    /** A builder for [SenderProfileListPage]. */
    class Builder internal constructor() {

        private var service: SenderProfileService? = null
        private var params: SenderProfileListParams? = null
        private var response: ApiResponseOfSenderProfilesList? = null

        @JvmSynthetic
        internal fun from(senderProfileListPage: SenderProfileListPage) = apply {
            service = senderProfileListPage.service
            params = senderProfileListPage.params
            response = senderProfileListPage.response
        }

        fun service(service: SenderProfileService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SenderProfileListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfSenderProfilesList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SenderProfileListPage].
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
        fun build(): SenderProfileListPage =
            SenderProfileListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfileListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "SenderProfileListPage{service=$service, params=$params, response=$response}"
}
