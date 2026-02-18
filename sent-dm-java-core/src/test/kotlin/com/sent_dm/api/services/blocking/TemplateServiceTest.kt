// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.models.templates.TemplateBodyContent
import com.sent_dm.api.models.templates.TemplateCreateParams
import com.sent_dm.api.models.templates.TemplateDefinition
import com.sent_dm.api.models.templates.TemplateDeleteParams
import com.sent_dm.api.models.templates.TemplateListParams
import com.sent_dm.api.models.templates.TemplateUpdateParams
import com.sent_dm.api.models.templates.TemplateVariable
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TemplateServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val templateService = client.templates()

        val apiResponseTemplate =
            templateService.create(
                TemplateCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .category("MARKETING")
                    .creationSource(null)
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                TemplateDefinition.Body.builder()
                                    .multiChannel(
                                        TemplateBodyContent.builder()
                                            .template(
                                                "Hello {{0:variable}}! Welcome to {{1:variable}}."
                                            )
                                            .type(null)
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .id(0)
                                                    .name("name")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .alt(null)
                                                            .mediaType(null)
                                                            .sample("John")
                                                            .shortUrl(null)
                                                            .url(null)
                                                            .variableType("text")
                                                            .build()
                                                    )
                                                    .type("variable")
                                                    .build()
                                            )
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .id(1)
                                                    .name("company")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .alt(null)
                                                            .mediaType(null)
                                                            .sample("SentDM")
                                                            .shortUrl(null)
                                                            .url(null)
                                                            .variableType("text")
                                                            .build()
                                                    )
                                                    .type("variable")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .sms(
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
                                    )
                                    .whatsapp(
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
                                    )
                                    .build()
                            )
                            .authenticationConfig(
                                TemplateDefinition.AuthenticationConfig.builder()
                                    .addSecurityRecommendation(true)
                                    .codeExpirationMinutes(0)
                                    .build()
                            )
                            .addButton(
                                TemplateDefinition.Button.builder()
                                    .id(0)
                                    .props(
                                        TemplateDefinition.Button.Props.builder()
                                            .activeFor(0)
                                            .autofillText("autofillText")
                                            .countryCode("countryCode")
                                            .offerCode("offerCode")
                                            .otpType("otpType")
                                            .packageName("packageName")
                                            .phoneNumber("phoneNumber")
                                            .quickReplyType("quickReplyType")
                                            .signatureHash("signatureHash")
                                            .text("text")
                                            .url("url")
                                            .urlType("urlType")
                                            .build()
                                    )
                                    .type("type")
                                    .build()
                            )
                            .definitionVersion("1.0")
                            .footer(
                                TemplateDefinition.Footer.builder()
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
                            )
                            .header(
                                TemplateDefinition.Header.builder()
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
                            )
                            .build()
                    )
                    .language("en_US")
                    .submitForReview(false)
                    .build()
            )

        apiResponseTemplate.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val templateService = client.templates()

        val apiResponseTemplate = templateService.retrieve("7ba7b820-9dad-11d1-80b4-00c04fd430c8")

        apiResponseTemplate.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val templateService = client.templates()

        val apiResponseTemplate =
            templateService.update(
                TemplateUpdateParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .category("MARKETING")
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                TemplateDefinition.Body.builder()
                                    .multiChannel(
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
                                    )
                                    .sms(
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
                                    )
                                    .whatsapp(
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
                                    )
                                    .build()
                            )
                            .authenticationConfig(
                                TemplateDefinition.AuthenticationConfig.builder()
                                    .addSecurityRecommendation(true)
                                    .codeExpirationMinutes(0)
                                    .build()
                            )
                            .addButton(
                                TemplateDefinition.Button.builder()
                                    .id(0)
                                    .props(
                                        TemplateDefinition.Button.Props.builder()
                                            .activeFor(0)
                                            .autofillText("autofillText")
                                            .countryCode("countryCode")
                                            .offerCode("offerCode")
                                            .otpType("otpType")
                                            .packageName("packageName")
                                            .phoneNumber("phoneNumber")
                                            .quickReplyType("quickReplyType")
                                            .signatureHash("signatureHash")
                                            .text("text")
                                            .url("url")
                                            .urlType("urlType")
                                            .build()
                                    )
                                    .type("type")
                                    .build()
                            )
                            .definitionVersion("definitionVersion")
                            .footer(
                                TemplateDefinition.Footer.builder()
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
                            )
                            .header(
                                TemplateDefinition.Header.builder()
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
                            )
                            .build()
                    )
                    .language(null)
                    .name("Updated Welcome Message")
                    .submitForReview(false)
                    .build()
            )

        apiResponseTemplate.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val templateService = client.templates()

        val templates =
            templateService.list(
                TemplateListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .category("category")
                    .search("search")
                    .status("status")
                    .build()
            )

        templates.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val templateService = client.templates()

        templateService.delete(
            TemplateDeleteParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .testMode(false)
                .deleteFromMeta(false)
                .build()
        )
    }
}
