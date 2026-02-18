// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.services.async.BrandServiceAsync
import dm.sent.services.async.ContactServiceAsync
import dm.sent.services.async.LookupServiceAsync
import dm.sent.services.async.MeServiceAsync
import dm.sent.services.async.MessageServiceAsync
import dm.sent.services.async.ProfileServiceAsync
import dm.sent.services.async.TemplateServiceAsync
import dm.sent.services.async.UserServiceAsync
import dm.sent.services.async.WebhookServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Sent Dm REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface SentDmClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): SentDmClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClientAsync

    fun webhooks(): WebhookServiceAsync

    fun users(): UserServiceAsync

    fun templates(): TemplateServiceAsync

    fun profiles(): ProfileServiceAsync

    fun messages(): MessageServiceAsync

    fun lookup(): LookupServiceAsync

    fun contacts(): ContactServiceAsync

    fun brands(): BrandServiceAsync

    fun me(): MeServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [SentDmClientAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentDmClientAsync.WithRawResponse

        fun webhooks(): WebhookServiceAsync.WithRawResponse

        fun users(): UserServiceAsync.WithRawResponse

        fun templates(): TemplateServiceAsync.WithRawResponse

        fun profiles(): ProfileServiceAsync.WithRawResponse

        fun messages(): MessageServiceAsync.WithRawResponse

        fun lookup(): LookupServiceAsync.WithRawResponse

        fun contacts(): ContactServiceAsync.WithRawResponse

        fun brands(): BrandServiceAsync.WithRawResponse

        fun me(): MeServiceAsync.WithRawResponse
    }
}
