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
import dm.sent.models.webhooks.PaginationMeta
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A paginated list of sender profiles. */
class SenderProfilesList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val pagination: JsonField<PaginationMeta>,
    private val senderProfiles: JsonField<List<SenderProfile>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("pagination")
        @ExcludeMissing
        pagination: JsonField<PaginationMeta> = JsonMissing.of(),
        @JsonProperty("sender_profiles")
        @ExcludeMissing
        senderProfiles: JsonField<List<SenderProfile>> = JsonMissing.of(),
    ) : this(pagination, senderProfiles, mutableMapOf())

    /**
     * Pagination metadata for list responses
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun pagination(): Optional<PaginationMeta> = pagination.getOptional("pagination")

    /**
     * The sender_profiles on this page.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderProfiles(): Optional<List<SenderProfile>> =
        senderProfiles.getOptional("sender_profiles")

    /**
     * Returns the raw JSON value of [pagination].
     *
     * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pagination")
    @ExcludeMissing
    fun _pagination(): JsonField<PaginationMeta> = pagination

    /**
     * Returns the raw JSON value of [senderProfiles].
     *
     * Unlike [senderProfiles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_profiles")
    @ExcludeMissing
    fun _senderProfiles(): JsonField<List<SenderProfile>> = senderProfiles

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

        /** Returns a mutable builder for constructing an instance of [SenderProfilesList]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfilesList]. */
    class Builder internal constructor() {

        private var pagination: JsonField<PaginationMeta> = JsonMissing.of()
        private var senderProfiles: JsonField<MutableList<SenderProfile>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfilesList: SenderProfilesList) = apply {
            pagination = senderProfilesList.pagination
            senderProfiles = senderProfilesList.senderProfiles.map { it.toMutableList() }
            additionalProperties = senderProfilesList.additionalProperties.toMutableMap()
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

        /** The sender_profiles on this page. */
        fun senderProfiles(senderProfiles: List<SenderProfile>) =
            senderProfiles(JsonField.of(senderProfiles))

        /**
         * Sets [Builder.senderProfiles] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderProfiles] with a well-typed `List<SenderProfile>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun senderProfiles(senderProfiles: JsonField<List<SenderProfile>>) = apply {
            this.senderProfiles = senderProfiles.map { it.toMutableList() }
        }

        /**
         * Adds a single [SenderProfile] to [senderProfiles].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSenderProfile(senderProfile: SenderProfile) = apply {
            senderProfiles =
                (senderProfiles ?: JsonField.of(mutableListOf())).also {
                    checkKnown("senderProfiles", it).add(senderProfile)
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
         * Returns an immutable instance of [SenderProfilesList].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfilesList =
            SenderProfilesList(
                pagination,
                (senderProfiles ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): SenderProfilesList = apply {
        if (validated) {
            return@apply
        }

        pagination().ifPresent { it.validate() }
        senderProfiles().ifPresent { it.forEach { it.validate() } }
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
            (senderProfiles.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfilesList &&
            pagination == other.pagination &&
            senderProfiles == other.senderProfiles &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(pagination, senderProfiles, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfilesList{pagination=$pagination, senderProfiles=$senderProfiles, additionalProperties=$additionalProperties}"
}
