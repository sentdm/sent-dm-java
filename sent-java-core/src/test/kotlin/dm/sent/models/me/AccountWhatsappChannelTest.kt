// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountWhatsappChannelTest {

    @Test
    fun create() {
        val accountWhatsappChannel =
            AccountWhatsappChannel.builder()
                .businessName("business_name")
                .configured(true)
                .phoneNumber("phone_number")
                .build()

        assertThat(accountWhatsappChannel.businessName()).contains("business_name")
        assertThat(accountWhatsappChannel.configured()).contains(true)
        assertThat(accountWhatsappChannel.phoneNumber()).contains("phone_number")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountWhatsappChannel =
            AccountWhatsappChannel.builder()
                .businessName("business_name")
                .configured(true)
                .phoneNumber("phone_number")
                .build()

        val roundtrippedAccountWhatsappChannel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountWhatsappChannel),
                jacksonTypeRef<AccountWhatsappChannel>(),
            )

        assertThat(roundtrippedAccountWhatsappChannel).isEqualTo(accountWhatsappChannel)
    }
}
