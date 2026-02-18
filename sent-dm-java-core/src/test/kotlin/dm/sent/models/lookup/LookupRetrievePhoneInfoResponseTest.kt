// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.lookup

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LookupRetrievePhoneInfoResponseTest {

    @Test
    fun create() {
        val lookupRetrievePhoneInfoResponse =
            LookupRetrievePhoneInfoResponse.builder()
                .data(
                    LookupRetrievePhoneInfoResponse.Data.builder()
                        .carrierName("carrierName")
                        .isPorted(true)
                        .isValid(true)
                        .isVoip(true)
                        .lineType("lineType")
                        .mobileCountryCode("mobileCountryCode")
                        .mobileNetworkCode("mobileNetworkCode")
                        .phoneNumber("phoneNumber")
                        .provider("provider")
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

        assertThat(lookupRetrievePhoneInfoResponse.data())
            .contains(
                LookupRetrievePhoneInfoResponse.Data.builder()
                    .carrierName("carrierName")
                    .isPorted(true)
                    .isValid(true)
                    .isVoip(true)
                    .lineType("lineType")
                    .mobileCountryCode("mobileCountryCode")
                    .mobileNetworkCode("mobileNetworkCode")
                    .phoneNumber("phoneNumber")
                    .provider("provider")
                    .build()
            )
        assertThat(lookupRetrievePhoneInfoResponse.error())
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
        assertThat(lookupRetrievePhoneInfoResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(lookupRetrievePhoneInfoResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val lookupRetrievePhoneInfoResponse =
            LookupRetrievePhoneInfoResponse.builder()
                .data(
                    LookupRetrievePhoneInfoResponse.Data.builder()
                        .carrierName("carrierName")
                        .isPorted(true)
                        .isValid(true)
                        .isVoip(true)
                        .lineType("lineType")
                        .mobileCountryCode("mobileCountryCode")
                        .mobileNetworkCode("mobileNetworkCode")
                        .phoneNumber("phoneNumber")
                        .provider("provider")
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

        val roundtrippedLookupRetrievePhoneInfoResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(lookupRetrievePhoneInfoResponse),
                jacksonTypeRef<LookupRetrievePhoneInfoResponse>(),
            )

        assertThat(roundtrippedLookupRetrievePhoneInfoResponse)
            .isEqualTo(lookupRetrievePhoneInfoResponse)
    }
}
