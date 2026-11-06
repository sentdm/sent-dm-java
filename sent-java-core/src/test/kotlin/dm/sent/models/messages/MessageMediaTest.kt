// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageMediaTest {

    @Test
    fun create() {
        val messageMedia =
            MessageMedia.builder()
                .mediaType("mediaType")
                .mimeType("mimeType")
                .sizeBytes(0L)
                .sourceHashSha256("sourceHashSha256")
                .url("url")
                .build()

        assertThat(messageMedia.mediaType()).contains("mediaType")
        assertThat(messageMedia.mimeType()).contains("mimeType")
        assertThat(messageMedia.sizeBytes()).contains(0L)
        assertThat(messageMedia.sourceHashSha256()).contains("sourceHashSha256")
        assertThat(messageMedia.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageMedia =
            MessageMedia.builder()
                .mediaType("mediaType")
                .mimeType("mimeType")
                .sizeBytes(0L)
                .sourceHashSha256("sourceHashSha256")
                .url("url")
                .build()

        val roundtrippedMessageMedia =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageMedia),
                jacksonTypeRef<MessageMedia>(),
            )

        assertThat(roundtrippedMessageMedia).isEqualTo(messageMedia)
    }
}
