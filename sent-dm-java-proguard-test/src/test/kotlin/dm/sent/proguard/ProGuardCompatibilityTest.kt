// File generated from our OpenAPI spec by Stainless.

package dm.sent.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.brands.TcrBrandRelationship
import dm.sent.models.messages.MessageRetrieveActivitiesResponse
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/sent-dm-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.webhooks()).isNotNull()
        assertThat(client.users()).isNotNull()
        assertThat(client.templates()).isNotNull()
        assertThat(client.profiles()).isNotNull()
        assertThat(client.messages()).isNotNull()
        assertThat(client.lookup()).isNotNull()
        assertThat(client.contacts()).isNotNull()
        assertThat(client.brands()).isNotNull()
        assertThat(client.me()).isNotNull()
    }

    @Test
    fun messageRetrieveActivitiesResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageRetrieveActivitiesResponse =
            MessageRetrieveActivitiesResponse.builder()
                .data(
                    MessageRetrieveActivitiesResponse.Data.builder()
                        .addActivity(
                            MessageRetrieveActivitiesResponse.Data.Activity.builder()
                                .content("content")
                                .description("description")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedMessageRetrieveActivitiesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRetrieveActivitiesResponse),
                jacksonTypeRef<MessageRetrieveActivitiesResponse>(),
            )

        assertThat(roundtrippedMessageRetrieveActivitiesResponse)
            .isEqualTo(messageRetrieveActivitiesResponse)
    }

    @Test
    fun tcrBrandRelationshipRoundtrip() {
        val jsonMapper = jsonMapper()
        val tcrBrandRelationship = TcrBrandRelationship.BASIC_ACCOUNT

        val roundtrippedTcrBrandRelationship =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tcrBrandRelationship),
                jacksonTypeRef<TcrBrandRelationship>(),
            )

        assertThat(roundtrippedTcrBrandRelationship).isEqualTo(tcrBrandRelationship)
    }
}
