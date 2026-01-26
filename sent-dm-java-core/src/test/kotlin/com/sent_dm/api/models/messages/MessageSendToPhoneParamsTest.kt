// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendToPhoneParamsTest {

    @Test
    fun create() {
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
            .build()
    }

    @Test
    fun headers() {
        val params =
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
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("x-api-key", "")
                    .put("x-sender-id", "00000000-0000-0000-0000-000000000000")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            MessageSendToPhoneParams.builder()
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .phoneNumber("+1234567890")
                .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("x-api-key", "")
                    .put("x-sender-id", "00000000-0000-0000-0000-000000000000")
                    .build()
            )
    }

    @Test
    fun body() {
        val params =
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
                .build()

        val body = params._body()

        assertThat(body.phoneNumber()).isEqualTo("+1234567890")
        assertThat(body.templateId()).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
        assertThat(body.templateVariables())
            .contains(
                MessageSendToPhoneParams.TemplateVariables.builder()
                    .putAdditionalProperty("name", JsonValue.from("John Doe"))
                    .putAdditionalProperty("order_id", JsonValue.from("12345"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageSendToPhoneParams.builder()
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .phoneNumber("+1234567890")
                .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .build()

        val body = params._body()

        assertThat(body.phoneNumber()).isEqualTo("+1234567890")
        assertThat(body.templateId()).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
    }
}
