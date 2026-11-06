// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageBodyTest {

    @Test
    fun create() {
        val messageBody =
            MessageBody.builder()
                .addButton(
                    MessageButton.builder()
                        .postbackData("postbackData")
                        .text("text")
                        .type("type")
                        .value("value")
                        .build()
                )
                .content("content")
                .footer("footer")
                .header("header")
                .headerMedia(MessageHeaderMedia.builder().type("type").url("url").build())
                .addMedia(
                    MessageMedia.builder()
                        .mediaType("mediaType")
                        .mimeType("mimeType")
                        .sizeBytes(0L)
                        .sourceHashSha256("sourceHashSha256")
                        .url("url")
                        .build()
                )
                .subject("subject")
                .build()

        assertThat(messageBody.buttons().getOrNull())
            .containsExactly(
                MessageButton.builder()
                    .postbackData("postbackData")
                    .text("text")
                    .type("type")
                    .value("value")
                    .build()
            )
        assertThat(messageBody.content()).contains("content")
        assertThat(messageBody.footer()).contains("footer")
        assertThat(messageBody.header()).contains("header")
        assertThat(messageBody.headerMedia())
            .contains(MessageHeaderMedia.builder().type("type").url("url").build())
        assertThat(messageBody.media().getOrNull())
            .containsExactly(
                MessageMedia.builder()
                    .mediaType("mediaType")
                    .mimeType("mimeType")
                    .sizeBytes(0L)
                    .sourceHashSha256("sourceHashSha256")
                    .url("url")
                    .build()
            )
        assertThat(messageBody.subject()).contains("subject")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageBody =
            MessageBody.builder()
                .addButton(
                    MessageButton.builder()
                        .postbackData("postbackData")
                        .text("text")
                        .type("type")
                        .value("value")
                        .build()
                )
                .content("content")
                .footer("footer")
                .header("header")
                .headerMedia(MessageHeaderMedia.builder().type("type").url("url").build())
                .addMedia(
                    MessageMedia.builder()
                        .mediaType("mediaType")
                        .mimeType("mimeType")
                        .sizeBytes(0L)
                        .sourceHashSha256("sourceHashSha256")
                        .url("url")
                        .build()
                )
                .subject("subject")
                .build()

        val roundtrippedMessageBody =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageBody),
                jacksonTypeRef<MessageBody>(),
            )

        assertThat(roundtrippedMessageBody).isEqualTo(messageBody)
    }
}
