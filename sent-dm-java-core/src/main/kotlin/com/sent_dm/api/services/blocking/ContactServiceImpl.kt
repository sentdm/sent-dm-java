// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

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
import com.sent_dm.api.core.prepare
import com.sent_dm.api.models.contacts.ContactListItem
import com.sent_dm.api.models.contacts.ContactListParams
import com.sent_dm.api.models.contacts.ContactListResponse
import com.sent_dm.api.models.contacts.ContactRetrieveByPhoneParams
import com.sent_dm.api.models.contacts.ContactRetrieveIdParams
import java.util.function.Consumer

class ContactServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ContactService {

    private val withRawResponse: ContactService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContactService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContactService =
        ContactServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: ContactListParams,
        requestOptions: RequestOptions,
    ): ContactListResponse =
        // get /v2/contacts
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveByPhone(
        params: ContactRetrieveByPhoneParams,
        requestOptions: RequestOptions,
    ): ContactListItem =
        // get /v2/contacts/phone
        withRawResponse().retrieveByPhone(params, requestOptions).parse()

    override fun retrieveId(
        params: ContactRetrieveIdParams,
        requestOptions: RequestOptions,
    ): ContactListItem =
        // get /v2/contacts/id
        withRawResponse().retrieveId(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContactService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContactService.WithRawResponse =
            ContactServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ContactListResponse> =
            jsonHandler<ContactListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ContactListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "contacts")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveByPhoneHandler: Handler<ContactListItem> =
            jsonHandler<ContactListItem>(clientOptions.jsonMapper)

        override fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactListItem> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "contacts", "phone")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveByPhoneHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveIdHandler: Handler<ContactListItem> =
            jsonHandler<ContactListItem>(clientOptions.jsonMapper)

        override fun retrieveId(
            params: ContactRetrieveIdParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactListItem> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "contacts", "id")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
