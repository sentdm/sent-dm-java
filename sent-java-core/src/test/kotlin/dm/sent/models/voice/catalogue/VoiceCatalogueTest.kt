// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.catalogue

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCatalogueTest {

    @Test
    fun create() {
        val voiceCatalogue =
            VoiceCatalogue.builder()
                .addLanguage("string")
                .addVoice(
                    VoiceCatalogueVoice.builder()
                        .default_(true)
                        .description("description")
                        .language("language")
                        .name("name")
                        .build()
                )
                .build()

        assertThat(voiceCatalogue.languages().getOrNull()).containsExactly("string")
        assertThat(voiceCatalogue.voices().getOrNull())
            .containsExactly(
                VoiceCatalogueVoice.builder()
                    .default_(true)
                    .description("description")
                    .language("language")
                    .name("name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceCatalogue =
            VoiceCatalogue.builder()
                .addLanguage("string")
                .addVoice(
                    VoiceCatalogueVoice.builder()
                        .default_(true)
                        .description("description")
                        .language("language")
                        .name("name")
                        .build()
                )
                .build()

        val roundtrippedVoiceCatalogue =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceCatalogue),
                jacksonTypeRef<VoiceCatalogue>(),
            )

        assertThat(roundtrippedVoiceCatalogue).isEqualTo(voiceCatalogue)
    }
}
