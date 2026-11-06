// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.models.messages.MessageCancelParams
import dm.sent.models.messages.MessageResendParams
import dm.sent.models.messages.MessageRetrieveActivitiesParams
import dm.sent.models.messages.MessageRetrieveStatusParams
import dm.sent.models.messages.MessageSendParams
import dm.sent.models.templates.TemplateRef
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MessageServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun cancel() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val messageService = client.messages()

        val apiResponseOfCancelledMessage =
            messageService.cancel(
                MessageCancelParams.builder()
                    .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        apiResponseOfCancelledMessage.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun resend() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val messageService = client.messages()

        val messageSendResponse =
            messageService.resend(
                MessageResendParams.builder()
                    .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        messageSendResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveActivities() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val messageService = client.messages()

        val apiResponseOfMessageActivities =
            messageService.retrieveActivities(
                MessageRetrieveActivitiesParams.builder()
                    .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfMessageActivities.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveStatus() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val messageService = client.messages()

        val apiResponseOfMessage =
            messageService.retrieveStatus(
                MessageRetrieveStatusParams.builder()
                    .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfMessage.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun send() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val messageService = client.messages()

        val messageSendResponse =
            messageService.send(
                MessageSendParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .addChannel("sms")
                    .addChannel("whatsapp")
                    .channels(
                        MessageSendParams.Channels.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    listOf(
                                        mapOf(
                                            "country" to "country",
                                            "from" to listOf("string"),
                                            "strategy" to "strategy",
                                        )
                                    )
                                ),
                            )
                            .build()
                    )
                    .addMediaUrl("string")
                    .scheduledAt(null)
                    .subject(null)
                    .template(
                        TemplateRef.builder()
                            .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                            .name("order_confirmation")
                            .parameters(
                                TemplateRef.Parameters.builder()
                                    .putAdditionalProperty("name", JsonValue.from("John Doe"))
                                    .putAdditionalProperty("order_id", JsonValue.from("12345"))
                                    .build()
                            )
                            .build()
                    )
                    .text(null)
                    .addTo("+14155551234")
                    .addTo("+14155555678")
                    .build()
            )

        messageSendResponse.validate()
    }
}
