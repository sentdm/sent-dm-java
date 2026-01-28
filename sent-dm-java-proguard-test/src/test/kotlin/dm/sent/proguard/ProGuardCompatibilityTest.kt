// File generated from our OpenAPI spec by Stainless.

package dm.sent.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.core.jsonMapper
import dm.sent.models.messages.MessageRetrieveResponse
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
        val client =
            SentDmOkHttpClient.builder().apiKey("My API Key").senderId("My Sender ID").build()

        assertThat(client).isNotNull()
        assertThat(client.templates()).isNotNull()
        assertThat(client.contacts()).isNotNull()
        assertThat(client.messages()).isNotNull()
        assertThat(client.numberLookup()).isNotNull()
        assertThat(client.organizations()).isNotNull()
    }

    @Test
    fun messageRetrieveResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageRetrieveResponse =
            MessageRetrieveResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channel("channel")
                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .correctedPrice(0.0)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addEvent(
                    MessageRetrieveResponse.Event.builder()
                        .description("description")
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .messageBody(
                    MessageRetrieveResponse.MessageBody.builder()
                        .addButton(
                            MessageRetrieveResponse.MessageBody.Button.builder()
                                .type("type")
                                .value("value")
                                .build()
                        )
                        .content("content")
                        .footer("footer")
                        .header("header")
                        .build()
                )
                .phoneNumber("phoneNumber")
                .phoneNumberInternational("phoneNumberInternational")
                .regionCode("regionCode")
                .status("status")
                .templateCategory("templateCategory")
                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .templateName("templateName")
                .build()

        val roundtrippedMessageRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRetrieveResponse),
                jacksonTypeRef<MessageRetrieveResponse>(),
            )

        assertThat(roundtrippedMessageRetrieveResponse).isEqualTo(messageRetrieveResponse)
    }
}
