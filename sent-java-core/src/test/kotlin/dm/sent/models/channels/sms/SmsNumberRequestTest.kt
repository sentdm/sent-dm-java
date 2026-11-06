// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmsNumberRequestTest {

    @Test
    fun create() {
        val smsNumberRequest = SmsNumberRequest.builder().areaCode("area_code").quantity(0).build()

        assertThat(smsNumberRequest.areaCode()).contains("area_code")
        assertThat(smsNumberRequest.quantity()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val smsNumberRequest = SmsNumberRequest.builder().areaCode("area_code").quantity(0).build()

        val roundtrippedSmsNumberRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smsNumberRequest),
                jacksonTypeRef<SmsNumberRequest>(),
            )

        assertThat(roundtrippedSmsNumberRequest).isEqualTo(smsNumberRequest)
    }
}
