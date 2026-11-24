// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.sms.SmsNumberRequest
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Adds numbers to a market you hold. They are **added** to what it already asks for, never
 * replacing it — with one exception: a US `TEN_DLC` campaign opened without `numbers` asks for one
 * number in any area code by default, and while it holds no number yet, the first numbers added
 * replace that default. Once it holds one, they are added beside it.
 *
 * ## Where they go
 * - **SMS US `TEN_DLC`**: to **one campaign of your own**, named by `campaign_id` — the `id` of an
 *   entry in the market's `compliance.campaigns` (`GET /v3/channels/sms/US/TEN_DLC`). Required:
 *   left out it is `400` naming your campaigns in service. One you inherit from your organization
 *   is `400`: its numbers are the organization's. One out of service — expired, deactivated or
 *   released — is `409`. A campaign the carriers have not approved yet gets its numbers when they
 *   do; an approved one gets them now. With everything it asks for, a campaign holds at most 49
 *   numbers, counting one for each sender profile inheriting it.
 * - **`LOCAL`**: to the market, claimed from inventory now; what inventory cannot cover stays
 *   pending. No `campaign_id`. A market holds at most 49 numbers.
 * - **Any other sender type** takes no numbers: `400`.
 *
 * ## What to send
 *
 * `numbers` — the list `POST /v3/channels/sms` takes, one entry per area code — and, on US
 * `TEN_DLC`, `campaign_id`, required.
 *
 * Until a number is assigned it reads as `PROVISIONING` in the market's `numbers`, with the area
 * code it was asked for. Returns **the market**, in the shape `GET
 * /v3/channels/sms/{country}/{type}` returns, with `202`.
 */
