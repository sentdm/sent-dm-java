// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.ChannelsState
import dm.sent.models.channels.sms.SuppliedCompliance
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A sender profile as the API reports it — the same document the create call accepts, plus the
 * read-only facts it cannot: each market's status and what it still owes.
 *
 * No status at the profile, brand or campaign level. Brand and campaign are identity, and identity
 * has no lifecycle. What has one is the registration of a sender in a market, and the approval of a
 * channel — so status lives there, where it says which specific thing is blocked rather than
 * flattening several answers into one.
 */
class SenderProfile
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val apiKey: JsonField<String>,
    private val billing: JsonField<SenderProfileBilling>,
    private val channels: JsonField<ChannelsState>,
    private val compliance: JsonField<SuppliedCompliance>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val description: JsonField<String>,
    private val name: JsonField<String>,
    private val notifications: JsonField<String>,
    private val organizationId: JsonField<String>,
    private val shortName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("api_key") @ExcludeMissing apiKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("billing")
        @ExcludeMissing
        billing: JsonField<SenderProfileBilling> = JsonMissing.of(),
        @JsonProperty("channels")
        @ExcludeMissing
        channels: JsonField<ChannelsState> = JsonMissing.of(),
        @JsonProperty("compliance")
        @ExcludeMissing
        compliance: JsonField<SuppliedCompliance> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("notifications")
        @ExcludeMissing
        notifications: JsonField<String> = JsonMissing.of(),
        @JsonProperty("organization_id")
        @ExcludeMissing
        organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("short_name") @ExcludeMissing shortName: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        apiKey,
        billing,
        channels,
        compliance,
        createdAt,
        description,
        name,
        notifications,
        organizationId,
        shortName,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * The API key for this profile.
     *
     * Returned by create and by nothing else. It is shown once; a read that repeated it would turn
     * every profile list into a credential dump and put the key into any log or cache that keeps a
     * response body.
     *
     * Omitted rather than null on a read. A key field that is always present and always empty
     * suggests it could be populated, which is an invitation to populate it; absent says there is
     * nothing to look for. Doing it with a serializer condition rather than a second response type
     * keeps create and read on one shape, which is what stops them drifting.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun apiKey(): Optional<String> = apiKey.getOptional("api_key")

    /**
     * Who pays for a sender profile's traffic, as a read reports it.
     *
     * Its own type, field for field the same as BillingRequest. Same reason as the brand: a
     * response is not a request, whatever it carries.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun billing(): Optional<SenderProfileBilling> = billing.getOptional("billing")

    /**
     * The channels a profile sends on. SMS is a list because a profile can send in several markets;
     * WhatsApp and RCS are single, because a profile has one business account and one agent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channels(): Optional<ChannelsState> = channels.getOptional("channels")

    /**
     * What a market has been given: the identity it registers under, its programme, and any
     * documents attached.
     *
     * What it does not carry is what the market asks for. That is the subject of GET
     * /v3/compliance/requirements, and it is the same answer for every caller — a description of
     * what a compliance regime wants, not a record of one customer's progress through it. It was
     * reported here as well for a while, which put the same array in six response shapes and left a
     * caller deciding which of two sources to believe.
     *
     * Present on a list read for markets that register (carrying brand and campaign), but with
     * documents absent — documents are not fetched for a list, because a catalog lookup and a
     * document read per market would multiply across a page. Absent documents is distinct from an
     * empty list: absent says they were not fetched; empty says the market has been given none. The
     * parent object is null only when the market registers with nobody and compliance was not
     * computed — nothing to show at all.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<SuppliedCompliance> = compliance.getOptional("compliance")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Who is notified about this profile's events: ORGANIZATION, SENDER_PROFILE, or
     * ORGANIZATION_AND_SENDER_PROFILE. Always present — a profile that never chose reports as
     * ORGANIZATION, the value a create would send to get the default behaviour.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun notifications(): Optional<String> = notifications.getOptional("notifications")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = organizationId.getOptional("organization_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun shortName(): Optional<String> = shortName.getOptional("short_name")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [apiKey].
     *
     * Unlike [apiKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("api_key") @ExcludeMissing fun _apiKey(): JsonField<String> = apiKey

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing")
    @ExcludeMissing
    fun _billing(): JsonField<SenderProfileBilling> = billing

    /**
     * Returns the raw JSON value of [channels].
     *
     * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channels") @ExcludeMissing fun _channels(): JsonField<ChannelsState> = channels

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compliance")
    @ExcludeMissing
    fun _compliance(): JsonField<SuppliedCompliance> = compliance

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
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [notifications].
     *
     * Unlike [notifications], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("notifications")
    @ExcludeMissing
    fun _notifications(): JsonField<String> = notifications

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("organization_id")
    @ExcludeMissing
    fun _organizationId(): JsonField<String> = organizationId

    /**
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("short_name") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

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

        /** Returns a mutable builder for constructing an instance of [SenderProfile]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfile]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var apiKey: JsonField<String> = JsonMissing.of()
        private var billing: JsonField<SenderProfileBilling> = JsonMissing.of()
        private var channels: JsonField<ChannelsState> = JsonMissing.of()
        private var compliance: JsonField<SuppliedCompliance> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var notifications: JsonField<String> = JsonMissing.of()
        private var organizationId: JsonField<String> = JsonMissing.of()
        private var shortName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfile: SenderProfile) = apply {
            id = senderProfile.id
            apiKey = senderProfile.apiKey
            billing = senderProfile.billing
            channels = senderProfile.channels
            compliance = senderProfile.compliance
            createdAt = senderProfile.createdAt
            description = senderProfile.description
            name = senderProfile.name
            notifications = senderProfile.notifications
            organizationId = senderProfile.organizationId
            shortName = senderProfile.shortName
            additionalProperties = senderProfile.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The API key for this profile.
         *
         * Returned by create and by nothing else. It is shown once; a read that repeated it would
         * turn every profile list into a credential dump and put the key into any log or cache that
         * keeps a response body.
         *
         * Omitted rather than null on a read. A key field that is always present and always empty
         * suggests it could be populated, which is an invitation to populate it; absent says there
         * is nothing to look for. Doing it with a serializer condition rather than a second
         * response type keeps create and read on one shape, which is what stops them drifting.
         */
        fun apiKey(apiKey: String?) = apiKey(JsonField.ofNullable(apiKey))

        /** Alias for calling [Builder.apiKey] with `apiKey.orElse(null)`. */
        fun apiKey(apiKey: Optional<String>) = apiKey(apiKey.getOrNull())

        /**
         * Sets [Builder.apiKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKey] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun apiKey(apiKey: JsonField<String>) = apply { this.apiKey = apiKey }

        /**
         * Who pays for a sender profile's traffic, as a read reports it.
         *
         * Its own type, field for field the same as BillingRequest. Same reason as the brand: a
         * response is not a request, whatever it carries.
         */
        fun billing(billing: SenderProfileBilling?) = billing(JsonField.ofNullable(billing))

        /** Alias for calling [Builder.billing] with `billing.orElse(null)`. */
        fun billing(billing: Optional<SenderProfileBilling>) = billing(billing.getOrNull())

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [SenderProfileBilling] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun billing(billing: JsonField<SenderProfileBilling>) = apply { this.billing = billing }

        /**
         * The channels a profile sends on. SMS is a list because a profile can send in several
         * markets; WhatsApp and RCS are single, because a profile has one business account and one
         * agent.
         */
        fun channels(channels: ChannelsState?) = channels(JsonField.ofNullable(channels))

        /** Alias for calling [Builder.channels] with `channels.orElse(null)`. */
        fun channels(channels: Optional<ChannelsState>) = channels(channels.getOrNull())

        /**
         * Sets [Builder.channels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channels] with a well-typed [ChannelsState] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun channels(channels: JsonField<ChannelsState>) = apply { this.channels = channels }

        /**
         * What a market has been given: the identity it registers under, its programme, and any
         * documents attached.
         *
         * What it does not carry is what the market asks for. That is the subject of GET
         * /v3/compliance/requirements, and it is the same answer for every caller — a description
         * of what a compliance regime wants, not a record of one customer's progress through it. It
         * was reported here as well for a while, which put the same array in six response shapes
         * and left a caller deciding which of two sources to believe.
         *
         * Present on a list read for markets that register (carrying brand and campaign), but with
         * documents absent — documents are not fetched for a list, because a catalog lookup and a
         * document read per market would multiply across a page. Absent documents is distinct from
         * an empty list: absent says they were not fetched; empty says the market has been given
         * none. The parent object is null only when the market registers with nobody and compliance
         * was not computed — nothing to show at all.
         */
        fun compliance(compliance: SuppliedCompliance?) =
            compliance(JsonField.ofNullable(compliance))

        /** Alias for calling [Builder.compliance] with `compliance.orElse(null)`. */
        fun compliance(compliance: Optional<SuppliedCompliance>) =
            compliance(compliance.getOrNull())

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [SuppliedCompliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<SuppliedCompliance>) = apply {
            this.compliance = compliance
        }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

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

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Who is notified about this profile's events: ORGANIZATION, SENDER_PROFILE, or
         * ORGANIZATION_AND_SENDER_PROFILE. Always present — a profile that never chose reports as
         * ORGANIZATION, the value a create would send to get the default behaviour.
         */
        fun notifications(notifications: String?) =
            notifications(JsonField.ofNullable(notifications))

        /** Alias for calling [Builder.notifications] with `notifications.orElse(null)`. */
        fun notifications(notifications: Optional<String>) =
            notifications(notifications.getOrNull())

        /**
         * Sets [Builder.notifications] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notifications] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun notifications(notifications: JsonField<String>) = apply {
            this.notifications = notifications
        }

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
         * Returns an immutable instance of [SenderProfile].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfile =
            SenderProfile(
                id,
                apiKey,
                billing,
                channels,
                compliance,
                createdAt,
                description,
                name,
                notifications,
                organizationId,
                shortName,
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
    fun validate(): SenderProfile = apply {
        if (validated) {
            return@apply
        }

        id()
        apiKey()
        billing().ifPresent { it.validate() }
        channels().ifPresent { it.validate() }
        compliance().ifPresent { it.validate() }
        createdAt()
        description()
        name()
        notifications()
        organizationId()
        shortName()
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
            (if (apiKey.asKnown().isPresent) 1 else 0) +
            (billing.asKnown().getOrNull()?.validity() ?: 0) +
            (channels.asKnown().getOrNull()?.validity() ?: 0) +
            (compliance.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (notifications.asKnown().isPresent) 1 else 0) +
            (if (organizationId.asKnown().isPresent) 1 else 0) +
            (if (shortName.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfile &&
            id == other.id &&
            apiKey == other.apiKey &&
            billing == other.billing &&
            channels == other.channels &&
            compliance == other.compliance &&
            createdAt == other.createdAt &&
            description == other.description &&
            name == other.name &&
            notifications == other.notifications &&
            organizationId == other.organizationId &&
            shortName == other.shortName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            apiKey,
            billing,
            channels,
            compliance,
            createdAt,
            description,
            name,
            notifications,
            organizationId,
            shortName,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfile{id=$id, apiKey=$apiKey, billing=$billing, channels=$channels, compliance=$compliance, createdAt=$createdAt, description=$description, name=$name, notifications=$notifications, organizationId=$organizationId, shortName=$shortName, additionalProperties=$additionalProperties}"
}
