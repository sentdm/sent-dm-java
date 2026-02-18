// File generated from our OpenAPI spec by Stainless.

package dm.sent.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import dm.sent.client.SentDmClient
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.core.http.Headers
import dm.sent.core.jsonMapper
import dm.sent.errors.BadRequestException
import dm.sent.errors.InternalServerException
import dm.sent.errors.NotFoundException
import dm.sent.errors.PermissionDeniedException
import dm.sent.errors.RateLimitException
import dm.sent.errors.SentDmException
import dm.sent.errors.UnauthorizedException
import dm.sent.errors.UnexpectedStatusCodeException
import dm.sent.errors.UnprocessableEntityException
import dm.sent.models.messages.MessageSendParams
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
                .build()
    }

    @Test
    fun messagesSend400() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend400WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend401() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend401WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend403() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend403WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend404() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend404WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend422() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend422WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend429() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend429WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend500() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend500WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend999() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSend999WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesSendInvalidJsonBody() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<SentDmException> {
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
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
