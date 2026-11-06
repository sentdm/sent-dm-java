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
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The profile's own WhatsApp Business Account, named by the two identifiers the organization cannot
 * answer for you.
 *
 * No mode: a profile's WABA is its own or it has none. Sharing the organization's would mean
 * sharing its inbox and its throughput, which makes the two indistinguishable to a recipient — so
 * inheriting is not offered rather than refused.
 *
 * Everything derivable is derived. Whenever this block is present, the solution the account arrived
 * through, the client business portfolio that owns it, the access token and that token's expiry are
 * all resolved from the organization by IPartnerSolutionService.ResolveAccountCredentialsAsync —
 * the first two off the org's shared-account listing, the token minted against the org's own
 * solution. They were previously asked for and are no longer accepted: solution_id and
 * owner_business_id are Meta's answer about provenance, so taking them from the caller let a
 * request assert a partnership Meta disagreed with, and the listing has to be consulted regardless
 * because it is what proves the account is one this organization may reach.
 *
 * No access token, and there never was one here: it is minted per client business portfolio and
 * rotates roughly every sixty days, so a pasted value would be stale before it was useful. Asking a
 * customer to mint a System User token in Meta Business Manager is skilled work in a console they
 * were never meant to see, and it would say nothing about which solution the account came from or
 * when it is revoked.
 */
class SenderProfileWhatsapp
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val phoneNumberId: JsonField<String>,
    private val wabaId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("phone_number_id")
        @ExcludeMissing
        phoneNumberId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("waba_id") @ExcludeMissing wabaId: JsonField<String> = JsonMissing.of(),
    ) : this(phoneNumberId, wabaId, mutableMapOf())

    /**
     * The Meta phone-number id this profile sends from. Must already be registered under WabaId.
     *
     * Optional. Omit it to attach the account now and settle the number later: the channel reads as
     * ACTION_NEEDED with CHANNEL_007, and the profile's WhatsApp messages fail until a number is
     * named. They do not fall back to the organization's account. Nothing picks one on your behalf.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneNumberId(): Optional<String> = phoneNumberId.getOptional("phone_number_id")

    /**
     * WhatsApp Business Account id — one of the accounts shared into your organization. Required:
     * the organization holds one per client, and nothing but the caller says which belongs to this
     * profile.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun wabaId(): Optional<String> = wabaId.getOptional("waba_id")

    /**
     * Returns the raw JSON value of [phoneNumberId].
     *
     * Unlike [phoneNumberId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone_number_id")
    @ExcludeMissing
    fun _phoneNumberId(): JsonField<String> = phoneNumberId

    /**
     * Returns the raw JSON value of [wabaId].
     *
     * Unlike [wabaId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waba_id") @ExcludeMissing fun _wabaId(): JsonField<String> = wabaId

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

        /** Returns a mutable builder for constructing an instance of [SenderProfileWhatsapp]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileWhatsapp]. */
    class Builder internal constructor() {

        private var phoneNumberId: JsonField<String> = JsonMissing.of()
        private var wabaId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfileWhatsapp: SenderProfileWhatsapp) = apply {
            phoneNumberId = senderProfileWhatsapp.phoneNumberId
            wabaId = senderProfileWhatsapp.wabaId
            additionalProperties = senderProfileWhatsapp.additionalProperties.toMutableMap()
        }

        /**
         * The Meta phone-number id this profile sends from. Must already be registered under
         * WabaId.
         *
         * Optional. Omit it to attach the account now and settle the number later: the channel
         * reads as ACTION_NEEDED with CHANNEL_007, and the profile's WhatsApp messages fail until a
         * number is named. They do not fall back to the organization's account. Nothing picks one
         * on your behalf.
         */
        fun phoneNumberId(phoneNumberId: String?) =
            phoneNumberId(JsonField.ofNullable(phoneNumberId))

        /** Alias for calling [Builder.phoneNumberId] with `phoneNumberId.orElse(null)`. */
        fun phoneNumberId(phoneNumberId: Optional<String>) =
            phoneNumberId(phoneNumberId.getOrNull())

        /**
         * Sets [Builder.phoneNumberId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumberId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumberId(phoneNumberId: JsonField<String>) = apply {
            this.phoneNumberId = phoneNumberId
        }

        /**
         * WhatsApp Business Account id — one of the accounts shared into your organization.
         * Required: the organization holds one per client, and nothing but the caller says which
         * belongs to this profile.
         */
        fun wabaId(wabaId: String?) = wabaId(JsonField.ofNullable(wabaId))

        /** Alias for calling [Builder.wabaId] with `wabaId.orElse(null)`. */
        fun wabaId(wabaId: Optional<String>) = wabaId(wabaId.getOrNull())

        /**
         * Sets [Builder.wabaId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.wabaId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun wabaId(wabaId: JsonField<String>) = apply { this.wabaId = wabaId }

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
         * Returns an immutable instance of [SenderProfileWhatsapp].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfileWhatsapp =
            SenderProfileWhatsapp(phoneNumberId, wabaId, additionalProperties.toMutableMap())
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
    fun validate(): SenderProfileWhatsapp = apply {
        if (validated) {
            return@apply
        }

        phoneNumberId()
        wabaId()
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
        (if (phoneNumberId.asKnown().isPresent) 1 else 0) +
            (if (wabaId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfileWhatsapp &&
            phoneNumberId == other.phoneNumberId &&
            wabaId == other.wabaId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(phoneNumberId, wabaId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfileWhatsapp{phoneNumberId=$phoneNumberId, wabaId=$wabaId, additionalProperties=$additionalProperties}"
}