class MarketAddNumbersParams
private constructor(
    private val channel: String,
    private val country: String,
    private val type: String?,
    private val idempotencyKey: String,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun channel(): String = channel

    fun country(): String = country

    fun type(): Optional<String> = Optional.ofNullable(type)

    fun idempotencyKey(): String = idempotencyKey

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * The numbers, one entry per area code, e.g.
     * [{"area_code": "415", "quantity": 2}, {"quantity": 1}]. quantity defaults to 1, and an entry
     * without area_code means any area code. Required.
     *
     * POST adds them to what the market or campaign already asks for; PATCH replaces that list with
     * them, and has to cover every number already held, since none is ever released.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun numbers(): List<SmsNumberRequest> = body.numbers()

    /**
     * The campaign to add the numbers to, as campaigns[].id reports it. Required on SMS US TEN_DLC,
     * where every number belongs to a campaign; refused on a market without campaigns.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun campaignId(): Optional<String> = body.campaignId()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [numbers].
     *
     * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _numbers(): JsonField<List<SmsNumberRequest>> = body._numbers()

    /**
     * Returns the raw JSON value of [campaignId].
     *
     * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _campaignId(): JsonField<String> = body._campaignId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MarketAddNumbersParams].
         *
         * The following fields are required:
         * ```java
         * .channel()
         * .country()
         * .idempotencyKey()
         * .numbers()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MarketAddNumbersParams]. */
    class Builder internal constructor() {

        private var channel: String? = null
        private var country: String? = null
        private var type: String? = null
        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(marketAddNumbersParams: MarketAddNumbersParams) = apply {
            channel = marketAddNumbersParams.channel
            country = marketAddNumbersParams.country
            type = marketAddNumbersParams.type
            idempotencyKey = marketAddNumbersParams.idempotencyKey
            xProfileId = marketAddNumbersParams.xProfileId
            body = marketAddNumbersParams.body.toBuilder()
            additionalHeaders = marketAddNumbersParams.additionalHeaders.toBuilder()
            additionalQueryParams = marketAddNumbersParams.additionalQueryParams.toBuilder()
        }

        fun channel(channel: String) = apply { this.channel = channel }

        fun country(country: String) = apply { this.country = country }

        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        fun idempotencyKey(idempotencyKey: String) = apply { this.idempotencyKey = idempotencyKey }

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [sandbox]
         * - [numbers]
         * - [campaignId]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun sandbox(sandbox: Boolean) = apply { body.sandbox(sandbox) }

        /**
         * Sets [Builder.sandbox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sandbox(sandbox: JsonField<Boolean>) = apply { body.sandbox(sandbox) }

        /**
         * The numbers, one entry per area code, e.g.
         * [{"area_code": "415", "quantity": 2}, {"quantity": 1}]. quantity defaults to 1, and an
         * entry without area_code means any area code. Required.
         *
         * POST adds them to what the market or campaign already asks for; PATCH replaces that list
         * with them, and has to cover every number already held, since none is ever released.
         */
        fun numbers(numbers: List<SmsNumberRequest>) = apply { body.numbers(numbers) }

        /**
         * Sets [Builder.numbers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numbers] with a well-typed `List<SmsNumberRequest>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun numbers(numbers: JsonField<List<SmsNumberRequest>>) = apply { body.numbers(numbers) }

        /**
         * Adds a single [SmsNumberRequest] to [numbers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addNumber(number: SmsNumberRequest) = apply { body.addNumber(number) }

        /**
         * The campaign to add the numbers to, as campaigns[].id reports it. Required on SMS US
         * TEN_DLC, where every number belongs to a campaign; refused on a market without campaigns.
         */
        fun campaignId(campaignId: String?) = apply { body.campaignId(campaignId) }

        /** Alias for calling [Builder.campaignId] with `campaignId.orElse(null)`. */
        fun campaignId(campaignId: Optional<String>) = campaignId(campaignId.getOrNull())

        /**
         * Sets [Builder.campaignId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaignId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun campaignId(campaignId: JsonField<String>) = apply { body.campaignId(campaignId) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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
         * Returns an immutable instance of [MarketAddNumbersParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .channel()
         * .country()
         * .idempotencyKey()
         * .numbers()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MarketAddNumbersParams =
            MarketAddNumbersParams(
                checkRequired("channel", channel),
                checkRequired("country", country),
                type,
                checkRequired("idempotencyKey", idempotencyKey),
                xProfileId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

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
                put("Idempotency-Key", idempotencyKey)
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * What adding to (AddMarketNumbersRequest) and replacing (ReplaceMarketNumbersRequest) a
     * market's numbers share: the market in the path and, on SMS US TEN_DLC, the campaign they
     * belong to.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val numbers: JsonField<List<SmsNumberRequest>>,
        private val campaignId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("numbers")
            @ExcludeMissing
            numbers: JsonField<List<SmsNumberRequest>> = JsonMissing.of(),
            @JsonProperty("campaign_id")
            @ExcludeMissing
            campaignId: JsonField<String> = JsonMissing.of(),
        ) : this(sandbox, numbers, campaignId, mutableMapOf())

        fun toMutationRequest(): MutationRequest =
            MutationRequest.builder().sandbox(sandbox).build()

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * The numbers, one entry per area code, e.g.
         * [{"area_code": "415", "quantity": 2}, {"quantity": 1}]. quantity defaults to 1, and an
         * entry without area_code means any area code. Required.
         *
         * POST adds them to what the market or campaign already asks for; PATCH replaces that list
         * with them, and has to cover every number already held, since none is ever released.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun numbers(): List<SmsNumberRequest> = numbers.getRequired("numbers")

        /**
         * The campaign to add the numbers to, as campaigns[].id reports it. Required on SMS US
         * TEN_DLC, where every number belongs to a campaign; refused on a market without campaigns.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun campaignId(): Optional<String> = campaignId.getOptional("campaign_id")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [numbers].
         *
         * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("numbers")
        @ExcludeMissing
        fun _numbers(): JsonField<List<SmsNumberRequest>> = numbers

        /**
         * Returns the raw JSON value of [campaignId].
         *
         * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaign_id")
        @ExcludeMissing
        fun _campaignId(): JsonField<String> = campaignId

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .numbers()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var numbers: JsonField<MutableList<SmsNumberRequest>>? = null
            private var campaignId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                numbers = body.numbers.map { it.toMutableList() }
                campaignId = body.campaignId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Sandbox flag - when true, the operation is simulated without side effects Useful for
             * testing integrations without actual execution
             */
            fun sandbox(sandbox: Boolean) = sandbox(JsonField.of(sandbox))

            /**
             * Sets [Builder.sandbox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sandbox(sandbox: JsonField<Boolean>) = apply { this.sandbox = sandbox }

            /**
             * The numbers, one entry per area code, e.g.
             * [{"area_code": "415", "quantity": 2}, {"quantity": 1}]. quantity defaults to 1, and
             * an entry without area_code means any area code. Required.
             *
             * POST adds them to what the market or campaign already asks for; PATCH replaces that
             * list with them, and has to cover every number already held, since none is ever
             * released.
             */
            fun numbers(numbers: List<SmsNumberRequest>) = numbers(JsonField.of(numbers))

            /**
             * Sets [Builder.numbers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numbers] with a well-typed `List<SmsNumberRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun numbers(numbers: JsonField<List<SmsNumberRequest>>) = apply {
                this.numbers = numbers.map { it.toMutableList() }
            }

            /**
             * Adds a single [SmsNumberRequest] to [numbers].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addNumber(number: SmsNumberRequest) = apply {
                numbers =
                    (numbers ?: JsonField.of(mutableListOf())).also {
                        checkKnown("numbers", it).add(number)
                    }
            }

            /**
             * The campaign to add the numbers to, as campaigns[].id reports it. Required on SMS US
             * TEN_DLC, where every number belongs to a campaign; refused on a market without
             * campaigns.
             */
            fun campaignId(campaignId: String?) = campaignId(JsonField.ofNullable(campaignId))

            /** Alias for calling [Builder.campaignId] with `campaignId.orElse(null)`. */
            fun campaignId(campaignId: Optional<String>) = campaignId(campaignId.getOrNull())

            /**
             * Sets [Builder.campaignId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaignId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaignId(campaignId: JsonField<String>) = apply { this.campaignId = campaignId }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .numbers()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    sandbox,
                    checkRequired("numbers", numbers).map { it.toImmutable() },
                    campaignId,
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            sandbox()
            numbers().forEach { it?.validate() }
            campaignId()
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
            (if (sandbox.asKnown().isPresent) 1 else 0) +
                (numbers.asKnown().getOrNull()?.sumOf { (it?.validity() ?: 0).toInt() } ?: 0) +
                (if (campaignId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                numbers == other.numbers &&
                campaignId == other.campaignId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sandbox, numbers, campaignId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, numbers=$numbers, campaignId=$campaignId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MarketAddNumbersParams &&
            channel == other.channel &&
            country == other.country &&
            type == other.type &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            channel,
            country,
            type,
            idempotencyKey,
            xProfileId,
            body,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "MarketAddNumbersParams{channel=$channel, country=$country, type=$type, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
