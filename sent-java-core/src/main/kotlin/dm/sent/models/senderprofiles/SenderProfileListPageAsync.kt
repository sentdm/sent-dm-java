// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import dm.sent.core.AutoPagerAsync
import dm.sent.core.PageAsync
import dm.sent.core.checkRequired
import dm.sent.services.async.SenderProfileServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see SenderProfileServiceAsync.list */
class SenderProfileListPageAsync
private constructor(
    private val service: SenderProfileServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: SenderProfileListParams,
    private val response: ApiResponseOfSenderProfilesList,
) : PageAsync<SenderProfile> {

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

    override fun nextPage(): CompletableFuture<SenderProfileListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<SenderProfile> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): SenderProfileListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfSenderProfilesList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SenderProfileListPageAsync].
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

    /** A builder for [SenderProfileListPageAsync]. */
    class Builder internal constructor() {

        private var service: SenderProfileServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: SenderProfileListParams? = null
        private var response: ApiResponseOfSenderProfilesList? = null

        @JvmSynthetic
        internal fun from(senderProfileListPageAsync: SenderProfileListPageAsync) = apply {
            service = senderProfileListPageAsync.service
            streamHandlerExecutor = senderProfileListPageAsync.streamHandlerExecutor
            params = senderProfileListPageAsync.params
            response = senderProfileListPageAsync.response
        }

        fun service(service: SenderProfileServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: SenderProfileListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfSenderProfilesList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SenderProfileListPageAsync].
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
        fun build(): SenderProfileListPageAsync =
            SenderProfileListPageAsync(
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

        return other is SenderProfileListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "SenderProfileListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
