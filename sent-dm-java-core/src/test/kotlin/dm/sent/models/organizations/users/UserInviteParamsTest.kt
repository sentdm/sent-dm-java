// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.organizations.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserInviteParamsTest {

    @Test
    fun create() {
        UserInviteParams.builder()
            .customerId("550e8400-e29b-41d4-a716-446655440000")
            .email("user@example.com")
            .invitedBy("650e8400-e29b-41d4-a716-446655440000")
            .name("John Doe")
            .role("admin")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserInviteParams.builder().customerId("550e8400-e29b-41d4-a716-446655440000").build()

        assertThat(params._pathParam(0)).isEqualTo("550e8400-e29b-41d4-a716-446655440000")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserInviteParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .email("user@example.com")
                .invitedBy("650e8400-e29b-41d4-a716-446655440000")
                .name("John Doe")
                .role("admin")
                .build()

        val body = params._body()

        assertThat(body.email()).contains("user@example.com")
        assertThat(body.invitedBy()).contains("650e8400-e29b-41d4-a716-446655440000")
        assertThat(body.name()).contains("John Doe")
        assertThat(body.role()).contains("admin")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserInviteParams.builder().customerId("550e8400-e29b-41d4-a716-446655440000").build()

        val body = params._body()
    }
}
