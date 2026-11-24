// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

import dm.sent.core.JsonValue
import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenDlcAddCampaignParamsTest {

    @Test
    fun create() {
        TenDlcAddCampaignParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .description("Appointment reminders for patients who opted in when booking.")
            .helpKeywords("help_keywords")
            .helpMessage("xxxxxxxxxxxxxxxxxxxx")
            .messageFlow("Patients opt in on the booking form by checking a consent box.")
            .optInKeywords("opt_in_keywords")
            .optInMessage("xxxxxxxxxxxxxxxxxxxx")
            .optOutKeywords("opt_out_keywords")
            .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
            .privacyPolicyLink("privacy_policy_link")
            .termsAndConditionsLink("terms_and_conditions_link")
            .addUseCase(
                TenDlcAddCampaignParams.UseCase.builder()
                    .addSampleMessage(
                        JsonValue.from(
                            "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                        )
                    )
                    .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                    .build()
            )
            .volume("volume")
            .sandbox(false)
            .build()
    }

    @Test
    fun headers() {
        val params =
            TenDlcAddCampaignParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .description("Appointment reminders for patients who opted in when booking.")
                .helpKeywords("help_keywords")
                .helpMessage("xxxxxxxxxxxxxxxxxxxx")
                .messageFlow("Patients opt in on the booking form by checking a consent box.")
                .optInKeywords("opt_in_keywords")
                .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                .optOutKeywords("opt_out_keywords")
                .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                .privacyPolicyLink("privacy_policy_link")
                .termsAndConditionsLink("terms_and_conditions_link")
                .addUseCase(
                    TenDlcAddCampaignParams.UseCase.builder()
                        .addSampleMessage(
                            JsonValue.from(
                                "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                            )
                        )
                        .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                        .build()
                )
                .volume("volume")
                .sandbox(false)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("Idempotency-Key", "req_abc123_retry1")
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            TenDlcAddCampaignParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .description("Appointment reminders for patients who opted in when booking.")
                .helpKeywords("help_keywords")
                .helpMessage("xxxxxxxxxxxxxxxxxxxx")
                .messageFlow("Patients opt in on the booking form by checking a consent box.")
                .optInKeywords("opt_in_keywords")
                .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                .optOutKeywords("opt_out_keywords")
                .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                .privacyPolicyLink("privacy_policy_link")
                .termsAndConditionsLink("terms_and_conditions_link")
                .addUseCase(
                    TenDlcAddCampaignParams.UseCase.builder()
                        .addSampleMessage(
                            JsonValue.from(
                                "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                            )
                        )
                        .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                        .build()
                )
                .volume("volume")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun body() {
        val params =
            TenDlcAddCampaignParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .description("Appointment reminders for patients who opted in when booking.")
                .helpKeywords("help_keywords")
                .helpMessage("xxxxxxxxxxxxxxxxxxxx")
                .messageFlow("Patients opt in on the booking form by checking a consent box.")
                .optInKeywords("opt_in_keywords")
                .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                .optOutKeywords("opt_out_keywords")
                .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                .privacyPolicyLink("privacy_policy_link")
                .termsAndConditionsLink("terms_and_conditions_link")
                .addUseCase(
                    TenDlcAddCampaignParams.UseCase.builder()
                        .addSampleMessage(
                            JsonValue.from(
                                "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                            )
                        )
                        .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                        .build()
                )
                .volume("volume")
                .sandbox(false)
                .build()

        val body = params._body()

        assertThat(body.description())
            .isEqualTo("Appointment reminders for patients who opted in when booking.")
        assertThat(body.helpKeywords()).isEqualTo("help_keywords")
        assertThat(body.helpMessage()).isEqualTo("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.messageFlow())
            .isEqualTo("Patients opt in on the booking form by checking a consent box.")
        assertThat(body.optInKeywords()).isEqualTo("opt_in_keywords")
        assertThat(body.optInMessage()).isEqualTo("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.optOutKeywords()).isEqualTo("opt_out_keywords")
        assertThat(body.optOutMessage()).isEqualTo("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.privacyPolicyLink()).isEqualTo("privacy_policy_link")
        assertThat(body.termsAndConditionsLink()).isEqualTo("terms_and_conditions_link")
        assertThat(body.useCases())
            .containsExactly(
                TenDlcAddCampaignParams.UseCase.builder()
                    .addSampleMessage(
                        JsonValue.from(
                            "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                        )
                    )
                    .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                    .build()
            )
        assertThat(body.volume()).isEqualTo("volume")
        assertThat(body.sandbox()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TenDlcAddCampaignParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .description("Appointment reminders for patients who opted in when booking.")
                .helpKeywords("help_keywords")
                .helpMessage("xxxxxxxxxxxxxxxxxxxx")
                .messageFlow("Patients opt in on the booking form by checking a consent box.")
                .optInKeywords("opt_in_keywords")
                .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                .optOutKeywords("opt_out_keywords")
                .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                .privacyPolicyLink("privacy_policy_link")
                .termsAndConditionsLink("terms_and_conditions_link")
                .addUseCase(
                    TenDlcAddCampaignParams.UseCase.builder()
                        .addSampleMessage(
                            JsonValue.from(
                                "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                            )
                        )
                        .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                        .build()
                )
                .volume("volume")
                .build()

        val body = params._body()

        assertThat(body.description())
            .isEqualTo("Appointment reminders for patients who opted in when booking.")
        assertThat(body.helpKeywords()).isEqualTo("help_keywords")
        assertThat(body.helpMessage()).isEqualTo("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.messageFlow())
            .isEqualTo("Patients opt in on the booking form by checking a consent box.")
        assertThat(body.optInKeywords()).isEqualTo("opt_in_keywords")
        assertThat(body.optInMessage()).isEqualTo("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.optOutKeywords()).isEqualTo("opt_out_keywords")
        assertThat(body.optOutMessage()).isEqualTo("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.privacyPolicyLink()).isEqualTo("privacy_policy_link")
        assertThat(body.termsAndConditionsLink()).isEqualTo("terms_and_conditions_link")
        assertThat(body.useCases())
            .containsExactly(
                TenDlcAddCampaignParams.UseCase.builder()
                    .addSampleMessage(
                        JsonValue.from(
                            "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                        )
                    )
                    .useCase(TenDlcAddCampaignParams.UseCase.InnerUseCase.ACCOUNT_NOTIFICATION)
                    .build()
            )
        assertThat(body.volume()).isEqualTo("volume")
    }
}
