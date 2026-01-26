// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.handlers.errorBodyHandler
import com.sent_dm.api.core.handlers.errorHandler
import com.sent_dm.api.core.handlers.jsonHandler
import com.sent_dm.api.core.http.HttpMethod
import com.sent_dm.api.core.http.HttpRequest
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponse.Handler
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepareAsync
import com.sent_dm.api.models.contacts.ContactListItem
import com.sent_dm.api.models.contacts.ContactListParams
import com.sent_dm.api.models.contacts.ContactListResponse
import com.sent_dm.api.models.contacts.ContactRetrieveByPhoneParams
import com.sent_dm.api.models.contacts.ContactRetrieveIdParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ContactServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ContactServiceAsync {

    private val withRawResponse: ContactServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContactServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContactServiceAsync =
        ContactServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: ContactListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContactListResponse> =
        // get /v2/contacts
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun retrieveByPhone(
        params: ContactRetrieveByPhoneParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContactListItem> =
        // get /v2/contacts/phone
        withRawResponse().retrieveByPhone(params, requestOptions).thenApply { it.parse() }

    override fun retrieveId(
        params: ContactRetrieveIdParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContactListItem> =
        // get /v2/contacts/id
        withRawResponse().retrieveId(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContactServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContactServiceAsync.WithRawResponse =
            ContactServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ContactListResponse> =
            jsonHandler<ContactListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ContactListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContactListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "contacts")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveByPhoneHandler: Handler<ContactListItem> =
            jsonHandler<ContactListItem>(clientOptions.jsonMapper)

        override fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContactListItem>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "contacts", "phone")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveByPhoneHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveIdHandler: Handler<ContactListItem> =
            jsonHandler<ContactListItem>(clientOptions.jsonMapper)

        override fun retrieveId(
            params: ContactRetrieveIdParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContactListItem>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "contacts", "id")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveIdHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
