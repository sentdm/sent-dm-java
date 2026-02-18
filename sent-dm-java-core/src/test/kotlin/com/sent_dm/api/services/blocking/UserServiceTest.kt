// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.models.users.UserInviteParams
import com.sent_dm.api.models.users.UserRemoveParams
import com.sent_dm.api.models.users.UserUpdateRoleParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()

        val apiResponseOfUser = userService.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        apiResponseOfUser.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()

        val users = userService.list()

        users.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun invite() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()

        val apiResponseOfUser =
            userService.invite(
                UserInviteParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .email("newuser@example.com")
                    .name("New User")
                    .role("developer")
                    .build()
            )

        apiResponseOfUser.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun remove() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()

        userService.remove(
            UserRemoveParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .testMode(false)
                .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                .build()
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateRole() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()

        val apiResponseOfUser =
            userService.updateRole(
                UserUpdateRoleParams.builder()
                    .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .role("billing")
                    .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                    .build()
            )

        apiResponseOfUser.validate()
    }
}
