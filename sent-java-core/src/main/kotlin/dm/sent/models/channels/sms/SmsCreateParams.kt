// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
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
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Gives the customer a sender in one country — the first market it sends in, and the fifth.
 *
 * ## What to have in place first
 *
 * **Call `GET /v3/compliance/requirements?country=US&type=TEN_DLC` first.** It returns this
 * request's body ready to fill in, plus the brand and campaign calls to make before it, in order.
 * You never have to track forty countries' rules yourself.
 *
 * **A market that registers with a compliance regime needs an identity, and this call takes one.**
 * US `TEN_DLC` registers with The Campaign Registry and files that registration against a business
 * identity. Send it in `compliance.brand` and it is recorded here, before the registration that
 * attaches to it — so a customer with no identity reaches a first 10DLC market in one call.
 *
 * `{ "inherit": true }` runs on your organization's instead. A market with neither — none stored,
 * none sent — is `400`, because accepting it would write a channel that could never register and
 * leave it provisioning for ever with nothing saying why.
 *
 * **Everything the regime wants arrives in this request's `compliance`**, as two declared objects:
 * `brand` — the identity the registration is filed against — and `campaign`, with the use case, the
 * consent narrative, the volume, the sample messages and the keywords. There is nothing to set up
 * first. Nothing is submitted here either: the rows are what a submission is later assembled from,
 * and filing is externally rejectable so it happens on its own path.
 *
 * **A half you run yourself has to be complete here.** Whichever of `brand` and `campaign` is your
 * own rather than your organization's must carry every field the regime asks of it, counting what
 * you already hold — send the rest in this request. A missing one is `400` naming each field,
 * rather than a `202` for a market that could never be filed. A half you inherit is asked for
 * nothing.
 *
 * A market that registers with nobody — an alphanumeric sender in most countries — needs neither,
 * and may need documents instead.
 *
 * ## Sending it
 *
 * Takes the same fields `channels.sms` takes on `POST /v3/sender-profiles`, because it is the same
 * work, and both run one provisioning path. `compliance` is top-level and answers for the market in
 * this request, carrying `brand` and `campaign` where the market registers.
 *
 * **Accepts multipart as well as JSON**, with each file named after the compliance key it satisfies
 * — a market that pre-registers its sender needs its documents at the same moment it needs the
 * sender. Every required document must be attached to this request; a missing or invalid file is
 * rejected before the market is added.
 *
 * **`area_codes` puts the sender somewhere specific**, in your order of preference, for a `LOCAL`
 * sender in any country or a US `TEN_DLC` sender — a 10DLC number is an ordinary local long code
 * bound to a registered campaign, so both take the same codes out of the same inventory. It is
 * honoured exactly: you get a number in one of the codes you named or you get none, never one in a
 * code you left out.
 *
 * ## Several numbers
 *
 * **`numbers` lists the numbers you want, one entry per area code**, e.g. `[{"area_code": "212",
 * "quantity": 2}, {"quantity": 1}]` for two numbers in 212 and one in any area code. `quantity`
 * defaults to 1, and an entry without `area_code` means any area code. Omit `numbers` for one
 * number. It is for `LOCAL` and `TEN_DLC` only and cannot be combined with `area_codes`. A market
 * holds at most 49 numbers, counting the ones it already has.
 *
 * **On a `LOCAL` market you already hold, `numbers` adds those numbers to it** instead of `409`. US
 * `TEN_DLC` numbers belong to the market's campaign and are assigned when the campaign is approved,
 * not at request time. Until then they read as `PROVISIONING` in the response's `numbers`, each
 * with the area code it was asked for. A profile inheriting your organization's campaign cannot
 * request `numbers` (`400`). `numbers` on a `TEN_DLC` market you already hold is `409`: its numbers
 * belong to its one campaign and are set when the market is created.
 *
 * **A market you already send in is `409`**: adding what is already there is a mistake worth
 * reporting rather than a silent no-op. A market is a `(country, sender_type)` pair, so a **second
 * sender type in a country you already send in is fine** — `US TOLL_FREE` alongside `US TEN_DLC` is
 * the ordinary case. Two of the same type is not.
 *
 * **A market you hold that has no sender yet is not a duplicate**, and re-sending it re-asks for a
 * sender rather than being refused. That is the way out of an area-code request nothing could fill:
 * send the call again to name different codes, or no codes at all to take a number anywhere in the
 * country. It answers `201` with the sender when the pool has one, otherwise `202` with the codes
 * recorded — and changes nothing else; compliance on a market you hold is `PATCH
 * /v3/channels/sms/{country}/{type}`.
 *
 * One exception: while a market's sender type is still unassigned, adding any type to that country
 * is `409` once it has a sender, because the market you have may be about to become the one you
 * asked for.
 *
 * Returns **the market**, in the shape `GET` and `PATCH` on `/v3/channels/sms/{country}/{type}` use
 * — so what this answers can be read back and written back without reshaping. Not every channel you
 * have: adding a market cannot change an RCS agent or a WhatsApp account, and `GET /v3/channels` is
 * the whole picture. `201` when the market is ready; `202` while a sender or a registration is
 * still outstanding.
 *
 * Send `x-profile-id` with an organization key to add a market to one of your profiles.
 */
