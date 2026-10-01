// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallRetrieveParamsTest {

    @Test
    fun create() {
        CallRetrieveParams.builder()
            .id("call_9f2ab000-0000-4000-8000-000000000001")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CallRetrieveParams.builder().id("call_9f2ab000-0000-4000-8000-000000000001").build()

        assertThat(params._pathParam(0)).isEqualTo("call_9f2ab000-0000-4000-8000-000000000001")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            CallRetrieveParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            CallRetrieveParams.builder().id("call_9f2ab000-0000-4000-8000-000000000001").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
