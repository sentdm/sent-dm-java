// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.services.blocking.ContactService
import dm.sent.services.blocking.MeService
import dm.sent.services.blocking.MessageService
import dm.sent.services.blocking.NumberService
import dm.sent.services.blocking.ProfileService
import dm.sent.services.blocking.TemplateService
import dm.sent.services.blocking.UserService
import dm.sent.services.blocking.WebhookService
import java.util.function.Consumer

/**
 * A client for interacting with the Sent REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
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
interface SentClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): SentClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentClient

    /** Configure webhook endpoints for real-time event delivery */
    fun webhooks(): WebhookService

    /** Invite, update, and manage organization users and roles */
    fun users(): UserService

    /** Manage message templates with variable substitution */
    fun templates(): TemplateService

    /** Manage organization profiles */
    fun profiles(): ProfileService

    /** Manage and lookup phone numbers */
    fun numbers(): NumberService

    /** Send and track SMS and WhatsApp messages */
    fun messages(): MessageService

    /** Create, update, and manage customer contact lists */
    fun contacts(): ContactService

    /** Retrieve account details */
    fun me(): MeService

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

    /** A view of [SentClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentClient.WithRawResponse

        /** Configure webhook endpoints for real-time event delivery */
        fun webhooks(): WebhookService.WithRawResponse

        /** Invite, update, and manage organization users and roles */
        fun users(): UserService.WithRawResponse

        /** Manage message templates with variable substitution */
        fun templates(): TemplateService.WithRawResponse

        /** Manage organization profiles */
        fun profiles(): ProfileService.WithRawResponse

        /** Manage and lookup phone numbers */
        fun numbers(): NumberService.WithRawResponse

        /** Send and track SMS and WhatsApp messages */
        fun messages(): MessageService.WithRawResponse

        /** Create, update, and manage customer contact lists */
        fun contacts(): ContactService.WithRawResponse

        /** Retrieve account details */
        fun me(): MeService.WithRawResponse
    }
}
