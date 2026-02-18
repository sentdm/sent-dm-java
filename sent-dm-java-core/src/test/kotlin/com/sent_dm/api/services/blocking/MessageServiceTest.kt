// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.models.messages.MessageSendParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveActivities() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response = messageService.retrieveActivities("8ba7b830-9dad-11d1-80b4-00c04fd430c8")

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response = messageService.retrieveStatus("8ba7b830-9dad-11d1-80b4-00c04fd430c8")

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun send() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response =
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

        response.validate()
    }
}
