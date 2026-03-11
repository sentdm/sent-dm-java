// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

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
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Compliance and TCR information for brand registration */
class SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val brandRelationship: JsonField<TcrBrandRelationship>,
    private val vertical: JsonField<TcrVertical>,
    private val destinationCountries: JsonField<List<DestinationCountry>>,
    private val expectedMessagingVolume: JsonField<String>,
    private val isTcrApplication: JsonField<Boolean>,
    private val notes: JsonField<String>,
    private val phoneNumberPrefix: JsonField<String>,
    private val primaryUseCase: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("brandRelationship")
        @ExcludeMissing
        brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of(),
        @JsonProperty("vertical")
        @ExcludeMissing
        vertical: JsonField<TcrVertical> = JsonMissing.of(),
        @JsonProperty("destinationCountries")
        @ExcludeMissing
        destinationCountries: JsonField<List<DestinationCountry>> = JsonMissing.of(),
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
        @JsonProperty("primaryUseCase")
        @ExcludeMissing
        primaryUseCase: JsonField<String> = JsonMissing.of(),
    ) : this(
        brandRelationship,
        vertical,
        destinationCountries,
        expectedMessagingVolume,
        isTcrApplication,
        notes,
        phoneNumberPrefix,
        primaryUseCase,
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
     * Business vertical/industry category (required for TCR)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vertical(): TcrVertical = vertical.getRequired("vertical")

    /**
     * List of destination countries for messaging
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun destinationCountries(): Optional<List<DestinationCountry>> =
        destinationCountries.getOptional("destinationCountries")

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
     * Primary messaging use case description
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun primaryUseCase(): Optional<String> = primaryUseCase.getOptional("primaryUseCase")

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
     * Returns the raw JSON value of [vertical].
     *
     * Unlike [vertical], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vertical") @ExcludeMissing fun _vertical(): JsonField<TcrVertical> = vertical

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
     * Returns the raw JSON value of [primaryUseCase].
     *
     * Unlike [primaryUseCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("primaryUseCase")
    @ExcludeMissing
    fun _primaryUseCase(): JsonField<String> = primaryUseCase

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
         * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo].
         *
         * The following fields are required:
         * ```java
         * .brandRelationship()
         * .vertical()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /**
     * A builder for
     * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo].
     */
    class Builder internal constructor() {

        private var brandRelationship: JsonField<TcrBrandRelationship>? = null
        private var vertical: JsonField<TcrVertical>? = null
        private var destinationCountries: JsonField<MutableList<DestinationCountry>>? = null
        private var expectedMessagingVolume: JsonField<String> = JsonMissing.of()
        private var isTcrApplication: JsonField<Boolean> = JsonMissing.of()
        private var notes: JsonField<String> = JsonMissing.of()
        private var phoneNumberPrefix: JsonField<String> = JsonMissing.of()
        private var primaryUseCase: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo:
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
        ) = apply {
            brandRelationship =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .brandRelationship
            vertical =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .vertical
            destinationCountries =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .destinationCountries
                    .map { it.toMutableList() }
            expectedMessagingVolume =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .expectedMessagingVolume
            isTcrApplication =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .isTcrApplication
            notes =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo.notes
            phoneNumberPrefix =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .phoneNumberPrefix
            primaryUseCase =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .primaryUseCase
            additionalProperties =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .additionalProperties
                    .toMutableMap()
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
         * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .brandRelationship()
         * .vertical()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build():
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo(
                checkRequired("brandRelationship", brandRelationship),
                checkRequired("vertical", vertical),
                (destinationCountries ?: JsonMissing.of()).map { it.toImmutable() },
                expectedMessagingVolume,
                isTcrApplication,
                notes,
                phoneNumberPrefix,
                primaryUseCase,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo =
        apply {
            if (validated) {
                return@apply
            }

            brandRelationship().validate()
            vertical().validate()
            destinationCountries().ifPresent { it.forEach { it.validate() } }
            expectedMessagingVolume()
            isTcrApplication()
            notes()
            phoneNumberPrefix()
            primaryUseCase()
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
            (vertical.asKnown().getOrNull()?.validity() ?: 0) +
            (destinationCountries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (expectedMessagingVolume.asKnown().isPresent) 1 else 0) +
            (if (isTcrApplication.asKnown().isPresent) 1 else 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (if (phoneNumberPrefix.asKnown().isPresent) 1 else 0) +
            (if (primaryUseCase.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo &&
            brandRelationship == other.brandRelationship &&
            vertical == other.vertical &&
            destinationCountries == other.destinationCountries &&
            expectedMessagingVolume == other.expectedMessagingVolume &&
            isTcrApplication == other.isTcrApplication &&
            notes == other.notes &&
            phoneNumberPrefix == other.phoneNumberPrefix &&
            primaryUseCase == other.primaryUseCase &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            brandRelationship,
            vertical,
            destinationCountries,
            expectedMessagingVolume,
            isTcrApplication,
            notes,
            phoneNumberPrefix,
            primaryUseCase,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo{brandRelationship=$brandRelationship, vertical=$vertical, destinationCountries=$destinationCountries, expectedMessagingVolume=$expectedMessagingVolume, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, primaryUseCase=$primaryUseCase, additionalProperties=$additionalProperties}"
}
