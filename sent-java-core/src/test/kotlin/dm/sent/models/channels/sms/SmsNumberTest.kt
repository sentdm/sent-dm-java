// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmsNumberTest {

    @Test
    fun create() {
        val smsNumber =
            SmsNumber.builder()
                .areaCode("area_code")
                .senderValue("sender_value")
                .status("status")
                .build()

        assertThat(smsNumber.areaCode()).contains("area_code")
        assertThat(smsNumber.senderValue()).contains("sender_value")
        assertThat(smsNumber.status()).contains("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val smsNumber =
            SmsNumber.builder()
                .areaCode("area_code")
                .senderValue("sender_value")
                .status("status")
                .build()

        val roundtrippedSmsNumber =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smsNumber),
                jacksonTypeRef<SmsNumber>(),
            )

        assertThat(roundtrippedSmsNumber).isEqualTo(smsNumber)
    }
}
