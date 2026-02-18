// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.profiles

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

/** Detailed profile response for v3 API */
class ProfileDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val description: JsonField<String>,
    private val email: JsonField<String>,
    private val icon: JsonField<String>,
    private val name: JsonField<String>,
    private val organizationId: JsonField<String>,
    private val settings: JsonField<Settings>,
    private val shortName: JsonField<String>,
    private val status: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("icon") @ExcludeMissing icon: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("organization_id")
        @ExcludeMissing
        organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("settings") @ExcludeMissing settings: JsonField<Settings> = JsonMissing.of(),
        @JsonProperty("short_name") @ExcludeMissing shortName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        description,
        email,
        icon,
        name,
        organizationId,
        settings,
        shortName,
        status,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * Profile unique identifier
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * When the profile was created
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Profile description
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Profile email (inherited from organization)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * Profile icon URL
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun icon(): Optional<String> = icon.getOptional("icon")

    /**
     * Profile name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Parent organization ID
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = organizationId.getOptional("organization_id")

    /**
     * Profile configuration settings
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun settings(): Optional<Settings> = settings.getOptional("settings")

    /**
     * Profile short name (abbreviation)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shortName(): Optional<String> = shortName.getOptional("short_name")

    /**
     * Profile setup status: incomplete, pending_review, approved, rejected
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * When the profile was last updated
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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [icon].
     *
     * Unlike [icon], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("icon") @ExcludeMissing fun _icon(): JsonField<String> = icon

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("organization_id")
    @ExcludeMissing
    fun _organizationId(): JsonField<String> = organizationId

    /**
     * Returns the raw JSON value of [settings].
     *
     * Unlike [settings], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("settings") @ExcludeMissing fun _settings(): JsonField<Settings> = settings

    /**
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("short_name") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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

        /** Returns a mutable builder for constructing an instance of [ProfileDetail]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProfileDetail]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var icon: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var organizationId: JsonField<String> = JsonMissing.of()
        private var settings: JsonField<Settings> = JsonMissing.of()
        private var shortName: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(profileDetail: ProfileDetail) = apply {
            id = profileDetail.id
            createdAt = profileDetail.createdAt
            description = profileDetail.description
            email = profileDetail.email
            icon = profileDetail.icon
            name = profileDetail.name
            organizationId = profileDetail.organizationId
            settings = profileDetail.settings
            shortName = profileDetail.shortName
            status = profileDetail.status
            updatedAt = profileDetail.updatedAt
            additionalProperties = profileDetail.additionalProperties.toMutableMap()
        }

        /** Profile unique identifier */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** When the profile was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Profile description */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Profile email (inherited from organization) */
        fun email(email: String?) = email(JsonField.ofNullable(email))

        /** Alias for calling [Builder.email] with `email.orElse(null)`. */
        fun email(email: Optional<String>) = email(email.getOrNull())

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** Profile icon URL */
        fun icon(icon: String?) = icon(JsonField.ofNullable(icon))

        /** Alias for calling [Builder.icon] with `icon.orElse(null)`. */
        fun icon(icon: Optional<String>) = icon(icon.getOrNull())

        /**
         * Sets [Builder.icon] to an arbitrary JSON value.
         *
         * You should usually call [Builder.icon] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun icon(icon: JsonField<String>) = apply { this.icon = icon }

        /** Profile name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Parent organization ID */
        fun organizationId(organizationId: String?) =
            organizationId(JsonField.ofNullable(organizationId))

        /** Alias for calling [Builder.organizationId] with `organizationId.orElse(null)`. */
        fun organizationId(organizationId: Optional<String>) =
            organizationId(organizationId.getOrNull())

        /**
         * Sets [Builder.organizationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun organizationId(organizationId: JsonField<String>) = apply {
            this.organizationId = organizationId
        }

        /** Profile configuration settings */
        fun settings(settings: Settings) = settings(JsonField.of(settings))

        /**
         * Sets [Builder.settings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.settings] with a well-typed [Settings] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun settings(settings: JsonField<Settings>) = apply { this.settings = settings }

        /** Profile short name (abbreviation) */
        fun shortName(shortName: String?) = shortName(JsonField.ofNullable(shortName))

        /** Alias for calling [Builder.shortName] with `shortName.orElse(null)`. */
        fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

        /**
         * Sets [Builder.shortName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shortName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

        /** Profile setup status: incomplete, pending_review, approved, rejected */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** When the profile was last updated */
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
         * Returns an immutable instance of [ProfileDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ProfileDetail =
            ProfileDetail(
                id,
                createdAt,
                description,
                email,
                icon,
                name,
                organizationId,
                settings,
                shortName,
                status,
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ProfileDetail = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        description()
        email()
        icon()
        name()
        organizationId()
        settings().ifPresent { it.validate() }
        shortName()
        status()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (icon.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (organizationId.asKnown().isPresent) 1 else 0) +
            (settings.asKnown().getOrNull()?.validity() ?: 0) +
            (if (shortName.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    /** Profile configuration settings */
    class Settings
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val allowContactSharing: JsonField<Boolean>,
        private val allowNumberChangeDuringOnboarding: JsonField<Boolean>,
        private val allowTemplateSharing: JsonField<Boolean>,
        private val billingModel: JsonField<String>,
        private val inheritContacts: JsonField<Boolean>,
        private val inheritTcrBrand: JsonField<Boolean>,
        private val inheritTcrCampaign: JsonField<Boolean>,
        private val inheritTemplates: JsonField<Boolean>,
        private val sendingPhoneNumber: JsonField<String>,
        private val sendingPhoneNumberProfileId: JsonField<String>,
        private val sendingWhatsappNumberProfileId: JsonField<String>,
        private val whatsappPhoneNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("allow_contact_sharing")
            @ExcludeMissing
            allowContactSharing: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("allow_number_change_during_onboarding")
            @ExcludeMissing
            allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of(),
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
            @JsonProperty("sending_phone_number")
            @ExcludeMissing
            sendingPhoneNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sending_phone_number_profile_id")
            @ExcludeMissing
            sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sending_whatsapp_number_profile_id")
            @ExcludeMissing
            sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("whatsapp_phone_number")
            @ExcludeMissing
            whatsappPhoneNumber: JsonField<String> = JsonMissing.of(),
        ) : this(
            allowContactSharing,
            allowNumberChangeDuringOnboarding,
            allowTemplateSharing,
            billingModel,
            inheritContacts,
            inheritTcrBrand,
            inheritTcrCampaign,
            inheritTemplates,
            sendingPhoneNumber,
            sendingPhoneNumberProfileId,
            sendingWhatsappNumberProfileId,
            whatsappPhoneNumber,
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
         * Whether number changes are allowed during onboarding
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowNumberChangeDuringOnboarding(): Optional<Boolean> =
            allowNumberChangeDuringOnboarding.getOptional("allow_number_change_during_onboarding")

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
        fun inheritTemplates(): Optional<Boolean> =
            inheritTemplates.getOptional("inherit_templates")

        /**
         * Direct SMS phone number
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingPhoneNumber(): Optional<String> =
            sendingPhoneNumber.getOptional("sending_phone_number")

        /**
         * Reference to another profile for SMS/Telnyx configuration
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingPhoneNumberProfileId(): Optional<String> =
            sendingPhoneNumberProfileId.getOptional("sending_phone_number_profile_id")

        /**
         * Reference to another profile for WhatsApp configuration
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingWhatsappNumberProfileId(): Optional<String> =
            sendingWhatsappNumberProfileId.getOptional("sending_whatsapp_number_profile_id")

        /**
         * Direct WhatsApp phone number
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun whatsappPhoneNumber(): Optional<String> =
            whatsappPhoneNumber.getOptional("whatsapp_phone_number")

        /**
         * Returns the raw JSON value of [allowContactSharing].
         *
         * Unlike [allowContactSharing], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("allow_contact_sharing")
        @ExcludeMissing
        fun _allowContactSharing(): JsonField<Boolean> = allowContactSharing

        /**
         * Returns the raw JSON value of [allowNumberChangeDuringOnboarding].
         *
         * Unlike [allowNumberChangeDuringOnboarding], this method doesn't throw if the JSON field
         * has an unexpected type.
         */
        @JsonProperty("allow_number_change_during_onboarding")
        @ExcludeMissing
        fun _allowNumberChangeDuringOnboarding(): JsonField<Boolean> =
            allowNumberChangeDuringOnboarding

        /**
         * Returns the raw JSON value of [allowTemplateSharing].
         *
         * Unlike [allowTemplateSharing], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("allow_template_sharing")
        @ExcludeMissing
        fun _allowTemplateSharing(): JsonField<Boolean> = allowTemplateSharing

        /**
         * Returns the raw JSON value of [billingModel].
         *
         * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("billing_model")
        @ExcludeMissing
        fun _billingModel(): JsonField<String> = billingModel

        /**
         * Returns the raw JSON value of [inheritContacts].
         *
         * Unlike [inheritContacts], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inherit_contacts")
        @ExcludeMissing
        fun _inheritContacts(): JsonField<Boolean> = inheritContacts

        /**
         * Returns the raw JSON value of [inheritTcrBrand].
         *
         * Unlike [inheritTcrBrand], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inherit_tcr_brand")
        @ExcludeMissing
        fun _inheritTcrBrand(): JsonField<Boolean> = inheritTcrBrand

        /**
         * Returns the raw JSON value of [inheritTcrCampaign].
         *
         * Unlike [inheritTcrCampaign], this method doesn't throw if the JSON field has an
         * unexpected type.
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

        /**
         * Returns the raw JSON value of [sendingPhoneNumber].
         *
         * Unlike [sendingPhoneNumber], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("sending_phone_number")
        @ExcludeMissing
        fun _sendingPhoneNumber(): JsonField<String> = sendingPhoneNumber

        /**
         * Returns the raw JSON value of [sendingPhoneNumberProfileId].
         *
         * Unlike [sendingPhoneNumberProfileId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("sending_phone_number_profile_id")
        @ExcludeMissing
        fun _sendingPhoneNumberProfileId(): JsonField<String> = sendingPhoneNumberProfileId

        /**
         * Returns the raw JSON value of [sendingWhatsappNumberProfileId].
         *
         * Unlike [sendingWhatsappNumberProfileId], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("sending_whatsapp_number_profile_id")
        @ExcludeMissing
        fun _sendingWhatsappNumberProfileId(): JsonField<String> = sendingWhatsappNumberProfileId

        /**
         * Returns the raw JSON value of [whatsappPhoneNumber].
         *
         * Unlike [whatsappPhoneNumber], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("whatsapp_phone_number")
        @ExcludeMissing
        fun _whatsappPhoneNumber(): JsonField<String> = whatsappPhoneNumber

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

            /** Returns a mutable builder for constructing an instance of [Settings]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Settings]. */
        class Builder internal constructor() {

            private var allowContactSharing: JsonField<Boolean> = JsonMissing.of()
            private var allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of()
            private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
            private var billingModel: JsonField<String> = JsonMissing.of()
            private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
            private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
            private var sendingPhoneNumber: JsonField<String> = JsonMissing.of()
            private var sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of()
            private var sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of()
            private var whatsappPhoneNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(settings: Settings) = apply {
                allowContactSharing = settings.allowContactSharing
                allowNumberChangeDuringOnboarding = settings.allowNumberChangeDuringOnboarding
                allowTemplateSharing = settings.allowTemplateSharing
                billingModel = settings.billingModel
                inheritContacts = settings.inheritContacts
                inheritTcrBrand = settings.inheritTcrBrand
                inheritTcrCampaign = settings.inheritTcrCampaign
                inheritTemplates = settings.inheritTemplates
                sendingPhoneNumber = settings.sendingPhoneNumber
                sendingPhoneNumberProfileId = settings.sendingPhoneNumberProfileId
                sendingWhatsappNumberProfileId = settings.sendingWhatsappNumberProfileId
                whatsappPhoneNumber = settings.whatsappPhoneNumber
                additionalProperties = settings.additionalProperties.toMutableMap()
            }

            /** Whether contacts are shared across profiles in the organization */
            fun allowContactSharing(allowContactSharing: Boolean) =
                allowContactSharing(JsonField.of(allowContactSharing))

            /**
             * Sets [Builder.allowContactSharing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowContactSharing] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun allowContactSharing(allowContactSharing: JsonField<Boolean>) = apply {
                this.allowContactSharing = allowContactSharing
            }

            /** Whether number changes are allowed during onboarding */
            fun allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding: Boolean?) =
                allowNumberChangeDuringOnboarding(
                    JsonField.ofNullable(allowNumberChangeDuringOnboarding)
                )

            /**
             * Alias for [Builder.allowNumberChangeDuringOnboarding].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding: Boolean) =
                allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding as Boolean?)

            /**
             * Alias for calling [Builder.allowNumberChangeDuringOnboarding] with
             * `allowNumberChangeDuringOnboarding.orElse(null)`.
             */
            fun allowNumberChangeDuringOnboarding(
                allowNumberChangeDuringOnboarding: Optional<Boolean>
            ) = allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding.getOrNull())

            /**
             * Sets [Builder.allowNumberChangeDuringOnboarding] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowNumberChangeDuringOnboarding] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun allowNumberChangeDuringOnboarding(
                allowNumberChangeDuringOnboarding: JsonField<Boolean>
            ) = apply { this.allowNumberChangeDuringOnboarding = allowNumberChangeDuringOnboarding }

            /** Whether templates are shared across profiles in the organization */
            fun allowTemplateSharing(allowTemplateSharing: Boolean) =
                allowTemplateSharing(JsonField.of(allowTemplateSharing))

            /**
             * Sets [Builder.allowTemplateSharing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowTemplateSharing] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun allowTemplateSharing(allowTemplateSharing: JsonField<Boolean>) = apply {
                this.allowTemplateSharing = allowTemplateSharing
            }

            /** Billing model: profile, organization, or profile_and_organization */
            fun billingModel(billingModel: String) = billingModel(JsonField.of(billingModel))

            /**
             * Sets [Builder.billingModel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billingModel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun billingModel(billingModel: JsonField<String>) = apply {
                this.billingModel = billingModel
            }

            /** Whether this profile inherits contacts from the organization */
            fun inheritContacts(inheritContacts: Boolean) =
                inheritContacts(JsonField.of(inheritContacts))

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
            fun inheritTcrBrand(inheritTcrBrand: Boolean) =
                inheritTcrBrand(JsonField.of(inheritTcrBrand))

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
            fun inheritTcrCampaign(inheritTcrCampaign: Boolean) =
                inheritTcrCampaign(JsonField.of(inheritTcrCampaign))

            /**
             * Sets [Builder.inheritTcrCampaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inheritTcrCampaign] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun inheritTcrCampaign(inheritTcrCampaign: JsonField<Boolean>) = apply {
                this.inheritTcrCampaign = inheritTcrCampaign
            }

            /** Whether this profile inherits templates from the organization */
            fun inheritTemplates(inheritTemplates: Boolean) =
                inheritTemplates(JsonField.of(inheritTemplates))

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

            /** Direct SMS phone number */
            fun sendingPhoneNumber(sendingPhoneNumber: String?) =
                sendingPhoneNumber(JsonField.ofNullable(sendingPhoneNumber))

            /**
             * Alias for calling [Builder.sendingPhoneNumber] with
             * `sendingPhoneNumber.orElse(null)`.
             */
            fun sendingPhoneNumber(sendingPhoneNumber: Optional<String>) =
                sendingPhoneNumber(sendingPhoneNumber.getOrNull())

            /**
             * Sets [Builder.sendingPhoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sendingPhoneNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sendingPhoneNumber(sendingPhoneNumber: JsonField<String>) = apply {
                this.sendingPhoneNumber = sendingPhoneNumber
            }

            /** Reference to another profile for SMS/Telnyx configuration */
            fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: String?) =
                sendingPhoneNumberProfileId(JsonField.ofNullable(sendingPhoneNumberProfileId))

            /**
             * Alias for calling [Builder.sendingPhoneNumberProfileId] with
             * `sendingPhoneNumberProfileId.orElse(null)`.
             */
            fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: Optional<String>) =
                sendingPhoneNumberProfileId(sendingPhoneNumberProfileId.getOrNull())

            /**
             * Sets [Builder.sendingPhoneNumberProfileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sendingPhoneNumberProfileId] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: JsonField<String>) =
                apply {
                    this.sendingPhoneNumberProfileId = sendingPhoneNumberProfileId
                }

            /** Reference to another profile for WhatsApp configuration */
            fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: String?) =
                sendingWhatsappNumberProfileId(JsonField.ofNullable(sendingWhatsappNumberProfileId))

            /**
             * Alias for calling [Builder.sendingWhatsappNumberProfileId] with
             * `sendingWhatsappNumberProfileId.orElse(null)`.
             */
            fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: Optional<String>) =
                sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId.getOrNull())

            /**
             * Sets [Builder.sendingWhatsappNumberProfileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sendingWhatsappNumberProfileId] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: JsonField<String>) =
                apply {
                    this.sendingWhatsappNumberProfileId = sendingWhatsappNumberProfileId
                }

            /** Direct WhatsApp phone number */
            fun whatsappPhoneNumber(whatsappPhoneNumber: String?) =
                whatsappPhoneNumber(JsonField.ofNullable(whatsappPhoneNumber))

            /**
             * Alias for calling [Builder.whatsappPhoneNumber] with
             * `whatsappPhoneNumber.orElse(null)`.
             */
            fun whatsappPhoneNumber(whatsappPhoneNumber: Optional<String>) =
                whatsappPhoneNumber(whatsappPhoneNumber.getOrNull())

            /**
             * Sets [Builder.whatsappPhoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.whatsappPhoneNumber] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun whatsappPhoneNumber(whatsappPhoneNumber: JsonField<String>) = apply {
                this.whatsappPhoneNumber = whatsappPhoneNumber
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
             * Returns an immutable instance of [Settings].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Settings =
                Settings(
                    allowContactSharing,
                    allowNumberChangeDuringOnboarding,
                    allowTemplateSharing,
                    billingModel,
                    inheritContacts,
                    inheritTcrBrand,
                    inheritTcrCampaign,
                    inheritTemplates,
                    sendingPhoneNumber,
                    sendingPhoneNumberProfileId,
                    sendingWhatsappNumberProfileId,
                    whatsappPhoneNumber,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Settings = apply {
            if (validated) {
                return@apply
            }

            allowContactSharing()
            allowNumberChangeDuringOnboarding()
            allowTemplateSharing()
            billingModel()
            inheritContacts()
            inheritTcrBrand()
            inheritTcrCampaign()
            inheritTemplates()
            sendingPhoneNumber()
            sendingPhoneNumberProfileId()
            sendingWhatsappNumberProfileId()
            whatsappPhoneNumber()
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
            (if (allowContactSharing.asKnown().isPresent) 1 else 0) +
                (if (allowNumberChangeDuringOnboarding.asKnown().isPresent) 1 else 0) +
                (if (allowTemplateSharing.asKnown().isPresent) 1 else 0) +
                (if (billingModel.asKnown().isPresent) 1 else 0) +
                (if (inheritContacts.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrBrand.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrCampaign.asKnown().isPresent) 1 else 0) +
                (if (inheritTemplates.asKnown().isPresent) 1 else 0) +
                (if (sendingPhoneNumber.asKnown().isPresent) 1 else 0) +
                (if (sendingPhoneNumberProfileId.asKnown().isPresent) 1 else 0) +
                (if (sendingWhatsappNumberProfileId.asKnown().isPresent) 1 else 0) +
                (if (whatsappPhoneNumber.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Settings &&
                allowContactSharing == other.allowContactSharing &&
                allowNumberChangeDuringOnboarding == other.allowNumberChangeDuringOnboarding &&
                allowTemplateSharing == other.allowTemplateSharing &&
                billingModel == other.billingModel &&
                inheritContacts == other.inheritContacts &&
                inheritTcrBrand == other.inheritTcrBrand &&
                inheritTcrCampaign == other.inheritTcrCampaign &&
                inheritTemplates == other.inheritTemplates &&
                sendingPhoneNumber == other.sendingPhoneNumber &&
                sendingPhoneNumberProfileId == other.sendingPhoneNumberProfileId &&
                sendingWhatsappNumberProfileId == other.sendingWhatsappNumberProfileId &&
                whatsappPhoneNumber == other.whatsappPhoneNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                allowContactSharing,
                allowNumberChangeDuringOnboarding,
                allowTemplateSharing,
                billingModel,
                inheritContacts,
                inheritTcrBrand,
                inheritTcrCampaign,
                inheritTemplates,
                sendingPhoneNumber,
                sendingPhoneNumberProfileId,
                sendingWhatsappNumberProfileId,
                whatsappPhoneNumber,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Settings{allowContactSharing=$allowContactSharing, allowNumberChangeDuringOnboarding=$allowNumberChangeDuringOnboarding, allowTemplateSharing=$allowTemplateSharing, billingModel=$billingModel, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, sendingPhoneNumber=$sendingPhoneNumber, sendingPhoneNumberProfileId=$sendingPhoneNumberProfileId, sendingWhatsappNumberProfileId=$sendingWhatsappNumberProfileId, whatsappPhoneNumber=$whatsappPhoneNumber, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileDetail &&
            id == other.id &&
            createdAt == other.createdAt &&
            description == other.description &&
            email == other.email &&
            icon == other.icon &&
            name == other.name &&
            organizationId == other.organizationId &&
            settings == other.settings &&
            shortName == other.shortName &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            description,
            email,
            icon,
            name,
            organizationId,
            settings,
            shortName,
            status,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProfileDetail{id=$id, createdAt=$createdAt, description=$description, email=$email, icon=$icon, name=$name, organizationId=$organizationId, settings=$settings, shortName=$shortName, status=$status, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
