// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaymentDetailsTest {

    @Test
    fun create() {
        val paymentDetails =
            PaymentDetails.builder()
                .cardNumber("3216699102256101")
                .cvc("3216")
                .expiry("11/66")
                .zipCode("x")
                .build()

        assertThat(paymentDetails.cardNumber()).isEqualTo("3216699102256101")
        assertThat(paymentDetails.cvc()).isEqualTo("3216")
        assertThat(paymentDetails.expiry()).isEqualTo("11/66")
        assertThat(paymentDetails.zipCode()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paymentDetails =
            PaymentDetails.builder()
                .cardNumber("3216699102256101")
                .cvc("3216")
                .expiry("11/66")
                .zipCode("x")
                .build()

        val roundtrippedPaymentDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paymentDetails),
                jacksonTypeRef<PaymentDetails>(),
            )

        assertThat(roundtrippedPaymentDetails).isEqualTo(paymentDetails)
    }
}
