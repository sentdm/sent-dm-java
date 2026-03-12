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
import dm.sent.errors.SentDmInvalidDataException
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class MeRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<ApiError>,
    private val meta: JsonField<ApiMeta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<ApiError> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<ApiMeta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * Account response for GET /v3/me endpoint. Returns organization (with profiles), user
     * (standalone), or profile (child of an organization) data depending on the API key type.
     * Always includes messaging channel configuration.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error information
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<ApiError> = error.getOptional("error")

    /**
     * Request and response metadata
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun meta(): Optional<ApiMeta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun success(): Optional<Boolean> = success.getOptional("success")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ApiError> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<ApiMeta> = meta

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

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

        /** Returns a mutable builder for constructing an instance of [MeRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MeRetrieveResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<ApiError> = JsonMissing.of()
        private var meta: JsonField<ApiMeta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(meRetrieveResponse: MeRetrieveResponse) = apply {
            data = meRetrieveResponse.data
            error = meRetrieveResponse.error
            meta = meRetrieveResponse.meta
            success = meRetrieveResponse.success
            additionalProperties = meRetrieveResponse.additionalProperties.toMutableMap()
        }

        /**
         * Account response for GET /v3/me endpoint. Returns organization (with profiles), user
         * (standalone), or profile (child of an organization) data depending on the API key type.
         * Always includes messaging channel configuration.
         */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Error information */
        fun error(error: ApiError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ApiError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [ApiError] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<ApiError>) = apply { this.error = error }

        /** Request and response metadata */
        fun meta(meta: ApiMeta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [ApiMeta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<ApiMeta>) = apply { this.meta = meta }

        /** Indicates whether the request was successful */
        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

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
         * Returns an immutable instance of [MeRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MeRetrieveResponse =
            MeRetrieveResponse(data, error, meta, success, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): MeRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        data().ifPresent { it.validate() }
        error().ifPresent { it.validate() }
        meta().ifPresent { it.validate() }
        success()
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    /**
     * Account response for GET /v3/me endpoint. Returns organization (with profiles), user
     * (standalone), or profile (child of an organization) data depending on the API key type.
     * Always includes messaging channel configuration.
     */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val channels: JsonField<Channels>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val description: JsonField<String>,
        private val email: JsonField<String>,
        private val icon: JsonField<String>,
        private val name: JsonField<String>,
        private val organizationId: JsonField<String>,
        private val profiles: JsonField<List<Profile>>,
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
            channels: JsonField<Channels> = JsonMissing.of(),
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
            @JsonProperty("profiles")
            @ExcludeMissing
            profiles: JsonField<List<Profile>> = JsonMissing.of(),
            @JsonProperty("settings")
            @ExcludeMissing
            settings: JsonField<ProfileSettings> = JsonMissing.of(),
            @JsonProperty("short_name")
            @ExcludeMissing
            shortName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            channels,
            createdAt,
            description,
            email,
            icon,
            name,
            organizationId,
            profiles,
            settings,
            shortName,
            status,
            type,
            mutableMapOf(),
        )

        /**
         * Customer ID (organization, account, or profile)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Messaging channel configuration. All three channels are always present. Each channel has
         * a "configured" flag; configured channels expose additional details.
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channels(): Optional<Channels> = channels.getOptional("channels")

        /**
         * When the account was created
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

        /**
         * Account description
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Contact email address
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * Account icon URL
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun icon(): Optional<String> = icon.getOptional("icon")

        /**
         * Account name
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Organization ID (only for profile type — the parent organization)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun organizationId(): Optional<String> = organizationId.getOptional("organization_id")

        /**
         * List of profiles (populated for organization type, empty for user and profile types)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun profiles(): Optional<List<Profile>> = profiles.getOptional("profiles")

        /**
         * Profile configuration settings
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun settings(): Optional<ProfileSettings> = settings.getOptional("settings")

        /**
         * Short name / abbreviation (only for profile type)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortName(): Optional<String> = shortName.getOptional("short_name")

        /**
         * Profile status (only for profile type): incomplete, pending_review, approved, etc.
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<String> = status.getOptional("status")

        /**
         * Account type: "organization" (has profiles), "user" (no profiles), or "profile" (child of
         * an organization)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
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
        @JsonProperty("channels") @ExcludeMissing fun _channels(): JsonField<Channels> = channels

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
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

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
         * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected
         * type.
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
        fun _profiles(): JsonField<List<Profile>> = profiles

        /**
         * Returns the raw JSON value of [settings].
         *
         * Unlike [settings], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("settings")
        @ExcludeMissing
        fun _settings(): JsonField<ProfileSettings> = settings

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var channels: JsonField<Channels> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var icon: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var organizationId: JsonField<String> = JsonMissing.of()
            private var profiles: JsonField<MutableList<Profile>>? = null
            private var settings: JsonField<ProfileSettings> = JsonMissing.of()
            private var shortName: JsonField<String> = JsonMissing.of()
            private var status: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                channels = data.channels
                createdAt = data.createdAt
                description = data.description
                email = data.email
                icon = data.icon
                name = data.name
                organizationId = data.organizationId
                profiles = data.profiles.map { it.toMutableList() }
                settings = data.settings
                shortName = data.shortName
                status = data.status
                type = data.type
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** Customer ID (organization, account, or profile) */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * Messaging channel configuration. All three channels are always present. Each channel
             * has a "configured" flag; configured channels expose additional details.
             */
            fun channels(channels: Channels) = channels(JsonField.of(channels))

            /**
             * Sets [Builder.channels] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channels] with a well-typed [Channels] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channels(channels: JsonField<Channels>) = apply { this.channels = channels }

            /** When the account was created */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** Account description */
            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

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

            /** Account icon URL */
            fun icon(icon: String?) = icon(JsonField.ofNullable(icon))

            /** Alias for calling [Builder.icon] with `icon.orElse(null)`. */
            fun icon(icon: Optional<String>) = icon(icon.getOrNull())

            /**
             * Sets [Builder.icon] to an arbitrary JSON value.
             *
             * You should usually call [Builder.icon] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun icon(icon: JsonField<String>) = apply { this.icon = icon }

            /** Account name */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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

            /**
             * List of profiles (populated for organization type, empty for user and profile types)
             */
            fun profiles(profiles: List<Profile>) = profiles(JsonField.of(profiles))

            /**
             * Sets [Builder.profiles] to an arbitrary JSON value.
             *
             * You should usually call [Builder.profiles] with a well-typed `List<Profile>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun profiles(profiles: JsonField<List<Profile>>) = apply {
                this.profiles = profiles.map { it.toMutableList() }
            }

            /**
             * Adds a single [Profile] to [profiles].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addProfile(profile: Profile) = apply {
                profiles =
                    (profiles ?: JsonField.of(mutableListOf())).also {
                        checkKnown("profiles", it).add(profile)
                    }
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
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

            /**
             * Profile status (only for profile type): incomplete, pending_review, approved, etc.
             */
            fun status(status: String?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<String>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            /**
             * Account type: "organization" (has profiles), "user" (no profiles), or "profile"
             * (child of an organization)
             */
            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    id,
                    channels,
                    createdAt,
                    description,
                    email,
                    icon,
                    name,
                    organizationId,
                    (profiles ?: JsonMissing.of()).map { it.toImmutable() },
                    settings,
                    shortName,
                    status,
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            channels().ifPresent { it.validate() }
            createdAt()
            description()
            email()
            icon()
            name()
            organizationId()
            profiles().ifPresent { it.forEach { it.validate() } }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (channels.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (icon.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (organizationId.asKnown().isPresent) 1 else 0) +
                (profiles.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (settings.asKnown().getOrNull()?.validity() ?: 0) +
                (if (shortName.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0)

        /**
         * Messaging channel configuration. All three channels are always present. Each channel has
         * a "configured" flag; configured channels expose additional details.
         */
        class Channels
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val rcs: JsonField<Rcs>,
            private val sms: JsonField<Sms>,
            private val whatsapp: JsonField<Whatsapp>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("rcs") @ExcludeMissing rcs: JsonField<Rcs> = JsonMissing.of(),
                @JsonProperty("sms") @ExcludeMissing sms: JsonField<Sms> = JsonMissing.of(),
                @JsonProperty("whatsapp")
                @ExcludeMissing
                whatsapp: JsonField<Whatsapp> = JsonMissing.of(),
            ) : this(rcs, sms, whatsapp, mutableMapOf())

            /**
             * RCS channel configuration. When configured, includes the RCS phone number.
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun rcs(): Optional<Rcs> = rcs.getOptional("rcs")

            /**
             * SMS channel configuration. When configured, includes the sending phone number.
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun sms(): Optional<Sms> = sms.getOptional("sms")

            /**
             * WhatsApp Business channel configuration. When configured, includes the WhatsApp phone
             * number and business name.
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun whatsapp(): Optional<Whatsapp> = whatsapp.getOptional("whatsapp")

            /**
             * Returns the raw JSON value of [rcs].
             *
             * Unlike [rcs], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("rcs") @ExcludeMissing fun _rcs(): JsonField<Rcs> = rcs

            /**
             * Returns the raw JSON value of [sms].
             *
             * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<Sms> = sms

            /**
             * Returns the raw JSON value of [whatsapp].
             *
             * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("whatsapp")
            @ExcludeMissing
            fun _whatsapp(): JsonField<Whatsapp> = whatsapp

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

                /** Returns a mutable builder for constructing an instance of [Channels]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Channels]. */
            class Builder internal constructor() {

                private var rcs: JsonField<Rcs> = JsonMissing.of()
                private var sms: JsonField<Sms> = JsonMissing.of()
                private var whatsapp: JsonField<Whatsapp> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(channels: Channels) = apply {
                    rcs = channels.rcs
                    sms = channels.sms
                    whatsapp = channels.whatsapp
                    additionalProperties = channels.additionalProperties.toMutableMap()
                }

                /** RCS channel configuration. When configured, includes the RCS phone number. */
                fun rcs(rcs: Rcs) = rcs(JsonField.of(rcs))

                /**
                 * Sets [Builder.rcs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.rcs] with a well-typed [Rcs] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun rcs(rcs: JsonField<Rcs>) = apply { this.rcs = rcs }

                /**
                 * SMS channel configuration. When configured, includes the sending phone number.
                 */
                fun sms(sms: Sms) = sms(JsonField.of(sms))

                /**
                 * Sets [Builder.sms] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sms] with a well-typed [Sms] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun sms(sms: JsonField<Sms>) = apply { this.sms = sms }

                /**
                 * WhatsApp Business channel configuration. When configured, includes the WhatsApp
                 * phone number and business name.
                 */
                fun whatsapp(whatsapp: Whatsapp) = whatsapp(JsonField.of(whatsapp))

                /**
                 * Sets [Builder.whatsapp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.whatsapp] with a well-typed [Whatsapp] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun whatsapp(whatsapp: JsonField<Whatsapp>) = apply { this.whatsapp = whatsapp }

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
                 * Returns an immutable instance of [Channels].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Channels =
                    Channels(rcs, sms, whatsapp, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Channels = apply {
                if (validated) {
                    return@apply
                }

                rcs().ifPresent { it.validate() }
                sms().ifPresent { it.validate() }
                whatsapp().ifPresent { it.validate() }
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
                (rcs.asKnown().getOrNull()?.validity() ?: 0) +
                    (sms.asKnown().getOrNull()?.validity() ?: 0) +
                    (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

            /** RCS channel configuration. When configured, includes the RCS phone number. */
            class Rcs
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val configured: JsonField<Boolean>,
                private val phoneNumber: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("configured")
                    @ExcludeMissing
                    configured: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("phone_number")
                    @ExcludeMissing
                    phoneNumber: JsonField<String> = JsonMissing.of(),
                ) : this(configured, phoneNumber, mutableMapOf())

                /**
                 * Whether RCS is configured for this account
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun configured(): Optional<Boolean> = configured.getOptional("configured")

                /**
                 * RCS-enabled phone number in E.164 format
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

                /**
                 * Returns the raw JSON value of [configured].
                 *
                 * Unlike [configured], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("configured")
                @ExcludeMissing
                fun _configured(): JsonField<Boolean> = configured

                /**
                 * Returns the raw JSON value of [phoneNumber].
                 *
                 * Unlike [phoneNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("phone_number")
                @ExcludeMissing
                fun _phoneNumber(): JsonField<String> = phoneNumber

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

                    /** Returns a mutable builder for constructing an instance of [Rcs]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Rcs]. */
                class Builder internal constructor() {

                    private var configured: JsonField<Boolean> = JsonMissing.of()
                    private var phoneNumber: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(rcs: Rcs) = apply {
                        configured = rcs.configured
                        phoneNumber = rcs.phoneNumber
                        additionalProperties = rcs.additionalProperties.toMutableMap()
                    }

                    /** Whether RCS is configured for this account */
                    fun configured(configured: Boolean) = configured(JsonField.of(configured))

                    /**
                     * Sets [Builder.configured] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.configured] with a well-typed [Boolean]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun configured(configured: JsonField<Boolean>) = apply {
                        this.configured = configured
                    }

                    /** RCS-enabled phone number in E.164 format */
                    fun phoneNumber(phoneNumber: String?) =
                        phoneNumber(JsonField.ofNullable(phoneNumber))

                    /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
                    fun phoneNumber(phoneNumber: Optional<String>) =
                        phoneNumber(phoneNumber.getOrNull())

                    /**
                     * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.phoneNumber] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                        this.phoneNumber = phoneNumber
                    }

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
                     * Returns an immutable instance of [Rcs].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Rcs =
                        Rcs(configured, phoneNumber, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Rcs = apply {
                    if (validated) {
                        return@apply
                    }

                    configured()
                    phoneNumber()
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
                    (if (configured.asKnown().isPresent) 1 else 0) +
                        (if (phoneNumber.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Rcs &&
                        configured == other.configured &&
                        phoneNumber == other.phoneNumber &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(configured, phoneNumber, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Rcs{configured=$configured, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"
            }

            /** SMS channel configuration. When configured, includes the sending phone number. */
            class Sms
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val configured: JsonField<Boolean>,
                private val phoneNumber: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("configured")
                    @ExcludeMissing
                    configured: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("phone_number")
                    @ExcludeMissing
                    phoneNumber: JsonField<String> = JsonMissing.of(),
                ) : this(configured, phoneNumber, mutableMapOf())

                /**
                 * Whether SMS is configured for this account
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun configured(): Optional<Boolean> = configured.getOptional("configured")

                /**
                 * Sending phone number in E.164 format
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

                /**
                 * Returns the raw JSON value of [configured].
                 *
                 * Unlike [configured], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("configured")
                @ExcludeMissing
                fun _configured(): JsonField<Boolean> = configured

                /**
                 * Returns the raw JSON value of [phoneNumber].
                 *
                 * Unlike [phoneNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("phone_number")
                @ExcludeMissing
                fun _phoneNumber(): JsonField<String> = phoneNumber

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

                    /** Returns a mutable builder for constructing an instance of [Sms]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Sms]. */
                class Builder internal constructor() {

                    private var configured: JsonField<Boolean> = JsonMissing.of()
                    private var phoneNumber: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(sms: Sms) = apply {
                        configured = sms.configured
                        phoneNumber = sms.phoneNumber
                        additionalProperties = sms.additionalProperties.toMutableMap()
                    }

                    /** Whether SMS is configured for this account */
                    fun configured(configured: Boolean) = configured(JsonField.of(configured))

                    /**
                     * Sets [Builder.configured] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.configured] with a well-typed [Boolean]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun configured(configured: JsonField<Boolean>) = apply {
                        this.configured = configured
                    }

                    /** Sending phone number in E.164 format */
                    fun phoneNumber(phoneNumber: String?) =
                        phoneNumber(JsonField.ofNullable(phoneNumber))

                    /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
                    fun phoneNumber(phoneNumber: Optional<String>) =
                        phoneNumber(phoneNumber.getOrNull())

                    /**
                     * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.phoneNumber] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                        this.phoneNumber = phoneNumber
                    }

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
                     * Returns an immutable instance of [Sms].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Sms =
                        Sms(configured, phoneNumber, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Sms = apply {
                    if (validated) {
                        return@apply
                    }

                    configured()
                    phoneNumber()
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
                    (if (configured.asKnown().isPresent) 1 else 0) +
                        (if (phoneNumber.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Sms &&
                        configured == other.configured &&
                        phoneNumber == other.phoneNumber &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(configured, phoneNumber, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Sms{configured=$configured, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"
            }

            /**
             * WhatsApp Business channel configuration. When configured, includes the WhatsApp phone
             * number and business name.
             */
            class Whatsapp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val businessName: JsonField<String>,
                private val configured: JsonField<Boolean>,
                private val phoneNumber: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("business_name")
                    @ExcludeMissing
                    businessName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("configured")
                    @ExcludeMissing
                    configured: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("phone_number")
                    @ExcludeMissing
                    phoneNumber: JsonField<String> = JsonMissing.of(),
                ) : this(businessName, configured, phoneNumber, mutableMapOf())

                /**
                 * WhatsApp Business display name
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun businessName(): Optional<String> = businessName.getOptional("business_name")

                /**
                 * Whether WhatsApp is configured for this account
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun configured(): Optional<Boolean> = configured.getOptional("configured")

                /**
                 * WhatsApp phone number in E.164 format
                 *
                 * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

                /**
                 * Returns the raw JSON value of [businessName].
                 *
                 * Unlike [businessName], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("business_name")
                @ExcludeMissing
                fun _businessName(): JsonField<String> = businessName

                /**
                 * Returns the raw JSON value of [configured].
                 *
                 * Unlike [configured], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("configured")
                @ExcludeMissing
                fun _configured(): JsonField<Boolean> = configured

                /**
                 * Returns the raw JSON value of [phoneNumber].
                 *
                 * Unlike [phoneNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("phone_number")
                @ExcludeMissing
                fun _phoneNumber(): JsonField<String> = phoneNumber

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

                    /** Returns a mutable builder for constructing an instance of [Whatsapp]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Whatsapp]. */
                class Builder internal constructor() {

                    private var businessName: JsonField<String> = JsonMissing.of()
                    private var configured: JsonField<Boolean> = JsonMissing.of()
                    private var phoneNumber: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(whatsapp: Whatsapp) = apply {
                        businessName = whatsapp.businessName
                        configured = whatsapp.configured
                        phoneNumber = whatsapp.phoneNumber
                        additionalProperties = whatsapp.additionalProperties.toMutableMap()
                    }

                    /** WhatsApp Business display name */
                    fun businessName(businessName: String?) =
                        businessName(JsonField.ofNullable(businessName))

                    /**
                     * Alias for calling [Builder.businessName] with `businessName.orElse(null)`.
                     */
                    fun businessName(businessName: Optional<String>) =
                        businessName(businessName.getOrNull())

                    /**
                     * Sets [Builder.businessName] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.businessName] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun businessName(businessName: JsonField<String>) = apply {
                        this.businessName = businessName
                    }

                    /** Whether WhatsApp is configured for this account */
                    fun configured(configured: Boolean) = configured(JsonField.of(configured))

                    /**
                     * Sets [Builder.configured] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.configured] with a well-typed [Boolean]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun configured(configured: JsonField<Boolean>) = apply {
                        this.configured = configured
                    }

                    /** WhatsApp phone number in E.164 format */
                    fun phoneNumber(phoneNumber: String?) =
                        phoneNumber(JsonField.ofNullable(phoneNumber))

                    /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
                    fun phoneNumber(phoneNumber: Optional<String>) =
                        phoneNumber(phoneNumber.getOrNull())

                    /**
                     * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.phoneNumber] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                        this.phoneNumber = phoneNumber
                    }

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
                     * Returns an immutable instance of [Whatsapp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Whatsapp =
                        Whatsapp(
                            businessName,
                            configured,
                            phoneNumber,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Whatsapp = apply {
                    if (validated) {
                        return@apply
                    }

                    businessName()
                    configured()
                    phoneNumber()
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
                    (if (businessName.asKnown().isPresent) 1 else 0) +
                        (if (configured.asKnown().isPresent) 1 else 0) +
                        (if (phoneNumber.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Whatsapp &&
                        businessName == other.businessName &&
                        configured == other.configured &&
                        phoneNumber == other.phoneNumber &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(businessName, configured, phoneNumber, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Whatsapp{businessName=$businessName, configured=$configured, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Channels &&
                    rcs == other.rcs &&
                    sms == other.sms &&
                    whatsapp == other.whatsapp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(rcs, sms, whatsapp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Channels{rcs=$rcs, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
        }

        /** Profile (sender profile) response for v3 API */
        class Profile
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val description: JsonField<String>,
            private val icon: JsonField<String>,
            private val name: JsonField<String>,
            private val role: JsonField<String>,
            private val settings: JsonField<ProfileSettings>,
            private val shortName: JsonField<String>,
            private val status: JsonField<String>,
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
                @JsonProperty("icon") @ExcludeMissing icon: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
                @JsonProperty("settings")
                @ExcludeMissing
                settings: JsonField<ProfileSettings> = JsonMissing.of(),
                @JsonProperty("short_name")
                @ExcludeMissing
                shortName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                createdAt,
                description,
                icon,
                name,
                role,
                settings,
                shortName,
                status,
                mutableMapOf(),
            )

            /**
             * Profile unique identifier
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * When the profile was created
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

            /**
             * Profile description
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Profile icon URL
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun icon(): Optional<String> = icon.getOptional("icon")

            /**
             * Profile name
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * User's role in this profile: admin, billing, developer (inherited from organization
             * if not explicitly set)
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Profile configuration settings
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun settings(): Optional<ProfileSettings> = settings.getOptional("settings")

            /**
             * Profile short name (abbreviation)
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun shortName(): Optional<String> = shortName.getOptional("short_name")

            /**
             * Profile setup status: incomplete, pending_review, approved, rejected
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun status(): Optional<String> = status.getOptional("status")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

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
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

            /**
             * Returns the raw JSON value of [settings].
             *
             * Unlike [settings], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("settings")
            @ExcludeMissing
            fun _settings(): JsonField<ProfileSettings> = settings

            /**
             * Returns the raw JSON value of [shortName].
             *
             * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("short_name")
            @ExcludeMissing
            fun _shortName(): JsonField<String> = shortName

            /**
             * Returns the raw JSON value of [status].
             *
             * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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

                /** Returns a mutable builder for constructing an instance of [Profile]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Profile]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var icon: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var role: JsonField<String> = JsonMissing.of()
                private var settings: JsonField<ProfileSettings> = JsonMissing.of()
                private var shortName: JsonField<String> = JsonMissing.of()
                private var status: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(profile: Profile) = apply {
                    id = profile.id
                    createdAt = profile.createdAt
                    description = profile.description
                    icon = profile.icon
                    name = profile.name
                    role = profile.role
                    settings = profile.settings
                    shortName = profile.shortName
                    status = profile.status
                    additionalProperties = profile.additionalProperties.toMutableMap()
                }

                /** Profile unique identifier */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** When the profile was created */
                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                /** Profile description */
                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** Profile icon URL */
                fun icon(icon: String?) = icon(JsonField.ofNullable(icon))

                /** Alias for calling [Builder.icon] with `icon.orElse(null)`. */
                fun icon(icon: Optional<String>) = icon(icon.getOrNull())

                /**
                 * Sets [Builder.icon] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.icon] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun icon(icon: JsonField<String>) = apply { this.icon = icon }

                /** Profile name */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * User's role in this profile: admin, billing, developer (inherited from
                 * organization if not explicitly set)
                 */
                fun role(role: String?) = role(JsonField.ofNullable(role))

                /** Alias for calling [Builder.role] with `role.orElse(null)`. */
                fun role(role: Optional<String>) = role(role.getOrNull())

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

                /** Profile configuration settings */
                fun settings(settings: ProfileSettings) = settings(JsonField.of(settings))

                /**
                 * Sets [Builder.settings] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.settings] with a well-typed [ProfileSettings]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun settings(settings: JsonField<ProfileSettings>) = apply {
                    this.settings = settings
                }

                /** Profile short name (abbreviation) */
                fun shortName(shortName: String?) = shortName(JsonField.ofNullable(shortName))

                /** Alias for calling [Builder.shortName] with `shortName.orElse(null)`. */
                fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

                /**
                 * Sets [Builder.shortName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.shortName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

                /** Profile setup status: incomplete, pending_review, approved, rejected */
                fun status(status: String?) = status(JsonField.ofNullable(status))

                /** Alias for calling [Builder.status] with `status.orElse(null)`. */
                fun status(status: Optional<String>) = status(status.getOrNull())

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<String>) = apply { this.status = status }

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
                 * Returns an immutable instance of [Profile].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Profile =
                    Profile(
                        id,
                        createdAt,
                        description,
                        icon,
                        name,
                        role,
                        settings,
                        shortName,
                        status,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Profile = apply {
                if (validated) {
                    return@apply
                }

                id()
                createdAt()
                description()
                icon()
                name()
                role()
                settings().ifPresent { it.validate() }
                shortName()
                status()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (icon.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (role.asKnown().isPresent) 1 else 0) +
                    (settings.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (shortName.asKnown().isPresent) 1 else 0) +
                    (if (status.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Profile &&
                    id == other.id &&
                    createdAt == other.createdAt &&
                    description == other.description &&
                    icon == other.icon &&
                    name == other.name &&
                    role == other.role &&
                    settings == other.settings &&
                    shortName == other.shortName &&
                    status == other.status &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    createdAt,
                    description,
                    icon,
                    name,
                    role,
                    settings,
                    shortName,
                    status,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Profile{id=$id, createdAt=$createdAt, description=$description, icon=$icon, name=$name, role=$role, settings=$settings, shortName=$shortName, status=$status, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                channels == other.channels &&
                createdAt == other.createdAt &&
                description == other.description &&
                email == other.email &&
                icon == other.icon &&
                name == other.name &&
                organizationId == other.organizationId &&
                profiles == other.profiles &&
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
                icon,
                name,
                organizationId,
                profiles,
                settings,
                shortName,
                status,
                type,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, channels=$channels, createdAt=$createdAt, description=$description, email=$email, icon=$icon, name=$name, organizationId=$organizationId, profiles=$profiles, settings=$settings, shortName=$shortName, status=$status, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MeRetrieveResponse &&
            data == other.data &&
            error == other.error &&
            meta == other.meta &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, error, meta, success, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MeRetrieveResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
