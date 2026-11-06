// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileUpdateParamsTest {

    @Test
    fun create() {
        SenderProfileUpdateParams.builder()
            .id("770e8400-e29b-41d4-a716-446655440002")
            .idempotencyKey("req_abc123_retry1")
            .sandbox(false)
            .description(null)
            .name("Example Retail Renamed")
            .notifications(null)
            .shortName("EXMPL")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SenderProfileUpdateParams.builder().id("770e8400-e29b-41d4-a716-446655440002").build()

        assertThat(params._pathParam(0)).isEqualTo("770e8400-e29b-41d4-a716-446655440002")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            SenderProfileUpdateParams.builder()
                .id("770e8400-e29b-41d4-a716-446655440002")
                .idempotencyKey("req_abc123_retry1")
                .sandbox(false)
                .description(null)
                .name("Example Retail Renamed")
                .notifications(null)
                .shortName("EXMPL")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            SenderProfileUpdateParams.builder().id("770e8400-e29b-41d4-a716-446655440002").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            SenderProfileUpdateParams.builder()
                .id("770e8400-e29b-41d4-a716-446655440002")
                .idempotencyKey("req_abc123_retry1")
                .sandbox(false)
                .description(null)
                .name("Example Retail Renamed")
                .notifications(null)
                .shortName("EXMPL")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.description()).isEmpty
        assertThat(body.name()).contains("Example Retail Renamed")
        assertThat(body.notifications()).isEmpty
        assertThat(body.shortName()).contains("EXMPL")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SenderProfileUpdateParams.builder().id("770e8400-e29b-41d4-a716-446655440002").build()

        val body = params._body()
    }
}
