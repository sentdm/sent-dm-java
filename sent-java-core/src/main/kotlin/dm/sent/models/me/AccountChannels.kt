// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Messaging channel configuration. All three channels are always present. Each channel has a
 * "configured" flag; configured channels expose additional details.
 */
class AccountChannels
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val rcs: JsonField<AccountRcsChannel>,
    private val sms: JsonField<AccountSmsChannel>,
    private val whatsapp: JsonField<AccountWhatsappChannel>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("rcs") @ExcludeMissing rcs: JsonField<AccountRcsChannel> = JsonMissing.of(),
        @JsonProperty("sms") @ExcludeMissing sms: JsonField<AccountSmsChannel> = JsonMissing.of(),
        @JsonProperty("whatsapp")
        @ExcludeMissing
        whatsapp: JsonField<AccountWhatsappChannel> = JsonMissing.of(),
    ) : this(rcs, sms, whatsapp, mutableMapOf())

    /**
     * RCS channel configuration. When configured, includes the RCS phone number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun rcs(): Optional<AccountRcsChannel> = rcs.getOptional("rcs")

    /**
     * SMS channel configuration. When configured, includes the sending phone number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sms(): Optional<AccountSmsChannel> = sms.getOptional("sms")

    /**
     * WhatsApp Business channel configuration. When configured, includes the WhatsApp phone number
     * and business name.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun whatsapp(): Optional<AccountWhatsappChannel> = whatsapp.getOptional("whatsapp")

    /**
     * Returns the raw JSON value of [rcs].
     *
     * Unlike [rcs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rcs") @ExcludeMissing fun _rcs(): JsonField<AccountRcsChannel> = rcs

    /**
     * Returns the raw JSON value of [sms].
     *
     * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<AccountSmsChannel> = sms

    /**
     * Returns the raw JSON value of [whatsapp].
     *
     * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("whatsapp")
    @ExcludeMissing
    fun _whatsapp(): JsonField<AccountWhatsappChannel> = whatsapp

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

        /** Returns a mutable builder for constructing an instance of [AccountChannels]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountChannels]. */
    class Builder internal constructor() {

        private var rcs: JsonField<AccountRcsChannel> = JsonMissing.of()
        private var sms: JsonField<AccountSmsChannel> = JsonMissing.of()
        private var whatsapp: JsonField<AccountWhatsappChannel> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountChannels: AccountChannels) = apply {
            rcs = accountChannels.rcs
            sms = accountChannels.sms
            whatsapp = accountChannels.whatsapp
            additionalProperties = accountChannels.additionalProperties.toMutableMap()
        }

        /** RCS channel configuration. When configured, includes the RCS phone number. */
        fun rcs(rcs: AccountRcsChannel) = rcs(JsonField.of(rcs))

        /**
         * Sets [Builder.rcs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rcs] with a well-typed [AccountRcsChannel] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rcs(rcs: JsonField<AccountRcsChannel>) = apply { this.rcs = rcs }

        /** SMS channel configuration. When configured, includes the sending phone number. */
        fun sms(sms: AccountSmsChannel) = sms(JsonField.of(sms))

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed [AccountSmsChannel] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sms(sms: JsonField<AccountSmsChannel>) = apply { this.sms = sms }

        /**
         * WhatsApp Business channel configuration. When configured, includes the WhatsApp phone
         * number and business name.
         */
        fun whatsapp(whatsapp: AccountWhatsappChannel) = whatsapp(JsonField.of(whatsapp))

        /**
         * Sets [Builder.whatsapp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsapp] with a well-typed [AccountWhatsappChannel]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun whatsapp(whatsapp: JsonField<AccountWhatsappChannel>) = apply {
            this.whatsapp = whatsapp
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
         * Returns an immutable instance of [AccountChannels].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AccountChannels =
            AccountChannels(rcs, sms, whatsapp, additionalProperties.toMutableMap())
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
    fun validate(): AccountChannels = apply {
        if (validated) {
            return@apply
        }

        rcs().ifPresent { it.validate() }
        sms().ifPresent { it.validate() }
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
        (rcs.asKnown().getOrNull()?.validity() ?: 0) +
            (sms.asKnown().getOrNull()?.validity() ?: 0) +
            (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountChannels &&
            rcs == other.rcs &&
            sms == other.sms &&
            whatsapp == other.whatsapp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(rcs, sms, whatsapp, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountChannels{rcs=$rcs, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
}
