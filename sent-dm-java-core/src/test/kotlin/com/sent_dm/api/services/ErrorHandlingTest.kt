// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.sent_dm.api.client.SentDmClient
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.errors.BadRequestException
import com.sent_dm.api.errors.InternalServerException
import com.sent_dm.api.errors.NotFoundException
import com.sent_dm.api.errors.PermissionDeniedException
import com.sent_dm.api.errors.RateLimitException
import com.sent_dm.api.errors.UnauthorizedException
import com.sent_dm.api.errors.UnexpectedStatusCodeException
import com.sent_dm.api.errors.UnprocessableEntityException
import com.sent_dm.api.models.messages.MessageSendToPhoneParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

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

    @Test
    fun messagesSendToPhone400() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone400WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone401() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone401WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone403() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone403WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone404() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone404WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone422() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone422WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone429() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone429WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone500() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone500WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone999() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendToPhone999WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                messageService.sendToPhone(
                    MessageSendToPhoneParams.builder()
                        .phoneNumber("+1234567890")
                        .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                        .templateVariables(
                            MessageSendToPhoneParams.TemplateVariables.builder()
                                .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
