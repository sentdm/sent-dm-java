// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.organizations.users

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CustomerUser
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customerId: JsonField<String>,
    private val email: JsonField<String>,
    private val invitationSentAt: JsonField<OffsetDateTime>,
    private val invitationToken: JsonField<String>,
    private val invitationTokenExpiresAt: JsonField<OffsetDateTime>,
    private val lastLoginAt: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val role: JsonField<String>,
    private val status: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("customerId")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("invitationSentAt")
        @ExcludeMissing
        invitationSentAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("invitationToken")
        @ExcludeMissing
        invitationToken: JsonField<String> = JsonMissing.of(),
        @JsonProperty("invitationTokenExpiresAt")
        @ExcludeMissing
        invitationTokenExpiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("lastLoginAt")
        @ExcludeMissing
        lastLoginAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        customerId,
        email,
        invitationSentAt,
        invitationToken,
        invitationTokenExpiresAt,
        lastLoginAt,
        name,
        role,
        status,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * Unique identifier
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customerId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun invitationSentAt(): Optional<OffsetDateTime> =
        invitationSentAt.getOptional("invitationSentAt")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun invitationToken(): Optional<String> = invitationToken.getOptional("invitationToken")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun invitationTokenExpiresAt(): Optional<OffsetDateTime> =
        invitationTokenExpiresAt.getOptional("invitationTokenExpiresAt")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastLoginAt(): Optional<OffsetDateTime> = lastLoginAt.getOptional("lastLoginAt")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun role(): Optional<String> = role.getOptional("role")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

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
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customerId") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [invitationSentAt].
     *
     * Unlike [invitationSentAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("invitationSentAt")
    @ExcludeMissing
    fun _invitationSentAt(): JsonField<OffsetDateTime> = invitationSentAt

    /**
     * Returns the raw JSON value of [invitationToken].
     *
     * Unlike [invitationToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invitationToken")
    @ExcludeMissing
    fun _invitationToken(): JsonField<String> = invitationToken

    /**
     * Returns the raw JSON value of [invitationTokenExpiresAt].
     *
     * Unlike [invitationTokenExpiresAt], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("invitationTokenExpiresAt")
    @ExcludeMissing
    fun _invitationTokenExpiresAt(): JsonField<OffsetDateTime> = invitationTokenExpiresAt

    /**
     * Returns the raw JSON value of [lastLoginAt].
     *
     * Unlike [lastLoginAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lastLoginAt")
    @ExcludeMissing
    fun _lastLoginAt(): JsonField<OffsetDateTime> = lastLoginAt

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
    @JsonProperty("updatedAt")
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

        /** Returns a mutable builder for constructing an instance of [CustomerUser]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CustomerUser]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var invitationSentAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var invitationToken: JsonField<String> = JsonMissing.of()
        private var invitationTokenExpiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastLoginAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var role: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(customerUser: CustomerUser) = apply {
            id = customerUser.id
            createdAt = customerUser.createdAt
            customerId = customerUser.customerId
            email = customerUser.email
            invitationSentAt = customerUser.invitationSentAt
            invitationToken = customerUser.invitationToken
            invitationTokenExpiresAt = customerUser.invitationTokenExpiresAt
            lastLoginAt = customerUser.lastLoginAt
            name = customerUser.name
            role = customerUser.role
            status = customerUser.status
            updatedAt = customerUser.updatedAt
            additionalProperties = customerUser.additionalProperties.toMutableMap()
        }

        /** Unique identifier */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun customerId(customerId: String) = customerId(JsonField.of(customerId))

        /**
         * Sets [Builder.customerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

        fun email(email: String) = email(JsonField.of(email))

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        fun invitationSentAt(invitationSentAt: OffsetDateTime?) =
            invitationSentAt(JsonField.ofNullable(invitationSentAt))

        /** Alias for calling [Builder.invitationSentAt] with `invitationSentAt.orElse(null)`. */
        fun invitationSentAt(invitationSentAt: Optional<OffsetDateTime>) =
            invitationSentAt(invitationSentAt.getOrNull())

        /**
         * Sets [Builder.invitationSentAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.invitationSentAt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun invitationSentAt(invitationSentAt: JsonField<OffsetDateTime>) = apply {
            this.invitationSentAt = invitationSentAt
        }

        fun invitationToken(invitationToken: String?) =
            invitationToken(JsonField.ofNullable(invitationToken))

        /** Alias for calling [Builder.invitationToken] with `invitationToken.orElse(null)`. */
        fun invitationToken(invitationToken: Optional<String>) =
            invitationToken(invitationToken.getOrNull())

        /**
         * Sets [Builder.invitationToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.invitationToken] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun invitationToken(invitationToken: JsonField<String>) = apply {
            this.invitationToken = invitationToken
        }

        fun invitationTokenExpiresAt(invitationTokenExpiresAt: OffsetDateTime?) =
            invitationTokenExpiresAt(JsonField.ofNullable(invitationTokenExpiresAt))

        /**
         * Alias for calling [Builder.invitationTokenExpiresAt] with
         * `invitationTokenExpiresAt.orElse(null)`.
         */
        fun invitationTokenExpiresAt(invitationTokenExpiresAt: Optional<OffsetDateTime>) =
            invitationTokenExpiresAt(invitationTokenExpiresAt.getOrNull())

        /**
         * Sets [Builder.invitationTokenExpiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.invitationTokenExpiresAt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun invitationTokenExpiresAt(invitationTokenExpiresAt: JsonField<OffsetDateTime>) = apply {
            this.invitationTokenExpiresAt = invitationTokenExpiresAt
        }

        fun lastLoginAt(lastLoginAt: OffsetDateTime?) =
            lastLoginAt(JsonField.ofNullable(lastLoginAt))

        /** Alias for calling [Builder.lastLoginAt] with `lastLoginAt.orElse(null)`. */
        fun lastLoginAt(lastLoginAt: Optional<OffsetDateTime>) =
            lastLoginAt(lastLoginAt.getOrNull())

        /**
         * Sets [Builder.lastLoginAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastLoginAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lastLoginAt(lastLoginAt: JsonField<OffsetDateTime>) = apply {
            this.lastLoginAt = lastLoginAt
        }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun role(role: String) = role(JsonField.of(role))

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<String>) = apply { this.role = role }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [CustomerUser].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CustomerUser =
            CustomerUser(
                id,
                createdAt,
                customerId,
                email,
                invitationSentAt,
                invitationToken,
                invitationTokenExpiresAt,
                lastLoginAt,
                name,
                role,
                status,
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CustomerUser = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        customerId()
        email()
        invitationSentAt()
        invitationToken()
        invitationTokenExpiresAt()
        lastLoginAt()
        name()
        role()
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
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (invitationSentAt.asKnown().isPresent) 1 else 0) +
            (if (invitationToken.asKnown().isPresent) 1 else 0) +
            (if (invitationTokenExpiresAt.asKnown().isPresent) 1 else 0) +
            (if (lastLoginAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (role.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomerUser &&
            id == other.id &&
            createdAt == other.createdAt &&
            customerId == other.customerId &&
            email == other.email &&
            invitationSentAt == other.invitationSentAt &&
            invitationToken == other.invitationToken &&
            invitationTokenExpiresAt == other.invitationTokenExpiresAt &&
            lastLoginAt == other.lastLoginAt &&
            name == other.name &&
            role == other.role &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            customerId,
            email,
            invitationSentAt,
            invitationToken,
            invitationTokenExpiresAt,
            lastLoginAt,
            name,
            role,
            status,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CustomerUser{id=$id, createdAt=$createdAt, customerId=$customerId, email=$email, invitationSentAt=$invitationSentAt, invitationToken=$invitationToken, invitationTokenExpiresAt=$invitationTokenExpiresAt, lastLoginAt=$lastLoginAt, name=$name, role=$role, status=$status, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
