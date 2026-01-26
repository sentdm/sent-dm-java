// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async.organizations

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClientAsync
import com.sent_dm.api.models.organizations.users.UserDeleteParams
import com.sent_dm.api.models.organizations.users.UserInviteParams
import com.sent_dm.api.models.organizations.users.UserListParams
import com.sent_dm.api.models.organizations.users.UserRetrieveParams
import com.sent_dm.api.models.organizations.users.UserUpdateRoleParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val userServiceAsync = client.organizations().users()

        val customerUserFuture =
            userServiceAsync.retrieve(
                UserRetrieveParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .userId("650e8400-e29b-41d4-a716-446655440000")
                    .build()
            )

        val customerUser = customerUserFuture.get()
        customerUser.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val userServiceAsync = client.organizations().users()

        val usersFuture =
            userServiceAsync.list(
                UserListParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .page(0)
                    .pageSize(0)
                    .build()
            )

        val users = usersFuture.get()
        users.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val userServiceAsync = client.organizations().users()

        val future =
            userServiceAsync.delete(
                UserDeleteParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .userId("650e8400-e29b-41d4-a716-446655440000")
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun invite() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val userServiceAsync = client.organizations().users()

        val customerUserFuture =
            userServiceAsync.invite(
                UserInviteParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .email("user@example.com")
                    .invitedBy("650e8400-e29b-41d4-a716-446655440000")
                    .name("John Doe")
                    .role("admin")
                    .build()
            )

        val customerUser = customerUserFuture.get()
        customerUser.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateRole() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val userServiceAsync = client.organizations().users()

        val customerUserFuture =
            userServiceAsync.updateRole(
                UserUpdateRoleParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .userId("650e8400-e29b-41d4-a716-446655440000")
                    .role("admin")
                    .build()
            )

        val customerUser = customerUserFuture.get()
        customerUser.validate()
    }
}
