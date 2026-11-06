// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels

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
import dm.sent.models.channels.rcs.RcsAgent
import dm.sent.models.channels.sms.SmsMarket
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
    private val sms: JsonField<List<SmsMarket>>,
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
        @JsonProperty("sms") @ExcludeMissing sms: JsonField<List<SmsMarket>> = JsonMissing.of(),
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
    fun sms(): Optional<List<SmsMarket>> = sms.getOptional("sms")

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
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<List<SmsMarket>> = sms

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
        private var sms: JsonField<MutableList<SmsMarket>>? = null
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

        fun sms(sms: List<SmsMarket>) = sms(JsonField.of(sms))

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed `List<SmsMarket>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sms(sms: JsonField<List<SmsMarket>>) = apply {
            this.sms = sms.map { it.toMutableList() }
        }

        /**
         * Adds a single [SmsMarket] to [Builder.sms].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSms(sms: SmsMarket) = apply {
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
