// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandListResponseTest {

    @Test
    fun create() {
        val brandListResponse =
            BrandListResponse.builder()
                .addData(
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

        assertThat(brandListResponse.data().getOrNull())
            .containsExactly(
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
        assertThat(brandListResponse.error())
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
        assertThat(brandListResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(brandListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandListResponse =
            BrandListResponse.builder()
                .addData(
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

        val roundtrippedBrandListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandListResponse),
                jacksonTypeRef<BrandListResponse>(),
            )

        assertThat(roundtrippedBrandListResponse).isEqualTo(brandListResponse)
    }
}
