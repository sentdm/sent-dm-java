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
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Brand and KYC data grouped into contact, business, and compliance sections */
class BrandsBrandData
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val compliance: JsonField<Compliance>,
    private val contact: JsonField<Contact>,
    private val business: JsonField<Business>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("compliance")
        @ExcludeMissing
        compliance: JsonField<Compliance> = JsonMissing.of(),
        @JsonProperty("contact") @ExcludeMissing contact: JsonField<Contact> = JsonMissing.of(),
        @JsonProperty("business") @ExcludeMissing business: JsonField<Business> = JsonMissing.of(),
    ) : this(compliance, contact, business, mutableMapOf())

    /**
     * Compliance and TCR-related information
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun compliance(): Compliance = compliance.getRequired("compliance")

    /**
     * Contact information for the brand
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contact(): Contact = contact.getRequired("contact")

    /**
     * Business details and address information
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun business(): Optional<Business> = business.getOptional("business")

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compliance")
    @ExcludeMissing
    fun _compliance(): JsonField<Compliance> = compliance

    /**
     * Returns the raw JSON value of [contact].
     *
     * Unlike [contact], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact") @ExcludeMissing fun _contact(): JsonField<Contact> = contact

    /**
     * Returns the raw JSON value of [business].
     *
     * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("business") @ExcludeMissing fun _business(): JsonField<Business> = business

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
         * Returns a mutable builder for constructing an instance of [BrandsBrandData].
         *
         * The following fields are required:
         * ```java
         * .compliance()
         * .contact()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandsBrandData]. */
    class Builder internal constructor() {

        private var compliance: JsonField<Compliance>? = null
        private var contact: JsonField<Contact>? = null
        private var business: JsonField<Business> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandsBrandData: BrandsBrandData) = apply {
            compliance = brandsBrandData.compliance
            contact = brandsBrandData.contact
            business = brandsBrandData.business
            additionalProperties = brandsBrandData.additionalProperties.toMutableMap()
        }

        /** Compliance and TCR-related information */
        fun compliance(compliance: Compliance) = compliance(JsonField.of(compliance))

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [Compliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<Compliance>) = apply { this.compliance = compliance }

        /** Contact information for the brand */
        fun contact(contact: Contact) = contact(JsonField.of(contact))

        /**
         * Sets [Builder.contact] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contact] with a well-typed [Contact] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun contact(contact: JsonField<Contact>) = apply { this.contact = contact }

        /** Business details and address information */
        fun business(business: Business?) = business(JsonField.ofNullable(business))

        /** Alias for calling [Builder.business] with `business.orElse(null)`. */
        fun business(business: Optional<Business>) = business(business.getOrNull())

        /**
         * Sets [Builder.business] to an arbitrary JSON value.
         *
         * You should usually call [Builder.business] with a well-typed [Business] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun business(business: JsonField<Business>) = apply { this.business = business }

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
         * Returns an immutable instance of [BrandsBrandData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .compliance()
         * .contact()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BrandsBrandData =
            BrandsBrandData(
                checkRequired("compliance", compliance),
                checkRequired("contact", contact),
                business,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BrandsBrandData = apply {
        if (validated) {
            return@apply
        }

        compliance().validate()
        contact().validate()
        business().ifPresent { it.validate() }
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
        (compliance.asKnown().getOrNull()?.validity() ?: 0) +
            (contact.asKnown().getOrNull()?.validity() ?: 0) +
            (business.asKnown().getOrNull()?.validity() ?: 0)

    /** Compliance and TCR-related information */
    class Compliance
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
        fun phoneNumberPrefix(): Optional<String> =
            phoneNumberPrefix.getOptional("phoneNumberPrefix")

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
         * Unlike [destinationCountries], this method doesn't throw if the JSON field has an
         * unexpected type.
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
         * Unlike [primaryUseCase], this method doesn't throw if the JSON field has an unexpected
         * type.
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
             * Returns a mutable builder for constructing an instance of [Compliance].
             *
             * The following fields are required:
             * ```java
             * .brandRelationship()
             * .vertical()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Compliance]. */
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
            internal fun from(compliance: Compliance) = apply {
                brandRelationship = compliance.brandRelationship
                vertical = compliance.vertical
                destinationCountries = compliance.destinationCountries.map { it.toMutableList() }
                expectedMessagingVolume = compliance.expectedMessagingVolume
                isTcrApplication = compliance.isTcrApplication
                notes = compliance.notes
                phoneNumberPrefix = compliance.phoneNumberPrefix
                primaryUseCase = compliance.primaryUseCase
                additionalProperties = compliance.additionalProperties.toMutableMap()
            }

            /** Brand relationship level with TCR (required for TCR) */
            fun brandRelationship(brandRelationship: TcrBrandRelationship) =
                brandRelationship(JsonField.of(brandRelationship))

            /**
             * Sets [Builder.brandRelationship] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandRelationship] with a well-typed
             * [TcrBrandRelationship] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun brandRelationship(brandRelationship: JsonField<TcrBrandRelationship>) = apply {
                this.brandRelationship = brandRelationship
            }

            /** Business vertical/industry category (required for TCR) */
            fun vertical(vertical: TcrVertical) = vertical(JsonField.of(vertical))

            /**
             * Sets [Builder.vertical] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vertical] with a well-typed [TcrVertical] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * `List<DestinationCountry>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            /**
             * Alias for calling [Builder.isTcrApplication] with `isTcrApplication.orElse(null)`.
             */
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
             * You should usually call [Builder.notes] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun notes(notes: JsonField<String>) = apply { this.notes = notes }

            /** Phone number prefix for messaging (e.g., "+1") */
            fun phoneNumberPrefix(phoneNumberPrefix: String?) =
                phoneNumberPrefix(JsonField.ofNullable(phoneNumberPrefix))

            /**
             * Alias for calling [Builder.phoneNumberPrefix] with `phoneNumberPrefix.orElse(null)`.
             */
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
             * Returns an immutable instance of [Compliance].
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
            fun build(): Compliance =
                Compliance(
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

        fun validate(): Compliance = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

            return other is Compliance &&
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
            "Compliance{brandRelationship=$brandRelationship, vertical=$vertical, destinationCountries=$destinationCountries, expectedMessagingVolume=$expectedMessagingVolume, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, primaryUseCase=$primaryUseCase, additionalProperties=$additionalProperties}"
    }

    /** Contact information for the brand */
    class Contact
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val businessName: JsonField<String>,
        private val email: JsonField<String>,
        private val phone: JsonField<String>,
        private val phoneCountryCode: JsonField<String>,
        private val role: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("businessName")
            @ExcludeMissing
            businessName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phoneCountryCode")
            @ExcludeMissing
            phoneCountryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
        ) : this(name, businessName, email, phone, phoneCountryCode, role, mutableMapOf())

        /**
         * Primary contact name (required)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Business/brand name
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun businessName(): Optional<String> = businessName.getOptional("businessName")

        /**
         * Contact email address
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * Contact phone number in E.164 format
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phone(): Optional<String> = phone.getOptional("phone")

        /**
         * Contact phone country code (e.g., "1" for US)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phoneCountryCode(): Optional<String> = phoneCountryCode.getOptional("phoneCountryCode")

        /**
         * Contact's role in the business
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun role(): Optional<String> = role.getOptional("role")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [businessName].
         *
         * Unlike [businessName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("businessName")
        @ExcludeMissing
        fun _businessName(): JsonField<String> = businessName

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [phone].
         *
         * Unlike [phone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

        /**
         * Returns the raw JSON value of [phoneCountryCode].
         *
         * Unlike [phoneCountryCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("phoneCountryCode")
        @ExcludeMissing
        fun _phoneCountryCode(): JsonField<String> = phoneCountryCode

        /**
         * Returns the raw JSON value of [role].
         *
         * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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
             * Returns a mutable builder for constructing an instance of [Contact].
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Contact]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var businessName: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var phone: JsonField<String> = JsonMissing.of()
            private var phoneCountryCode: JsonField<String> = JsonMissing.of()
            private var role: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(contact: Contact) = apply {
                name = contact.name
                businessName = contact.businessName
                email = contact.email
                phone = contact.phone
                phoneCountryCode = contact.phoneCountryCode
                role = contact.role
                additionalProperties = contact.additionalProperties.toMutableMap()
            }

            /** Primary contact name (required) */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Business/brand name */
            fun businessName(businessName: String?) =
                businessName(JsonField.ofNullable(businessName))

            /** Alias for calling [Builder.businessName] with `businessName.orElse(null)`. */
            fun businessName(businessName: Optional<String>) =
                businessName(businessName.getOrNull())

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

            /** Contact email address */
            fun email(email: String?) = email(JsonField.ofNullable(email))

            /** Alias for calling [Builder.email] with `email.orElse(null)`. */
            fun email(email: Optional<String>) = email(email.getOrNull())

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            /** Contact phone number in E.164 format */
            fun phone(phone: String?) = phone(JsonField.ofNullable(phone))

            /** Alias for calling [Builder.phone] with `phone.orElse(null)`. */
            fun phone(phone: Optional<String>) = phone(phone.getOrNull())

            /**
             * Sets [Builder.phone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phone] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phone(phone: JsonField<String>) = apply { this.phone = phone }

            /** Contact phone country code (e.g., "1" for US) */
            fun phoneCountryCode(phoneCountryCode: String?) =
                phoneCountryCode(JsonField.ofNullable(phoneCountryCode))

            /**
             * Alias for calling [Builder.phoneCountryCode] with `phoneCountryCode.orElse(null)`.
             */
            fun phoneCountryCode(phoneCountryCode: Optional<String>) =
                phoneCountryCode(phoneCountryCode.getOrNull())

            /**
             * Sets [Builder.phoneCountryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phoneCountryCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phoneCountryCode(phoneCountryCode: JsonField<String>) = apply {
                this.phoneCountryCode = phoneCountryCode
            }

            /** Contact's role in the business */
            fun role(role: String?) = role(JsonField.ofNullable(role))

            /** Alias for calling [Builder.role] with `role.orElse(null)`. */
            fun role(role: Optional<String>) = role(role.getOrNull())

            /**
             * Sets [Builder.role] to an arbitrary JSON value.
             *
             * You should usually call [Builder.role] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun role(role: JsonField<String>) = apply { this.role = role }

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
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Contact =
                Contact(
                    checkRequired("name", name),
                    businessName,
                    email,
                    phone,
                    phoneCountryCode,
                    role,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Contact = apply {
            if (validated) {
                return@apply
            }

            name()
            businessName()
            email()
            phone()
            phoneCountryCode()
            role()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (businessName.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (phone.asKnown().isPresent) 1 else 0) +
                (if (phoneCountryCode.asKnown().isPresent) 1 else 0) +
                (if (role.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Contact &&
                name == other.name &&
                businessName == other.businessName &&
                email == other.email &&
                phone == other.phone &&
                phoneCountryCode == other.phoneCountryCode &&
                role == other.role &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                name,
                businessName,
                email,
                phone,
                phoneCountryCode,
                role,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Contact{name=$name, businessName=$businessName, email=$email, phone=$phone, phoneCountryCode=$phoneCountryCode, role=$role, additionalProperties=$additionalProperties}"
    }

    /** Business details and address information */
    class Business
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
            @JsonProperty("legalName")
            @ExcludeMissing
            legalName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("postalCode")
            @ExcludeMissing
            postalCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("street") @ExcludeMissing street: JsonField<String> = JsonMissing.of(),
            @JsonProperty("taxId") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("taxIdType")
            @ExcludeMissing
            taxIdType: JsonField<String> = JsonMissing.of(),
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
         * Business entity type
         *
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
         * Unlike [countryOfRegistration], this method doesn't throw if the JSON field has an
         * unexpected type.
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
        @JsonProperty("postalCode")
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

            /** Returns a mutable builder for constructing an instance of [Business]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Business]. */
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
            internal fun from(business: Business) = apply {
                city = business.city
                country = business.country
                countryOfRegistration = business.countryOfRegistration
                entityType = business.entityType
                legalName = business.legalName
                postalCode = business.postalCode
                state = business.state
                street = business.street
                taxId = business.taxId
                taxIdType = business.taxIdType
                url = business.url
                additionalProperties = business.additionalProperties.toMutableMap()
            }

            /** City */
            fun city(city: String?) = city(JsonField.ofNullable(city))

            /** Alias for calling [Builder.city] with `city.orElse(null)`. */
            fun city(city: Optional<String>) = city(city.getOrNull())

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            /** Country code (e.g., US, CA) */
            fun country(country: String?) = country(JsonField.ofNullable(country))

            /** Alias for calling [Builder.country] with `country.orElse(null)`. */
            fun country(country: Optional<String>) = country(country.getOrNull())

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.countryOfRegistration] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun countryOfRegistration(countryOfRegistration: JsonField<String>) = apply {
                this.countryOfRegistration = countryOfRegistration
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
            fun entityType(entityType: JsonField<EntityType>) = apply {
                this.entityType = entityType
            }

            /** Legal business name */
            fun legalName(legalName: String?) = legalName(JsonField.ofNullable(legalName))

            /** Alias for calling [Builder.legalName] with `legalName.orElse(null)`. */
            fun legalName(legalName: Optional<String>) = legalName(legalName.getOrNull())

            /**
             * Sets [Builder.legalName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.legalName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun legalName(legalName: JsonField<String>) = apply { this.legalName = legalName }

            /** Postal/ZIP code */
            fun postalCode(postalCode: String?) = postalCode(JsonField.ofNullable(postalCode))

            /** Alias for calling [Builder.postalCode] with `postalCode.orElse(null)`. */
            fun postalCode(postalCode: Optional<String>) = postalCode(postalCode.getOrNull())

            /**
             * Sets [Builder.postalCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.postalCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

            /** State/province code */
            fun state(state: String?) = state(JsonField.ofNullable(state))

            /** Alias for calling [Builder.state] with `state.orElse(null)`. */
            fun state(state: Optional<String>) = state(state.getOrNull())

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            /** Street address */
            fun street(street: String?) = street(JsonField.ofNullable(street))

            /** Alias for calling [Builder.street] with `street.orElse(null)`. */
            fun street(street: Optional<String>) = street(street.getOrNull())

            /**
             * Sets [Builder.street] to an arbitrary JSON value.
             *
             * You should usually call [Builder.street] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun street(street: JsonField<String>) = apply { this.street = street }

            /** Tax ID/EIN number */
            fun taxId(taxId: String?) = taxId(JsonField.ofNullable(taxId))

            /** Alias for calling [Builder.taxId] with `taxId.orElse(null)`. */
            fun taxId(taxId: Optional<String>) = taxId(taxId.getOrNull())

            /**
             * Sets [Builder.taxId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taxId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Business].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Business =
                Business(
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

        fun validate(): Business = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

        /** Business entity type */
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentDmInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentDmInvalidDataException("Value is not a String")
                }

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

            return other is Business &&
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
            "Business{city=$city, country=$country, countryOfRegistration=$countryOfRegistration, entityType=$entityType, legalName=$legalName, postalCode=$postalCode, state=$state, street=$street, taxId=$taxId, taxIdType=$taxIdType, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandsBrandData &&
            compliance == other.compliance &&
            contact == other.contact &&
            business == other.business &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(compliance, contact, business, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandsBrandData{compliance=$compliance, contact=$contact, business=$business, additionalProperties=$additionalProperties}"
}