class SmsCreateParams
private constructor(
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

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
     * Sender type. Decides the provisioning flow and what compliance is asked for.
     *
     * [Required] so the published document says so. The validator has always demanded it, but
     * requiredness reached the schema by matching a rule to a property name — which works for
     * country, whose wire name is its camel-cased C# name, and silently does not for number_type. A
     * client generating a request from our OpenAPI therefore sent what the document called
     * sufficient and was answered 400.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun numberType(): NumberType = body.numberType()

    /**
     * The area codes to put this sender in, in your own order of preference, e.g. ["415", "628"]
     * for the US or ["20"] for London. Omit it and a number is claimed anywhere in the country.
     *
     * Ordered, and the order is the request. The claim tries each code in turn and stops at the
     * first that yields a number. Nothing sorts the list and a code listed twice is refused.
     *
     * One to fifty entries, each the area code as digits: 415, with the trunk prefix as 020, or
     * with the country's dialing prefix as +1415 (all are stored as the bare code). A dialing
     * prefix from a different country than country is refused. Each code is checked against the
     * country's numbering plan: it must start real local or mobile numbers there, so toll-free and
     * premium ranges, service codes and another country's codes are refused with a reason.
     *
     * LOCAL senders in any country, and US TEN_DLC senders. No other sender type has a geographic
     * area code, and the list is refused with one rather than accepted and dropped.
     *
     * Honoured exactly or not at all. Ask for 415 and you get a 415 number or you get none, never a
     * neighbouring code you did not name. A miss leaves the market with no sender yet and the codes
     * recorded on it, so it is filled when stock appears rather than filled now from somewhere
     * else. Many countries outside North America require address or business documents before a
     * local number can be bought, which can delay or prevent the fill.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun areaCodes(): Optional<List<String>> = body.areaCodes()

    /**
     * The compliance values a market registers with. `brand` and `campaign` apply to US `TEN_DLC`;
     * other markets fill this map with the document keys their own requirements name.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<MarketCompliance> = body.compliance()

    /**
     * ISO 3166-1 alpha-2 country the sender operates in.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun country(): Optional<String> = body.country()

    /**
     * The numbers to assign, one entry per area code, e.g.
     * [{"area_code": "212", "quantity": 2}, {"area_code": "415"}, {"quantity": 1}]: two numbers in
     * 212, one in 415 and one in any area code. quantity defaults to 1, and an entry without
     * area_code means any area code. Omit numbers for one number.
     *
     * Only with LOCAL or TEN_DLC, and not together with area_codes. Each area code is validated
     * against country the same way area_codes is and may appear once, and at most one entry may
     * leave area_code out. On a LOCAL market you already hold, this adds the numbers to it. US
     * TEN_DLC numbers are assigned when the campaign is approved, not at request time. Not
     * available when the profile inherits the organization's campaign.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun numbers(): Optional<List<SmsNumberRequest>> = body.numbers()

    /**
     * The sender's identity where the caller chooses it. Required when number_type is ALPHANUMERIC;
     * optional for carrier-assigned types, which are procured afterwards.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderValue(): Optional<String> = body.senderValue()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [numberType].
     *
     * Unlike [numberType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _numberType(): JsonField<NumberType> = body._numberType()

    /**
     * Returns the raw JSON value of [areaCodes].
     *
     * Unlike [areaCodes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _areaCodes(): JsonField<List<String>> = body._areaCodes()

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _compliance(): JsonField<MarketCompliance> = body._compliance()

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _country(): JsonField<String> = body._country()

    /**
     * Returns the raw JSON value of [numbers].
     *
     * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _numbers(): JsonField<List<SmsNumberRequest>> = body._numbers()

    /**
     * Returns the raw JSON value of [senderValue].
     *
     * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _senderValue(): JsonField<String> = body._senderValue()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SmsCreateParams].
         *
         * The following fields are required:
         * ```java
         * .numberType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SmsCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(smsCreateParams: SmsCreateParams) = apply {
            idempotencyKey = smsCreateParams.idempotencyKey
            xProfileId = smsCreateParams.xProfileId
            body = smsCreateParams.body.toBuilder()
            additionalHeaders = smsCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = smsCreateParams.additionalQueryParams.toBuilder()
        }

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
         * - [sandbox]
         * - [numberType]
         * - [areaCodes]
         * - [compliance]
         * - [country]
         * - etc.
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
         * Sender type. Decides the provisioning flow and what compliance is asked for.
         *
         * [Required] so the published document says so. The validator has always demanded it, but
         * requiredness reached the schema by matching a rule to a property name — which works for
         * country, whose wire name is its camel-cased C# name, and silently does not for
         * number_type. A client generating a request from our OpenAPI therefore sent what the
         * document called sufficient and was answered 400.
         */
        fun numberType(numberType: NumberType) = apply { body.numberType(numberType) }

        /**
         * Sets [Builder.numberType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numberType] with a well-typed [NumberType] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun numberType(numberType: JsonField<NumberType>) = apply { body.numberType(numberType) }

        /**
         * The area codes to put this sender in, in your own order of preference, e.g.
         * ["415", "628"] for the US or ["20"] for London. Omit it and a number is claimed anywhere
         * in the country.
         *
         * Ordered, and the order is the request. The claim tries each code in turn and stops at the
         * first that yields a number. Nothing sorts the list and a code listed twice is refused.
         *
         * One to fifty entries, each the area code as digits: 415, with the trunk prefix as 020, or
         * with the country's dialing prefix as +1415 (all are stored as the bare code). A dialing
         * prefix from a different country than country is refused. Each code is checked against the
         * country's numbering plan: it must start real local or mobile numbers there, so toll-free
         * and premium ranges, service codes and another country's codes are refused with a reason.
         *
         * LOCAL senders in any country, and US TEN_DLC senders. No other sender type has a
         * geographic area code, and the list is refused with one rather than accepted and dropped.
         *
         * Honoured exactly or not at all. Ask for 415 and you get a 415 number or you get none,
         * never a neighbouring code you did not name. A miss leaves the market with no sender yet
         * and the codes recorded on it, so it is filled when stock appears rather than filled now
         * from somewhere else. Many countries outside North America require address or business
         * documents before a local number can be bought, which can delay or prevent the fill.
         */
        fun areaCodes(areaCodes: List<String>?) = apply { body.areaCodes(areaCodes) }

        /** Alias for calling [Builder.areaCodes] with `areaCodes.orElse(null)`. */
        fun areaCodes(areaCodes: Optional<List<String>>) = areaCodes(areaCodes.getOrNull())

        /**
         * Sets [Builder.areaCodes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.areaCodes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun areaCodes(areaCodes: JsonField<List<String>>) = apply { body.areaCodes(areaCodes) }

        /**
         * Adds a single [String] to [areaCodes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAreaCode(areaCode: String) = apply { body.addAreaCode(areaCode) }

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

        /** ISO 3166-1 alpha-2 country the sender operates in. */
        fun country(country: String) = apply { body.country(country) }

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<String>) = apply { body.country(country) }

        /**
         * The numbers to assign, one entry per area code, e.g.
         * [{"area_code": "212", "quantity": 2}, {"area_code": "415"}, {"quantity": 1}]: two numbers
         * in 212, one in 415 and one in any area code. quantity defaults to 1, and an entry without
         * area_code means any area code. Omit numbers for one number.
         *
         * Only with LOCAL or TEN_DLC, and not together with area_codes. Each area code is validated
         * against country the same way area_codes is and may appear once, and at most one entry may
         * leave area_code out. On a LOCAL market you already hold, this adds the numbers to it. US
         * TEN_DLC numbers are assigned when the campaign is approved, not at request time. Not
         * available when the profile inherits the organization's campaign.
         */
        fun numbers(numbers: List<SmsNumberRequest>?) = apply { body.numbers(numbers) }

        /** Alias for calling [Builder.numbers] with `numbers.orElse(null)`. */
        fun numbers(numbers: Optional<List<SmsNumberRequest>>) = numbers(numbers.getOrNull())

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
         * The sender's identity where the caller chooses it. Required when number_type is
         * ALPHANUMERIC; optional for carrier-assigned types, which are procured afterwards.
         */
        fun senderValue(senderValue: String?) = apply { body.senderValue(senderValue) }

        /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
        fun senderValue(senderValue: Optional<String>) = senderValue(senderValue.getOrNull())

        /**
         * Sets [Builder.senderValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun senderValue(senderValue: JsonField<String>) = apply { body.senderValue(senderValue) }

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
         * Returns an immutable instance of [SmsCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .numberType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SmsCreateParams =
            SmsCreateParams(
                idempotencyKey,
                xProfileId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Adds an SMS market — a country and a sender type — to a customer.
     *
     * The same fields channels.sms takes on POST /v3/sender-profiles, because it is the same work:
     * create is "make the profile, then add its first market", and both run one provisioning path.
     * compliance is top-level and answers for the market this request concerns, exactly as it does
     * there.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val numberType: JsonField<NumberType>,
        private val areaCodes: JsonField<List<String>>,
        private val compliance: JsonField<MarketCompliance>,
        private val country: JsonField<String>,
        private val numbers: JsonField<List<SmsNumberRequest>>,
        private val senderValue: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("number_type")
            @ExcludeMissing
            numberType: JsonField<NumberType> = JsonMissing.of(),
            @JsonProperty("area_codes")
            @ExcludeMissing
            areaCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("compliance")
            @ExcludeMissing
            compliance: JsonField<MarketCompliance> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("numbers")
            @ExcludeMissing
            numbers: JsonField<List<SmsNumberRequest>> = JsonMissing.of(),
            @JsonProperty("sender_value")
            @ExcludeMissing
            senderValue: JsonField<String> = JsonMissing.of(),
        ) : this(
            sandbox,
            numberType,
            areaCodes,
            compliance,
            country,
            numbers,
            senderValue,
            mutableMapOf(),
        )

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
         * Sender type. Decides the provisioning flow and what compliance is asked for.
         *
         * [Required] so the published document says so. The validator has always demanded it, but
         * requiredness reached the schema by matching a rule to a property name — which works for
         * country, whose wire name is its camel-cased C# name, and silently does not for
         * number_type. A client generating a request from our OpenAPI therefore sent what the
         * document called sufficient and was answered 400.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun numberType(): NumberType = numberType.getRequired("number_type")

        /**
         * The area codes to put this sender in, in your own order of preference, e.g.
         * ["415", "628"] for the US or ["20"] for London. Omit it and a number is claimed anywhere
         * in the country.
         *
         * Ordered, and the order is the request. The claim tries each code in turn and stops at the
         * first that yields a number. Nothing sorts the list and a code listed twice is refused.
         *
         * One to fifty entries, each the area code as digits: 415, with the trunk prefix as 020, or
         * with the country's dialing prefix as +1415 (all are stored as the bare code). A dialing
         * prefix from a different country than country is refused. Each code is checked against the
         * country's numbering plan: it must start real local or mobile numbers there, so toll-free
         * and premium ranges, service codes and another country's codes are refused with a reason.
         *
         * LOCAL senders in any country, and US TEN_DLC senders. No other sender type has a
         * geographic area code, and the list is refused with one rather than accepted and dropped.
         *
         * Honoured exactly or not at all. Ask for 415 and you get a 415 number or you get none,
         * never a neighbouring code you did not name. A miss leaves the market with no sender yet
         * and the codes recorded on it, so it is filled when stock appears rather than filled now
         * from somewhere else. Many countries outside North America require address or business
         * documents before a local number can be bought, which can delay or prevent the fill.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun areaCodes(): Optional<List<String>> = areaCodes.getOptional("area_codes")

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
         * ISO 3166-1 alpha-2 country the sender operates in.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * The numbers to assign, one entry per area code, e.g.
         * [{"area_code": "212", "quantity": 2}, {"area_code": "415"}, {"quantity": 1}]: two numbers
         * in 212, one in 415 and one in any area code. quantity defaults to 1, and an entry without
         * area_code means any area code. Omit numbers for one number.
         *
         * Only with LOCAL or TEN_DLC, and not together with area_codes. Each area code is validated
         * against country the same way area_codes is and may appear once, and at most one entry may
         * leave area_code out. On a LOCAL market you already hold, this adds the numbers to it. US
         * TEN_DLC numbers are assigned when the campaign is approved, not at request time. Not
         * available when the profile inherits the organization's campaign.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun numbers(): Optional<List<SmsNumberRequest>> = numbers.getOptional("numbers")

        /**
         * The sender's identity where the caller chooses it. Required when number_type is
         * ALPHANUMERIC; optional for carrier-assigned types, which are procured afterwards.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [numberType].
         *
         * Unlike [numberType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("number_type")
        @ExcludeMissing
        fun _numberType(): JsonField<NumberType> = numberType

        /**
         * Returns the raw JSON value of [areaCodes].
         *
         * Unlike [areaCodes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("area_codes")
        @ExcludeMissing
        fun _areaCodes(): JsonField<List<String>> = areaCodes

        /**
         * Returns the raw JSON value of [compliance].
         *
         * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("compliance")
        @ExcludeMissing
        fun _compliance(): JsonField<MarketCompliance> = compliance

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [numbers].
         *
         * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("numbers")
        @ExcludeMissing
        fun _numbers(): JsonField<List<SmsNumberRequest>> = numbers

        /**
         * Returns the raw JSON value of [senderValue].
         *
         * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sender_value")
        @ExcludeMissing
        fun _senderValue(): JsonField<String> = senderValue

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
             * .numberType()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var numberType: JsonField<NumberType>? = null
            private var areaCodes: JsonField<MutableList<String>>? = null
            private var compliance: JsonField<MarketCompliance> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var numbers: JsonField<MutableList<SmsNumberRequest>>? = null
            private var senderValue: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                numberType = body.numberType
                areaCodes = body.areaCodes.map { it.toMutableList() }
                compliance = body.compliance
                country = body.country
                numbers = body.numbers.map { it.toMutableList() }
                senderValue = body.senderValue
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
             * Sender type. Decides the provisioning flow and what compliance is asked for.
             *
             * [Required] so the published document says so. The validator has always demanded it,
             * but requiredness reached the schema by matching a rule to a property name — which
             * works for country, whose wire name is its camel-cased C# name, and silently does not
             * for number_type. A client generating a request from our OpenAPI therefore sent what
             * the document called sufficient and was answered 400.
             */
            fun numberType(numberType: NumberType) = numberType(JsonField.of(numberType))

            /**
             * Sets [Builder.numberType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numberType] with a well-typed [NumberType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numberType(numberType: JsonField<NumberType>) = apply {
                this.numberType = numberType
            }

            /**
             * The area codes to put this sender in, in your own order of preference, e.g.
             * ["415", "628"] for the US or ["20"] for London. Omit it and a number is claimed
             * anywhere in the country.
             *
             * Ordered, and the order is the request. The claim tries each code in turn and stops at
             * the first that yields a number. Nothing sorts the list and a code listed twice is
             * refused.
             *
             * One to fifty entries, each the area code as digits: 415, with the trunk prefix as
             * 020, or with the country's dialing prefix as +1415 (all are stored as the bare code).
             * A dialing prefix from a different country than country is refused. Each code is
             * checked against the country's numbering plan: it must start real local or mobile
             * numbers there, so toll-free and premium ranges, service codes and another country's
             * codes are refused with a reason.
             *
             * LOCAL senders in any country, and US TEN_DLC senders. No other sender type has a
             * geographic area code, and the list is refused with one rather than accepted and
             * dropped.
             *
             * Honoured exactly or not at all. Ask for 415 and you get a 415 number or you get none,
             * never a neighbouring code you did not name. A miss leaves the market with no sender
             * yet and the codes recorded on it, so it is filled when stock appears rather than
             * filled now from somewhere else. Many countries outside North America require address
             * or business documents before a local number can be bought, which can delay or prevent
             * the fill.
             */
            fun areaCodes(areaCodes: List<String>?) = areaCodes(JsonField.ofNullable(areaCodes))

            /** Alias for calling [Builder.areaCodes] with `areaCodes.orElse(null)`. */
            fun areaCodes(areaCodes: Optional<List<String>>) = areaCodes(areaCodes.getOrNull())

            /**
             * Sets [Builder.areaCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.areaCodes] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun areaCodes(areaCodes: JsonField<List<String>>) = apply {
                this.areaCodes = areaCodes.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [areaCodes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAreaCode(areaCode: String) = apply {
                areaCodes =
                    (areaCodes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("areaCodes", it).add(areaCode)
                    }
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

            /** ISO 3166-1 alpha-2 country the sender operates in. */
            fun country(country: String) = country(JsonField.of(country))

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /**
             * The numbers to assign, one entry per area code, e.g.
             * [{"area_code": "212", "quantity": 2}, {"area_code": "415"}, {"quantity": 1}]: two
             * numbers in 212, one in 415 and one in any area code. quantity defaults to 1, and an
             * entry without area_code means any area code. Omit numbers for one number.
             *
             * Only with LOCAL or TEN_DLC, and not together with area_codes. Each area code is
             * validated against country the same way area_codes is and may appear once, and at most
             * one entry may leave area_code out. On a LOCAL market you already hold, this adds the
             * numbers to it. US TEN_DLC numbers are assigned when the campaign is approved, not at
             * request time. Not available when the profile inherits the organization's campaign.
             */
            fun numbers(numbers: List<SmsNumberRequest>?) = numbers(JsonField.ofNullable(numbers))

            /** Alias for calling [Builder.numbers] with `numbers.orElse(null)`. */
            fun numbers(numbers: Optional<List<SmsNumberRequest>>) = numbers(numbers.getOrNull())

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
             * The sender's identity where the caller chooses it. Required when number_type is
             * ALPHANUMERIC; optional for carrier-assigned types, which are procured afterwards.
             */
            fun senderValue(senderValue: String?) = senderValue(JsonField.ofNullable(senderValue))

            /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
            fun senderValue(senderValue: Optional<String>) = senderValue(senderValue.getOrNull())

            /**
             * Sets [Builder.senderValue] to an arbitrary JSON value.
             *
             * You should usually call [Builder.senderValue] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun senderValue(senderValue: JsonField<String>) = apply {
                this.senderValue = senderValue
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .numberType()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    sandbox,
                    checkRequired("numberType", numberType),
                    (areaCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    compliance,
                    country,
                    (numbers ?: JsonMissing.of()).map { it.toImmutable() },
                    senderValue,
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
            numberType().validate()
            areaCodes()
            compliance().ifPresent { it.validate() }
            country()
            numbers().ifPresent { it.forEach { it.validate() } }
            senderValue()
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
                (numberType.asKnown().getOrNull()?.validity() ?: 0) +
                (areaCodes.asKnown().getOrNull()?.size ?: 0) +
                (compliance.asKnown().getOrNull()?.validity() ?: 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (numbers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (senderValue.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                numberType == other.numberType &&
                areaCodes == other.areaCodes &&
                compliance == other.compliance &&
                country == other.country &&
                numbers == other.numbers &&
                senderValue == other.senderValue &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                numberType,
                areaCodes,
                compliance,
                country,
                numbers,
                senderValue,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, numberType=$numberType, areaCodes=$areaCodes, compliance=$compliance, country=$country, numbers=$numbers, senderValue=$senderValue, additionalProperties=$additionalProperties}"
    }

    /**
     * Sender type. Decides the provisioning flow and what compliance is asked for.
     *
     * [Required] so the published document says so. The validator has always demanded it, but
     * requiredness reached the schema by matching a rule to a property name — which works for
     * country, whose wire name is its camel-cased C# name, and silently does not for number_type. A
     * client generating a request from our OpenAPI therefore sent what the document called
     * sufficient and was answered 400.
     */
    class NumberType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            /**
             * A geographic number for the country. The ordinary choice: recognisable to recipients,
             * and available almost everywhere.
             */
            @JvmField val LOCAL = of("LOCAL")

            /**
             * A toll-free number. High throughput and no per-country registration, but US toll-free
             * traffic goes through its own verification.
             */
            @JvmField val TOLL_FREE = of("TOLL_FREE")

            /**
             * A short code — five or six digits, leased rather than provisioned. Highest
             * throughput, longest lead time, and the most expensive.
             */
            @JvmField val SHORT_CODE = of("SHORT_CODE")

            /**
             * A sender name rather than a number, up to 11 characters. Recipients cannot reply. Not
             * available in every country, and several require it to be pre-registered with
             * documents.
             */
            @JvmField val ALPHANUMERIC = of("ALPHANUMERIC")

            /**
             * A US 10-digit long code registered with The Campaign Registry. The only sender type
             * that registers with a compliance regime, so it is the only one whose market declares
             * `compliance.brand` and `compliance.campaign`.
             */
            @JvmField val TEN_DLC = of("TEN_DLC")

            /**
             * A mobile number. Where a country distinguishes it from a landline, some carriers
             * treat mobile traffic differently.
             */
            @JvmField val MOBILE = of("MOBILE")

            /**
             * The industry's spelling of `TEN_DLC`, accepted so an integrator can send the term it
             * knows. Resolves to the same market.
             */
            @JvmField val _10_DLC = of("10DLC")

            @JvmStatic fun of(value: String) = NumberType(JsonField.of(value))
        }

        /** An enum containing [NumberType]'s known values. */
        enum class Known {
            /**
             * A geographic number for the country. The ordinary choice: recognisable to recipients,
             * and available almost everywhere.
             */
            LOCAL,
            /**
             * A toll-free number. High throughput and no per-country registration, but US toll-free
             * traffic goes through its own verification.
             */
            TOLL_FREE,
            /**
             * A short code — five or six digits, leased rather than provisioned. Highest
             * throughput, longest lead time, and the most expensive.
             */
            SHORT_CODE,
            /**
             * A sender name rather than a number, up to 11 characters. Recipients cannot reply. Not
             * available in every country, and several require it to be pre-registered with
             * documents.
             */
            ALPHANUMERIC,
            /**
             * A US 10-digit long code registered with The Campaign Registry. The only sender type
             * that registers with a compliance regime, so it is the only one whose market declares
             * `compliance.brand` and `compliance.campaign`.
             */
            TEN_DLC,
            /**
             * A mobile number. Where a country distinguishes it from a landline, some carriers
             * treat mobile traffic differently.
             */
            MOBILE,
            /**
             * The industry's spelling of `TEN_DLC`, accepted so an integrator can send the term it
             * knows. Resolves to the same market.
             */
            _10_DLC,
        }

        /**
         * An enum containing [NumberType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [NumberType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /**
             * A geographic number for the country. The ordinary choice: recognisable to recipients,
             * and available almost everywhere.
             */
            LOCAL,
            /**
             * A toll-free number. High throughput and no per-country registration, but US toll-free
             * traffic goes through its own verification.
             */
            TOLL_FREE,
            /**
             * A short code — five or six digits, leased rather than provisioned. Highest
             * throughput, longest lead time, and the most expensive.
             */
            SHORT_CODE,
            /**
             * A sender name rather than a number, up to 11 characters. Recipients cannot reply. Not
             * available in every country, and several require it to be pre-registered with
             * documents.
             */
            ALPHANUMERIC,
            /**
             * A US 10-digit long code registered with The Campaign Registry. The only sender type
             * that registers with a compliance regime, so it is the only one whose market declares
             * `compliance.brand` and `compliance.campaign`.
             */
            TEN_DLC,
            /**
             * A mobile number. Where a country distinguishes it from a landline, some carriers
             * treat mobile traffic differently.
             */
            MOBILE,
            /**
             * The industry's spelling of `TEN_DLC`, accepted so an integrator can send the term it
             * knows. Resolves to the same market.
             */
            _10_DLC,
            /**
             * An enum member indicating that [NumberType] was instantiated with an unknown value.
             */
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
                LOCAL -> Value.LOCAL
                TOLL_FREE -> Value.TOLL_FREE
                SHORT_CODE -> Value.SHORT_CODE
                ALPHANUMERIC -> Value.ALPHANUMERIC
                TEN_DLC -> Value.TEN_DLC
                MOBILE -> Value.MOBILE
                _10_DLC -> Value._10_DLC
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
                LOCAL -> Known.LOCAL
                TOLL_FREE -> Known.TOLL_FREE
                SHORT_CODE -> Known.SHORT_CODE
                ALPHANUMERIC -> Known.ALPHANUMERIC
                TEN_DLC -> Known.TEN_DLC
                MOBILE -> Known.MOBILE
                _10_DLC -> Known._10_DLC
                else -> throw SentInvalidDataException("Unknown NumberType: $value")
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
        fun validate(): NumberType = apply {
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

            return other is NumberType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SmsCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "SmsCreateParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
