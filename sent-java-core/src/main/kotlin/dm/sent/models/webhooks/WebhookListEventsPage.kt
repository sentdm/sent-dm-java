// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import dm.sent.core.AutoPager
import dm.sent.core.Page
import dm.sent.core.checkRequired
import dm.sent.services.blocking.WebhookService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see WebhookService.listEvents */
class WebhookListEventsPage
private constructor(
    private val service: WebhookService,
    private val params: WebhookListEventsParams,
    private val response: WebhookListEventsPageResponse,
) : Page<WebhookListEventsResponse> {

    /**
     * Delegates to [WebhookListEventsPageResponse], but gracefully handles missing data.
     *
     * @see WebhookListEventsPageResponse.data
     */
    fun data(): Optional<WebhookListEventsPageResponse.Data> = response._data().getOptional("data")

    override fun items(): List<WebhookListEventsResponse> =
        response.events().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): WebhookListEventsParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): WebhookListEventsPage = service.listEvents(nextPageParams())

    fun autoPager(): AutoPager<WebhookListEventsResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): WebhookListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): WebhookListEventsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListEventsPage].
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

    /** A builder for [WebhookListEventsPage]. */
    class Builder internal constructor() {

        private var service: WebhookService? = null
        private var params: WebhookListEventsParams? = null
        private var response: WebhookListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(webhookListEventsPage: WebhookListEventsPage) = apply {
            service = webhookListEventsPage.service
            params = webhookListEventsPage.params
            response = webhookListEventsPage.response
        }

        fun service(service: WebhookService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: WebhookListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WebhookListEventsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [WebhookListEventsPage].
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
        fun build(): WebhookListEventsPage =
            WebhookListEventsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListEventsPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "WebhookListEventsPage{service=$service, params=$params, response=$response}"
}
