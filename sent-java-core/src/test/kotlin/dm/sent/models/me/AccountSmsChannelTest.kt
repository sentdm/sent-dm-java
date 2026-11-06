// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountSmsChannelTest {

    @Test
    fun create() {
        val accountSmsChannel =
            AccountSmsChannel.builder().configured(true).phoneNumber("phone_number").build()

        assertThat(accountSmsChannel.configured()).contains(true)
        assertThat(accountSmsChannel.phoneNumber()).contains("phone_number")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountSmsChannel =
            AccountSmsChannel.builder().configured(true).phoneNumber("phone_number").build()

        val roundtrippedAccountSmsChannel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountSmsChannel),
                jacksonTypeRef<AccountSmsChannel>(),
            )

        assertThat(roundtrippedAccountSmsChannel).isEqualTo(accountSmsChannel)
    }
}
