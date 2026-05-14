// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateDeleteParamsTest {

    @Test
    fun create() {
        TemplateDeleteParams.builder()
            .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .deleteFromMeta(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TemplateDeleteParams.builder().id("7ba7b820-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            TemplateDeleteParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .deleteFromMeta(false)
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
            TemplateDeleteParams.builder().id("7ba7b820-9dad-11d1-80b4-00c04fd430c8").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            TemplateDeleteParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .deleteFromMeta(false)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.deleteFromMeta()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TemplateDeleteParams.builder().id("7ba7b820-9dad-11d1-80b4-00c04fd430c8").build()

        val body = params._body()
    }
}
