// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.models.brands.BrandCreateParams
import com.sent_dm.api.models.brands.BrandData
import com.sent_dm.api.models.brands.BrandDeleteParams
import com.sent_dm.api.models.brands.BrandUpdateParams
import com.sent_dm.api.models.brands.DestinationCountry
import com.sent_dm.api.models.brands.TcrBrandRelationship
import com.sent_dm.api.models.brands.TcrVertical
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BrandServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val brandService = client.brands()

        val apiResponseBrandWithKyc =
            brandService.create(
                BrandCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .brand(
                        BrandData.builder()
                            .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                            .contactName("John Smith")
                            .vertical(TcrVertical.PROFESSIONAL)
                            .brandName(null)
                            .businessLegalName("Acme Corporation LLC")
                            .businessName("Acme Corp")
                            .businessRole("CEO")
                            .businessUrl("https://acmecorp.com")
                            .city("New York")
                            .contactEmail("john@acmecorp.com")
                            .contactPhone("+12025551234")
                            .contactPhoneCountryCode("1")
                            .country("US")
                            .countryOfRegistration("US")
                            .addDestinationCountry(
                                DestinationCountry.builder().id("US").isMain(false).build()
                            )
                            .entityType(BrandData.EntityType.PRIVATE_PROFIT)
                            .expectedMessagingVolume("10000")
                            .isTcrApplication(true)
                            .notes(null)
                            .phoneNumberPrefix("+1")
                            .postalCode("10001")
                            .primaryUseCase("Customer notifications and appointment reminders")
                            .state("NY")
                            .street("123 Main Street")
                            .taxId("12-3456789")
                            .taxIdType("us_ein")
                            .build()
                    )
                    .build()
            )

        apiResponseBrandWithKyc.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val brandService = client.brands()

        val apiResponseBrandWithKyc =
            brandService.update(
                BrandUpdateParams.builder()
                    .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .brand(
                        BrandData.builder()
                            .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                            .contactName("John Smith")
                            .vertical(TcrVertical.PROFESSIONAL)
                            .brandName(null)
                            .businessLegalName("Acme Corporation LLC")
                            .businessName("Acme Corp Updated")
                            .businessRole("CTO")
                            .businessUrl(null)
                            .city(null)
                            .contactEmail("john@acmecorp.com")
                            .contactPhone("+12025551234")
                            .contactPhoneCountryCode("1")
                            .country("US")
                            .countryOfRegistration(null)
                            .addDestinationCountry(
                                DestinationCountry.builder().id("id").isMain(true).build()
                            )
                            .entityType(null)
                            .expectedMessagingVolume(null)
                            .isTcrApplication(null)
                            .notes(null)
                            .phoneNumberPrefix(null)
                            .postalCode(null)
                            .primaryUseCase(null)
                            .state(null)
                            .street(null)
                            .taxId(null)
                            .taxIdType(null)
                            .build()
                    )
                    .build()
            )

        apiResponseBrandWithKyc.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val brandService = client.brands()

        val brands = brandService.list()

        brands.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val brandService = client.brands()

        brandService.delete(
            BrandDeleteParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .testMode(false)
                .build()
        )
    }
}
