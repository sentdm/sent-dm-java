// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Represents a contact in the customer's contact list */
class ContactListItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val availableChannels: JsonField<String>,
    private val countryCode: JsonField<String>,
    private val defaultChannel: JsonField<String>,
    private val formatE164: JsonField<String>,
    private val formatInternational: JsonField<String>,
    private val formatNational: JsonField<String>,
    private val formatRfc: JsonField<String>,
    private val phoneNumber: JsonField<String>,
    private val regionCode: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("availableChannels")
        @ExcludeMissing
        availableChannels: JsonField<String> = JsonMissing.of(),
        @JsonProperty("countryCode")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("defaultChannel")
        @ExcludeMissing
        defaultChannel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("formatE164")
        @ExcludeMissing
        formatE164: JsonField<String> = JsonMissing.of(),
        @JsonProperty("formatInternational")
        @ExcludeMissing
        formatInternational: JsonField<String> = JsonMissing.of(),
        @JsonProperty("formatNational")
        @ExcludeMissing
        formatNational: JsonField<String> = JsonMissing.of(),
        @JsonProperty("formatRfc") @ExcludeMissing formatRfc: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phoneNumber")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("regionCode") @ExcludeMissing regionCode: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        availableChannels,
        countryCode,
        defaultChannel,
        formatE164,
        formatInternational,
        formatNational,
        formatRfc,
        phoneNumber,
        regionCode,
        mutableMapOf(),
    )

    /**
     * The unique identifier of the contact
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Comma-separated list of available messaging channels for this contact (e.g., "sms,whatsapp")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun availableChannels(): Optional<String> = availableChannels.getOptional("availableChannels")

    /**
     * The country calling code (e.g., 1 for US/Canada)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

    /**
     * The default messaging channel to use for this contact (e.g., "sms" or "whatsapp")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun defaultChannel(): Optional<String> = defaultChannel.getOptional("defaultChannel")

    /**
     * The phone number formatted in E.164 standard (e.g., +1234567890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatE164(): Optional<String> = formatE164.getOptional("formatE164")

    /**
     * The phone number formatted for international dialing (e.g., +1 234-567-890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatInternational(): Optional<String> =
        formatInternational.getOptional("formatInternational")

    /**
     * The phone number formatted for national dialing (e.g., (234) 567-890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatNational(): Optional<String> = formatNational.getOptional("formatNational")

    /**
     * The phone number formatted according to RFC 3966 (e.g., tel:+1-234-567-890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatRfc(): Optional<String> = formatRfc.getOptional("formatRfc")

    /**
     * The phone number in its original format
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phoneNumber")

    /**
     * The ISO 3166-1 alpha-2 country code (e.g., US, CA, GB)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun regionCode(): Optional<String> = regionCode.getOptional("regionCode")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [availableChannels].
     *
     * Unlike [availableChannels], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("availableChannels")
    @ExcludeMissing
    fun _availableChannels(): JsonField<String> = availableChannels

    /**
     * Returns the raw JSON value of [countryCode].
     *
     * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("countryCode") @ExcludeMissing fun _countryCode(): JsonField<String> = countryCode

    /**
     * Returns the raw JSON value of [defaultChannel].
     *
     * Unlike [defaultChannel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("defaultChannel")
    @ExcludeMissing
    fun _defaultChannel(): JsonField<String> = defaultChannel

    /**
     * Returns the raw JSON value of [formatE164].
     *
     * Unlike [formatE164], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("formatE164") @ExcludeMissing fun _formatE164(): JsonField<String> = formatE164

    /**
     * Returns the raw JSON value of [formatInternational].
     *
     * Unlike [formatInternational], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("formatInternational")
    @ExcludeMissing
    fun _formatInternational(): JsonField<String> = formatInternational

    /**
     * Returns the raw JSON value of [formatNational].
     *
     * Unlike [formatNational], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("formatNational")
    @ExcludeMissing
    fun _formatNational(): JsonField<String> = formatNational

    /**
     * Returns the raw JSON value of [formatRfc].
     *
     * Unlike [formatRfc], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("formatRfc") @ExcludeMissing fun _formatRfc(): JsonField<String> = formatRfc

    /**
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phoneNumber") @ExcludeMissing fun _phoneNumber(): JsonField<String> = phoneNumber

    /**
     * Returns the raw JSON value of [regionCode].
     *
     * Unlike [regionCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("regionCode") @ExcludeMissing fun _regionCode(): JsonField<String> = regionCode

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

        /** Returns a mutable builder for constructing an instance of [ContactListItem]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactListItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var availableChannels: JsonField<String> = JsonMissing.of()
        private var countryCode: JsonField<String> = JsonMissing.of()
        private var defaultChannel: JsonField<String> = JsonMissing.of()
        private var formatE164: JsonField<String> = JsonMissing.of()
        private var formatInternational: JsonField<String> = JsonMissing.of()
        private var formatNational: JsonField<String> = JsonMissing.of()
        private var formatRfc: JsonField<String> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var regionCode: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contactListItem: ContactListItem) = apply {
            id = contactListItem.id
            availableChannels = contactListItem.availableChannels
            countryCode = contactListItem.countryCode
            defaultChannel = contactListItem.defaultChannel
            formatE164 = contactListItem.formatE164
            formatInternational = contactListItem.formatInternational
            formatNational = contactListItem.formatNational
            formatRfc = contactListItem.formatRfc
            phoneNumber = contactListItem.phoneNumber
            regionCode = contactListItem.regionCode
            additionalProperties = contactListItem.additionalProperties.toMutableMap()
        }

        /** The unique identifier of the contact */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Comma-separated list of available messaging channels for this contact (e.g.,
         * "sms,whatsapp")
         */
        fun availableChannels(availableChannels: String) =
            availableChannels(JsonField.of(availableChannels))

        /**
         * Sets [Builder.availableChannels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.availableChannels] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun availableChannels(availableChannels: JsonField<String>) = apply {
            this.availableChannels = availableChannels
        }

        /** The country calling code (e.g., 1 for US/Canada) */
        fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

        /**
         * Sets [Builder.countryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryCode(countryCode: JsonField<String>) = apply { this.countryCode = countryCode }

        /** The default messaging channel to use for this contact (e.g., "sms" or "whatsapp") */
        fun defaultChannel(defaultChannel: String) = defaultChannel(JsonField.of(defaultChannel))

        /**
         * Sets [Builder.defaultChannel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.defaultChannel] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun defaultChannel(defaultChannel: JsonField<String>) = apply {
            this.defaultChannel = defaultChannel
        }

        /** The phone number formatted in E.164 standard (e.g., +1234567890) */
        fun formatE164(formatE164: String) = formatE164(JsonField.of(formatE164))

        /**
         * Sets [Builder.formatE164] to an arbitrary JSON value.
         *
         * You should usually call [Builder.formatE164] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun formatE164(formatE164: JsonField<String>) = apply { this.formatE164 = formatE164 }

        /** The phone number formatted for international dialing (e.g., +1 234-567-890) */
        fun formatInternational(formatInternational: String) =
            formatInternational(JsonField.of(formatInternational))

        /**
         * Sets [Builder.formatInternational] to an arbitrary JSON value.
         *
         * You should usually call [Builder.formatInternational] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun formatInternational(formatInternational: JsonField<String>) = apply {
            this.formatInternational = formatInternational
        }

        /** The phone number formatted for national dialing (e.g., (234) 567-890) */
        fun formatNational(formatNational: String) = formatNational(JsonField.of(formatNational))

        /**
         * Sets [Builder.formatNational] to an arbitrary JSON value.
         *
         * You should usually call [Builder.formatNational] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun formatNational(formatNational: JsonField<String>) = apply {
            this.formatNational = formatNational
        }

        /** The phone number formatted according to RFC 3966 (e.g., tel:+1-234-567-890) */
        fun formatRfc(formatRfc: String) = formatRfc(JsonField.of(formatRfc))

        /**
         * Sets [Builder.formatRfc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.formatRfc] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun formatRfc(formatRfc: JsonField<String>) = apply { this.formatRfc = formatRfc }

        /** The phone number in its original format */
        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /** The ISO 3166-1 alpha-2 country code (e.g., US, CA, GB) */
        fun regionCode(regionCode: String) = regionCode(JsonField.of(regionCode))

        /**
         * Sets [Builder.regionCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.regionCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun regionCode(regionCode: JsonField<String>) = apply { this.regionCode = regionCode }

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
         * Returns an immutable instance of [ContactListItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContactListItem =
            ContactListItem(
                id,
                availableChannels,
                countryCode,
                defaultChannel,
                formatE164,
                formatInternational,
                formatNational,
                formatRfc,
                phoneNumber,
                regionCode,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContactListItem = apply {
        if (validated) {
            return@apply
        }

        id()
        availableChannels()
        countryCode()
        defaultChannel()
        formatE164()
        formatInternational()
        formatNational()
        formatRfc()
        phoneNumber()
        regionCode()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: SentDmInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (availableChannels.asKnown().isPresent) 1 else 0) +
            (if (countryCode.asKnown().isPresent) 1 else 0) +
            (if (defaultChannel.asKnown().isPresent) 1 else 0) +
            (if (formatE164.asKnown().isPresent) 1 else 0) +
            (if (formatInternational.asKnown().isPresent) 1 else 0) +
            (if (formatNational.asKnown().isPresent) 1 else 0) +
            (if (formatRfc.asKnown().isPresent) 1 else 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (regionCode.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactListItem &&
            id == other.id &&
            availableChannels == other.availableChannels &&
            countryCode == other.countryCode &&
            defaultChannel == other.defaultChannel &&
            formatE164 == other.formatE164 &&
            formatInternational == other.formatInternational &&
            formatNational == other.formatNational &&
            formatRfc == other.formatRfc &&
            phoneNumber == other.phoneNumber &&
            regionCode == other.regionCode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            availableChannels,
            countryCode,
            defaultChannel,
            formatE164,
            formatInternational,
            formatNational,
            formatRfc,
            phoneNumber,
            regionCode,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContactListItem{id=$id, availableChannels=$availableChannels, countryCode=$countryCode, defaultChannel=$defaultChannel, formatE164=$formatE164, formatInternational=$formatInternational, formatNational=$formatNational, formatRfc=$formatRfc, phoneNumber=$phoneNumber, regionCode=$regionCode, additionalProperties=$additionalProperties}"
}
