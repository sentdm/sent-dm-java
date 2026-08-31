// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.async.ContactServiceAsync
import dm.sent.services.async.ContactServiceAsyncImpl
import dm.sent.services.async.ConversationServiceAsync
import dm.sent.services.async.ConversationServiceAsyncImpl
import dm.sent.services.async.MeServiceAsync
import dm.sent.services.async.MeServiceAsyncImpl
import dm.sent.services.async.MessageServiceAsync
import dm.sent.services.async.MessageServiceAsyncImpl
import dm.sent.services.async.NumberServiceAsync
import dm.sent.services.async.NumberServiceAsyncImpl
import dm.sent.services.async.ProfileServiceAsync
import dm.sent.services.async.ProfileServiceAsyncImpl
import dm.sent.services.async.TemplateServiceAsync
import dm.sent.services.async.TemplateServiceAsyncImpl
import dm.sent.services.async.UserServiceAsync
import dm.sent.services.async.UserServiceAsyncImpl
import dm.sent.services.async.WebhookServiceAsync
import dm.sent.services.async.WebhookServiceAsyncImpl
import java.util.function.Consumer

class SentClientAsyncImpl(private val clientOptions: ClientOptions) : SentClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: SentClient by lazy { SentClientImpl(clientOptions) }

    private val withRawResponse: SentClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val templates: TemplateServiceAsync by lazy {
        TemplateServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val profiles: ProfileServiceAsync by lazy {
        ProfileServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val numbers: NumberServiceAsync by lazy {
        NumberServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val contacts: ContactServiceAsync by lazy {
        ContactServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val conversations: ConversationServiceAsync by lazy {
        ConversationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val me: MeServiceAsync by lazy { MeServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): SentClient = sync

    override fun withRawResponse(): SentClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentClientAsync =
        SentClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
    override fun webhooks(): WebhookServiceAsync = webhooks

    /**
     * The people who can sign in to your organization, and what each may do.
     *
     * Users are dashboard access and nothing else — they do not send, and removing one does not
     * affect traffic. An API key is not a user: it belongs to the organization or to a sender
     * profile, so revoking a person's access leaves your integration running.
     */
    override fun users(): UserServiceAsync = users

    /**
     * Reusable message bodies with named variables.
     *
     * A template is substituted at send time from the values you pass, so the copy lives here
     * rather than in your application. WhatsApp templates additionally need Meta's approval before
     * they can be sent, and a template's channel status reports where that stands — an approved SMS
     * template and an unapproved WhatsApp one are the same template in two states.
     */
    override fun templates(): TemplateServiceAsync = templates

    /**
     * **Deprecated — use Sender Profiles.**
     *
     * The original profile resource, kept because it has live callers. It still works, and its
     * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
     * instead of across three.
     *
     * New integrations should not start here.
     */
    override fun profiles(): ProfileServiceAsync = profiles

    /**
     * What a phone number actually is, before you send to it.
     *
     * A lookup returns the number's country, line type and carrier, which is what decides whether
     * it is reachable on a channel and what it costs. Worth doing on import rather than on send: a
     * landline in a contact list is a message that can never be delivered.
     */
    override fun numbers(): NumberServiceAsync = numbers

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
    override fun messages(): MessageServiceAsync = messages

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
    override fun contacts(): ContactServiceAsync = contacts

    /**
     * Inbound and outbound messages, grouped by the person they are with.
     *
     * A conversation is the thread for one contact across every channel — a reply by SMS and one by
     * WhatsApp belong to the same conversation, because they are the same person talking to you.
     *
     * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
     */
    override fun conversations(): ConversationServiceAsync = conversations

    /**
     * Who the current key is.
     *
     * `GET /v3/me` answers with the account the key authenticates as, which is the quickest way to
     * tell a live key from a test one, an organization key from a sender profile's, and to confirm
     * `x-profile-id` resolved to the profile you meant.
     */
    override fun me(): MeServiceAsync = me

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentClientAsync.WithRawResponse {

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val templates: TemplateServiceAsync.WithRawResponse by lazy {
            TemplateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val profiles: ProfileServiceAsync.WithRawResponse by lazy {
            ProfileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val numbers: NumberServiceAsync.WithRawResponse by lazy {
            NumberServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactServiceAsync.WithRawResponse by lazy {
            ContactServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val conversations: ConversationServiceAsync.WithRawResponse by lazy {
            ConversationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val me: MeServiceAsync.WithRawResponse by lazy {
            MeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentClientAsync.WithRawResponse =
            SentClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

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
        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        /**
         * The people who can sign in to your organization, and what each may do.
         *
         * Users are dashboard access and nothing else — they do not send, and removing one does not
         * affect traffic. An API key is not a user: it belongs to the organization or to a sender
         * profile, so revoking a person's access leaves your integration running.
         */
        override fun users(): UserServiceAsync.WithRawResponse = users

        /**
         * Reusable message bodies with named variables.
         *
         * A template is substituted at send time from the values you pass, so the copy lives here
         * rather than in your application. WhatsApp templates additionally need Meta's approval
         * before they can be sent, and a template's channel status reports where that stands — an
         * approved SMS template and an unapproved WhatsApp one are the same template in two states.
         */
        override fun templates(): TemplateServiceAsync.WithRawResponse = templates

        /**
         * **Deprecated — use Sender Profiles.**
         *
         * The original profile resource, kept because it has live callers. It still works, and its
         * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one
         * call instead of across three.
         *
         * New integrations should not start here.
         */
        override fun profiles(): ProfileServiceAsync.WithRawResponse = profiles

        /**
         * What a phone number actually is, before you send to it.
         *
         * A lookup returns the number's country, line type and carrier, which is what decides
         * whether it is reachable on a channel and what it costs. Worth doing on import rather than
         * on send: a landline in a contact list is a message that can never be delivered.
         */
        override fun numbers(): NumberServiceAsync.WithRawResponse = numbers

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
        override fun messages(): MessageServiceAsync.WithRawResponse = messages

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
        override fun contacts(): ContactServiceAsync.WithRawResponse = contacts

        /**
         * Inbound and outbound messages, grouped by the person they are with.
         *
         * A conversation is the thread for one contact across every channel — a reply by SMS and
         * one by WhatsApp belong to the same conversation, because they are the same person talking
         * to you.
         *
         * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
         */
        override fun conversations(): ConversationServiceAsync.WithRawResponse = conversations

        /**
         * Who the current key is.
         *
         * `GET /v3/me` answers with the account the key authenticates as, which is the quickest way
         * to tell a live key from a test one, an organization key from a sender profile's, and to
         * confirm `x-profile-id` resolved to the profile you meant.
         */
        override fun me(): MeServiceAsync.WithRawResponse = me
    }
}
