// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.core.JsonValue
import dm.sent.models.messages.MessageSendParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MessageServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveActivities() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.retrieveActivities("8ba7b830-9dad-11d1-80b4-00c04fd430c8")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.retrieveStatus("8ba7b830-9dad-11d1-80b4-00c04fd430c8")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun send() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.send(
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

        val response = responseFuture.get()
        response.validate()
    }
}
