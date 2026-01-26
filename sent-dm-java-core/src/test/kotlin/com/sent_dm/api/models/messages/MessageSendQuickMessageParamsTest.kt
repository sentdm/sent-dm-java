// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendQuickMessageParamsTest {

    @Test
    fun create() {
        MessageSendQuickMessageParams.builder()
            .xApiKey("")
            .xSenderId("00000000-0000-0000-0000-000000000000")
            .customMessage("Hello, this is a test message!")
            .phoneNumber("+1234567890")
            .build()
    }

    @Test
    fun headers() {
        val params =
            MessageSendQuickMessageParams.builder()
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .customMessage("Hello, this is a test message!")
                .phoneNumber("+1234567890")
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
            MessageSendQuickMessageParams.builder()
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .customMessage("Hello, this is a test message!")
                .phoneNumber("+1234567890")
                .build()

        val body = params._body()

        assertThat(body.customMessage()).isEqualTo("Hello, this is a test message!")
        assertThat(body.phoneNumber()).isEqualTo("+1234567890")
    }
}
