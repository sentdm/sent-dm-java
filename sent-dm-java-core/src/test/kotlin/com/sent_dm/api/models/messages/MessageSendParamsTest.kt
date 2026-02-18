// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun headers() {
        val params =
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

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = MessageSendParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.channel().getOrNull()).containsExactly("sms", "whatsapp")
        assertThat(body.template())
            .contains(
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
        assertThat(body.to().getOrNull()).containsExactly("+14155551234", "+14155555678")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MessageSendParams.builder().build()

        val body = params._body()
    }
}
