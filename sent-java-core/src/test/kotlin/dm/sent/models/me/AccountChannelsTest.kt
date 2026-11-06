// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountChannelsTest {

    @Test
    fun create() {
        val accountChannels =
            AccountChannels.builder()
                .rcs(
                    AccountRcsChannel.builder().configured(true).phoneNumber("phone_number").build()
                )
                .sms(
                    AccountSmsChannel.builder().configured(true).phoneNumber("phone_number").build()
                )
                .whatsapp(
                    AccountWhatsappChannel.builder()
                        .businessName("business_name")
                        .configured(true)
                        .phoneNumber("phone_number")
                        .build()
                )
                .build()

        assertThat(accountChannels.rcs())
            .contains(
                AccountRcsChannel.builder().configured(true).phoneNumber("phone_number").build()
            )
        assertThat(accountChannels.sms())
            .contains(
                AccountSmsChannel.builder().configured(true).phoneNumber("phone_number").build()
            )
        assertThat(accountChannels.whatsapp())
            .contains(
                AccountWhatsappChannel.builder()
                    .businessName("business_name")
                    .configured(true)
                    .phoneNumber("phone_number")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountChannels =
            AccountChannels.builder()
                .rcs(
                    AccountRcsChannel.builder().configured(true).phoneNumber("phone_number").build()
                )
                .sms(
                    AccountSmsChannel.builder().configured(true).phoneNumber("phone_number").build()
                )
                .whatsapp(
                    AccountWhatsappChannel.builder()
                        .businessName("business_name")
                        .configured(true)
                        .phoneNumber("phone_number")
                        .build()
                )
                .build()

        val roundtrippedAccountChannels =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountChannels),
                jacksonTypeRef<AccountChannels>(),
            )

        assertThat(roundtrippedAccountChannels).isEqualTo(accountChannels)
    }
}
