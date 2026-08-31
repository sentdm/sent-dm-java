// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.templates.AuthenticationConfig
import dm.sent.models.templates.TemplateBody
import dm.sent.models.templates.TemplateBodyContent
import dm.sent.models.templates.TemplateButton
import dm.sent.models.templates.TemplateButtonProps
import dm.sent.models.templates.TemplateCreateParams
import dm.sent.models.templates.TemplateDefinition
import dm.sent.models.templates.TemplateDeleteParams
import dm.sent.models.templates.TemplateFooter
import dm.sent.models.templates.TemplateHeader
import dm.sent.models.templates.TemplateListParams
import dm.sent.models.templates.TemplateRetrieveParams
import dm.sent.models.templates.TemplateUpdateParams
import dm.sent.models.templates.TemplateVariable
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TemplateServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val templateFuture =
            templateServiceAsync.create(
                TemplateCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .category("MARKETING")
                    .creationSource(null)
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                TemplateBody.builder()
                                    .multiChannel(
                                        TemplateBodyContent.builder()
                                            .template(
                                                "Hello {{0:variable}}! Welcome to {{1:variable}}."
                                            )
                                            .type(null)
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("name")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("John")
                                                            .url("x")
                                                            .variableType("text")
                                                            .alt(null)
                                                            .regex(null)
                                                            .shortUrl(null)
                                                            .build()
                                                    )
                                                    .type("variable")
                                                    .id(0)
                                                    .build()
                                            )
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("company")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("SentDM")
                                                            .url("x")
                                                            .variableType("text")
                                                            .alt(null)
                                                            .regex(null)
                                                            .shortUrl(null)
                                                            .build()
                                                    )
                                                    .type("variable")
                                                    .id(1)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .rcs(
                                        TemplateBodyContent.builder()
                                            .template("template")
                                            .type("type")
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
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
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
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
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .authenticationConfig(
                                AuthenticationConfig.builder()
                                    .addSecurityRecommendation(true)
                                    .codeExpirationMinutes(0)
                                    .build()
                            )
                            .addButton(
                                TemplateButton.builder()
                                    .props(
                                        TemplateButtonProps.builder()
                                            .activeFor(1)
                                            .countryCode("x")
                                            .offerCode("x")
                                            .phoneNumber("x")
                                            .quickReplyType("x")
                                            .text("text")
                                            .url("url")
                                            .urlType("x")
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
                                                    .build()
                                            )
                                            .autofillText("autofillText")
                                            .otpType("otpType")
                                            .packageName("packageName")
                                            .signatureHash("signatureHash")
                                            .build()
                                    )
                                    .type("x")
                                    .id(0)
                                    .build()
                            )
                            .definitionVersion("1.0")
                            .footer(
                                TemplateFooter.builder()
                                    .template("template")
                                    .type("type")
                                    .addVariable(
                                        TemplateVariable.builder()
                                            .name("x")
                                            .props(
                                                TemplateVariable.Props.builder()
                                                    .mediaType("x")
                                                    .sample("x")
                                                    .url("x")
                                                    .variableType("x")
                                                    .alt("alt")
                                                    .regex("regex")
                                                    .shortUrl("shortUrl")
                                                    .build()
                                            )
                                            .type("x")
                                            .id(0)
                                            .build()
                                    )
                                    .build()
                            )
                            .header(
                                TemplateHeader.builder()
                                    .template("template")
                                    .type("type")
                                    .addVariable(
                                        TemplateVariable.builder()
                                            .name("x")
                                            .props(
                                                TemplateVariable.Props.builder()
                                                    .mediaType("x")
                                                    .sample("x")
                                                    .url("x")
                                                    .variableType("x")
                                                    .alt("alt")
                                                    .regex("regex")
                                                    .shortUrl("shortUrl")
                                                    .build()
                                            )
                                            .type("x")
                                            .id(0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .language("en_US")
                    .sandbox(false)
                    .submitForReview(false)
                    .build()
            )

        val template = templateFuture.get()
        template.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val templateFuture =
            templateServiceAsync.retrieve(
                TemplateRetrieveParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val template = templateFuture.get()
        template.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val templateFuture =
            templateServiceAsync.update(
                TemplateUpdateParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .category("MARKETING")
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                TemplateBody.builder()
                                    .multiChannel(
                                        TemplateBodyContent.builder()
                                            .template("template")
                                            .type("type")
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .rcs(
                                        TemplateBodyContent.builder()
                                            .template("template")
                                            .type("type")
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
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
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
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
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .authenticationConfig(
                                AuthenticationConfig.builder()
                                    .addSecurityRecommendation(true)
                                    .codeExpirationMinutes(0)
                                    .build()
                            )
                            .addButton(
                                TemplateButton.builder()
                                    .props(
                                        TemplateButtonProps.builder()
                                            .activeFor(1)
                                            .countryCode("x")
                                            .offerCode("x")
                                            .phoneNumber("x")
                                            .quickReplyType("x")
                                            .text("text")
                                            .url("url")
                                            .urlType("x")
                                            .addVariable(
                                                TemplateVariable.builder()
                                                    .name("x")
                                                    .props(
                                                        TemplateVariable.Props.builder()
                                                            .mediaType("x")
                                                            .sample("x")
                                                            .url("x")
                                                            .variableType("x")
                                                            .alt("alt")
                                                            .regex("regex")
                                                            .shortUrl("shortUrl")
                                                            .build()
                                                    )
                                                    .type("x")
                                                    .id(0)
                                                    .build()
                                            )
                                            .autofillText("autofillText")
                                            .otpType("otpType")
                                            .packageName("packageName")
                                            .signatureHash("signatureHash")
                                            .build()
                                    )
                                    .type("x")
                                    .id(0)
                                    .build()
                            )
                            .definitionVersion("definitionVersion")
                            .footer(
                                TemplateFooter.builder()
                                    .template("template")
                                    .type("type")
                                    .addVariable(
                                        TemplateVariable.builder()
                                            .name("x")
                                            .props(
                                                TemplateVariable.Props.builder()
                                                    .mediaType("x")
                                                    .sample("x")
                                                    .url("x")
                                                    .variableType("x")
                                                    .alt("alt")
                                                    .regex("regex")
                                                    .shortUrl("shortUrl")
                                                    .build()
                                            )
                                            .type("x")
                                            .id(0)
                                            .build()
                                    )
                                    .build()
                            )
                            .header(
                                TemplateHeader.builder()
                                    .template("template")
                                    .type("type")
                                    .addVariable(
                                        TemplateVariable.builder()
                                            .name("x")
                                            .props(
                                                TemplateVariable.Props.builder()
                                                    .mediaType("x")
                                                    .sample("x")
                                                    .url("x")
                                                    .variableType("x")
                                                    .alt("alt")
                                                    .regex("regex")
                                                    .shortUrl("shortUrl")
                                                    .build()
                                            )
                                            .type("x")
                                            .id(0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .language(null)
                    .name("Updated Welcome Message")
                    .sandbox(false)
                    .submitForReview(false)
                    .build()
            )

        val template = templateFuture.get()
        template.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val templatesFuture =
            templateServiceAsync.list(
                TemplateListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .category("category")
                    .isWelcomePlayground(true)
                    .search("search")
                    .status("status")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val templates = templatesFuture.get()
        templates.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val future =
            templateServiceAsync.delete(
                TemplateDeleteParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .deleteFromMeta(false)
                    .sandbox(false)
                    .build()
            )

        val response = future.get()
    }
}
