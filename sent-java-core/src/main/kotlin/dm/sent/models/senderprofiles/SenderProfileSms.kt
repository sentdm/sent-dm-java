// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.sms.SmsNumberRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * One SMS market a profile sends in — a country and a sender type.
 *
 * A profile may have several. It is a tenant, not a market: a business sending to two countries is
 * one customer of yours, and forcing it into two profiles would give it two API keys, two inboxes
 * and two contact lists for one business. The platform already assumes many —
 * CustomerChannelProviders is unique on (customer, channel, iso, number).
 *
 * No mode: a sender is the profile's own or it has none. Listing a market is the request for one.
 *
 * Also the discriminator for everything else: the compliance catalog is keyed on (country, number
 * type), and that pair decides which fields brand accepts and what compliance is asked for.
 */
class SenderProfileSms
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val country: JsonField<String>,
    private val areaCodes: JsonField<List<String>>,
    private val numberType: JsonField<String>,
    private val numbers: JsonField<List<SmsNumberRequest>>,
    private val senderValue: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("area_codes")
        @ExcludeMissing
        areaCodes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("number_type")
        @ExcludeMissing
        numberType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("numbers")
        @ExcludeMissing
        numbers: JsonField<List<SmsNumberRequest>> = JsonMissing.of(),
        @JsonProperty("sender_value")
        @ExcludeMissing
        senderValue: JsonField<String> = JsonMissing.of(),
    ) : this(country, areaCodes, numberType, numbers, senderValue, mutableMapOf())

    /**
     * ISO 3166-1 alpha-2 country the sender operates in, e.g. US.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun country(): String = country.getRequired("country")

    /**
     * The area codes to put this sender in, in your own order of preference, e.g. ["415", "628"]
     * for the US or ["20"] for London. Omit it and a number is claimed anywhere in the country.
     *
     * Ordered, and the order is the request. The claim tries each code in turn and stops at the
     * first that yields a number. Nothing sorts the list and a code listed twice is refused.
     *
     * One to fifty entries, each the area code as digits: 415, with the trunk prefix as 020, or
     * with the country's dialing prefix as +1415 (all are stored as the bare code). A dialing
     * prefix from a different country than country is refused. Each code is checked against the
     * country's numbering plan: it must start real local or mobile numbers there, so toll-free and
     * premium ranges, service codes and another country's codes are refused with a reason.
     *
     * LOCAL senders in any country, and US TEN_DLC senders. No other sender type has a geographic
     * area code, and the list is refused with one rather than accepted and dropped.
     *
     * Honoured exactly or not at all. Ask for 415 and you get a 415 number or you get none, never a
     * neighbouring code you did not name. A miss leaves the market with no sender yet and the codes
     * recorded on it, so it is filled when stock appears rather than filled now from somewhere
     * else. Many countries outside North America require address or business documents before a
     * local number can be bought, which can delay or prevent the fill.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun areaCodes(): Optional<List<String>> = areaCodes.getOptional("area_codes")

    /**
     * Sender type: LOCAL, MOBILE, TEN_DLC, TOLL_FREE, SHORT_CODE or ALPHANUMERIC. 10DLC is accepted
     * as a synonym of TEN_DLC. Availability varies by country.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun numberType(): Optional<String> = numberType.getOptional("number_type")

    /**
     * The numbers to assign, one entry per area code, e.g.
     * [{"area_code": "212", "quantity": 2}, {"area_code": "415"}, {"quantity": 1}]: two numbers in
     * 212, one in 415 and one in any area code. quantity defaults to 1, and an entry without
     * area_code means any area code. Omit numbers for one number.
     *
     * Only with LOCAL or TEN_DLC, and not together with area_codes. Each area code is validated
     * against country the same way area_codes is and may appear once, and at most one entry may
     * leave area_code out. US TEN_DLC numbers are assigned when the campaign is approved, not at
     * request time. Not available when the profile inherits the organization's campaign.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun numbers(): Optional<List<SmsNumberRequest>> = numbers.getOptional("numbers")

    /**
     * The sender's identity, where the caller chooses it rather than the carrier assigning it.
     * Required when number_type is ALPHANUMERIC; omit for carrier-assigned types and one is
     * provisioned.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

    /**
     * Returns the raw JSON value of [areaCodes].
     *
     * Unlike [areaCodes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("area_codes")
    @ExcludeMissing
    fun _areaCodes(): JsonField<List<String>> = areaCodes

    /**
     * Returns the raw JSON value of [numberType].
     *
     * Unlike [numberType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number_type") @ExcludeMissing fun _numberType(): JsonField<String> = numberType

    /**
     * Returns the raw JSON value of [numbers].
     *
     * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("numbers")
    @ExcludeMissing
    fun _numbers(): JsonField<List<SmsNumberRequest>> = numbers

    /**
     * Returns the raw JSON value of [senderValue].
     *
     * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_value")
    @ExcludeMissing
    fun _senderValue(): JsonField<String> = senderValue

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
         * Returns a mutable builder for constructing an instance of [SenderProfileSms].
         *
         * The following fields are required:
         * ```java
         * .country()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileSms]. */
    class Builder internal constructor() {

        private var country: JsonField<String>? = null
        private var areaCodes: JsonField<MutableList<String>>? = null
        private var numberType: JsonField<String> = JsonMissing.of()
        private var numbers: JsonField<MutableList<SmsNumberRequest>>? = null
        private var senderValue: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfileSms: SenderProfileSms) = apply {
            country = senderProfileSms.country
            areaCodes = senderProfileSms.areaCodes.map { it.toMutableList() }
            numberType = senderProfileSms.numberType
            numbers = senderProfileSms.numbers.map { it.toMutableList() }
            senderValue = senderProfileSms.senderValue
            additionalProperties = senderProfileSms.additionalProperties.toMutableMap()
        }

        /** ISO 3166-1 alpha-2 country the sender operates in, e.g. US. */
        fun country(country: String) = country(JsonField.of(country))

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<String>) = apply { this.country = country }

        /**
         * The area codes to put this sender in, in your own order of preference, e.g.
         * ["415", "628"] for the US or ["20"] for London. Omit it and a number is claimed anywhere
         * in the country.
         *
         * Ordered, and the order is the request. The claim tries each code in turn and stops at the
         * first that yields a number. Nothing sorts the list and a code listed twice is refused.
         *
         * One to fifty entries, each the area code as digits: 415, with the trunk prefix as 020, or
         * with the country's dialing prefix as +1415 (all are stored as the bare code). A dialing
         * prefix from a different country than country is refused. Each code is checked against the
         * country's numbering plan: it must start real local or mobile numbers there, so toll-free
         * and premium ranges, service codes and another country's codes are refused with a reason.
         *
         * LOCAL senders in any country, and US TEN_DLC senders. No other sender type has a
         * geographic area code, and the list is refused with one rather than accepted and dropped.
         *
         * Honoured exactly or not at all. Ask for 415 and you get a 415 number or you get none,
         * never a neighbouring code you did not name. A miss leaves the market with no sender yet
         * and the codes recorded on it, so it is filled when stock appears rather than filled now
         * from somewhere else. Many countries outside North America require address or business
         * documents before a local number can be bought, which can delay or prevent the fill.
         */
        fun areaCodes(areaCodes: List<String>?) = areaCodes(JsonField.ofNullable(areaCodes))

        /** Alias for calling [Builder.areaCodes] with `areaCodes.orElse(null)`. */
        fun areaCodes(areaCodes: Optional<List<String>>) = areaCodes(areaCodes.getOrNull())

        /**
         * Sets [Builder.areaCodes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.areaCodes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun areaCodes(areaCodes: JsonField<List<String>>) = apply {
            this.areaCodes = areaCodes.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [areaCodes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAreaCode(areaCode: String) = apply {
            areaCodes =
                (areaCodes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("areaCodes", it).add(areaCode)
                }
        }

        /**
         * Sender type: LOCAL, MOBILE, TEN_DLC, TOLL_FREE, SHORT_CODE or ALPHANUMERIC. 10DLC is
         * accepted as a synonym of TEN_DLC. Availability varies by country.
         */
        fun numberType(numberType: String?) = numberType(JsonField.ofNullable(numberType))

        /** Alias for calling [Builder.numberType] with `numberType.orElse(null)`. */
        fun numberType(numberType: Optional<String>) = numberType(numberType.getOrNull())

        /**
         * Sets [Builder.numberType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numberType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun numberType(numberType: JsonField<String>) = apply { this.numberType = numberType }

        /**
         * The numbers to assign, one entry per area code, e.g.
         * [{"area_code": "212", "quantity": 2}, {"area_code": "415"}, {"quantity": 1}]: two numbers
         * in 212, one in 415 and one in any area code. quantity defaults to 1, and an entry without
         * area_code means any area code. Omit numbers for one number.
         *
         * Only with LOCAL or TEN_DLC, and not together with area_codes. Each area code is validated
         * against country the same way area_codes is and may appear once, and at most one entry may
         * leave area_code out. US TEN_DLC numbers are assigned when the campaign is approved, not
         * at request time. Not available when the profile inherits the organization's campaign.
         */
        fun numbers(numbers: List<SmsNumberRequest>?) = numbers(JsonField.ofNullable(numbers))

        /** Alias for calling [Builder.numbers] with `numbers.orElse(null)`. */
        fun numbers(numbers: Optional<List<SmsNumberRequest>>) = numbers(numbers.getOrNull())

        /**
         * Sets [Builder.numbers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numbers] with a well-typed `List<SmsNumberRequest>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun numbers(numbers: JsonField<List<SmsNumberRequest>>) = apply {
            this.numbers = numbers.map { it.toMutableList() }
        }

        /**
         * Adds a single [SmsNumberRequest] to [numbers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addNumber(number: SmsNumberRequest) = apply {
            numbers =
                (numbers ?: JsonField.of(mutableListOf())).also {
                    checkKnown("numbers", it).add(number)
                }
        }

        /**
         * The sender's identity, where the caller chooses it rather than the carrier assigning it.
         * Required when number_type is ALPHANUMERIC; omit for carrier-assigned types and one is
         * provisioned.
         */
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
         * Returns an immutable instance of [SenderProfileSms].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .country()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SenderProfileSms =
            SenderProfileSms(
                checkRequired("country", country),
                (areaCodes ?: JsonMissing.of()).map { it.toImmutable() },
                numberType,
                (numbers ?: JsonMissing.of()).map { it.toImmutable() },
                senderValue,
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
    fun validate(): SenderProfileSms = apply {
        if (validated) {
            return@apply
        }

        country()
        areaCodes()
        numberType()
        numbers().ifPresent { it.forEach { it.validate() } }
        senderValue()
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
            (areaCodes.asKnown().getOrNull()?.size ?: 0) +
            (if (numberType.asKnown().isPresent) 1 else 0) +
            (numbers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (senderValue.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfileSms &&
            country == other.country &&
            areaCodes == other.areaCodes &&
            numberType == other.numberType &&
            numbers == other.numbers &&
            senderValue == other.senderValue &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(country, areaCodes, numberType, numbers, senderValue, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfileSms{country=$country, areaCodes=$areaCodes, numberType=$numberType, numbers=$numbers, senderValue=$senderValue, additionalProperties=$additionalProperties}"
}
