// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.webhooks.ApiResponseWebhook
import dm.sent.models.webhooks.WebhookCreateParams
import dm.sent.models.webhooks.WebhookDeleteParams
import dm.sent.models.webhooks.WebhookListEventTypesParams
import dm.sent.models.webhooks.WebhookListEventTypesResponse
import dm.sent.models.webhooks.WebhookListEventsPageAsync
import dm.sent.models.webhooks.WebhookListEventsParams
import dm.sent.models.webhooks.WebhookListPageAsync
import dm.sent.models.webhooks.WebhookListParams
import dm.sent.models.webhooks.WebhookRetrieveParams
import dm.sent.models.webhooks.WebhookRotateSecretParams
import dm.sent.models.webhooks.WebhookRotateSecretResponse
import dm.sent.models.webhooks.WebhookTestParams
import dm.sent.models.webhooks.WebhookTestResponse
import dm.sent.models.webhooks.WebhookToggleStatusParams
import dm.sent.models.webhooks.WebhookUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Delivery reports and inbound messages, pushed to you.
 *
 * Subscribe an endpoint to the event types you care about — `GET /v3/webhooks/event-types` lists
 * them — and we POST each one as it happens, retrying on failure. Polling `GET /v3/messages/{id}`
 * works and does not scale.
 *
 * **Verify the signature.** Every delivery is signed with your endpoint's secret; an unverified
 * endpoint is one anybody can post to. `rotate-secret` replaces it, `test` sends a specimen event,
 * and `GET /v3/webhooks/{id}/events` shows what we tried to deliver and what your endpoint answered
 * — which is the first place to look when something appears to be missing.
 */
