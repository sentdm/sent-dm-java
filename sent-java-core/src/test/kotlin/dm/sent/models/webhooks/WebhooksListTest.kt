// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhooksListTest {

    @Test
    fun create() {
        val webhooksList =
            WebhooksList.builder()
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .addWebhook(
                    WebhookResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .eventFilters(
                            WebhookResponse.EventFilters.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .addEventType("string")
                        .isActive(true)
                        .isInheritable(true)
                        .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .retryCount(0)
                        .senderProfile(
                            WebhookSenderProfile.builder()
                                .eventFilters(
                                    WebhookSenderProfile.EventFilters.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .addEventType("string")
                                .build()
                        )
                        .signingSecret("signing_secret")
                        .timeoutSeconds(0)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .webhookVersion(0L)
                        .build()
                )
                .build()

        assertThat(webhooksList.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(PaginationCursors.builder().after("after").before("before").build())
                    .hasMore(true)
                    .page(0)
                    .pageSize(0)
                    .totalCount(0)
                    .totalPages(0)
                    .build()
            )
        assertThat(webhooksList.webhooks().getOrNull())
            .containsExactly(
                WebhookResponse.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .consecutiveFailures(0)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .displayName("display_name")
                    .endpointUrl("endpoint_url")
                    .eventFilters(
                        WebhookResponse.EventFilters.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .addEventType("string")
                    .isActive(true)
                    .isInheritable(true)
                    .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .retryCount(0)
                    .senderProfile(
                        WebhookSenderProfile.builder()
                            .eventFilters(
                                WebhookSenderProfile.EventFilters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .addEventType("string")
                            .build()
                    )
                    .signingSecret("signing_secret")
                    .timeoutSeconds(0)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .webhookVersion(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhooksList =
            WebhooksList.builder()
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .addWebhook(
                    WebhookResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .eventFilters(
                            WebhookResponse.EventFilters.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .addEventType("string")
                        .isActive(true)
                        .isInheritable(true)
                        .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .retryCount(0)
                        .senderProfile(
                            WebhookSenderProfile.builder()
                                .eventFilters(
                                    WebhookSenderProfile.EventFilters.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .addEventType("string")
                                .build()
                        )
                        .signingSecret("signing_secret")
                        .timeoutSeconds(0)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .webhookVersion(0L)
                        .build()
                )
                .build()

        val roundtrippedWebhooksList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhooksList),
                jacksonTypeRef<WebhooksList>(),
            )

        assertThat(roundtrippedWebhooksList).isEqualTo(webhooksList)
    }
}
