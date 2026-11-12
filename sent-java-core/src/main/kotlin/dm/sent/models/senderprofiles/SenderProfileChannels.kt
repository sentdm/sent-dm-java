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
 * The channels the profile sends on. Each is independently the profile's own or absent — none can
 * be inherited, so none carries a mode and presence is the whole of the request.
 *
 * A profile can send SMS in several markets, but create takes one — the market it starts in.
 * Further markets are added through POST /v3/channels/sms with x-profile-id, and a read returns
 * them all as a list. Create stays singular permanently rather than being a list that accepts one
 * entry: the constraint is in the type, and there is no later widening to break the contract.
 */
class SenderProfileChannels
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val rcs: JsonField<SenderProfileRcs>,
    private val sms: JsonField<SenderProfileSms>,
    private val whatsapp: JsonField<SenderProfileWhatsapp>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("rcs") @ExcludeMissing rcs: JsonField<SenderProfileRcs> = JsonMissing.of(),
        @JsonProperty("sms") @ExcludeMissing sms: JsonField<SenderProfileSms> = JsonMissing.of(),
        @JsonProperty("whatsapp")
        @ExcludeMissing
        whatsapp: JsonField<SenderProfileWhatsapp> = JsonMissing.of(),
    ) : this(rcs, sms, whatsapp, mutableMapOf())

    /**
     * Asks for an RCS agent of the profile's own, optionally with the full order form inline.
     *
     * Two modes, distinguished by whether any field is populated: "rcs": {} — intent only. Records
     * that the profile wants its own agent; the order form is submitted separately through POST
     * /v3/channels/rcs once the fields are ready. "rcs": { ...fields... } — full form. All required
     * fields must be present; the agent is created alongside the profile in one call. Omitting
     * opt_in_screenshot_url is allowed.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun rcs(): Optional<SenderProfileRcs> = rcs.getOptional("rcs")

    /**
     * One SMS market a profile sends in — a country and a sender type.
     *
     * A profile may have several. It is a tenant, not a market: a business sending to two countries
     * is one customer of yours, and forcing it into two profiles would give it two API keys, two
     * inboxes and two contact lists for one business. The platform already assumes many —
     * CustomerChannelProviders is unique on (customer, channel, iso, number).
     *
     * No mode: a sender is the profile's own or it has none. Listing a market is the request for
     * one.
     *
     * Also the discriminator for everything else: the compliance catalog is keyed on (country,
     * number type), and that pair decides which fields brand accepts and what compliance is asked
     * for.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sms(): Optional<SenderProfileSms> = sms.getOptional("sms")

    /**
     * The profile's own WhatsApp Business Account, named by the two identifiers the organization
     * cannot answer for you.
     *
     * No mode: a profile's WABA is its own or it has none. Sharing the organization's would mean
     * sharing its inbox and its throughput, which makes the two indistinguishable to a recipient —
     * so inheriting is not offered rather than refused.
     *
     * Everything derivable is derived. Whenever this block is present, the solution the account
     * arrived through, the client business portfolio that owns it, the access token and that
     * token's expiry are all resolved from the organization by
     * IPartnerSolutionService.ResolveAccountCredentialsAsync — the first two off the org's
     * shared-account listing, the token minted against the org's own solution. They were previously
     * asked for and are no longer accepted: solution_id and owner_business_id are Meta's answer
     * about provenance, so taking them from the caller let a request assert a partnership Meta
     * disagreed with, and the listing has to be consulted regardless because it is what proves the
     * account is one this organization may reach.
     *
     * No access token, and there never was one here: it is minted per client business portfolio and
     * rotates roughly every sixty days, so a pasted value would be stale before it was useful.
     * Asking a customer to mint a System User token in Meta Business Manager is skilled work in a
     * console they were never meant to see, and it would say nothing about which solution the
     * account came from or when it is revoked.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun whatsapp(): Optional<SenderProfileWhatsapp> = whatsapp.getOptional("whatsapp")

    /**
     * Returns the raw JSON value of [rcs].
     *
     * Unlike [rcs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rcs") @ExcludeMissing fun _rcs(): JsonField<SenderProfileRcs> = rcs

    /**
     * Returns the raw JSON value of [sms].
     *
     * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<SenderProfileSms> = sms

    /**
     * Returns the raw JSON value of [whatsapp].
     *
     * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("whatsapp")
    @ExcludeMissing
    fun _whatsapp(): JsonField<SenderProfileWhatsapp> = whatsapp

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

        /** Returns a mutable builder for constructing an instance of [SenderProfileChannels]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileChannels]. */
    class Builder internal constructor() {

        private var rcs: JsonField<SenderProfileRcs> = JsonMissing.of()
        private var sms: JsonField<SenderProfileSms> = JsonMissing.of()
        private var whatsapp: JsonField<SenderProfileWhatsapp> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfileChannels: SenderProfileChannels) = apply {
            rcs = senderProfileChannels.rcs
            sms = senderProfileChannels.sms
            whatsapp = senderProfileChannels.whatsapp
            additionalProperties = senderProfileChannels.additionalProperties.toMutableMap()
        }

        /**
         * Asks for an RCS agent of the profile's own, optionally with the full order form inline.
         *
         * Two modes, distinguished by whether any field is populated: "rcs": {} — intent only.
         * Records that the profile wants its own agent; the order form is submitted separately
         * through POST /v3/channels/rcs once the fields are ready. "rcs": { ...fields... } — full
         * form. All required fields must be present; the agent is created alongside the profile in
         * one call. Omitting opt_in_screenshot_url is allowed.
         */
        fun rcs(rcs: SenderProfileRcs?) = rcs(JsonField.ofNullable(rcs))

        /** Alias for calling [Builder.rcs] with `rcs.orElse(null)`. */
        fun rcs(rcs: Optional<SenderProfileRcs>) = rcs(rcs.getOrNull())

        /**
         * Sets [Builder.rcs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rcs] with a well-typed [SenderProfileRcs] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rcs(rcs: JsonField<SenderProfileRcs>) = apply { this.rcs = rcs }

        /**
         * One SMS market a profile sends in — a country and a sender type.
         *
         * A profile may have several. It is a tenant, not a market: a business sending to two
         * countries is one customer of yours, and forcing it into two profiles would give it two
         * API keys, two inboxes and two contact lists for one business. The platform already
         * assumes many — CustomerChannelProviders is unique on (customer, channel, iso, number).
         *
         * No mode: a sender is the profile's own or it has none. Listing a market is the request
         * for one.
         *
         * Also the discriminator for everything else: the compliance catalog is keyed on (country,
         * number type), and that pair decides which fields brand accepts and what compliance is
         * asked for.
         */
        fun sms(sms: SenderProfileSms?) = sms(JsonField.ofNullable(sms))

        /** Alias for calling [Builder.sms] with `sms.orElse(null)`. */
        fun sms(sms: Optional<SenderProfileSms>) = sms(sms.getOrNull())

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed [SenderProfileSms] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sms(sms: JsonField<SenderProfileSms>) = apply { this.sms = sms }

        /**
         * The profile's own WhatsApp Business Account, named by the two identifiers the
         * organization cannot answer for you.
         *
         * No mode: a profile's WABA is its own or it has none. Sharing the organization's would
         * mean sharing its inbox and its throughput, which makes the two indistinguishable to a
         * recipient — so inheriting is not offered rather than refused.
         *
         * Everything derivable is derived. Whenever this block is present, the solution the account
         * arrived through, the client business portfolio that owns it, the access token and that
         * token's expiry are all resolved from the organization by
         * IPartnerSolutionService.ResolveAccountCredentialsAsync — the first two off the org's
         * shared-account listing, the token minted against the org's own solution. They were
         * previously asked for and are no longer accepted: solution_id and owner_business_id are
         * Meta's answer about provenance, so taking them from the caller let a request assert a
         * partnership Meta disagreed with, and the listing has to be consulted regardless because
         * it is what proves the account is one this organization may reach.
         *
         * No access token, and there never was one here: it is minted per client business portfolio
         * and rotates roughly every sixty days, so a pasted value would be stale before it was
         * useful. Asking a customer to mint a System User token in Meta Business Manager is skilled
         * work in a console they were never meant to see, and it would say nothing about which
         * solution the account came from or when it is revoked.
         */
        fun whatsapp(whatsapp: SenderProfileWhatsapp?) = whatsapp(JsonField.ofNullable(whatsapp))

        /** Alias for calling [Builder.whatsapp] with `whatsapp.orElse(null)`. */
        fun whatsapp(whatsapp: Optional<SenderProfileWhatsapp>) = whatsapp(whatsapp.getOrNull())

        /**
         * Sets [Builder.whatsapp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsapp] with a well-typed [SenderProfileWhatsapp]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun whatsapp(whatsapp: JsonField<SenderProfileWhatsapp>) = apply {
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
         * Returns an immutable instance of [SenderProfileChannels].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfileChannels =
            SenderProfileChannels(rcs, sms, whatsapp, additionalProperties.toMutableMap())
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
    fun validate(): SenderProfileChannels = apply {
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

        return other is SenderProfileChannels &&
            rcs == other.rcs &&
            sms == other.sms &&
            whatsapp == other.whatsapp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(rcs, sms, whatsapp, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfileChannels{rcs=$rcs, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
}
