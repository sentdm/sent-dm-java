// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.models.messages.MessageSendQuickMessageParams
import com.sent_dm.api.models.messages.MessageSendToContactParams
import com.sent_dm.api.models.messages.MessageSendToPhoneParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val messageService = client.messages()

        val message = messageService.retrieve("7ba7b820-9dad-11d1-80b4-00c04fd430c8")

        message.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendQuickMessage() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val messageService = client.messages()

        messageService.sendQuickMessage(
            MessageSendQuickMessageParams.builder()
                .customMessage("Hello, this is a test message!")
                .phoneNumber("+1234567890")
                .build()
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendToContact() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val messageService = client.messages()

        messageService.sendToContact(
            MessageSendToContactParams.builder()
                .contactId("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .templateVariables(
                    MessageSendToContactParams.TemplateVariables.builder()
                        .putAdditionalProperty("name", JsonValue.from("John Doe"))
                        .putAdditionalProperty("order_id", JsonValue.from("12345"))
                        .build()
                )
                .build()
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendToPhone() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val messageService = client.messages()

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
}
