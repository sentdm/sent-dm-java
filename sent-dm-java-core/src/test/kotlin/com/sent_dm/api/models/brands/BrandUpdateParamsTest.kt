// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandUpdateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params =
            BrandUpdateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .brand(
                    BrandData.builder()
                        .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                        .contactName("John Smith")
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
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

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            BrandUpdateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BrandUpdateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
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
