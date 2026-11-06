// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import dm.sent.core.Params
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **Call this first.** It returns what a channel, country and sender type demand before you can
 * send there — and `setup[]`, the calls that satisfy those demands, in order, each with a body you
 * can copy and send as it stands. You never have to track forty countries' rules yourself.
 *
 * ## Channel
 *
 * `channel` is `sms`, `whatsapp` or `rcs`, and **defaults to `sms`** — so a caller that omits it
 * gets exactly what this endpoint has always returned.
 *
 * `sms` is the only one answered today; the other two are `501` until their requirements are
 * declared. They are refused rather than answered with an empty requirement set, because empty
 * would say the channel demands nothing, and both demand plenty — WhatsApp a business verification
 * and a display name review, RCS a carrier approval. Saying "not yet" is the true answer and the
 * same one `POST /v3/sender-profiles` gives for `channels.whatsapp`.
 *
 * `type` is an SMS sender type, and SMS is the only channel whose senders have one.
 *
 * Requirements vary enormously. US `TEN_DLC` registers a brand and a campaign with The Campaign
 * Registry and asks for a substantial set of values. An alphanumeric sender in one country
 * pre-registers with supporting documents; in another it needs nothing at all. This is the
 * authoritative answer for whichever market you are asking about, and it is the same declaration
 * used to validate the calls themselves — so it can never drift from what is actually enforced.
 *
 * ## `setup[]` — what to do
 *
 * **One step.** `POST /v3/channels/sms` adds the market and records everything it registers with —
 * the identity in `compliance.brand`, the programme in `compliance.campaign`. There were three, in
 * a load-bearing order, while the identity and the campaign were resources of their own; they are
 * members of this call's body now, so there is nothing to sequence.
 *
 * Correct any of it afterwards with `PATCH /v3/channels/sms/{country}/{type}`, which takes the same
 * `compliance` object one key at a time.
 *
 * Each step's `body` has every key that market wants already present, with the values left
 * **blank**. Blank rather than filled with placeholders, because the body is meant to be sent: a
 * null value counts as not supplied, so posting a step verbatim comes back naming every blank you
 * left. `attachments[]` lists files to send as multipart on the channel call, each under the field
 * name given — a file cannot be a JSON value, so documents are never listed in `compliance[]`.
 *
 * Every step is a call for whoever holds the key. To set a **sender profile** up instead, send the
 * same requests with the `x-profile-id` header naming it; there is no separate path.
 *
 * ## `requirements[]` — what each value means
 *
 * Each entry names a key for the `compliance` array, its value type, and whether it is required.
 * `required_when` marks values needed only in certain cases — evaluate it against your own payload,
 * e.g. `brand.entity_type == PUBLIC_PROFIT`. `options` lists accepted values where the market
 * constrains them, and `label` is suitable for rendering a form field.
 *
 * Values Sent supplies on your behalf are never listed: correlation ids, environment flags, carrier
 * elections, and booleans derivable from what you already send.
 *
 * ## When nothing is required
 *
 * `required` is `false` and `requirements` is empty, and the single `setup` step carries no
 * `compliance` array at all. A `sender_id_pattern` may still be present — many markets constrain
 * the sender string without registering anything.
 */
class ComplianceRetrieveRequirementsParams
private constructor(
    private val channel: String?,
    private val country: String?,
    private val type: String?,
    private val xProfileId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Channel the sender is for: sms, whatsapp or rcs. Defaults to sms, which is the only one
     * answered today — the other two are 501 until their requirements are declared.
     */
    fun channel(): Optional<String> = Optional.ofNullable(channel)

    /** ISO 3166-1 alpha-2 country code, e.g. US, XK, IN */
    fun country(): Optional<String> = Optional.ofNullable(country)

    /**
     * Sender type: LOCAL, MOBILE, TEN_DLC, TOLL_FREE, SHORT_CODE, ALPHANUMERIC. 10DLC is accepted
     * as a synonym of TEN_DLC, the same as on POST /v3/sender-profiles. Applies to channel=sms, the
     * only channel whose senders have a type.
     */
    fun type(): Optional<String> = Optional.ofNullable(type)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ComplianceRetrieveRequirementsParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [ComplianceRetrieveRequirementsParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComplianceRetrieveRequirementsParams]. */
    class Builder internal constructor() {

        private var channel: String? = null
        private var country: String? = null
        private var type: String? = null
        private var xProfileId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            complianceRetrieveRequirementsParams: ComplianceRetrieveRequirementsParams
        ) = apply {
            channel = complianceRetrieveRequirementsParams.channel
            country = complianceRetrieveRequirementsParams.country
            type = complianceRetrieveRequirementsParams.type
            xProfileId = complianceRetrieveRequirementsParams.xProfileId
            additionalHeaders = complianceRetrieveRequirementsParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                complianceRetrieveRequirementsParams.additionalQueryParams.toBuilder()
        }

        /**
         * Channel the sender is for: sms, whatsapp or rcs. Defaults to sms, which is the only one
         * answered today — the other two are 501 until their requirements are declared.
         */
        fun channel(channel: String?) = apply { this.channel = channel }

        /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
        fun channel(channel: Optional<String>) = channel(channel.getOrNull())

        /** ISO 3166-1 alpha-2 country code, e.g. US, XK, IN */
        fun country(country: String?) = apply { this.country = country }

        /** Alias for calling [Builder.country] with `country.orElse(null)`. */
        fun country(country: Optional<String>) = country(country.getOrNull())

        /**
         * Sender type: LOCAL, MOBILE, TEN_DLC, TOLL_FREE, SHORT_CODE, ALPHANUMERIC. 10DLC is
         * accepted as a synonym of TEN_DLC, the same as on POST /v3/sender-profiles. Applies to
         * channel=sms, the only channel whose senders have a type.
         */
        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ComplianceRetrieveRequirementsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ComplianceRetrieveRequirementsParams =
            ComplianceRetrieveRequirementsParams(
                channel,
                country,
                type,
                xProfileId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                channel?.let { put("channel", it) }
                country?.let { put("country", it) }
                type?.let { put("type", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComplianceRetrieveRequirementsParams &&
            channel == other.channel &&
            country == other.country &&
            type == other.type &&
            xProfileId == other.xProfileId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(channel, country, type, xProfileId, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ComplianceRetrieveRequirementsParams{channel=$channel, country=$country, type=$type, xProfileId=$xProfileId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
