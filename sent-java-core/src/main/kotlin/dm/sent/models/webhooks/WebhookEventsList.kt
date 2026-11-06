// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A paginated list of webhook delivery records. */
class WebhookEventsList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val events: JsonField<List<WebhookDelivery>>,
    private val pagination: JsonField<PaginationMeta>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("events")
        @ExcludeMissing
        events: JsonField<List<WebhookDelivery>> = JsonMissing.of(),
        @JsonProperty("pagination")
        @ExcludeMissing
        pagination: JsonField<PaginationMeta> = JsonMissing.of(),
    ) : this(events, pagination, mutableMapOf())

    /**
     * The events on this page.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun events(): Optional<List<WebhookDelivery>> = events.getOptional("events")

    /**
     * Pagination metadata for list responses
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun pagination(): Optional<PaginationMeta> = pagination.getOptional("pagination")

    /**
     * Returns the raw JSON value of [events].
     *
     * Unlike [events], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("events") @ExcludeMissing fun _events(): JsonField<List<WebhookDelivery>> = events

    /**
     * Returns the raw JSON value of [pagination].
     *
     * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pagination")
    @ExcludeMissing
    fun _pagination(): JsonField<PaginationMeta> = pagination

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [WebhookEventsList]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookEventsList]. */
    class Builder internal constructor() {

        private var events: JsonField<MutableList<WebhookDelivery>>? = null
        private var pagination: JsonField<PaginationMeta> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookEventsList: WebhookEventsList) = apply {
            events = webhookEventsList.events.map { it.toMutableList() }
            pagination = webhookEventsList.pagination
            additionalProperties = webhookEventsList.additionalProperties.toMutableMap()
        }

        /** The events on this page. */
        fun events(events: List<WebhookDelivery>) = events(JsonField.of(events))

        /**
         * Sets [Builder.events] to an arbitrary JSON value.
         *
         * You should usually call [Builder.events] with a well-typed `List<WebhookDelivery>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun events(events: JsonField<List<WebhookDelivery>>) = apply {
            this.events = events.map { it.toMutableList() }
        }

        /**
         * Adds a single [WebhookDelivery] to [events].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEvent(event: WebhookDelivery) = apply {
            events =
                (events ?: JsonField.of(mutableListOf())).also {
                    checkKnown("events", it).add(event)
                }
        }

        /** Pagination metadata for list responses */
        fun pagination(pagination: PaginationMeta) = pagination(JsonField.of(pagination))

        /**
         * Sets [Builder.pagination] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pagination] with a well-typed [PaginationMeta] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pagination(pagination: JsonField<PaginationMeta>) = apply {
            this.pagination = pagination
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [WebhookEventsList].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookEventsList =
            WebhookEventsList(
                (events ?: JsonMissing.of()).map { it.toImmutable() },
                pagination,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): WebhookEventsList = apply {
        if (validated) {
            return@apply
        }

        events().ifPresent { it.forEach { it.validate() } }
        pagination().ifPresent { it.validate() }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: SentInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (events.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (pagination.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookEventsList &&
            events == other.events &&
            pagination == other.pagination &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(events, pagination, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookEventsList{events=$events, pagination=$pagination, additionalProperties=$additionalProperties}"
}
