// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.users.UserInviteParams
import dm.sent.models.users.UserRemoveParams
import dm.sent.models.users.UserUpdateRoleParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UserServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val apiResponseOfUserFuture =
            userServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val apiResponseOfUser = apiResponseOfUserFuture.get()
        apiResponseOfUser.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val usersFuture = userServiceAsync.list()

        val users = usersFuture.get()
        users.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun invite() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val apiResponseOfUserFuture =
            userServiceAsync.invite(
                UserInviteParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .email("newuser@example.com")
                    .name("New User")
                    .role("developer")
                    .build()
            )

        val apiResponseOfUser = apiResponseOfUserFuture.get()
        apiResponseOfUser.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun remove() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val future =
            userServiceAsync.remove(
                UserRemoveParams.builder()
                    .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .testMode(false)
                    .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateRole() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val apiResponseOfUserFuture =
            userServiceAsync.updateRole(
                UserUpdateRoleParams.builder()
                    .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .role("billing")
                    .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                    .build()
            )

        val apiResponseOfUser = apiResponseOfUserFuture.get()
        apiResponseOfUser.validate()
    }
}
