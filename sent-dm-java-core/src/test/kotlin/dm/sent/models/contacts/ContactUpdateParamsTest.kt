// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactUpdateParamsTest {

    @Test
    fun create() {
        ContactUpdateParams.builder()
            .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .defaultChannel("whatsapp")
            .optOut(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ContactUpdateParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ContactUpdateParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .defaultChannel("whatsapp")
                .optOut(false)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            ContactUpdateParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ContactUpdateParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .defaultChannel("whatsapp")
                .optOut(false)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.defaultChannel()).contains("whatsapp")
        assertThat(body.optOut()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContactUpdateParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        val body = params._body()
    }
}
