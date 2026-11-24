// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Body of an agent.* webhook (Sent Agents). The event is the agent service's own record, forwarded
 * without renaming: EventId is its id, so a subscriber can dedupe a redelivery.
 */
class AgentEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventId: JsonField<String>,
    private val occurredAt: JsonField<String>,
    private val accountId: JsonField<String>,
    private val actor: JsonField<String>,
    private val agentId: JsonField<String>,
    private val agentName: JsonField<String>,
    private val agentVersion: JsonField<Int>,
    private val contactId: JsonField<String>,
    private val contactPhoneNumber: JsonField<String>,
    private val data: JsonValue,
    private val instanceId: JsonField<String>,
    private val sequence: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("occurred_at")
        @ExcludeMissing
        occurredAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("actor") @ExcludeMissing actor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_name") @ExcludeMissing agentName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_version")
        @ExcludeMissing
        agentVersion: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("contact_id") @ExcludeMissing contactId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contact_phone_number")
        @ExcludeMissing
        contactPhoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
        @JsonProperty("instance_id")
        @ExcludeMissing
        instanceId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sequence") @ExcludeMissing sequence: JsonField<Long> = JsonMissing.of(),
    ) : this(
        eventId,
        occurredAt,
        accountId,
        actor,
        agentId,
        agentName,
        agentVersion,
        contactId,
        contactPhoneNumber,
        data,
        instanceId,
        sequence,
        mutableMapOf(),
    )

    /**
     * The agent service's event id. The same event is never delivered under two ids.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * When the agent service recorded it, UTC, to the millisecond.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun occurredAt(): String = occurredAt.getRequired("occurred_at")

    /**
     * The sender profile the agent runs on.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * Who caused it: system, the agent service's customer, or an approver.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun actor(): Optional<String> = actor.getOptional("actor")

    /**
     * The agent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentId(): Optional<String> = agentId.getOptional("agent_id")

    /**
     * The agent's name, as it is listed. Absent for an agent services no longer holds.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentName(): Optional<String> = agentName.getOptional("agent_name")

    /**
     * The version of the agent the event is of: the one its conversation runs, or the active one
     * for an event of the agent itself. Absent when the agent service does not say it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentVersion(): Optional<Int> = agentVersion.getOptional("agent_version")

    /**
     * The contact of that conversation; absent on agent-level events.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactId(): Optional<String> = contactId.getOptional("contact_id")

    /**
     * The contact's phone number, in E.164, so a receiver knows who the event is about without
     * asking for the contact. Read from the account's contacts as the webhook is built: the agent
     * service's own record names a contact by id only. Absent on agent-level events, and for a
     * contact the account no longer holds.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactPhoneNumber(): Optional<String> =
        contactPhoneNumber.getOptional("contact_phone_number")

    /**
     * The event's own fields (outcome, reason, ...), exactly as the agent service recorded them.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = agentEventPayload.data().convert(MyClass.class);
     * ```
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

    /**
     * The conversation (agent × contact) the event belongs to; absent on agent-level events.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun instanceId(): Optional<String> = instanceId.getOptional("instance_id")

    /**
     * Where the event stands among the agent's events: a number that grows with each, so two events
     * of the same second are put in order by it. Not a count: there are gaps between an agent's
     * own. Absent from an agent service that does not say it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sequence(): Optional<Long> = sequence.getOptional("sequence")

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [occurredAt].
     *
     * Unlike [occurredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("occurred_at") @ExcludeMissing fun _occurredAt(): JsonField<String> = occurredAt

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [actor].
     *
     * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<String> = actor

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

    /**
     * Returns the raw JSON value of [agentName].
     *
     * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_name") @ExcludeMissing fun _agentName(): JsonField<String> = agentName

    /**
     * Returns the raw JSON value of [agentVersion].
     *
     * Unlike [agentVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_version")
    @ExcludeMissing
    fun _agentVersion(): JsonField<Int> = agentVersion

    /**
     * Returns the raw JSON value of [contactId].
     *
     * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact_id") @ExcludeMissing fun _contactId(): JsonField<String> = contactId

    /**
     * Returns the raw JSON value of [contactPhoneNumber].
     *
     * Unlike [contactPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("contact_phone_number")
    @ExcludeMissing
    fun _contactPhoneNumber(): JsonField<String> = contactPhoneNumber

    /**
     * Returns the raw JSON value of [instanceId].
     *
     * Unlike [instanceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instance_id") @ExcludeMissing fun _instanceId(): JsonField<String> = instanceId

    /**
     * Returns the raw JSON value of [sequence].
     *
     * Unlike [sequence], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence") @ExcludeMissing fun _sequence(): JsonField<Long> = sequence

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
         * Returns a mutable builder for constructing an instance of [AgentEventPayload].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .occurredAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentEventPayload]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var occurredAt: JsonField<String>? = null
        private var accountId: JsonField<String> = JsonMissing.of()
        private var actor: JsonField<String> = JsonMissing.of()
        private var agentId: JsonField<String> = JsonMissing.of()
        private var agentName: JsonField<String> = JsonMissing.of()
        private var agentVersion: JsonField<Int> = JsonMissing.of()
        private var contactId: JsonField<String> = JsonMissing.of()
        private var contactPhoneNumber: JsonField<String> = JsonMissing.of()
        private var data: JsonValue = JsonMissing.of()
        private var instanceId: JsonField<String> = JsonMissing.of()
        private var sequence: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentEventPayload: AgentEventPayload) = apply {
            eventId = agentEventPayload.eventId
            occurredAt = agentEventPayload.occurredAt
            accountId = agentEventPayload.accountId
            actor = agentEventPayload.actor
            agentId = agentEventPayload.agentId
            agentName = agentEventPayload.agentName
            agentVersion = agentEventPayload.agentVersion
            contactId = agentEventPayload.contactId
            contactPhoneNumber = agentEventPayload.contactPhoneNumber
            data = agentEventPayload.data
            instanceId = agentEventPayload.instanceId
            sequence = agentEventPayload.sequence
            additionalProperties = agentEventPayload.additionalProperties.toMutableMap()
        }

        /** The agent service's event id. The same event is never delivered under two ids. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** When the agent service recorded it, UTC, to the millisecond. */
        fun occurredAt(occurredAt: String) = occurredAt(JsonField.of(occurredAt))

        /**
         * Sets [Builder.occurredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.occurredAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun occurredAt(occurredAt: JsonField<String>) = apply { this.occurredAt = occurredAt }

        /** The sender profile the agent runs on. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** Who caused it: system, the agent service's customer, or an approver. */
        fun actor(actor: String?) = actor(JsonField.ofNullable(actor))

        /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
        fun actor(actor: Optional<String>) = actor(actor.getOrNull())

        /**
         * Sets [Builder.actor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actor] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun actor(actor: JsonField<String>) = apply { this.actor = actor }

        /** The agent. */
        fun agentId(agentId: String) = agentId(JsonField.of(agentId))

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

        /** The agent's name, as it is listed. Absent for an agent services no longer holds. */
        fun agentName(agentName: String?) = agentName(JsonField.ofNullable(agentName))

        /** Alias for calling [Builder.agentName] with `agentName.orElse(null)`. */
        fun agentName(agentName: Optional<String>) = agentName(agentName.getOrNull())

        /**
         * Sets [Builder.agentName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

        /**
         * The version of the agent the event is of: the one its conversation runs, or the active
         * one for an event of the agent itself. Absent when the agent service does not say it.
         */
        fun agentVersion(agentVersion: Int?) = agentVersion(JsonField.ofNullable(agentVersion))

        /**
         * Alias for [Builder.agentVersion].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun agentVersion(agentVersion: Int) = agentVersion(agentVersion as Int?)

        /** Alias for calling [Builder.agentVersion] with `agentVersion.orElse(null)`. */
        fun agentVersion(agentVersion: Optional<Int>) = agentVersion(agentVersion.getOrNull())

        /**
         * Sets [Builder.agentVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentVersion] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun agentVersion(agentVersion: JsonField<Int>) = apply { this.agentVersion = agentVersion }

        /** The contact of that conversation; absent on agent-level events. */
        fun contactId(contactId: String?) = contactId(JsonField.ofNullable(contactId))

        /** Alias for calling [Builder.contactId] with `contactId.orElse(null)`. */
        fun contactId(contactId: Optional<String>) = contactId(contactId.getOrNull())

        /**
         * Sets [Builder.contactId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactId(contactId: JsonField<String>) = apply { this.contactId = contactId }

        /**
         * The contact's phone number, in E.164, so a receiver knows who the event is about without
         * asking for the contact. Read from the account's contacts as the webhook is built: the
         * agent service's own record names a contact by id only. Absent on agent-level events, and
         * for a contact the account no longer holds.
         */
        fun contactPhoneNumber(contactPhoneNumber: String?) =
            contactPhoneNumber(JsonField.ofNullable(contactPhoneNumber))

        /**
         * Alias for calling [Builder.contactPhoneNumber] with `contactPhoneNumber.orElse(null)`.
         */
        fun contactPhoneNumber(contactPhoneNumber: Optional<String>) =
            contactPhoneNumber(contactPhoneNumber.getOrNull())

        /**
         * Sets [Builder.contactPhoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactPhoneNumber] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contactPhoneNumber(contactPhoneNumber: JsonField<String>) = apply {
            this.contactPhoneNumber = contactPhoneNumber
        }

        /**
         * The event's own fields (outcome, reason, ...), exactly as the agent service recorded
         * them.
         */
        fun data(data: JsonValue) = apply { this.data = data }

        /**
         * The conversation (agent × contact) the event belongs to; absent on agent-level events.
         */
        fun instanceId(instanceId: String?) = instanceId(JsonField.ofNullable(instanceId))

        /** Alias for calling [Builder.instanceId] with `instanceId.orElse(null)`. */
        fun instanceId(instanceId: Optional<String>) = instanceId(instanceId.getOrNull())

        /**
         * Sets [Builder.instanceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instanceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instanceId(instanceId: JsonField<String>) = apply { this.instanceId = instanceId }

        /**
         * Where the event stands among the agent's events: a number that grows with each, so two
         * events of the same second are put in order by it. Not a count: there are gaps between an
         * agent's own. Absent from an agent service that does not say it.
         */
        fun sequence(sequence: Long?) = sequence(JsonField.ofNullable(sequence))

        /**
         * Alias for [Builder.sequence].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun sequence(sequence: Long) = sequence(sequence as Long?)

        /** Alias for calling [Builder.sequence] with `sequence.orElse(null)`. */
        fun sequence(sequence: Optional<Long>) = sequence(sequence.getOrNull())

        /**
         * Sets [Builder.sequence] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequence] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sequence(sequence: JsonField<Long>) = apply { this.sequence = sequence }

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
         * Returns an immutable instance of [AgentEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .occurredAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentEventPayload =
            AgentEventPayload(
                checkRequired("eventId", eventId),
                checkRequired("occurredAt", occurredAt),
                accountId,
                actor,
                agentId,
                agentName,
                agentVersion,
                contactId,
                contactPhoneNumber,
                data,
                instanceId,
                sequence,
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
    fun validate(): AgentEventPayload = apply {
        if (validated) {
            return@apply
        }

        eventId()
        occurredAt()
        accountId()
        actor()
        agentId()
        agentName()
        agentVersion()
        contactId()
        contactPhoneNumber()
        instanceId()
        sequence()
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (occurredAt.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (actor.asKnown().isPresent) 1 else 0) +
            (if (agentId.asKnown().isPresent) 1 else 0) +
            (if (agentName.asKnown().isPresent) 1 else 0) +
            (if (agentVersion.asKnown().isPresent) 1 else 0) +
            (if (contactId.asKnown().isPresent) 1 else 0) +
            (if (contactPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (instanceId.asKnown().isPresent) 1 else 0) +
            (if (sequence.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentEventPayload &&
            eventId == other.eventId &&
            occurredAt == other.occurredAt &&
            accountId == other.accountId &&
            actor == other.actor &&
            agentId == other.agentId &&
            agentName == other.agentName &&
            agentVersion == other.agentVersion &&
            contactId == other.contactId &&
            contactPhoneNumber == other.contactPhoneNumber &&
            data == other.data &&
            instanceId == other.instanceId &&
            sequence == other.sequence &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            eventId,
            occurredAt,
            accountId,
            actor,
            agentId,
            agentName,
            agentVersion,
            contactId,
            contactPhoneNumber,
            data,
            instanceId,
            sequence,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentEventPayload{eventId=$eventId, occurredAt=$occurredAt, accountId=$accountId, actor=$actor, agentId=$agentId, agentName=$agentName, agentVersion=$agentVersion, contactId=$contactId, contactPhoneNumber=$contactPhoneNumber, data=$data, instanceId=$instanceId, sequence=$sequence, additionalProperties=$additionalProperties}"
}
