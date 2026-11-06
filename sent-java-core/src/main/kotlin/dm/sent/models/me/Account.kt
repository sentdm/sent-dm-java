// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Account response for GET /v3/me endpoint. Returns organization (with profiles), user
 * (standalone), or profile (child of an organization) data depending on the API key type. Always
 * includes messaging channel configuration.
 */
class Account
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val channels: JsonField<AccountChannels>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val description: JsonField<String>,
    private val email: JsonField<String>,
    private val enableTemplateAutoCreationForSp: JsonField<Boolean>,
    private val icon: JsonField<String>,
    private val name: JsonField<String>,
    private val organizationId: JsonField<String>,
    private val profiles: JsonField<List<AccountProfile>>,
    private val sendingPhoneNumber: JsonField<String>,
    private val sendingPhoneNumberProfileId: JsonField<String>,
    private val settings: JsonField<ProfileSettings>,
    private val shortName: JsonField<String>,
    private val status: JsonField<String>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channels")
        @ExcludeMissing
        channels: JsonField<AccountChannels> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("enable_template_auto_creation_for_sp")
        @ExcludeMissing
        enableTemplateAutoCreationForSp: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("icon") @ExcludeMissing icon: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("organization_id")
        @ExcludeMissing
        organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profiles")
        @ExcludeMissing
        profiles: JsonField<List<AccountProfile>> = JsonMissing.of(),
        @JsonProperty("sending_phone_number")
        @ExcludeMissing
        sendingPhoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sending_phone_number_profile_id")
        @ExcludeMissing
        sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("settings")
        @ExcludeMissing
        settings: JsonField<ProfileSettings> = JsonMissing.of(),
        @JsonProperty("short_name") @ExcludeMissing shortName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        channels,
        createdAt,
        description,
        email,
        enableTemplateAutoCreationForSp,
        icon,
        name,
        organizationId,
        profiles,
        sendingPhoneNumber,
        sendingPhoneNumberProfileId,
        settings,
        shortName,
        status,
        type,
        mutableMapOf(),
    )

    /**
     * Customer ID (organization, account, or profile)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Messaging channel configuration. All three channels are always present. Each channel has a
     * "configured" flag; configured channels expose additional details.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channels(): Optional<AccountChannels> = channels.getOptional("channels")

    /**
     * When the account was created
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Account description
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Contact email address
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * Whether this account may mark a template for automatic creation on its sender profiles.
     * Granted by Sent per account and off by default, so it is what a template-create form reads to
     * decide whether to offer the option at all — marking a template without it does nothing.
     *
     * Top-level rather than inside settings, which is written for type: "profile" only and so would
     * never carry it to the account type that can act on it.
     *
     * This is the capability, not the stored flag: a profile reports false whatever its own row
     * holds. A sender profile owns no sender profiles, so a template it marked would have nothing
     * to be created on and the fan-out would never read the flag. The admin GET /customers/{id}
     * reports the stored value instead, because that is the one an operator granted.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun enableTemplateAutoCreationForSp(): Optional<Boolean> =
        enableTemplateAutoCreationForSp.getOptional("enable_template_auto_creation_for_sp")

    /**
     * Account icon URL
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun icon(): Optional<String> = icon.getOptional("icon")

    /**
     * Account name
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Organization ID (only for profile type — the parent organization)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = organizationId.getOptional("organization_id")

    /**
     * List of profiles (populated for organization type, empty for user and profile types)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun profiles(): Optional<List<AccountProfile>> = profiles.getOptional("profiles")

    /**
     * The SMS sender this account sends from in the United States, in E.164 form. Null when the
     * account has no US SMS sender.
     *
     * The same value as channels.sms.phone_number, published under both names on purpose:
     * sending_phone_number is what this value is already called on GET /v3/profiles, so the same
     * key answers the same question whichever of the two endpoints you ask. Neither name is
     * preferred over the other and neither is deprecated.
     *
     * The same value, not the same presence: this key is always written, including as null, whereas
     * channels.sms.phone_number is left out entirely when there is no sender.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sendingPhoneNumber(): Optional<String> =
        sendingPhoneNumber.getOptional("sending_phone_number")

    /**
     * The account that holds sending_phone_number in number inventory: normally this account
     * itself, and a different account when the number is held elsewhere. Null when there is no US
     * sender, or when the sender is not a number drawn from inventory — an alphanumeric sender ID
     * or a short code.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sendingPhoneNumberProfileId(): Optional<String> =
        sendingPhoneNumberProfileId.getOptional("sending_phone_number_profile_id")

    /**
     * Profile configuration settings
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun settings(): Optional<ProfileSettings> = settings.getOptional("settings")

    /**
     * Short name / abbreviation (only for profile type)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun shortName(): Optional<String> = shortName.getOptional("short_name")

    /**
     * Profile status (only for profile type): incomplete, pending_review, approved, etc.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Account type: "organization" (has profiles), "user" (no profiles), or "profile" (child of an
     * organization)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [channels].
     *
     * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channels") @ExcludeMissing fun _channels(): JsonField<AccountChannels> = channels

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
     * Returns the raw JSON value of [enableTemplateAutoCreationForSp].
     *
     * Unlike [enableTemplateAutoCreationForSp], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("enable_template_auto_creation_for_sp")
    @ExcludeMissing
    fun _enableTemplateAutoCreationForSp(): JsonField<Boolean> = enableTemplateAutoCreationForSp

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
     * Returns the raw JSON value of [profiles].
     *
     * Unlike [profiles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("profiles")
    @ExcludeMissing
    fun _profiles(): JsonField<List<AccountProfile>> = profiles

    /**
     * Returns the raw JSON value of [sendingPhoneNumber].
     *
     * Unlike [sendingPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
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
     * Returns the raw JSON value of [settings].
     *
     * Unlike [settings], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("settings") @ExcludeMissing fun _settings(): JsonField<ProfileSettings> = settings

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
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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

        /** Returns a mutable builder for constructing an instance of [Account]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Account]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var channels: JsonField<AccountChannels> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var enableTemplateAutoCreationForSp: JsonField<Boolean> = JsonMissing.of()
        private var icon: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var organizationId: JsonField<String> = JsonMissing.of()
        private var profiles: JsonField<MutableList<AccountProfile>>? = null
        private var sendingPhoneNumber: JsonField<String> = JsonMissing.of()
        private var sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of()
        private var settings: JsonField<ProfileSettings> = JsonMissing.of()
        private var shortName: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(account: Account) = apply {
            id = account.id
            channels = account.channels
            createdAt = account.createdAt
            description = account.description
            email = account.email
            enableTemplateAutoCreationForSp = account.enableTemplateAutoCreationForSp
            icon = account.icon
            name = account.name
            organizationId = account.organizationId
            profiles = account.profiles.map { it.toMutableList() }
            sendingPhoneNumber = account.sendingPhoneNumber
            sendingPhoneNumberProfileId = account.sendingPhoneNumberProfileId
            settings = account.settings
            shortName = account.shortName
            status = account.status
            type = account.type
            additionalProperties = account.additionalProperties.toMutableMap()
        }

        /** Customer ID (organization, account, or profile) */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Messaging channel configuration. All three channels are always present. Each channel has
         * a "configured" flag; configured channels expose additional details.
         */
        fun channels(channels: AccountChannels) = channels(JsonField.of(channels))

        /**
         * Sets [Builder.channels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channels] with a well-typed [AccountChannels] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun channels(channels: JsonField<AccountChannels>) = apply { this.channels = channels }

        /** When the account was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Account description */
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

        /** Contact email address */
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

        /**
         * Whether this account may mark a template for automatic creation on its sender profiles.
         * Granted by Sent per account and off by default, so it is what a template-create form
         * reads to decide whether to offer the option at all — marking a template without it does
         * nothing.
         *
         * Top-level rather than inside settings, which is written for type: "profile" only and so
         * would never carry it to the account type that can act on it.
         *
         * This is the capability, not the stored flag: a profile reports false whatever its own row
         * holds. A sender profile owns no sender profiles, so a template it marked would have
         * nothing to be created on and the fan-out would never read the flag. The admin GET
         * /customers/{id} reports the stored value instead, because that is the one an operator
         * granted.
         */
        fun enableTemplateAutoCreationForSp(enableTemplateAutoCreationForSp: Boolean) =
            enableTemplateAutoCreationForSp(JsonField.of(enableTemplateAutoCreationForSp))

        /**
         * Sets [Builder.enableTemplateAutoCreationForSp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enableTemplateAutoCreationForSp] with a well-typed
         * [Boolean] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun enableTemplateAutoCreationForSp(enableTemplateAutoCreationForSp: JsonField<Boolean>) =
            apply {
                this.enableTemplateAutoCreationForSp = enableTemplateAutoCreationForSp
            }

        /** Account icon URL */
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

        /** Account name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Organization ID (only for profile type — the parent organization) */
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

        /** List of profiles (populated for organization type, empty for user and profile types) */
        fun profiles(profiles: List<AccountProfile>) = profiles(JsonField.of(profiles))

        /**
         * Sets [Builder.profiles] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profiles] with a well-typed `List<AccountProfile>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profiles(profiles: JsonField<List<AccountProfile>>) = apply {
            this.profiles = profiles.map { it.toMutableList() }
        }

        /**
         * Adds a single [AccountProfile] to [profiles].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addProfile(profile: AccountProfile) = apply {
            profiles =
                (profiles ?: JsonField.of(mutableListOf())).also {
                    checkKnown("profiles", it).add(profile)
                }
        }

        /**
         * The SMS sender this account sends from in the United States, in E.164 form. Null when the
         * account has no US SMS sender.
         *
         * The same value as channels.sms.phone_number, published under both names on purpose:
         * sending_phone_number is what this value is already called on GET /v3/profiles, so the
         * same key answers the same question whichever of the two endpoints you ask. Neither name
         * is preferred over the other and neither is deprecated.
         *
         * The same value, not the same presence: this key is always written, including as null,
         * whereas channels.sms.phone_number is left out entirely when there is no sender.
         */
        fun sendingPhoneNumber(sendingPhoneNumber: String?) =
            sendingPhoneNumber(JsonField.ofNullable(sendingPhoneNumber))

        /**
         * Alias for calling [Builder.sendingPhoneNumber] with `sendingPhoneNumber.orElse(null)`.
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

        /**
         * The account that holds sending_phone_number in number inventory: normally this account
         * itself, and a different account when the number is held elsewhere. Null when there is no
         * US sender, or when the sender is not a number drawn from inventory — an alphanumeric
         * sender ID or a short code.
         */
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
         * You should usually call [Builder.sendingPhoneNumberProfileId] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: JsonField<String>) = apply {
            this.sendingPhoneNumberProfileId = sendingPhoneNumberProfileId
        }

        /** Profile configuration settings */
        fun settings(settings: ProfileSettings?) = settings(JsonField.ofNullable(settings))

        /** Alias for calling [Builder.settings] with `settings.orElse(null)`. */
        fun settings(settings: Optional<ProfileSettings>) = settings(settings.getOrNull())

        /**
         * Sets [Builder.settings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.settings] with a well-typed [ProfileSettings] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun settings(settings: JsonField<ProfileSettings>) = apply { this.settings = settings }

        /** Short name / abbreviation (only for profile type) */
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

        /** Profile status (only for profile type): incomplete, pending_review, approved, etc. */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /**
         * Account type: "organization" (has profiles), "user" (no profiles), or "profile" (child of
         * an organization)
         */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

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
         * Returns an immutable instance of [Account].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Account =
            Account(
                id,
                channels,
                createdAt,
                description,
                email,
                enableTemplateAutoCreationForSp,
                icon,
                name,
                organizationId,
                (profiles ?: JsonMissing.of()).map { it.toImmutable() },
                sendingPhoneNumber,
                sendingPhoneNumberProfileId,
                settings,
                shortName,
                status,
                type,
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
    fun validate(): Account = apply {
        if (validated) {
            return@apply
        }

        id()
        channels().ifPresent { it.validate() }
        createdAt()
        description()
        email()
        enableTemplateAutoCreationForSp()
        icon()
        name()
        organizationId()
        profiles().ifPresent { it.forEach { it.validate() } }
        sendingPhoneNumber()
        sendingPhoneNumberProfileId()
        settings().ifPresent { it.validate() }
        shortName()
        status()
        type()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (channels.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (enableTemplateAutoCreationForSp.asKnown().isPresent) 1 else 0) +
            (if (icon.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (organizationId.asKnown().isPresent) 1 else 0) +
            (profiles.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (sendingPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (sendingPhoneNumberProfileId.asKnown().isPresent) 1 else 0) +
            (settings.asKnown().getOrNull()?.validity() ?: 0) +
            (if (shortName.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Account &&
            id == other.id &&
            channels == other.channels &&
            createdAt == other.createdAt &&
            description == other.description &&
            email == other.email &&
            enableTemplateAutoCreationForSp == other.enableTemplateAutoCreationForSp &&
            icon == other.icon &&
            name == other.name &&
            organizationId == other.organizationId &&
            profiles == other.profiles &&
            sendingPhoneNumber == other.sendingPhoneNumber &&
            sendingPhoneNumberProfileId == other.sendingPhoneNumberProfileId &&
            settings == other.settings &&
            shortName == other.shortName &&
            status == other.status &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            channels,
            createdAt,
            description,
            email,
            enableTemplateAutoCreationForSp,
            icon,
            name,
            organizationId,
            profiles,
            sendingPhoneNumber,
            sendingPhoneNumberProfileId,
            settings,
            shortName,
            status,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Account{id=$id, channels=$channels, createdAt=$createdAt, description=$description, email=$email, enableTemplateAutoCreationForSp=$enableTemplateAutoCreationForSp, icon=$icon, name=$name, organizationId=$organizationId, profiles=$profiles, sendingPhoneNumber=$sendingPhoneNumber, sendingPhoneNumberProfileId=$sendingPhoneNumberProfileId, settings=$settings, shortName=$shortName, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
