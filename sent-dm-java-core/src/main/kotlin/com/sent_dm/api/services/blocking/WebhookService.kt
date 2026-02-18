// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface WebhookService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService

    /** Creates a new webhook endpoint for the authenticated customer. */
    fun create(): ApiResponseWebhook = create(WebhookCreateParams.none())

    /** @see create */
    fun create(
        params: WebhookCreateParams = WebhookCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook

    /** @see create */
    fun create(params: WebhookCreateParams = WebhookCreateParams.none()): ApiResponseWebhook =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiResponseWebhook =
        create(WebhookCreateParams.none(), requestOptions)

    /** Retrieves a single webhook by ID for the authenticated customer. */
    fun retrieve(id: String): ApiResponseWebhook = retrieve(id, WebhookRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
    ): ApiResponseWebhook = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook

    /** @see retrieve */
    fun retrieve(params: WebhookRetrieveParams): ApiResponseWebhook =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ApiResponseWebhook =
        retrieve(id, WebhookRetrieveParams.none(), requestOptions)

    /** Updates an existing webhook for the authenticated customer. */
    fun update(id: String): ApiResponseWebhook = update(id, WebhookUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: WebhookUpdateParams = WebhookUpdateParams.none(),
    ): ApiResponseWebhook = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook

    /** @see update */
    fun update(params: WebhookUpdateParams): ApiResponseWebhook =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): ApiResponseWebhook =
        update(id, WebhookUpdateParams.none(), requestOptions)

    /** Retrieves a paginated list of webhooks for the authenticated customer. */
    fun list(params: WebhookListParams): WebhookListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: WebhookListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListResponse

    /** Deletes a webhook for the authenticated customer. */
    fun delete(id: String) = delete(id, WebhookDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: WebhookDeleteParams = WebhookDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: WebhookDeleteParams = WebhookDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: WebhookDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: WebhookDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, WebhookDeleteParams.none(), requestOptions)

    /** Retrieves all available webhook event types that can be subscribed to. */
    fun listEventTypes(): WebhookListEventTypesResponse =
        listEventTypes(WebhookListEventTypesParams.none())

    /** @see listEventTypes */
    fun listEventTypes(
        params: WebhookListEventTypesParams = WebhookListEventTypesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListEventTypesResponse

    /** @see listEventTypes */
    fun listEventTypes(
        params: WebhookListEventTypesParams = WebhookListEventTypesParams.none()
    ): WebhookListEventTypesResponse = listEventTypes(params, RequestOptions.none())

    /** @see listEventTypes */
    fun listEventTypes(requestOptions: RequestOptions): WebhookListEventTypesResponse =
        listEventTypes(WebhookListEventTypesParams.none(), requestOptions)

    /** Retrieves a paginated list of delivery events for the specified webhook. */
    fun listEvents(id: String, params: WebhookListEventsParams): WebhookListEventsResponse =
        listEvents(id, params, RequestOptions.none())

    /** @see listEvents */
    fun listEvents(
        id: String,
        params: WebhookListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListEventsResponse = listEvents(params.toBuilder().id(id).build(), requestOptions)

    /** @see listEvents */
    fun listEvents(params: WebhookListEventsParams): WebhookListEventsResponse =
        listEvents(params, RequestOptions.none())

    /** @see listEvents */
    fun listEvents(
        params: WebhookListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookListEventsResponse

    /**
     * Generates a new signing secret for the specified webhook. The old secret is immediately
     * invalidated.
     */
    fun rotateSecret(id: String): WebhookRotateSecretResponse =
        rotateSecret(id, WebhookRotateSecretParams.none())

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookRotateSecretResponse = rotateSecret(params.toBuilder().id(id).build(), requestOptions)

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
    ): WebhookRotateSecretResponse = rotateSecret(id, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookRotateSecretResponse

    /** @see rotateSecret */
    fun rotateSecret(params: WebhookRotateSecretParams): WebhookRotateSecretResponse =
        rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(id: String, requestOptions: RequestOptions): WebhookRotateSecretResponse =
        rotateSecret(id, WebhookRotateSecretParams.none(), requestOptions)

    /** Sends a test event to the specified webhook endpoint to verify connectivity. */
    fun test(id: String): WebhookTestResponse = test(id, WebhookTestParams.none())

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookTestResponse = test(params.toBuilder().id(id).build(), requestOptions)

    /** @see test */
    fun test(
        id: String,
        params: WebhookTestParams = WebhookTestParams.none(),
    ): WebhookTestResponse = test(id, params, RequestOptions.none())

    /** @see test */
    fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookTestResponse

    /** @see test */
    fun test(params: WebhookTestParams): WebhookTestResponse = test(params, RequestOptions.none())

    /** @see test */
    fun test(id: String, requestOptions: RequestOptions): WebhookTestResponse =
        test(id, WebhookTestParams.none(), requestOptions)

    /** Activates or deactivates a webhook for the authenticated customer. */
    fun toggleStatus(id: String): ApiResponseWebhook =
        toggleStatus(id, WebhookToggleStatusParams.none())

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook = toggleStatus(params.toBuilder().id(id).build(), requestOptions)

    /** @see toggleStatus */
    fun toggleStatus(
        id: String,
        params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
    ): ApiResponseWebhook = toggleStatus(id, params, RequestOptions.none())

    /** @see toggleStatus */
    fun toggleStatus(
        params: WebhookToggleStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseWebhook

    /** @see toggleStatus */
    fun toggleStatus(params: WebhookToggleStatusParams): ApiResponseWebhook =
        toggleStatus(params, RequestOptions.none())

    /** @see toggleStatus */
    fun toggleStatus(id: String, requestOptions: RequestOptions): ApiResponseWebhook =
        toggleStatus(id, WebhookToggleStatusParams.none(), requestOptions)

    /** A view of [WebhookService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/webhooks`, but is otherwise the same as
         * [WebhookService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ApiResponseWebhook> = create(WebhookCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: WebhookCreateParams = WebhookCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook>

        /** @see create */
        @MustBeClosed
        fun create(
            params: WebhookCreateParams = WebhookCreateParams.none()
        ): HttpResponseFor<ApiResponseWebhook> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiResponseWebhook> =
            create(WebhookCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ApiResponseWebhook> =
            retrieve(id, WebhookRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: WebhookRetrieveParams = WebhookRetrieveParams.none(),
        ): HttpResponseFor<ApiResponseWebhook> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: WebhookRetrieveParams): HttpResponseFor<ApiResponseWebhook> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> =
            retrieve(id, WebhookRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<ApiResponseWebhook> =
            update(id, WebhookUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: WebhookUpdateParams = WebhookUpdateParams.none(),
        ): HttpResponseFor<ApiResponseWebhook> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook>

        /** @see update */
        @MustBeClosed
        fun update(params: WebhookUpdateParams): HttpResponseFor<ApiResponseWebhook> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> =
            update(id, WebhookUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks`, but is otherwise the same as
         * [WebhookService.list].
         */
        @MustBeClosed
        fun list(params: WebhookListParams): HttpResponseFor<WebhookListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: WebhookListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListResponse>

        /**
         * Returns a raw HTTP response for `delete /v3/webhooks/{id}`, but is otherwise the same as
         * [WebhookService.delete].
         */
        @MustBeClosed fun delete(id: String): HttpResponse = delete(id, WebhookDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: WebhookDeleteParams = WebhookDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: WebhookDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, WebhookDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/event-types`, but is otherwise the same
         * as [WebhookService.listEventTypes].
         */
        @MustBeClosed
        fun listEventTypes(): HttpResponseFor<WebhookListEventTypesResponse> =
            listEventTypes(WebhookListEventTypesParams.none())

        /** @see listEventTypes */
        @MustBeClosed
        fun listEventTypes(
            params: WebhookListEventTypesParams = WebhookListEventTypesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListEventTypesResponse>

        /** @see listEventTypes */
        @MustBeClosed
        fun listEventTypes(
            params: WebhookListEventTypesParams = WebhookListEventTypesParams.none()
        ): HttpResponseFor<WebhookListEventTypesResponse> =
            listEventTypes(params, RequestOptions.none())

        /** @see listEventTypes */
        @MustBeClosed
        fun listEventTypes(
            requestOptions: RequestOptions
        ): HttpResponseFor<WebhookListEventTypesResponse> =
            listEventTypes(WebhookListEventTypesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/webhooks/{id}/events`, but is otherwise the same
         * as [WebhookService.listEvents].
         */
        @MustBeClosed
        fun listEvents(
            id: String,
            params: WebhookListEventsParams,
        ): HttpResponseFor<WebhookListEventsResponse> =
            listEvents(id, params, RequestOptions.none())

        /** @see listEvents */
        @MustBeClosed
        fun listEvents(
            id: String,
            params: WebhookListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListEventsResponse> =
            listEvents(params.toBuilder().id(id).build(), requestOptions)

        /** @see listEvents */
        @MustBeClosed
        fun listEvents(
            params: WebhookListEventsParams
        ): HttpResponseFor<WebhookListEventsResponse> = listEvents(params, RequestOptions.none())

        /** @see listEvents */
        @MustBeClosed
        fun listEvents(
            params: WebhookListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookListEventsResponse>

        /**
         * Returns a raw HTTP response for `post /v3/webhooks/{id}/rotate-secret`, but is otherwise
         * the same as [WebhookService.rotateSecret].
         */
        @MustBeClosed
        fun rotateSecret(id: String): HttpResponseFor<WebhookRotateSecretResponse> =
            rotateSecret(id, WebhookRotateSecretParams.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            id: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookRotateSecretResponse> =
            rotateSecret(params.toBuilder().id(id).build(), requestOptions)

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            id: String,
            params: WebhookRotateSecretParams = WebhookRotateSecretParams.none(),
        ): HttpResponseFor<WebhookRotateSecretResponse> =
            rotateSecret(id, params, RequestOptions.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookRotateSecretResponse>

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            params: WebhookRotateSecretParams
        ): HttpResponseFor<WebhookRotateSecretResponse> =
            rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookRotateSecretResponse> =
            rotateSecret(id, WebhookRotateSecretParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/webhooks/{id}/test`, but is otherwise the same
         * as [WebhookService.test].
         */
        @MustBeClosed
        fun test(id: String): HttpResponseFor<WebhookTestResponse> =
            test(id, WebhookTestParams.none())

        /** @see test */
        @MustBeClosed
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookTestResponse> =
            test(params.toBuilder().id(id).build(), requestOptions)

        /** @see test */
        @MustBeClosed
        fun test(
            id: String,
            params: WebhookTestParams = WebhookTestParams.none(),
        ): HttpResponseFor<WebhookTestResponse> = test(id, params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookTestResponse>

        /** @see test */
        @MustBeClosed
        fun test(params: WebhookTestParams): HttpResponseFor<WebhookTestResponse> =
            test(params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(id: String, requestOptions: RequestOptions): HttpResponseFor<WebhookTestResponse> =
            test(id, WebhookTestParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/webhooks/{id}/toggle-status`, but is otherwise
         * the same as [WebhookService.toggleStatus].
         */
        @MustBeClosed
        fun toggleStatus(id: String): HttpResponseFor<ApiResponseWebhook> =
            toggleStatus(id, WebhookToggleStatusParams.none())

        /** @see toggleStatus */
        @MustBeClosed
        fun toggleStatus(
            id: String,
            params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook> =
            toggleStatus(params.toBuilder().id(id).build(), requestOptions)

        /** @see toggleStatus */
        @MustBeClosed
        fun toggleStatus(
            id: String,
            params: WebhookToggleStatusParams = WebhookToggleStatusParams.none(),
        ): HttpResponseFor<ApiResponseWebhook> = toggleStatus(id, params, RequestOptions.none())

        /** @see toggleStatus */
        @MustBeClosed
        fun toggleStatus(
            params: WebhookToggleStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseWebhook>

        /** @see toggleStatus */
        @MustBeClosed
        fun toggleStatus(params: WebhookToggleStatusParams): HttpResponseFor<ApiResponseWebhook> =
            toggleStatus(params, RequestOptions.none())

        /** @see toggleStatus */
        @MustBeClosed
        fun toggleStatus(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> =
            toggleStatus(id, WebhookToggleStatusParams.none(), requestOptions)
    }
}
