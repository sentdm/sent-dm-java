// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels

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
import dm.sent.models.channels.rcs.RcsAgent
import dm.sent.models.channels.sms.SmsNumber
import dm.sent.models.channels.sms.SuppliedCompliance
import dm.sent.models.channels.voice.VoiceNumber
import dm.sent.models.channels.whatsapp.WhatsappChannel
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The channels a profile sends on. SMS is a list because a profile can send in several markets;
 * WhatsApp and RCS are single, because a profile has one business account and one agent.
 */
class ChannelsState
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val customerId: JsonField<String>,
    private val mms: JsonField<List<MmsMarket>>,
    private val rcs: JsonField<RcsAgent>,
    private val sms: JsonField<List<Sms>>,
    private val voice: JsonField<List<VoiceNumber>>,
    private val whatsapp: JsonField<WhatsappChannel>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("customer_id")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mms") @ExcludeMissing mms: JsonField<List<MmsMarket>> = JsonMissing.of(),
        @JsonProperty("rcs") @ExcludeMissing rcs: JsonField<RcsAgent> = JsonMissing.of(),
        @JsonProperty("sms") @ExcludeMissing sms: JsonField<List<Sms>> = JsonMissing.of(),
        @JsonProperty("voice")
        @ExcludeMissing
        voice: JsonField<List<VoiceNumber>> = JsonMissing.of(),
        @JsonProperty("whatsapp")
        @ExcludeMissing
        whatsapp: JsonField<WhatsappChannel> = JsonMissing.of(),
    ) : this(customerId, mms, rcs, sms, voice, whatsapp, mutableMapOf())

    /**
     * Which customer these channels belong to — the key's own, or the profile named in
     * x-profile-id.
     *
     * Same reason the brand carries one: as the response to /v3/channels there is no other id in
     * the document, and under x-profile-id this is the profile the call resolved to rather than the
     * caller. Absent when nested inside a sender profile, whose own id already says whose they are.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customer_id")

    /**
     * The markets this profile can send MMS in, one entry per country, or empty when none.
     *
     * Appears alongside sms rather than replacing an entry in it: the two are separate senders on
     * the same number and a caller needs to see both — a market can be live for SMS while its MMS
     * row is still provisioning, or MMS-incapable entirely because the market's sender-type SKU
     * does not carry it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mms(): Optional<List<MmsMarket>> = mms.getOptional("mms")

    /**
     * An RCS agent as its owner sees it: the order form back, plus where the submission stands.
     *
     * Not RcsSenderResponse. That one is the admin projection and carries the pipeline we track
     * about a customer's request — internalStatus, statusReason, isLaunched — and the S3 keys
     * behind the assets. None of that is the customer's to read: an internal status is a note to
     * ourselves, and an S3 key is a storage detail that would become a contract the moment it was
     * published.
     *
     * What is here is what the caller sent, in the names it sent them under, plus the three things
     * only we can answer: the record's id, its status, and the number it sends from. So a read
     * after a write shows the form as stored rather than as echoed.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun rcs(): Optional<RcsAgent> = rcs.getOptional("rcs")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sms(): Optional<List<Sms>> = sms.getOptional("sms")

    /**
     * The numbers this profile carries phone calls on, one entry per number, or empty when none.
     * Voice is per number like an SMS market is per country: each number is its own channel row,
     * turned on and off on its own, and one of them is the line app-originated calls fall back to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun voice(): Optional<List<VoiceNumber>> = voice.getOptional("voice")

    /**
     * The profile's WhatsApp account. Its status is Meta's verification state.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun whatsapp(): Optional<WhatsappChannel> = whatsapp.getOptional("whatsapp")

    /**
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customer_id") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [mms].
     *
     * Unlike [mms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mms") @ExcludeMissing fun _mms(): JsonField<List<MmsMarket>> = mms

    /**
     * Returns the raw JSON value of [rcs].
     *
     * Unlike [rcs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rcs") @ExcludeMissing fun _rcs(): JsonField<RcsAgent> = rcs

    /**
     * Returns the raw JSON value of [sms].
     *
     * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<List<Sms>> = sms

    /**
     * Returns the raw JSON value of [voice].
     *
     * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<List<VoiceNumber>> = voice

    /**
     * Returns the raw JSON value of [whatsapp].
     *
     * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("whatsapp") @ExcludeMissing fun _whatsapp(): JsonField<WhatsappChannel> = whatsapp

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

        /** Returns a mutable builder for constructing an instance of [ChannelsState]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChannelsState]. */
    class Builder internal constructor() {

        private var customerId: JsonField<String> = JsonMissing.of()
        private var mms: JsonField<MutableList<MmsMarket>>? = null
        private var rcs: JsonField<RcsAgent> = JsonMissing.of()
        private var sms: JsonField<MutableList<Sms>>? = null
        private var voice: JsonField<MutableList<VoiceNumber>>? = null
        private var whatsapp: JsonField<WhatsappChannel> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(channelsState: ChannelsState) = apply {
            customerId = channelsState.customerId
            mms = channelsState.mms.map { it.toMutableList() }
            rcs = channelsState.rcs
            sms = channelsState.sms.map { it.toMutableList() }
            voice = channelsState.voice.map { it.toMutableList() }
            whatsapp = channelsState.whatsapp
            additionalProperties = channelsState.additionalProperties.toMutableMap()
        }

        /**
         * Which customer these channels belong to — the key's own, or the profile named in
         * x-profile-id.
         *
         * Same reason the brand carries one: as the response to /v3/channels there is no other id
         * in the document, and under x-profile-id this is the profile the call resolved to rather
         * than the caller. Absent when nested inside a sender profile, whose own id already says
         * whose they are.
         */
        fun customerId(customerId: String?) = customerId(JsonField.ofNullable(customerId))

        /** Alias for calling [Builder.customerId] with `customerId.orElse(null)`. */
        fun customerId(customerId: Optional<String>) = customerId(customerId.getOrNull())

        /**
         * Sets [Builder.customerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

        /**
         * The markets this profile can send MMS in, one entry per country, or empty when none.
         *
         * Appears alongside sms rather than replacing an entry in it: the two are separate senders
         * on the same number and a caller needs to see both — a market can be live for SMS while
         * its MMS row is still provisioning, or MMS-incapable entirely because the market's
         * sender-type SKU does not carry it.
         */
        fun mms(mms: List<MmsMarket>) = mms(JsonField.of(mms))

        /**
         * Sets [Builder.mms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mms] with a well-typed `List<MmsMarket>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mms(mms: JsonField<List<MmsMarket>>) = apply {
            this.mms = mms.map { it.toMutableList() }
        }

        /**
         * Adds a single [MmsMarket] to [mms].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMm(mm: MmsMarket) = apply {
            mms = (mms ?: JsonField.of(mutableListOf())).also { checkKnown("mms", it).add(mm) }
        }

        /**
         * An RCS agent as its owner sees it: the order form back, plus where the submission stands.
         *
         * Not RcsSenderResponse. That one is the admin projection and carries the pipeline we track
         * about a customer's request — internalStatus, statusReason, isLaunched — and the S3 keys
         * behind the assets. None of that is the customer's to read: an internal status is a note
         * to ourselves, and an S3 key is a storage detail that would become a contract the moment
         * it was published.
         *
         * What is here is what the caller sent, in the names it sent them under, plus the three
         * things only we can answer: the record's id, its status, and the number it sends from. So
         * a read after a write shows the form as stored rather than as echoed.
         */
        fun rcs(rcs: RcsAgent?) = rcs(JsonField.ofNullable(rcs))

        /** Alias for calling [Builder.rcs] with `rcs.orElse(null)`. */
        fun rcs(rcs: Optional<RcsAgent>) = rcs(rcs.getOrNull())

        /**
         * Sets [Builder.rcs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rcs] with a well-typed [RcsAgent] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun rcs(rcs: JsonField<RcsAgent>) = apply { this.rcs = rcs }

        fun sms(sms: List<Sms>) = sms(JsonField.of(sms))

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed `List<Sms>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sms(sms: JsonField<List<Sms>>) = apply { this.sms = sms.map { it.toMutableList() } }

        /**
         * Adds a single [Sms] to [Builder.sms].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSms(sms: Sms) = apply {
            this.sms =
                (this.sms ?: JsonField.of(mutableListOf())).also { checkKnown("sms", it).add(sms) }
        }

        /**
         * The numbers this profile carries phone calls on, one entry per number, or empty when
         * none. Voice is per number like an SMS market is per country: each number is its own
         * channel row, turned on and off on its own, and one of them is the line app-originated
         * calls fall back to.
         */
        fun voice(voice: List<VoiceNumber>) = voice(JsonField.of(voice))

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed `List<VoiceNumber>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun voice(voice: JsonField<List<VoiceNumber>>) = apply {
            this.voice = voice.map { it.toMutableList() }
        }

        /**
         * Adds a single [VoiceNumber] to [Builder.voice].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVoice(voice: VoiceNumber) = apply {
            this.voice =
                (this.voice ?: JsonField.of(mutableListOf())).also {
                    checkKnown("voice", it).add(voice)
                }
        }

        /** The profile's WhatsApp account. Its status is Meta's verification state. */
        fun whatsapp(whatsapp: WhatsappChannel?) = whatsapp(JsonField.ofNullable(whatsapp))

        /** Alias for calling [Builder.whatsapp] with `whatsapp.orElse(null)`. */
        fun whatsapp(whatsapp: Optional<WhatsappChannel>) = whatsapp(whatsapp.getOrNull())

        /**
         * Sets [Builder.whatsapp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsapp] with a well-typed [WhatsappChannel] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun whatsapp(whatsapp: JsonField<WhatsappChannel>) = apply { this.whatsapp = whatsapp }

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
         * Returns an immutable instance of [ChannelsState].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ChannelsState =
            ChannelsState(
                customerId,
                (mms ?: JsonMissing.of()).map { it.toImmutable() },
                rcs,
                (sms ?: JsonMissing.of()).map { it.toImmutable() },
                (voice ?: JsonMissing.of()).map { it.toImmutable() },
                whatsapp,
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
    fun validate(): ChannelsState = apply {
        if (validated) {
            return@apply
        }

        customerId()
        mms().ifPresent { it.forEach { it.validate() } }
        rcs().ifPresent { it.validate() }
        sms().ifPresent { it.forEach { it.validate() } }
        voice().ifPresent { it.forEach { it.validate() } }
        whatsapp().ifPresent { it.validate() }
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
        (if (customerId.asKnown().isPresent) 1 else 0) +
            (mms.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (rcs.asKnown().getOrNull()?.validity() ?: 0) +
            (sms.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (voice.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * One market the profile sends in on a channel — its sender, where that sender stands, and what
     * the market wants. Named for no one channel, as the routes it answers are not
     * (/v3/channels/{channel}/{country}/{type}); SMS is the channel with markets today.
     *
     * A profile may send in several: it is a tenant, not a market. Each carries its own status,
     * because a profile can be live in one country and mid-registration in another — and each
     * carries what it still owes, rather than that being reported in a separate array a caller has
     * to join on.
     */
    class Sms
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val compliance: JsonField<SuppliedCompliance>,
        private val country: JsonField<String>,
        private val numberType: JsonField<String>,
        private val numbers: JsonField<List<SmsNumber>>,
        private val reason: JsonField<String>,
        private val reasonCode: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("compliance")
            @ExcludeMissing
            compliance: JsonField<SuppliedCompliance> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("number_type")
            @ExcludeMissing
            numberType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("numbers")
            @ExcludeMissing
            numbers: JsonField<List<SmsNumber>> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reason_code")
            @ExcludeMissing
            reasonCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(
            compliance,
            country,
            numberType,
            numbers,
            reason,
            reasonCode,
            status,
            mutableMapOf(),
        )

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
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun compliance(): Optional<SuppliedCompliance> = compliance.getOptional("compliance")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun numberType(): Optional<String> = numberType.getOptional("number_type")

        /**
         * Every number this market holds or is still owed, each with its area code and its own
         * status (ACTIVE once it can send, PROVISIONING while it is still to be assigned, INACTIVE
         * once it could send and no longer can). One entry for a market holding one number. US
         * 10DLC numbers are assigned when the campaign is approved, so they read as owed until
         * then. Read-only.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun numbers(): Optional<List<SmsNumber>> = numbers.getOptional("numbers")

        /**
         * A sentence for reason_code: this market's own explanation, naming what is outstanding
         * where that is you. Omitted while ACTIVE.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reason(): Optional<String> = reason.getOptional("reason")

        /**
         * Why the market is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
         * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than
         * on reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
         * generic reason for the status.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reasonCode(): Optional<String> = reasonCode.getOptional("reason_code")

        /**
         * Where this market's sender stands, in terms of who is holding it up — PROVISIONING,
         * ACTION_NEEDED, PENDING_REVIEW or ACTIVE. Read-only.
         *
         * Resolved rather than reported raw: a live sender reads ACTIVE whatever it still owes, a
         * market with outstanding requirements or an open resubmission request reads ACTION_NEEDED,
         * and a market that registers with a regime reads PENDING_REVIEW once its brand exists —
         * filing to The Campaign Registry is ours to do and need not have happened yet, so a
         * dedicated brand created through this API reads PENDING_REVIEW from the moment it is
         * stored.
         *
         * Describes whether the market can send, not each number: a market holding several numbers
         * reads ACTIVE as soon as one of them is, whatever the others are doing. Each number's own
         * status is in numbers.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [compliance].
         *
         * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("compliance")
        @ExcludeMissing
        fun _compliance(): JsonField<SuppliedCompliance> = compliance

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [numberType].
         *
         * Unlike [numberType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("number_type")
        @ExcludeMissing
        fun _numberType(): JsonField<String> = numberType

        /**
         * Returns the raw JSON value of [numbers].
         *
         * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("numbers")
        @ExcludeMissing
        fun _numbers(): JsonField<List<SmsNumber>> = numbers

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

        /**
         * Returns the raw JSON value of [reasonCode].
         *
         * Unlike [reasonCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason_code")
        @ExcludeMissing
        fun _reasonCode(): JsonField<String> = reasonCode

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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

            /** Returns a mutable builder for constructing an instance of [Sms]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Sms]. */
        class Builder internal constructor() {

            private var compliance: JsonField<SuppliedCompliance> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var numberType: JsonField<String> = JsonMissing.of()
            private var numbers: JsonField<MutableList<SmsNumber>>? = null
            private var reason: JsonField<String> = JsonMissing.of()
            private var reasonCode: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(sms: Sms) = apply {
                compliance = sms.compliance
                country = sms.country
                numberType = sms.numberType
                numbers = sms.numbers.map { it.toMutableList() }
                reason = sms.reason
                reasonCode = sms.reasonCode
                status = sms.status
                additionalProperties = sms.additionalProperties.toMutableMap()
            }

            /**
             * What a market has been given: the identity it registers under, its programme, and any
             * documents attached.
             *
             * What it does not carry is what the market asks for. That is the subject of GET
             * /v3/compliance/requirements, and it is the same answer for every caller — a
             * description of what a compliance regime wants, not a record of one customer's
             * progress through it. It was reported here as well for a while, which put the same
             * array in six response shapes and left a caller deciding which of two sources to
             * believe.
             *
             * Present on a list read for markets that register (carrying brand and campaign), but
             * with documents absent — documents are not fetched for a list, because a catalog
             * lookup and a document read per market would multiply across a page. Absent documents
             * is distinct from an empty list: absent says they were not fetched; empty says the
             * market has been given none. The parent object is null only when the market registers
             * with nobody and compliance was not computed — nothing to show at all.
             */
            fun compliance(compliance: SuppliedCompliance?) =
                compliance(JsonField.ofNullable(compliance))

            /** Alias for calling [Builder.compliance] with `compliance.orElse(null)`. */
            fun compliance(compliance: Optional<SuppliedCompliance>) =
                compliance(compliance.getOrNull())

            /**
             * Sets [Builder.compliance] to an arbitrary JSON value.
             *
             * You should usually call [Builder.compliance] with a well-typed [SuppliedCompliance]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun compliance(compliance: JsonField<SuppliedCompliance>) = apply {
                this.compliance = compliance
            }

            fun country(country: String?) = country(JsonField.ofNullable(country))

            /** Alias for calling [Builder.country] with `country.orElse(null)`. */
            fun country(country: Optional<String>) = country(country.getOrNull())

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            fun numberType(numberType: String?) = numberType(JsonField.ofNullable(numberType))

            /** Alias for calling [Builder.numberType] with `numberType.orElse(null)`. */
            fun numberType(numberType: Optional<String>) = numberType(numberType.getOrNull())

            /**
             * Sets [Builder.numberType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numberType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numberType(numberType: JsonField<String>) = apply { this.numberType = numberType }

            /**
             * Every number this market holds or is still owed, each with its area code and its own
             * status (ACTIVE once it can send, PROVISIONING while it is still to be assigned,
             * INACTIVE once it could send and no longer can). One entry for a market holding one
             * number. US 10DLC numbers are assigned when the campaign is approved, so they read as
             * owed until then. Read-only.
             */
            fun numbers(numbers: List<SmsNumber>) = numbers(JsonField.of(numbers))

            /**
             * Sets [Builder.numbers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numbers] with a well-typed `List<SmsNumber>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numbers(numbers: JsonField<List<SmsNumber>>) = apply {
                this.numbers = numbers.map { it.toMutableList() }
            }

            /**
             * Adds a single [SmsNumber] to [numbers].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addNumber(number: SmsNumber) = apply {
                numbers =
                    (numbers ?: JsonField.of(mutableListOf())).also {
                        checkKnown("numbers", it).add(number)
                    }
            }

            /**
             * A sentence for reason_code: this market's own explanation, naming what is outstanding
             * where that is you. Omitted while ACTIVE.
             */
            fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

            /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
            fun reason(reason: Optional<String>) = reason(reason.getOrNull())

            /**
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reason(reason: JsonField<String>) = apply { this.reason = reason }

            /**
             * Why the market is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such
             * as CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this
             * rather than on reason. Omitted while ACTIVE. Read-only; when nothing more specific is
             * known it is the generic reason for the status.
             */
            fun reasonCode(reasonCode: String?) = reasonCode(JsonField.ofNullable(reasonCode))

            /** Alias for calling [Builder.reasonCode] with `reasonCode.orElse(null)`. */
            fun reasonCode(reasonCode: Optional<String>) = reasonCode(reasonCode.getOrNull())

            /**
             * Sets [Builder.reasonCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasonCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reasonCode(reasonCode: JsonField<String>) = apply { this.reasonCode = reasonCode }

            /**
             * Where this market's sender stands, in terms of who is holding it up — PROVISIONING,
             * ACTION_NEEDED, PENDING_REVIEW or ACTIVE. Read-only.
             *
             * Resolved rather than reported raw: a live sender reads ACTIVE whatever it still owes,
             * a market with outstanding requirements or an open resubmission request reads
             * ACTION_NEEDED, and a market that registers with a regime reads PENDING_REVIEW once
             * its brand exists — filing to The Campaign Registry is ours to do and need not have
             * happened yet, so a dedicated brand created through this API reads PENDING_REVIEW from
             * the moment it is stored.
             *
             * Describes whether the market can send, not each number: a market holding several
             * numbers reads ACTIVE as soon as one of them is, whatever the others are doing. Each
             * number's own status is in numbers.
             */
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
             * Returns an immutable instance of [Sms].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Sms =
                Sms(
                    compliance,
                    country,
                    numberType,
                    (numbers ?: JsonMissing.of()).map { it.toImmutable() },
                    reason,
                    reasonCode,
                    status,
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
        fun validate(): Sms = apply {
            if (validated) {
                return@apply
            }

            compliance().ifPresent { it.validate() }
            country()
            numberType()
            numbers().ifPresent { it.forEach { it.validate() } }
            reason()
            reasonCode()
            status().ifPresent { it.validate() }
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
            (compliance.asKnown().getOrNull()?.validity() ?: 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (numberType.asKnown().isPresent) 1 else 0) +
                (numbers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (reason.asKnown().isPresent) 1 else 0) +
                (if (reasonCode.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Where this market's sender stands, in terms of who is holding it up — PROVISIONING,
         * ACTION_NEEDED, PENDING_REVIEW or ACTIVE. Read-only.
         *
         * Resolved rather than reported raw: a live sender reads ACTIVE whatever it still owes, a
         * market with outstanding requirements or an open resubmission request reads ACTION_NEEDED,
         * and a market that registers with a regime reads PENDING_REVIEW once its brand exists —
         * filing to The Campaign Registry is ours to do and need not have happened yet, so a
         * dedicated brand created through this API reads PENDING_REVIEW from the moment it is
         * stored.
         *
         * Describes whether the market can send, not each number: a market holding several numbers
         * reads ACTIVE as soon as one of them is, whatever the others are doing. Each number's own
         * status is in numbers.
         */
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

                /**
                 * We are working on it and there is nothing for you to do — a number is being
                 * procured, or a registration is being assembled. Minutes to hours.
                 */
                @JvmField val PROVISIONING = of("PROVISIONING")

                /**
                 * **Waiting on you.** Something the market asks for has not been supplied, a
                 * regulator rejected what was, or we have asked you to correct and resubmit your
                 * identity data. Nothing progresses until you act. For an SMS market, `GET
                 * /v3/channels/sms/{country}/{type}` names what it wants and `PATCH` on the same
                 * path supplies it — compliance values, documents and numbers alike.
                 */
                @JvmField val ACTION_NEEDED = of("ACTION_NEEDED")

                /**
                 * With a regulator or carrier — filed, or assembled and queued for us to file — and
                 * their answer is what moves it, to `ACTIVE` or back to `ACTION_NEEDED`. Nothing on
                 * your side changes it. Days for SMS, weeks for RCS.
                 */
                @JvmField val PENDING_REVIEW = of("PENDING_REVIEW")

                /**
                 * Can carry traffic now. A channel a sender profile runs on its organization's
                 * reads `ACTIVE` too — it sends, which is what the field is about.
                 */
                @JvmField val ACTIVE = of("ACTIVE")

                /**
                 * **It had a working sender and no longer does** — the number was released, or the
                 * campaign it carried lapsed. Distinct from `PROVISIONING`, which means it has
                 * never sent yet: the same absence of a sender, opposite news. Sends will fail
                 * until it returns to `ACTIVE`.
                 */
                @JvmField val INACTIVE = of("INACTIVE")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                /**
                 * We are working on it and there is nothing for you to do — a number is being
                 * procured, or a registration is being assembled. Minutes to hours.
                 */
                PROVISIONING,
                /**
                 * **Waiting on you.** Something the market asks for has not been supplied, a
                 * regulator rejected what was, or we have asked you to correct and resubmit your
                 * identity data. Nothing progresses until you act. For an SMS market, `GET
                 * /v3/channels/sms/{country}/{type}` names what it wants and `PATCH` on the same
                 * path supplies it — compliance values, documents and numbers alike.
                 */
                ACTION_NEEDED,
                /**
                 * With a regulator or carrier — filed, or assembled and queued for us to file — and
                 * their answer is what moves it, to `ACTIVE` or back to `ACTION_NEEDED`. Nothing on
                 * your side changes it. Days for SMS, weeks for RCS.
                 */
                PENDING_REVIEW,
                /**
                 * Can carry traffic now. A channel a sender profile runs on its organization's
                 * reads `ACTIVE` too — it sends, which is what the field is about.
                 */
                ACTIVE,
                /**
                 * **It had a working sender and no longer does** — the number was released, or the
                 * campaign it carried lapsed. Distinct from `PROVISIONING`, which means it has
                 * never sent yet: the same absence of a sender, opposite news. Sends will fail
                 * until it returns to `ACTIVE`.
                 */
                INACTIVE,
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
                /**
                 * We are working on it and there is nothing for you to do — a number is being
                 * procured, or a registration is being assembled. Minutes to hours.
                 */
                PROVISIONING,
                /**
                 * **Waiting on you.** Something the market asks for has not been supplied, a
                 * regulator rejected what was, or we have asked you to correct and resubmit your
                 * identity data. Nothing progresses until you act. For an SMS market, `GET
                 * /v3/channels/sms/{country}/{type}` names what it wants and `PATCH` on the same
                 * path supplies it — compliance values, documents and numbers alike.
                 */
                ACTION_NEEDED,
                /**
                 * With a regulator or carrier — filed, or assembled and queued for us to file — and
                 * their answer is what moves it, to `ACTIVE` or back to `ACTION_NEEDED`. Nothing on
                 * your side changes it. Days for SMS, weeks for RCS.
                 */
                PENDING_REVIEW,
                /**
                 * Can carry traffic now. A channel a sender profile runs on its organization's
                 * reads `ACTIVE` too — it sends, which is what the field is about.
                 */
                ACTIVE,
                /**
                 * **It had a working sender and no longer does** — the number was released, or the
                 * campaign it carried lapsed. Distinct from `PROVISIONING`, which means it has
                 * never sent yet: the same absence of a sender, opposite news. Sends will fail
                 * until it returns to `ACTIVE`.
                 */
                INACTIVE,
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
                    PROVISIONING -> Value.PROVISIONING
                    ACTION_NEEDED -> Value.ACTION_NEEDED
                    PENDING_REVIEW -> Value.PENDING_REVIEW
                    ACTIVE -> Value.ACTIVE
                    INACTIVE -> Value.INACTIVE
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
                    PROVISIONING -> Known.PROVISIONING
                    ACTION_NEEDED -> Known.ACTION_NEEDED
                    PENDING_REVIEW -> Known.PENDING_REVIEW
                    ACTIVE -> Known.ACTIVE
                    INACTIVE -> Known.INACTIVE
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Sms &&
                compliance == other.compliance &&
                country == other.country &&
                numberType == other.numberType &&
                numbers == other.numbers &&
                reason == other.reason &&
                reasonCode == other.reasonCode &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                compliance,
                country,
                numberType,
                numbers,
                reason,
                reasonCode,
                status,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Sms{compliance=$compliance, country=$country, numberType=$numberType, numbers=$numbers, reason=$reason, reasonCode=$reasonCode, status=$status, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChannelsState &&
            customerId == other.customerId &&
            mms == other.mms &&
            rcs == other.rcs &&
            sms == other.sms &&
            voice == other.voice &&
            whatsapp == other.whatsapp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(customerId, mms, rcs, sms, voice, whatsapp, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChannelsState{customerId=$customerId, mms=$mms, rcs=$rcs, sms=$sms, voice=$voice, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
}
