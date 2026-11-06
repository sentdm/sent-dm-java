// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.channels.sms.SmsNumberRequest
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileSmsTest {

    @Test
    fun create() {
        val senderProfileSms =
            SenderProfileSms.builder()
                .country("x")
                .addAreaCode("string")
                .numberType("number_type")
                .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
                .senderValue("sender_value")
                .build()

        assertThat(senderProfileSms.country()).isEqualTo("x")
        assertThat(senderProfileSms.areaCodes().getOrNull()).containsExactly("string")
        assertThat(senderProfileSms.numberType()).contains("number_type")
        assertThat(senderProfileSms.numbers().getOrNull())
            .containsExactly(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
        assertThat(senderProfileSms.senderValue()).contains("sender_value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val senderProfileSms =
            SenderProfileSms.builder()
                .country("x")
                .addAreaCode("string")
                .numberType("number_type")
                .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
                .senderValue("sender_value")
                .build()

        val roundtrippedSenderProfileSms =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(senderProfileSms),
                jacksonTypeRef<SenderProfileSms>(),
            )

        assertThat(roundtrippedSenderProfileSms).isEqualTo(senderProfileSms)
    }
}
