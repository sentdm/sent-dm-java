// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
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

/** Standard API response envelope for all v3 endpoints */
class CampaignCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<Error>,
    private val meta: JsonField<Meta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<Meta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * The response data (null if error)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error information
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun error(): Optional<Error> = error.getOptional("error")

    /**
     * Request and response metadata
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun meta(): Optional<Meta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
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
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<Meta> = meta

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

        /** Returns a mutable builder for constructing an instance of [CampaignCreateResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CampaignCreateResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<Error> = JsonMissing.of()
        private var meta: JsonField<Meta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(campaignCreateResponse: CampaignCreateResponse) = apply {
            data = campaignCreateResponse.data
            error = campaignCreateResponse.error
            meta = campaignCreateResponse.meta
            success = campaignCreateResponse.success
            additionalProperties = campaignCreateResponse.additionalProperties.toMutableMap()
        }

        /** The response data (null if error) */
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
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<Error>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /** Request and response metadata */
        fun meta(meta: Meta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [Meta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<Meta>) = apply { this.meta = meta }

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
         * Returns an immutable instance of [CampaignCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CampaignCreateResponse =
            CampaignCreateResponse(data, error, meta, success, additionalProperties.toMutableMap())
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
    fun validate(): CampaignCreateResponse = apply {
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    /** The response data (null if error) */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val billedDate: JsonField<OffsetDateTime>,
        private val brandId: JsonField<String>,
        private val cost: JsonField<Double>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val cspId: JsonField<String>,
        private val customerId: JsonField<String>,
        private val dcaElectionsComplete: JsonField<Boolean>,
        private val dcaElectionsCompletedAt: JsonField<OffsetDateTime>,
        private val description: JsonField<String>,
        private val helpKeywords: JsonField<String>,
        private val helpMessage: JsonField<String>,
        private val kycSubmissionFormId: JsonField<String>,
        private val messageFlow: JsonField<String>,
        private val name: JsonField<String>,
        private val optinKeywords: JsonField<String>,
        private val optinMessage: JsonField<String>,
        private val optoutKeywords: JsonField<String>,
        private val optoutMessage: JsonField<String>,
        private val privacyPolicyLink: JsonField<String>,
        private val resellerId: JsonField<String>,
        private val sharingStatus: JsonField<SharingStatus>,
        private val status: JsonField<Status>,
        private val submittedAt: JsonField<OffsetDateTime>,
        private val submittedToTcr: JsonField<Boolean>,
        private val tcrCampaignId: JsonField<String>,
        private val tcrSyncError: JsonField<String>,
        private val telnyxCampaignId: JsonField<String>,
        private val termsAndConditionsLink: JsonField<String>,
        private val type: JsonField<String>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val upstreamCnpId: JsonField<String>,
        private val useCases: JsonField<List<UseCase>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("billedDate")
            @ExcludeMissing
            billedDate: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("brandId") @ExcludeMissing brandId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cost") @ExcludeMissing cost: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("cspId") @ExcludeMissing cspId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("customerId")
            @ExcludeMissing
            customerId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dcaElectionsComplete")
            @ExcludeMissing
            dcaElectionsComplete: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("dcaElectionsCompletedAt")
            @ExcludeMissing
            dcaElectionsCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("helpKeywords")
            @ExcludeMissing
            helpKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("helpMessage")
            @ExcludeMissing
            helpMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("kycSubmissionFormId")
            @ExcludeMissing
            kycSubmissionFormId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("messageFlow")
            @ExcludeMissing
            messageFlow: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optinKeywords")
            @ExcludeMissing
            optinKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optinMessage")
            @ExcludeMissing
            optinMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optoutKeywords")
            @ExcludeMissing
            optoutKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optoutMessage")
            @ExcludeMissing
            optoutMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("privacyPolicyLink")
            @ExcludeMissing
            privacyPolicyLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resellerId")
            @ExcludeMissing
            resellerId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sharingStatus")
            @ExcludeMissing
            sharingStatus: JsonField<SharingStatus> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("submittedAt")
            @ExcludeMissing
            submittedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("submittedToTCR")
            @ExcludeMissing
            submittedToTcr: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("tcrCampaignId")
            @ExcludeMissing
            tcrCampaignId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tcrSyncError")
            @ExcludeMissing
            tcrSyncError: JsonField<String> = JsonMissing.of(),
            @JsonProperty("telnyxCampaignId")
            @ExcludeMissing
            telnyxCampaignId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("termsAndConditionsLink")
            @ExcludeMissing
            termsAndConditionsLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("upstreamCnpId")
            @ExcludeMissing
            upstreamCnpId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("useCases")
            @ExcludeMissing
            useCases: JsonField<List<UseCase>> = JsonMissing.of(),
        ) : this(
            id,
            billedDate,
            brandId,
            cost,
            createdAt,
            cspId,
            customerId,
            dcaElectionsComplete,
            dcaElectionsCompletedAt,
            description,
            helpKeywords,
            helpMessage,
            kycSubmissionFormId,
            messageFlow,
            name,
            optinKeywords,
            optinMessage,
            optoutKeywords,
            optoutMessage,
            privacyPolicyLink,
            resellerId,
            sharingStatus,
            status,
            submittedAt,
            submittedToTcr,
            tcrCampaignId,
            tcrSyncError,
            telnyxCampaignId,
            termsAndConditionsLink,
            type,
            updatedAt,
            upstreamCnpId,
            useCases,
            mutableMapOf(),
        )

        /**
         * Unique identifier
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun billedDate(): Optional<OffsetDateTime> = billedDate.getOptional("billedDate")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brandId(): Optional<String> = brandId.getOptional("brandId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cost(): Optional<Double> = cost.getOptional("cost")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cspId(): Optional<String> = cspId.getOptional("cspId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun customerId(): Optional<String> = customerId.getOptional("customerId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun dcaElectionsComplete(): Optional<Boolean> =
            dcaElectionsComplete.getOptional("dcaElectionsComplete")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun dcaElectionsCompletedAt(): Optional<OffsetDateTime> =
            dcaElectionsCompletedAt.getOptional("dcaElectionsCompletedAt")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpKeywords(): Optional<String> = helpKeywords.getOptional("helpKeywords")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpMessage(): Optional<String> = helpMessage.getOptional("helpMessage")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun kycSubmissionFormId(): Optional<String> =
            kycSubmissionFormId.getOptional("kycSubmissionFormId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messageFlow(): Optional<String> = messageFlow.getOptional("messageFlow")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optinKeywords(): Optional<String> = optinKeywords.getOptional("optinKeywords")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optinMessage(): Optional<String> = optinMessage.getOptional("optinMessage")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optoutKeywords(): Optional<String> = optoutKeywords.getOptional("optoutKeywords")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optoutMessage(): Optional<String> = optoutMessage.getOptional("optoutMessage")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun privacyPolicyLink(): Optional<String> =
            privacyPolicyLink.getOptional("privacyPolicyLink")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resellerId(): Optional<String> = resellerId.getOptional("resellerId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sharingStatus(): Optional<SharingStatus> = sharingStatus.getOptional("sharingStatus")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submittedAt(): Optional<OffsetDateTime> = submittedAt.getOptional("submittedAt")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submittedToTcr(): Optional<Boolean> = submittedToTcr.getOptional("submittedToTCR")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tcrCampaignId(): Optional<String> = tcrCampaignId.getOptional("tcrCampaignId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tcrSyncError(): Optional<String> = tcrSyncError.getOptional("tcrSyncError")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun telnyxCampaignId(): Optional<String> = telnyxCampaignId.getOptional("telnyxCampaignId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun termsAndConditionsLink(): Optional<String> =
            termsAndConditionsLink.getOptional("termsAndConditionsLink")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun upstreamCnpId(): Optional<String> = upstreamCnpId.getOptional("upstreamCnpId")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun useCases(): Optional<List<UseCase>> = useCases.getOptional("useCases")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [billedDate].
         *
         * Unlike [billedDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("billedDate")
        @ExcludeMissing
        fun _billedDate(): JsonField<OffsetDateTime> = billedDate

        /**
         * Returns the raw JSON value of [brandId].
         *
         * Unlike [brandId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("brandId") @ExcludeMissing fun _brandId(): JsonField<String> = brandId

        /**
         * Returns the raw JSON value of [cost].
         *
         * Unlike [cost], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cost") @ExcludeMissing fun _cost(): JsonField<Double> = cost

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [cspId].
         *
         * Unlike [cspId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cspId") @ExcludeMissing fun _cspId(): JsonField<String> = cspId

        /**
         * Returns the raw JSON value of [customerId].
         *
         * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("customerId")
        @ExcludeMissing
        fun _customerId(): JsonField<String> = customerId

        /**
         * Returns the raw JSON value of [dcaElectionsComplete].
         *
         * Unlike [dcaElectionsComplete], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("dcaElectionsComplete")
        @ExcludeMissing
        fun _dcaElectionsComplete(): JsonField<Boolean> = dcaElectionsComplete

        /**
         * Returns the raw JSON value of [dcaElectionsCompletedAt].
         *
         * Unlike [dcaElectionsCompletedAt], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("dcaElectionsCompletedAt")
        @ExcludeMissing
        fun _dcaElectionsCompletedAt(): JsonField<OffsetDateTime> = dcaElectionsCompletedAt

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [helpKeywords].
         *
         * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("helpKeywords")
        @ExcludeMissing
        fun _helpKeywords(): JsonField<String> = helpKeywords

        /**
         * Returns the raw JSON value of [helpMessage].
         *
         * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("helpMessage")
        @ExcludeMissing
        fun _helpMessage(): JsonField<String> = helpMessage

        /**
         * Returns the raw JSON value of [kycSubmissionFormId].
         *
         * Unlike [kycSubmissionFormId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("kycSubmissionFormId")
        @ExcludeMissing
        fun _kycSubmissionFormId(): JsonField<String> = kycSubmissionFormId

        /**
         * Returns the raw JSON value of [messageFlow].
         *
         * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("messageFlow")
        @ExcludeMissing
        fun _messageFlow(): JsonField<String> = messageFlow

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [optinKeywords].
         *
         * Unlike [optinKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optinKeywords")
        @ExcludeMissing
        fun _optinKeywords(): JsonField<String> = optinKeywords

        /**
         * Returns the raw JSON value of [optinMessage].
         *
         * Unlike [optinMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optinMessage")
        @ExcludeMissing
        fun _optinMessage(): JsonField<String> = optinMessage

        /**
         * Returns the raw JSON value of [optoutKeywords].
         *
         * Unlike [optoutKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optoutKeywords")
        @ExcludeMissing
        fun _optoutKeywords(): JsonField<String> = optoutKeywords

        /**
         * Returns the raw JSON value of [optoutMessage].
         *
         * Unlike [optoutMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optoutMessage")
        @ExcludeMissing
        fun _optoutMessage(): JsonField<String> = optoutMessage

        /**
         * Returns the raw JSON value of [privacyPolicyLink].
         *
         * Unlike [privacyPolicyLink], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("privacyPolicyLink")
        @ExcludeMissing
        fun _privacyPolicyLink(): JsonField<String> = privacyPolicyLink

        /**
         * Returns the raw JSON value of [resellerId].
         *
         * Unlike [resellerId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resellerId")
        @ExcludeMissing
        fun _resellerId(): JsonField<String> = resellerId

        /**
         * Returns the raw JSON value of [sharingStatus].
         *
         * Unlike [sharingStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sharingStatus")
        @ExcludeMissing
        fun _sharingStatus(): JsonField<SharingStatus> = sharingStatus

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [submittedAt].
         *
         * Unlike [submittedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("submittedAt")
        @ExcludeMissing
        fun _submittedAt(): JsonField<OffsetDateTime> = submittedAt

        /**
         * Returns the raw JSON value of [submittedToTcr].
         *
         * Unlike [submittedToTcr], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("submittedToTCR")
        @ExcludeMissing
        fun _submittedToTcr(): JsonField<Boolean> = submittedToTcr

        /**
         * Returns the raw JSON value of [tcrCampaignId].
         *
         * Unlike [tcrCampaignId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tcrCampaignId")
        @ExcludeMissing
        fun _tcrCampaignId(): JsonField<String> = tcrCampaignId

        /**
         * Returns the raw JSON value of [tcrSyncError].
         *
         * Unlike [tcrSyncError], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tcrSyncError")
        @ExcludeMissing
        fun _tcrSyncError(): JsonField<String> = tcrSyncError

        /**
         * Returns the raw JSON value of [telnyxCampaignId].
         *
         * Unlike [telnyxCampaignId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("telnyxCampaignId")
        @ExcludeMissing
        fun _telnyxCampaignId(): JsonField<String> = telnyxCampaignId

        /**
         * Returns the raw JSON value of [termsAndConditionsLink].
         *
         * Unlike [termsAndConditionsLink], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("termsAndConditionsLink")
        @ExcludeMissing
        fun _termsAndConditionsLink(): JsonField<String> = termsAndConditionsLink

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

        /**
         * Returns the raw JSON value of [upstreamCnpId].
         *
         * Unlike [upstreamCnpId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("upstreamCnpId")
        @ExcludeMissing
        fun _upstreamCnpId(): JsonField<String> = upstreamCnpId

        /**
         * Returns the raw JSON value of [useCases].
         *
         * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("useCases")
        @ExcludeMissing
        fun _useCases(): JsonField<List<UseCase>> = useCases

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
            private var billedDate: JsonField<OffsetDateTime> = JsonMissing.of()
            private var brandId: JsonField<String> = JsonMissing.of()
            private var cost: JsonField<Double> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var cspId: JsonField<String> = JsonMissing.of()
            private var customerId: JsonField<String> = JsonMissing.of()
            private var dcaElectionsComplete: JsonField<Boolean> = JsonMissing.of()
            private var dcaElectionsCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var helpKeywords: JsonField<String> = JsonMissing.of()
            private var helpMessage: JsonField<String> = JsonMissing.of()
            private var kycSubmissionFormId: JsonField<String> = JsonMissing.of()
            private var messageFlow: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var optinKeywords: JsonField<String> = JsonMissing.of()
            private var optinMessage: JsonField<String> = JsonMissing.of()
            private var optoutKeywords: JsonField<String> = JsonMissing.of()
            private var optoutMessage: JsonField<String> = JsonMissing.of()
            private var privacyPolicyLink: JsonField<String> = JsonMissing.of()
            private var resellerId: JsonField<String> = JsonMissing.of()
            private var sharingStatus: JsonField<SharingStatus> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var submittedToTcr: JsonField<Boolean> = JsonMissing.of()
            private var tcrCampaignId: JsonField<String> = JsonMissing.of()
            private var tcrSyncError: JsonField<String> = JsonMissing.of()
            private var telnyxCampaignId: JsonField<String> = JsonMissing.of()
            private var termsAndConditionsLink: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var upstreamCnpId: JsonField<String> = JsonMissing.of()
            private var useCases: JsonField<MutableList<UseCase>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                billedDate = data.billedDate
                brandId = data.brandId
                cost = data.cost
                createdAt = data.createdAt
                cspId = data.cspId
                customerId = data.customerId
                dcaElectionsComplete = data.dcaElectionsComplete
                dcaElectionsCompletedAt = data.dcaElectionsCompletedAt
                description = data.description
                helpKeywords = data.helpKeywords
                helpMessage = data.helpMessage
                kycSubmissionFormId = data.kycSubmissionFormId
                messageFlow = data.messageFlow
                name = data.name
                optinKeywords = data.optinKeywords
                optinMessage = data.optinMessage
                optoutKeywords = data.optoutKeywords
                optoutMessage = data.optoutMessage
                privacyPolicyLink = data.privacyPolicyLink
                resellerId = data.resellerId
                sharingStatus = data.sharingStatus
                status = data.status
                submittedAt = data.submittedAt
                submittedToTcr = data.submittedToTcr
                tcrCampaignId = data.tcrCampaignId
                tcrSyncError = data.tcrSyncError
                telnyxCampaignId = data.telnyxCampaignId
                termsAndConditionsLink = data.termsAndConditionsLink
                type = data.type
                updatedAt = data.updatedAt
                upstreamCnpId = data.upstreamCnpId
                useCases = data.useCases.map { it.toMutableList() }
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** Unique identifier */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun billedDate(billedDate: OffsetDateTime?) =
                billedDate(JsonField.ofNullable(billedDate))

            /** Alias for calling [Builder.billedDate] with `billedDate.orElse(null)`. */
            fun billedDate(billedDate: Optional<OffsetDateTime>) =
                billedDate(billedDate.getOrNull())

            /**
             * Sets [Builder.billedDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billedDate] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun billedDate(billedDate: JsonField<OffsetDateTime>) = apply {
                this.billedDate = billedDate
            }

            fun brandId(brandId: String?) = brandId(JsonField.ofNullable(brandId))

            /** Alias for calling [Builder.brandId] with `brandId.orElse(null)`. */
            fun brandId(brandId: Optional<String>) = brandId(brandId.getOrNull())

            /**
             * Sets [Builder.brandId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brandId(brandId: JsonField<String>) = apply { this.brandId = brandId }

            fun cost(cost: Double?) = cost(JsonField.ofNullable(cost))

            /**
             * Alias for [Builder.cost].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun cost(cost: Double) = cost(cost as Double?)

            /** Alias for calling [Builder.cost] with `cost.orElse(null)`. */
            fun cost(cost: Optional<Double>) = cost(cost.getOrNull())

            /**
             * Sets [Builder.cost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cost] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun cost(cost: JsonField<Double>) = apply { this.cost = cost }

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

            fun cspId(cspId: String?) = cspId(JsonField.ofNullable(cspId))

            /** Alias for calling [Builder.cspId] with `cspId.orElse(null)`. */
            fun cspId(cspId: Optional<String>) = cspId(cspId.getOrNull())

            /**
             * Sets [Builder.cspId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cspId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cspId(cspId: JsonField<String>) = apply { this.cspId = cspId }

            fun customerId(customerId: String) = customerId(JsonField.of(customerId))

            /**
             * Sets [Builder.customerId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customerId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

            fun dcaElectionsComplete(dcaElectionsComplete: Boolean) =
                dcaElectionsComplete(JsonField.of(dcaElectionsComplete))

            /**
             * Sets [Builder.dcaElectionsComplete] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dcaElectionsComplete] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun dcaElectionsComplete(dcaElectionsComplete: JsonField<Boolean>) = apply {
                this.dcaElectionsComplete = dcaElectionsComplete
            }

            fun dcaElectionsCompletedAt(dcaElectionsCompletedAt: OffsetDateTime?) =
                dcaElectionsCompletedAt(JsonField.ofNullable(dcaElectionsCompletedAt))

            /**
             * Alias for calling [Builder.dcaElectionsCompletedAt] with
             * `dcaElectionsCompletedAt.orElse(null)`.
             */
            fun dcaElectionsCompletedAt(dcaElectionsCompletedAt: Optional<OffsetDateTime>) =
                dcaElectionsCompletedAt(dcaElectionsCompletedAt.getOrNull())

            /**
             * Sets [Builder.dcaElectionsCompletedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dcaElectionsCompletedAt] with a well-typed
             * [OffsetDateTime] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun dcaElectionsCompletedAt(dcaElectionsCompletedAt: JsonField<OffsetDateTime>) =
                apply {
                    this.dcaElectionsCompletedAt = dcaElectionsCompletedAt
                }

            fun description(description: String) = description(JsonField.of(description))

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

            fun helpKeywords(helpKeywords: String?) =
                helpKeywords(JsonField.ofNullable(helpKeywords))

            /** Alias for calling [Builder.helpKeywords] with `helpKeywords.orElse(null)`. */
            fun helpKeywords(helpKeywords: Optional<String>) =
                helpKeywords(helpKeywords.getOrNull())

            /**
             * Sets [Builder.helpKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpKeywords(helpKeywords: JsonField<String>) = apply {
                this.helpKeywords = helpKeywords
            }

            fun helpMessage(helpMessage: String?) = helpMessage(JsonField.ofNullable(helpMessage))

            /** Alias for calling [Builder.helpMessage] with `helpMessage.orElse(null)`. */
            fun helpMessage(helpMessage: Optional<String>) = helpMessage(helpMessage.getOrNull())

            /**
             * Sets [Builder.helpMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpMessage(helpMessage: JsonField<String>) = apply {
                this.helpMessage = helpMessage
            }

            fun kycSubmissionFormId(kycSubmissionFormId: String?) =
                kycSubmissionFormId(JsonField.ofNullable(kycSubmissionFormId))

            /**
             * Alias for calling [Builder.kycSubmissionFormId] with
             * `kycSubmissionFormId.orElse(null)`.
             */
            fun kycSubmissionFormId(kycSubmissionFormId: Optional<String>) =
                kycSubmissionFormId(kycSubmissionFormId.getOrNull())

            /**
             * Sets [Builder.kycSubmissionFormId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.kycSubmissionFormId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun kycSubmissionFormId(kycSubmissionFormId: JsonField<String>) = apply {
                this.kycSubmissionFormId = kycSubmissionFormId
            }

            fun messageFlow(messageFlow: String?) = messageFlow(JsonField.ofNullable(messageFlow))

            /** Alias for calling [Builder.messageFlow] with `messageFlow.orElse(null)`. */
            fun messageFlow(messageFlow: Optional<String>) = messageFlow(messageFlow.getOrNull())

            /**
             * Sets [Builder.messageFlow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageFlow] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageFlow(messageFlow: JsonField<String>) = apply {
                this.messageFlow = messageFlow
            }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun optinKeywords(optinKeywords: String?) =
                optinKeywords(JsonField.ofNullable(optinKeywords))

            /** Alias for calling [Builder.optinKeywords] with `optinKeywords.orElse(null)`. */
            fun optinKeywords(optinKeywords: Optional<String>) =
                optinKeywords(optinKeywords.getOrNull())

            /**
             * Sets [Builder.optinKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optinKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optinKeywords(optinKeywords: JsonField<String>) = apply {
                this.optinKeywords = optinKeywords
            }

            fun optinMessage(optinMessage: String?) =
                optinMessage(JsonField.ofNullable(optinMessage))

            /** Alias for calling [Builder.optinMessage] with `optinMessage.orElse(null)`. */
            fun optinMessage(optinMessage: Optional<String>) =
                optinMessage(optinMessage.getOrNull())

            /**
             * Sets [Builder.optinMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optinMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optinMessage(optinMessage: JsonField<String>) = apply {
                this.optinMessage = optinMessage
            }

            fun optoutKeywords(optoutKeywords: String?) =
                optoutKeywords(JsonField.ofNullable(optoutKeywords))

            /** Alias for calling [Builder.optoutKeywords] with `optoutKeywords.orElse(null)`. */
            fun optoutKeywords(optoutKeywords: Optional<String>) =
                optoutKeywords(optoutKeywords.getOrNull())

            /**
             * Sets [Builder.optoutKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optoutKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optoutKeywords(optoutKeywords: JsonField<String>) = apply {
                this.optoutKeywords = optoutKeywords
            }

            fun optoutMessage(optoutMessage: String?) =
                optoutMessage(JsonField.ofNullable(optoutMessage))

            /** Alias for calling [Builder.optoutMessage] with `optoutMessage.orElse(null)`. */
            fun optoutMessage(optoutMessage: Optional<String>) =
                optoutMessage(optoutMessage.getOrNull())

            /**
             * Sets [Builder.optoutMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optoutMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optoutMessage(optoutMessage: JsonField<String>) = apply {
                this.optoutMessage = optoutMessage
            }

            fun privacyPolicyLink(privacyPolicyLink: String?) =
                privacyPolicyLink(JsonField.ofNullable(privacyPolicyLink))

            /**
             * Alias for calling [Builder.privacyPolicyLink] with `privacyPolicyLink.orElse(null)`.
             */
            fun privacyPolicyLink(privacyPolicyLink: Optional<String>) =
                privacyPolicyLink(privacyPolicyLink.getOrNull())

            /**
             * Sets [Builder.privacyPolicyLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.privacyPolicyLink] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun privacyPolicyLink(privacyPolicyLink: JsonField<String>) = apply {
                this.privacyPolicyLink = privacyPolicyLink
            }

            fun resellerId(resellerId: String?) = resellerId(JsonField.ofNullable(resellerId))

            /** Alias for calling [Builder.resellerId] with `resellerId.orElse(null)`. */
            fun resellerId(resellerId: Optional<String>) = resellerId(resellerId.getOrNull())

            /**
             * Sets [Builder.resellerId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resellerId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resellerId(resellerId: JsonField<String>) = apply { this.resellerId = resellerId }

            fun sharingStatus(sharingStatus: SharingStatus?) =
                sharingStatus(JsonField.ofNullable(sharingStatus))

            /** Alias for calling [Builder.sharingStatus] with `sharingStatus.orElse(null)`. */
            fun sharingStatus(sharingStatus: Optional<SharingStatus>) =
                sharingStatus(sharingStatus.getOrNull())

            /**
             * Sets [Builder.sharingStatus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sharingStatus] with a well-typed [SharingStatus]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun sharingStatus(sharingStatus: JsonField<SharingStatus>) = apply {
                this.sharingStatus = sharingStatus
            }

            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun submittedAt(submittedAt: OffsetDateTime?) =
                submittedAt(JsonField.ofNullable(submittedAt))

            /** Alias for calling [Builder.submittedAt] with `submittedAt.orElse(null)`. */
            fun submittedAt(submittedAt: Optional<OffsetDateTime>) =
                submittedAt(submittedAt.getOrNull())

            /**
             * Sets [Builder.submittedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.submittedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
                this.submittedAt = submittedAt
            }

            fun submittedToTcr(submittedToTcr: Boolean) =
                submittedToTcr(JsonField.of(submittedToTcr))

            /**
             * Sets [Builder.submittedToTcr] to an arbitrary JSON value.
             *
             * You should usually call [Builder.submittedToTcr] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun submittedToTcr(submittedToTcr: JsonField<Boolean>) = apply {
                this.submittedToTcr = submittedToTcr
            }

            fun tcrCampaignId(tcrCampaignId: String?) =
                tcrCampaignId(JsonField.ofNullable(tcrCampaignId))

            /** Alias for calling [Builder.tcrCampaignId] with `tcrCampaignId.orElse(null)`. */
            fun tcrCampaignId(tcrCampaignId: Optional<String>) =
                tcrCampaignId(tcrCampaignId.getOrNull())

            /**
             * Sets [Builder.tcrCampaignId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tcrCampaignId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tcrCampaignId(tcrCampaignId: JsonField<String>) = apply {
                this.tcrCampaignId = tcrCampaignId
            }

            fun tcrSyncError(tcrSyncError: String?) =
                tcrSyncError(JsonField.ofNullable(tcrSyncError))

            /** Alias for calling [Builder.tcrSyncError] with `tcrSyncError.orElse(null)`. */
            fun tcrSyncError(tcrSyncError: Optional<String>) =
                tcrSyncError(tcrSyncError.getOrNull())

            /**
             * Sets [Builder.tcrSyncError] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tcrSyncError] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tcrSyncError(tcrSyncError: JsonField<String>) = apply {
                this.tcrSyncError = tcrSyncError
            }

            fun telnyxCampaignId(telnyxCampaignId: String?) =
                telnyxCampaignId(JsonField.ofNullable(telnyxCampaignId))

            /**
             * Alias for calling [Builder.telnyxCampaignId] with `telnyxCampaignId.orElse(null)`.
             */
            fun telnyxCampaignId(telnyxCampaignId: Optional<String>) =
                telnyxCampaignId(telnyxCampaignId.getOrNull())

            /**
             * Sets [Builder.telnyxCampaignId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.telnyxCampaignId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun telnyxCampaignId(telnyxCampaignId: JsonField<String>) = apply {
                this.telnyxCampaignId = telnyxCampaignId
            }

            fun termsAndConditionsLink(termsAndConditionsLink: String?) =
                termsAndConditionsLink(JsonField.ofNullable(termsAndConditionsLink))

            /**
             * Alias for calling [Builder.termsAndConditionsLink] with
             * `termsAndConditionsLink.orElse(null)`.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: Optional<String>) =
                termsAndConditionsLink(termsAndConditionsLink.getOrNull())

            /**
             * Sets [Builder.termsAndConditionsLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: JsonField<String>) = apply {
                this.termsAndConditionsLink = termsAndConditionsLink
            }

            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

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
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
            }

            fun upstreamCnpId(upstreamCnpId: String?) =
                upstreamCnpId(JsonField.ofNullable(upstreamCnpId))

            /** Alias for calling [Builder.upstreamCnpId] with `upstreamCnpId.orElse(null)`. */
            fun upstreamCnpId(upstreamCnpId: Optional<String>) =
                upstreamCnpId(upstreamCnpId.getOrNull())

            /**
             * Sets [Builder.upstreamCnpId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.upstreamCnpId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun upstreamCnpId(upstreamCnpId: JsonField<String>) = apply {
                this.upstreamCnpId = upstreamCnpId
            }

            fun useCases(useCases: List<UseCase>) = useCases(JsonField.of(useCases))

            /**
             * Sets [Builder.useCases] to an arbitrary JSON value.
             *
             * You should usually call [Builder.useCases] with a well-typed `List<UseCase>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun useCases(useCases: JsonField<List<UseCase>>) = apply {
                this.useCases = useCases.map { it.toMutableList() }
            }

            /**
             * Adds a single [UseCase] to [useCases].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUseCase(useCase: UseCase) = apply {
                useCases =
                    (useCases ?: JsonField.of(mutableListOf())).also {
                        checkKnown("useCases", it).add(useCase)
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    id,
                    billedDate,
                    brandId,
                    cost,
                    createdAt,
                    cspId,
                    customerId,
                    dcaElectionsComplete,
                    dcaElectionsCompletedAt,
                    description,
                    helpKeywords,
                    helpMessage,
                    kycSubmissionFormId,
                    messageFlow,
                    name,
                    optinKeywords,
                    optinMessage,
                    optoutKeywords,
                    optoutMessage,
                    privacyPolicyLink,
                    resellerId,
                    sharingStatus,
                    status,
                    submittedAt,
                    submittedToTcr,
                    tcrCampaignId,
                    tcrSyncError,
                    telnyxCampaignId,
                    termsAndConditionsLink,
                    type,
                    updatedAt,
                    upstreamCnpId,
                    (useCases ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            billedDate()
            brandId()
            cost()
            createdAt()
            cspId()
            customerId()
            dcaElectionsComplete()
            dcaElectionsCompletedAt()
            description()
            helpKeywords()
            helpMessage()
            kycSubmissionFormId()
            messageFlow()
            name()
            optinKeywords()
            optinMessage()
            optoutKeywords()
            optoutMessage()
            privacyPolicyLink()
            resellerId()
            sharingStatus().ifPresent { it.validate() }
            status().ifPresent { it.validate() }
            submittedAt()
            submittedToTcr()
            tcrCampaignId()
            tcrSyncError()
            telnyxCampaignId()
            termsAndConditionsLink()
            type()
            updatedAt()
            upstreamCnpId()
            useCases().ifPresent { it.forEach { it.validate() } }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (billedDate.asKnown().isPresent) 1 else 0) +
                (if (brandId.asKnown().isPresent) 1 else 0) +
                (if (cost.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (cspId.asKnown().isPresent) 1 else 0) +
                (if (customerId.asKnown().isPresent) 1 else 0) +
                (if (dcaElectionsComplete.asKnown().isPresent) 1 else 0) +
                (if (dcaElectionsCompletedAt.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (helpKeywords.asKnown().isPresent) 1 else 0) +
                (if (helpMessage.asKnown().isPresent) 1 else 0) +
                (if (kycSubmissionFormId.asKnown().isPresent) 1 else 0) +
                (if (messageFlow.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (optinKeywords.asKnown().isPresent) 1 else 0) +
                (if (optinMessage.asKnown().isPresent) 1 else 0) +
                (if (optoutKeywords.asKnown().isPresent) 1 else 0) +
                (if (optoutMessage.asKnown().isPresent) 1 else 0) +
                (if (privacyPolicyLink.asKnown().isPresent) 1 else 0) +
                (if (resellerId.asKnown().isPresent) 1 else 0) +
                (sharingStatus.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (submittedAt.asKnown().isPresent) 1 else 0) +
                (if (submittedToTcr.asKnown().isPresent) 1 else 0) +
                (if (tcrCampaignId.asKnown().isPresent) 1 else 0) +
                (if (tcrSyncError.asKnown().isPresent) 1 else 0) +
                (if (telnyxCampaignId.asKnown().isPresent) 1 else 0) +
                (if (termsAndConditionsLink.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0) +
                (if (upstreamCnpId.asKnown().isPresent) 1 else 0) +
                (useCases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class SharingStatus @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val PENDING = of("PENDING")

                @JvmField val ACCEPTED = of("ACCEPTED")

                @JvmField val DECLINED = of("DECLINED")

                @JvmStatic fun of(value: String) = SharingStatus(JsonField.of(value))
            }

            /** An enum containing [SharingStatus]'s known values. */
            enum class Known {
                PENDING,
                ACCEPTED,
                DECLINED,
            }

            /**
             * An enum containing [SharingStatus]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [SharingStatus] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PENDING,
                ACCEPTED,
                DECLINED,
                /**
                 * An enum member indicating that [SharingStatus] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    PENDING -> Value.PENDING
                    ACCEPTED -> Value.ACCEPTED
                    DECLINED -> Value.DECLINED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SentInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    PENDING -> Known.PENDING
                    ACCEPTED -> Known.ACCEPTED
                    DECLINED -> Known.DECLINED
                    else -> throw SentInvalidDataException("Unknown SharingStatus: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentInvalidDataException("Value is not a String")
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
            fun validate(): SharingStatus = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SharingStatus && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SENT_CREATED = of("SENT_CREATED")

                @JvmField val ACTIVE = of("ACTIVE")

                @JvmField val EXPIRED = of("EXPIRED")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                SENT_CREATED,
                ACTIVE,
                EXPIRED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SENT_CREATED,
                ACTIVE,
                EXPIRED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SENT_CREATED -> Value.SENT_CREATED
                    ACTIVE -> Value.ACTIVE
                    EXPIRED -> Value.EXPIRED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SentInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SENT_CREATED -> Known.SENT_CREATED
                    ACTIVE -> Known.ACTIVE
                    EXPIRED -> Known.EXPIRED
                    else -> throw SentInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentInvalidDataException("Value is not a String")
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
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class UseCase
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
             * Unique identifier
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun campaignId(): Optional<String> = campaignId.getOptional("campaignId")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun customerId(): Optional<String> = customerId.getOptional("customerId")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun messagingUseCaseUs(): Optional<MessagingUseCaseUs> =
                messagingUseCaseUs.getOptional("messagingUseCaseUs")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun sampleMessages(): Optional<List<String>> =
                sampleMessages.getOptional("sampleMessages")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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
             * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("campaignId")
            @ExcludeMissing
            fun _campaignId(): JsonField<String> = campaignId

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [customerId].
             *
             * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("customerId")
            @ExcludeMissing
            fun _customerId(): JsonField<String> = customerId

            /**
             * Returns the raw JSON value of [messagingUseCaseUs].
             *
             * Unlike [messagingUseCaseUs], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("messagingUseCaseUs")
            @ExcludeMissing
            fun _messagingUseCaseUs(): JsonField<MessagingUseCaseUs> = messagingUseCaseUs

            /**
             * Returns the raw JSON value of [sampleMessages].
             *
             * Unlike [sampleMessages], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sampleMessages")
            @ExcludeMissing
            fun _sampleMessages(): JsonField<List<String>> = sampleMessages

            /**
             * Returns the raw JSON value of [updatedAt].
             *
             * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
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

                /** Returns a mutable builder for constructing an instance of [UseCase]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UseCase]. */
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
                internal fun from(useCase: UseCase) = apply {
                    id = useCase.id
                    campaignId = useCase.campaignId
                    createdAt = useCase.createdAt
                    customerId = useCase.customerId
                    messagingUseCaseUs = useCase.messagingUseCaseUs
                    sampleMessages = useCase.sampleMessages.map { it.toMutableList() }
                    updatedAt = useCase.updatedAt
                    additionalProperties = useCase.additionalProperties.toMutableMap()
                }

                /** Unique identifier */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun campaignId(campaignId: String) = campaignId(JsonField.of(campaignId))

                /**
                 * Sets [Builder.campaignId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.campaignId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun campaignId(campaignId: JsonField<String>) = apply {
                    this.campaignId = campaignId
                }

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

                fun customerId(customerId: String) = customerId(JsonField.of(customerId))

                /**
                 * Sets [Builder.customerId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.customerId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun customerId(customerId: JsonField<String>) = apply {
                    this.customerId = customerId
                }

                fun messagingUseCaseUs(messagingUseCaseUs: MessagingUseCaseUs) =
                    messagingUseCaseUs(JsonField.of(messagingUseCaseUs))

                /**
                 * Sets [Builder.messagingUseCaseUs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.messagingUseCaseUs] with a well-typed
                 * [MessagingUseCaseUs] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun messagingUseCaseUs(messagingUseCaseUs: JsonField<MessagingUseCaseUs>) = apply {
                    this.messagingUseCaseUs = messagingUseCaseUs
                }

                fun sampleMessages(sampleMessages: List<String>) =
                    sampleMessages(JsonField.of(sampleMessages))

                /**
                 * Sets [Builder.sampleMessages] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sampleMessages] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
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

                fun updatedAt(updatedAt: OffsetDateTime?) =
                    updatedAt(JsonField.ofNullable(updatedAt))

                /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
                fun updatedAt(updatedAt: Optional<OffsetDateTime>) =
                    updatedAt(updatedAt.getOrNull())

                /**
                 * Sets [Builder.updatedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                    this.updatedAt = updatedAt
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
                 * Returns an immutable instance of [UseCase].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): UseCase =
                    UseCase(
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
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): UseCase = apply {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
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

            class MessagingUseCaseUs
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val MARKETING = of("MARKETING")

                    @JvmField val ACCOUNT_NOTIFICATION = of("ACCOUNT_NOTIFICATION")

                    @JvmField val CUSTOMER_CARE = of("CUSTOMER_CARE")

                    @JvmField val FRAUD_ALERT = of("FRAUD_ALERT")

                    @JvmField val TWO_FA = of("TWO_FA")

                    @JvmField val DELIVERY_NOTIFICATION = of("DELIVERY_NOTIFICATION")

                    @JvmField val SECURITY_ALERT = of("SECURITY_ALERT")

                    @JvmField val M2_M = of("M2M")

                    @JvmField val MIXED = of("MIXED")

                    @JvmField val HIGHER_EDUCATION = of("HIGHER_EDUCATION")

                    @JvmField val POLLING_VOTING = of("POLLING_VOTING")

                    @JvmField val PUBLIC_SERVICE_ANNOUNCEMENT = of("PUBLIC_SERVICE_ANNOUNCEMENT")

                    @JvmField val LOW_VOLUME = of("LOW_VOLUME")

                    @JvmStatic fun of(value: String) = MessagingUseCaseUs(JsonField.of(value))
                }

                /** An enum containing [MessagingUseCaseUs]'s known values. */
                enum class Known {
                    MARKETING,
                    ACCOUNT_NOTIFICATION,
                    CUSTOMER_CARE,
                    FRAUD_ALERT,
                    TWO_FA,
                    DELIVERY_NOTIFICATION,
                    SECURITY_ALERT,
                    M2_M,
                    MIXED,
                    HIGHER_EDUCATION,
                    POLLING_VOTING,
                    PUBLIC_SERVICE_ANNOUNCEMENT,
                    LOW_VOLUME,
                }

                /**
                 * An enum containing [MessagingUseCaseUs]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [MessagingUseCaseUs] can contain an unknown value in a couple of
                 * cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    MARKETING,
                    ACCOUNT_NOTIFICATION,
                    CUSTOMER_CARE,
                    FRAUD_ALERT,
                    TWO_FA,
                    DELIVERY_NOTIFICATION,
                    SECURITY_ALERT,
                    M2_M,
                    MIXED,
                    HIGHER_EDUCATION,
                    POLLING_VOTING,
                    PUBLIC_SERVICE_ANNOUNCEMENT,
                    LOW_VOLUME,
                    /**
                     * An enum member indicating that [MessagingUseCaseUs] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        MARKETING -> Value.MARKETING
                        ACCOUNT_NOTIFICATION -> Value.ACCOUNT_NOTIFICATION
                        CUSTOMER_CARE -> Value.CUSTOMER_CARE
                        FRAUD_ALERT -> Value.FRAUD_ALERT
                        TWO_FA -> Value.TWO_FA
                        DELIVERY_NOTIFICATION -> Value.DELIVERY_NOTIFICATION
                        SECURITY_ALERT -> Value.SECURITY_ALERT
                        M2_M -> Value.M2_M
                        MIXED -> Value.MIXED
                        HIGHER_EDUCATION -> Value.HIGHER_EDUCATION
                        POLLING_VOTING -> Value.POLLING_VOTING
                        PUBLIC_SERVICE_ANNOUNCEMENT -> Value.PUBLIC_SERVICE_ANNOUNCEMENT
                        LOW_VOLUME -> Value.LOW_VOLUME
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SentInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        MARKETING -> Known.MARKETING
                        ACCOUNT_NOTIFICATION -> Known.ACCOUNT_NOTIFICATION
                        CUSTOMER_CARE -> Known.CUSTOMER_CARE
                        FRAUD_ALERT -> Known.FRAUD_ALERT
                        TWO_FA -> Known.TWO_FA
                        DELIVERY_NOTIFICATION -> Known.DELIVERY_NOTIFICATION
                        SECURITY_ALERT -> Known.SECURITY_ALERT
                        M2_M -> Known.M2_M
                        MIXED -> Known.MIXED
                        HIGHER_EDUCATION -> Known.HIGHER_EDUCATION
                        POLLING_VOTING -> Known.POLLING_VOTING
                        PUBLIC_SERVICE_ANNOUNCEMENT -> Known.PUBLIC_SERVICE_ANNOUNCEMENT
                        LOW_VOLUME -> Known.LOW_VOLUME
                        else -> throw SentInvalidDataException("Unknown MessagingUseCaseUs: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SentInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        SentInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): MessagingUseCaseUs = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
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
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is MessagingUseCaseUs && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UseCase &&
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
                "UseCase{id=$id, campaignId=$campaignId, createdAt=$createdAt, customerId=$customerId, messagingUseCaseUs=$messagingUseCaseUs, sampleMessages=$sampleMessages, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                billedDate == other.billedDate &&
                brandId == other.brandId &&
                cost == other.cost &&
                createdAt == other.createdAt &&
                cspId == other.cspId &&
                customerId == other.customerId &&
                dcaElectionsComplete == other.dcaElectionsComplete &&
                dcaElectionsCompletedAt == other.dcaElectionsCompletedAt &&
                description == other.description &&
                helpKeywords == other.helpKeywords &&
                helpMessage == other.helpMessage &&
                kycSubmissionFormId == other.kycSubmissionFormId &&
                messageFlow == other.messageFlow &&
                name == other.name &&
                optinKeywords == other.optinKeywords &&
                optinMessage == other.optinMessage &&
                optoutKeywords == other.optoutKeywords &&
                optoutMessage == other.optoutMessage &&
                privacyPolicyLink == other.privacyPolicyLink &&
                resellerId == other.resellerId &&
                sharingStatus == other.sharingStatus &&
                status == other.status &&
                submittedAt == other.submittedAt &&
                submittedToTcr == other.submittedToTcr &&
                tcrCampaignId == other.tcrCampaignId &&
                tcrSyncError == other.tcrSyncError &&
                telnyxCampaignId == other.telnyxCampaignId &&
                termsAndConditionsLink == other.termsAndConditionsLink &&
                type == other.type &&
                updatedAt == other.updatedAt &&
                upstreamCnpId == other.upstreamCnpId &&
                useCases == other.useCases &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                billedDate,
                brandId,
                cost,
                createdAt,
                cspId,
                customerId,
                dcaElectionsComplete,
                dcaElectionsCompletedAt,
                description,
                helpKeywords,
                helpMessage,
                kycSubmissionFormId,
                messageFlow,
                name,
                optinKeywords,
                optinMessage,
                optoutKeywords,
                optoutMessage,
                privacyPolicyLink,
                resellerId,
                sharingStatus,
                status,
                submittedAt,
                submittedToTcr,
                tcrCampaignId,
                tcrSyncError,
                telnyxCampaignId,
                termsAndConditionsLink,
                type,
                updatedAt,
                upstreamCnpId,
                useCases,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, billedDate=$billedDate, brandId=$brandId, cost=$cost, createdAt=$createdAt, cspId=$cspId, customerId=$customerId, dcaElectionsComplete=$dcaElectionsComplete, dcaElectionsCompletedAt=$dcaElectionsCompletedAt, description=$description, helpKeywords=$helpKeywords, helpMessage=$helpMessage, kycSubmissionFormId=$kycSubmissionFormId, messageFlow=$messageFlow, name=$name, optinKeywords=$optinKeywords, optinMessage=$optinMessage, optoutKeywords=$optoutKeywords, optoutMessage=$optoutMessage, privacyPolicyLink=$privacyPolicyLink, resellerId=$resellerId, sharingStatus=$sharingStatus, status=$status, submittedAt=$submittedAt, submittedToTcr=$submittedToTcr, tcrCampaignId=$tcrCampaignId, tcrSyncError=$tcrSyncError, telnyxCampaignId=$telnyxCampaignId, termsAndConditionsLink=$termsAndConditionsLink, type=$type, updatedAt=$updatedAt, upstreamCnpId=$upstreamCnpId, useCases=$useCases, additionalProperties=$additionalProperties}"
    }

    /** Error information */
    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val details: JsonField<Details>,
        private val docUrl: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
            @JsonProperty("doc_url") @ExcludeMissing docUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(code, details, docUrl, message, mutableMapOf())

        /**
         * Machine-readable error code (e.g., "RESOURCE_001")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun code(): Optional<String> = code.getOptional("code")

        /**
         * Additional validation error details (field-level errors)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun details(): Optional<Details> = details.getOptional("details")

        /**
         * URL to documentation about this error
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun docUrl(): Optional<String> = docUrl.getOptional("doc_url")

        /**
         * Human-readable error message
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun message(): Optional<String> = message.getOptional("message")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [details].
         *
         * Unlike [details], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

        /**
         * Returns the raw JSON value of [docUrl].
         *
         * Unlike [docUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("doc_url") @ExcludeMissing fun _docUrl(): JsonField<String> = docUrl

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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

            /** Returns a mutable builder for constructing an instance of [Error]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var code: JsonField<String> = JsonMissing.of()
            private var details: JsonField<Details> = JsonMissing.of()
            private var docUrl: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                details = error.details
                docUrl = error.docUrl
                message = error.message
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /** Machine-readable error code (e.g., "RESOURCE_001") */
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Additional validation error details (field-level errors) */
            fun details(details: Details?) = details(JsonField.ofNullable(details))

            /** Alias for calling [Builder.details] with `details.orElse(null)`. */
            fun details(details: Optional<Details>) = details(details.getOrNull())

            /**
             * Sets [Builder.details] to an arbitrary JSON value.
             *
             * You should usually call [Builder.details] with a well-typed [Details] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun details(details: JsonField<Details>) = apply { this.details = details }

            /** URL to documentation about this error */
            fun docUrl(docUrl: String?) = docUrl(JsonField.ofNullable(docUrl))

            /** Alias for calling [Builder.docUrl] with `docUrl.orElse(null)`. */
            fun docUrl(docUrl: Optional<String>) = docUrl(docUrl.getOrNull())

            /**
             * Sets [Builder.docUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.docUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun docUrl(docUrl: JsonField<String>) = apply { this.docUrl = docUrl }

            /** Human-readable error message */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

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
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Error =
                Error(code, details, docUrl, message, additionalProperties.toMutableMap())
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
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            code()
            details().ifPresent { it.validate() }
            docUrl()
            message()
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (details.asKnown().getOrNull()?.validity() ?: 0) +
                (if (docUrl.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0)

        /** Additional validation error details (field-level errors) */
        class Details
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

                /** Returns a mutable builder for constructing an instance of [Details]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Details]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(details: Details) = apply {
                    additionalProperties = details.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Details].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Details = Details(additionalProperties.toImmutable())
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
            fun validate(): Details = apply {
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

                return other is Details && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Details{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                details == other.details &&
                docUrl == other.docUrl &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, details, docUrl, message, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, details=$details, docUrl=$docUrl, message=$message, additionalProperties=$additionalProperties}"
    }

    /** Request and response metadata */
    class Meta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val requestId: JsonField<String>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val version: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
        ) : this(requestId, timestamp, version, mutableMapOf())

        /**
         * Unique identifier for this request (for tracing and support)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

        /**
         * Server timestamp when the response was generated
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

        /**
         * API version used for this request
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun version(): Optional<String> = version.getOptional("version")

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [timestamp].
         *
         * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timestamp")
        @ExcludeMissing
        fun _timestamp(): JsonField<OffsetDateTime> = timestamp

        /**
         * Returns the raw JSON value of [version].
         *
         * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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

            /** Returns a mutable builder for constructing an instance of [Meta]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Meta]. */
        class Builder internal constructor() {

            private var requestId: JsonField<String> = JsonMissing.of()
            private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
            private var version: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(meta: Meta) = apply {
                requestId = meta.requestId
                timestamp = meta.timestamp
                version = meta.version
                additionalProperties = meta.additionalProperties.toMutableMap()
            }

            /** Unique identifier for this request (for tracing and support) */
            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            /** Server timestamp when the response was generated */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
            }

            /** API version used for this request */
            fun version(version: String) = version(JsonField.of(version))

            /**
             * Sets [Builder.version] to an arbitrary JSON value.
             *
             * You should usually call [Builder.version] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun version(version: JsonField<String>) = apply { this.version = version }

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
             * Returns an immutable instance of [Meta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Meta =
                Meta(requestId, timestamp, version, additionalProperties.toMutableMap())
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
        fun validate(): Meta = apply {
            if (validated) {
                return@apply
            }

            requestId()
            timestamp()
            version()
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
            (if (requestId.asKnown().isPresent) 1 else 0) +
                (if (timestamp.asKnown().isPresent) 1 else 0) +
                (if (version.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Meta &&
                requestId == other.requestId &&
                timestamp == other.timestamp &&
                version == other.version &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(requestId, timestamp, version, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Meta{requestId=$requestId, timestamp=$timestamp, version=$version, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CampaignCreateResponse &&
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
        "CampaignCreateResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
