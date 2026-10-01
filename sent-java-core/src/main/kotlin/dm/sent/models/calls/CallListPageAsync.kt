// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import dm.sent.core.AutoPagerAsync
import dm.sent.core.PageAsync
import dm.sent.core.checkRequired
import dm.sent.services.async.CallServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see CallServiceAsync.list */
class CallListPageAsync
private constructor(
    private val service: CallServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CallListParams,
    private val response: ApiResponseOfCallsList,
) : PageAsync<Call> {

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

    override fun nextPage(): CompletableFuture<CallListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Call> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CallListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiResponseOfCallsList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CallListPageAsync].
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

    /** A builder for [CallListPageAsync]. */
    class Builder internal constructor() {

        private var service: CallServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CallListParams? = null
        private var response: ApiResponseOfCallsList? = null

        @JvmSynthetic
        internal fun from(callListPageAsync: CallListPageAsync) = apply {
            service = callListPageAsync.service
            streamHandlerExecutor = callListPageAsync.streamHandlerExecutor
            params = callListPageAsync.params
            response = callListPageAsync.response
        }

        fun service(service: CallServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CallListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiResponseOfCallsList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CallListPageAsync].
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
        fun build(): CallListPageAsync =
            CallListPageAsync(
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

        return other is CallListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CallListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