interface WebhookServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookServiceAsync

    /**
     * Creates a new webhook endpoint for the authenticated customer. A webhook is version 2 unless
     * the request sets webhook_version to 1: Svix delivers it, signed with the webhook-id,
     * webhook-timestamp and webhook-signature headers, and retries it on its own schedule, so
     * retry_count and timeout_seconds apply to version 1 only. sender_profile applies to version 1
     * only and is ignored on version 2; is_inheritable applies to version 2 only. A version 1
     * webhook's response returns its sender_profile selection, with an empty event_types when it is
     * not cloned onto sender profiles; a version 2 webhook's response leaves sender_profile out.
     */
    fun create(): CompletableFuture<ApiResponseWebhook> = create(WebhookCreateParams.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams = WebhookCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook>

    /** @see create */
    fun create(
        params: WebhookCreateParams = WebhookCreateParams.none()
    ): CompletableFuture<ApiResponseWebhook> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseWebhook> =
        create(WebhookCreateParams.none(), requestOptions)

    /**
     * Retrieves a single webhook by ID for the authenticated customer. A version 1 webhook includes
     * its sender_profile selection.
     */
    fun retrieve(id: String): CompletableFuture<ApiResponseWebhook> =
        retrieve(id, WebhookRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
    ): CompletableFuture<ApiResponseWebhook> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook>

    /** @see retrieve */
    fun retrieve(params: WebhookRetrieveParams): CompletableFuture<ApiResponseWebhook> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseWebhook> =
        retrieve(id, WebhookRetrieveParams.none(), requestOptions)

    /**
     * Updates an existing webhook for the authenticated customer. Its version does not change.
     * sender_profile applies to a version 1 webhook and is_inheritable to a version 2 one;
     * retry_count and timeout_seconds apply to version 1 only. A version 1 webhook's response
     * returns its sender_profile selection as saved; a version 2 webhook's response leaves
     * sender_profile out.
     */
    fun update(id: String): CompletableFuture<ApiResponseWebhook> =
        update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): CompletableFuture<ApiResponseWebhook> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook>

    /** @see update */
    fun update(params: WebhookUpdateParams): CompletableFuture<ApiResponseWebhook> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<ApiResponseWebhook> =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of webhooks for the authenticated customer. Each version 1 webhook
     * includes its sender_profile selection.
     */
    fun list(): CompletableFuture<WebhookListPageAsync> = list(WebhookListParams.none())

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListPageAsync>

    /** @see list */
    fun list(
        params: WebhookListParams = WebhookListParams.none()
    ): CompletableFuture<WebhookListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<WebhookListPageAsync> =
        list(WebhookListParams.none(), requestOptions)

    /** Deletes a webhook for the authenticated customer. */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, WebhookDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: WebhookDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: WebhookDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, WebhookDeleteParams.none(), requestOptions)

    /** Retrieves all available webhook event types that can be subscribed to. */
    fun listEventTypes(): CompletableFuture<WebhookListEventTypesResponse> =
        listEventTypes(WebhookListEventTypesParams.none())

    /** @see listEventTypes */
    fun listEventTypes(
        params: WebhookListEventTypesParams = WebhookListEventTypesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListEventTypesResponse>

    /** @see listEventTypes */
    fun listEventTypes(
        params: WebhookListEventTypesParams = WebhookListEventTypesParams.none()
    ): CompletableFuture<WebhookListEventTypesResponse> =
        listEventTypes(params, RequestOptions.none())

    /** @see listEventTypes */
    fun listEventTypes(
        requestOptions: RequestOptions
    ): CompletableFuture<WebhookListEventTypesResponse> =
        listEventTypes(WebhookListEventTypesParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of delivery events for the specified webhook, newest first. If the
     * webhook is cloned onto your sender profiles (version 1) or inheritable by them (version 2,
     * is_inheritable), the list includes their events; read payload.account_id to tell whose event
     * it is. A sender profile may read its organization's inheritable webhook too, and gets the
     * events about itself.
     */
    fun listEvents(id: String): CompletableFuture<WebhookListEventsPageAsync> =
        listEvents(id, WebhookListEventsParams.none())

    /** @see listEvents */
    fun listEvents(
        id: String,
        params: WebhookListEventsParams = WebhookListEventsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListEventsPageAsync> =
        listEvents(params.toBuilder().id(id).build(), requestOptions)

    /** @see listEvents */
    fun listEvents(
        id: String,
        params: WebhookListEventsParams = WebhookListEventsParams.none(),
    ): CompletableFuture<WebhookListEventsPageAsync> = listEvents(id, params, RequestOptions.none())

    /** @see listEvents */
    fun listEvents(
        params: WebhookListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListEventsPageAsync>

    /** @see listEvents */
    fun listEvents(params: WebhookListEventsParams): CompletableFuture<WebhookListEventsPageAsync> =
        listEvents(params, RequestOptions.none())

    /** @see listEvents */
    fun listEvents(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookListEventsPageAsync> =
        listEvents(id, WebhookListEventsParams.none(), requestOptions)

    /**
     * Generates a new signing secret for the specified webhook. A version 1 webhook's old secret
     * stops verifying at once. A version 2 webhook's deliveries are signed with the new secret at
     * once, and with the old one as well for the next 24 hours, so a receiver can switch over
     * without rejecting any; after that the old secret no longer verifies.
     */
    fun rotateSecret(
        id: String,
        params: WebhookRotateSecretParams,
    ): CompletableFuture<WebhookRotateSecretResponse> =
        rotateSecret(id, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookRotateSecretResponse> =
        rotateSecret(params.toBuilder().id(id).build(), requestOptions)

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams
    ): CompletableFuture<WebhookRotateSecretResponse> = rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookRotateSecretResponse>

    /**
     * Sends a test event to the specified webhook endpoint to verify connectivity. A version 1
     * webhook is tested at once and the answer says whether it was delivered; a version 2 webhook's
     * test is queued with Svix, which delivers it right after, and the answer says it was queued.
     */
    fun test(id: String): CompletableFuture<WebhookTestResponse> =
        test(id, WebhookTestParams.none())

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookTestResponse> =
        test(params.toBuilder().id(id).build(), requestOptions)

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
    ): CompletableFuture<WebhookTestResponse> = test(id, params, RequestOptions.none())

    /** @see test */
    fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookTestResponse>

    /** @see test */
    fun test(params: WebhookTestParams): CompletableFuture<WebhookTestResponse> =
        test(params, RequestOptions.none())

    /** @see test */
    fun test(id: String, requestOptions: RequestOptions): CompletableFuture<WebhookTestResponse> =
        test(id, WebhookTestParams.none(), requestOptions)

    /** Activates or deactivates a webhook for the authenticated customer. */
    fun toggleStatus(id: String): CompletableFuture<ApiResponseWebhook> =
        toggleStatus(id, WebhookToggleStatusParams.none())

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook> =
        toggleStatus(params.toBuilder().id(id).build(), requestOptions)

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
    ): CompletableFuture<ApiResponseWebhook> = toggleStatus(id, params, RequestOptions.none())

    /** @see toggleStatus */
    fun toggleStatus(
        params: WebhookToggleStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseWebhook>

    /** @see toggleStatus */
    fun toggleStatus(params: WebhookToggleStatusParams): CompletableFuture<ApiResponseWebhook> =
        toggleStatus(params, RequestOptions.none())

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseWebhook> =
        toggleStatus(id, WebhookToggleStatusParams.none(), requestOptions)

    /**
     * A view of [WebhookServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/webhooks`, but is otherwise the same as
         * [WebhookServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            create(WebhookCreateParams.none())

        /** @see create */
        fun create(
            params: WebhookCreateParams = WebhookCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>>

        /** @see create */
        fun create(
            params: WebhookCreateParams = WebhookCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            create(WebhookCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            retrieve(id, WebhookRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>>

        /** @see retrieve */
        fun retrieve(
            params: WebhookRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            retrieve(id, WebhookRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            update(id, WebhookUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>>

        /** @see update */
        fun update(
            params: WebhookUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks`, but is otherwise the same as
         * [WebhookServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<WebhookListPageAsync>> =
            list(WebhookListParams.none())

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListPageAsync>>

        /** @see list */
        fun list(
            params: WebhookListParams = WebhookListParams.none()
        ): CompletableFuture<HttpResponseFor<WebhookListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WebhookListPageAsync>> =
            list(WebhookListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, WebhookDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: WebhookDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, WebhookDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/event-types`, but is otherwise the same
         * as [WebhookServiceAsync.listEventTypes].
         */
        fun listEventTypes(): CompletableFuture<HttpResponseFor<WebhookListEventTypesResponse>> =
            listEventTypes(WebhookListEventTypesParams.none())

        /** @see listEventTypes */
        fun listEventTypes(
            params: WebhookListEventTypesParams = WebhookListEventTypesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListEventTypesResponse>>

        /** @see listEventTypes */
        fun listEventTypes(
            params: WebhookListEventTypesParams = WebhookListEventTypesParams.none()
        ): CompletableFuture<HttpResponseFor<WebhookListEventTypesResponse>> =
            listEventTypes(params, RequestOptions.none())

        /** @see listEventTypes */
        fun listEventTypes(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WebhookListEventTypesResponse>> =
            listEventTypes(WebhookListEventTypesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/{id}/events`, but is otherwise the same
         * as [WebhookServiceAsync.listEvents].
         */
        fun listEvents(id: String): CompletableFuture<HttpResponseFor<WebhookListEventsPageAsync>> =
            listEvents(id, WebhookListEventsParams.none())

        /** @see listEvents */
        fun listEvents(
            id: String,
            params: WebhookListEventsParams = WebhookListEventsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListEventsPageAsync>> =
            listEvents(params.toBuilder().id(id).build(), requestOptions)

        /** @see listEvents */
        fun listEvents(
            id: String,
            params: WebhookListEventsParams = WebhookListEventsParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListEventsPageAsync>> =
            listEvents(id, params, RequestOptions.none())

        /** @see listEvents */
        fun listEvents(
            params: WebhookListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListEventsPageAsync>>

        /** @see listEvents */
        fun listEvents(
            params: WebhookListEventsParams
        ): CompletableFuture<HttpResponseFor<WebhookListEventsPageAsync>> =
            listEvents(params, RequestOptions.none())

        /** @see listEvents */
        fun listEvents(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookListEventsPageAsync>> =
            listEvents(id, WebhookListEventsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/webhooks/{id}/rotate-secret`, but is otherwise
         * the same as [WebhookServiceAsync.rotateSecret].
         */
        fun rotateSecret(
            id: String,
            params: WebhookRotateSecretParams,
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(id, params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            id: String,
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(params.toBuilder().id(id).build(), requestOptions)

        /** @see rotateSecret */
        fun rotateSecret(
            params: WebhookRotateSecretParams
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>>

        /**
         * Returns a raw HTTP response for `post /v3/webhooks/{id}/test`, but is otherwise the same
         * as [WebhookServiceAsync.test].
         */
        fun test(id: String): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(id, WebhookTestParams.none())

        /** @see test */
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(params.toBuilder().id(id).build(), requestOptions)

        /** @see test */
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(id, params, RequestOptions.none())

        /** @see test */
        fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>>

        /** @see test */
        fun test(
            params: WebhookTestParams
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(params, RequestOptions.none())

        /** @see test */
        fun test(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookTestResponse>> =
            test(id, WebhookTestParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/webhooks/{id}/toggle-status`, but is otherwise
         * the same as [WebhookServiceAsync.toggleStatus].
         */
        fun toggleStatus(id: String): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            toggleStatus(id, WebhookToggleStatusParams.none())

        /** @see toggleStatus */
        fun toggleStatus(
            id: String,
            params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            toggleStatus(params.toBuilder().id(id).build(), requestOptions)

        /** @see toggleStatus */
        fun toggleStatus(
            id: String,
            params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            toggleStatus(id, params, RequestOptions.none())

        /** @see toggleStatus */
        fun toggleStatus(
            params: WebhookToggleStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>>

        /** @see toggleStatus */
        fun toggleStatus(
            params: WebhookToggleStatusParams
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            toggleStatus(params, RequestOptions.none())

        /** @see toggleStatus */
        fun toggleStatus(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseWebhook>> =
            toggleStatus(id, WebhookToggleStatusParams.none(), requestOptions)
    }
}
