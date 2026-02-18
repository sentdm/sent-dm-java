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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Contact response for v3 API Uses snake_case for JSON property names */
class Contact
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val availableChannels: JsonField<String>,
    private val countryCode: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val defaultChannel: JsonField<String>,
    private val formatE164: JsonField<String>,
    private val formatInternational: JsonField<String>,
    private val formatNational: JsonField<String>,
    private val formatRfc: JsonField<String>,
    private val isInherited: JsonField<Boolean>,
    private val optOut: JsonField<Boolean>,
    private val phoneNumber: JsonField<String>,
    private val regionCode: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("available_channels")
        @ExcludeMissing
        availableChannels: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country_code")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("default_channel")
        @ExcludeMissing
        defaultChannel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format_e164")
        @ExcludeMissing
        formatE164: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format_international")
        @ExcludeMissing
        formatInternational: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format_national")
        @ExcludeMissing
        formatNational: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format_rfc") @ExcludeMissing formatRfc: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_inherited")
        @ExcludeMissing
        isInherited: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("opt_out") @ExcludeMissing optOut: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("phone_number")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region_code")
        @ExcludeMissing
        regionCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        availableChannels,
        countryCode,
        createdAt,
        defaultChannel,
        formatE164,
        formatInternational,
        formatNational,
        formatRfc,
        isInherited,
        optOut,
        phoneNumber,
        regionCode,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the contact
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Comma-separated list of available messaging channels (e.g., "sms,whatsapp")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun availableChannels(): Optional<String> = availableChannels.getOptional("available_channels")

    /**
     * Country calling code (e.g., 1 for US/Canada)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

    /**
     * When the contact was created
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Default messaging channel to use (e.g., "sms" or "whatsapp")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun defaultChannel(): Optional<String> = defaultChannel.getOptional("default_channel")

    /**
     * Phone number in E.164 format (e.g., +1234567890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatE164(): Optional<String> = formatE164.getOptional("format_e164")

    /**
     * Phone number in international format (e.g., +1 234-567-890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatInternational(): Optional<String> =
        formatInternational.getOptional("format_international")

    /**
     * Phone number in national format (e.g., (234) 567-890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatNational(): Optional<String> = formatNational.getOptional("format_national")

    /**
     * Phone number in RFC 3966 format (e.g., tel:+1-234-567-890)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun formatRfc(): Optional<String> = formatRfc.getOptional("format_rfc")

    /**
     * Whether this is an inherited contact (read-only)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isInherited(): Optional<Boolean> = isInherited.getOptional("is_inherited")

    /**
     * Whether the contact has opted out of messaging
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optOut(): Optional<Boolean> = optOut.getOptional("opt_out")

    /**
     * Phone number in original format
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

    /**
     * ISO 3166-1 alpha-2 country code (e.g., US, CA, GB)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun regionCode(): Optional<String> = regionCode.getOptional("region_code")

    /**
     * When the contact was last updated
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

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
    @JsonProperty("available_channels")
    @ExcludeMissing
    fun _availableChannels(): JsonField<String> = availableChannels

    /**
     * Returns the raw JSON value of [countryCode].
     *
     * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country_code")
    @ExcludeMissing
    fun _countryCode(): JsonField<String> = countryCode

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [defaultChannel].
     *
     * Unlike [defaultChannel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("default_channel")
    @ExcludeMissing
    fun _defaultChannel(): JsonField<String> = defaultChannel

    /**
     * Returns the raw JSON value of [formatE164].
     *
     * Unlike [formatE164], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format_e164") @ExcludeMissing fun _formatE164(): JsonField<String> = formatE164

    /**
     * Returns the raw JSON value of [formatInternational].
     *
     * Unlike [formatInternational], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("format_international")
    @ExcludeMissing
    fun _formatInternational(): JsonField<String> = formatInternational

    /**
     * Returns the raw JSON value of [formatNational].
     *
     * Unlike [formatNational], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format_national")
    @ExcludeMissing
    fun _formatNational(): JsonField<String> = formatNational

    /**
     * Returns the raw JSON value of [formatRfc].
     *
     * Unlike [formatRfc], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format_rfc") @ExcludeMissing fun _formatRfc(): JsonField<String> = formatRfc

    /**
     * Returns the raw JSON value of [isInherited].
     *
     * Unlike [isInherited], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_inherited")
    @ExcludeMissing
    fun _isInherited(): JsonField<Boolean> = isInherited

    /**
     * Returns the raw JSON value of [optOut].
     *
     * Unlike [optOut], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("opt_out") @ExcludeMissing fun _optOut(): JsonField<Boolean> = optOut

    /**
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone_number")
    @ExcludeMissing
    fun _phoneNumber(): JsonField<String> = phoneNumber

    /**
     * Returns the raw JSON value of [regionCode].
     *
     * Unlike [regionCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("region_code") @ExcludeMissing fun _regionCode(): JsonField<String> = regionCode

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

        /** Returns a mutable builder for constructing an instance of [Contact]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Contact]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var availableChannels: JsonField<String> = JsonMissing.of()
        private var countryCode: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var defaultChannel: JsonField<String> = JsonMissing.of()
        private var formatE164: JsonField<String> = JsonMissing.of()
        private var formatInternational: JsonField<String> = JsonMissing.of()
        private var formatNational: JsonField<String> = JsonMissing.of()
        private var formatRfc: JsonField<String> = JsonMissing.of()
        private var isInherited: JsonField<Boolean> = JsonMissing.of()
        private var optOut: JsonField<Boolean> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var regionCode: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contact: Contact) = apply {
            id = contact.id
            availableChannels = contact.availableChannels
            countryCode = contact.countryCode
            createdAt = contact.createdAt
            defaultChannel = contact.defaultChannel
            formatE164 = contact.formatE164
            formatInternational = contact.formatInternational
            formatNational = contact.formatNational
            formatRfc = contact.formatRfc
            isInherited = contact.isInherited
            optOut = contact.optOut
            phoneNumber = contact.phoneNumber
            regionCode = contact.regionCode
            updatedAt = contact.updatedAt
            additionalProperties = contact.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the contact */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Comma-separated list of available messaging channels (e.g., "sms,whatsapp") */
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

        /** Country calling code (e.g., 1 for US/Canada) */
        fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

        /**
         * Sets [Builder.countryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryCode(countryCode: JsonField<String>) = apply { this.countryCode = countryCode }

        /** When the contact was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Default messaging channel to use (e.g., "sms" or "whatsapp") */
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

        /** Phone number in E.164 format (e.g., +1234567890) */
        fun formatE164(formatE164: String) = formatE164(JsonField.of(formatE164))

        /**
         * Sets [Builder.formatE164] to an arbitrary JSON value.
         *
         * You should usually call [Builder.formatE164] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun formatE164(formatE164: JsonField<String>) = apply { this.formatE164 = formatE164 }

        /** Phone number in international format (e.g., +1 234-567-890) */
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

        /** Phone number in national format (e.g., (234) 567-890) */
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

        /** Phone number in RFC 3966 format (e.g., tel:+1-234-567-890) */
        fun formatRfc(formatRfc: String) = formatRfc(JsonField.of(formatRfc))

        /**
         * Sets [Builder.formatRfc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.formatRfc] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun formatRfc(formatRfc: JsonField<String>) = apply { this.formatRfc = formatRfc }

        /** Whether this is an inherited contact (read-only) */
        fun isInherited(isInherited: Boolean) = isInherited(JsonField.of(isInherited))

        /**
         * Sets [Builder.isInherited] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isInherited] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isInherited(isInherited: JsonField<Boolean>) = apply { this.isInherited = isInherited }

        /** Whether the contact has opted out of messaging */
        fun optOut(optOut: Boolean) = optOut(JsonField.of(optOut))

        /**
         * Sets [Builder.optOut] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optOut] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun optOut(optOut: JsonField<Boolean>) = apply { this.optOut = optOut }

        /** Phone number in original format */
        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /** ISO 3166-1 alpha-2 country code (e.g., US, CA, GB) */
        fun regionCode(regionCode: String) = regionCode(JsonField.of(regionCode))

        /**
         * Sets [Builder.regionCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.regionCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun regionCode(regionCode: JsonField<String>) = apply { this.regionCode = regionCode }

        /** When the contact was last updated */
        fun updatedAt(updatedAt: OffsetDateTime?) = updatedAt(JsonField.ofNullable(updatedAt))

        /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
        fun updatedAt(updatedAt: Optional<OffsetDateTime>) = updatedAt(updatedAt.getOrNull())

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [Contact].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Contact =
            Contact(
                id,
                availableChannels,
                countryCode,
                createdAt,
                defaultChannel,
                formatE164,
                formatInternational,
                formatNational,
                formatRfc,
                isInherited,
                optOut,
                phoneNumber,
                regionCode,
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Contact = apply {
        if (validated) {
            return@apply
        }

        id()
        availableChannels()
        countryCode()
        createdAt()
        defaultChannel()
        formatE164()
        formatInternational()
        formatNational()
        formatRfc()
        isInherited()
        optOut()
        phoneNumber()
        regionCode()
        updatedAt()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (defaultChannel.asKnown().isPresent) 1 else 0) +
            (if (formatE164.asKnown().isPresent) 1 else 0) +
            (if (formatInternational.asKnown().isPresent) 1 else 0) +
            (if (formatNational.asKnown().isPresent) 1 else 0) +
            (if (formatRfc.asKnown().isPresent) 1 else 0) +
            (if (isInherited.asKnown().isPresent) 1 else 0) +
            (if (optOut.asKnown().isPresent) 1 else 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (regionCode.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Contact &&
            id == other.id &&
            availableChannels == other.availableChannels &&
            countryCode == other.countryCode &&
            createdAt == other.createdAt &&
            defaultChannel == other.defaultChannel &&
            formatE164 == other.formatE164 &&
            formatInternational == other.formatInternational &&
            formatNational == other.formatNational &&
            formatRfc == other.formatRfc &&
            isInherited == other.isInherited &&
            optOut == other.optOut &&
            phoneNumber == other.phoneNumber &&
            regionCode == other.regionCode &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            availableChannels,
            countryCode,
            createdAt,
            defaultChannel,
            formatE164,
            formatInternational,
            formatNational,
            formatRfc,
            isInherited,
            optOut,
            phoneNumber,
            regionCode,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Contact{id=$id, availableChannels=$availableChannels, countryCode=$countryCode, createdAt=$createdAt, defaultChannel=$defaultChannel, formatE164=$formatE164, formatInternational=$formatInternational, formatNational=$formatNational, formatRfc=$formatRfc, isInherited=$isInherited, optOut=$optOut, phoneNumber=$phoneNumber, regionCode=$regionCode, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
