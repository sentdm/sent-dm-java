// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.sent_dm.api.client.SentDmClient
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.models.messages.MessageSendToPhoneParams
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
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendToPhone() {
        val messageService = client.messages()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        messageService.sendToPhone(
            MessageSendToPhoneParams.builder()
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .phoneNumber("+1234567890")
                .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .templateVariables(
                    MessageSendToPhoneParams.TemplateVariables.builder()
                        .putAdditionalProperty("name", JsonValue.from("John Doe"))
                        .putAdditionalProperty("order_id", JsonValue.from("12345"))
                        .build()
                )
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
