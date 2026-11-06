// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.compliance.ComplianceRetrieveRequirementsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ComplianceServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveRequirements() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val complianceService = client.compliance()

        val apiResponseOfComplianceRequirements =
            complianceService.retrieveRequirements(
                ComplianceRetrieveRequirementsParams.builder()
                    .channel("channel")
                    .country("country")
                    .type("type")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfComplianceRequirements.validate()
    }
}
