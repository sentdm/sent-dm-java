// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import dm.sent.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendToPhoneParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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
                .phoneNumber("+1234567890")
                .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .build()

        val body = params._body()

        assertThat(body.phoneNumber()).isEqualTo("+1234567890")
        assertThat(body.templateId()).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
    }
}
