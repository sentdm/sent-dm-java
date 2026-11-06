// File generated from our OpenAPI spec by Stainless.

package dm.sent.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.messages.ApiResponseOfCancelledMessage
import dm.sent.models.messages.CancelledMessage
import dm.sent.models.messages.MessageBody
import dm.sent.models.messages.MessageButton
import dm.sent.models.messages.MessageHeaderMedia
import dm.sent.models.messages.MessageMedia
import dm.sent.models.messages.MessageStatusEvent
import dm.sent.models.profiles.EntityType
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
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
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/sent-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.webhooks()).isNotNull()
        assertThat(client.users()).isNotNull()
        assertThat(client.templates()).isNotNull()
        assertThat(client.profiles()).isNotNull()
        assertThat(client.senderProfiles()).isNotNull()
        assertThat(client.numbers()).isNotNull()
        assertThat(client.messages()).isNotNull()
        assertThat(client.contacts()).isNotNull()
        assertThat(client.conversations()).isNotNull()
        assertThat(client.voice()).isNotNull()
        assertThat(client.channels()).isNotNull()
        assertThat(client.compliance()).isNotNull()
        assertThat(client.me()).isNotNull()
    }

    @Test
    fun apiResponseOfCancelledMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfCancelledMessage =
            ApiResponseOfCancelledMessage.builder()
                .data(
                    CancelledMessage.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .activeContactPrice(0.0)
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .direction("direction")
                        .addEvent(
                            MessageStatusEvent.builder()
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .build()
                        )
                        .messageBody(
                            MessageBody.builder()
                                .addButton(
                                    MessageButton.builder()
                                        .postbackData("postbackData")
                                        .text("text")
                                        .type("type")
                                        .value("value")
                                        .build()
                                )
                                .content("content")
                                .footer("footer")
                                .header("header")
                                .headerMedia(
                                    MessageHeaderMedia.builder().type("type").url("url").build()
                                )
                                .addMedia(
                                    MessageMedia.builder()
                                        .mediaType("mediaType")
                                        .mimeType("mimeType")
                                        .sizeBytes(0L)
                                        .sourceHashSha256("sourceHashSha256")
                                        .url("url")
                                        .build()
                                )
                                .subject("subject")
                                .build()
                        )
                        .phone("phone")
                        .phoneInternational("phone_international")
                        .price(0.0)
                        .reason("reason")
                        .reasonCode("reason_code")
                        .regionCode("region_code")
                        .status("status")
                        .templateCategory("template_category")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
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
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfCancelledMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfCancelledMessage),
                jacksonTypeRef<ApiResponseOfCancelledMessage>(),
            )

        assertThat(roundtrippedApiResponseOfCancelledMessage)
            .isEqualTo(apiResponseOfCancelledMessage)
    }

    @Test
    fun entityTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val entityType = EntityType.PRIVATE_PROFIT

        val roundtrippedEntityType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityType),
                jacksonTypeRef<EntityType>(),
            )

        assertThat(roundtrippedEntityType).isEqualTo(entityType)
    }
}
