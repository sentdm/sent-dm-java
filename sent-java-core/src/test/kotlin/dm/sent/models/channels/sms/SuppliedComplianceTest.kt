// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SuppliedComplianceTest {

    @Test
    fun create() {
        val suppliedCompliance =
            SuppliedCompliance.builder()
                .brand(
                    SuppliedCompliance.Brand.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .campaign(
                    SuppliedCompliance.Campaign.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addCampaign(
                    SuppliedCompliance.Campaign.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addDocument(
                    SuppliedDocument.builder()
                        .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileName("file_name")
                        .key("key")
                        .build()
                )
                .build()

        assertThat(suppliedCompliance.brand())
            .contains(
                SuppliedCompliance.Brand.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(suppliedCompliance.campaign())
            .contains(
                SuppliedCompliance.Campaign.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(suppliedCompliance.campaigns().getOrNull())
            .containsExactly(
                SuppliedCompliance.Campaign.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(suppliedCompliance.documents().getOrNull())
            .containsExactly(
                SuppliedDocument.builder()
                    .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .fileName("file_name")
                    .key("key")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val suppliedCompliance =
            SuppliedCompliance.builder()
                .brand(
                    SuppliedCompliance.Brand.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .campaign(
                    SuppliedCompliance.Campaign.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addCampaign(
                    SuppliedCompliance.Campaign.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addDocument(
                    SuppliedDocument.builder()
                        .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileName("file_name")
                        .key("key")
                        .build()
                )
                .build()

        val roundtrippedSuppliedCompliance =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(suppliedCompliance),
                jacksonTypeRef<SuppliedCompliance>(),
            )

        assertThat(roundtrippedSuppliedCompliance).isEqualTo(suppliedCompliance)
    }
}
