// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.webhooks.ApiResponseWebhook
import com.sent_dm.api.models.webhooks.WebhookCreateParams
import com.sent_dm.api.models.webhooks.WebhookDeleteParams
import com.sent_dm.api.models.webhooks.WebhookListEventTypesParams
import com.sent_dm.api.models.webhooks.WebhookListEventTypesResponse
import com.sent_dm.api.models.webhooks.WebhookListEventsParams
import com.sent_dm.api.models.webhooks.WebhookListEventsResponse
import com.sent_dm.api.models.webhooks.WebhookListParams
import com.sent_dm.api.models.webhooks.WebhookListResponse
import com.sent_dm.api.models.webhooks.WebhookRetrieveParams
import com.sent_dm.api.models.webhooks.WebhookRotateSecretParams
import com.sent_dm.api.models.webhooks.WebhookRotateSecretResponse
import com.sent_dm.api.models.webhooks.WebhookTestParams
import com.sent_dm.api.models.webhooks.WebhookTestResponse
import com.sent_dm.api.models.webhooks.WebhookToggleStatusParams
import com.sent_dm.api.models.webhooks.WebhookUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

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

    /** Retrieves a single webhook by ID for the authenticated customer. */
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

    /** Updates an existing webhook for the authenticated customer. */
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
