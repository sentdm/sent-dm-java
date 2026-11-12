// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import dm.sent.core.AutoPagerAsync
import dm.sent.core.PageAsync
import dm.sent.core.checkRequired
import dm.sent.services.async.WebhookServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see WebhookServiceAsync.listEvents */
class WebhookListEventsPageAsync
private constructor(
    private val service: WebhookServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: WebhookListEventsParams,
    private val response: ApiResponseOfWebhookEventsList,
) : PageAsync<WebhookDelivery> {

    /**
     * Delegates to [ApiResponseOfWebhookEventsList], but gracefully handles missing data.
     *
     * @see ApiResponseOfWebhookEventsList.data
     */
    fun data(): Optional<WebhookEventsList> = response._data().getOptional("data")

    override fun items(): List<WebhookDelivery> = response.events().getOrNull() ?: emptyList()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): WebhookListEventsParams {
        val pageNumber = params.page().getOrDefault(1)
        return params.toBuilder().page(pageNumber + 1).build()
    }

    override fun nextPage(): CompletableFuture<WebhookListEventsPageAsync> =
        service.listEvents(nextPageParams())

    fun autoPager(): AutoPagerAsync<WebhookDelivery> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): WebhookListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfWebhookEventsList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListEventsPageAsync].
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

    /** A builder for [WebhookListEventsPageAsync]. */
    class Builder internal constructor() {

        private var service: WebhookServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: WebhookListEventsParams? = null
        private var response: ApiResponseOfWebhookEventsList? = null

        @JvmSynthetic
        internal fun from(webhookListEventsPageAsync: WebhookListEventsPageAsync) = apply {
            service = webhookListEventsPageAsync.service
            streamHandlerExecutor = webhookListEventsPageAsync.streamHandlerExecutor
            params = webhookListEventsPageAsync.params
            response = webhookListEventsPageAsync.response
        }

        fun service(service: WebhookServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: WebhookListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfWebhookEventsList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [WebhookListEventsPageAsync].
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
        fun build(): WebhookListEventsPageAsync =
            WebhookListEventsPageAsync(
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

        return other is WebhookListEventsPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "WebhookListEventsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
