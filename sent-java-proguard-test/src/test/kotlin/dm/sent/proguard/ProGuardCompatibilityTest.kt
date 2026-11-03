// File generated from our OpenAPI spec by Stainless.

package dm.sent.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.jsonMapper
import dm.sent.models.messages.MessageResendResponseData
import dm.sent.models.profiles.TcrBrandRelationship
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
        assertThat(client.numbers()).isNotNull()
        assertThat(client.messages()).isNotNull()
        assertThat(client.contacts()).isNotNull()
        assertThat(client.conversations()).isNotNull()
        assertThat(client.voice()).isNotNull()
        assertThat(client.channels()).isNotNull()
        assertThat(client.me()).isNotNull()
    }

    @Test
    fun messageResendResponseDataRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageResendResponseData =
            MessageResendResponseData.builder()
                .addRecipient(
                    MessageResendResponseData.Recipient.builder()
                        .body("body")
                        .channel("channel")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .to("to")
                        .build()
                )
                .status("status")
                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .templateName("template_name")
                .build()

        val roundtrippedMessageResendResponseData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageResendResponseData),
                jacksonTypeRef<MessageResendResponseData>(),
            )

        assertThat(roundtrippedMessageResendResponseData).isEqualTo(messageResendResponseData)
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
