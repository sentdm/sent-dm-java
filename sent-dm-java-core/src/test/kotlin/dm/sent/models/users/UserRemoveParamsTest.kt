// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRemoveParamsTest {

    @Test
    fun create() {
        UserRemoveParams.builder()
            .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .testMode(false)
            .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserRemoveParams.builder().pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserRemoveParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .testMode(false)
                .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.bodyUserId()).contains("aa0e8400-e29b-41d4-a716-446655440005")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserRemoveParams.builder().pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        val body = params._body()
    }
}
