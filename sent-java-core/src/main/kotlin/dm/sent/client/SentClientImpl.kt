// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.blocking.ContactService
import dm.sent.services.blocking.ContactServiceImpl
import dm.sent.services.blocking.ConversationService
import dm.sent.services.blocking.ConversationServiceImpl
import dm.sent.services.blocking.MeService
import dm.sent.services.blocking.MeServiceImpl
import dm.sent.services.blocking.MessageService
import dm.sent.services.blocking.MessageServiceImpl
import dm.sent.services.blocking.NumberService
import dm.sent.services.blocking.NumberServiceImpl
import dm.sent.services.blocking.ProfileService
import dm.sent.services.blocking.ProfileServiceImpl
import dm.sent.services.blocking.TemplateService
import dm.sent.services.blocking.TemplateServiceImpl
import dm.sent.services.blocking.UserService
import dm.sent.services.blocking.UserServiceImpl
import dm.sent.services.blocking.WebhookService
import dm.sent.services.blocking.WebhookServiceImpl
import java.util.function.Consumer

class SentClientImpl(private val clientOptions: ClientOptions) : SentClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: SentClientAsync by lazy { SentClientAsyncImpl(clientOptions) }

    private val withRawResponse: SentClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    private val templates: TemplateService by lazy {
        TemplateServiceImpl(clientOptionsWithUserAgent)
    }

    private val profiles: ProfileService by lazy { ProfileServiceImpl(clientOptionsWithUserAgent) }

    private val numbers: NumberService by lazy { NumberServiceImpl(clientOptionsWithUserAgent) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptionsWithUserAgent) }

    private val conversations: ConversationService by lazy {
        ConversationServiceImpl(clientOptionsWithUserAgent)
    }

    private val me: MeService by lazy { MeServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): SentClientAsync = async

    override fun withRawResponse(): SentClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentClient =
        SentClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
    override fun webhooks(): WebhookService = webhooks

    /**
     * The people who can sign in to your organization, and what each may do.
     *
     * Users are dashboard access and nothing else — they do not send, and removing one does not
     * affect traffic. An API key is not a user: it belongs to the organization or to a sender
     * profile, so revoking a person's access leaves your integration running.
     */
    override fun users(): UserService = users

    /**
     * Reusable message bodies with named variables.
     *
     * A template is substituted at send time from the values you pass, so the copy lives here
     * rather than in your application. WhatsApp templates additionally need Meta's approval before
     * they can be sent, and a template's channel status reports where that stands — an approved SMS
     * template and an unapproved WhatsApp one are the same template in two states.
     */
    override fun templates(): TemplateService = templates

    /**
     * **Deprecated — use Sender Profiles.**
     *
     * The original profile resource, kept because it has live callers. It still works, and its
     * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
     * instead of across three.
     *
     * New integrations should not start here.
     */
    override fun profiles(): ProfileService = profiles

    /**
     * What a phone number actually is, before you send to it.
     *
     * A lookup returns the number's country, line type and carrier, which is what decides whether
     * it is reachable on a channel and what it costs. Worth doing on import rather than on send: a
     * landline in a contact list is a message that can never be delivered.
     */
    override fun numbers(): NumberService = numbers

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
    override fun messages(): MessageService = messages

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
    override fun contacts(): ContactService = contacts

    /**
     * Inbound and outbound messages, grouped by the person they are with.
     *
     * A conversation is the thread for one contact across every channel — a reply by SMS and one by
     * WhatsApp belong to the same conversation, because they are the same person talking to you.
     *
     * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
     */
    override fun conversations(): ConversationService = conversations

    /**
     * Who the current key is.
     *
     * `GET /v3/me` answers with the account the key authenticates as, which is the quickest way to
     * tell a live key from a test one, an organization key from a sender profile's, and to confirm
     * `x-profile-id` resolved to the profile you meant.
     */
    override fun me(): MeService = me

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentClient.WithRawResponse {

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val templates: TemplateService.WithRawResponse by lazy {
            TemplateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val profiles: ProfileService.WithRawResponse by lazy {
            ProfileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val numbers: NumberService.WithRawResponse by lazy {
            NumberServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactService.WithRawResponse by lazy {
            ContactServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val conversations: ConversationService.WithRawResponse by lazy {
            ConversationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val me: MeService.WithRawResponse by lazy {
            MeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentClient.WithRawResponse =
            SentClientImpl.WithRawResponseImpl(
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
        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        /**
         * The people who can sign in to your organization, and what each may do.
         *
         * Users are dashboard access and nothing else — they do not send, and removing one does not
         * affect traffic. An API key is not a user: it belongs to the organization or to a sender
         * profile, so revoking a person's access leaves your integration running.
         */
        override fun users(): UserService.WithRawResponse = users

        /**
         * Reusable message bodies with named variables.
         *
         * A template is substituted at send time from the values you pass, so the copy lives here
         * rather than in your application. WhatsApp templates additionally need Meta's approval
         * before they can be sent, and a template's channel status reports where that stands — an
         * approved SMS template and an unapproved WhatsApp one are the same template in two states.
         */
        override fun templates(): TemplateService.WithRawResponse = templates

        /**
         * **Deprecated — use Sender Profiles.**
         *
         * The original profile resource, kept because it has live callers. It still works, and its
         * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one
         * call instead of across three.
         *
         * New integrations should not start here.
         */
        override fun profiles(): ProfileService.WithRawResponse = profiles

        /**
         * What a phone number actually is, before you send to it.
         *
         * A lookup returns the number's country, line type and carrier, which is what decides
         * whether it is reachable on a channel and what it costs. Worth doing on import rather than
         * on send: a landline in a contact list is a message that can never be delivered.
         */
        override fun numbers(): NumberService.WithRawResponse = numbers

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
        override fun messages(): MessageService.WithRawResponse = messages

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
        override fun contacts(): ContactService.WithRawResponse = contacts

        /**
         * Inbound and outbound messages, grouped by the person they are with.
         *
         * A conversation is the thread for one contact across every channel — a reply by SMS and
         * one by WhatsApp belong to the same conversation, because they are the same person talking
         * to you.
         *
         * Read-only. Sending is **Messages**; a reply arrives here and through your webhooks.
         */
        override fun conversations(): ConversationService.WithRawResponse = conversations

        /**
         * Who the current key is.
         *
         * `GET /v3/me` answers with the account the key authenticates as, which is the quickest way
         * to tell a live key from a test one, an organization key from a sender profile's, and to
         * confirm `x-profile-id` resolved to the profile you meant.
         */
        override fun me(): MeService.WithRawResponse = me
    }
}
