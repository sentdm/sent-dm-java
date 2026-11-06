// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SuppliedDocumentTest {

    @Test
    fun create() {
        val suppliedDocument =
            SuppliedDocument.builder()
                .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .fileName("file_name")
                .key("key")
                .build()

        assertThat(suppliedDocument.documentId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(suppliedDocument.fileName()).contains("file_name")
        assertThat(suppliedDocument.key()).contains("key")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val suppliedDocument =
            SuppliedDocument.builder()
                .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .fileName("file_name")
                .key("key")
                .build()

        val roundtrippedSuppliedDocument =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(suppliedDocument),
                jacksonTypeRef<SuppliedDocument>(),
            )

        assertThat(roundtrippedSuppliedDocument).isEqualTo(suppliedDocument)
    }
}
