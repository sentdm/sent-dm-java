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

/**
 * Request-only: the events an organization webhook's sender profile clones receive, one clone per
 * existing and future profile. A version 1 webhook's responses report it as
 * WebhookSenderProfileV3Response.
 */
class WebhookSenderProfileConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventFilters: JsonField<EventFilters>,
    private val eventTypes: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_filters")
        @ExcludeMissing
        eventFilters: JsonField<EventFilters> = JsonMissing.of(),
        @JsonProperty("event_types")
        @ExcludeMissing
        eventTypes: JsonField<List<String>> = JsonMissing.of(),
    ) : this(eventFilters, eventTypes, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun eventFilters(): Optional<EventFilters> = eventFilters.getOptional("event_filters")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun eventTypes(): Optional<List<String>> = eventTypes.getOptional("event_types")

    /**
     * Returns the raw JSON value of [eventFilters].
     *
     * Unlike [eventFilters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_filters")
    @ExcludeMissing
    fun _eventFilters(): JsonField<EventFilters> = eventFilters

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_types")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<String>> = eventTypes

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

        /**
         * Returns a mutable builder for constructing an instance of [WebhookSenderProfileConfig].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookSenderProfileConfig]. */
    class Builder internal constructor() {

        private var eventFilters: JsonField<EventFilters> = JsonMissing.of()
        private var eventTypes: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookSenderProfileConfig: WebhookSenderProfileConfig) = apply {
            eventFilters = webhookSenderProfileConfig.eventFilters
            eventTypes = webhookSenderProfileConfig.eventTypes.map { it.toMutableList() }
            additionalProperties = webhookSenderProfileConfig.additionalProperties.toMutableMap()
        }

        fun eventFilters(eventFilters: EventFilters?) =
            eventFilters(JsonField.ofNullable(eventFilters))

        /** Alias for calling [Builder.eventFilters] with `eventFilters.orElse(null)`. */
        fun eventFilters(eventFilters: Optional<EventFilters>) =
            eventFilters(eventFilters.getOrNull())

        /**
         * Sets [Builder.eventFilters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventFilters] with a well-typed [EventFilters] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventFilters(eventFilters: JsonField<EventFilters>) = apply {
            this.eventFilters = eventFilters
        }

        fun eventTypes(eventTypes: List<String>) = eventTypes(JsonField.of(eventTypes))

        /**
         * Sets [Builder.eventTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventTypes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventTypes(eventTypes: JsonField<List<String>>) = apply {
            this.eventTypes = eventTypes.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: String) = apply {
            eventTypes =
                (eventTypes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("eventTypes", it).add(eventType)
                }
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
         * Returns an immutable instance of [WebhookSenderProfileConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookSenderProfileConfig =
            WebhookSenderProfileConfig(
                eventFilters,
                (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): WebhookSenderProfileConfig = apply {
        if (validated) {
            return@apply
        }

        eventFilters().ifPresent { it.validate() }
        eventTypes()
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
        (eventFilters.asKnown().getOrNull()?.validity() ?: 0) +
            (eventTypes.asKnown().getOrNull()?.size ?: 0)

    class EventFilters
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [EventFilters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EventFilters]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(eventFilters: EventFilters) = apply {
                additionalProperties = eventFilters.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [EventFilters].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): EventFilters = EventFilters(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws SentInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): EventFilters = apply {
            if (validated) {
                return@apply
            }

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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EventFilters && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "EventFilters{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookSenderProfileConfig &&
            eventFilters == other.eventFilters &&
            eventTypes == other.eventTypes &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventFilters, eventTypes, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookSenderProfileConfig{eventFilters=$eventFilters, eventTypes=$eventTypes, additionalProperties=$additionalProperties}"
}
