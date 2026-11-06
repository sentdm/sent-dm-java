// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileWhatsappTest {

    @Test
    fun create() {
        val senderProfileWhatsapp =
            SenderProfileWhatsapp.builder()
                .phoneNumberId("phone_number_id")
                .wabaId("waba_id")
                .build()

        assertThat(senderProfileWhatsapp.phoneNumberId()).contains("phone_number_id")
        assertThat(senderProfileWhatsapp.wabaId()).contains("waba_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val senderProfileWhatsapp =
            SenderProfileWhatsapp.builder()
                .phoneNumberId("phone_number_id")
                .wabaId("waba_id")
                .build()

        val roundtrippedSenderProfileWhatsapp =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(senderProfileWhatsapp),
                jacksonTypeRef<SenderProfileWhatsapp>(),
            )

        assertThat(roundtrippedSenderProfileWhatsapp).isEqualTo(senderProfileWhatsapp)
    }
}
