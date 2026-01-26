// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.sent_dm.api.client.SentDmClient
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.models.templates.TemplateDeleteParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: SentDmClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            SentDmOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val templateService = client.templates()
        stubFor(delete(anyUrl()).willReturn(ok("{}")))

        templateService.delete(
            TemplateDeleteParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            deleteRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
