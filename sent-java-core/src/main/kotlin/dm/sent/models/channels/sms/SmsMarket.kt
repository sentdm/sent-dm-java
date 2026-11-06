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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * One SMS market the profile sends in — its sender, where that sender stands, and what the market
 * wants.
 *
 * A profile may send in several: it is a tenant, not a market. Each carries its own status, because
 * a profile can be live in one country and mid-registration in another — and each carries what it
 * still owes, rather than that being reported in a separate array a caller has to join on.
 */
class SmsMarket
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val compliance: JsonField<Compliance>,
    private val country: JsonField<String>,
    private val numberType: JsonField<String>,
    private val numbers: JsonField<List<SmsNumber>>,
    private val reason: JsonField<String>,
    private val reasonCode: JsonField<String>,
    private val senderValue: JsonField<String>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("compliance")
        @ExcludeMissing
        compliance: JsonField<Compliance> = JsonMissing.of(),
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
        @JsonProperty("sender_value")
        @ExcludeMissing
        senderValue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(
        compliance,
        country,
        numberType,
        numbers,
        reason,
        reasonCode,
        senderValue,
        status,
        mutableMapOf(),
    )

    /**
     * What a market has been given: the identity it registers under, its programme, and any
     * documents attached.
     *
     * What it does not carry is what the market asks for. That is the subject of GET
     * /v3/compliance/requirements, and it is the same answer for every caller — a description of
     * what a compliance regime wants, not a record of one customer's progress through it. It was
     * reported here as well for a while, which put the same array in six response shapes and left a
     * caller deciding which of two sources to believe.
     *
     * Present on a list read for markets that register (carrying brand and campaign), but with
     * documents absent — documents are not fetched for a list, because a catalog lookup and a
     * document read per market would multiply across a page. Absent documents is distinct from an
     * empty list: absent says they were not fetched; empty says the market has been given none. The
     * parent object is null only when the market registers with nobody and compliance was not
     * computed — nothing to show at all.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<Compliance> = compliance.getOptional("compliance")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun country(): Optional<String> = country.getOptional("country")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun numberType(): Optional<String> = numberType.getOptional("number_type")

    /**
     * Every number this market holds or is still owed, each with its area code and its own status
     * (ACTIVE once it can send, PROVISIONING while it is still to be assigned, INACTIVE once it
     * could send and no longer can). One entry for a market holding one number. US 10DLC numbers
     * are assigned when the campaign is approved, so they read as owed until then. Read-only.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun numbers(): Optional<List<SmsNumber>> = numbers.getOptional("numbers")

    /**
     * A sentence for reason_code: this market's own explanation, naming what is outstanding where
     * that is you. Omitted while ACTIVE.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Why the market is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
     * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than on
     * reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
     * generic reason for the status.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reasonCode(): Optional<String> = reasonCode.getOptional("reason_code")

    /**
     * The sender itself. Null until a carrier-assigned number is procured. For a market holding
     * several numbers, the first active one (the first assigned while none is active) — every
     * number is in numbers.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

    /**
     * Where this market's sender stands, in terms of who is holding it up — PROVISIONING,
     * ACTION_NEEDED, PENDING_REVIEW or ACTIVE. Read-only.
     *
     * Resolved rather than reported raw: a live sender reads ACTIVE whatever it still owes, a
     * market with outstanding requirements or an open resubmission request reads ACTION_NEEDED, and
     * a market that registers with a regime reads PENDING_REVIEW once its brand exists — filing to
     * The Campaign Registry is ours to do and need not have happened yet, so a dedicated brand
     * created through this API reads PENDING_REVIEW from the moment it is stored.
     *
     * Describes whether the market can send, not each number: a market holding several numbers
     * reads ACTIVE as soon as one of them is, whatever the others are doing. Each number's own
     * status is in numbers.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compliance")
    @ExcludeMissing
    fun _compliance(): JsonField<Compliance> = compliance

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
    @JsonProperty("number_type") @ExcludeMissing fun _numberType(): JsonField<String> = numberType

    /**
     * Returns the raw JSON value of [numbers].
     *
     * Unlike [numbers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("numbers") @ExcludeMissing fun _numbers(): JsonField<List<SmsNumber>> = numbers

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
    @JsonProperty("reason_code") @ExcludeMissing fun _reasonCode(): JsonField<String> = reasonCode

    /**
     * Returns the raw JSON value of [senderValue].
     *
     * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_value")
    @ExcludeMissing
    fun _senderValue(): JsonField<String> = senderValue

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

        /** Returns a mutable builder for constructing an instance of [SmsMarket]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SmsMarket]. */
    class Builder internal constructor() {

        private var compliance: JsonField<Compliance> = JsonMissing.of()
        private var country: JsonField<String> = JsonMissing.of()
        private var numberType: JsonField<String> = JsonMissing.of()
        private var numbers: JsonField<MutableList<SmsNumber>>? = null
        private var reason: JsonField<String> = JsonMissing.of()
        private var reasonCode: JsonField<String> = JsonMissing.of()
        private var senderValue: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(smsMarket: SmsMarket) = apply {
            compliance = smsMarket.compliance
            country = smsMarket.country
            numberType = smsMarket.numberType
            numbers = smsMarket.numbers.map { it.toMutableList() }
            reason = smsMarket.reason
            reasonCode = smsMarket.reasonCode
            senderValue = smsMarket.senderValue
            status = smsMarket.status
            additionalProperties = smsMarket.additionalProperties.toMutableMap()
        }

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
         */
        fun compliance(compliance: Compliance?) = compliance(JsonField.ofNullable(compliance))

        /** Alias for calling [Builder.compliance] with `compliance.orElse(null)`. */
        fun compliance(compliance: Optional<Compliance>) = compliance(compliance.getOrNull())

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [Compliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<Compliance>) = apply { this.compliance = compliance }

        fun country(country: String?) = country(JsonField.ofNullable(country))

        /** Alias for calling [Builder.country] with `country.orElse(null)`. */
        fun country(country: Optional<String>) = country(country.getOrNull())

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<String>) = apply { this.country = country }

        fun numberType(numberType: String?) = numberType(JsonField.ofNullable(numberType))

        /** Alias for calling [Builder.numberType] with `numberType.orElse(null)`. */
        fun numberType(numberType: Optional<String>) = numberType(numberType.getOrNull())

        /**
         * Sets [Builder.numberType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numberType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun numberType(numberType: JsonField<String>) = apply { this.numberType = numberType }

        /**
         * Every number this market holds or is still owed, each with its area code and its own
         * status (ACTIVE once it can send, PROVISIONING while it is still to be assigned, INACTIVE
         * once it could send and no longer can). One entry for a market holding one number. US
         * 10DLC numbers are assigned when the campaign is approved, so they read as owed until
         * then. Read-only.
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
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        /**
         * Why the market is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
         * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than
         * on reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
         * generic reason for the status.
         */
        fun reasonCode(reasonCode: String?) = reasonCode(JsonField.ofNullable(reasonCode))

        /** Alias for calling [Builder.reasonCode] with `reasonCode.orElse(null)`. */
        fun reasonCode(reasonCode: Optional<String>) = reasonCode(reasonCode.getOrNull())

        /**
         * Sets [Builder.reasonCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasonCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasonCode(reasonCode: JsonField<String>) = apply { this.reasonCode = reasonCode }

        /**
         * The sender itself. Null until a carrier-assigned number is procured. For a market holding
         * several numbers, the first active one (the first assigned while none is active) — every
         * number is in numbers.
         */
        fun senderValue(senderValue: String?) = senderValue(JsonField.ofNullable(senderValue))

        /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
        fun senderValue(senderValue: Optional<String>) = senderValue(senderValue.getOrNull())

        /**
         * Sets [Builder.senderValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun senderValue(senderValue: JsonField<String>) = apply { this.senderValue = senderValue }

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
        fun status(status: Status?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [SmsMarket].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SmsMarket =
            SmsMarket(
                compliance,
                country,
                numberType,
                (numbers ?: JsonMissing.of()).map { it.toImmutable() },
                reason,
                reasonCode,
                senderValue,
                status,
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
    fun validate(): SmsMarket = apply {
        if (validated) {
            return@apply
        }

        compliance().ifPresent { it.validate() }
        country()
        numberType()
        numbers().ifPresent { it.forEach { it.validate() } }
        reason()
        reasonCode()
        senderValue()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
            (if (senderValue.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * What a market has been given: the identity it registers under, its programme, and any
     * documents attached.
     *
     * What it does not carry is what the market asks for. That is the subject of GET
     * /v3/compliance/requirements, and it is the same answer for every caller — a description of
     * what a compliance regime wants, not a record of one customer's progress through it. It was
     * reported here as well for a while, which put the same array in six response shapes and left a
     * caller deciding which of two sources to believe.
     *
     * Present on a list read for markets that register (carrying brand and campaign), but with
     * documents absent — documents are not fetched for a list, because a catalog lookup and a
     * document read per market would multiply across a page. Absent documents is distinct from an
     * empty list: absent says they were not fetched; empty says the market has been given none. The
     * parent object is null only when the market registers with nobody and compliance was not
     * computed — nothing to show at all.
     */
    class Compliance
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val brand: JsonField<Brand>,
        private val campaign: JsonField<Campaign>,
        private val documents: JsonField<List<Document>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("brand") @ExcludeMissing brand: JsonField<Brand> = JsonMissing.of(),
            @JsonProperty("campaign")
            @ExcludeMissing
            campaign: JsonField<Campaign> = JsonMissing.of(),
            @JsonProperty("documents")
            @ExcludeMissing
            documents: JsonField<List<Document>> = JsonMissing.of(),
        ) : this(brand, campaign, documents, mutableMapOf())

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brand(): Optional<Brand> = brand.getOptional("brand")

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun campaign(): Optional<Campaign> = campaign.getOptional("campaign")

        /**
         * What has been supplied for this market.
         *
         * Files, not values — the declared halves above carry the values. A document cannot be a
         * JSON value, so it is sent as multipart on the channel call and reported here as a
         * reference.
         *
         * Absent on a list read, which fetches identity but does not compute compliance documents
         * per market. Absent and empty mean different things: absent says the documents were not
         * fetched; empty says the market has been given none.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun documents(): Optional<List<Document>> = documents.getOptional("documents")

        /**
         * Returns the raw JSON value of [brand].
         *
         * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<Brand> = brand

        /**
         * Returns the raw JSON value of [campaign].
         *
         * Unlike [campaign], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaign") @ExcludeMissing fun _campaign(): JsonField<Campaign> = campaign

        /**
         * Returns the raw JSON value of [documents].
         *
         * Unlike [documents], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("documents")
        @ExcludeMissing
        fun _documents(): JsonField<List<Document>> = documents

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

            /** Returns a mutable builder for constructing an instance of [Compliance]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Compliance]. */
        class Builder internal constructor() {

            private var brand: JsonField<Brand> = JsonMissing.of()
            private var campaign: JsonField<Campaign> = JsonMissing.of()
            private var documents: JsonField<MutableList<Document>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(compliance: Compliance) = apply {
                brand = compliance.brand
                campaign = compliance.campaign
                documents = compliance.documents.map { it.toMutableList() }
                additionalProperties = compliance.additionalProperties.toMutableMap()
            }

            /**
             * The identity this market registers under, with inherit saying whose it is.
             *
             * Reported here rather than on the profile because it belongs to the registration this
             * market files, and only one market files one. It was a top-level block for a while,
             * which put a per-registration value beside a list of markets and left a caller to work
             * out which market it belonged to.
             *
             * Absent for a market that registers with nobody — such a market asks for no identity,
             * so there is none to report. Absent and null mean different things: absent says this
             * market does not ask, null would say it asks and nothing was supplied.
             *
             * Untyped, like the request side, because its members are declared by the market's own
             * schema rather than by a C# class. A typed pair here would be a second definition of
             * what a market wants, free to drift from the one that validates.
             */
            fun brand(brand: Brand?) = brand(JsonField.ofNullable(brand))

            /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
            fun brand(brand: Optional<Brand>) = brand(brand.getOrNull())

            /**
             * Sets [Builder.brand] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun brand(brand: JsonField<Brand>) = apply { this.brand = brand }

            /**
             * The programme this market registers, with inherit saying whose it is.
             *
             * One, not a list. TcrCampaigns permits several and an account built on the admin side
             * may hold them, but this surface offers one — which is what lets the market's PATCH be
             * an upsert rather than a collection with an addressable create behind it. An account
             * holding several is reported as its first and refused on write, rather than
             * half-edited.
             *
             * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused
             * if the caller sent this object back — which it is meant to be able to do.
             */
            fun campaign(campaign: Campaign?) = campaign(JsonField.ofNullable(campaign))

            /** Alias for calling [Builder.campaign] with `campaign.orElse(null)`. */
            fun campaign(campaign: Optional<Campaign>) = campaign(campaign.getOrNull())

            /**
             * Sets [Builder.campaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaign] with a well-typed [Campaign] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaign(campaign: JsonField<Campaign>) = apply { this.campaign = campaign }

            /**
             * What has been supplied for this market.
             *
             * Files, not values — the declared halves above carry the values. A document cannot be
             * a JSON value, so it is sent as multipart on the channel call and reported here as a
             * reference.
             *
             * Absent on a list read, which fetches identity but does not compute compliance
             * documents per market. Absent and empty mean different things: absent says the
             * documents were not fetched; empty says the market has been given none.
             */
            fun documents(documents: List<Document>?) = documents(JsonField.ofNullable(documents))

            /** Alias for calling [Builder.documents] with `documents.orElse(null)`. */
            fun documents(documents: Optional<List<Document>>) = documents(documents.getOrNull())

            /**
             * Sets [Builder.documents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.documents] with a well-typed `List<Document>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun documents(documents: JsonField<List<Document>>) = apply {
                this.documents = documents.map { it.toMutableList() }
            }

            /**
             * Adds a single [Document] to [documents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDocument(document: Document) = apply {
                documents =
                    (documents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("documents", it).add(document)
                    }
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
             * Returns an immutable instance of [Compliance].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Compliance =
                Compliance(
                    brand,
                    campaign,
                    (documents ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Compliance = apply {
            if (validated) {
                return@apply
            }

            brand().ifPresent { it.validate() }
            campaign().ifPresent { it.validate() }
            documents().ifPresent { it.forEach { it.validate() } }
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
            (brand.asKnown().getOrNull()?.validity() ?: 0) +
                (campaign.asKnown().getOrNull()?.validity() ?: 0) +
                (documents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         */
        class Brand
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Brand]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Brand]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(brand: Brand) = apply {
                    additionalProperties = brand.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Brand].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Brand = Brand(additionalProperties.toImmutable())
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
            fun validate(): Brand = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Brand && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Brand{additionalProperties=$additionalProperties}"
        }

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         */
        class Campaign
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Campaign]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Campaign]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(campaign: Campaign) = apply {
                    additionalProperties = campaign.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Campaign].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Campaign = Campaign(additionalProperties.toImmutable())
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
            fun validate(): Campaign = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Campaign && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Campaign{additionalProperties=$additionalProperties}"
        }

        /** A document a market asked for and has been given. */
        class Document
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val documentId: JsonField<String>,
            private val fileName: JsonField<String>,
            private val key: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("document_id")
                @ExcludeMissing
                documentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("file_name")
                @ExcludeMissing
                fileName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            ) : this(documentId, fileName, key, mutableMapOf())

            /**
             * Identifier of the upload, for fetching it back through the documents endpoints.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun documentId(): Optional<String> = documentId.getOptional("document_id")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileName(): Optional<String> = fileName.getOptional("file_name")

            /**
             * The catalog's name for this document, matching the requirement it satisfies.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun key(): Optional<String> = key.getOptional("key")

            /**
             * Returns the raw JSON value of [documentId].
             *
             * Unlike [documentId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("document_id")
            @ExcludeMissing
            fun _documentId(): JsonField<String> = documentId

            /**
             * Returns the raw JSON value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * Returns the raw JSON value of [key].
             *
             * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

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

                /** Returns a mutable builder for constructing an instance of [Document]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Document]. */
            class Builder internal constructor() {

                private var documentId: JsonField<String> = JsonMissing.of()
                private var fileName: JsonField<String> = JsonMissing.of()
                private var key: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(document: Document) = apply {
                    documentId = document.documentId
                    fileName = document.fileName
                    key = document.key
                    additionalProperties = document.additionalProperties.toMutableMap()
                }

                /**
                 * Identifier of the upload, for fetching it back through the documents endpoints.
                 */
                fun documentId(documentId: String?) = documentId(JsonField.ofNullable(documentId))

                /** Alias for calling [Builder.documentId] with `documentId.orElse(null)`. */
                fun documentId(documentId: Optional<String>) = documentId(documentId.getOrNull())

                /**
                 * Sets [Builder.documentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.documentId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun documentId(documentId: JsonField<String>) = apply {
                    this.documentId = documentId
                }

                fun fileName(fileName: String?) = fileName(JsonField.ofNullable(fileName))

                /** Alias for calling [Builder.fileName] with `fileName.orElse(null)`. */
                fun fileName(fileName: Optional<String>) = fileName(fileName.getOrNull())

                /**
                 * Sets [Builder.fileName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                /** The catalog's name for this document, matching the requirement it satisfies. */
                fun key(key: String) = key(JsonField.of(key))

                /**
                 * Sets [Builder.key] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.key] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun key(key: JsonField<String>) = apply { this.key = key }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Document].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Document =
                    Document(documentId, fileName, key, additionalProperties.toMutableMap())
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
            fun validate(): Document = apply {
                if (validated) {
                    return@apply
                }

                documentId()
                fileName()
                key()
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
                (if (documentId.asKnown().isPresent) 1 else 0) +
                    (if (fileName.asKnown().isPresent) 1 else 0) +
                    (if (key.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Document &&
                    documentId == other.documentId &&
                    fileName == other.fileName &&
                    key == other.key &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(documentId, fileName, key, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Document{documentId=$documentId, fileName=$fileName, key=$key, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Compliance &&
                brand == other.brand &&
                campaign == other.campaign &&
                documents == other.documents &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(brand, campaign, documents, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Compliance{brand=$brand, campaign=$campaign, documents=$documents, additionalProperties=$additionalProperties}"
    }

    /**
     * Where this market's sender stands, in terms of who is holding it up — PROVISIONING,
     * ACTION_NEEDED, PENDING_REVIEW or ACTIVE. Read-only.
     *
     * Resolved rather than reported raw: a live sender reads ACTIVE whatever it still owes, a
     * market with outstanding requirements or an open resubmission request reads ACTION_NEEDED, and
     * a market that registers with a regime reads PENDING_REVIEW once its brand exists — filing to
     * The Campaign Registry is ours to do and need not have happened yet, so a dedicated brand
     * created through this API reads PENDING_REVIEW from the moment it is stored.
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
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PROVISIONING = of("PROVISIONING")

            @JvmField val ACTION_NEEDED = of("ACTION_NEEDED")

            @JvmField val PENDING_REVIEW = of("PENDING_REVIEW")

            @JvmField val ACTIVE = of("ACTIVE")

            @JvmField val INACTIVE = of("INACTIVE")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PROVISIONING,
            ACTION_NEEDED,
            PENDING_REVIEW,
            ACTIVE,
            INACTIVE,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PROVISIONING,
            ACTION_NEEDED,
            PENDING_REVIEW,
            ACTIVE,
            INACTIVE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentInvalidDataException if this class instance's value is a not a known member.
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

        return other is SmsMarket &&
            compliance == other.compliance &&
            country == other.country &&
            numberType == other.numberType &&
            numbers == other.numbers &&
            reason == other.reason &&
            reasonCode == other.reasonCode &&
            senderValue == other.senderValue &&
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
            senderValue,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SmsMarket{compliance=$compliance, country=$country, numberType=$numberType, numbers=$numbers, reason=$reason, reasonCode=$reasonCode, senderValue=$senderValue, status=$status, additionalProperties=$additionalProperties}"
}
