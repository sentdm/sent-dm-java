// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseBrandWithKycTest {

    @Test
    fun create() {
        val apiResponseBrandWithKyc =
            ApiResponseBrandWithKyc.builder()
                .data(
                    BrandWithKyc.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                        .businessLegalName("businessLegalName")
                        .businessName("businessName")
                        .businessRole("businessRole")
                        .businessUrl("businessUrl")
                        .city("city")
                        .contactEmail("contactEmail")
                        .contactName("contactName")
                        .contactPhone("contactPhone")
                        .contactPhoneCountryCode("contactPhoneCountryCode")
                        .country("country")
                        .countryOfRegistration("countryOfRegistration")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .cspId("cspId")
                        .addDestinationCountry(
                            DestinationCountry.builder().id("id").isMain(true).build()
                        )
                        .entityType("entityType")
                        .expectedMessagingVolume("expectedMessagingVolume")
                        .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                        .isInherited(true)
                        .isTcrApplication(true)
                        .notes("notes")
                        .phoneNumberPrefix("phoneNumberPrefix")
                        .postalCode("postalCode")
                        .primaryUseCase("primaryUseCase")
                        .state("state")
                        .status(BrandWithKyc.Status.ACTIVE)
                        .street("street")
                        .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .submittedToTcr(true)
                        .taxId("taxId")
                        .taxIdType("taxIdType")
                        .tcrBrandId("tcrBrandId")
                        .universalEin("universalEin")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseBrandWithKyc.data())
            .contains(
                BrandWithKyc.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                    .businessLegalName("businessLegalName")
                    .businessName("businessName")
                    .businessRole("businessRole")
                    .businessUrl("businessUrl")
                    .city("city")
                    .contactEmail("contactEmail")
                    .contactName("contactName")
                    .contactPhone("contactPhone")
                    .contactPhoneCountryCode("contactPhoneCountryCode")
                    .country("country")
                    .countryOfRegistration("countryOfRegistration")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .cspId("cspId")
                    .addDestinationCountry(
                        DestinationCountry.builder().id("id").isMain(true).build()
                    )
                    .entityType("entityType")
                    .expectedMessagingVolume("expectedMessagingVolume")
                    .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                    .isInherited(true)
                    .isTcrApplication(true)
                    .notes("notes")
                    .phoneNumberPrefix("phoneNumberPrefix")
                    .postalCode("postalCode")
                    .primaryUseCase("primaryUseCase")
                    .state("state")
                    .status(BrandWithKyc.Status.ACTIVE)
                    .street("street")
                    .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .submittedToTcr(true)
                    .taxId("taxId")
                    .taxIdType("taxIdType")
                    .tcrBrandId("tcrBrandId")
                    .universalEin("universalEin")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .vertical(TcrVertical.PROFESSIONAL)
                    .build()
            )
        assertThat(apiResponseBrandWithKyc.error())
            .contains(
                ApiError.builder()
                    .code("code")
                    .details(
                        ApiError.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseBrandWithKyc.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseBrandWithKyc.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseBrandWithKyc =
            ApiResponseBrandWithKyc.builder()
                .data(
                    BrandWithKyc.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                        .businessLegalName("businessLegalName")
                        .businessName("businessName")
                        .businessRole("businessRole")
                        .businessUrl("businessUrl")
                        .city("city")
                        .contactEmail("contactEmail")
                        .contactName("contactName")
                        .contactPhone("contactPhone")
                        .contactPhoneCountryCode("contactPhoneCountryCode")
                        .country("country")
                        .countryOfRegistration("countryOfRegistration")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .cspId("cspId")
                        .addDestinationCountry(
                            DestinationCountry.builder().id("id").isMain(true).build()
                        )
                        .entityType("entityType")
                        .expectedMessagingVolume("expectedMessagingVolume")
                        .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                        .isInherited(true)
                        .isTcrApplication(true)
                        .notes("notes")
                        .phoneNumberPrefix("phoneNumberPrefix")
                        .postalCode("postalCode")
                        .primaryUseCase("primaryUseCase")
                        .state("state")
                        .status(BrandWithKyc.Status.ACTIVE)
                        .street("street")
                        .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .submittedToTcr(true)
                        .taxId("taxId")
                        .taxIdType("taxIdType")
                        .tcrBrandId("tcrBrandId")
                        .universalEin("universalEin")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseBrandWithKyc =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseBrandWithKyc),
                jacksonTypeRef<ApiResponseBrandWithKyc>(),
            )

        assertThat(roundtrippedApiResponseBrandWithKyc).isEqualTo(apiResponseBrandWithKyc)
    }
}
