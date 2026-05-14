// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfContactTest {

    @Test
    fun create() {
        val apiResponseOfContact =
            ApiResponseOfContact.builder()
                .data(
                    ContactResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .availableChannels("available_channels")
                        .countryCode("country_code")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .defaultChannel("default_channel")
                        .formatE164("format_e164")
                        .formatInternational("format_international")
                        .formatNational("format_national")
                        .formatRfc("format_rfc")
                        .isInherited(true)
                        .optOut(true)
                        .phoneNumber("phone_number")
                        .regionCode("region_code")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
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
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfContact.data())
            .contains(
                ContactResponse.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .availableChannels("available_channels")
                    .countryCode("country_code")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .defaultChannel("default_channel")
                    .formatE164("format_e164")
                    .formatInternational("format_international")
                    .formatNational("format_national")
                    .formatRfc("format_rfc")
                    .isInherited(true)
                    .optOut(true)
                    .phoneNumber("phone_number")
                    .regionCode("region_code")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(apiResponseOfContact.error())
            .contains(
                ErrorDetail.builder()
                    .code("code")
                    .details(
                        ErrorDetail.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseOfContact.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfContact.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfContact =
            ApiResponseOfContact.builder()
                .data(
                    ContactResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .availableChannels("available_channels")
                        .countryCode("country_code")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .defaultChannel("default_channel")
                        .formatE164("format_e164")
                        .formatInternational("format_international")
                        .formatNational("format_national")
                        .formatRfc("format_rfc")
                        .isInherited(true)
                        .optOut(true)
                        .phoneNumber("phone_number")
                        .regionCode("region_code")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
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
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfContact =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfContact),
                jacksonTypeRef<ApiResponseOfContact>(),
            )

        assertThat(roundtrippedApiResponseOfContact).isEqualTo(apiResponseOfContact)
    }
}
