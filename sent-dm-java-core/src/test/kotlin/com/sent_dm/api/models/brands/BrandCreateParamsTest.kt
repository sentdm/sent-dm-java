// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun headers() {
        val params =
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

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            BrandCreateParams.builder()
                .brand(
                    BrandData.builder()
                        .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                        .contactName("John Smith")
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.brand())
            .isEqualTo(
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BrandCreateParams.builder()
                .brand(
                    BrandData.builder()
                        .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                        .contactName("John Smith")
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.brand())
            .isEqualTo(
                BrandData.builder()
                    .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                    .contactName("John Smith")
                    .vertical(TcrVertical.PROFESSIONAL)
                    .build()
            )
    }
}
