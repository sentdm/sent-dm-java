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
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.sms.MarketCompliance
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Supplies the market's identity and documents, and answers with the market as stored — the same
 * shape `GET` on this path returns.
 *
 * |To change                              |Send                                                                                                    |
 * |---------------------------------------|--------------------------------------------------------------------------------------------------------|
 * |a `brand` value (US `TEN_DLC`)         |`compliance.brand`, as below                                                                            |
 * |a registration sent back for correction|`compliance.brand` — the identity is accepted even once filed, and the registration goes back for review|
 * |a document, in any market              |a multipart file named after the document's key                                                         |
 * |a campaign                             |`PATCH /v3/channels/sms/US/TEN_DLC/campaigns/{id}` — `compliance.campaign` here is `400`                |
 * |the numbers                            |`POST /v3/channels/{channel}/{country}/{type}/numbers` — `numbers` here is `400`                        |
 *
 * ## Partial, at every level
 *
 * **An omitted key is left alone. An explicit `null` clears it.** Those are different requests, so
 * `{}` changes nothing and is refused rather than silently accepted, and correcting one field does
 * not blank the others.
 *
 * ```json
 * { "compliance": { "brand": { "contact_phone": "+12125550123" } } }
 * ```
 *
 * | Body                           | Effect                                                       |
 * |--------------------------------|--------------------------------------------------------------|
 * | `"brand": { … }`               | supplies or corrects the identity, and takes one of your own |
 * | `"brand": { "inherit": true }` | runs on your organization's, giving up your own              |
 * | `"brand": null`                | the same thing, said the short way                           |
 * | key omitted                    | left exactly as it is                                        |
 *
 * The brand read on this path, its `id` and `vetting` included, can be sent back unchanged: both
 * are read-only and ignored.
 *
 * ## Every other market
 *
 * Markets that register with no regime have no brand, so `compliance` is `400` there. Their
 * compliance is documents, sent here as multipart.
 *
 * ## Documents
 *
 * Send `multipart/form-data` with **each file named after the compliance key it satisfies** — the
 * key `GET /v3/channels/{channel}/{country}/compliance` lists. A file that matches no document the
 * market asks for is `400` naming the keys that would, and a file the upload rules refuse (empty,
 * too large, an unsupported type) is `422`. `compliance` may ride in the same form as a text part
 * holding its JSON.
 *
 * ## What it will refuse
 *
 * **A filed identity is `409`.** Once the registration has gone to The Campaign Registry they hold
 * a copy, and a local change would diverge from it silently. The exception is a registration sent
 * back for correction: the identity is accepted, and the registration goes back for review.
 * Refiling it with The Campaign Registry stays with Sent.
 *
 * Nothing is submitted to a regime here. Send `x-profile-id` with an organization key to write one
 * of your profiles' markets.
 */
class MarketUpdateParams
private constructor(
    private val channel: String,
    private val country: String,
    private val type: String?,
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun channel(): String = channel

    fun country(): String = country

    fun type(): Optional<String> = Optional.ofNullable(type)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * The compliance values a market registers with. `brand` and `campaign` apply to US `TEN_DLC`;
     * other markets fill this map with the document keys their own requirements name.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<MarketCompliance> = body.compliance()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _compliance(): JsonField<MarketCompliance> = body._compliance()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MarketUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .channel()
         * .country()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MarketUpdateParams]. */
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
        internal fun from(marketUpdateParams: MarketUpdateParams) = apply {
            channel = marketUpdateParams.channel
            country = marketUpdateParams.country
            type = marketUpdateParams.type
            idempotencyKey = marketUpdateParams.idempotencyKey
            xProfileId = marketUpdateParams.xProfileId
            body = marketUpdateParams.body.toBuilder()
            additionalHeaders = marketUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = marketUpdateParams.additionalQueryParams.toBuilder()
        }

        fun channel(channel: String) = apply { this.channel = channel }

        fun country(country: String) = apply { this.country = country }

        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [compliance]
         * - [sandbox]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The compliance values a market registers with. `brand` and `campaign` apply to US
         * `TEN_DLC`; other markets fill this map with the document keys their own requirements
         * name.
         */
        fun compliance(compliance: MarketCompliance) = apply { body.compliance(compliance) }

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [MarketCompliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<MarketCompliance>) = apply {
            body.compliance(compliance)
        }

        fun sandbox(sandbox: Boolean) = apply { body.sandbox(sandbox) }

        /**
         * Sets [Builder.sandbox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sandbox(sandbox: JsonField<Boolean>) = apply { body.sandbox(sandbox) }

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
         * Returns an immutable instance of [MarketUpdateParams].
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
        fun build(): MarketUpdateParams =
            MarketUpdateParams(
                checkRequired("channel", channel),
                checkRequired("country", country),
                type,
                idempotencyKey,
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
                idempotencyKey?.let { put("Idempotency-Key", it) }
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val compliance: JsonField<MarketCompliance>,
        private val sandbox: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("compliance")
            @ExcludeMissing
            compliance: JsonField<MarketCompliance> = JsonMissing.of(),
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
        ) : this(compliance, sandbox, mutableMapOf())

        /**
         * The compliance values a market registers with. `brand` and `campaign` apply to US
         * `TEN_DLC`; other markets fill this map with the document keys their own requirements
         * name.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun compliance(): Optional<MarketCompliance> = compliance.getOptional("compliance")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Returns the raw JSON value of [compliance].
         *
         * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("compliance")
        @ExcludeMissing
        fun _compliance(): JsonField<MarketCompliance> = compliance

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var compliance: JsonField<MarketCompliance> = JsonMissing.of()
            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                compliance = body.compliance
                sandbox = body.sandbox
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The compliance values a market registers with. `brand` and `campaign` apply to US
             * `TEN_DLC`; other markets fill this map with the document keys their own requirements
             * name.
             */
            fun compliance(compliance: MarketCompliance) = compliance(JsonField.of(compliance))

            /**
             * Sets [Builder.compliance] to an arbitrary JSON value.
             *
             * You should usually call [Builder.compliance] with a well-typed [MarketCompliance]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun compliance(compliance: JsonField<MarketCompliance>) = apply {
                this.compliance = compliance
            }

            fun sandbox(sandbox: Boolean) = sandbox(JsonField.of(sandbox))

            /**
             * Sets [Builder.sandbox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sandbox(sandbox: JsonField<Boolean>) = apply { this.sandbox = sandbox }

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
             */
            fun build(): Body = Body(compliance, sandbox, additionalProperties.toMutableMap())
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

            compliance().ifPresent { it.validate() }
            sandbox()
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
                (if (sandbox.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                compliance == other.compliance &&
                sandbox == other.sandbox &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(compliance, sandbox, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{compliance=$compliance, sandbox=$sandbox, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MarketUpdateParams &&
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
        "MarketUpdateParams{channel=$channel, country=$country, type=$type, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
