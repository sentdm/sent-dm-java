// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageChannelOptionsTest {

    @Test
    fun create() {
        val messageChannelOptions =
            MessageChannelOptions.builder()
                .country("country")
                .addFrom("string")
                .strategy("strategy")
                .build()

        assertThat(messageChannelOptions.country()).contains("country")
        assertThat(messageChannelOptions.from().getOrNull()).containsExactly("string")
        assertThat(messageChannelOptions.strategy()).contains("strategy")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageChannelOptions =
            MessageChannelOptions.builder()
                .country("country")
                .addFrom("string")
                .strategy("strategy")
                .build()

        val roundtrippedMessageChannelOptions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageChannelOptions),
                jacksonTypeRef<MessageChannelOptions>(),
            )

        assertThat(roundtrippedMessageChannelOptions).isEqualTo(messageChannelOptions)
    }
}
