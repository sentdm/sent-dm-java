// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.users

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
import dm.sent.models.webhooks.PaginationMeta
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The users in the organization. */
class UsersList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val pagination: JsonField<PaginationMeta>,
    private val users: JsonField<List<UserResponse>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("pagination")
        @ExcludeMissing
        pagination: JsonField<PaginationMeta> = JsonMissing.of(),
        @JsonProperty("users")
        @ExcludeMissing
        users: JsonField<List<UserResponse>> = JsonMissing.of(),
    ) : this(pagination, users, mutableMapOf())

    /**
     * Pagination metadata for list responses
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun pagination(): Optional<PaginationMeta> = pagination.getOptional("pagination")

    /**
     * The users on this page.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun users(): Optional<List<UserResponse>> = users.getOptional("users")

    /**
     * Returns the raw JSON value of [pagination].
     *
     * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pagination")
    @ExcludeMissing
    fun _pagination(): JsonField<PaginationMeta> = pagination

    /**
     * Returns the raw JSON value of [users].
     *
     * Unlike [users], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<UserResponse>> = users

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

        /** Returns a mutable builder for constructing an instance of [UsersList]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsersList]. */
    class Builder internal constructor() {

        private var pagination: JsonField<PaginationMeta> = JsonMissing.of()
        private var users: JsonField<MutableList<UserResponse>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usersList: UsersList) = apply {
            pagination = usersList.pagination
            users = usersList.users.map { it.toMutableList() }
            additionalProperties = usersList.additionalProperties.toMutableMap()
        }

        /** Pagination metadata for list responses */
        fun pagination(pagination: PaginationMeta) = pagination(JsonField.of(pagination))

        /**
         * Sets [Builder.pagination] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pagination] with a well-typed [PaginationMeta] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pagination(pagination: JsonField<PaginationMeta>) = apply {
            this.pagination = pagination
        }

        /** The users on this page. */
        fun users(users: List<UserResponse>) = users(JsonField.of(users))

        /**
         * Sets [Builder.users] to an arbitrary JSON value.
         *
         * You should usually call [Builder.users] with a well-typed `List<UserResponse>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun users(users: JsonField<List<UserResponse>>) = apply {
            this.users = users.map { it.toMutableList() }
        }

        /**
         * Adds a single [UserResponse] to [users].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUser(user: UserResponse) = apply {
            users =
                (users ?: JsonField.of(mutableListOf())).also { checkKnown("users", it).add(user) }
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
         * Returns an immutable instance of [UsersList].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UsersList =
            UsersList(
                pagination,
                (users ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): UsersList = apply {
        if (validated) {
            return@apply
        }

        pagination().ifPresent { it.validate() }
        users().ifPresent { it.forEach { it.validate() } }
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
        (pagination.asKnown().getOrNull()?.validity() ?: 0) +
            (users.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsersList &&
            pagination == other.pagination &&
            users == other.users &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(pagination, users, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsersList{pagination=$pagination, users=$users, additionalProperties=$additionalProperties}"
}
