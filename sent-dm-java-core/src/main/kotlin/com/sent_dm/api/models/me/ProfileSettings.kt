// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.me

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
import kotlin.jvm.optionals.getOrNull

/** Profile configuration settings */
class ProfileSettings
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowContactSharing: JsonField<Boolean>,
    private val allowTemplateSharing: JsonField<Boolean>,
    private val billingModel: JsonField<String>,
    private val inheritContacts: JsonField<Boolean>,
    private val inheritTcrBrand: JsonField<Boolean>,
    private val inheritTcrCampaign: JsonField<Boolean>,
    private val inheritTemplates: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allow_contact_sharing")
        @ExcludeMissing
        allowContactSharing: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("allow_template_sharing")
        @ExcludeMissing
        allowTemplateSharing: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("billing_model")
        @ExcludeMissing
        billingModel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inherit_contacts")
        @ExcludeMissing
        inheritContacts: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inherit_tcr_brand")
        @ExcludeMissing
        inheritTcrBrand: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inherit_tcr_campaign")
        @ExcludeMissing
        inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inherit_templates")
        @ExcludeMissing
        inheritTemplates: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        allowContactSharing,
        allowTemplateSharing,
        billingModel,
        inheritContacts,
        inheritTcrBrand,
        inheritTcrCampaign,
        inheritTemplates,
        mutableMapOf(),
    )

    /**
     * Whether contacts are shared across profiles in the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowContactSharing(): Optional<Boolean> =
        allowContactSharing.getOptional("allow_contact_sharing")

    /**
     * Whether templates are shared across profiles in the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowTemplateSharing(): Optional<Boolean> =
        allowTemplateSharing.getOptional("allow_template_sharing")

    /**
     * Billing model: profile, organization, or profile_and_organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun billingModel(): Optional<String> = billingModel.getOptional("billing_model")

    /**
     * Whether this profile inherits contacts from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritContacts(): Optional<Boolean> = inheritContacts.getOptional("inherit_contacts")

    /**
     * Whether this profile inherits TCR brand from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrBrand(): Optional<Boolean> = inheritTcrBrand.getOptional("inherit_tcr_brand")

    /**
     * Whether this profile inherits TCR campaign from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrCampaign(): Optional<Boolean> =
        inheritTcrCampaign.getOptional("inherit_tcr_campaign")

    /**
     * Whether this profile inherits templates from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTemplates(): Optional<Boolean> = inheritTemplates.getOptional("inherit_templates")

    /**
     * Returns the raw JSON value of [allowContactSharing].
     *
     * Unlike [allowContactSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allow_contact_sharing")
    @ExcludeMissing
    fun _allowContactSharing(): JsonField<Boolean> = allowContactSharing

    /**
     * Returns the raw JSON value of [allowTemplateSharing].
     *
     * Unlike [allowTemplateSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allow_template_sharing")
    @ExcludeMissing
    fun _allowTemplateSharing(): JsonField<Boolean> = allowTemplateSharing

    /**
     * Returns the raw JSON value of [billingModel].
     *
     * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing_model")
    @ExcludeMissing
    fun _billingModel(): JsonField<String> = billingModel

    /**
     * Returns the raw JSON value of [inheritContacts].
     *
     * Unlike [inheritContacts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inherit_contacts")
    @ExcludeMissing
    fun _inheritContacts(): JsonField<Boolean> = inheritContacts

    /**
     * Returns the raw JSON value of [inheritTcrBrand].
     *
     * Unlike [inheritTcrBrand], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inherit_tcr_brand")
    @ExcludeMissing
    fun _inheritTcrBrand(): JsonField<Boolean> = inheritTcrBrand

    /**
     * Returns the raw JSON value of [inheritTcrCampaign].
     *
     * Unlike [inheritTcrCampaign], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("inherit_tcr_campaign")
    @ExcludeMissing
    fun _inheritTcrCampaign(): JsonField<Boolean> = inheritTcrCampaign

    /**
     * Returns the raw JSON value of [inheritTemplates].
     *
     * Unlike [inheritTemplates], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("inherit_templates")
    @ExcludeMissing
    fun _inheritTemplates(): JsonField<Boolean> = inheritTemplates

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

        /** Returns a mutable builder for constructing an instance of [ProfileSettings]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProfileSettings]. */
    class Builder internal constructor() {

        private var allowContactSharing: JsonField<Boolean> = JsonMissing.of()
        private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
        private var billingModel: JsonField<String> = JsonMissing.of()
        private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
        private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
        private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
        private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(profileSettings: ProfileSettings) = apply {
            allowContactSharing = profileSettings.allowContactSharing
            allowTemplateSharing = profileSettings.allowTemplateSharing
            billingModel = profileSettings.billingModel
            inheritContacts = profileSettings.inheritContacts
            inheritTcrBrand = profileSettings.inheritTcrBrand
            inheritTcrCampaign = profileSettings.inheritTcrCampaign
            inheritTemplates = profileSettings.inheritTemplates
            additionalProperties = profileSettings.additionalProperties.toMutableMap()
        }

        /** Whether contacts are shared across profiles in the organization */
        fun allowContactSharing(allowContactSharing: Boolean?) =
            allowContactSharing(JsonField.ofNullable(allowContactSharing))

        /**
         * Alias for [Builder.allowContactSharing].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun allowContactSharing(allowContactSharing: Boolean) =
            allowContactSharing(allowContactSharing as Boolean?)

        /**
         * Alias for calling [Builder.allowContactSharing] with `allowContactSharing.orElse(null)`.
         */
        fun allowContactSharing(allowContactSharing: Optional<Boolean>) =
            allowContactSharing(allowContactSharing.getOrNull())

        /**
         * Sets [Builder.allowContactSharing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowContactSharing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowContactSharing(allowContactSharing: JsonField<Boolean>) = apply {
            this.allowContactSharing = allowContactSharing
        }

        /** Whether templates are shared across profiles in the organization */
        fun allowTemplateSharing(allowTemplateSharing: Boolean?) =
            allowTemplateSharing(JsonField.ofNullable(allowTemplateSharing))

        /**
         * Alias for [Builder.allowTemplateSharing].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun allowTemplateSharing(allowTemplateSharing: Boolean) =
            allowTemplateSharing(allowTemplateSharing as Boolean?)

        /**
         * Alias for calling [Builder.allowTemplateSharing] with
         * `allowTemplateSharing.orElse(null)`.
         */
        fun allowTemplateSharing(allowTemplateSharing: Optional<Boolean>) =
            allowTemplateSharing(allowTemplateSharing.getOrNull())

        /**
         * Sets [Builder.allowTemplateSharing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowTemplateSharing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowTemplateSharing(allowTemplateSharing: JsonField<Boolean>) = apply {
            this.allowTemplateSharing = allowTemplateSharing
        }

        /** Billing model: profile, organization, or profile_and_organization */
        fun billingModel(billingModel: String?) = billingModel(JsonField.ofNullable(billingModel))

        /** Alias for calling [Builder.billingModel] with `billingModel.orElse(null)`. */
        fun billingModel(billingModel: Optional<String>) = billingModel(billingModel.getOrNull())

        /**
         * Sets [Builder.billingModel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billingModel] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billingModel(billingModel: JsonField<String>) = apply {
            this.billingModel = billingModel
        }

        /** Whether this profile inherits contacts from the organization */
        fun inheritContacts(inheritContacts: Boolean?) =
            inheritContacts(JsonField.ofNullable(inheritContacts))

        /**
         * Alias for [Builder.inheritContacts].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritContacts(inheritContacts: Boolean) = inheritContacts(inheritContacts as Boolean?)

        /** Alias for calling [Builder.inheritContacts] with `inheritContacts.orElse(null)`. */
        fun inheritContacts(inheritContacts: Optional<Boolean>) =
            inheritContacts(inheritContacts.getOrNull())

        /**
         * Sets [Builder.inheritContacts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritContacts] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritContacts(inheritContacts: JsonField<Boolean>) = apply {
            this.inheritContacts = inheritContacts
        }

        /** Whether this profile inherits TCR brand from the organization */
        fun inheritTcrBrand(inheritTcrBrand: Boolean?) =
            inheritTcrBrand(JsonField.ofNullable(inheritTcrBrand))

        /**
         * Alias for [Builder.inheritTcrBrand].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritTcrBrand(inheritTcrBrand: Boolean) = inheritTcrBrand(inheritTcrBrand as Boolean?)

        /** Alias for calling [Builder.inheritTcrBrand] with `inheritTcrBrand.orElse(null)`. */
        fun inheritTcrBrand(inheritTcrBrand: Optional<Boolean>) =
            inheritTcrBrand(inheritTcrBrand.getOrNull())

        /**
         * Sets [Builder.inheritTcrBrand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTcrBrand] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTcrBrand(inheritTcrBrand: JsonField<Boolean>) = apply {
            this.inheritTcrBrand = inheritTcrBrand
        }

        /** Whether this profile inherits TCR campaign from the organization */
        fun inheritTcrCampaign(inheritTcrCampaign: Boolean?) =
            inheritTcrCampaign(JsonField.ofNullable(inheritTcrCampaign))

        /**
         * Alias for [Builder.inheritTcrCampaign].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: Boolean) =
            inheritTcrCampaign(inheritTcrCampaign as Boolean?)

        /**
         * Alias for calling [Builder.inheritTcrCampaign] with `inheritTcrCampaign.orElse(null)`.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: Optional<Boolean>) =
            inheritTcrCampaign(inheritTcrCampaign.getOrNull())

        /**
         * Sets [Builder.inheritTcrCampaign] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTcrCampaign] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: JsonField<Boolean>) = apply {
            this.inheritTcrCampaign = inheritTcrCampaign
        }

        /** Whether this profile inherits templates from the organization */
        fun inheritTemplates(inheritTemplates: Boolean?) =
            inheritTemplates(JsonField.ofNullable(inheritTemplates))

        /**
         * Alias for [Builder.inheritTemplates].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritTemplates(inheritTemplates: Boolean) =
            inheritTemplates(inheritTemplates as Boolean?)

        /** Alias for calling [Builder.inheritTemplates] with `inheritTemplates.orElse(null)`. */
        fun inheritTemplates(inheritTemplates: Optional<Boolean>) =
            inheritTemplates(inheritTemplates.getOrNull())

        /**
         * Sets [Builder.inheritTemplates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTemplates] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTemplates(inheritTemplates: JsonField<Boolean>) = apply {
            this.inheritTemplates = inheritTemplates
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
         * Returns an immutable instance of [ProfileSettings].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ProfileSettings =
            ProfileSettings(
                allowContactSharing,
                allowTemplateSharing,
                billingModel,
                inheritContacts,
                inheritTcrBrand,
                inheritTcrCampaign,
                inheritTemplates,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ProfileSettings = apply {
        if (validated) {
            return@apply
        }

        allowContactSharing()
        allowTemplateSharing()
        billingModel()
        inheritContacts()
        inheritTcrBrand()
        inheritTcrCampaign()
        inheritTemplates()
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
        (if (allowContactSharing.asKnown().isPresent) 1 else 0) +
            (if (allowTemplateSharing.asKnown().isPresent) 1 else 0) +
            (if (billingModel.asKnown().isPresent) 1 else 0) +
            (if (inheritContacts.asKnown().isPresent) 1 else 0) +
            (if (inheritTcrBrand.asKnown().isPresent) 1 else 0) +
            (if (inheritTcrCampaign.asKnown().isPresent) 1 else 0) +
            (if (inheritTemplates.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileSettings &&
            allowContactSharing == other.allowContactSharing &&
            allowTemplateSharing == other.allowTemplateSharing &&
            billingModel == other.billingModel &&
            inheritContacts == other.inheritContacts &&
            inheritTcrBrand == other.inheritTcrBrand &&
            inheritTcrCampaign == other.inheritTcrCampaign &&
            inheritTemplates == other.inheritTemplates &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            allowContactSharing,
            allowTemplateSharing,
            billingModel,
            inheritContacts,
            inheritTcrBrand,
            inheritTcrCampaign,
            inheritTemplates,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProfileSettings{allowContactSharing=$allowContactSharing, allowTemplateSharing=$allowTemplateSharing, billingModel=$billingModel, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, additionalProperties=$additionalProperties}"
}
