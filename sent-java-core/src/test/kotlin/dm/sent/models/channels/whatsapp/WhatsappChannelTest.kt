// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.whatsapp

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WhatsappChannelTest {

    @Test
    fun create() {
        val whatsappChannel =
            WhatsappChannel.builder()
                .ownerBusinessId("owner_business_id")
                .phoneNumberId("phone_number_id")
                .reason("reason")
                .reasonCode("reason_code")
                .solutionId("solution_id")
                .status(WhatsappChannel.Status.PROVISIONING)
                .wabaId("waba_id")
                .build()

        assertThat(whatsappChannel.ownerBusinessId()).contains("owner_business_id")
        assertThat(whatsappChannel.phoneNumberId()).contains("phone_number_id")
        assertThat(whatsappChannel.reason()).contains("reason")
        assertThat(whatsappChannel.reasonCode()).contains("reason_code")
        assertThat(whatsappChannel.solutionId()).contains("solution_id")
        assertThat(whatsappChannel.status()).contains(WhatsappChannel.Status.PROVISIONING)
        assertThat(whatsappChannel.wabaId()).contains("waba_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val whatsappChannel =
            WhatsappChannel.builder()
                .ownerBusinessId("owner_business_id")
                .phoneNumberId("phone_number_id")
                .reason("reason")
                .reasonCode("reason_code")
                .solutionId("solution_id")
                .status(WhatsappChannel.Status.PROVISIONING)
                .wabaId("waba_id")
                .build()

        val roundtrippedWhatsappChannel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(whatsappChannel),
                jacksonTypeRef<WhatsappChannel>(),
            )

        assertThat(roundtrippedWhatsappChannel).isEqualTo(whatsappChannel)
    }
}
