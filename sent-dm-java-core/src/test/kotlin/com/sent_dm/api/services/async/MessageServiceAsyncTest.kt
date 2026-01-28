// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClientAsync
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.models.messages.MessageSendQuickMessageParams
import com.sent_dm.api.models.messages.MessageSendToContactParams
import com.sent_dm.api.models.messages.MessageSendToPhoneParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val messageServiceAsync = client.messages()

        val messageFuture = messageServiceAsync.retrieve("7ba7b820-9dad-11d1-80b4-00c04fd430c8")

        val message = messageFuture.get()
        message.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendQuickMessage() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val messageServiceAsync = client.messages()

        val future =
            messageServiceAsync.sendQuickMessage(
                MessageSendQuickMessageParams.builder()
                    .customMessage("Hello, this is a test message!")
                    .phoneNumber("+1234567890")
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendToContact() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val messageServiceAsync = client.messages()

        val future =
            messageServiceAsync.sendToContact(
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

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun sendToPhone() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val messageServiceAsync = client.messages()

        val future =
            messageServiceAsync.sendToPhone(
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

        val response = future.get()
    }
}
