// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import dm.sent.core.Params
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Every number you hold in one market (country and sender type): `ACTIVE` once it can send,
 * `PROVISIONING` while it is still to be assigned (it then has no `sender_value` yet), `INACTIVE`
 * once it could send and no longer can. US `TEN_DLC` numbers name their `campaign_id`, and
 * `?campaign_id=` keeps one campaign's.
 *
 * A market you do not hold is `404`. Add numbers with `POST` on the same path.
 */
class MarketListNumbersParams
private constructor(
    private val channel: String,
    private val country: String,
    private val type: String?,
    private val campaignId: String?,
    private val xProfileId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun channel(): String = channel

    fun country(): String = country

    fun type(): Optional<String> = Optional.ofNullable(type)

    /** Only the numbers of this campaign (US TEN_DLC); all of the market's when absent. */
    fun campaignId(): Optional<String> = Optional.ofNullable(campaignId)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MarketListNumbersParams].
         *
         * The following fields are required:
         * ```java
         * .channel()
         * .country()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MarketListNumbersParams]. */
    class Builder internal constructor() {

        private var channel: String? = null
        private var country: String? = null
        private var type: String? = null
        private var campaignId: String? = null
        private var xProfileId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(marketListNumbersParams: MarketListNumbersParams) = apply {
            channel = marketListNumbersParams.channel
            country = marketListNumbersParams.country
            type = marketListNumbersParams.type
            campaignId = marketListNumbersParams.campaignId
            xProfileId = marketListNumbersParams.xProfileId
            additionalHeaders = marketListNumbersParams.additionalHeaders.toBuilder()
            additionalQueryParams = marketListNumbersParams.additionalQueryParams.toBuilder()
        }

        fun channel(channel: String) = apply { this.channel = channel }

        fun country(country: String) = apply { this.country = country }

        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        /** Only the numbers of this campaign (US TEN_DLC); all of the market's when absent. */
        fun campaignId(campaignId: String?) = apply { this.campaignId = campaignId }

        /** Alias for calling [Builder.campaignId] with `campaignId.orElse(null)`. */
        fun campaignId(campaignId: Optional<String>) = campaignId(campaignId.getOrNull())

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
         * Returns an immutable instance of [MarketListNumbersParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .channel()
         * .country()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MarketListNumbersParams =
            MarketListNumbersParams(
                checkRequired("channel", channel),
                checkRequired("country", country),
                type,
                campaignId,
                xProfileId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> channel
            1 -> country
            2 -> type ?: ""
            else -> ""
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
                campaignId?.let { put("campaign_id", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MarketListNumbersParams &&
            channel == other.channel &&
            country == other.country &&
            type == other.type &&
            campaignId == other.campaignId &&
            xProfileId == other.xProfileId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            channel,
            country,
            type,
            campaignId,
            xProfileId,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "MarketListNumbersParams{channel=$channel, country=$country, type=$type, campaignId=$campaignId, xProfileId=$xProfileId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
