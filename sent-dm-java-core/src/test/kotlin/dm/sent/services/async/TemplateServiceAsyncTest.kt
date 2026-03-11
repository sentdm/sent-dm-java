// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.templates.SentDmServicesCommonContractsPocOsAuthenticationConfig
import dm.sent.models.templates.SentDmServicesCommonContractsPocOsTemplateBody
import dm.sent.models.templates.SentDmServicesCommonContractsPocOsTemplateButton
import dm.sent.models.templates.SentDmServicesCommonContractsPocOsTemplateButtonProps
import dm.sent.models.templates.SentDmServicesCommonContractsPocOsTemplateFooter
import dm.sent.models.templates.SentDmServicesCommonContractsPocOsTemplateHeader
import dm.sent.models.templates.TemplateBodyContent
import dm.sent.models.templates.TemplateCreateParams
import dm.sent.models.templates.TemplateDefinition
import dm.sent.models.templates.TemplateDeleteParams
import dm.sent.models.templates.TemplateListParams
import dm.sent.models.templates.TemplateUpdateParams
import dm.sent.models.templates.TemplateVariable
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TemplateServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val apiResponseTemplateFuture =
            templateServiceAsync.create(
                TemplateCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .category("MARKETING")
                    .creationSource(null)
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                SentDmServicesCommonContractsPocOsTemplateBody.builder()
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
                                SentDmServicesCommonContractsPocOsAuthenticationConfig.builder()
                                    .addSecurityRecommendation(true)
                                    .codeExpirationMinutes(0)
                                    .build()
                            )
                            .addButton(
                                SentDmServicesCommonContractsPocOsTemplateButton.builder()
                                    .id(0)
                                    .props(
                                        SentDmServicesCommonContractsPocOsTemplateButtonProps
                                            .builder()
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
                                SentDmServicesCommonContractsPocOsTemplateFooter.builder()
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
                                SentDmServicesCommonContractsPocOsTemplateHeader.builder()
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

        val apiResponseTemplate = apiResponseTemplateFuture.get()
        apiResponseTemplate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val apiResponseTemplateFuture =
            templateServiceAsync.retrieve("7ba7b820-9dad-11d1-80b4-00c04fd430c8")

        val apiResponseTemplate = apiResponseTemplateFuture.get()
        apiResponseTemplate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val apiResponseTemplateFuture =
            templateServiceAsync.update(
                TemplateUpdateParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .category("MARKETING")
                    .definition(
                        TemplateDefinition.builder()
                            .body(
                                SentDmServicesCommonContractsPocOsTemplateBody.builder()
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
                                SentDmServicesCommonContractsPocOsAuthenticationConfig.builder()
                                    .addSecurityRecommendation(true)
                                    .codeExpirationMinutes(0)
                                    .build()
                            )
                            .addButton(
                                SentDmServicesCommonContractsPocOsTemplateButton.builder()
                                    .id(0)
                                    .props(
                                        SentDmServicesCommonContractsPocOsTemplateButtonProps
                                            .builder()
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
                                SentDmServicesCommonContractsPocOsTemplateFooter.builder()
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
                                SentDmServicesCommonContractsPocOsTemplateHeader.builder()
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

        val apiResponseTemplate = apiResponseTemplateFuture.get()
        apiResponseTemplate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val templatesFuture =
            templateServiceAsync.list(
                TemplateListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .category("category")
                    .search("search")
                    .status("status")
                    .build()
            )

        val templates = templatesFuture.get()
        templates.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val future =
            templateServiceAsync.delete(
                TemplateDeleteParams.builder()
                    .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                    .testMode(false)
                    .deleteFromMeta(false)
                    .build()
            )

        val response = future.get()
    }
}
