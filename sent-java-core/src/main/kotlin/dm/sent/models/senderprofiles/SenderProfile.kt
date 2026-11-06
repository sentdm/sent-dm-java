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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.ChannelsState
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
    private val compliance: JsonField<Compliance>,
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
        compliance: JsonField<Compliance> = JsonMissing.of(),
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
    fun compliance(): Optional<Compliance> = compliance.getOptional("compliance")

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
    fun _compliance(): JsonField<Compliance> = compliance

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
        private var compliance: JsonField<Compliance> = JsonMissing.of()
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
        fun compliance(compliance: Compliance?) = compliance(JsonField.ofNullable(compliance))

        /** Alias for calling [Builder.compliance] with `compliance.orElse(null)`. */
        fun compliance(compliance: Optional<Compliance>) = compliance(compliance.getOrNull())

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [Compliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<Compliance>) = apply { this.compliance = compliance }

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
     */
    class Compliance
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val brand: JsonField<Brand>,
        private val campaign: JsonField<Campaign>,
        private val documents: JsonField<List<Document>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("brand") @ExcludeMissing brand: JsonField<Brand> = JsonMissing.of(),
            @JsonProperty("campaign")
            @ExcludeMissing
            campaign: JsonField<Campaign> = JsonMissing.of(),
            @JsonProperty("documents")
            @ExcludeMissing
            documents: JsonField<List<Document>> = JsonMissing.of(),
        ) : this(brand, campaign, documents, mutableMapOf())

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brand(): Optional<Brand> = brand.getOptional("brand")

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun campaign(): Optional<Campaign> = campaign.getOptional("campaign")

        /**
         * What has been supplied for this market.
         *
         * Files, not values — the declared halves above carry the values. A document cannot be a
         * JSON value, so it is sent as multipart on the channel call and reported here as a
         * reference.
         *
         * Absent on a list read, which fetches identity but does not compute compliance documents
         * per market. Absent and empty mean different things: absent says the documents were not
         * fetched; empty says the market has been given none.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun documents(): Optional<List<Document>> = documents.getOptional("documents")

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

        /**
         * Returns the raw JSON value of [documents].
         *
         * Unlike [documents], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("documents")
        @ExcludeMissing
        fun _documents(): JsonField<List<Document>> = documents

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

            /** Returns a mutable builder for constructing an instance of [Compliance]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Compliance]. */
        class Builder internal constructor() {

            private var brand: JsonField<Brand> = JsonMissing.of()
            private var campaign: JsonField<Campaign> = JsonMissing.of()
            private var documents: JsonField<MutableList<Document>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(compliance: Compliance) = apply {
                brand = compliance.brand
                campaign = compliance.campaign
                documents = compliance.documents.map { it.toMutableList() }
                additionalProperties = compliance.additionalProperties.toMutableMap()
            }

            /**
             * The identity this market registers under, with inherit saying whose it is.
             *
             * Reported here rather than on the profile because it belongs to the registration this
             * market files, and only one market files one. It was a top-level block for a while,
             * which put a per-registration value beside a list of markets and left a caller to work
             * out which market it belonged to.
             *
             * Absent for a market that registers with nobody — such a market asks for no identity,
             * so there is none to report. Absent and null mean different things: absent says this
             * market does not ask, null would say it asks and nothing was supplied.
             *
             * Untyped, like the request side, because its members are declared by the market's own
             * schema rather than by a C# class. A typed pair here would be a second definition of
             * what a market wants, free to drift from the one that validates.
             */
            fun brand(brand: Brand?) = brand(JsonField.ofNullable(brand))

            /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
            fun brand(brand: Optional<Brand>) = brand(brand.getOrNull())

            /**
             * Sets [Builder.brand] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun brand(brand: JsonField<Brand>) = apply { this.brand = brand }

            /**
             * The programme this market registers, with inherit saying whose it is.
             *
             * One, not a list. TcrCampaigns permits several and an account built on the admin side
             * may hold them, but this surface offers one — which is what lets the market's PATCH be
             * an upsert rather than a collection with an addressable create behind it. An account
             * holding several is reported as its first and refused on write, rather than
             * half-edited.
             *
             * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused
             * if the caller sent this object back — which it is meant to be able to do.
             */
            fun campaign(campaign: Campaign?) = campaign(JsonField.ofNullable(campaign))

            /** Alias for calling [Builder.campaign] with `campaign.orElse(null)`. */
            fun campaign(campaign: Optional<Campaign>) = campaign(campaign.getOrNull())

            /**
             * Sets [Builder.campaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaign] with a well-typed [Campaign] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaign(campaign: JsonField<Campaign>) = apply { this.campaign = campaign }

            /**
             * What has been supplied for this market.
             *
             * Files, not values — the declared halves above carry the values. A document cannot be
             * a JSON value, so it is sent as multipart on the channel call and reported here as a
             * reference.
             *
             * Absent on a list read, which fetches identity but does not compute compliance
             * documents per market. Absent and empty mean different things: absent says the
             * documents were not fetched; empty says the market has been given none.
             */
            fun documents(documents: List<Document>?) = documents(JsonField.ofNullable(documents))

            /** Alias for calling [Builder.documents] with `documents.orElse(null)`. */
            fun documents(documents: Optional<List<Document>>) = documents(documents.getOrNull())

            /**
             * Sets [Builder.documents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.documents] with a well-typed `List<Document>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun documents(documents: JsonField<List<Document>>) = apply {
                this.documents = documents.map { it.toMutableList() }
            }

            /**
             * Adds a single [Document] to [documents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDocument(document: Document) = apply {
                documents =
                    (documents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("documents", it).add(document)
                    }
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
             */
            fun build(): Compliance =
                Compliance(
                    brand,
                    campaign,
                    (documents ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Compliance = apply {
            if (validated) {
                return@apply
            }

            brand().ifPresent { it.validate() }
            campaign().ifPresent { it.validate() }
            documents().ifPresent { it.forEach { it.validate() } }
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
            (brand.asKnown().getOrNull()?.validity() ?: 0) +
                (campaign.asKnown().getOrNull()?.validity() ?: 0) +
                (documents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         */
        class Brand
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Brand]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Brand]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(brand: Brand) = apply {
                    additionalProperties = brand.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Brand].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Brand = Brand(additionalProperties.toImmutable())
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
            fun validate(): Brand = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Brand && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Brand{additionalProperties=$additionalProperties}"
        }

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         */
        class Campaign
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Campaign]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Campaign]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(campaign: Campaign) = apply {
                    additionalProperties = campaign.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Campaign].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Campaign = Campaign(additionalProperties.toImmutable())
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
            fun validate(): Campaign = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Campaign && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Campaign{additionalProperties=$additionalProperties}"
        }

        /** A document a market asked for and has been given. */
        class Document
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val documentId: JsonField<String>,
            private val fileName: JsonField<String>,
            private val key: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("document_id")
                @ExcludeMissing
                documentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("file_name")
                @ExcludeMissing
                fileName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            ) : this(documentId, fileName, key, mutableMapOf())

            /**
             * Identifier of the upload, for fetching it back through the documents endpoints.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun documentId(): Optional<String> = documentId.getOptional("document_id")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileName(): Optional<String> = fileName.getOptional("file_name")

            /**
             * The catalog's name for this document, matching the requirement it satisfies.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun key(): Optional<String> = key.getOptional("key")

            /**
             * Returns the raw JSON value of [documentId].
             *
             * Unlike [documentId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("document_id")
            @ExcludeMissing
            fun _documentId(): JsonField<String> = documentId

            /**
             * Returns the raw JSON value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * Returns the raw JSON value of [key].
             *
             * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

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

                /** Returns a mutable builder for constructing an instance of [Document]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Document]. */
            class Builder internal constructor() {

                private var documentId: JsonField<String> = JsonMissing.of()
                private var fileName: JsonField<String> = JsonMissing.of()
                private var key: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(document: Document) = apply {
                    documentId = document.documentId
                    fileName = document.fileName
                    key = document.key
                    additionalProperties = document.additionalProperties.toMutableMap()
                }

                /**
                 * Identifier of the upload, for fetching it back through the documents endpoints.
                 */
                fun documentId(documentId: String?) = documentId(JsonField.ofNullable(documentId))

                /** Alias for calling [Builder.documentId] with `documentId.orElse(null)`. */
                fun documentId(documentId: Optional<String>) = documentId(documentId.getOrNull())

                /**
                 * Sets [Builder.documentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.documentId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun documentId(documentId: JsonField<String>) = apply {
                    this.documentId = documentId
                }

                fun fileName(fileName: String?) = fileName(JsonField.ofNullable(fileName))

                /** Alias for calling [Builder.fileName] with `fileName.orElse(null)`. */
                fun fileName(fileName: Optional<String>) = fileName(fileName.getOrNull())

                /**
                 * Sets [Builder.fileName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                /** The catalog's name for this document, matching the requirement it satisfies. */
                fun key(key: String) = key(JsonField.of(key))

                /**
                 * Sets [Builder.key] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.key] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun key(key: JsonField<String>) = apply { this.key = key }

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
                 * Returns an immutable instance of [Document].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Document =
                    Document(documentId, fileName, key, additionalProperties.toMutableMap())
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
            fun validate(): Document = apply {
                if (validated) {
                    return@apply
                }

                documentId()
                fileName()
                key()
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
                (if (documentId.asKnown().isPresent) 1 else 0) +
                    (if (fileName.asKnown().isPresent) 1 else 0) +
                    (if (key.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Document &&
                    documentId == other.documentId &&
                    fileName == other.fileName &&
                    key == other.key &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(documentId, fileName, key, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Document{documentId=$documentId, fileName=$fileName, key=$key, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Compliance &&
                brand == other.brand &&
                campaign == other.campaign &&
                documents == other.documents &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(brand, campaign, documents, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Compliance{brand=$brand, campaign=$campaign, documents=$documents, additionalProperties=$additionalProperties}"
    }

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
