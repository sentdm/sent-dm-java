// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundMediaTest {

    @Test
    fun create() {
        val inboundMedia =
            InboundMedia.builder()
                .hashSha256("hash_sha256")
                .mimeType("mime_type")
                .sizeBytes(0L)
                .url("url")
                .build()

        assertThat(inboundMedia.hashSha256()).contains("hash_sha256")
        assertThat(inboundMedia.mimeType()).contains("mime_type")
        assertThat(inboundMedia.sizeBytes()).contains(0L)
        assertThat(inboundMedia.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundMedia =
            InboundMedia.builder()
                .hashSha256("hash_sha256")
                .mimeType("mime_type")
                .sizeBytes(0L)
                .url("url")
                .build()

        val roundtrippedInboundMedia =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundMedia),
                jacksonTypeRef<InboundMedia>(),
            )

        assertThat(roundtrippedInboundMedia).isEqualTo(inboundMedia)
    }
}
