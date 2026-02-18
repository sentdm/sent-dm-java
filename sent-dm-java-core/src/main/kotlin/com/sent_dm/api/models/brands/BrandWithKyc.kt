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
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Flattened brand response with embedded KYC information */
class BrandWithKyc
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val brandRelationship: JsonField<TcrBrandRelationship>,
    private val businessLegalName: JsonField<String>,
    private val businessName: JsonField<String>,
    private val businessRole: JsonField<String>,
    private val businessUrl: JsonField<String>,
    private val city: JsonField<String>,
    private val contactEmail: JsonField<String>,
    private val contactName: JsonField<String>,
    private val contactPhone: JsonField<String>,
    private val contactPhoneCountryCode: JsonField<String>,
    private val country: JsonField<String>,
    private val countryOfRegistration: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val cspId: JsonField<String>,
    private val destinationCountries: JsonField<List<DestinationCountry>>,
    private val entityType: JsonField<String>,
    private val expectedMessagingVolume: JsonField<String>,
    private val identityStatus: JsonField<IdentityStatus>,
    private val isInherited: JsonField<Boolean>,
    private val isTcrApplication: JsonField<Boolean>,
    private val notes: JsonField<String>,
    private val phoneNumberPrefix: JsonField<String>,
    private val postalCode: JsonField<String>,
    private val primaryUseCase: JsonField<String>,
    private val state: JsonField<String>,
    private val status: JsonField<Status>,
    private val street: JsonField<String>,
    private val submittedAt: JsonField<OffsetDateTime>,
    private val submittedToTcr: JsonField<Boolean>,
    private val taxId: JsonField<String>,
    private val taxIdType: JsonField<String>,
    private val tcrBrandId: JsonField<String>,
    private val universalEin: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val vertical: JsonField<TcrVertical>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("brandRelationship")
        @ExcludeMissing
        brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of(),
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
        @JsonProperty("contactName")
        @ExcludeMissing
        contactName: JsonField<String> = JsonMissing.of(),
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
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("cspId") @ExcludeMissing cspId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("destinationCountries")
        @ExcludeMissing
        destinationCountries: JsonField<List<DestinationCountry>> = JsonMissing.of(),
        @JsonProperty("entityType")
        @ExcludeMissing
        entityType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expectedMessagingVolume")
        @ExcludeMissing
        expectedMessagingVolume: JsonField<String> = JsonMissing.of(),
        @JsonProperty("identityStatus")
        @ExcludeMissing
        identityStatus: JsonField<IdentityStatus> = JsonMissing.of(),
        @JsonProperty("isInherited")
        @ExcludeMissing
        isInherited: JsonField<Boolean> = JsonMissing.of(),
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
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("street") @ExcludeMissing street: JsonField<String> = JsonMissing.of(),
        @JsonProperty("submittedAt")
        @ExcludeMissing
        submittedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("submittedToTCR")
        @ExcludeMissing
        submittedToTcr: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("taxId") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taxIdType") @ExcludeMissing taxIdType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tcrBrandId")
        @ExcludeMissing
        tcrBrandId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("universalEin")
        @ExcludeMissing
        universalEin: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("vertical")
        @ExcludeMissing
        vertical: JsonField<TcrVertical> = JsonMissing.of(),
    ) : this(
        id,
        brandRelationship,
        businessLegalName,
        businessName,
        businessRole,
        businessUrl,
        city,
        contactEmail,
        contactName,
        contactPhone,
        contactPhoneCountryCode,
        country,
        countryOfRegistration,
        createdAt,
        cspId,
        destinationCountries,
        entityType,
        expectedMessagingVolume,
        identityStatus,
        isInherited,
        isTcrApplication,
        notes,
        phoneNumberPrefix,
        postalCode,
        primaryUseCase,
        state,
        status,
        street,
        submittedAt,
        submittedToTcr,
        taxId,
        taxIdType,
        tcrBrandId,
        universalEin,
        updatedAt,
        vertical,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the brand
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Brand relationship level with TCR
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun brandRelationship(): Optional<TcrBrandRelationship> =
        brandRelationship.getOptional("brandRelationship")

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
     * Primary contact name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactName(): Optional<String> = contactName.getOptional("contactName")

    /**
     * Contact phone number
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactPhone(): Optional<String> = contactPhone.getOptional("contactPhone")

    /**
     * Contact phone country code
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactPhoneCountryCode(): Optional<String> =
        contactPhoneCountryCode.getOptional("contactPhoneCountryCode")

    /**
     * Country code
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
     * When the brand was created
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * CSP (Campaign Service Provider) ID
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cspId(): Optional<String> = cspId.getOptional("cspId")

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
    fun entityType(): Optional<String> = entityType.getOptional("entityType")

    /**
     * Expected daily messaging volume
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expectedMessagingVolume(): Optional<String> =
        expectedMessagingVolume.getOptional("expectedMessagingVolume")

    /**
     * TCR brand identity verification status
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun identityStatus(): Optional<IdentityStatus> = identityStatus.getOptional("identityStatus")

    /**
     * Whether this brand is inherited from parent organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isInherited(): Optional<Boolean> = isInherited.getOptional("isInherited")

    /**
     * Whether this is a TCR application
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isTcrApplication(): Optional<Boolean> = isTcrApplication.getOptional("isTcrApplication")

    /**
     * Additional notes
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notes(): Optional<String> = notes.getOptional("notes")

    /**
     * Phone number prefix for messaging
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
     * TCR brand status
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * Street address
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun street(): Optional<String> = street.getOptional("street")

    /**
     * When the brand was submitted to TCR
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun submittedAt(): Optional<OffsetDateTime> = submittedAt.getOptional("submittedAt")

    /**
     * Whether this brand was submitted to TCR
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun submittedToTcr(): Optional<Boolean> = submittedToTcr.getOptional("submittedToTCR")

    /**
     * Tax ID/EIN number
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxId(): Optional<String> = taxId.getOptional("taxId")

    /**
     * Type of tax ID
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxIdType(): Optional<String> = taxIdType.getOptional("taxIdType")

    /**
     * TCR brand ID (populated after TCR submission)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tcrBrandId(): Optional<String> = tcrBrandId.getOptional("tcrBrandId")

    /**
     * Universal EIN from TCR
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun universalEin(): Optional<String> = universalEin.getOptional("universalEin")

    /**
     * When the brand was last updated
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * Business vertical/industry category
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vertical(): Optional<TcrVertical> = vertical.getOptional("vertical")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
     * Returns the raw JSON value of [contactName].
     *
     * Unlike [contactName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contactName") @ExcludeMissing fun _contactName(): JsonField<String> = contactName

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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [cspId].
     *
     * Unlike [cspId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cspId") @ExcludeMissing fun _cspId(): JsonField<String> = cspId

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
    @JsonProperty("entityType") @ExcludeMissing fun _entityType(): JsonField<String> = entityType

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
     * Returns the raw JSON value of [identityStatus].
     *
     * Unlike [identityStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("identityStatus")
    @ExcludeMissing
    fun _identityStatus(): JsonField<IdentityStatus> = identityStatus

    /**
     * Returns the raw JSON value of [isInherited].
     *
     * Unlike [isInherited], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isInherited")
    @ExcludeMissing
    fun _isInherited(): JsonField<Boolean> = isInherited

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
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [street].
     *
     * Unlike [street], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("street") @ExcludeMissing fun _street(): JsonField<String> = street

    /**
     * Returns the raw JSON value of [submittedAt].
     *
     * Unlike [submittedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("submittedAt")
    @ExcludeMissing
    fun _submittedAt(): JsonField<OffsetDateTime> = submittedAt

    /**
     * Returns the raw JSON value of [submittedToTcr].
     *
     * Unlike [submittedToTcr], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("submittedToTCR")
    @ExcludeMissing
    fun _submittedToTcr(): JsonField<Boolean> = submittedToTcr

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

    /**
     * Returns the raw JSON value of [tcrBrandId].
     *
     * Unlike [tcrBrandId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tcrBrandId") @ExcludeMissing fun _tcrBrandId(): JsonField<String> = tcrBrandId

    /**
     * Returns the raw JSON value of [universalEin].
     *
     * Unlike [universalEin], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("universalEin")
    @ExcludeMissing
    fun _universalEin(): JsonField<String> = universalEin

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [vertical].
     *
     * Unlike [vertical], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vertical") @ExcludeMissing fun _vertical(): JsonField<TcrVertical> = vertical

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

        /** Returns a mutable builder for constructing an instance of [BrandWithKyc]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandWithKyc]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of()
        private var businessLegalName: JsonField<String> = JsonMissing.of()
        private var businessName: JsonField<String> = JsonMissing.of()
        private var businessRole: JsonField<String> = JsonMissing.of()
        private var businessUrl: JsonField<String> = JsonMissing.of()
        private var city: JsonField<String> = JsonMissing.of()
        private var contactEmail: JsonField<String> = JsonMissing.of()
        private var contactName: JsonField<String> = JsonMissing.of()
        private var contactPhone: JsonField<String> = JsonMissing.of()
        private var contactPhoneCountryCode: JsonField<String> = JsonMissing.of()
        private var country: JsonField<String> = JsonMissing.of()
        private var countryOfRegistration: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var cspId: JsonField<String> = JsonMissing.of()
        private var destinationCountries: JsonField<MutableList<DestinationCountry>>? = null
        private var entityType: JsonField<String> = JsonMissing.of()
        private var expectedMessagingVolume: JsonField<String> = JsonMissing.of()
        private var identityStatus: JsonField<IdentityStatus> = JsonMissing.of()
        private var isInherited: JsonField<Boolean> = JsonMissing.of()
        private var isTcrApplication: JsonField<Boolean> = JsonMissing.of()
        private var notes: JsonField<String> = JsonMissing.of()
        private var phoneNumberPrefix: JsonField<String> = JsonMissing.of()
        private var postalCode: JsonField<String> = JsonMissing.of()
        private var primaryUseCase: JsonField<String> = JsonMissing.of()
        private var state: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var street: JsonField<String> = JsonMissing.of()
        private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var submittedToTcr: JsonField<Boolean> = JsonMissing.of()
        private var taxId: JsonField<String> = JsonMissing.of()
        private var taxIdType: JsonField<String> = JsonMissing.of()
        private var tcrBrandId: JsonField<String> = JsonMissing.of()
        private var universalEin: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var vertical: JsonField<TcrVertical> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandWithKyc: BrandWithKyc) = apply {
            id = brandWithKyc.id
            brandRelationship = brandWithKyc.brandRelationship
            businessLegalName = brandWithKyc.businessLegalName
            businessName = brandWithKyc.businessName
            businessRole = brandWithKyc.businessRole
            businessUrl = brandWithKyc.businessUrl
            city = brandWithKyc.city
            contactEmail = brandWithKyc.contactEmail
            contactName = brandWithKyc.contactName
            contactPhone = brandWithKyc.contactPhone
            contactPhoneCountryCode = brandWithKyc.contactPhoneCountryCode
            country = brandWithKyc.country
            countryOfRegistration = brandWithKyc.countryOfRegistration
            createdAt = brandWithKyc.createdAt
            cspId = brandWithKyc.cspId
            destinationCountries = brandWithKyc.destinationCountries.map { it.toMutableList() }
            entityType = brandWithKyc.entityType
            expectedMessagingVolume = brandWithKyc.expectedMessagingVolume
            identityStatus = brandWithKyc.identityStatus
            isInherited = brandWithKyc.isInherited
            isTcrApplication = brandWithKyc.isTcrApplication
            notes = brandWithKyc.notes
            phoneNumberPrefix = brandWithKyc.phoneNumberPrefix
            postalCode = brandWithKyc.postalCode
            primaryUseCase = brandWithKyc.primaryUseCase
            state = brandWithKyc.state
            status = brandWithKyc.status
            street = brandWithKyc.street
            submittedAt = brandWithKyc.submittedAt
            submittedToTcr = brandWithKyc.submittedToTcr
            taxId = brandWithKyc.taxId
            taxIdType = brandWithKyc.taxIdType
            tcrBrandId = brandWithKyc.tcrBrandId
            universalEin = brandWithKyc.universalEin
            updatedAt = brandWithKyc.updatedAt
            vertical = brandWithKyc.vertical
            additionalProperties = brandWithKyc.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the brand */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Brand relationship level with TCR */
        fun brandRelationship(brandRelationship: TcrBrandRelationship?) =
            brandRelationship(JsonField.ofNullable(brandRelationship))

        /** Alias for calling [Builder.brandRelationship] with `brandRelationship.orElse(null)`. */
        fun brandRelationship(brandRelationship: Optional<TcrBrandRelationship>) =
            brandRelationship(brandRelationship.getOrNull())

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

        /** Primary contact name */
        fun contactName(contactName: String) = contactName(JsonField.of(contactName))

        /**
         * Sets [Builder.contactName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactName(contactName: JsonField<String>) = apply { this.contactName = contactName }

        /** Contact phone number */
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

        /** Contact phone country code */
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

        /** Country code */
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

        /** When the brand was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** CSP (Campaign Service Provider) ID */
        fun cspId(cspId: String?) = cspId(JsonField.ofNullable(cspId))

        /** Alias for calling [Builder.cspId] with `cspId.orElse(null)`. */
        fun cspId(cspId: Optional<String>) = cspId(cspId.getOrNull())

        /**
         * Sets [Builder.cspId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cspId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cspId(cspId: JsonField<String>) = apply { this.cspId = cspId }

        /** List of destination countries for messaging */
        fun destinationCountries(destinationCountries: List<DestinationCountry>) =
            destinationCountries(JsonField.of(destinationCountries))

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
        fun entityType(entityType: String?) = entityType(JsonField.ofNullable(entityType))

        /** Alias for calling [Builder.entityType] with `entityType.orElse(null)`. */
        fun entityType(entityType: Optional<String>) = entityType(entityType.getOrNull())

        /**
         * Sets [Builder.entityType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entityType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun entityType(entityType: JsonField<String>) = apply { this.entityType = entityType }

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

        /** TCR brand identity verification status */
        fun identityStatus(identityStatus: IdentityStatus?) =
            identityStatus(JsonField.ofNullable(identityStatus))

        /** Alias for calling [Builder.identityStatus] with `identityStatus.orElse(null)`. */
        fun identityStatus(identityStatus: Optional<IdentityStatus>) =
            identityStatus(identityStatus.getOrNull())

        /**
         * Sets [Builder.identityStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.identityStatus] with a well-typed [IdentityStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun identityStatus(identityStatus: JsonField<IdentityStatus>) = apply {
            this.identityStatus = identityStatus
        }

        /** Whether this brand is inherited from parent organization */
        fun isInherited(isInherited: Boolean) = isInherited(JsonField.of(isInherited))

        /**
         * Sets [Builder.isInherited] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isInherited] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isInherited(isInherited: JsonField<Boolean>) = apply { this.isInherited = isInherited }

        /** Whether this is a TCR application */
        fun isTcrApplication(isTcrApplication: Boolean) =
            isTcrApplication(JsonField.of(isTcrApplication))

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

        /** Additional notes */
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

        /** Phone number prefix for messaging */
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

        /** TCR brand status */
        fun status(status: Status?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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

        /** When the brand was submitted to TCR */
        fun submittedAt(submittedAt: OffsetDateTime?) =
            submittedAt(JsonField.ofNullable(submittedAt))

        /** Alias for calling [Builder.submittedAt] with `submittedAt.orElse(null)`. */
        fun submittedAt(submittedAt: Optional<OffsetDateTime>) =
            submittedAt(submittedAt.getOrNull())

        /**
         * Sets [Builder.submittedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.submittedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
            this.submittedAt = submittedAt
        }

        /** Whether this brand was submitted to TCR */
        fun submittedToTcr(submittedToTcr: Boolean) = submittedToTcr(JsonField.of(submittedToTcr))

        /**
         * Sets [Builder.submittedToTcr] to an arbitrary JSON value.
         *
         * You should usually call [Builder.submittedToTcr] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun submittedToTcr(submittedToTcr: JsonField<Boolean>) = apply {
            this.submittedToTcr = submittedToTcr
        }

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

        /** Type of tax ID */
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

        /** TCR brand ID (populated after TCR submission) */
        fun tcrBrandId(tcrBrandId: String?) = tcrBrandId(JsonField.ofNullable(tcrBrandId))

        /** Alias for calling [Builder.tcrBrandId] with `tcrBrandId.orElse(null)`. */
        fun tcrBrandId(tcrBrandId: Optional<String>) = tcrBrandId(tcrBrandId.getOrNull())

        /**
         * Sets [Builder.tcrBrandId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tcrBrandId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tcrBrandId(tcrBrandId: JsonField<String>) = apply { this.tcrBrandId = tcrBrandId }

        /** Universal EIN from TCR */
        fun universalEin(universalEin: String?) = universalEin(JsonField.ofNullable(universalEin))

        /** Alias for calling [Builder.universalEin] with `universalEin.orElse(null)`. */
        fun universalEin(universalEin: Optional<String>) = universalEin(universalEin.getOrNull())

        /**
         * Sets [Builder.universalEin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.universalEin] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun universalEin(universalEin: JsonField<String>) = apply {
            this.universalEin = universalEin
        }

        /** When the brand was last updated */
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

        /** Business vertical/industry category */
        fun vertical(vertical: TcrVertical?) = vertical(JsonField.ofNullable(vertical))

        /** Alias for calling [Builder.vertical] with `vertical.orElse(null)`. */
        fun vertical(vertical: Optional<TcrVertical>) = vertical(vertical.getOrNull())

        /**
         * Sets [Builder.vertical] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vertical] with a well-typed [TcrVertical] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun vertical(vertical: JsonField<TcrVertical>) = apply { this.vertical = vertical }

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
         * Returns an immutable instance of [BrandWithKyc].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BrandWithKyc =
            BrandWithKyc(
                id,
                brandRelationship,
                businessLegalName,
                businessName,
                businessRole,
                businessUrl,
                city,
                contactEmail,
                contactName,
                contactPhone,
                contactPhoneCountryCode,
                country,
                countryOfRegistration,
                createdAt,
                cspId,
                (destinationCountries ?: JsonMissing.of()).map { it.toImmutable() },
                entityType,
                expectedMessagingVolume,
                identityStatus,
                isInherited,
                isTcrApplication,
                notes,
                phoneNumberPrefix,
                postalCode,
                primaryUseCase,
                state,
                status,
                street,
                submittedAt,
                submittedToTcr,
                taxId,
                taxIdType,
                tcrBrandId,
                universalEin,
                updatedAt,
                vertical,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BrandWithKyc = apply {
        if (validated) {
            return@apply
        }

        id()
        brandRelationship().ifPresent { it.validate() }
        businessLegalName()
        businessName()
        businessRole()
        businessUrl()
        city()
        contactEmail()
        contactName()
        contactPhone()
        contactPhoneCountryCode()
        country()
        countryOfRegistration()
        createdAt()
        cspId()
        destinationCountries().ifPresent { it.forEach { it.validate() } }
        entityType()
        expectedMessagingVolume()
        identityStatus().ifPresent { it.validate() }
        isInherited()
        isTcrApplication()
        notes()
        phoneNumberPrefix()
        postalCode()
        primaryUseCase()
        state()
        status().ifPresent { it.validate() }
        street()
        submittedAt()
        submittedToTcr()
        taxId()
        taxIdType()
        tcrBrandId()
        universalEin()
        updatedAt()
        vertical().ifPresent { it.validate() }
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
            (brandRelationship.asKnown().getOrNull()?.validity() ?: 0) +
            (if (businessLegalName.asKnown().isPresent) 1 else 0) +
            (if (businessName.asKnown().isPresent) 1 else 0) +
            (if (businessRole.asKnown().isPresent) 1 else 0) +
            (if (businessUrl.asKnown().isPresent) 1 else 0) +
            (if (city.asKnown().isPresent) 1 else 0) +
            (if (contactEmail.asKnown().isPresent) 1 else 0) +
            (if (contactName.asKnown().isPresent) 1 else 0) +
            (if (contactPhone.asKnown().isPresent) 1 else 0) +
            (if (contactPhoneCountryCode.asKnown().isPresent) 1 else 0) +
            (if (country.asKnown().isPresent) 1 else 0) +
            (if (countryOfRegistration.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (cspId.asKnown().isPresent) 1 else 0) +
            (destinationCountries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (entityType.asKnown().isPresent) 1 else 0) +
            (if (expectedMessagingVolume.asKnown().isPresent) 1 else 0) +
            (identityStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isInherited.asKnown().isPresent) 1 else 0) +
            (if (isTcrApplication.asKnown().isPresent) 1 else 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (if (phoneNumberPrefix.asKnown().isPresent) 1 else 0) +
            (if (postalCode.asKnown().isPresent) 1 else 0) +
            (if (primaryUseCase.asKnown().isPresent) 1 else 0) +
            (if (state.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (street.asKnown().isPresent) 1 else 0) +
            (if (submittedAt.asKnown().isPresent) 1 else 0) +
            (if (submittedToTcr.asKnown().isPresent) 1 else 0) +
            (if (taxId.asKnown().isPresent) 1 else 0) +
            (if (taxIdType.asKnown().isPresent) 1 else 0) +
            (if (tcrBrandId.asKnown().isPresent) 1 else 0) +
            (if (universalEin.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (vertical.asKnown().getOrNull()?.validity() ?: 0)

    /** TCR brand identity verification status */
    class IdentityStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val SELF_DECLARED = of("SELF_DECLARED")

            @JvmField val UNVERIFIED = of("UNVERIFIED")

            @JvmField val VERIFIED = of("VERIFIED")

            @JvmField val VETTED_VERIFIED = of("VETTED_VERIFIED")

            @JvmStatic fun of(value: String) = IdentityStatus(JsonField.of(value))
        }

        /** An enum containing [IdentityStatus]'s known values. */
        enum class Known {
            SELF_DECLARED,
            UNVERIFIED,
            VERIFIED,
            VETTED_VERIFIED,
        }

        /**
         * An enum containing [IdentityStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [IdentityStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SELF_DECLARED,
            UNVERIFIED,
            VERIFIED,
            VETTED_VERIFIED,
            /**
             * An enum member indicating that [IdentityStatus] was instantiated with an unknown
             * value.
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
                SELF_DECLARED -> Value.SELF_DECLARED
                UNVERIFIED -> Value.UNVERIFIED
                VERIFIED -> Value.VERIFIED
                VETTED_VERIFIED -> Value.VETTED_VERIFIED
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
                SELF_DECLARED -> Known.SELF_DECLARED
                UNVERIFIED -> Known.UNVERIFIED
                VERIFIED -> Known.VERIFIED
                VETTED_VERIFIED -> Known.VETTED_VERIFIED
                else -> throw SentDmInvalidDataException("Unknown IdentityStatus: $value")
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

        fun validate(): IdentityStatus = apply {
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

            return other is IdentityStatus && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** TCR brand status */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ACTIVE = of("ACTIVE")

            @JvmField val INACTIVE = of("INACTIVE")

            @JvmField val SUSPENDED = of("SUSPENDED")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            ACTIVE,
            INACTIVE,
            SUSPENDED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACTIVE,
            INACTIVE,
            SUSPENDED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
                SUSPENDED -> Value.SUSPENDED
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
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                SUSPENDED -> Known.SUSPENDED
                else -> throw SentDmInvalidDataException("Unknown Status: $value")
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

        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandWithKyc &&
            id == other.id &&
            brandRelationship == other.brandRelationship &&
            businessLegalName == other.businessLegalName &&
            businessName == other.businessName &&
            businessRole == other.businessRole &&
            businessUrl == other.businessUrl &&
            city == other.city &&
            contactEmail == other.contactEmail &&
            contactName == other.contactName &&
            contactPhone == other.contactPhone &&
            contactPhoneCountryCode == other.contactPhoneCountryCode &&
            country == other.country &&
            countryOfRegistration == other.countryOfRegistration &&
            createdAt == other.createdAt &&
            cspId == other.cspId &&
            destinationCountries == other.destinationCountries &&
            entityType == other.entityType &&
            expectedMessagingVolume == other.expectedMessagingVolume &&
            identityStatus == other.identityStatus &&
            isInherited == other.isInherited &&
            isTcrApplication == other.isTcrApplication &&
            notes == other.notes &&
            phoneNumberPrefix == other.phoneNumberPrefix &&
            postalCode == other.postalCode &&
            primaryUseCase == other.primaryUseCase &&
            state == other.state &&
            status == other.status &&
            street == other.street &&
            submittedAt == other.submittedAt &&
            submittedToTcr == other.submittedToTcr &&
            taxId == other.taxId &&
            taxIdType == other.taxIdType &&
            tcrBrandId == other.tcrBrandId &&
            universalEin == other.universalEin &&
            updatedAt == other.updatedAt &&
            vertical == other.vertical &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            brandRelationship,
            businessLegalName,
            businessName,
            businessRole,
            businessUrl,
            city,
            contactEmail,
            contactName,
            contactPhone,
            contactPhoneCountryCode,
            country,
            countryOfRegistration,
            createdAt,
            cspId,
            destinationCountries,
            entityType,
            expectedMessagingVolume,
            identityStatus,
            isInherited,
            isTcrApplication,
            notes,
            phoneNumberPrefix,
            postalCode,
            primaryUseCase,
            state,
            status,
            street,
            submittedAt,
            submittedToTcr,
            taxId,
            taxIdType,
            tcrBrandId,
            universalEin,
            updatedAt,
            vertical,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandWithKyc{id=$id, brandRelationship=$brandRelationship, businessLegalName=$businessLegalName, businessName=$businessName, businessRole=$businessRole, businessUrl=$businessUrl, city=$city, contactEmail=$contactEmail, contactName=$contactName, contactPhone=$contactPhone, contactPhoneCountryCode=$contactPhoneCountryCode, country=$country, countryOfRegistration=$countryOfRegistration, createdAt=$createdAt, cspId=$cspId, destinationCountries=$destinationCountries, entityType=$entityType, expectedMessagingVolume=$expectedMessagingVolume, identityStatus=$identityStatus, isInherited=$isInherited, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, postalCode=$postalCode, primaryUseCase=$primaryUseCase, state=$state, status=$status, street=$street, submittedAt=$submittedAt, submittedToTcr=$submittedToTcr, taxId=$taxId, taxIdType=$taxIdType, tcrBrandId=$tcrBrandId, universalEin=$universalEin, updatedAt=$updatedAt, vertical=$vertical, additionalProperties=$additionalProperties}"
}
