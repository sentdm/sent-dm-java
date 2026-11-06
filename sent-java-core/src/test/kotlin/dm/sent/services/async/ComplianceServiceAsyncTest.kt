// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.compliance.ComplianceRetrieveRequirementsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ComplianceServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveRequirements() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val complianceServiceAsync = client.compliance()

        val apiResponseOfComplianceRequirementsFuture =
            complianceServiceAsync.retrieveRequirements(
                ComplianceRetrieveRequirementsParams.builder()
                    .channel("channel")
                    .country("country")
                    .type("type")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfComplianceRequirements = apiResponseOfComplianceRequirementsFuture.get()
        apiResponseOfComplianceRequirements.validate()
    }
}
