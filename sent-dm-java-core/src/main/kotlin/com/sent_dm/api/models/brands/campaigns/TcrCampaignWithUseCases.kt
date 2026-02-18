// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands.campaigns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.Enum
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TcrCampaignWithUseCases
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val billedDate: JsonField<OffsetDateTime>,
    private val brandId: JsonField<String>,
    private val cost: JsonField<Double>,
    private val cspId: JsonField<String>,
    private val customerId: JsonField<String>,
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
    private val upstreamCnpId: JsonField<String>,
    private val useCases: JsonField<List<UseCase>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("billedDate")
        @ExcludeMissing
        billedDate: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("brandId") @ExcludeMissing brandId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cost") @ExcludeMissing cost: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("cspId") @ExcludeMissing cspId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customerId")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
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
        @JsonProperty("upstreamCnpId")
        @ExcludeMissing
        upstreamCnpId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("useCases")
        @ExcludeMissing
        useCases: JsonField<List<UseCase>> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        updatedAt,
        billedDate,
        brandId,
        cost,
        cspId,
        customerId,
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
        upstreamCnpId,
        useCases,
        mutableMapOf(),
    )

    fun toBaseDto(): BaseDto =
        BaseDto.builder().id(id).createdAt(createdAt).updatedAt(updatedAt).build()

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
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun billedDate(): Optional<OffsetDateTime> = billedDate.getOptional("billedDate")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun brandId(): Optional<String> = brandId.getOptional("brandId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cost(): Optional<Double> = cost.getOptional("cost")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cspId(): Optional<String> = cspId.getOptional("cspId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customerId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun helpKeywords(): Optional<String> = helpKeywords.getOptional("helpKeywords")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun helpMessage(): Optional<String> = helpMessage.getOptional("helpMessage")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kycSubmissionFormId(): Optional<String> =
        kycSubmissionFormId.getOptional("kycSubmissionFormId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun messageFlow(): Optional<String> = messageFlow.getOptional("messageFlow")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optinKeywords(): Optional<String> = optinKeywords.getOptional("optinKeywords")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optinMessage(): Optional<String> = optinMessage.getOptional("optinMessage")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optoutKeywords(): Optional<String> = optoutKeywords.getOptional("optoutKeywords")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optoutMessage(): Optional<String> = optoutMessage.getOptional("optoutMessage")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun privacyPolicyLink(): Optional<String> = privacyPolicyLink.getOptional("privacyPolicyLink")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun resellerId(): Optional<String> = resellerId.getOptional("resellerId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sharingStatus(): Optional<SharingStatus> = sharingStatus.getOptional("sharingStatus")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun submittedAt(): Optional<OffsetDateTime> = submittedAt.getOptional("submittedAt")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun submittedToTcr(): Optional<Boolean> = submittedToTcr.getOptional("submittedToTCR")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tcrCampaignId(): Optional<String> = tcrCampaignId.getOptional("tcrCampaignId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tcrSyncError(): Optional<String> = tcrSyncError.getOptional("tcrSyncError")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun telnyxCampaignId(): Optional<String> = telnyxCampaignId.getOptional("telnyxCampaignId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun termsAndConditionsLink(): Optional<String> =
        termsAndConditionsLink.getOptional("termsAndConditionsLink")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun upstreamCnpId(): Optional<String> = upstreamCnpId.getOptional("upstreamCnpId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
    @JsonProperty("customerId") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [helpKeywords].
     *
     * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("helpKeywords")
    @ExcludeMissing
    fun _helpKeywords(): JsonField<String> = helpKeywords

    /**
     * Returns the raw JSON value of [helpMessage].
     *
     * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("helpMessage") @ExcludeMissing fun _helpMessage(): JsonField<String> = helpMessage

    /**
     * Returns the raw JSON value of [kycSubmissionFormId].
     *
     * Unlike [kycSubmissionFormId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("kycSubmissionFormId")
    @ExcludeMissing
    fun _kycSubmissionFormId(): JsonField<String> = kycSubmissionFormId

    /**
     * Returns the raw JSON value of [messageFlow].
     *
     * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageFlow") @ExcludeMissing fun _messageFlow(): JsonField<String> = messageFlow

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [optinKeywords].
     *
     * Unlike [optinKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optinKeywords")
    @ExcludeMissing
    fun _optinKeywords(): JsonField<String> = optinKeywords

    /**
     * Returns the raw JSON value of [optinMessage].
     *
     * Unlike [optinMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optinMessage")
    @ExcludeMissing
    fun _optinMessage(): JsonField<String> = optinMessage

    /**
     * Returns the raw JSON value of [optoutKeywords].
     *
     * Unlike [optoutKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optoutKeywords")
    @ExcludeMissing
    fun _optoutKeywords(): JsonField<String> = optoutKeywords

    /**
     * Returns the raw JSON value of [optoutMessage].
     *
     * Unlike [optoutMessage], this method doesn't throw if the JSON field has an unexpected type.
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
    @JsonProperty("resellerId") @ExcludeMissing fun _resellerId(): JsonField<String> = resellerId

    /**
     * Returns the raw JSON value of [sharingStatus].
     *
     * Unlike [sharingStatus], this method doesn't throw if the JSON field has an unexpected type.
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
     * Unlike [submittedToTcr], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("submittedToTCR")
    @ExcludeMissing
    fun _submittedToTcr(): JsonField<Boolean> = submittedToTcr

    /**
     * Returns the raw JSON value of [tcrCampaignId].
     *
     * Unlike [tcrCampaignId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tcrCampaignId")
    @ExcludeMissing
    fun _tcrCampaignId(): JsonField<String> = tcrCampaignId

    /**
     * Returns the raw JSON value of [tcrSyncError].
     *
     * Unlike [tcrSyncError], this method doesn't throw if the JSON field has an unexpected type.
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
     * Returns the raw JSON value of [upstreamCnpId].
     *
     * Unlike [upstreamCnpId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("upstreamCnpId")
    @ExcludeMissing
    fun _upstreamCnpId(): JsonField<String> = upstreamCnpId

    /**
     * Returns the raw JSON value of [useCases].
     *
     * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("useCases") @ExcludeMissing fun _useCases(): JsonField<List<UseCase>> = useCases

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

        /** Returns a mutable builder for constructing an instance of [TcrCampaignWithUseCases]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TcrCampaignWithUseCases]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var billedDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var brandId: JsonField<String> = JsonMissing.of()
        private var cost: JsonField<Double> = JsonMissing.of()
        private var cspId: JsonField<String> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
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
        private var upstreamCnpId: JsonField<String> = JsonMissing.of()
        private var useCases: JsonField<MutableList<UseCase>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tcrCampaignWithUseCases: TcrCampaignWithUseCases) = apply {
            id = tcrCampaignWithUseCases.id
            createdAt = tcrCampaignWithUseCases.createdAt
            updatedAt = tcrCampaignWithUseCases.updatedAt
            billedDate = tcrCampaignWithUseCases.billedDate
            brandId = tcrCampaignWithUseCases.brandId
            cost = tcrCampaignWithUseCases.cost
            cspId = tcrCampaignWithUseCases.cspId
            customerId = tcrCampaignWithUseCases.customerId
            description = tcrCampaignWithUseCases.description
            helpKeywords = tcrCampaignWithUseCases.helpKeywords
            helpMessage = tcrCampaignWithUseCases.helpMessage
            kycSubmissionFormId = tcrCampaignWithUseCases.kycSubmissionFormId
            messageFlow = tcrCampaignWithUseCases.messageFlow
            name = tcrCampaignWithUseCases.name
            optinKeywords = tcrCampaignWithUseCases.optinKeywords
            optinMessage = tcrCampaignWithUseCases.optinMessage
            optoutKeywords = tcrCampaignWithUseCases.optoutKeywords
            optoutMessage = tcrCampaignWithUseCases.optoutMessage
            privacyPolicyLink = tcrCampaignWithUseCases.privacyPolicyLink
            resellerId = tcrCampaignWithUseCases.resellerId
            sharingStatus = tcrCampaignWithUseCases.sharingStatus
            status = tcrCampaignWithUseCases.status
            submittedAt = tcrCampaignWithUseCases.submittedAt
            submittedToTcr = tcrCampaignWithUseCases.submittedToTcr
            tcrCampaignId = tcrCampaignWithUseCases.tcrCampaignId
            tcrSyncError = tcrCampaignWithUseCases.tcrSyncError
            telnyxCampaignId = tcrCampaignWithUseCases.telnyxCampaignId
            termsAndConditionsLink = tcrCampaignWithUseCases.termsAndConditionsLink
            type = tcrCampaignWithUseCases.type
            upstreamCnpId = tcrCampaignWithUseCases.upstreamCnpId
            useCases = tcrCampaignWithUseCases.useCases.map { it.toMutableList() }
            additionalProperties = tcrCampaignWithUseCases.additionalProperties.toMutableMap()
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

        fun billedDate(billedDate: OffsetDateTime?) = billedDate(JsonField.ofNullable(billedDate))

        /** Alias for calling [Builder.billedDate] with `billedDate.orElse(null)`. */
        fun billedDate(billedDate: Optional<OffsetDateTime>) = billedDate(billedDate.getOrNull())

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
         * You should usually call [Builder.brandId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cost(cost: JsonField<Double>) = apply { this.cost = cost }

        fun cspId(cspId: String?) = cspId(JsonField.ofNullable(cspId))

        /** Alias for calling [Builder.cspId] with `cspId.orElse(null)`. */
        fun cspId(cspId: Optional<String>) = cspId(cspId.getOrNull())

        /**
         * Sets [Builder.cspId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cspId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cspId(cspId: JsonField<String>) = apply { this.cspId = cspId }

        fun customerId(customerId: String) = customerId(JsonField.of(customerId))

        /**
         * Sets [Builder.customerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun helpKeywords(helpKeywords: String?) = helpKeywords(JsonField.ofNullable(helpKeywords))

        /** Alias for calling [Builder.helpKeywords] with `helpKeywords.orElse(null)`. */
        fun helpKeywords(helpKeywords: Optional<String>) = helpKeywords(helpKeywords.getOrNull())

        /**
         * Sets [Builder.helpKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.helpKeywords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.helpMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun helpMessage(helpMessage: JsonField<String>) = apply { this.helpMessage = helpMessage }

        fun kycSubmissionFormId(kycSubmissionFormId: String?) =
            kycSubmissionFormId(JsonField.ofNullable(kycSubmissionFormId))

        /**
         * Alias for calling [Builder.kycSubmissionFormId] with `kycSubmissionFormId.orElse(null)`.
         */
        fun kycSubmissionFormId(kycSubmissionFormId: Optional<String>) =
            kycSubmissionFormId(kycSubmissionFormId.getOrNull())

        /**
         * Sets [Builder.kycSubmissionFormId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kycSubmissionFormId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * You should usually call [Builder.messageFlow] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageFlow(messageFlow: JsonField<String>) = apply { this.messageFlow = messageFlow }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.optinKeywords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optinKeywords(optinKeywords: JsonField<String>) = apply {
            this.optinKeywords = optinKeywords
        }

        fun optinMessage(optinMessage: String?) = optinMessage(JsonField.ofNullable(optinMessage))

        /** Alias for calling [Builder.optinMessage] with `optinMessage.orElse(null)`. */
        fun optinMessage(optinMessage: Optional<String>) = optinMessage(optinMessage.getOrNull())

        /**
         * Sets [Builder.optinMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optinMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.optoutMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optoutMessage(optoutMessage: JsonField<String>) = apply {
            this.optoutMessage = optoutMessage
        }

        fun privacyPolicyLink(privacyPolicyLink: String?) =
            privacyPolicyLink(JsonField.ofNullable(privacyPolicyLink))

        /** Alias for calling [Builder.privacyPolicyLink] with `privacyPolicyLink.orElse(null)`. */
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
         * You should usually call [Builder.resellerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.sharingStatus] with a well-typed [SharingStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.submittedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
            this.submittedAt = submittedAt
        }

        fun submittedToTcr(submittedToTcr: Boolean) = submittedToTcr(JsonField.of(submittedToTcr))

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
         * You should usually call [Builder.tcrCampaignId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tcrCampaignId(tcrCampaignId: JsonField<String>) = apply {
            this.tcrCampaignId = tcrCampaignId
        }

        fun tcrSyncError(tcrSyncError: String?) = tcrSyncError(JsonField.ofNullable(tcrSyncError))

        /** Alias for calling [Builder.tcrSyncError] with `tcrSyncError.orElse(null)`. */
        fun tcrSyncError(tcrSyncError: Optional<String>) = tcrSyncError(tcrSyncError.getOrNull())

        /**
         * Sets [Builder.tcrSyncError] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tcrSyncError] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tcrSyncError(tcrSyncError: JsonField<String>) = apply {
            this.tcrSyncError = tcrSyncError
        }

        fun telnyxCampaignId(telnyxCampaignId: String?) =
            telnyxCampaignId(JsonField.ofNullable(telnyxCampaignId))

        /** Alias for calling [Builder.telnyxCampaignId] with `telnyxCampaignId.orElse(null)`. */
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
         * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun termsAndConditionsLink(termsAndConditionsLink: JsonField<String>) = apply {
            this.termsAndConditionsLink = termsAndConditionsLink
        }

        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        fun upstreamCnpId(upstreamCnpId: String?) =
            upstreamCnpId(JsonField.ofNullable(upstreamCnpId))

        /** Alias for calling [Builder.upstreamCnpId] with `upstreamCnpId.orElse(null)`. */
        fun upstreamCnpId(upstreamCnpId: Optional<String>) =
            upstreamCnpId(upstreamCnpId.getOrNull())

        /**
         * Sets [Builder.upstreamCnpId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.upstreamCnpId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [TcrCampaignWithUseCases].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TcrCampaignWithUseCases =
            TcrCampaignWithUseCases(
                id,
                createdAt,
                updatedAt,
                billedDate,
                brandId,
                cost,
                cspId,
                customerId,
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
                upstreamCnpId,
                (useCases ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TcrCampaignWithUseCases = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        updatedAt()
        billedDate()
        brandId()
        cost()
        cspId()
        customerId()
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
        upstreamCnpId()
        useCases().ifPresent { it.forEach { it.validate() } }
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
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (billedDate.asKnown().isPresent) 1 else 0) +
            (if (brandId.asKnown().isPresent) 1 else 0) +
            (if (cost.asKnown().isPresent) 1 else 0) +
            (if (cspId.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
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
            (if (upstreamCnpId.asKnown().isPresent) 1 else 0) +
            (useCases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class SharingStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentDmInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PENDING -> Known.PENDING
                ACCEPTED -> Known.ACCEPTED
                DECLINED -> Known.DECLINED
                else -> throw SentDmInvalidDataException("Unknown SharingStatus: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentDmInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentDmInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

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
            } catch (e: SentDmInvalidDataException) {
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
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SENT_CREATED,
            ACTIVE,
            EXPIRED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentDmInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                SENT_CREATED -> Known.SENT_CREATED
                ACTIVE -> Known.ACTIVE
                EXPIRED -> Known.EXPIRED
                else -> throw SentDmInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentDmInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentDmInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

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
            } catch (e: SentDmInvalidDataException) {
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
        private val createdAt: JsonField<OffsetDateTime>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val campaignId: JsonField<String>,
        private val customerId: JsonField<String>,
        private val messagingUseCaseUs: JsonField<MessagingUseCaseUs>,
        private val sampleMessages: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("campaignId")
            @ExcludeMissing
            campaignId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("customerId")
            @ExcludeMissing
            customerId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("messagingUseCaseUs")
            @ExcludeMissing
            messagingUseCaseUs: JsonField<MessagingUseCaseUs> = JsonMissing.of(),
            @JsonProperty("sampleMessages")
            @ExcludeMissing
            sampleMessages: JsonField<List<String>> = JsonMissing.of(),
        ) : this(
            id,
            createdAt,
            updatedAt,
            campaignId,
            customerId,
            messagingUseCaseUs,
            sampleMessages,
            mutableMapOf(),
        )

        fun toBaseDto(): BaseDto =
            BaseDto.builder().id(id).createdAt(createdAt).updatedAt(updatedAt).build()

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
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun campaignId(): Optional<String> = campaignId.getOptional("campaignId")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun customerId(): Optional<String> = customerId.getOptional("customerId")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messagingUseCaseUs(): Optional<MessagingUseCaseUs> =
            messagingUseCaseUs.getOptional("messagingUseCaseUs")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sampleMessages(): Optional<List<String>> = sampleMessages.getOptional("sampleMessages")

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
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

        /**
         * Returns the raw JSON value of [campaignId].
         *
         * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaignId")
        @ExcludeMissing
        fun _campaignId(): JsonField<String> = campaignId

        /**
         * Returns the raw JSON value of [customerId].
         *
         * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
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
         * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected
         * type.
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

            /** Returns a mutable builder for constructing an instance of [UseCase]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UseCase]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var campaignId: JsonField<String> = JsonMissing.of()
            private var customerId: JsonField<String> = JsonMissing.of()
            private var messagingUseCaseUs: JsonField<MessagingUseCaseUs> = JsonMissing.of()
            private var sampleMessages: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(useCase: UseCase) = apply {
                id = useCase.id
                createdAt = useCase.createdAt
                updatedAt = useCase.updatedAt
                campaignId = useCase.campaignId
                customerId = useCase.customerId
                messagingUseCaseUs = useCase.messagingUseCaseUs
                sampleMessages = useCase.sampleMessages.map { it.toMutableList() }
                additionalProperties = useCase.additionalProperties.toMutableMap()
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

            fun campaignId(campaignId: String) = campaignId(JsonField.of(campaignId))

            /**
             * Sets [Builder.campaignId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaignId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaignId(campaignId: JsonField<String>) = apply { this.campaignId = campaignId }

            fun customerId(customerId: String) = customerId(JsonField.of(customerId))

            /**
             * Sets [Builder.customerId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customerId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

            fun messagingUseCaseUs(messagingUseCaseUs: MessagingUseCaseUs) =
                messagingUseCaseUs(JsonField.of(messagingUseCaseUs))

            /**
             * Sets [Builder.messagingUseCaseUs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messagingUseCaseUs] with a well-typed
             * [MessagingUseCaseUs] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
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
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * Returns an immutable instance of [UseCase].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UseCase =
                UseCase(
                    id,
                    createdAt,
                    updatedAt,
                    campaignId,
                    customerId,
                    messagingUseCaseUs,
                    (sampleMessages ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UseCase = apply {
            if (validated) {
                return@apply
            }

            id()
            createdAt()
            updatedAt()
            campaignId()
            customerId()
            messagingUseCaseUs().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0) +
                (if (campaignId.asKnown().isPresent) 1 else 0) +
                (if (customerId.asKnown().isPresent) 1 else 0) +
                (messagingUseCaseUs.asKnown().getOrNull()?.validity() ?: 0) +
                (sampleMessages.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UseCase &&
                id == other.id &&
                createdAt == other.createdAt &&
                updatedAt == other.updatedAt &&
                campaignId == other.campaignId &&
                customerId == other.customerId &&
                messagingUseCaseUs == other.messagingUseCaseUs &&
                sampleMessages == other.sampleMessages &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                createdAt,
                updatedAt,
                campaignId,
                customerId,
                messagingUseCaseUs,
                sampleMessages,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UseCase{id=$id, createdAt=$createdAt, updatedAt=$updatedAt, campaignId=$campaignId, customerId=$customerId, messagingUseCaseUs=$messagingUseCaseUs, sampleMessages=$sampleMessages, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TcrCampaignWithUseCases &&
            id == other.id &&
            createdAt == other.createdAt &&
            updatedAt == other.updatedAt &&
            billedDate == other.billedDate &&
            brandId == other.brandId &&
            cost == other.cost &&
            cspId == other.cspId &&
            customerId == other.customerId &&
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
            upstreamCnpId == other.upstreamCnpId &&
            useCases == other.useCases &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            updatedAt,
            billedDate,
            brandId,
            cost,
            cspId,
            customerId,
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
            upstreamCnpId,
            useCases,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TcrCampaignWithUseCases{id=$id, createdAt=$createdAt, updatedAt=$updatedAt, billedDate=$billedDate, brandId=$brandId, cost=$cost, cspId=$cspId, customerId=$customerId, description=$description, helpKeywords=$helpKeywords, helpMessage=$helpMessage, kycSubmissionFormId=$kycSubmissionFormId, messageFlow=$messageFlow, name=$name, optinKeywords=$optinKeywords, optinMessage=$optinMessage, optoutKeywords=$optoutKeywords, optoutMessage=$optoutMessage, privacyPolicyLink=$privacyPolicyLink, resellerId=$resellerId, sharingStatus=$sharingStatus, status=$status, submittedAt=$submittedAt, submittedToTcr=$submittedToTcr, tcrCampaignId=$tcrCampaignId, tcrSyncError=$tcrSyncError, telnyxCampaignId=$telnyxCampaignId, termsAndConditionsLink=$termsAndConditionsLink, type=$type, upstreamCnpId=$upstreamCnpId, useCases=$useCases, additionalProperties=$additionalProperties}"
}
