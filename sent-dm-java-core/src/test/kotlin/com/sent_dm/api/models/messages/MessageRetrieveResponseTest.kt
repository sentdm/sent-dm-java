// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRetrieveResponseTest {

    @Test
    fun create() {
        val messageRetrieveResponse =
            MessageRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channel("channel")
                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .correctedPrice(0.0)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addEvent(
                    MessageRetrieveResponse.Event.builder()
                        .description("description")
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .messageBody(
                    MessageRetrieveResponse.MessageBody.builder()
                        .addButton(
                            MessageRetrieveResponse.MessageBody.Button.builder()
                                .type("type")
                                .value("value")
                                .build()
                        )
                        .content("content")
                        .footer("footer")
                        .header("header")
                        .build()
                )
                .phoneNumber("phoneNumber")
                .phoneNumberInternational("phoneNumberInternational")
                .regionCode("regionCode")
                .status("status")
                .templateCategory("templateCategory")
                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .templateName("templateName")
                .build()

        assertThat(messageRetrieveResponse.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageRetrieveResponse.channel()).contains("channel")
        assertThat(messageRetrieveResponse.contactId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageRetrieveResponse.correctedPrice()).contains(0.0)
        assertThat(messageRetrieveResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(messageRetrieveResponse.customerId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageRetrieveResponse.events().getOrNull())
            .containsExactly(
                MessageRetrieveResponse.Event.builder()
                    .description("description")
                    .status("status")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(messageRetrieveResponse.messageBody())
            .contains(
                MessageRetrieveResponse.MessageBody.builder()
                    .addButton(
                        MessageRetrieveResponse.MessageBody.Button.builder()
                            .type("type")
                            .value("value")
                            .build()
                    )
                    .content("content")
                    .footer("footer")
                    .header("header")
                    .build()
            )
        assertThat(messageRetrieveResponse.phoneNumber()).contains("phoneNumber")
        assertThat(messageRetrieveResponse.phoneNumberInternational())
            .contains("phoneNumberInternational")
        assertThat(messageRetrieveResponse.regionCode()).contains("regionCode")
        assertThat(messageRetrieveResponse.status()).contains("status")
        assertThat(messageRetrieveResponse.templateCategory()).contains("templateCategory")
        assertThat(messageRetrieveResponse.templateId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageRetrieveResponse.templateName()).contains("templateName")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageRetrieveResponse =
            MessageRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channel("channel")
                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .correctedPrice(0.0)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addEvent(
                    MessageRetrieveResponse.Event.builder()
                        .description("description")
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .messageBody(
                    MessageRetrieveResponse.MessageBody.builder()
                        .addButton(
                            MessageRetrieveResponse.MessageBody.Button.builder()
                                .type("type")
                                .value("value")
                                .build()
                        )
                        .content("content")
                        .footer("footer")
                        .header("header")
                        .build()
                )
                .phoneNumber("phoneNumber")
                .phoneNumberInternational("phoneNumberInternational")
                .regionCode("regionCode")
                .status("status")
                .templateCategory("templateCategory")
                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .templateName("templateName")
                .build()

        val roundtrippedMessageRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRetrieveResponse),
                jacksonTypeRef<MessageRetrieveResponse>(),
            )

        assertThat(roundtrippedMessageRetrieveResponse).isEqualTo(messageRetrieveResponse)
    }
}
