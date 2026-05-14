// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.numbers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberLookupResponseTest {

    @Test
    fun create() {
        val numberLookupResponse =
            NumberLookupResponse.builder()
                .data(
                    NumberLookupResponse.Data.builder()
                        .carrierName("carrier_name")
                        .countryCode("country_code")
                        .isPorted(true)
                        .isValid_(true)
                        .isVoip(true)
                        .lineType("line_type")
                        .mobileCountryCode("mobile_country_code")
                        .mobileNetworkCode("mobile_network_code")
                        .phoneNumber("phone_number")
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

        assertThat(numberLookupResponse.data())
            .contains(
                NumberLookupResponse.Data.builder()
                    .carrierName("carrier_name")
                    .countryCode("country_code")
                    .isPorted(true)
                    .isValid_(true)
                    .isVoip(true)
                    .lineType("line_type")
                    .mobileCountryCode("mobile_country_code")
                    .mobileNetworkCode("mobile_network_code")
                    .phoneNumber("phone_number")
                    .build()
            )
        assertThat(numberLookupResponse.error())
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
        assertThat(numberLookupResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(numberLookupResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val numberLookupResponse =
            NumberLookupResponse.builder()
                .data(
                    NumberLookupResponse.Data.builder()
                        .carrierName("carrier_name")
                        .countryCode("country_code")
                        .isPorted(true)
                        .isValid_(true)
                        .isVoip(true)
                        .lineType("line_type")
                        .mobileCountryCode("mobile_country_code")
                        .mobileNetworkCode("mobile_network_code")
                        .phoneNumber("phone_number")
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

        val roundtrippedNumberLookupResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(numberLookupResponse),
                jacksonTypeRef<NumberLookupResponse>(),
            )

        assertThat(roundtrippedNumberLookupResponse).isEqualTo(numberLookupResponse)
    }
}
