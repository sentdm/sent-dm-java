// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

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
 * Customer-facing use-case representation for the public v3 campaign contract. Exists for the same
 * reason as BrandCampaignV3Response: nesting the TcrCampaignUseCase database entity in a public
 * response means any column added to that table silently becomes part of the customer-facing
 * contract. This DTO is an explicit allowlist, so a new column stays invisible until it is added
 * here on purpose. This mirrors exactly the fields the entity already serialized, so it removes
 * nothing from the current response shape. It only closes the future-leak path.
 */
class CampaignUseCase
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val campaignId: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customerId: JsonField<String>,
    private val messagingUseCaseUs: JsonField<MessagingUseCaseUs>,
    private val sampleMessages: JsonField<List<String>>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("campaignId")
        @ExcludeMissing
        campaignId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("customerId")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("messagingUseCaseUs")
        @ExcludeMissing
        messagingUseCaseUs: JsonField<MessagingUseCaseUs> = JsonMissing.of(),
        @JsonProperty("sampleMessages")
        @ExcludeMissing
        sampleMessages: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        campaignId,
        createdAt,
        customerId,
        messagingUseCaseUs,
        sampleMessages,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun campaignId(): Optional<String> = campaignId.getOptional("campaignId")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customerId")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messagingUseCaseUs(): Optional<MessagingUseCaseUs> =
        messagingUseCaseUs.getOptional("messagingUseCaseUs")

    /**
     * Sample messages submitted to the registry for this use case.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sampleMessages(): Optional<List<String>> = sampleMessages.getOptional("sampleMessages")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [campaignId].
     *
     * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("campaignId") @ExcludeMissing fun _campaignId(): JsonField<String> = campaignId

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
     * Returns the raw JSON value of [messagingUseCaseUs].
     *
     * Unlike [messagingUseCaseUs], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("messagingUseCaseUs")
    @ExcludeMissing
    fun _messagingUseCaseUs(): JsonField<MessagingUseCaseUs> = messagingUseCaseUs

    /**
     * Returns the raw JSON value of [sampleMessages].
     *
     * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sampleMessages")
    @ExcludeMissing
    fun _sampleMessages(): JsonField<List<String>> = sampleMessages

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

        /** Returns a mutable builder for constructing an instance of [CampaignUseCase]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CampaignUseCase]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var campaignId: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
        private var messagingUseCaseUs: JsonField<MessagingUseCaseUs> = JsonMissing.of()
        private var sampleMessages: JsonField<MutableList<String>>? = null
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(campaignUseCase: CampaignUseCase) = apply {
            id = campaignUseCase.id
            campaignId = campaignUseCase.campaignId
            createdAt = campaignUseCase.createdAt
            customerId = campaignUseCase.customerId
            messagingUseCaseUs = campaignUseCase.messagingUseCaseUs
            sampleMessages = campaignUseCase.sampleMessages.map { it.toMutableList() }
            updatedAt = campaignUseCase.updatedAt
            additionalProperties = campaignUseCase.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun campaignId(campaignId: String) = campaignId(JsonField.of(campaignId))

        /**
         * Sets [Builder.campaignId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaignId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun campaignId(campaignId: JsonField<String>) = apply { this.campaignId = campaignId }

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

        fun messagingUseCaseUs(messagingUseCaseUs: MessagingUseCaseUs) =
            messagingUseCaseUs(JsonField.of(messagingUseCaseUs))

        /**
         * Sets [Builder.messagingUseCaseUs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messagingUseCaseUs] with a well-typed
         * [MessagingUseCaseUs] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun messagingUseCaseUs(messagingUseCaseUs: JsonField<MessagingUseCaseUs>) = apply {
            this.messagingUseCaseUs = messagingUseCaseUs
        }

        /** Sample messages submitted to the registry for this use case. */
        fun sampleMessages(sampleMessages: List<String>) =
            sampleMessages(JsonField.of(sampleMessages))

        /**
         * Sets [Builder.sampleMessages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sampleMessages] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sampleMessages(sampleMessages: JsonField<List<String>>) = apply {
            this.sampleMessages = sampleMessages.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [sampleMessages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSampleMessage(sampleMessage: String) = apply {
            sampleMessages =
                (sampleMessages ?: JsonField.of(mutableListOf())).also {
                    checkKnown("sampleMessages", it).add(sampleMessage)
                }
        }

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
         * Returns an immutable instance of [CampaignUseCase].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CampaignUseCase =
            CampaignUseCase(
                id,
                campaignId,
                createdAt,
                customerId,
                messagingUseCaseUs,
                (sampleMessages ?: JsonMissing.of()).map { it.toImmutable() },
                updatedAt,
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
    fun validate(): CampaignUseCase = apply {
        if (validated) {
            return@apply
        }

        id()
        campaignId()
        createdAt()
        customerId()
        messagingUseCaseUs().ifPresent { it.validate() }
        sampleMessages()
        updatedAt()
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
            (if (campaignId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (messagingUseCaseUs.asKnown().getOrNull()?.validity() ?: 0) +
            (sampleMessages.asKnown().getOrNull()?.size ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CampaignUseCase &&
            id == other.id &&
            campaignId == other.campaignId &&
            createdAt == other.createdAt &&
            customerId == other.customerId &&
            messagingUseCaseUs == other.messagingUseCaseUs &&
            sampleMessages == other.sampleMessages &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            campaignId,
            createdAt,
            customerId,
            messagingUseCaseUs,
            sampleMessages,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CampaignUseCase{id=$id, campaignId=$campaignId, createdAt=$createdAt, customerId=$customerId, messagingUseCaseUs=$messagingUseCaseUs, sampleMessages=$sampleMessages, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
