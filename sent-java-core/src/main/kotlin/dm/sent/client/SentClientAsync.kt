// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.services.async.ContactServiceAsync
import dm.sent.services.async.ConversationServiceAsync
import dm.sent.services.async.MeServiceAsync
import dm.sent.services.async.MessageServiceAsync
import dm.sent.services.async.NumberServiceAsync
import dm.sent.services.async.ProfileServiceAsync
import dm.sent.services.async.TemplateServiceAsync
import dm.sent.services.async.UserServiceAsync
import dm.sent.services.async.WebhookServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Sent REST API asynchronously. You can also switch to
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
interface SentClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): SentClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentClientAsync

    /**
     * Delivery reports and inbound messages, pushed to you.
     *
     * Subscribe an endpoint to the event types you care about — `GET /v3/webhooks/event-types`
     * lists them — and we POST each one as it happens, retrying on failure. Polling `GET
     * /v3/messages/{id}` works and does not scale.
     *
     * **Verify the signature.** Every delivery is signed with your endpoint's secret; an unverified
     * endpoint is one anybody can post to. `rotate-secret` replaces it, `test` sends a specimen
     * event, and `GET /v3/webhooks/{id}/events` shows what we tried to deliver and what your
     * endpoint answered — which is the first place to look when something appears to be missing.
     */
    fun webhooks(): WebhookServiceAsync

    /**
     * The people who can sign in to your organization, and what each may do.
     *
     * Users are dashboard access and nothing else — they do not send, and removing one does not
     * affect traffic. An API key is not a user: it belongs to the organization or to a sender
     * profile, so revoking a person's access leaves your integration running.
     */
    fun users(): UserServiceAsync

    /**
     * Reusable message bodies with named variables.
     *
     * A template is substituted at send time from the values you pass, so the copy lives here
     * rather than in your application. WhatsApp templates additionally need Meta's approval before
     * they can be sent, and a template's channel status reports where that stands — an approved SMS
     * template and an unapproved WhatsApp one are the same template in two states.
     */
    fun templates(): TemplateServiceAsync

    /**
     * **Deprecated — use Sender Profiles.**
     *
     * The original profile resource, kept because it has live callers. It still works, and its
     * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
     * instead of across three.
     *
     * New integrations should not start here.
     */
    fun profiles(): ProfileServiceAsync

    /**
     * What a phone number actually is, before you send to it.
     *
     * A lookup returns the number's country, line type and carrier, which is what decides whether
     * it is reachable on a channel and what it costs. Worth doing on import rather than on send: a
     * landline in a contact list is a message that can never be delivered.
     */
    fun numbers(): NumberServiceAsync

    /**
     * Send a message and follow what happened to it.
     *
     * One endpoint sends on any channel: pass `channel: "sent"` and we pick between SMS, WhatsApp
     * and RCS per recipient using your routing rules, or name a channel to pin it. A send is
     * accepted asynchronously — `POST /v3/messages` returns an id, and delivery is reported through
     * `GET /v3/messages/{id}`, its activities, or a webhook.
     *
     * **A message needs a sender.** What you can send, where, and at what cost is decided by the
     * markets under **Channels** — so a recipient in a country you hold no sender for is refused
     * here rather than queued.
     */
    fun messages(): MessageServiceAsync

    /**
     * The people you message, and their channel identities.
     *
     * A contact holds one identity per channel — a phone number, a WhatsApp number — so routing can
     * choose between them for the same person. Opt-out is recorded against the contact and honoured
     * on every send, whichever channel it came through.
     *
     * `GET /v3/contacts/{id}/message-summary` is the per-contact view of what you have sent and
     * what happened to it.
     */
    fun contacts(): ContactServiceAsync

    /**
     * Inbound and outbound messages, grouped by the person they are with.
     *
     * A conversation is the thread for one contact across every channel — a reply by SMS and one by
     * WhatsApp belong to the same conversation, because they are the same person talking to you.
     *
     * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
     */
    fun conversations(): ConversationServiceAsync

    /**
     * Who the current key is.
     *
     * `GET /v3/me` answers with the account the key authenticates as, which is the quickest way to
     * tell a live key from a test one, an organization key from a sender profile's, and to confirm
     * `x-profile-id` resolved to the profile you meant.
     */
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

    /** A view of [SentClientAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentClientAsync.WithRawResponse

        /**
         * Delivery reports and inbound messages, pushed to you.
         *
         * Subscribe an endpoint to the event types you care about — `GET /v3/webhooks/event-types`
         * lists them — and we POST each one as it happens, retrying on failure. Polling `GET
         * /v3/messages/{id}` works and does not scale.
         *
         * **Verify the signature.** Every delivery is signed with your endpoint's secret; an
         * unverified endpoint is one anybody can post to. `rotate-secret` replaces it, `test` sends
         * a specimen event, and `GET /v3/webhooks/{id}/events` shows what we tried to deliver and
         * what your endpoint answered — which is the first place to look when something appears to
         * be missing.
         */
        fun webhooks(): WebhookServiceAsync.WithRawResponse

        /**
         * The people who can sign in to your organization, and what each may do.
         *
         * Users are dashboard access and nothing else — they do not send, and removing one does not
         * affect traffic. An API key is not a user: it belongs to the organization or to a sender
         * profile, so revoking a person's access leaves your integration running.
         */
        fun users(): UserServiceAsync.WithRawResponse

        /**
         * Reusable message bodies with named variables.
         *
         * A template is substituted at send time from the values you pass, so the copy lives here
         * rather than in your application. WhatsApp templates additionally need Meta's approval
         * before they can be sent, and a template's channel status reports where that stands — an
         * approved SMS template and an unapproved WhatsApp one are the same template in two states.
         */
        fun templates(): TemplateServiceAsync.WithRawResponse

        /**
         * **Deprecated — use Sender Profiles.**
         *
         * The original profile resource, kept because it has live callers. It still works, and its
         * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one
         * call instead of across three.
         *
         * New integrations should not start here.
         */
        fun profiles(): ProfileServiceAsync.WithRawResponse

        /**
         * What a phone number actually is, before you send to it.
         *
         * A lookup returns the number's country, line type and carrier, which is what decides
         * whether it is reachable on a channel and what it costs. Worth doing on import rather than
         * on send: a landline in a contact list is a message that can never be delivered.
         */
        fun numbers(): NumberServiceAsync.WithRawResponse

        /**
         * Send a message and follow what happened to it.
         *
         * One endpoint sends on any channel: pass `channel: "sent"` and we pick between SMS,
         * WhatsApp and RCS per recipient using your routing rules, or name a channel to pin it. A
         * send is accepted asynchronously — `POST /v3/messages` returns an id, and delivery is
         * reported through `GET /v3/messages/{id}`, its activities, or a webhook.
         *
         * **A message needs a sender.** What you can send, where, and at what cost is decided by
         * the markets under **Channels** — so a recipient in a country you hold no sender for is
         * refused here rather than queued.
         */
        fun messages(): MessageServiceAsync.WithRawResponse

        /**
         * The people you message, and their channel identities.
         *
         * A contact holds one identity per channel — a phone number, a WhatsApp number — so routing
         * can choose between them for the same person. Opt-out is recorded against the contact and
         * honoured on every send, whichever channel it came through.
         *
         * `GET /v3/contacts/{id}/message-summary` is the per-contact view of what you have sent and
         * what happened to it.
         */
        fun contacts(): ContactServiceAsync.WithRawResponse

        /**
         * Inbound and outbound messages, grouped by the person they are with.
         *
         * A conversation is the thread for one contact across every channel — a reply by SMS and
         * one by WhatsApp belong to the same conversation, because they are the same person talking
         * to you.
         *
         * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
         */
        fun conversations(): ConversationServiceAsync.WithRawResponse

        /**
         * Who the current key is.
         *
         * `GET /v3/me` answers with the account the key authenticates as, which is the quickest way
         * to tell a live key from a test one, an organization key from a sender profile's, and to
         * confirm `x-profile-id` resolved to the profile you meant.
         */
        fun me(): MeServiceAsync.WithRawResponse
    }
}
