// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.templates.TemplateBodyContent
import dm.sent.models.templates.TemplateCreateParams
import dm.sent.models.templates.TemplateDefinition
import dm.sent.models.templates.TemplateListParams
import dm.sent.models.templates.TemplateVariable
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TemplateServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val templateServiceAsync = client.templates()

        val templateResponseV2Future =
            templateServiceAsync.create(
                TemplateCreateParams.builder()
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

        val templateResponseV2 = templateResponseV2Future.get()
        templateResponseV2.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val templateServiceAsync = client.templates()

        val templateResponseV2Future =
            templateServiceAsync.retrieve("7ba7b820-9dad-11d1-80b4-00c04fd430c8")

        val templateResponseV2 = templateResponseV2Future.get()
        templateResponseV2.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
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

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val templateServiceAsync = client.templates()

        val future = templateServiceAsync.delete("7ba7b820-9dad-11d1-80b4-00c04fd430c8")

        val response = future.get()
    }
}
