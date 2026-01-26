// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.models.templates.TemplateBodyContent
import com.sent_dm.api.models.templates.TemplateCreateParams
import com.sent_dm.api.models.templates.TemplateDefinition
import com.sent_dm.api.models.templates.TemplateDeleteParams
import com.sent_dm.api.models.templates.TemplateListParams
import com.sent_dm.api.models.templates.TemplateRetrieveParams
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
                .senderId("My Sender ID")
                .build()
        val templateService = client.templates()

        val templateResponse =
            templateService.create(
                TemplateCreateParams.builder()
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                TemplateDefinition.Body.builder()
                                    .multiChannel(
                                        TemplateBodyContent.builder()
                                            .template(
                                                "Hello {{1:variable}}, thank you for joining our service. We're excited to help you with your messaging needs!"
                                            )
                                            .type(null)
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .id(1)
                                                    .name("customerName")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .alt(null)
                                                            .mediaType(null)
                                                            .sample("John Doe")
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
                                    .template("Best regards, The SentDM Team")
                                    .type("text")
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
                                    .template("Welcome to {{1:variable}}!")
                                    .type("text")
                                    .addVariable(
                                        TemplateVariable.builder()
                                            .id(1)
                                            .name("companyName")
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
                            .build()
                    )
                    .category("MARKETING")
                    .language("en_US")
                    .submitForReview(false)
                    .build()
            )

        templateResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val templateService = client.templates()

        val templateResponse =
            templateService.retrieve(
                TemplateRetrieveParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .build()
            )

        templateResponse.validate()
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
        val templateService = client.templates()

        val templates =
            templateService.list(
                TemplateListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
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
                .senderId("My Sender ID")
                .build()
        val templateService = client.templates()

        templateService.delete(
            TemplateDeleteParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .build()
        )
    }
}
