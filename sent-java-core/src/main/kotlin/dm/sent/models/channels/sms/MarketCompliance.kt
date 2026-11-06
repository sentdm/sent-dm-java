// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The compliance values a market registers with. `brand` and `campaign` apply to US `TEN_DLC`;
 * other markets fill this map with the document keys their own requirements name.
 */
class MarketCompliance
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val brand: JsonField<Brand>,
    private val campaign: JsonField<Campaign>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("brand") @ExcludeMissing brand: JsonField<Brand> = JsonMissing.of(),
        @JsonProperty("campaign") @ExcludeMissing campaign: JsonField<Campaign> = JsonMissing.of(),
    ) : this(brand, campaign, mutableMapOf())

    /**
     * Business identity. The identity the registration is filed against. Omit to have none; {
     * "inherit": true } to register under your organization's.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brand(): Optional<Brand> = brand.getOptional("brand")

    /**
     * Messaging campaign. What the programme sends and how recipients consented. Omit to run on
     * your organization's; supplying it takes one of your own. { "inherit": true } says so
     * outright. Required when `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun campaign(): Optional<Campaign> = campaign.getOptional("campaign")

    /**
     * Returns the raw JSON value of [brand].
     *
     * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<Brand> = brand

    /**
     * Returns the raw JSON value of [campaign].
     *
     * Unlike [campaign], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("campaign") @ExcludeMissing fun _campaign(): JsonField<Campaign> = campaign

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

        /** Returns a mutable builder for constructing an instance of [MarketCompliance]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MarketCompliance]. */
    class Builder internal constructor() {

        private var brand: JsonField<Brand> = JsonMissing.of()
        private var campaign: JsonField<Campaign> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(marketCompliance: MarketCompliance) = apply {
            brand = marketCompliance.brand
            campaign = marketCompliance.campaign
            additionalProperties = marketCompliance.additionalProperties.toMutableMap()
        }

        /**
         * Business identity. The identity the registration is filed against. Omit to have none; {
         * "inherit": true } to register under your organization's.
         */
        fun brand(brand: Brand) = brand(JsonField.of(brand))

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun brand(brand: JsonField<Brand>) = apply { this.brand = brand }

        /**
         * Messaging campaign. What the programme sends and how recipients consented. Omit to run on
         * your organization's; supplying it takes one of your own. { "inherit": true } says so
         * outright. Required when `compliance.campaign.inherit != true`.
         */
        fun campaign(campaign: Campaign) = campaign(JsonField.of(campaign))

        /**
         * Sets [Builder.campaign] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaign] with a well-typed [Campaign] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun campaign(campaign: JsonField<Campaign>) = apply { this.campaign = campaign }

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
         * Returns an immutable instance of [MarketCompliance].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MarketCompliance =
            MarketCompliance(brand, campaign, additionalProperties.toMutableMap())
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
    fun validate(): MarketCompliance = apply {
        if (validated) {
            return@apply
        }

        brand().ifPresent { it.validate() }
        campaign().ifPresent { it.validate() }
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
        (brand.asKnown().getOrNull()?.validity() ?: 0) +
            (campaign.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Business identity. The identity the registration is filed against. Omit to have none; {
     * "inherit": true } to register under your organization's.
     */
    class Brand
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val businessName: JsonField<String>,
        private val city: JsonField<String>,
        private val contactEmail: JsonField<String>,
        private val contactName: JsonField<String>,
        private val contactPhone: JsonField<String>,
        private val country: JsonField<String>,
        private val einIssuingCountry: JsonField<String>,
        private val entityType: JsonField<EntityType>,
        private val inherit: JsonField<Boolean>,
        private val legalName: JsonField<String>,
        private val postalCode: JsonField<String>,
        private val state: JsonField<String>,
        private val street: JsonField<String>,
        private val taxId: JsonField<String>,
        private val taxIdType: JsonField<String>,
        private val website: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("business_name")
            @ExcludeMissing
            businessName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contact_email")
            @ExcludeMissing
            contactEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contact_name")
            @ExcludeMissing
            contactName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contact_phone")
            @ExcludeMissing
            contactPhone: JsonField<String> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ein_issuing_country")
            @ExcludeMissing
            einIssuingCountry: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entity_type")
            @ExcludeMissing
            entityType: JsonField<EntityType> = JsonMissing.of(),
            @JsonProperty("inherit") @ExcludeMissing inherit: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("legal_name")
            @ExcludeMissing
            legalName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("postal_code")
            @ExcludeMissing
            postalCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("street") @ExcludeMissing street: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tax_id") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tax_id_type")
            @ExcludeMissing
            taxIdType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("website") @ExcludeMissing website: JsonField<String> = JsonMissing.of(),
        ) : this(
            businessName,
            city,
            contactEmail,
            contactName,
            contactPhone,
            country,
            einIssuingCountry,
            entityType,
            inherit,
            legalName,
            postalCode,
            state,
            street,
            taxId,
            taxIdType,
            website,
            mutableMapOf(),
        )

        /**
         * Public-facing name. TCR displayName — the name recipients would recognise. Named for what
         * it holds rather than for TCR's field, which is why it is not `display_name`. Required
         * when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun businessName(): Optional<String> = businessName.getOptional("business_name")

        /**
         * City. Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun city(): Optional<String> = city.getOptional("city")

        /**
         * Contact email. TCR email. Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contactEmail(): Optional<String> = contactEmail.getOptional("contact_email")

        /**
         * Responsible contact. Split into TCR's firstName/lastName on submission. BrandService
         * refuses a blank one, so a missing name is reported here rather than thrown after the
         * profile was written. Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contactName(): Optional<String> = contactName.getOptional("contact_name")

        /**
         * Contact phone. TCR sends it as both phone and mobilePhone, so it is asked for once. Named
         * for the contact it belongs to rather than as a bare `phone` on a block that also carries
         * an address. Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contactPhone(): Optional<String> = contactPhone.getOptional("contact_phone")

        /**
         * Country of registration. Two letters — US. The country spelled out in full is accepted
         * too and stored as its code, which is what a read answers with and what is filed. Required
         * when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * Country that issued the tax id. TCR einIssuingCountry — where the tax id was issued,
         * which is not always where the business trades. Defaults to `country` when omitted, which
         * is right for most. Takes the code or the country spelled out, as `country` does.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun einIssuingCountry(): Optional<String> =
            einIssuingCountry.getOptional("ein_issuing_country")

        /**
         * Entity type. TCR entityType. Decides which vetting TCR applies and, for SOLE_PROPRIETOR,
         * fixes the campaign fee regardless of volume. Also refused at submission if absent.
         * Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun entityType(): Optional<EntityType> = entityType.getOptional("entity_type")

        /**
         * Run on the organization's brand. True to register under the parent organization's
         * identity rather than one of this profile's own; every field below is then neither asked
         * for nor accepted. Omitted, the brand is the organization's unless this block supplies
         * identity fields, which says plainly enough that it wants one of its own.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inherit(): Optional<Boolean> = inherit.getOptional("inherit")

        /**
         * Registered legal name. TCR companyName — the name on the incorporation documents, which
         * is often not the name recipients would recognise. Required when `compliance.brand.inherit
         * != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun legalName(): Optional<String> = legalName.getOptional("legal_name")

        /**
         * Postal code. Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun postalCode(): Optional<String> = postalCode.getOptional("postal_code")

        /**
         * State or region. TCR state. Two letters for a US registration. Required when
         * `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun state(): Optional<String> = state.getOptional("state")

        /**
         * Street address. Required when `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun street(): Optional<String> = street.getOptional("street")

        /**
         * Tax identifier. TCR ein. TcrBrandSubmissionValidator refuses a submission without one, so
         * it is wanted here rather than discovered at filing time. Required when
         * `compliance.brand.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun taxId(): Optional<String> = taxId.getOptional("tax_id")

        /**
         * Kind of tax identifier. Which kind of identifier `tax_id` is, e.g. us_ein. Derived onto
         * the brand form, and not itself sent to TCR. Required when `compliance.brand.inherit !=
         * true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun taxIdType(): Optional<String> = taxIdType.getOptional("tax_id_type")

        /**
         * Website. TCR website. Optional, and worth sending: carriers weigh it when vetting, so a
         * brand that has one and omits it is vetted on less than it could be.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun website(): Optional<String> = website.getOptional("website")

        /**
         * Returns the raw JSON value of [businessName].
         *
         * Unlike [businessName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("business_name")
        @ExcludeMissing
        fun _businessName(): JsonField<String> = businessName

        /**
         * Returns the raw JSON value of [city].
         *
         * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * Returns the raw JSON value of [contactEmail].
         *
         * Unlike [contactEmail], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contact_email")
        @ExcludeMissing
        fun _contactEmail(): JsonField<String> = contactEmail

        /**
         * Returns the raw JSON value of [contactName].
         *
         * Unlike [contactName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contact_name")
        @ExcludeMissing
        fun _contactName(): JsonField<String> = contactName

        /**
         * Returns the raw JSON value of [contactPhone].
         *
         * Unlike [contactPhone], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contact_phone")
        @ExcludeMissing
        fun _contactPhone(): JsonField<String> = contactPhone

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [einIssuingCountry].
         *
         * Unlike [einIssuingCountry], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ein_issuing_country")
        @ExcludeMissing
        fun _einIssuingCountry(): JsonField<String> = einIssuingCountry

        /**
         * Returns the raw JSON value of [entityType].
         *
         * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entity_type")
        @ExcludeMissing
        fun _entityType(): JsonField<EntityType> = entityType

        /**
         * Returns the raw JSON value of [inherit].
         *
         * Unlike [inherit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inherit") @ExcludeMissing fun _inherit(): JsonField<Boolean> = inherit

        /**
         * Returns the raw JSON value of [legalName].
         *
         * Unlike [legalName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("legal_name") @ExcludeMissing fun _legalName(): JsonField<String> = legalName

        /**
         * Returns the raw JSON value of [postalCode].
         *
         * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postal_code")
        @ExcludeMissing
        fun _postalCode(): JsonField<String> = postalCode

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
        @JsonProperty("tax_id") @ExcludeMissing fun _taxId(): JsonField<String> = taxId

        /**
         * Returns the raw JSON value of [taxIdType].
         *
         * Unlike [taxIdType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tax_id_type") @ExcludeMissing fun _taxIdType(): JsonField<String> = taxIdType

        /**
         * Returns the raw JSON value of [website].
         *
         * Unlike [website], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("website") @ExcludeMissing fun _website(): JsonField<String> = website

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

            /** Returns a mutable builder for constructing an instance of [Brand]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Brand]. */
        class Builder internal constructor() {

            private var businessName: JsonField<String> = JsonMissing.of()
            private var city: JsonField<String> = JsonMissing.of()
            private var contactEmail: JsonField<String> = JsonMissing.of()
            private var contactName: JsonField<String> = JsonMissing.of()
            private var contactPhone: JsonField<String> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var einIssuingCountry: JsonField<String> = JsonMissing.of()
            private var entityType: JsonField<EntityType> = JsonMissing.of()
            private var inherit: JsonField<Boolean> = JsonMissing.of()
            private var legalName: JsonField<String> = JsonMissing.of()
            private var postalCode: JsonField<String> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var street: JsonField<String> = JsonMissing.of()
            private var taxId: JsonField<String> = JsonMissing.of()
            private var taxIdType: JsonField<String> = JsonMissing.of()
            private var website: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(brand: Brand) = apply {
                businessName = brand.businessName
                city = brand.city
                contactEmail = brand.contactEmail
                contactName = brand.contactName
                contactPhone = brand.contactPhone
                country = brand.country
                einIssuingCountry = brand.einIssuingCountry
                entityType = brand.entityType
                inherit = brand.inherit
                legalName = brand.legalName
                postalCode = brand.postalCode
                state = brand.state
                street = brand.street
                taxId = brand.taxId
                taxIdType = brand.taxIdType
                website = brand.website
                additionalProperties = brand.additionalProperties.toMutableMap()
            }

            /**
             * Public-facing name. TCR displayName — the name recipients would recognise. Named for
             * what it holds rather than for TCR's field, which is why it is not `display_name`.
             * Required when `compliance.brand.inherit != true`.
             */
            fun businessName(businessName: String) = businessName(JsonField.of(businessName))

            /**
             * Sets [Builder.businessName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.businessName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun businessName(businessName: JsonField<String>) = apply {
                this.businessName = businessName
            }

            /** City. Required when `compliance.brand.inherit != true`. */
            fun city(city: String) = city(JsonField.of(city))

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            /** Contact email. TCR email. Required when `compliance.brand.inherit != true`. */
            fun contactEmail(contactEmail: String) = contactEmail(JsonField.of(contactEmail))

            /**
             * Sets [Builder.contactEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contactEmail] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contactEmail(contactEmail: JsonField<String>) = apply {
                this.contactEmail = contactEmail
            }

            /**
             * Responsible contact. Split into TCR's firstName/lastName on submission. BrandService
             * refuses a blank one, so a missing name is reported here rather than thrown after the
             * profile was written. Required when `compliance.brand.inherit != true`.
             */
            fun contactName(contactName: String) = contactName(JsonField.of(contactName))

            /**
             * Sets [Builder.contactName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contactName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contactName(contactName: JsonField<String>) = apply {
                this.contactName = contactName
            }

            /**
             * Contact phone. TCR sends it as both phone and mobilePhone, so it is asked for once.
             * Named for the contact it belongs to rather than as a bare `phone` on a block that
             * also carries an address. Required when `compliance.brand.inherit != true`.
             */
            fun contactPhone(contactPhone: String) = contactPhone(JsonField.of(contactPhone))

            /**
             * Sets [Builder.contactPhone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contactPhone] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contactPhone(contactPhone: JsonField<String>) = apply {
                this.contactPhone = contactPhone
            }

            /**
             * Country of registration. Two letters — US. The country spelled out in full is
             * accepted too and stored as its code, which is what a read answers with and what is
             * filed. Required when `compliance.brand.inherit != true`.
             */
            fun country(country: String) = country(JsonField.of(country))

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /**
             * Country that issued the tax id. TCR einIssuingCountry — where the tax id was issued,
             * which is not always where the business trades. Defaults to `country` when omitted,
             * which is right for most. Takes the code or the country spelled out, as `country`
             * does.
             */
            fun einIssuingCountry(einIssuingCountry: String) =
                einIssuingCountry(JsonField.of(einIssuingCountry))

            /**
             * Sets [Builder.einIssuingCountry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.einIssuingCountry] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun einIssuingCountry(einIssuingCountry: JsonField<String>) = apply {
                this.einIssuingCountry = einIssuingCountry
            }

            /**
             * Entity type. TCR entityType. Decides which vetting TCR applies and, for
             * SOLE_PROPRIETOR, fixes the campaign fee regardless of volume. Also refused at
             * submission if absent. Required when `compliance.brand.inherit != true`.
             */
            fun entityType(entityType: EntityType) = entityType(JsonField.of(entityType))

            /**
             * Sets [Builder.entityType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.entityType] with a well-typed [EntityType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun entityType(entityType: JsonField<EntityType>) = apply {
                this.entityType = entityType
            }

            /**
             * Run on the organization's brand. True to register under the parent organization's
             * identity rather than one of this profile's own; every field below is then neither
             * asked for nor accepted. Omitted, the brand is the organization's unless this block
             * supplies identity fields, which says plainly enough that it wants one of its own.
             */
            fun inherit(inherit: Boolean) = inherit(JsonField.of(inherit))

            /**
             * Sets [Builder.inherit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inherit] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inherit(inherit: JsonField<Boolean>) = apply { this.inherit = inherit }

            /**
             * Registered legal name. TCR companyName — the name on the incorporation documents,
             * which is often not the name recipients would recognise. Required when
             * `compliance.brand.inherit != true`.
             */
            fun legalName(legalName: String) = legalName(JsonField.of(legalName))

            /**
             * Sets [Builder.legalName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.legalName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun legalName(legalName: JsonField<String>) = apply { this.legalName = legalName }

            /** Postal code. Required when `compliance.brand.inherit != true`. */
            fun postalCode(postalCode: String) = postalCode(JsonField.of(postalCode))

            /**
             * Sets [Builder.postalCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.postalCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

            /**
             * State or region. TCR state. Two letters for a US registration. Required when
             * `compliance.brand.inherit != true`.
             */
            fun state(state: String) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            /** Street address. Required when `compliance.brand.inherit != true`. */
            fun street(street: String) = street(JsonField.of(street))

            /**
             * Sets [Builder.street] to an arbitrary JSON value.
             *
             * You should usually call [Builder.street] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun street(street: JsonField<String>) = apply { this.street = street }

            /**
             * Tax identifier. TCR ein. TcrBrandSubmissionValidator refuses a submission without
             * one, so it is wanted here rather than discovered at filing time. Required when
             * `compliance.brand.inherit != true`.
             */
            fun taxId(taxId: String) = taxId(JsonField.of(taxId))

            /**
             * Sets [Builder.taxId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taxId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun taxId(taxId: JsonField<String>) = apply { this.taxId = taxId }

            /**
             * Kind of tax identifier. Which kind of identifier `tax_id` is, e.g. us_ein. Derived
             * onto the brand form, and not itself sent to TCR. Required when
             * `compliance.brand.inherit != true`.
             */
            fun taxIdType(taxIdType: String) = taxIdType(JsonField.of(taxIdType))

            /**
             * Sets [Builder.taxIdType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taxIdType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun taxIdType(taxIdType: JsonField<String>) = apply { this.taxIdType = taxIdType }

            /**
             * Website. TCR website. Optional, and worth sending: carriers weigh it when vetting, so
             * a brand that has one and omits it is vetted on less than it could be.
             */
            fun website(website: String) = website(JsonField.of(website))

            /**
             * Sets [Builder.website] to an arbitrary JSON value.
             *
             * You should usually call [Builder.website] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun website(website: JsonField<String>) = apply { this.website = website }

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
             * Returns an immutable instance of [Brand].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Brand =
                Brand(
                    businessName,
                    city,
                    contactEmail,
                    contactName,
                    contactPhone,
                    country,
                    einIssuingCountry,
                    entityType,
                    inherit,
                    legalName,
                    postalCode,
                    state,
                    street,
                    taxId,
                    taxIdType,
                    website,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Brand = apply {
            if (validated) {
                return@apply
            }

            businessName()
            city()
            contactEmail()
            contactName()
            contactPhone()
            country()
            einIssuingCountry()
            entityType().ifPresent { it.validate() }
            inherit()
            legalName()
            postalCode()
            state()
            street()
            taxId()
            taxIdType()
            website()
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
            (if (businessName.asKnown().isPresent) 1 else 0) +
                (if (city.asKnown().isPresent) 1 else 0) +
                (if (contactEmail.asKnown().isPresent) 1 else 0) +
                (if (contactName.asKnown().isPresent) 1 else 0) +
                (if (contactPhone.asKnown().isPresent) 1 else 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (einIssuingCountry.asKnown().isPresent) 1 else 0) +
                (entityType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (inherit.asKnown().isPresent) 1 else 0) +
                (if (legalName.asKnown().isPresent) 1 else 0) +
                (if (postalCode.asKnown().isPresent) 1 else 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (if (street.asKnown().isPresent) 1 else 0) +
                (if (taxId.asKnown().isPresent) 1 else 0) +
                (if (taxIdType.asKnown().isPresent) 1 else 0) +
                (if (website.asKnown().isPresent) 1 else 0)

        /**
         * Entity type. TCR entityType. Decides which vetting TCR applies and, for SOLE_PROPRIETOR,
         * fixes the campaign fee regardless of volume. Also refused at submission if absent.
         * Required when `compliance.brand.inherit != true`.
         */
        class EntityType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PRIVATE_PROFIT,
                PUBLIC_PROFIT,
                NON_PROFIT,
                SOLE_PROPRIETOR,
                GOVERNMENT,
                /**
                 * An enum member indicating that [EntityType] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SentInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    PRIVATE_PROFIT -> Known.PRIVATE_PROFIT
                    PUBLIC_PROFIT -> Known.PUBLIC_PROFIT
                    NON_PROFIT -> Known.NON_PROFIT
                    SOLE_PROPRIETOR -> Known.SOLE_PROPRIETOR
                    GOVERNMENT -> Known.GOVERNMENT
                    else -> throw SentInvalidDataException("Unknown EntityType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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
                } catch (e: SentInvalidDataException) {
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

            return other is Brand &&
                businessName == other.businessName &&
                city == other.city &&
                contactEmail == other.contactEmail &&
                contactName == other.contactName &&
                contactPhone == other.contactPhone &&
                country == other.country &&
                einIssuingCountry == other.einIssuingCountry &&
                entityType == other.entityType &&
                inherit == other.inherit &&
                legalName == other.legalName &&
                postalCode == other.postalCode &&
                state == other.state &&
                street == other.street &&
                taxId == other.taxId &&
                taxIdType == other.taxIdType &&
                website == other.website &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                businessName,
                city,
                contactEmail,
                contactName,
                contactPhone,
                country,
                einIssuingCountry,
                entityType,
                inherit,
                legalName,
                postalCode,
                state,
                street,
                taxId,
                taxIdType,
                website,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Brand{businessName=$businessName, city=$city, contactEmail=$contactEmail, contactName=$contactName, contactPhone=$contactPhone, country=$country, einIssuingCountry=$einIssuingCountry, entityType=$entityType, inherit=$inherit, legalName=$legalName, postalCode=$postalCode, state=$state, street=$street, taxId=$taxId, taxIdType=$taxIdType, website=$website, additionalProperties=$additionalProperties}"
    }

    /**
     * Messaging campaign. What the programme sends and how recipients consented. Omit to run on
     * your organization's; supplying it takes one of your own. { "inherit": true } says so
     * outright. Required when `compliance.campaign.inherit != true`.
     */
    class Campaign
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val helpKeywords: JsonField<String>,
        private val helpMessage: JsonField<String>,
        private val inherit: JsonField<Boolean>,
        private val messageFlow: JsonField<String>,
        private val optInKeywords: JsonField<String>,
        private val optInMessage: JsonField<String>,
        private val optOutKeywords: JsonField<String>,
        private val optOutMessage: JsonField<String>,
        private val privacyPolicyLink: JsonField<String>,
        private val termsAndConditionsLink: JsonField<String>,
        private val useCases: JsonField<List<UseCase>>,
        private val volume: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("help_keywords")
            @ExcludeMissing
            helpKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("help_message")
            @ExcludeMissing
            helpMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inherit") @ExcludeMissing inherit: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("message_flow")
            @ExcludeMissing
            messageFlow: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_in_keywords")
            @ExcludeMissing
            optInKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_in_message")
            @ExcludeMissing
            optInMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_out_keywords")
            @ExcludeMissing
            optOutKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_out_message")
            @ExcludeMissing
            optOutMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("privacy_policy_link")
            @ExcludeMissing
            privacyPolicyLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("terms_and_conditions_link")
            @ExcludeMissing
            termsAndConditionsLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("use_cases")
            @ExcludeMissing
            useCases: JsonField<List<UseCase>> = JsonMissing.of(),
            @JsonProperty("volume") @ExcludeMissing volume: JsonField<String> = JsonMissing.of(),
        ) : this(
            description,
            helpKeywords,
            helpMessage,
            inherit,
            messageFlow,
            optInKeywords,
            optInMessage,
            optOutKeywords,
            optOutMessage,
            privacyPolicyLink,
            termsAndConditionsLink,
            useCases,
            volume,
            mutableMapOf(),
        )

        /**
         * What this programme sends. TCR description: what recipients will get and why, in a
         * sentence. The only one of these TCR takes verbatim as a description of the programme,
         * which is why it is asked for rather than derived from the customer's name. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Help keywords. TCR helpKeywords, comma separated, e.g. HELP,INFO. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpKeywords(): Optional<String> = helpKeywords.getOptional("help_keywords")

        /**
         * Help reply. TCR helpMessage. Its presence is what sets subscriberHelp. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpMessage(): Optional<String> = helpMessage.getOptional("help_message")

        /**
         * Run on the organization's campaign. True to register under the parent organization's
         * programme rather than one of this profile's own; every field below is then neither asked
         * for nor accepted. Owning the identity and inheriting the campaign is refused — a campaign
         * is filed against an identity registration, and chk_tcr_inheritance forbids that pairing
         * outright.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inherit(): Optional<Boolean> = inherit.getOptional("inherit")

        /**
         * Consent narrative. TCR messageFlow: how recipients opt in, in prose. Under 40 characters
         * is refused, and carriers reject vague descriptions — say where opt-in happens, that the
         * box is unchecked by default, and that consent is not a condition of purchase. Required
         * when `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messageFlow(): Optional<String> = messageFlow.getOptional("message_flow")

        /**
         * Opt-in keywords. TCR optinKeywords, comma separated, e.g. START,YES. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optInKeywords(): Optional<String> = optInKeywords.getOptional("opt_in_keywords")

        /**
         * Opt-in confirmation. TCR optinMessage. Should state message frequency and that rates may
         * apply. Its presence is what sets subscriberOptin. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optInMessage(): Optional<String> = optInMessage.getOptional("opt_in_message")

        /**
         * Opt-out keywords. TCR optoutKeywords, comma separated. STOP, END, CANCEL, UNSUBSCRIBE and
         * QUIT are honoured regardless of what is declared. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optOutKeywords(): Optional<String> = optOutKeywords.getOptional("opt_out_keywords")

        /**
         * Opt-out confirmation. TCR optoutMessage. Its presence is what sets subscriberOptout.
         * Required when `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optOutMessage(): Optional<String> = optOutMessage.getOptional("opt_out_message")

        /**
         * Privacy policy URL. TCR privacyPolicyLink. Required when `compliance.campaign.inherit !=
         * true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun privacyPolicyLink(): Optional<String> =
            privacyPolicyLink.getOptional("privacy_policy_link")

        /**
         * Terms and conditions URL. TCR termsAndConditionsLink. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun termsAndConditionsLink(): Optional<String> =
            termsAndConditionsLink.getOptional("terms_and_conditions_link")

        /**
         * Use cases. What the campaign sends, and an example of each. One to five entries; how they
         * register is decided by volume, never declared. Required when `compliance.campaign.inherit
         * != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun useCases(): Optional<List<UseCase>> = useCases.getOptional("use_cases")

        /**
         * Expected monthly volume. Decides how the campaign registers and which fee tier applies:
         * below the low-volume threshold it registers as LOW_VOLUME with sub-use-cases, above it as
         * a single use case or MIXED. Omitting it registers the campaign at the higher-fee standard
         * tier.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun volume(): Optional<String> = volume.getOptional("volume")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [helpKeywords].
         *
         * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("help_keywords")
        @ExcludeMissing
        fun _helpKeywords(): JsonField<String> = helpKeywords

        /**
         * Returns the raw JSON value of [helpMessage].
         *
         * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("help_message")
        @ExcludeMissing
        fun _helpMessage(): JsonField<String> = helpMessage

        /**
         * Returns the raw JSON value of [inherit].
         *
         * Unlike [inherit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inherit") @ExcludeMissing fun _inherit(): JsonField<Boolean> = inherit

        /**
         * Returns the raw JSON value of [messageFlow].
         *
         * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message_flow")
        @ExcludeMissing
        fun _messageFlow(): JsonField<String> = messageFlow

        /**
         * Returns the raw JSON value of [optInKeywords].
         *
         * Unlike [optInKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_in_keywords")
        @ExcludeMissing
        fun _optInKeywords(): JsonField<String> = optInKeywords

        /**
         * Returns the raw JSON value of [optInMessage].
         *
         * Unlike [optInMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_in_message")
        @ExcludeMissing
        fun _optInMessage(): JsonField<String> = optInMessage

        /**
         * Returns the raw JSON value of [optOutKeywords].
         *
         * Unlike [optOutKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_out_keywords")
        @ExcludeMissing
        fun _optOutKeywords(): JsonField<String> = optOutKeywords

        /**
         * Returns the raw JSON value of [optOutMessage].
         *
         * Unlike [optOutMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_out_message")
        @ExcludeMissing
        fun _optOutMessage(): JsonField<String> = optOutMessage

        /**
         * Returns the raw JSON value of [privacyPolicyLink].
         *
         * Unlike [privacyPolicyLink], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("privacy_policy_link")
        @ExcludeMissing
        fun _privacyPolicyLink(): JsonField<String> = privacyPolicyLink

        /**
         * Returns the raw JSON value of [termsAndConditionsLink].
         *
         * Unlike [termsAndConditionsLink], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("terms_and_conditions_link")
        @ExcludeMissing
        fun _termsAndConditionsLink(): JsonField<String> = termsAndConditionsLink

        /**
         * Returns the raw JSON value of [useCases].
         *
         * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("use_cases")
        @ExcludeMissing
        fun _useCases(): JsonField<List<UseCase>> = useCases

        /**
         * Returns the raw JSON value of [volume].
         *
         * Unlike [volume], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("volume") @ExcludeMissing fun _volume(): JsonField<String> = volume

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

            /** Returns a mutable builder for constructing an instance of [Campaign]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Campaign]. */
        class Builder internal constructor() {

            private var description: JsonField<String> = JsonMissing.of()
            private var helpKeywords: JsonField<String> = JsonMissing.of()
            private var helpMessage: JsonField<String> = JsonMissing.of()
            private var inherit: JsonField<Boolean> = JsonMissing.of()
            private var messageFlow: JsonField<String> = JsonMissing.of()
            private var optInKeywords: JsonField<String> = JsonMissing.of()
            private var optInMessage: JsonField<String> = JsonMissing.of()
            private var optOutKeywords: JsonField<String> = JsonMissing.of()
            private var optOutMessage: JsonField<String> = JsonMissing.of()
            private var privacyPolicyLink: JsonField<String> = JsonMissing.of()
            private var termsAndConditionsLink: JsonField<String> = JsonMissing.of()
            private var useCases: JsonField<MutableList<UseCase>>? = null
            private var volume: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(campaign: Campaign) = apply {
                description = campaign.description
                helpKeywords = campaign.helpKeywords
                helpMessage = campaign.helpMessage
                inherit = campaign.inherit
                messageFlow = campaign.messageFlow
                optInKeywords = campaign.optInKeywords
                optInMessage = campaign.optInMessage
                optOutKeywords = campaign.optOutKeywords
                optOutMessage = campaign.optOutMessage
                privacyPolicyLink = campaign.privacyPolicyLink
                termsAndConditionsLink = campaign.termsAndConditionsLink
                useCases = campaign.useCases.map { it.toMutableList() }
                volume = campaign.volume
                additionalProperties = campaign.additionalProperties.toMutableMap()
            }

            /**
             * What this programme sends. TCR description: what recipients will get and why, in a
             * sentence. The only one of these TCR takes verbatim as a description of the programme,
             * which is why it is asked for rather than derived from the customer's name. Required
             * when `compliance.campaign.inherit != true`.
             */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * Help keywords. TCR helpKeywords, comma separated, e.g. HELP,INFO. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun helpKeywords(helpKeywords: String) = helpKeywords(JsonField.of(helpKeywords))

            /**
             * Sets [Builder.helpKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpKeywords(helpKeywords: JsonField<String>) = apply {
                this.helpKeywords = helpKeywords
            }

            /**
             * Help reply. TCR helpMessage. Its presence is what sets subscriberHelp. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun helpMessage(helpMessage: String) = helpMessage(JsonField.of(helpMessage))

            /**
             * Sets [Builder.helpMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpMessage(helpMessage: JsonField<String>) = apply {
                this.helpMessage = helpMessage
            }

            /**
             * Run on the organization's campaign. True to register under the parent organization's
             * programme rather than one of this profile's own; every field below is then neither
             * asked for nor accepted. Owning the identity and inheriting the campaign is refused —
             * a campaign is filed against an identity registration, and chk_tcr_inheritance forbids
             * that pairing outright.
             */
            fun inherit(inherit: Boolean) = inherit(JsonField.of(inherit))

            /**
             * Sets [Builder.inherit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inherit] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inherit(inherit: JsonField<Boolean>) = apply { this.inherit = inherit }

            /**
             * Consent narrative. TCR messageFlow: how recipients opt in, in prose. Under 40
             * characters is refused, and carriers reject vague descriptions — say where opt-in
             * happens, that the box is unchecked by default, and that consent is not a condition of
             * purchase. Required when `compliance.campaign.inherit != true`.
             */
            fun messageFlow(messageFlow: String) = messageFlow(JsonField.of(messageFlow))

            /**
             * Sets [Builder.messageFlow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageFlow] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageFlow(messageFlow: JsonField<String>) = apply {
                this.messageFlow = messageFlow
            }

            /**
             * Opt-in keywords. TCR optinKeywords, comma separated, e.g. START,YES. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun optInKeywords(optInKeywords: String) = optInKeywords(JsonField.of(optInKeywords))

            /**
             * Sets [Builder.optInKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optInKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optInKeywords(optInKeywords: JsonField<String>) = apply {
                this.optInKeywords = optInKeywords
            }

            /**
             * Opt-in confirmation. TCR optinMessage. Should state message frequency and that rates
             * may apply. Its presence is what sets subscriberOptin. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun optInMessage(optInMessage: String) = optInMessage(JsonField.of(optInMessage))

            /**
             * Sets [Builder.optInMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optInMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optInMessage(optInMessage: JsonField<String>) = apply {
                this.optInMessage = optInMessage
            }

            /**
             * Opt-out keywords. TCR optoutKeywords, comma separated. STOP, END, CANCEL, UNSUBSCRIBE
             * and QUIT are honoured regardless of what is declared. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun optOutKeywords(optOutKeywords: String) =
                optOutKeywords(JsonField.of(optOutKeywords))

            /**
             * Sets [Builder.optOutKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optOutKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optOutKeywords(optOutKeywords: JsonField<String>) = apply {
                this.optOutKeywords = optOutKeywords
            }

            /**
             * Opt-out confirmation. TCR optoutMessage. Its presence is what sets subscriberOptout.
             * Required when `compliance.campaign.inherit != true`.
             */
            fun optOutMessage(optOutMessage: String) = optOutMessage(JsonField.of(optOutMessage))

            /**
             * Sets [Builder.optOutMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optOutMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optOutMessage(optOutMessage: JsonField<String>) = apply {
                this.optOutMessage = optOutMessage
            }

            /**
             * Privacy policy URL. TCR privacyPolicyLink. Required when `compliance.campaign.inherit
             * != true`.
             */
            fun privacyPolicyLink(privacyPolicyLink: String) =
                privacyPolicyLink(JsonField.of(privacyPolicyLink))

            /**
             * Sets [Builder.privacyPolicyLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.privacyPolicyLink] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun privacyPolicyLink(privacyPolicyLink: JsonField<String>) = apply {
                this.privacyPolicyLink = privacyPolicyLink
            }

            /**
             * Terms and conditions URL. TCR termsAndConditionsLink. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: String) =
                termsAndConditionsLink(JsonField.of(termsAndConditionsLink))

            /**
             * Sets [Builder.termsAndConditionsLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: JsonField<String>) = apply {
                this.termsAndConditionsLink = termsAndConditionsLink
            }

            /**
             * Use cases. What the campaign sends, and an example of each. One to five entries; how
             * they register is decided by volume, never declared. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun useCases(useCases: List<UseCase>) = useCases(JsonField.of(useCases))

            /**
             * Sets [Builder.useCases] to an arbitrary JSON value.
             *
             * You should usually call [Builder.useCases] with a well-typed `List<UseCase>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun useCases(useCases: JsonField<List<UseCase>>) = apply {
                this.useCases = useCases.map { it.toMutableList() }
            }

            /**
             * Adds a single [UseCase] to [useCases].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUseCase(useCase: UseCase) = apply {
                useCases =
                    (useCases ?: JsonField.of(mutableListOf())).also {
                        checkKnown("useCases", it).add(useCase)
                    }
            }

            /**
             * Expected monthly volume. Decides how the campaign registers and which fee tier
             * applies: below the low-volume threshold it registers as LOW_VOLUME with
             * sub-use-cases, above it as a single use case or MIXED. Omitting it registers the
             * campaign at the higher-fee standard tier.
             */
            fun volume(volume: String) = volume(JsonField.of(volume))

            /**
             * Sets [Builder.volume] to an arbitrary JSON value.
             *
             * You should usually call [Builder.volume] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun volume(volume: JsonField<String>) = apply { this.volume = volume }

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
             * Returns an immutable instance of [Campaign].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Campaign =
                Campaign(
                    description,
                    helpKeywords,
                    helpMessage,
                    inherit,
                    messageFlow,
                    optInKeywords,
                    optInMessage,
                    optOutKeywords,
                    optOutMessage,
                    privacyPolicyLink,
                    termsAndConditionsLink,
                    (useCases ?: JsonMissing.of()).map { it.toImmutable() },
                    volume,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Campaign = apply {
            if (validated) {
                return@apply
            }

            description()
            helpKeywords()
            helpMessage()
            inherit()
            messageFlow()
            optInKeywords()
            optInMessage()
            optOutKeywords()
            optOutMessage()
            privacyPolicyLink()
            termsAndConditionsLink()
            useCases().ifPresent { it.forEach { it.validate() } }
            volume()
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (helpKeywords.asKnown().isPresent) 1 else 0) +
                (if (helpMessage.asKnown().isPresent) 1 else 0) +
                (if (inherit.asKnown().isPresent) 1 else 0) +
                (if (messageFlow.asKnown().isPresent) 1 else 0) +
                (if (optInKeywords.asKnown().isPresent) 1 else 0) +
                (if (optInMessage.asKnown().isPresent) 1 else 0) +
                (if (optOutKeywords.asKnown().isPresent) 1 else 0) +
                (if (optOutMessage.asKnown().isPresent) 1 else 0) +
                (if (privacyPolicyLink.asKnown().isPresent) 1 else 0) +
                (if (termsAndConditionsLink.asKnown().isPresent) 1 else 0) +
                (useCases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (volume.asKnown().isPresent) 1 else 0)

        class UseCase
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val sampleMessages: JsonField<List<JsonValue>>,
            private val useCase: JsonField<InnerUseCase>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("sample_messages")
                @ExcludeMissing
                sampleMessages: JsonField<List<JsonValue>> = JsonMissing.of(),
                @JsonProperty("use_case")
                @ExcludeMissing
                useCase: JsonField<InnerUseCase> = JsonMissing.of(),
            ) : this(sampleMessages, useCase, mutableMapOf())

            /**
             * Sample messages. TCR sample1..sample5 for this use case. One to five, each carrying
             * the brand name and an opt-out instruction.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun sampleMessages(): List<JsonValue> = sampleMessages.getRequired("sample_messages")

            /**
             * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides
             * those.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun useCase(): InnerUseCase = useCase.getRequired("use_case")

            /**
             * Returns the raw JSON value of [sampleMessages].
             *
             * Unlike [sampleMessages], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sample_messages")
            @ExcludeMissing
            fun _sampleMessages(): JsonField<List<JsonValue>> = sampleMessages

            /**
             * Returns the raw JSON value of [useCase].
             *
             * Unlike [useCase], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("use_case")
            @ExcludeMissing
            fun _useCase(): JsonField<InnerUseCase> = useCase

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
                 * Returns a mutable builder for constructing an instance of [UseCase].
                 *
                 * The following fields are required:
                 * ```java
                 * .sampleMessages()
                 * .useCase()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UseCase]. */
            class Builder internal constructor() {

                private var sampleMessages: JsonField<MutableList<JsonValue>>? = null
                private var useCase: JsonField<InnerUseCase>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(useCase: UseCase) = apply {
                    sampleMessages = useCase.sampleMessages.map { it.toMutableList() }
                    this.useCase = useCase.useCase
                    additionalProperties = useCase.additionalProperties.toMutableMap()
                }

                /**
                 * Sample messages. TCR sample1..sample5 for this use case. One to five, each
                 * carrying the brand name and an opt-out instruction.
                 */
                fun sampleMessages(sampleMessages: List<JsonValue>) =
                    sampleMessages(JsonField.of(sampleMessages))

                /**
                 * Sets [Builder.sampleMessages] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sampleMessages] with a well-typed
                 * `List<JsonValue>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun sampleMessages(sampleMessages: JsonField<List<JsonValue>>) = apply {
                    this.sampleMessages = sampleMessages.map { it.toMutableList() }
                }

                /**
                 * Adds a single [JsonValue] to [sampleMessages].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSampleMessage(sampleMessage: JsonValue) = apply {
                    sampleMessages =
                        (sampleMessages ?: JsonField.of(mutableListOf())).also {
                            checkKnown("sampleMessages", it).add(sampleMessage)
                        }
                }

                /**
                 * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume
                 * decides those.
                 */
                fun useCase(useCase: InnerUseCase) = useCase(JsonField.of(useCase))

                /**
                 * Sets [Builder.useCase] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.useCase] with a well-typed [InnerUseCase] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun useCase(useCase: JsonField<InnerUseCase>) = apply { this.useCase = useCase }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [UseCase].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .sampleMessages()
                 * .useCase()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UseCase =
                    UseCase(
                        checkRequired("sampleMessages", sampleMessages).map { it.toImmutable() },
                        checkRequired("useCase", useCase),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): UseCase = apply {
                if (validated) {
                    return@apply
                }

                sampleMessages()
                useCase().validate()
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
                (sampleMessages.asKnown().getOrNull()?.size ?: 0) +
                    (useCase.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides
             * those.
             */
            class InnerUseCase
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val MARKETING = of("MARKETING")

                    @JvmField val ACCOUNT_NOTIFICATION = of("ACCOUNT_NOTIFICATION")

                    @JvmField val CUSTOMER_CARE = of("CUSTOMER_CARE")

                    @JvmField val FRAUD_ALERT = of("FRAUD_ALERT")

                    @JvmField val _2_FA = of("2FA")

                    @JvmField val DELIVERY_NOTIFICATION = of("DELIVERY_NOTIFICATION")

                    @JvmField val SECURITY_ALERT = of("SECURITY_ALERT")

                    @JvmField val M2_M = of("M2M")

                    @JvmField val HIGHER_EDUCATION = of("HIGHER_EDUCATION")

                    @JvmField val POLLING_VOTING = of("POLLING_VOTING")

                    @JvmField val PUBLIC_SERVICE_ANNOUNCEMENT = of("PUBLIC_SERVICE_ANNOUNCEMENT")

                    @JvmStatic fun of(value: String) = InnerUseCase(JsonField.of(value))
                }

                /** An enum containing [InnerUseCase]'s known values. */
                enum class Known {
                    MARKETING,
                    ACCOUNT_NOTIFICATION,
                    CUSTOMER_CARE,
                    FRAUD_ALERT,
                    _2_FA,
                    DELIVERY_NOTIFICATION,
                    SECURITY_ALERT,
                    M2_M,
                    HIGHER_EDUCATION,
                    POLLING_VOTING,
                    PUBLIC_SERVICE_ANNOUNCEMENT,
                }

                /**
                 * An enum containing [InnerUseCase]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [InnerUseCase] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    MARKETING,
                    ACCOUNT_NOTIFICATION,
                    CUSTOMER_CARE,
                    FRAUD_ALERT,
                    _2_FA,
                    DELIVERY_NOTIFICATION,
                    SECURITY_ALERT,
                    M2_M,
                    HIGHER_EDUCATION,
                    POLLING_VOTING,
                    PUBLIC_SERVICE_ANNOUNCEMENT,
                    /**
                     * An enum member indicating that [InnerUseCase] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        MARKETING -> Value.MARKETING
                        ACCOUNT_NOTIFICATION -> Value.ACCOUNT_NOTIFICATION
                        CUSTOMER_CARE -> Value.CUSTOMER_CARE
                        FRAUD_ALERT -> Value.FRAUD_ALERT
                        _2_FA -> Value._2_FA
                        DELIVERY_NOTIFICATION -> Value.DELIVERY_NOTIFICATION
                        SECURITY_ALERT -> Value.SECURITY_ALERT
                        M2_M -> Value.M2_M
                        HIGHER_EDUCATION -> Value.HIGHER_EDUCATION
                        POLLING_VOTING -> Value.POLLING_VOTING
                        PUBLIC_SERVICE_ANNOUNCEMENT -> Value.PUBLIC_SERVICE_ANNOUNCEMENT
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SentInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        MARKETING -> Known.MARKETING
                        ACCOUNT_NOTIFICATION -> Known.ACCOUNT_NOTIFICATION
                        CUSTOMER_CARE -> Known.CUSTOMER_CARE
                        FRAUD_ALERT -> Known.FRAUD_ALERT
                        _2_FA -> Known._2_FA
                        DELIVERY_NOTIFICATION -> Known.DELIVERY_NOTIFICATION
                        SECURITY_ALERT -> Known.SECURITY_ALERT
                        M2_M -> Known.M2_M
                        HIGHER_EDUCATION -> Known.HIGHER_EDUCATION
                        POLLING_VOTING -> Known.POLLING_VOTING
                        PUBLIC_SERVICE_ANNOUNCEMENT -> Known.PUBLIC_SERVICE_ANNOUNCEMENT
                        else -> throw SentInvalidDataException("Unknown InnerUseCase: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SentInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        SentInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): InnerUseCase = apply {
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
                    } catch (e: SentInvalidDataException) {
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

                    return other is InnerUseCase && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UseCase &&
                    sampleMessages == other.sampleMessages &&
                    useCase == other.useCase &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(sampleMessages, useCase, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UseCase{sampleMessages=$sampleMessages, useCase=$useCase, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Campaign &&
                description == other.description &&
                helpKeywords == other.helpKeywords &&
                helpMessage == other.helpMessage &&
                inherit == other.inherit &&
                messageFlow == other.messageFlow &&
                optInKeywords == other.optInKeywords &&
                optInMessage == other.optInMessage &&
                optOutKeywords == other.optOutKeywords &&
                optOutMessage == other.optOutMessage &&
                privacyPolicyLink == other.privacyPolicyLink &&
                termsAndConditionsLink == other.termsAndConditionsLink &&
                useCases == other.useCases &&
                volume == other.volume &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                description,
                helpKeywords,
                helpMessage,
                inherit,
                messageFlow,
                optInKeywords,
                optInMessage,
                optOutKeywords,
                optOutMessage,
                privacyPolicyLink,
                termsAndConditionsLink,
                useCases,
                volume,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Campaign{description=$description, helpKeywords=$helpKeywords, helpMessage=$helpMessage, inherit=$inherit, messageFlow=$messageFlow, optInKeywords=$optInKeywords, optInMessage=$optInMessage, optOutKeywords=$optOutKeywords, optOutMessage=$optOutMessage, privacyPolicyLink=$privacyPolicyLink, termsAndConditionsLink=$termsAndConditionsLink, useCases=$useCases, volume=$volume, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MarketCompliance &&
            brand == other.brand &&
            campaign == other.campaign &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(brand, campaign, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MarketCompliance{brand=$brand, campaign=$campaign, additionalProperties=$additionalProperties}"
}
