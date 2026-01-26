// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.models.templates.TemplateBodyContent
import com.sent_dm.api.models.templates.TemplateVariable
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
            SentDmOkHttpClient.builder()
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.templates()).isNotNull()
        assertThat(client.contacts()).isNotNull()
        assertThat(client.messages()).isNotNull()
        assertThat(client.numberLookup()).isNotNull()
        assertThat(client.organizations()).isNotNull()
    }

    @Test
    fun templateBodyContentRoundtrip() {
        val jsonMapper = jsonMapper()
        val templateBodyContent =
            TemplateBodyContent.builder()
                .template("template")
                .type("type")
                .addVariable(
                    TemplateVariable.builder()
                        .id(0)
                        .name("name")
                        .props(
                            TemplateVariable.Props.builder()
                                .alt("alt")
                                .mediaType("mediaType")
                                .sample("sample")
                                .shortUrl("shortUrl")
                                .url("url")
                                .variableType("variableType")
                                .build()
                        )
                        .type("type")
                        .build()
                )
                .build()

        val roundtrippedTemplateBodyContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateBodyContent),
                jacksonTypeRef<TemplateBodyContent>(),
            )

        assertThat(roundtrippedTemplateBodyContent).isEqualTo(templateBodyContent)
    }
}
