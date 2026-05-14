// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.webhooks.WebhookCreateParams
import dm.sent.models.webhooks.WebhookCreateResponse
import dm.sent.models.webhooks.WebhookDeleteParams
import dm.sent.models.webhooks.WebhookListEventTypesParams
import dm.sent.models.webhooks.WebhookListEventTypesResponse
import dm.sent.models.webhooks.WebhookListEventsParams
import dm.sent.models.webhooks.WebhookListEventsResponse
import dm.sent.models.webhooks.WebhookListParams
import dm.sent.models.webhooks.WebhookListResponse
import dm.sent.models.webhooks.WebhookRetrieveParams
import dm.sent.models.webhooks.WebhookRetrieveResponse
import dm.sent.models.webhooks.WebhookRotateSecretParams
import dm.sent.models.webhooks.WebhookRotateSecretResponse
import dm.sent.models.webhooks.WebhookTestParams
import dm.sent.models.webhooks.WebhookTestResponse
import dm.sent.models.webhooks.WebhookToggleStatusParams
import dm.sent.models.webhooks.WebhookToggleStatusResponse
import dm.sent.models.webhooks.WebhookUpdateParams
import dm.sent.models.webhooks.WebhookUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Configure webhook endpoints for real-time event delivery */
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

    /** Creates a new webhook endpoint for the authenticated customer. */
    fun create(): CompletableFuture<WebhookCreateResponse> = create(WebhookCreateParams.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams = WebhookCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookCreateResponse>

    /** @see create */
    fun create(
        params: WebhookCreateParams = WebhookCreateParams.none()
    ): CompletableFuture<WebhookCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<WebhookCreateResponse> =
        create(WebhookCreateParams.none(), requestOptions)

    /** Retrieves a single webhook by ID for the authenticated customer. */
    fun retrieve(id: String): CompletableFuture<WebhookRetrieveResponse> =
        retrieve(id, WebhookRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
    ): CompletableFuture<WebhookRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: WebhookRetrieveParams): CompletableFuture<WebhookRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookRetrieveResponse> =
        retrieve(id, WebhookRetrieveParams.none(), requestOptions)

    /** Updates an existing webhook for the authenticated customer. */
    fun update(id: String): CompletableFuture<WebhookUpdateResponse> =
        update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): CompletableFuture<WebhookUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookUpdateResponse>

    /** @see update */
    fun update(params: WebhookUpdateParams): CompletableFuture<WebhookUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookUpdateResponse> =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /** Retrieves a paginated list of webhooks for the authenticated customer. */
    fun list(params: WebhookListParams): CompletableFuture<WebhookListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: WebhookListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListResponse>

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

    /** Retrieves a paginated list of delivery events for the specified webhook. */
    fun listEvents(
        id: String,
        params: WebhookListEventsParams,
    ): CompletableFuture<WebhookListEventsResponse> = listEvents(id, params, RequestOptions.none())

    /** @see listEvents */
    fun listEvents(
        id: String,
        params: WebhookListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListEventsResponse> =
        listEvents(params.toBuilder().id(id).build(), requestOptions)

    /** @see listEvents */
    fun listEvents(params: WebhookListEventsParams): CompletableFuture<WebhookListEventsResponse> =
        listEvents(params, RequestOptions.none())

    /** @see listEvents */
    fun listEvents(
        params: WebhookListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookListEventsResponse>

    /**
     * Generates a new signing secret for the specified webhook. The old secret is immediately
     * invalidated.
     */
    fun rotateSecret(id: String): CompletableFuture<WebhookRotateSecretResponse> =
        rotateSecret(id, WebhookRotateSecretParams.none())

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookRotateSecretResponse> =
        rotateSecret(params.toBuilder().id(id).build(), requestOptions)

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
    ): CompletableFuture<WebhookRotateSecretResponse> =
        rotateSecret(id, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookRotateSecretResponse>

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams
    ): CompletableFuture<WebhookRotateSecretResponse> = rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookRotateSecretResponse> =
        rotateSecret(id, WebhookRotateSecretParams.none(), requestOptions)

    /** Sends a test event to the specified webhook endpoint to verify connectivity. */
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
    fun toggleStatus(id: String): CompletableFuture<WebhookToggleStatusResponse> =
        toggleStatus(id, WebhookToggleStatusParams.none())

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookToggleStatusResponse> =
        toggleStatus(params.toBuilder().id(id).build(), requestOptions)

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
    ): CompletableFuture<WebhookToggleStatusResponse> =
        toggleStatus(id, params, RequestOptions.none())

    /** @see toggleStatus */
    fun toggleStatus(
        params: WebhookToggleStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WebhookToggleStatusResponse>

    /** @see toggleStatus */
    fun toggleStatus(
        params: WebhookToggleStatusParams
    ): CompletableFuture<WebhookToggleStatusResponse> = toggleStatus(params, RequestOptions.none())

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebhookToggleStatusResponse> =
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
        fun create(): CompletableFuture<HttpResponseFor<WebhookCreateResponse>> =
            create(WebhookCreateParams.none())

        /** @see create */
        fun create(
            params: WebhookCreateParams = WebhookCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookCreateResponse>>

        /** @see create */
        fun create(
            params: WebhookCreateParams = WebhookCreateParams.none()
        ): CompletableFuture<HttpResponseFor<WebhookCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WebhookCreateResponse>> =
            create(WebhookCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<WebhookRetrieveResponse>> =
            retrieve(id, WebhookRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: WebhookRetrieveParams
        ): CompletableFuture<HttpResponseFor<WebhookRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookRetrieveResponse>> =
            retrieve(id, WebhookRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<WebhookUpdateResponse>> =
            update(id, WebhookUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookUpdateResponse>>

        /** @see update */
        fun update(
            params: WebhookUpdateParams
        ): CompletableFuture<HttpResponseFor<WebhookUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookUpdateResponse>> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks`, but is otherwise the same as
         * [WebhookServiceAsync.list].
         */
        fun list(
            params: WebhookListParams
        ): CompletableFuture<HttpResponseFor<WebhookListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: WebhookListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListResponse>>

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
        fun listEvents(
            id: String,
            params: WebhookListEventsParams,
        ): CompletableFuture<HttpResponseFor<WebhookListEventsResponse>> =
            listEvents(id, params, RequestOptions.none())

        /** @see listEvents */
        fun listEvents(
            id: String,
            params: WebhookListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListEventsResponse>> =
            listEvents(params.toBuilder().id(id).build(), requestOptions)

        /** @see listEvents */
        fun listEvents(
            params: WebhookListEventsParams
        ): CompletableFuture<HttpResponseFor<WebhookListEventsResponse>> =
            listEvents(params, RequestOptions.none())

        /** @see listEvents */
        fun listEvents(
            params: WebhookListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookListEventsResponse>>

        /**
         * Returns a raw HTTP response for `post /v3/webhooks/{id}/rotate-secret`, but is otherwise
         * the same as [WebhookServiceAsync.rotateSecret].
         */
        fun rotateSecret(
            id: String
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(id, WebhookRotateSecretParams.none())

        /** @see rotateSecret */
        fun rotateSecret(
            id: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(params.toBuilder().id(id).build(), requestOptions)

        /** @see rotateSecret */
        fun rotateSecret(
            id: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(id, params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>>

        /** @see rotateSecret */
        fun rotateSecret(
            params: WebhookRotateSecretParams
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookRotateSecretResponse>> =
            rotateSecret(id, WebhookRotateSecretParams.none(), requestOptions)

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
        fun toggleStatus(
            id: String
        ): CompletableFuture<HttpResponseFor<WebhookToggleStatusResponse>> =
            toggleStatus(id, WebhookToggleStatusParams.none())

        /** @see toggleStatus */
        fun toggleStatus(
            id: String,
            params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookToggleStatusResponse>> =
            toggleStatus(params.toBuilder().id(id).build(), requestOptions)

        /** @see toggleStatus */
        fun toggleStatus(
            id: String,
            params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
        ): CompletableFuture<HttpResponseFor<WebhookToggleStatusResponse>> =
            toggleStatus(id, params, RequestOptions.none())

        /** @see toggleStatus */
        fun toggleStatus(
            params: WebhookToggleStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WebhookToggleStatusResponse>>

        /** @see toggleStatus */
        fun toggleStatus(
            params: WebhookToggleStatusParams
        ): CompletableFuture<HttpResponseFor<WebhookToggleStatusResponse>> =
            toggleStatus(params, RequestOptions.none())

        /** @see toggleStatus */
        fun toggleStatus(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WebhookToggleStatusResponse>> =
            toggleStatus(id, WebhookToggleStatusParams.none(), requestOptions)
    }
}
