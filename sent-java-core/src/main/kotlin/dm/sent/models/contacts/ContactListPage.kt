// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.ContactService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see ContactService.list */
class ContactListPage
private constructor(
    private val service: ContactService,
    private val params: ContactListParams,
    private val response: ContactListPageResponse,
) : Page<ContactResponse> {

    /**
     * Delegates to [ContactListPageResponse], but gracefully handles missing data.
     *
     * @see ContactListPageResponse.data
     */
    fun data(): Optional<ContactListPageResponse.Data> = response._data().getOptional("data")

    override fun items(): List<ContactResponse> = response.contacts().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ContactListParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): ContactListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ContactResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ContactListParams = params

    /** The response that this page was parsed from. */
    fun response(): ContactListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContactListPage].
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

    /** A builder for [ContactListPage]. */
    class Builder internal constructor() {

        private var service: ContactService? = null
        private var params: ContactListParams? = null
        private var response: ContactListPageResponse? = null

        @JvmSynthetic
        internal fun from(contactListPage: ContactListPage) = apply {
            service = contactListPage.service
            params = contactListPage.params
            response = contactListPage.response
        }

        fun service(service: ContactService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ContactListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ContactListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ContactListPage].
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
        fun build(): ContactListPage =
            ContactListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ContactListPage{service=$service, params=$params, response=$response}"
}
