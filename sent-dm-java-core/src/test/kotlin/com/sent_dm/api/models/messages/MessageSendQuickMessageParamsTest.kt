// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendQuickMessageParamsTest {

    @Test
    fun create() {
        MessageSendQuickMessageParams.builder()
            .customMessage("Hello, this is a test message!")
            .phoneNumber("+1234567890")
            .build()
    }

    @Test
    fun body() {
        val params =
            MessageSendQuickMessageParams.builder()
                .customMessage("Hello, this is a test message!")
                .phoneNumber("+1234567890")
                .build()

        val body = params._body()

        assertThat(body.customMessage()).isEqualTo("Hello, this is a test message!")
        assertThat(body.phoneNumber()).isEqualTo("+1234567890")
    }
}
