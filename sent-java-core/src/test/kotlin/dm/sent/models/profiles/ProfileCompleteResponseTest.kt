// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompleteResponseTest {

    @Test
    fun create() {
        val profileCompleteResponse =
            ProfileCompleteResponse.builder()
                .data(
                    ProfileCompleteResponse.Data.builder()
                        .message("message")
                        .status("status")
                        .build()
                )
                .error(
                    ProfileCompleteResponse.Error.builder()
                        .code("code")
                        .details(
                            ProfileCompleteResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ProfileCompleteResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(profileCompleteResponse.data())
            .contains(
                ProfileCompleteResponse.Data.builder().message("message").status("status").build()
            )
        assertThat(profileCompleteResponse.error())
            .contains(
                ProfileCompleteResponse.Error.builder()
                    .code("code")
                    .details(
                        ProfileCompleteResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(profileCompleteResponse.meta())
            .contains(
                ProfileCompleteResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(profileCompleteResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileCompleteResponse =
            ProfileCompleteResponse.builder()
                .data(
                    ProfileCompleteResponse.Data.builder()
                        .message("message")
                        .status("status")
                        .build()
                )
                .error(
                    ProfileCompleteResponse.Error.builder()
                        .code("code")
                        .details(
                            ProfileCompleteResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ProfileCompleteResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedProfileCompleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileCompleteResponse),
                jacksonTypeRef<ProfileCompleteResponse>(),
            )

        assertThat(roundtrippedProfileCompleteResponse).isEqualTo(profileCompleteResponse)
    }
}
