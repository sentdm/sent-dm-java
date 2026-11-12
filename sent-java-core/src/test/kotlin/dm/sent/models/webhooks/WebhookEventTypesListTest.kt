// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEventTypesListTest {

    @Test
    fun create() {
        val webhookEventTypesList =
            WebhookEventTypesList.builder()
                .addEventType(
                    WebhookEventType.builder()
                        .description("description")
                        .displayName("display_name")
                        .eventType("event_type")
                        .isActive(true)
                        .name("name")
                        .subTypes(listOf())
                        .build()
                )
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
                .build()

        assertThat(webhookEventTypesList.eventTypes().getOrNull())
            .containsExactly(
                WebhookEventType.builder()
                    .description("description")
                    .displayName("display_name")
                    .eventType("event_type")
                    .isActive(true)
                    .name("name")
                    .subTypes(listOf())
                    .build()
            )
        assertThat(webhookEventTypesList.pagination())
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEventTypesList =
            WebhookEventTypesList.builder()
                .addEventType(
                    WebhookEventType.builder()
                        .description("description")
                        .displayName("display_name")
                        .eventType("event_type")
                        .isActive(true)
                        .name("name")
                        .subTypes(listOf())
                        .build()
                )
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
                .build()

        val roundtrippedWebhookEventTypesList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEventTypesList),
                jacksonTypeRef<WebhookEventTypesList>(),
            )

        assertThat(roundtrippedWebhookEventTypesList).isEqualTo(webhookEventTypesList)
    }
}
