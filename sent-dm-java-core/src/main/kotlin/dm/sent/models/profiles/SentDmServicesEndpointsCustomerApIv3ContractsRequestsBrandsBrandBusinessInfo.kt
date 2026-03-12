// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Business details and address for brand KYC */
class SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val city: JsonField<String>,
    private val country: JsonField<String>,
    private val countryOfRegistration: JsonField<String>,
    private val entityType: JsonField<EntityType>,
    private val legalName: JsonField<String>,
    private val postalCode: JsonField<String>,
    private val state: JsonField<String>,
    private val street: JsonField<String>,
    private val taxId: JsonField<String>,
    private val taxIdType: JsonField<String>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("countryOfRegistration")
        @ExcludeMissing
        countryOfRegistration: JsonField<String> = JsonMissing.of(),
        @JsonProperty("entityType")
        @ExcludeMissing
        entityType: JsonField<EntityType> = JsonMissing.of(),
        @JsonProperty("legalName") @ExcludeMissing legalName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("postalCode")
        @ExcludeMissing
        postalCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
        @JsonProperty("street") @ExcludeMissing street: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taxId") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taxIdType") @ExcludeMissing taxIdType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(
        city,
        country,
        countryOfRegistration,
        entityType,
        legalName,
        postalCode,
        state,
        street,
        taxId,
        taxIdType,
        url,
        mutableMapOf(),
    )

    /**
     * City
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun city(): Optional<String> = city.getOptional("city")

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
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun entityType(): Optional<EntityType> = entityType.getOptional("entityType")

    /**
     * Legal business name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun legalName(): Optional<String> = legalName.getOptional("legalName")

    /**
     * Postal/ZIP code
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun postalCode(): Optional<String> = postalCode.getOptional("postalCode")

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
     * Business website URL
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [city].
     *
     * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

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
     * Returns the raw JSON value of [entityType].
     *
     * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entityType")
    @ExcludeMissing
    fun _entityType(): JsonField<EntityType> = entityType

    /**
     * Returns the raw JSON value of [legalName].
     *
     * Unlike [legalName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("legalName") @ExcludeMissing fun _legalName(): JsonField<String> = legalName

    /**
     * Returns the raw JSON value of [postalCode].
     *
     * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("postalCode") @ExcludeMissing fun _postalCode(): JsonField<String> = postalCode

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

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
         * Returns a mutable builder for constructing an instance of
         * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo].
         */
        @JvmStatic fun builder() = Builder()
    }

    /**
     * A builder for [SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo].
     */
    class Builder internal constructor() {

        private var city: JsonField<String> = JsonMissing.of()
        private var country: JsonField<String> = JsonMissing.of()
        private var countryOfRegistration: JsonField<String> = JsonMissing.of()
        private var entityType: JsonField<EntityType> = JsonMissing.of()
        private var legalName: JsonField<String> = JsonMissing.of()
        private var postalCode: JsonField<String> = JsonMissing.of()
        private var state: JsonField<String> = JsonMissing.of()
        private var street: JsonField<String> = JsonMissing.of()
        private var taxId: JsonField<String> = JsonMissing.of()
        private var taxIdType: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo:
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
        ) = apply {
            city = sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.city
            country =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.country
            countryOfRegistration =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .countryOfRegistration
            entityType =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .entityType
            legalName =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .legalName
            postalCode =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .postalCode
            state =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.state
            street =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.street
            taxId =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.taxId
            taxIdType =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .taxIdType
            url = sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.url
            additionalProperties =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .additionalProperties
                    .toMutableMap()
        }

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

        /** Legal business name */
        fun legalName(legalName: String?) = legalName(JsonField.ofNullable(legalName))

        /** Alias for calling [Builder.legalName] with `legalName.orElse(null)`. */
        fun legalName(legalName: Optional<String>) = legalName(legalName.getOrNull())

        /**
         * Sets [Builder.legalName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.legalName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun legalName(legalName: JsonField<String>) = apply { this.legalName = legalName }

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

        /** Business website URL */
        fun url(url: String?) = url(JsonField.ofNullable(url))

        /** Alias for calling [Builder.url] with `url.orElse(null)`. */
        fun url(url: Optional<String>) = url(url.getOrNull())

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

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
         * Returns an immutable instance of
         * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo(
                city,
                country,
                countryOfRegistration,
                entityType,
                legalName,
                postalCode,
                state,
                street,
                taxId,
                taxIdType,
                url,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo =
        apply {
            if (validated) {
                return@apply
            }

            city()
            country()
            countryOfRegistration()
            entityType().ifPresent { it.validate() }
            legalName()
            postalCode()
            state()
            street()
            taxId()
            taxIdType()
            url()
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
        (if (city.asKnown().isPresent) 1 else 0) +
            (if (country.asKnown().isPresent) 1 else 0) +
            (if (countryOfRegistration.asKnown().isPresent) 1 else 0) +
            (entityType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (legalName.asKnown().isPresent) 1 else 0) +
            (if (postalCode.asKnown().isPresent) 1 else 0) +
            (if (state.asKnown().isPresent) 1 else 0) +
            (if (street.asKnown().isPresent) 1 else 0) +
            (if (taxId.asKnown().isPresent) 1 else 0) +
            (if (taxIdType.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

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

        return other is
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo &&
            city == other.city &&
            country == other.country &&
            countryOfRegistration == other.countryOfRegistration &&
            entityType == other.entityType &&
            legalName == other.legalName &&
            postalCode == other.postalCode &&
            state == other.state &&
            street == other.street &&
            taxId == other.taxId &&
            taxIdType == other.taxIdType &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            city,
            country,
            countryOfRegistration,
            entityType,
            legalName,
            postalCode,
            state,
            street,
            taxId,
            taxIdType,
            url,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo{city=$city, country=$country, countryOfRegistration=$countryOfRegistration, entityType=$entityType, legalName=$legalName, postalCode=$postalCode, state=$state, street=$street, taxId=$taxId, taxIdType=$taxIdType, url=$url, additionalProperties=$additionalProperties}"
}
