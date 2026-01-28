// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import dm.sent.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendToContactParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.contactId()).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        assertThat(body.templateId()).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
        assertThat(body.templateVariables())
            .contains(
                MessageSendToContactParams.TemplateVariables.builder()
                    .putAdditionalProperty("name", JsonValue.from("John Doe"))
                    .putAdditionalProperty("order_id", JsonValue.from("12345"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageSendToContactParams.builder()
                .contactId("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .templateId("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .build()

        val body = params._body()

        assertThat(body.contactId()).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        assertThat(body.templateId()).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
    }
}
