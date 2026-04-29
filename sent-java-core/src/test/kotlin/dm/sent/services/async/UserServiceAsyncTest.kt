// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.users.UserInviteParams
import dm.sent.models.users.UserListParams
import dm.sent.models.users.UserRemoveParams
import dm.sent.models.users.UserRetrieveParams
import dm.sent.models.users.UserUpdateRoleParams
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UserServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val apiResponseOfUserFuture =
            userServiceAsync.retrieve(
                UserRetrieveParams.builder()
                    .userId("userId")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfUser = apiResponseOfUserFuture.get()
        apiResponseOfUser.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val usersFuture =
            userServiceAsync.list(
                UserListParams.builder().xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        val users = usersFuture.get()
        users.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun invite() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val apiResponseOfUserFuture =
            userServiceAsync.invite(
                UserInviteParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
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
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val future =
            userServiceAsync.remove(
                UserRemoveParams.builder()
                    .userId("userId")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateRole() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.users()

        val apiResponseOfUserFuture =
            userServiceAsync.updateRole(
                UserUpdateRoleParams.builder()
                    .userId("userId")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .role("billing")
                    .build()
            )

        val apiResponseOfUser = apiResponseOfUserFuture.get()
        apiResponseOfUser.validate()
    }
}
