// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.catalogue

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCatalogueVoiceTest {

    @Test
    fun create() {
        val voiceCatalogueVoice =
            VoiceCatalogueVoice.builder()
                .default_(true)
                .description("description")
                .language("language")
                .name("name")
                .build()

        assertThat(voiceCatalogueVoice.default_()).contains(true)
        assertThat(voiceCatalogueVoice.description()).contains("description")
        assertThat(voiceCatalogueVoice.language()).contains("language")
        assertThat(voiceCatalogueVoice.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceCatalogueVoice =
            VoiceCatalogueVoice.builder()
                .default_(true)
                .description("description")
                .language("language")
                .name("name")
                .build()

        val roundtrippedVoiceCatalogueVoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceCatalogueVoice),
                jacksonTypeRef<VoiceCatalogueVoice>(),
            )

        assertThat(roundtrippedVoiceCatalogueVoice).isEqualTo(voiceCatalogueVoice)
    }
}
