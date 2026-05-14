// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.users.UserInviteParams
import dm.sent.models.users.UserListParams
import dm.sent.models.users.UserRemoveParams
import dm.sent.models.users.UserRetrieveParams
import dm.sent.models.users.UserUpdateRoleParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UserServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val userService = client.users()

        val user =
            userService.retrieve(
                UserRetrieveParams.builder()
                    .userId("userId")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        user.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val userService = client.users()

        val users =
            userService.list(
                UserListParams.builder().xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        users.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun invite() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val userService = client.users()

        val response =
            userService.invite(
                UserInviteParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .email("newuser@example.com")
                    .name("New User")
                    .role("developer")
                    .sandbox(false)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun remove() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val userService = client.users()

        userService.remove(
            UserRemoveParams.builder()
                .userId("userId")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateRole() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val userService = client.users()

        val response =
            userService.updateRole(
                UserUpdateRoleParams.builder()
                    .userId("userId")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .role("billing")
                    .sandbox(false)
                    .build()
            )

        response.validate()
    }
}
