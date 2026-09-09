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

/** A 10DLC campaign registered for a brand. */
class BrandCampaign
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val billedDate: JsonField<OffsetDateTime>,
    private val brandId: JsonField<String>,
    private val cost: JsonField<Double>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customerId: JsonField<String>,
    private val dcaElectionsComplete: JsonField<Boolean>,
    private val dcaElectionsCompletedAt: JsonField<OffsetDateTime>,
    private val description: JsonField<String>,
    private val hasSubmissionTransaction: JsonField<Boolean>,
    private val helpKeywords: JsonField<String>,
    private val helpMessage: JsonField<String>,
    private val messageFlow: JsonField<String>,
    private val name: JsonField<String>,
    private val optinKeywords: JsonField<String>,
    private val optinMessage: JsonField<String>,
    private val optoutKeywords: JsonField<String>,
    private val optoutMessage: JsonField<String>,
    private val privacyPolicyLink: JsonField<String>,
    private val status: JsonField<Status>,
    private val submittedAt: JsonField<OffsetDateTime>,
    private val submittedToTcr: JsonField<Boolean>,
    private val tcrCampaignId: JsonField<String>,
    private val tcrSyncError: JsonField<String>,
    private val termsAndConditionsLink: JsonField<String>,
    private val type: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val useCases: JsonField<List<CampaignUseCase>>,
    private val volume: JsonField<String>,
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
        @JsonProperty("hasSubmissionTransaction")
        @ExcludeMissing
        hasSubmissionTransaction: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("helpKeywords")
        @ExcludeMissing
        helpKeywords: JsonField<String> = JsonMissing.of(),
        @JsonProperty("helpMessage")
        @ExcludeMissing
        helpMessage: JsonField<String> = JsonMissing.of(),
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
        @JsonProperty("termsAndConditionsLink")
        @ExcludeMissing
        termsAndConditionsLink: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("useCases")
        @ExcludeMissing
        useCases: JsonField<List<CampaignUseCase>> = JsonMissing.of(),
        @JsonProperty("volume") @ExcludeMissing volume: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        billedDate,
        brandId,
        cost,
        createdAt,
        customerId,
        dcaElectionsComplete,
        dcaElectionsCompletedAt,
        description,
        hasSubmissionTransaction,
        helpKeywords,
        helpMessage,
        messageFlow,
        name,
        optinKeywords,
        optinMessage,
        optoutKeywords,
        optoutMessage,
        privacyPolicyLink,
        status,
        submittedAt,
        submittedToTcr,
        tcrCampaignId,
        tcrSyncError,
        termsAndConditionsLink,
        type,
        updatedAt,
        useCases,
        volume,
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
    fun billedDate(): Optional<OffsetDateTime> = billedDate.getOptional("billedDate")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandId(): Optional<String> = brandId.getOptional("brandId")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun cost(): Optional<Double> = cost.getOptional("cost")

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
     * True once every carrier has completed its DCA election and the campaign is operationally
     * ready for traffic.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun dcaElectionsComplete(): Optional<Boolean> =
        dcaElectionsComplete.getOptional("dcaElectionsComplete")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun dcaElectionsCompletedAt(): Optional<OffsetDateTime> =
        dcaElectionsCompletedAt.getOptional("dcaElectionsCompletedAt")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * True when the one-time campaign submission fee has already been charged.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun hasSubmissionTransaction(): Optional<Boolean> =
        hasSubmissionTransaction.getOptional("hasSubmissionTransaction")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun helpKeywords(): Optional<String> = helpKeywords.getOptional("helpKeywords")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun helpMessage(): Optional<String> = helpMessage.getOptional("helpMessage")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageFlow(): Optional<String> = messageFlow.getOptional("messageFlow")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optinKeywords(): Optional<String> = optinKeywords.getOptional("optinKeywords")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optinMessage(): Optional<String> = optinMessage.getOptional("optinMessage")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optoutKeywords(): Optional<String> = optoutKeywords.getOptional("optoutKeywords")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optoutMessage(): Optional<String> = optoutMessage.getOptional("optoutMessage")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun privacyPolicyLink(): Optional<String> = privacyPolicyLink.getOptional("privacyPolicyLink")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun submittedAt(): Optional<OffsetDateTime> = submittedAt.getOptional("submittedAt")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun submittedToTcr(): Optional<Boolean> = submittedToTcr.getOptional("submittedToTCR")

    /**
     * The Campaign Registry identifier, once the campaign has been accepted.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun tcrCampaignId(): Optional<String> = tcrCampaignId.getOptional("tcrCampaignId")

    /**
     * Surfaced so customers can see why a submission did not reach the registry.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun tcrSyncError(): Optional<String> = tcrSyncError.getOptional("tcrSyncError")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun termsAndConditionsLink(): Optional<String> =
        termsAndConditionsLink.getOptional("termsAndConditionsLink")

    /**
     * Campaign type (for example KYC or App).
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun useCases(): Optional<List<CampaignUseCase>> = useCases.getOptional("useCases")

    /**
     * Expected messaging volume for this campaign — customer-supplied on create/update, and the
     * input to both the TCR usecase classification (LOW_VOLUME vs MIXED/specific) and the campaign
     * fee tier. Surfaced so customers can read back the value they set.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun volume(): Optional<String> = volume.getOptional("volume")

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
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customerId") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [dcaElectionsComplete].
     *
     * Unlike [dcaElectionsComplete], this method doesn't throw if the JSON field has an unexpected
     * type.
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
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [hasSubmissionTransaction].
     *
     * Unlike [hasSubmissionTransaction], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("hasSubmissionTransaction")
    @ExcludeMissing
    fun _hasSubmissionTransaction(): JsonField<Boolean> = hasSubmissionTransaction

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
     * Returns the raw JSON value of [useCases].
     *
     * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("useCases")
    @ExcludeMissing
    fun _useCases(): JsonField<List<CampaignUseCase>> = useCases

    /**
     * Returns the raw JSON value of [volume].
     *
     * Unlike [volume], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("volume") @ExcludeMissing fun _volume(): JsonField<String> = volume

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

        /** Returns a mutable builder for constructing an instance of [BrandCampaign]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandCampaign]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var billedDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var brandId: JsonField<String> = JsonMissing.of()
        private var cost: JsonField<Double> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
        private var dcaElectionsComplete: JsonField<Boolean> = JsonMissing.of()
        private var dcaElectionsCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var hasSubmissionTransaction: JsonField<Boolean> = JsonMissing.of()
        private var helpKeywords: JsonField<String> = JsonMissing.of()
        private var helpMessage: JsonField<String> = JsonMissing.of()
        private var messageFlow: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var optinKeywords: JsonField<String> = JsonMissing.of()
        private var optinMessage: JsonField<String> = JsonMissing.of()
        private var optoutKeywords: JsonField<String> = JsonMissing.of()
        private var optoutMessage: JsonField<String> = JsonMissing.of()
        private var privacyPolicyLink: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var submittedToTcr: JsonField<Boolean> = JsonMissing.of()
        private var tcrCampaignId: JsonField<String> = JsonMissing.of()
        private var tcrSyncError: JsonField<String> = JsonMissing.of()
        private var termsAndConditionsLink: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var useCases: JsonField<MutableList<CampaignUseCase>>? = null
        private var volume: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandCampaign: BrandCampaign) = apply {
            id = brandCampaign.id
            billedDate = brandCampaign.billedDate
            brandId = brandCampaign.brandId
            cost = brandCampaign.cost
            createdAt = brandCampaign.createdAt
            customerId = brandCampaign.customerId
            dcaElectionsComplete = brandCampaign.dcaElectionsComplete
            dcaElectionsCompletedAt = brandCampaign.dcaElectionsCompletedAt
            description = brandCampaign.description
            hasSubmissionTransaction = brandCampaign.hasSubmissionTransaction
            helpKeywords = brandCampaign.helpKeywords
            helpMessage = brandCampaign.helpMessage
            messageFlow = brandCampaign.messageFlow
            name = brandCampaign.name
            optinKeywords = brandCampaign.optinKeywords
            optinMessage = brandCampaign.optinMessage
            optoutKeywords = brandCampaign.optoutKeywords
            optoutMessage = brandCampaign.optoutMessage
            privacyPolicyLink = brandCampaign.privacyPolicyLink
            status = brandCampaign.status
            submittedAt = brandCampaign.submittedAt
            submittedToTcr = brandCampaign.submittedToTcr
            tcrCampaignId = brandCampaign.tcrCampaignId
            tcrSyncError = brandCampaign.tcrSyncError
            termsAndConditionsLink = brandCampaign.termsAndConditionsLink
            type = brandCampaign.type
            updatedAt = brandCampaign.updatedAt
            useCases = brandCampaign.useCases.map { it.toMutableList() }
            volume = brandCampaign.volume
            additionalProperties = brandCampaign.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

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

        /**
         * True once every carrier has completed its DCA election and the campaign is operationally
         * ready for traffic.
         */
        fun dcaElectionsComplete(dcaElectionsComplete: Boolean?) =
            dcaElectionsComplete(JsonField.ofNullable(dcaElectionsComplete))

        /**
         * Alias for [Builder.dcaElectionsComplete].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun dcaElectionsComplete(dcaElectionsComplete: Boolean) =
            dcaElectionsComplete(dcaElectionsComplete as Boolean?)

        /**
         * Alias for calling [Builder.dcaElectionsComplete] with
         * `dcaElectionsComplete.orElse(null)`.
         */
        fun dcaElectionsComplete(dcaElectionsComplete: Optional<Boolean>) =
            dcaElectionsComplete(dcaElectionsComplete.getOrNull())

        /**
         * Sets [Builder.dcaElectionsComplete] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dcaElectionsComplete] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
        fun dcaElectionsCompletedAt(dcaElectionsCompletedAt: JsonField<OffsetDateTime>) = apply {
            this.dcaElectionsCompletedAt = dcaElectionsCompletedAt
        }

        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** True when the one-time campaign submission fee has already been charged. */
        fun hasSubmissionTransaction(hasSubmissionTransaction: Boolean) =
            hasSubmissionTransaction(JsonField.of(hasSubmissionTransaction))

        /**
         * Sets [Builder.hasSubmissionTransaction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasSubmissionTransaction] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun hasSubmissionTransaction(hasSubmissionTransaction: JsonField<Boolean>) = apply {
            this.hasSubmissionTransaction = hasSubmissionTransaction
        }

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

        /** The Campaign Registry identifier, once the campaign has been accepted. */
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

        /** Surfaced so customers can see why a submission did not reach the registry. */
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

        /** Campaign type (for example KYC or App). */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        fun useCases(useCases: List<CampaignUseCase>) = useCases(JsonField.of(useCases))

        /**
         * Sets [Builder.useCases] to an arbitrary JSON value.
         *
         * You should usually call [Builder.useCases] with a well-typed `List<CampaignUseCase>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun useCases(useCases: JsonField<List<CampaignUseCase>>) = apply {
            this.useCases = useCases.map { it.toMutableList() }
        }

        /**
         * Adds a single [CampaignUseCase] to [useCases].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUseCase(useCase: CampaignUseCase) = apply {
            useCases =
                (useCases ?: JsonField.of(mutableListOf())).also {
                    checkKnown("useCases", it).add(useCase)
                }
        }

        /**
         * Expected messaging volume for this campaign — customer-supplied on create/update, and the
         * input to both the TCR usecase classification (LOW_VOLUME vs MIXED/specific) and the
         * campaign fee tier. Surfaced so customers can read back the value they set.
         */
        fun volume(volume: String?) = volume(JsonField.ofNullable(volume))

        /** Alias for calling [Builder.volume] with `volume.orElse(null)`. */
        fun volume(volume: Optional<String>) = volume(volume.getOrNull())

        /**
         * Sets [Builder.volume] to an arbitrary JSON value.
         *
         * You should usually call [Builder.volume] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun volume(volume: JsonField<String>) = apply { this.volume = volume }

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
         * Returns an immutable instance of [BrandCampaign].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BrandCampaign =
            BrandCampaign(
                id,
                billedDate,
                brandId,
                cost,
                createdAt,
                customerId,
                dcaElectionsComplete,
                dcaElectionsCompletedAt,
                description,
                hasSubmissionTransaction,
                helpKeywords,
                helpMessage,
                messageFlow,
                name,
                optinKeywords,
                optinMessage,
                optoutKeywords,
                optoutMessage,
                privacyPolicyLink,
                status,
                submittedAt,
                submittedToTcr,
                tcrCampaignId,
                tcrSyncError,
                termsAndConditionsLink,
                type,
                updatedAt,
                (useCases ?: JsonMissing.of()).map { it.toImmutable() },
                volume,
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
    fun validate(): BrandCampaign = apply {
        if (validated) {
            return@apply
        }

        id()
        billedDate()
        brandId()
        cost()
        createdAt()
        customerId()
        dcaElectionsComplete()
        dcaElectionsCompletedAt()
        description()
        hasSubmissionTransaction()
        helpKeywords()
        helpMessage()
        messageFlow()
        name()
        optinKeywords()
        optinMessage()
        optoutKeywords()
        optoutMessage()
        privacyPolicyLink()
        status().ifPresent { it.validate() }
        submittedAt()
        submittedToTcr()
        tcrCampaignId()
        tcrSyncError()
        termsAndConditionsLink()
        type()
        updatedAt()
        useCases().ifPresent { it.forEach { it.validate() } }
        volume()
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
            (if (billedDate.asKnown().isPresent) 1 else 0) +
            (if (brandId.asKnown().isPresent) 1 else 0) +
            (if (cost.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (if (dcaElectionsComplete.asKnown().isPresent) 1 else 0) +
            (if (dcaElectionsCompletedAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (hasSubmissionTransaction.asKnown().isPresent) 1 else 0) +
            (if (helpKeywords.asKnown().isPresent) 1 else 0) +
            (if (helpMessage.asKnown().isPresent) 1 else 0) +
            (if (messageFlow.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (optinKeywords.asKnown().isPresent) 1 else 0) +
            (if (optinMessage.asKnown().isPresent) 1 else 0) +
            (if (optoutKeywords.asKnown().isPresent) 1 else 0) +
            (if (optoutMessage.asKnown().isPresent) 1 else 0) +
            (if (privacyPolicyLink.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (submittedAt.asKnown().isPresent) 1 else 0) +
            (if (submittedToTcr.asKnown().isPresent) 1 else 0) +
            (if (tcrCampaignId.asKnown().isPresent) 1 else 0) +
            (if (tcrSyncError.asKnown().isPresent) 1 else 0) +
            (if (termsAndConditionsLink.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (useCases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (volume.asKnown().isPresent) 1 else 0)

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
         * @throws SentInvalidDataException if this class instance's value is a not a known member.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentInvalidDataException("Value is not a String") }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandCampaign &&
            id == other.id &&
            billedDate == other.billedDate &&
            brandId == other.brandId &&
            cost == other.cost &&
            createdAt == other.createdAt &&
            customerId == other.customerId &&
            dcaElectionsComplete == other.dcaElectionsComplete &&
            dcaElectionsCompletedAt == other.dcaElectionsCompletedAt &&
            description == other.description &&
            hasSubmissionTransaction == other.hasSubmissionTransaction &&
            helpKeywords == other.helpKeywords &&
            helpMessage == other.helpMessage &&
            messageFlow == other.messageFlow &&
            name == other.name &&
            optinKeywords == other.optinKeywords &&
            optinMessage == other.optinMessage &&
            optoutKeywords == other.optoutKeywords &&
            optoutMessage == other.optoutMessage &&
            privacyPolicyLink == other.privacyPolicyLink &&
            status == other.status &&
            submittedAt == other.submittedAt &&
            submittedToTcr == other.submittedToTcr &&
            tcrCampaignId == other.tcrCampaignId &&
            tcrSyncError == other.tcrSyncError &&
            termsAndConditionsLink == other.termsAndConditionsLink &&
            type == other.type &&
            updatedAt == other.updatedAt &&
            useCases == other.useCases &&
            volume == other.volume &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            billedDate,
            brandId,
            cost,
            createdAt,
            customerId,
            dcaElectionsComplete,
            dcaElectionsCompletedAt,
            description,
            hasSubmissionTransaction,
            helpKeywords,
            helpMessage,
            messageFlow,
            name,
            optinKeywords,
            optinMessage,
            optoutKeywords,
            optoutMessage,
            privacyPolicyLink,
            status,
            submittedAt,
            submittedToTcr,
            tcrCampaignId,
            tcrSyncError,
            termsAndConditionsLink,
            type,
            updatedAt,
            useCases,
            volume,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandCampaign{id=$id, billedDate=$billedDate, brandId=$brandId, cost=$cost, createdAt=$createdAt, customerId=$customerId, dcaElectionsComplete=$dcaElectionsComplete, dcaElectionsCompletedAt=$dcaElectionsCompletedAt, description=$description, hasSubmissionTransaction=$hasSubmissionTransaction, helpKeywords=$helpKeywords, helpMessage=$helpMessage, messageFlow=$messageFlow, name=$name, optinKeywords=$optinKeywords, optinMessage=$optinMessage, optoutKeywords=$optoutKeywords, optoutMessage=$optoutMessage, privacyPolicyLink=$privacyPolicyLink, status=$status, submittedAt=$submittedAt, submittedToTcr=$submittedToTcr, tcrCampaignId=$tcrCampaignId, tcrSyncError=$tcrSyncError, termsAndConditionsLink=$termsAndConditionsLink, type=$type, updatedAt=$updatedAt, useCases=$useCases, volume=$volume, additionalProperties=$additionalProperties}"
}
