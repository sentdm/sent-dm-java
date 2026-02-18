// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.Enum
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Brand and KYC data */
class BrandData
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val brandRelationship: JsonField<TcrBrandRelationship>,
    private val contactName: JsonField<String>,
    private val vertical: JsonField<TcrVertical>,
    private val brandName: JsonField<String>,
    private val businessLegalName: JsonField<String>,
    private val businessName: JsonField<String>,
    private val businessRole: JsonField<String>,
    private val businessUrl: JsonField<String>,
    private val city: JsonField<String>,
    private val contactEmail: JsonField<String>,
    private val contactPhone: JsonField<String>,
    private val contactPhoneCountryCode: JsonField<String>,
    private val country: JsonField<String>,
    private val countryOfRegistration: JsonField<String>,
    private val destinationCountries: JsonField<List<DestinationCountry>>,
    private val entityType: JsonField<EntityType>,
    private val expectedMessagingVolume: JsonField<String>,
    private val isTcrApplication: JsonField<Boolean>,
    private val notes: JsonField<String>,
    private val phoneNumberPrefix: JsonField<String>,
    private val postalCode: JsonField<String>,
    private val primaryUseCase: JsonField<String>,
    private val state: JsonField<String>,
    private val street: JsonField<String>,
    private val taxId: JsonField<String>,
    private val taxIdType: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("brandRelationship")
        @ExcludeMissing
        brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of(),
        @JsonProperty("contactName")
        @ExcludeMissing
        contactName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("vertical")
        @ExcludeMissing
        vertical: JsonField<TcrVertical> = JsonMissing.of(),
        @JsonProperty("brandName") @ExcludeMissing brandName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("businessLegalName")
        @ExcludeMissing
        businessLegalName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("businessName")
        @ExcludeMissing
        businessName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("businessRole")
        @ExcludeMissing
        businessRole: JsonField<String> = JsonMissing.of(),
        @JsonProperty("businessUrl")
        @ExcludeMissing
        businessUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contactEmail")
        @ExcludeMissing
        contactEmail: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contactPhone")
        @ExcludeMissing
        contactPhone: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contactPhoneCountryCode")
        @ExcludeMissing
        contactPhoneCountryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("countryOfRegistration")
        @ExcludeMissing
        countryOfRegistration: JsonField<String> = JsonMissing.of(),
        @JsonProperty("destinationCountries")
        @ExcludeMissing
        destinationCountries: JsonField<List<DestinationCountry>> = JsonMissing.of(),
        @JsonProperty("entityType")
        @ExcludeMissing
        entityType: JsonField<EntityType> = JsonMissing.of(),
        @JsonProperty("expectedMessagingVolume")
        @ExcludeMissing
        expectedMessagingVolume: JsonField<String> = JsonMissing.of(),
        @JsonProperty("isTcrApplication")
        @ExcludeMissing
        isTcrApplication: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phoneNumberPrefix")
        @ExcludeMissing
        phoneNumberPrefix: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postalCode")
        @ExcludeMissing
        postalCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("primaryUseCase")
        @ExcludeMissing
        primaryUseCase: JsonField<String> = JsonMissing.of(),
        @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
        @JsonProperty("street") @ExcludeMissing street: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taxId") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taxIdType") @ExcludeMissing taxIdType: JsonField<String> = JsonMissing.of(),
    ) : this(
        brandRelationship,
        contactName,
        vertical,
        brandName,
        businessLegalName,
        businessName,
        businessRole,
        businessUrl,
        city,
        contactEmail,
        contactPhone,
        contactPhoneCountryCode,
        country,
        countryOfRegistration,
        destinationCountries,
        entityType,
        expectedMessagingVolume,
        isTcrApplication,
        notes,
        phoneNumberPrefix,
        postalCode,
        primaryUseCase,
        state,
        street,
        taxId,
        taxIdType,
        mutableMapOf(),
    )

    /**
     * Brand relationship level with TCR (required for TCR)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun brandRelationship(): TcrBrandRelationship =
        brandRelationship.getRequired("brandRelationship")

    /**
     * Primary contact name (required)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contactName(): String = contactName.getRequired("contactName")

    /**
     * Business vertical/industry category (required for TCR)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vertical(): TcrVertical = vertical.getRequired("vertical")

    /**
     * Brand name for KYC submission
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun brandName(): Optional<String> = brandName.getOptional("brandName")

    /**
     * Legal business name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun businessLegalName(): Optional<String> = businessLegalName.getOptional("businessLegalName")

    /**
     * Business/brand name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun businessName(): Optional<String> = businessName.getOptional("businessName")

    /**
     * Contact's role in the business
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun businessRole(): Optional<String> = businessRole.getOptional("businessRole")

    /**
     * Business website URL
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun businessUrl(): Optional<String> = businessUrl.getOptional("businessUrl")

    /**
     * City
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun city(): Optional<String> = city.getOptional("city")

    /**
     * Contact email address
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactEmail(): Optional<String> = contactEmail.getOptional("contactEmail")

    /**
     * Contact phone number in E.164 format
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactPhone(): Optional<String> = contactPhone.getOptional("contactPhone")

    /**
     * Contact phone country code (e.g., "1" for US)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactPhoneCountryCode(): Optional<String> =
        contactPhoneCountryCode.getOptional("contactPhoneCountryCode")

    /**
     * Country code (e.g., US, CA)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun country(): Optional<String> = country.getOptional("country")

    /**
     * Country where the business is registered
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun countryOfRegistration(): Optional<String> =
        countryOfRegistration.getOptional("countryOfRegistration")

    /**
     * List of destination countries for messaging
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun destinationCountries(): Optional<List<DestinationCountry>> =
        destinationCountries.getOptional("destinationCountries")

    /**
     * Business entity type
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun entityType(): Optional<EntityType> = entityType.getOptional("entityType")

    /**
     * Expected daily messaging volume
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expectedMessagingVolume(): Optional<String> =
        expectedMessagingVolume.getOptional("expectedMessagingVolume")

    /**
     * Whether this is a TCR (Campaign Registry) application
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isTcrApplication(): Optional<Boolean> = isTcrApplication.getOptional("isTcrApplication")

    /**
     * Additional notes about the business or use case
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notes(): Optional<String> = notes.getOptional("notes")

    /**
     * Phone number prefix for messaging (e.g., "+1")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phoneNumberPrefix(): Optional<String> = phoneNumberPrefix.getOptional("phoneNumberPrefix")

    /**
     * Postal/ZIP code
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun postalCode(): Optional<String> = postalCode.getOptional("postalCode")

    /**
     * Primary messaging use case description
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun primaryUseCase(): Optional<String> = primaryUseCase.getOptional("primaryUseCase")

    /**
     * State/province code
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun state(): Optional<String> = state.getOptional("state")

    /**
     * Street address
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun street(): Optional<String> = street.getOptional("street")

    /**
     * Tax ID/EIN number
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxId(): Optional<String> = taxId.getOptional("taxId")

    /**
     * Type of tax ID (e.g., us_ein, ca_bn)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxIdType(): Optional<String> = taxIdType.getOptional("taxIdType")

    /**
     * Returns the raw JSON value of [brandRelationship].
     *
     * Unlike [brandRelationship], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("brandRelationship")
    @ExcludeMissing
    fun _brandRelationship(): JsonField<TcrBrandRelationship> = brandRelationship

    /**
     * Returns the raw JSON value of [contactName].
     *
     * Unlike [contactName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contactName") @ExcludeMissing fun _contactName(): JsonField<String> = contactName

    /**
     * Returns the raw JSON value of [vertical].
     *
     * Unlike [vertical], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vertical") @ExcludeMissing fun _vertical(): JsonField<TcrVertical> = vertical

    /**
     * Returns the raw JSON value of [brandName].
     *
     * Unlike [brandName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brandName") @ExcludeMissing fun _brandName(): JsonField<String> = brandName

    /**
     * Returns the raw JSON value of [businessLegalName].
     *
     * Unlike [businessLegalName], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("businessLegalName")
    @ExcludeMissing
    fun _businessLegalName(): JsonField<String> = businessLegalName

    /**
     * Returns the raw JSON value of [businessName].
     *
     * Unlike [businessName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("businessName")
    @ExcludeMissing
    fun _businessName(): JsonField<String> = businessName

    /**
     * Returns the raw JSON value of [businessRole].
     *
     * Unlike [businessRole], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("businessRole")
    @ExcludeMissing
    fun _businessRole(): JsonField<String> = businessRole

    /**
     * Returns the raw JSON value of [businessUrl].
     *
     * Unlike [businessUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("businessUrl") @ExcludeMissing fun _businessUrl(): JsonField<String> = businessUrl

    /**
     * Returns the raw JSON value of [city].
     *
     * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

    /**
     * Returns the raw JSON value of [contactEmail].
     *
     * Unlike [contactEmail], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contactEmail")
    @ExcludeMissing
    fun _contactEmail(): JsonField<String> = contactEmail

    /**
     * Returns the raw JSON value of [contactPhone].
     *
     * Unlike [contactPhone], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contactPhone")
    @ExcludeMissing
    fun _contactPhone(): JsonField<String> = contactPhone

    /**
     * Returns the raw JSON value of [contactPhoneCountryCode].
     *
     * Unlike [contactPhoneCountryCode], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("contactPhoneCountryCode")
    @ExcludeMissing
    fun _contactPhoneCountryCode(): JsonField<String> = contactPhoneCountryCode

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

    /**
     * Returns the raw JSON value of [countryOfRegistration].
     *
     * Unlike [countryOfRegistration], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("countryOfRegistration")
    @ExcludeMissing
    fun _countryOfRegistration(): JsonField<String> = countryOfRegistration

    /**
     * Returns the raw JSON value of [destinationCountries].
     *
     * Unlike [destinationCountries], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("destinationCountries")
    @ExcludeMissing
    fun _destinationCountries(): JsonField<List<DestinationCountry>> = destinationCountries

    /**
     * Returns the raw JSON value of [entityType].
     *
     * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entityType")
    @ExcludeMissing
    fun _entityType(): JsonField<EntityType> = entityType

    /**
     * Returns the raw JSON value of [expectedMessagingVolume].
     *
     * Unlike [expectedMessagingVolume], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("expectedMessagingVolume")
    @ExcludeMissing
    fun _expectedMessagingVolume(): JsonField<String> = expectedMessagingVolume

    /**
     * Returns the raw JSON value of [isTcrApplication].
     *
     * Unlike [isTcrApplication], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("isTcrApplication")
    @ExcludeMissing
    fun _isTcrApplication(): JsonField<Boolean> = isTcrApplication

    /**
     * Returns the raw JSON value of [notes].
     *
     * Unlike [notes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("notes") @ExcludeMissing fun _notes(): JsonField<String> = notes

    /**
     * Returns the raw JSON value of [phoneNumberPrefix].
     *
     * Unlike [phoneNumberPrefix], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("phoneNumberPrefix")
    @ExcludeMissing
    fun _phoneNumberPrefix(): JsonField<String> = phoneNumberPrefix

    /**
     * Returns the raw JSON value of [postalCode].
     *
     * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("postalCode") @ExcludeMissing fun _postalCode(): JsonField<String> = postalCode

    /**
     * Returns the raw JSON value of [primaryUseCase].
     *
     * Unlike [primaryUseCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("primaryUseCase")
    @ExcludeMissing
    fun _primaryUseCase(): JsonField<String> = primaryUseCase

    /**
     * Returns the raw JSON value of [state].
     *
     * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

    /**
     * Returns the raw JSON value of [street].
     *
     * Unlike [street], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("street") @ExcludeMissing fun _street(): JsonField<String> = street

    /**
     * Returns the raw JSON value of [taxId].
     *
     * Unlike [taxId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("taxId") @ExcludeMissing fun _taxId(): JsonField<String> = taxId

    /**
     * Returns the raw JSON value of [taxIdType].
     *
     * Unlike [taxIdType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("taxIdType") @ExcludeMissing fun _taxIdType(): JsonField<String> = taxIdType

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
         * Returns a mutable builder for constructing an instance of [BrandData].
         *
         * The following fields are required:
         * ```java
         * .brandRelationship()
         * .contactName()
         * .vertical()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandData]. */
    class Builder internal constructor() {

        private var brandRelationship: JsonField<TcrBrandRelationship>? = null
        private var contactName: JsonField<String>? = null
        private var vertical: JsonField<TcrVertical>? = null
        private var brandName: JsonField<String> = JsonMissing.of()
        private var businessLegalName: JsonField<String> = JsonMissing.of()
        private var businessName: JsonField<String> = JsonMissing.of()
        private var businessRole: JsonField<String> = JsonMissing.of()
        private var businessUrl: JsonField<String> = JsonMissing.of()
        private var city: JsonField<String> = JsonMissing.of()
        private var contactEmail: JsonField<String> = JsonMissing.of()
        private var contactPhone: JsonField<String> = JsonMissing.of()
        private var contactPhoneCountryCode: JsonField<String> = JsonMissing.of()
        private var country: JsonField<String> = JsonMissing.of()
        private var countryOfRegistration: JsonField<String> = JsonMissing.of()
        private var destinationCountries: JsonField<MutableList<DestinationCountry>>? = null
        private var entityType: JsonField<EntityType> = JsonMissing.of()
        private var expectedMessagingVolume: JsonField<String> = JsonMissing.of()
        private var isTcrApplication: JsonField<Boolean> = JsonMissing.of()
        private var notes: JsonField<String> = JsonMissing.of()
        private var phoneNumberPrefix: JsonField<String> = JsonMissing.of()
        private var postalCode: JsonField<String> = JsonMissing.of()
        private var primaryUseCase: JsonField<String> = JsonMissing.of()
        private var state: JsonField<String> = JsonMissing.of()
        private var street: JsonField<String> = JsonMissing.of()
        private var taxId: JsonField<String> = JsonMissing.of()
        private var taxIdType: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandData: BrandData) = apply {
            brandRelationship = brandData.brandRelationship
            contactName = brandData.contactName
            vertical = brandData.vertical
            brandName = brandData.brandName
            businessLegalName = brandData.businessLegalName
            businessName = brandData.businessName
            businessRole = brandData.businessRole
            businessUrl = brandData.businessUrl
            city = brandData.city
            contactEmail = brandData.contactEmail
            contactPhone = brandData.contactPhone
            contactPhoneCountryCode = brandData.contactPhoneCountryCode
            country = brandData.country
            countryOfRegistration = brandData.countryOfRegistration
            destinationCountries = brandData.destinationCountries.map { it.toMutableList() }
            entityType = brandData.entityType
            expectedMessagingVolume = brandData.expectedMessagingVolume
            isTcrApplication = brandData.isTcrApplication
            notes = brandData.notes
            phoneNumberPrefix = brandData.phoneNumberPrefix
            postalCode = brandData.postalCode
            primaryUseCase = brandData.primaryUseCase
            state = brandData.state
            street = brandData.street
            taxId = brandData.taxId
            taxIdType = brandData.taxIdType
            additionalProperties = brandData.additionalProperties.toMutableMap()
        }

        /** Brand relationship level with TCR (required for TCR) */
        fun brandRelationship(brandRelationship: TcrBrandRelationship) =
            brandRelationship(JsonField.of(brandRelationship))

        /**
         * Sets [Builder.brandRelationship] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandRelationship] with a well-typed
         * [TcrBrandRelationship] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun brandRelationship(brandRelationship: JsonField<TcrBrandRelationship>) = apply {
            this.brandRelationship = brandRelationship
        }

        /** Primary contact name (required) */
        fun contactName(contactName: String) = contactName(JsonField.of(contactName))

        /**
         * Sets [Builder.contactName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactName(contactName: JsonField<String>) = apply { this.contactName = contactName }

        /** Business vertical/industry category (required for TCR) */
        fun vertical(vertical: TcrVertical) = vertical(JsonField.of(vertical))

        /**
         * Sets [Builder.vertical] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vertical] with a well-typed [TcrVertical] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun vertical(vertical: JsonField<TcrVertical>) = apply { this.vertical = vertical }

        /** Brand name for KYC submission */
        fun brandName(brandName: String?) = brandName(JsonField.ofNullable(brandName))

        /** Alias for calling [Builder.brandName] with `brandName.orElse(null)`. */
        fun brandName(brandName: Optional<String>) = brandName(brandName.getOrNull())

        /**
         * Sets [Builder.brandName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandName(brandName: JsonField<String>) = apply { this.brandName = brandName }

        /** Legal business name */
        fun businessLegalName(businessLegalName: String?) =
            businessLegalName(JsonField.ofNullable(businessLegalName))

        /** Alias for calling [Builder.businessLegalName] with `businessLegalName.orElse(null)`. */
        fun businessLegalName(businessLegalName: Optional<String>) =
            businessLegalName(businessLegalName.getOrNull())

        /**
         * Sets [Builder.businessLegalName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.businessLegalName] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun businessLegalName(businessLegalName: JsonField<String>) = apply {
            this.businessLegalName = businessLegalName
        }

        /** Business/brand name */
        fun businessName(businessName: String?) = businessName(JsonField.ofNullable(businessName))

        /** Alias for calling [Builder.businessName] with `businessName.orElse(null)`. */
        fun businessName(businessName: Optional<String>) = businessName(businessName.getOrNull())

        /**
         * Sets [Builder.businessName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.businessName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun businessName(businessName: JsonField<String>) = apply {
            this.businessName = businessName
        }

        /** Contact's role in the business */
        fun businessRole(businessRole: String?) = businessRole(JsonField.ofNullable(businessRole))

        /** Alias for calling [Builder.businessRole] with `businessRole.orElse(null)`. */
        fun businessRole(businessRole: Optional<String>) = businessRole(businessRole.getOrNull())

        /**
         * Sets [Builder.businessRole] to an arbitrary JSON value.
         *
         * You should usually call [Builder.businessRole] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun businessRole(businessRole: JsonField<String>) = apply {
            this.businessRole = businessRole
        }

        /** Business website URL */
        fun businessUrl(businessUrl: String?) = businessUrl(JsonField.ofNullable(businessUrl))

        /** Alias for calling [Builder.businessUrl] with `businessUrl.orElse(null)`. */
        fun businessUrl(businessUrl: Optional<String>) = businessUrl(businessUrl.getOrNull())

        /**
         * Sets [Builder.businessUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.businessUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun businessUrl(businessUrl: JsonField<String>) = apply { this.businessUrl = businessUrl }

        /** City */
        fun city(city: String?) = city(JsonField.ofNullable(city))

        /** Alias for calling [Builder.city] with `city.orElse(null)`. */
        fun city(city: Optional<String>) = city(city.getOrNull())

        /**
         * Sets [Builder.city] to an arbitrary JSON value.
         *
         * You should usually call [Builder.city] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun city(city: JsonField<String>) = apply { this.city = city }

        /** Contact email address */
        fun contactEmail(contactEmail: String?) = contactEmail(JsonField.ofNullable(contactEmail))

        /** Alias for calling [Builder.contactEmail] with `contactEmail.orElse(null)`. */
        fun contactEmail(contactEmail: Optional<String>) = contactEmail(contactEmail.getOrNull())

        /**
         * Sets [Builder.contactEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactEmail] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactEmail(contactEmail: JsonField<String>) = apply {
            this.contactEmail = contactEmail
        }

        /** Contact phone number in E.164 format */
        fun contactPhone(contactPhone: String?) = contactPhone(JsonField.ofNullable(contactPhone))

        /** Alias for calling [Builder.contactPhone] with `contactPhone.orElse(null)`. */
        fun contactPhone(contactPhone: Optional<String>) = contactPhone(contactPhone.getOrNull())

        /**
         * Sets [Builder.contactPhone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactPhone] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactPhone(contactPhone: JsonField<String>) = apply {
            this.contactPhone = contactPhone
        }

        /** Contact phone country code (e.g., "1" for US) */
        fun contactPhoneCountryCode(contactPhoneCountryCode: String?) =
            contactPhoneCountryCode(JsonField.ofNullable(contactPhoneCountryCode))

        /**
         * Alias for calling [Builder.contactPhoneCountryCode] with
         * `contactPhoneCountryCode.orElse(null)`.
         */
        fun contactPhoneCountryCode(contactPhoneCountryCode: Optional<String>) =
            contactPhoneCountryCode(contactPhoneCountryCode.getOrNull())

        /**
         * Sets [Builder.contactPhoneCountryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactPhoneCountryCode] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun contactPhoneCountryCode(contactPhoneCountryCode: JsonField<String>) = apply {
            this.contactPhoneCountryCode = contactPhoneCountryCode
        }

        /** Country code (e.g., US, CA) */
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

        /** Country where the business is registered */
        fun countryOfRegistration(countryOfRegistration: String?) =
            countryOfRegistration(JsonField.ofNullable(countryOfRegistration))

        /**
         * Alias for calling [Builder.countryOfRegistration] with
         * `countryOfRegistration.orElse(null)`.
         */
        fun countryOfRegistration(countryOfRegistration: Optional<String>) =
            countryOfRegistration(countryOfRegistration.getOrNull())

        /**
         * Sets [Builder.countryOfRegistration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryOfRegistration] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun countryOfRegistration(countryOfRegistration: JsonField<String>) = apply {
            this.countryOfRegistration = countryOfRegistration
        }

        /** List of destination countries for messaging */
        fun destinationCountries(destinationCountries: List<DestinationCountry>?) =
            destinationCountries(JsonField.ofNullable(destinationCountries))

        /**
         * Alias for calling [Builder.destinationCountries] with
         * `destinationCountries.orElse(null)`.
         */
        fun destinationCountries(destinationCountries: Optional<List<DestinationCountry>>) =
            destinationCountries(destinationCountries.getOrNull())

        /**
         * Sets [Builder.destinationCountries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.destinationCountries] with a well-typed
         * `List<DestinationCountry>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun destinationCountries(destinationCountries: JsonField<List<DestinationCountry>>) =
            apply {
                this.destinationCountries = destinationCountries.map { it.toMutableList() }
            }

        /**
         * Adds a single [DestinationCountry] to [destinationCountries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDestinationCountry(destinationCountry: DestinationCountry) = apply {
            destinationCountries =
                (destinationCountries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("destinationCountries", it).add(destinationCountry)
                }
        }

        /** Business entity type */
        fun entityType(entityType: EntityType?) = entityType(JsonField.ofNullable(entityType))

        /** Alias for calling [Builder.entityType] with `entityType.orElse(null)`. */
        fun entityType(entityType: Optional<EntityType>) = entityType(entityType.getOrNull())

        /**
         * Sets [Builder.entityType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entityType] with a well-typed [EntityType] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun entityType(entityType: JsonField<EntityType>) = apply { this.entityType = entityType }

        /** Expected daily messaging volume */
        fun expectedMessagingVolume(expectedMessagingVolume: String?) =
            expectedMessagingVolume(JsonField.ofNullable(expectedMessagingVolume))

        /**
         * Alias for calling [Builder.expectedMessagingVolume] with
         * `expectedMessagingVolume.orElse(null)`.
         */
        fun expectedMessagingVolume(expectedMessagingVolume: Optional<String>) =
            expectedMessagingVolume(expectedMessagingVolume.getOrNull())

        /**
         * Sets [Builder.expectedMessagingVolume] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expectedMessagingVolume] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun expectedMessagingVolume(expectedMessagingVolume: JsonField<String>) = apply {
            this.expectedMessagingVolume = expectedMessagingVolume
        }

        /** Whether this is a TCR (Campaign Registry) application */
        fun isTcrApplication(isTcrApplication: Boolean?) =
            isTcrApplication(JsonField.ofNullable(isTcrApplication))

        /**
         * Alias for [Builder.isTcrApplication].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun isTcrApplication(isTcrApplication: Boolean) =
            isTcrApplication(isTcrApplication as Boolean?)

        /** Alias for calling [Builder.isTcrApplication] with `isTcrApplication.orElse(null)`. */
        fun isTcrApplication(isTcrApplication: Optional<Boolean>) =
            isTcrApplication(isTcrApplication.getOrNull())

        /**
         * Sets [Builder.isTcrApplication] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isTcrApplication] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isTcrApplication(isTcrApplication: JsonField<Boolean>) = apply {
            this.isTcrApplication = isTcrApplication
        }

        /** Additional notes about the business or use case */
        fun notes(notes: String?) = notes(JsonField.ofNullable(notes))

        /** Alias for calling [Builder.notes] with `notes.orElse(null)`. */
        fun notes(notes: Optional<String>) = notes(notes.getOrNull())

        /**
         * Sets [Builder.notes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notes] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun notes(notes: JsonField<String>) = apply { this.notes = notes }

        /** Phone number prefix for messaging (e.g., "+1") */
        fun phoneNumberPrefix(phoneNumberPrefix: String?) =
            phoneNumberPrefix(JsonField.ofNullable(phoneNumberPrefix))

        /** Alias for calling [Builder.phoneNumberPrefix] with `phoneNumberPrefix.orElse(null)`. */
        fun phoneNumberPrefix(phoneNumberPrefix: Optional<String>) =
            phoneNumberPrefix(phoneNumberPrefix.getOrNull())

        /**
         * Sets [Builder.phoneNumberPrefix] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumberPrefix] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun phoneNumberPrefix(phoneNumberPrefix: JsonField<String>) = apply {
            this.phoneNumberPrefix = phoneNumberPrefix
        }

        /** Postal/ZIP code */
        fun postalCode(postalCode: String?) = postalCode(JsonField.ofNullable(postalCode))

        /** Alias for calling [Builder.postalCode] with `postalCode.orElse(null)`. */
        fun postalCode(postalCode: Optional<String>) = postalCode(postalCode.getOrNull())

        /**
         * Sets [Builder.postalCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.postalCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

        /** Primary messaging use case description */
        fun primaryUseCase(primaryUseCase: String?) =
            primaryUseCase(JsonField.ofNullable(primaryUseCase))

        /** Alias for calling [Builder.primaryUseCase] with `primaryUseCase.orElse(null)`. */
        fun primaryUseCase(primaryUseCase: Optional<String>) =
            primaryUseCase(primaryUseCase.getOrNull())

        /**
         * Sets [Builder.primaryUseCase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.primaryUseCase] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun primaryUseCase(primaryUseCase: JsonField<String>) = apply {
            this.primaryUseCase = primaryUseCase
        }

        /** State/province code */
        fun state(state: String?) = state(JsonField.ofNullable(state))

        /** Alias for calling [Builder.state] with `state.orElse(null)`. */
        fun state(state: Optional<String>) = state(state.getOrNull())

        /**
         * Sets [Builder.state] to an arbitrary JSON value.
         *
         * You should usually call [Builder.state] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun state(state: JsonField<String>) = apply { this.state = state }

        /** Street address */
        fun street(street: String?) = street(JsonField.ofNullable(street))

        /** Alias for calling [Builder.street] with `street.orElse(null)`. */
        fun street(street: Optional<String>) = street(street.getOrNull())

        /**
         * Sets [Builder.street] to an arbitrary JSON value.
         *
         * You should usually call [Builder.street] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun street(street: JsonField<String>) = apply { this.street = street }

        /** Tax ID/EIN number */
        fun taxId(taxId: String?) = taxId(JsonField.ofNullable(taxId))

        /** Alias for calling [Builder.taxId] with `taxId.orElse(null)`. */
        fun taxId(taxId: Optional<String>) = taxId(taxId.getOrNull())

        /**
         * Sets [Builder.taxId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxId(taxId: JsonField<String>) = apply { this.taxId = taxId }

        /** Type of tax ID (e.g., us_ein, ca_bn) */
        fun taxIdType(taxIdType: String?) = taxIdType(JsonField.ofNullable(taxIdType))

        /** Alias for calling [Builder.taxIdType] with `taxIdType.orElse(null)`. */
        fun taxIdType(taxIdType: Optional<String>) = taxIdType(taxIdType.getOrNull())

        /**
         * Sets [Builder.taxIdType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxIdType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun taxIdType(taxIdType: JsonField<String>) = apply { this.taxIdType = taxIdType }

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
         * Returns an immutable instance of [BrandData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .brandRelationship()
         * .contactName()
         * .vertical()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BrandData =
            BrandData(
                checkRequired("brandRelationship", brandRelationship),
                checkRequired("contactName", contactName),
                checkRequired("vertical", vertical),
                brandName,
                businessLegalName,
                businessName,
                businessRole,
                businessUrl,
                city,
                contactEmail,
                contactPhone,
                contactPhoneCountryCode,
                country,
                countryOfRegistration,
                (destinationCountries ?: JsonMissing.of()).map { it.toImmutable() },
                entityType,
                expectedMessagingVolume,
                isTcrApplication,
                notes,
                phoneNumberPrefix,
                postalCode,
                primaryUseCase,
                state,
                street,
                taxId,
                taxIdType,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BrandData = apply {
        if (validated) {
            return@apply
        }

        brandRelationship().validate()
        contactName()
        vertical().validate()
        brandName()
        businessLegalName()
        businessName()
        businessRole()
        businessUrl()
        city()
        contactEmail()
        contactPhone()
        contactPhoneCountryCode()
        country()
        countryOfRegistration()
        destinationCountries().ifPresent { it.forEach { it.validate() } }
        entityType().ifPresent { it.validate() }
        expectedMessagingVolume()
        isTcrApplication()
        notes()
        phoneNumberPrefix()
        postalCode()
        primaryUseCase()
        state()
        street()
        taxId()
        taxIdType()
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
        (brandRelationship.asKnown().getOrNull()?.validity() ?: 0) +
            (if (contactName.asKnown().isPresent) 1 else 0) +
            (vertical.asKnown().getOrNull()?.validity() ?: 0) +
            (if (brandName.asKnown().isPresent) 1 else 0) +
            (if (businessLegalName.asKnown().isPresent) 1 else 0) +
            (if (businessName.asKnown().isPresent) 1 else 0) +
            (if (businessRole.asKnown().isPresent) 1 else 0) +
            (if (businessUrl.asKnown().isPresent) 1 else 0) +
            (if (city.asKnown().isPresent) 1 else 0) +
            (if (contactEmail.asKnown().isPresent) 1 else 0) +
            (if (contactPhone.asKnown().isPresent) 1 else 0) +
            (if (contactPhoneCountryCode.asKnown().isPresent) 1 else 0) +
            (if (country.asKnown().isPresent) 1 else 0) +
            (if (countryOfRegistration.asKnown().isPresent) 1 else 0) +
            (destinationCountries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (entityType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (expectedMessagingVolume.asKnown().isPresent) 1 else 0) +
            (if (isTcrApplication.asKnown().isPresent) 1 else 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (if (phoneNumberPrefix.asKnown().isPresent) 1 else 0) +
            (if (postalCode.asKnown().isPresent) 1 else 0) +
            (if (primaryUseCase.asKnown().isPresent) 1 else 0) +
            (if (state.asKnown().isPresent) 1 else 0) +
            (if (street.asKnown().isPresent) 1 else 0) +
            (if (taxId.asKnown().isPresent) 1 else 0) +
            (if (taxIdType.asKnown().isPresent) 1 else 0)

    /** Business entity type */
    class EntityType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PRIVATE_PROFIT = of("PRIVATE_PROFIT")

            @JvmField val PUBLIC_PROFIT = of("PUBLIC_PROFIT")

            @JvmField val NON_PROFIT = of("NON_PROFIT")

            @JvmField val SOLE_PROPRIETOR = of("SOLE_PROPRIETOR")

            @JvmField val GOVERNMENT = of("GOVERNMENT")

            @JvmStatic fun of(value: String) = EntityType(JsonField.of(value))
        }

        /** An enum containing [EntityType]'s known values. */
        enum class Known {
            PRIVATE_PROFIT,
            PUBLIC_PROFIT,
            NON_PROFIT,
            SOLE_PROPRIETOR,
            GOVERNMENT,
        }

        /**
         * An enum containing [EntityType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EntityType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PRIVATE_PROFIT,
            PUBLIC_PROFIT,
            NON_PROFIT,
            SOLE_PROPRIETOR,
            GOVERNMENT,
            /**
             * An enum member indicating that [EntityType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PRIVATE_PROFIT -> Value.PRIVATE_PROFIT
                PUBLIC_PROFIT -> Value.PUBLIC_PROFIT
                NON_PROFIT -> Value.NON_PROFIT
                SOLE_PROPRIETOR -> Value.SOLE_PROPRIETOR
                GOVERNMENT -> Value.GOVERNMENT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentDmInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PRIVATE_PROFIT -> Known.PRIVATE_PROFIT
                PUBLIC_PROFIT -> Known.PUBLIC_PROFIT
                NON_PROFIT -> Known.NON_PROFIT
                SOLE_PROPRIETOR -> Known.SOLE_PROPRIETOR
                GOVERNMENT -> Known.GOVERNMENT
                else -> throw SentDmInvalidDataException("Unknown EntityType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentDmInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentDmInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): EntityType = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EntityType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandData &&
            brandRelationship == other.brandRelationship &&
            contactName == other.contactName &&
            vertical == other.vertical &&
            brandName == other.brandName &&
            businessLegalName == other.businessLegalName &&
            businessName == other.businessName &&
            businessRole == other.businessRole &&
            businessUrl == other.businessUrl &&
            city == other.city &&
            contactEmail == other.contactEmail &&
            contactPhone == other.contactPhone &&
            contactPhoneCountryCode == other.contactPhoneCountryCode &&
            country == other.country &&
            countryOfRegistration == other.countryOfRegistration &&
            destinationCountries == other.destinationCountries &&
            entityType == other.entityType &&
            expectedMessagingVolume == other.expectedMessagingVolume &&
            isTcrApplication == other.isTcrApplication &&
            notes == other.notes &&
            phoneNumberPrefix == other.phoneNumberPrefix &&
            postalCode == other.postalCode &&
            primaryUseCase == other.primaryUseCase &&
            state == other.state &&
            street == other.street &&
            taxId == other.taxId &&
            taxIdType == other.taxIdType &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            brandRelationship,
            contactName,
            vertical,
            brandName,
            businessLegalName,
            businessName,
            businessRole,
            businessUrl,
            city,
            contactEmail,
            contactPhone,
            contactPhoneCountryCode,
            country,
            countryOfRegistration,
            destinationCountries,
            entityType,
            expectedMessagingVolume,
            isTcrApplication,
            notes,
            phoneNumberPrefix,
            postalCode,
            primaryUseCase,
            state,
            street,
            taxId,
            taxIdType,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandData{brandRelationship=$brandRelationship, contactName=$contactName, vertical=$vertical, brandName=$brandName, businessLegalName=$businessLegalName, businessName=$businessName, businessRole=$businessRole, businessUrl=$businessUrl, city=$city, contactEmail=$contactEmail, contactPhone=$contactPhone, contactPhoneCountryCode=$contactPhoneCountryCode, country=$country, countryOfRegistration=$countryOfRegistration, destinationCountries=$destinationCountries, entityType=$entityType, expectedMessagingVolume=$expectedMessagingVolume, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, postalCode=$postalCode, primaryUseCase=$primaryUseCase, state=$state, street=$street, taxId=$taxId, taxIdType=$taxIdType, additionalProperties=$additionalProperties}"
}
