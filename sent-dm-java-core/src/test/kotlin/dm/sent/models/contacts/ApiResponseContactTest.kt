// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseContactTest {

    @Test
    fun create() {
        val apiResponseContact =
            ApiResponseContact.builder()
                .data(
                    Contact.builder()
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

        assertThat(apiResponseContact.data())
            .contains(
                Contact.builder()
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
        assertThat(apiResponseContact.error())
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
        assertThat(apiResponseContact.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseContact.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseContact =
            ApiResponseContact.builder()
                .data(
                    Contact.builder()
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

        val roundtrippedApiResponseContact =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseContact),
                jacksonTypeRef<ApiResponseContact>(),
            )

        assertThat(roundtrippedApiResponseContact).isEqualTo(apiResponseContact)
    }
}
