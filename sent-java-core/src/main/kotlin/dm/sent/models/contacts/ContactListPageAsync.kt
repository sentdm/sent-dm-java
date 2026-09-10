// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.AutoPagerAsync
import dm.sent.core.PageAsync
import dm.sent.core.checkRequired
import dm.sent.services.async.ContactServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see ContactServiceAsync.list */
class ContactListPageAsync
private constructor(
    private val service: ContactServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ContactListParams,
    private val response: ContactListPageResponse,
) : PageAsync<ContactResponse> {

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

    override fun nextPage(): CompletableFuture<ContactListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ContactResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ContactListParams = params

    /** The response that this page was parsed from. */
    fun response(): ContactListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContactListPageAsync].
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

    /** A builder for [ContactListPageAsync]. */
    class Builder internal constructor() {

        private var service: ContactServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ContactListParams? = null
        private var response: ContactListPageResponse? = null

        @JvmSynthetic
        internal fun from(contactListPageAsync: ContactListPageAsync) = apply {
            service = contactListPageAsync.service
            streamHandlerExecutor = contactListPageAsync.streamHandlerExecutor
            params = contactListPageAsync.params
            response = contactListPageAsync.response
        }

        fun service(service: ContactServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ContactListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ContactListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ContactListPageAsync].
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
        fun build(): ContactListPageAsync =
            ContactListPageAsync(
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

        return other is ContactListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ContactListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
