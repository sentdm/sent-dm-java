// File generated from our OpenAPI spec by Stainless.

package dm.sent.services

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
import dm.sent.client.SentDmClient
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.models.messages.MessageSendParams
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
                .build()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun send() {
        val messageService = client.messages()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        messageService.send(
            MessageSendParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .addChannel("sms")
                .addChannel("whatsapp")
                .template(
                    MessageSendParams.Template.builder()
                        .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .name("order_confirmation")
                        .parameters(
                            MessageSendParams.Template.Parameters.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
                .addTo("+14155551234")
                .addTo("+14155555678")
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
