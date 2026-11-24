// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** One number the customer holds, or is still owed. */
class MarketNumber
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val areaCode: JsonField<String>,
    private val campaignId: JsonField<String>,
    private val senderValue: JsonField<String>,
    private val status: JsonField<String>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("area_code") @ExcludeMissing areaCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("campaign_id")
        @ExcludeMissing
        campaignId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sender_value")
        @ExcludeMissing
        senderValue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(areaCode, campaignId, senderValue, status, type, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun areaCode(): Optional<String> = areaCode.getOptional("area_code")

    /**
     * The campaign the number belongs to (US TEN_DLC); null otherwise.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun campaignId(): Optional<String> = campaignId.getOptional("campaign_id")

    /**
     * The number, or the sender id; null until it is assigned.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

    /**
     * ACTIVE, PROVISIONING or INACTIVE.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * The market's sender type, e.g. TEN_DLC, LOCAL.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [areaCode].
     *
     * Unlike [areaCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("area_code") @ExcludeMissing fun _areaCode(): JsonField<String> = areaCode

    /**
     * Returns the raw JSON value of [campaignId].
     *
     * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("campaign_id") @ExcludeMissing fun _campaignId(): JsonField<String> = campaignId

    /**
     * Returns the raw JSON value of [senderValue].
     *
     * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_value")
    @ExcludeMissing
    fun _senderValue(): JsonField<String> = senderValue

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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

        /** Returns a mutable builder for constructing an instance of [MarketNumber]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MarketNumber]. */
    class Builder internal constructor() {

        private var areaCode: JsonField<String> = JsonMissing.of()
        private var campaignId: JsonField<String> = JsonMissing.of()
        private var senderValue: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(marketNumber: MarketNumber) = apply {
            areaCode = marketNumber.areaCode
            campaignId = marketNumber.campaignId
            senderValue = marketNumber.senderValue
            status = marketNumber.status
            type = marketNumber.type
            additionalProperties = marketNumber.additionalProperties.toMutableMap()
        }

        fun areaCode(areaCode: String?) = areaCode(JsonField.ofNullable(areaCode))

        /** Alias for calling [Builder.areaCode] with `areaCode.orElse(null)`. */
        fun areaCode(areaCode: Optional<String>) = areaCode(areaCode.getOrNull())

        /**
         * Sets [Builder.areaCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.areaCode] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun areaCode(areaCode: JsonField<String>) = apply { this.areaCode = areaCode }

        /** The campaign the number belongs to (US TEN_DLC); null otherwise. */
        fun campaignId(campaignId: String?) = campaignId(JsonField.ofNullable(campaignId))

        /** Alias for calling [Builder.campaignId] with `campaignId.orElse(null)`. */
        fun campaignId(campaignId: Optional<String>) = campaignId(campaignId.getOrNull())

        /**
         * Sets [Builder.campaignId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaignId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun campaignId(campaignId: JsonField<String>) = apply { this.campaignId = campaignId }

        /** The number, or the sender id; null until it is assigned. */
        fun senderValue(senderValue: String?) = senderValue(JsonField.ofNullable(senderValue))

        /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
        fun senderValue(senderValue: Optional<String>) = senderValue(senderValue.getOrNull())

        /**
         * Sets [Builder.senderValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun senderValue(senderValue: JsonField<String>) = apply { this.senderValue = senderValue }

        /** ACTIVE, PROVISIONING or INACTIVE. */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** The market's sender type, e.g. TEN_DLC, LOCAL. */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

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
         * Returns an immutable instance of [MarketNumber].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MarketNumber =
            MarketNumber(
                areaCode,
                campaignId,
                senderValue,
                status,
                type,
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
    fun validate(): MarketNumber = apply {
        if (validated) {
            return@apply
        }

        areaCode()
        campaignId()
        senderValue()
        status()
        type()
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
        (if (areaCode.asKnown().isPresent) 1 else 0) +
            (if (campaignId.asKnown().isPresent) 1 else 0) +
            (if (senderValue.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MarketNumber &&
            areaCode == other.areaCode &&
            campaignId == other.campaignId &&
            senderValue == other.senderValue &&
            status == other.status &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(areaCode, campaignId, senderValue, status, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MarketNumber{areaCode=$areaCode, campaignId=$campaignId, senderValue=$senderValue, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
