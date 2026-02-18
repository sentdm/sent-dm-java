// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRetrieveActivitiesParamsTest {

    @Test
    fun create() {
        MessageRetrieveActivitiesParams.builder().id("8ba7b830-9dad-11d1-80b4-00c04fd430c8").build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageRetrieveActivitiesParams.builder()
                .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
