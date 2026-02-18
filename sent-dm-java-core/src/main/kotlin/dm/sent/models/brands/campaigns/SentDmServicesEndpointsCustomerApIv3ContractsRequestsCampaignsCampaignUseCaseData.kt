// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Campaign use case with sample messages */
class SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val messagingUseCaseUs: JsonField<MessagingUseCaseUs>,
    private val sampleMessages: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("messagingUseCaseUs")
        @ExcludeMissing
        messagingUseCaseUs: JsonField<MessagingUseCaseUs> = JsonMissing.of(),
        @JsonProperty("sampleMessages")
        @ExcludeMissing
        sampleMessages: JsonField<List<String>> = JsonMissing.of(),
    ) : this(messagingUseCaseUs, sampleMessages, mutableMapOf())

    /**
     * US messaging use case category
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun messagingUseCaseUs(): MessagingUseCaseUs =
        messagingUseCaseUs.getRequired("messagingUseCaseUs")

    /**
     * Sample messages for this use case (1-5 messages, max 1024 characters each)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sampleMessages(): List<String> = sampleMessages.getRequired("sampleMessages")

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
         * Returns a mutable builder for constructing an instance of
         * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData].
         *
         * The following fields are required:
         * ```java
         * .messagingUseCaseUs()
         * .sampleMessages()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /**
     * A builder for
     * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData].
     */
    class Builder internal constructor() {

        private var messagingUseCaseUs: JsonField<MessagingUseCaseUs>? = null
        private var sampleMessages: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData:
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
        ) = apply {
            messagingUseCaseUs =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                    .messagingUseCaseUs
            sampleMessages =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                    .sampleMessages
                    .map { it.toMutableList() }
            additionalProperties =
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                    .additionalProperties
                    .toMutableMap()
        }

        /** US messaging use case category */
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

        /** Sample messages for this use case (1-5 messages, max 1024 characters each) */
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
         * Returns an immutable instance of
         * [SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .messagingUseCaseUs()
         * .sampleMessages()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build():
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData(
                checkRequired("messagingUseCaseUs", messagingUseCaseUs),
                checkRequired("sampleMessages", sampleMessages).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate():
        SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData = apply {
        if (validated) {
            return@apply
        }

        messagingUseCaseUs().validate()
        sampleMessages()
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
        (messagingUseCaseUs.asKnown().getOrNull()?.validity() ?: 0) +
            (sampleMessages.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData &&
            messagingUseCaseUs == other.messagingUseCaseUs &&
            sampleMessages == other.sampleMessages &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(messagingUseCaseUs, sampleMessages, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData{messagingUseCaseUs=$messagingUseCaseUs, sampleMessages=$sampleMessages, additionalProperties=$additionalProperties}"
}
