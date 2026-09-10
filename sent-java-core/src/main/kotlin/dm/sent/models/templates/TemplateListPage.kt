// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.TemplateService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see TemplateService.list */
class TemplateListPage
private constructor(
    private val service: TemplateService,
    private val params: TemplateListParams,
    private val response: TemplateListPageResponse,
) : Page<Template> {

    /**
     * Delegates to [TemplateListPageResponse], but gracefully handles missing data.
     *
     * @see TemplateListPageResponse.data
     */
    fun data(): Optional<TemplateListPageResponse.Data> = response._data().getOptional("data")

    override fun items(): List<Template> = response.templates().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): TemplateListParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): TemplateListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Template> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TemplateListParams = params

    /** The response that this page was parsed from. */
    fun response(): TemplateListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TemplateListPage].
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

    /** A builder for [TemplateListPage]. */
    class Builder internal constructor() {

        private var service: TemplateService? = null
        private var params: TemplateListParams? = null
        private var response: TemplateListPageResponse? = null

        @JvmSynthetic
        internal fun from(templateListPage: TemplateListPage) = apply {
            service = templateListPage.service
            params = templateListPage.params
            response = templateListPage.response
        }

        fun service(service: TemplateService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TemplateListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TemplateListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TemplateListPage].
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
        fun build(): TemplateListPage =
            TemplateListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TemplateListPage{service=$service, params=$params, response=$response}"
}
