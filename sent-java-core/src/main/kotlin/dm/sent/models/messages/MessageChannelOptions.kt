// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

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
 * One entry of a channel's list in Channels, e.g. {"country": "US", "from":
 * ["+15559990002", "+15559990003"], "strategy": "sticky"}.
 */
class MessageChannelOptions
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val country: JsonField<String>,
    private val from: JsonField<List<String>>,
    private val strategy: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("from") @ExcludeMissing from: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("strategy") @ExcludeMissing strategy: JsonField<String> = JsonMissing.of(),
    ) : this(country, from, strategy, mutableMapOf())

    /**
     * Recipient country this entry is meant for (ISO 3166-1 alpha-2, e.g. US). Optional. Accepted
     * and stored, not acted on yet.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun country(): Optional<String> = country.getOptional("country")

    /**
     * Sender numbers in E.164. Each must be an active sender on your account for this channel. That
     * is account state rather than request shape, so it is decided per message: the request is
     * accepted with 202 and a message naming an unusable number is recorded BLOCKED with error code
     * BUSINESS_029.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun from(): Optional<List<String>> = from.getOptional("from")

    /**
     * How to pick a number from From, e.g. sticky or geo. Optional. Accepted and stored, not acted
     * on yet.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun strategy(): Optional<String> = strategy.getOptional("strategy")

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

    /**
     * Returns the raw JSON value of [from].
     *
     * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<List<String>> = from

    /**
     * Returns the raw JSON value of [strategy].
     *
     * Unlike [strategy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("strategy") @ExcludeMissing fun _strategy(): JsonField<String> = strategy

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

        /** Returns a mutable builder for constructing an instance of [MessageChannelOptions]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageChannelOptions]. */
    class Builder internal constructor() {

        private var country: JsonField<String> = JsonMissing.of()
        private var from: JsonField<MutableList<String>>? = null
        private var strategy: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageChannelOptions: MessageChannelOptions) = apply {
            country = messageChannelOptions.country
            from = messageChannelOptions.from.map { it.toMutableList() }
            strategy = messageChannelOptions.strategy
            additionalProperties = messageChannelOptions.additionalProperties.toMutableMap()
        }

        /**
         * Recipient country this entry is meant for (ISO 3166-1 alpha-2, e.g. US). Optional.
         * Accepted and stored, not acted on yet.
         */
        fun country(country: String?) = country(JsonField.ofNullable(country))

        /** Alias for calling [Builder.country] with `country.orElse(null)`. */
        fun country(country: Optional<String>) = country(country.getOrNull())

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<String>) = apply { this.country = country }

        /**
         * Sender numbers in E.164. Each must be an active sender on your account for this channel.
         * That is account state rather than request shape, so it is decided per message: the
         * request is accepted with 202 and a message naming an unusable number is recorded BLOCKED
         * with error code BUSINESS_029.
         */
        fun from(from: List<String>?) = from(JsonField.ofNullable(from))

        /** Alias for calling [Builder.from] with `from.orElse(null)`. */
        fun from(from: Optional<List<String>>) = from(from.getOrNull())

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun from(from: JsonField<List<String>>) = apply {
            this.from = from.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [Builder.from].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFrom(from: String) = apply {
            this.from =
                (this.from ?: JsonField.of(mutableListOf())).also {
                    checkKnown("from", it).add(from)
                }
        }

        /**
         * How to pick a number from From, e.g. sticky or geo. Optional. Accepted and stored, not
         * acted on yet.
         */
        fun strategy(strategy: String?) = strategy(JsonField.ofNullable(strategy))

        /** Alias for calling [Builder.strategy] with `strategy.orElse(null)`. */
        fun strategy(strategy: Optional<String>) = strategy(strategy.getOrNull())

        /**
         * Sets [Builder.strategy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.strategy] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun strategy(strategy: JsonField<String>) = apply { this.strategy = strategy }

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
         * Returns an immutable instance of [MessageChannelOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageChannelOptions =
            MessageChannelOptions(
                country,
                (from ?: JsonMissing.of()).map { it.toImmutable() },
                strategy,
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
    fun validate(): MessageChannelOptions = apply {
        if (validated) {
            return@apply
        }

        country()
        from()
        strategy()
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
        (if (country.asKnown().isPresent) 1 else 0) +
            (from.asKnown().getOrNull()?.size ?: 0) +
            (if (strategy.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageChannelOptions &&
            country == other.country &&
            from == other.from &&
            strategy == other.strategy &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(country, from, strategy, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageChannelOptions{country=$country, from=$from, strategy=$strategy, additionalProperties=$additionalProperties}"
}
