// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.organizations

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.models.organizations.users.UserDeleteParams
import dm.sent.models.organizations.users.UserInviteParams
import dm.sent.models.organizations.users.UserListParams
import dm.sent.models.organizations.users.UserRetrieveParams
import dm.sent.models.organizations.users.UserUpdateRoleParams
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
                .senderId("My Sender ID")
                .build()
        val userService = client.organizations().users()

        val customerUser =
            userService.retrieve(
                UserRetrieveParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .userId("650e8400-e29b-41d4-a716-446655440000")
                    .build()
            )

        customerUser.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val userService = client.organizations().users()

        val users =
            userService.list(
                UserListParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .page(0)
                    .pageSize(0)
                    .build()
            )

        users.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val userService = client.organizations().users()

        userService.delete(
            UserDeleteParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .userId("650e8400-e29b-41d4-a716-446655440000")
                .build()
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun invite() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val userService = client.organizations().users()

        val customerUser =
            userService.invite(
                UserInviteParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .email("user@example.com")
                    .invitedBy("650e8400-e29b-41d4-a716-446655440000")
                    .name("John Doe")
                    .role("admin")
                    .build()
            )

        customerUser.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateRole() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val userService = client.organizations().users()

        val customerUser =
            userService.updateRole(
                UserUpdateRoleParams.builder()
                    .customerId("550e8400-e29b-41d4-a716-446655440000")
                    .userId("650e8400-e29b-41d4-a716-446655440000")
                    .role("admin")
                    .build()
            )

        customerUser.validate()
    }
}
