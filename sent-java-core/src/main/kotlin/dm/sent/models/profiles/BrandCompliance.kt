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
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BrandCompliance
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val brandRelationship: JsonField<TcrBrandRelationship>,
    private val destinationCountries: JsonField<List<DestinationCountry>>,
    private val isTcrApplication: JsonField<Boolean>,
    private val notes: JsonField<String>,
    private val phoneNumberPrefix: JsonField<String>,
    private val primaryUseCase: JsonField<String>,
    private val vertical: JsonField<TcrVertical>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("brand_relationship")
        @ExcludeMissing
        brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of(),
        @JsonProperty("destination_countries")
        @ExcludeMissing
        destinationCountries: JsonField<List<DestinationCountry>> = JsonMissing.of(),
        @JsonProperty("is_tcr_application")
        @ExcludeMissing
        isTcrApplication: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_number_prefix")
        @ExcludeMissing
        phoneNumberPrefix: JsonField<String> = JsonMissing.of(),
        @JsonProperty("primary_use_case")
        @ExcludeMissing
        primaryUseCase: JsonField<String> = JsonMissing.of(),
        @JsonProperty("vertical")
        @ExcludeMissing
        vertical: JsonField<TcrVertical> = JsonMissing.of(),
    ) : this(
        brandRelationship,
        destinationCountries,
        isTcrApplication,
        notes,
        phoneNumberPrefix,
        primaryUseCase,
        vertical,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandRelationship(): Optional<TcrBrandRelationship> =
        brandRelationship.getOptional("brand_relationship")

    /**
     * List of destination countries for messaging
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun destinationCountries(): Optional<List<DestinationCountry>> =
        destinationCountries.getOptional("destination_countries")

    /**
     * Whether this is a TCR (Campaign Registry) application
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun isTcrApplication(): Optional<Boolean> = isTcrApplication.getOptional("is_tcr_application")

    /**
     * Additional notes about the business or use case
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun notes(): Optional<String> = notes.getOptional("notes")

    /**
     * Phone number prefix for messaging (e.g., "+1")
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneNumberPrefix(): Optional<String> = phoneNumberPrefix.getOptional("phone_number_prefix")

    /**
     * Always null. The brand's free-text primary use case is no longer stored: it reached neither
     * TCR nor any decision, and its column is dropped with no backfill, because the values were
     * prose and the typed equivalent is the campaign's MessagingUseCaseUS.
     *
     * Retained so existing v3 clients reading primary_use_case keep deserializing. Unlike the
     * profile sharing flags, which can answer false truthfully, there is no value to report here —
     * the field is present and empty rather than present and wrong.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    @Deprecated("deprecated")
    fun primaryUseCase(): Optional<String> = primaryUseCase.getOptional("primary_use_case")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun vertical(): Optional<TcrVertical> = vertical.getOptional("vertical")

    /**
     * Returns the raw JSON value of [brandRelationship].
     *
     * Unlike [brandRelationship], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("brand_relationship")
    @ExcludeMissing
    fun _brandRelationship(): JsonField<TcrBrandRelationship> = brandRelationship

    /**
     * Returns the raw JSON value of [destinationCountries].
     *
     * Unlike [destinationCountries], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("destination_countries")
    @ExcludeMissing
    fun _destinationCountries(): JsonField<List<DestinationCountry>> = destinationCountries

    /**
     * Returns the raw JSON value of [isTcrApplication].
     *
     * Unlike [isTcrApplication], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("is_tcr_application")
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
    @JsonProperty("phone_number_prefix")
    @ExcludeMissing
    fun _phoneNumberPrefix(): JsonField<String> = phoneNumberPrefix

    /**
     * Returns the raw JSON value of [primaryUseCase].
     *
     * Unlike [primaryUseCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated")
    @JsonProperty("primary_use_case")
    @ExcludeMissing
    fun _primaryUseCase(): JsonField<String> = primaryUseCase

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

        /** Returns a mutable builder for constructing an instance of [BrandCompliance]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandCompliance]. */
    class Builder internal constructor() {

        private var brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of()
        private var destinationCountries: JsonField<MutableList<DestinationCountry>>? = null
        private var isTcrApplication: JsonField<Boolean> = JsonMissing.of()
        private var notes: JsonField<String> = JsonMissing.of()
        private var phoneNumberPrefix: JsonField<String> = JsonMissing.of()
        private var primaryUseCase: JsonField<String> = JsonMissing.of()
        private var vertical: JsonField<TcrVertical> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandCompliance: BrandCompliance) = apply {
            brandRelationship = brandCompliance.brandRelationship
            destinationCountries = brandCompliance.destinationCountries.map { it.toMutableList() }
            isTcrApplication = brandCompliance.isTcrApplication
            notes = brandCompliance.notes
            phoneNumberPrefix = brandCompliance.phoneNumberPrefix
            primaryUseCase = brandCompliance.primaryUseCase
            vertical = brandCompliance.vertical
            additionalProperties = brandCompliance.additionalProperties.toMutableMap()
        }

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

        /** Whether this is a TCR (Campaign Registry) application */
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

        /**
         * Always null. The brand's free-text primary use case is no longer stored: it reached
         * neither TCR nor any decision, and its column is dropped with no backfill, because the
         * values were prose and the typed equivalent is the campaign's MessagingUseCaseUS.
         *
         * Retained so existing v3 clients reading primary_use_case keep deserializing. Unlike the
         * profile sharing flags, which can answer false truthfully, there is no value to report
         * here — the field is present and empty rather than present and wrong.
         */
        @Deprecated("deprecated")
        fun primaryUseCase(primaryUseCase: String?) =
            primaryUseCase(JsonField.ofNullable(primaryUseCase))

        /** Alias for calling [Builder.primaryUseCase] with `primaryUseCase.orElse(null)`. */
        @Deprecated("deprecated")
        fun primaryUseCase(primaryUseCase: Optional<String>) =
            primaryUseCase(primaryUseCase.getOrNull())

        /**
         * Sets [Builder.primaryUseCase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.primaryUseCase] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        @Deprecated("deprecated")
        fun primaryUseCase(primaryUseCase: JsonField<String>) = apply {
            this.primaryUseCase = primaryUseCase
        }

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
         * Returns an immutable instance of [BrandCompliance].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BrandCompliance =
            BrandCompliance(
                brandRelationship,
                (destinationCountries ?: JsonMissing.of()).map { it.toImmutable() },
                isTcrApplication,
                notes,
                phoneNumberPrefix,
                primaryUseCase,
                vertical,
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
    fun validate(): BrandCompliance = apply {
        if (validated) {
            return@apply
        }

        brandRelationship().ifPresent { it.validate() }
        destinationCountries().ifPresent { it.forEach { it.validate() } }
        isTcrApplication()
        notes()
        phoneNumberPrefix()
        primaryUseCase()
        vertical().ifPresent { it.validate() }
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
        (brandRelationship.asKnown().getOrNull()?.validity() ?: 0) +
            (destinationCountries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (isTcrApplication.asKnown().isPresent) 1 else 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (if (phoneNumberPrefix.asKnown().isPresent) 1 else 0) +
            (if (primaryUseCase.asKnown().isPresent) 1 else 0) +
            (vertical.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandCompliance &&
            brandRelationship == other.brandRelationship &&
            destinationCountries == other.destinationCountries &&
            isTcrApplication == other.isTcrApplication &&
            notes == other.notes &&
            phoneNumberPrefix == other.phoneNumberPrefix &&
            primaryUseCase == other.primaryUseCase &&
            vertical == other.vertical &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            brandRelationship,
            destinationCountries,
            isTcrApplication,
            notes,
            phoneNumberPrefix,
            primaryUseCase,
            vertical,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandCompliance{brandRelationship=$brandRelationship, destinationCountries=$destinationCountries, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, primaryUseCase=$primaryUseCase, vertical=$vertical, additionalProperties=$additionalProperties}"
}
