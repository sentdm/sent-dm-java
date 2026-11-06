// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountRcsChannelTest {

    @Test
    fun create() {
        val accountRcsChannel =
            AccountRcsChannel.builder().configured(true).phoneNumber("phone_number").build()

        assertThat(accountRcsChannel.configured()).contains(true)
        assertThat(accountRcsChannel.phoneNumber()).contains("phone_number")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRcsChannel =
            AccountRcsChannel.builder().configured(true).phoneNumber("phone_number").build()

        val roundtrippedAccountRcsChannel =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRcsChannel),
                jacksonTypeRef<AccountRcsChannel>(),
            )

        assertThat(roundtrippedAccountRcsChannel).isEqualTo(accountRcsChannel)
    }
}
