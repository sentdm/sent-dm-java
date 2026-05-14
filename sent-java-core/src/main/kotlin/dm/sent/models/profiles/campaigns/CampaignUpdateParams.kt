// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates an existing campaign under the brand of the specified profile. Cannot update campaigns
 * that have already been submitted to TCR.
 */
class CampaignUpdateParams
private constructor(
    private val profileId: String,
    private val campaignId: String?,
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun profileId(): String = profileId

    fun campaignId(): Optional<String> = Optional.ofNullable(campaignId)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * Campaign data for create or update operation
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun campaign(): Campaign = body.campaign()

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Returns the raw JSON value of [campaign].
     *
     * Unlike [campaign], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _campaign(): JsonField<Campaign> = body._campaign()

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
         * Returns a mutable builder for constructing an instance of [CampaignUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .profileId()
         * .campaign()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CampaignUpdateParams]. */
    class Builder internal constructor() {

        private var profileId: String? = null
        private var campaignId: String? = null
        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(campaignUpdateParams: CampaignUpdateParams) = apply {
            profileId = campaignUpdateParams.profileId
            campaignId = campaignUpdateParams.campaignId
            idempotencyKey = campaignUpdateParams.idempotencyKey
            xProfileId = campaignUpdateParams.xProfileId
            body = campaignUpdateParams.body.toBuilder()
            additionalHeaders = campaignUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = campaignUpdateParams.additionalQueryParams.toBuilder()
        }

        fun profileId(profileId: String) = apply { this.profileId = profileId }

        fun campaignId(campaignId: String?) = apply { this.campaignId = campaignId }

        /** Alias for calling [Builder.campaignId] with `campaignId.orElse(null)`. */
        fun campaignId(campaignId: Optional<String>) = campaignId(campaignId.getOrNull())

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
         * - [campaign]
         * - [sandbox]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Campaign data for create or update operation */
        fun campaign(campaign: Campaign) = apply { body.campaign(campaign) }

        /**
         * Sets [Builder.campaign] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaign] with a well-typed [Campaign] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun campaign(campaign: JsonField<Campaign>) = apply { body.campaign(campaign) }

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
         * Returns an immutable instance of [CampaignUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .profileId()
         * .campaign()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CampaignUpdateParams =
            CampaignUpdateParams(
                checkRequired("profileId", profileId),
                campaignId,
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
            0 -> profileId
            1 -> campaignId ?: ""
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
        private val campaign: JsonField<Campaign>,
        private val sandbox: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("campaign")
            @ExcludeMissing
            campaign: JsonField<Campaign> = JsonMissing.of(),
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
        ) : this(campaign, sandbox, mutableMapOf())

        /**
         * Campaign data for create or update operation
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun campaign(): Campaign = campaign.getRequired("campaign")

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Returns the raw JSON value of [campaign].
         *
         * Unlike [campaign], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaign") @ExcludeMissing fun _campaign(): JsonField<Campaign> = campaign

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .campaign()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var campaign: JsonField<Campaign>? = null
            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                campaign = body.campaign
                sandbox = body.sandbox
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Campaign data for create or update operation */
            fun campaign(campaign: Campaign) = campaign(JsonField.of(campaign))

            /**
             * Sets [Builder.campaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaign] with a well-typed [Campaign] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaign(campaign: JsonField<Campaign>) = apply { this.campaign = campaign }

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
             * .campaign()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("campaign", campaign),
                    sandbox,
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

            campaign().validate()
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
            (campaign.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sandbox.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                campaign == other.campaign &&
                sandbox == other.sandbox &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(campaign, sandbox, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{campaign=$campaign, sandbox=$sandbox, additionalProperties=$additionalProperties}"
    }

    /** Campaign data for create or update operation */
    class Campaign
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonField<String>,
        private val useCases: JsonField<List<UseCase>>,
        private val helpKeywords: JsonField<String>,
        private val helpMessage: JsonField<String>,
        private val messageFlow: JsonField<String>,
        private val optinKeywords: JsonField<String>,
        private val optinMessage: JsonField<String>,
        private val optoutKeywords: JsonField<String>,
        private val optoutMessage: JsonField<String>,
        private val privacyPolicyLink: JsonField<String>,
        private val termsAndConditionsLink: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("useCases")
            @ExcludeMissing
            useCases: JsonField<List<UseCase>> = JsonMissing.of(),
            @JsonProperty("helpKeywords")
            @ExcludeMissing
            helpKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("helpMessage")
            @ExcludeMissing
            helpMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("messageFlow")
            @ExcludeMissing
            messageFlow: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optinKeywords")
            @ExcludeMissing
            optinKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optinMessage")
            @ExcludeMissing
            optinMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optoutKeywords")
            @ExcludeMissing
            optoutKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("optoutMessage")
            @ExcludeMissing
            optoutMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("privacyPolicyLink")
            @ExcludeMissing
            privacyPolicyLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("termsAndConditionsLink")
            @ExcludeMissing
            termsAndConditionsLink: JsonField<String> = JsonMissing.of(),
        ) : this(
            description,
            name,
            type,
            useCases,
            helpKeywords,
            helpMessage,
            messageFlow,
            optinKeywords,
            optinMessage,
            optoutKeywords,
            optoutMessage,
            privacyPolicyLink,
            termsAndConditionsLink,
            mutableMapOf(),
        )

        /**
         * Campaign description
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun description(): String = description.getRequired("description")

        /**
         * Campaign name
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Campaign type (e.g., "KYC", "App")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): String = type.getRequired("type")

        /**
         * List of use cases with sample messages
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun useCases(): List<UseCase> = useCases.getRequired("useCases")

        /**
         * Comma-separated keywords that trigger help message (e.g., "HELP, INFO, SUPPORT")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpKeywords(): Optional<String> = helpKeywords.getOptional("helpKeywords")

        /**
         * Message sent when user requests help
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpMessage(): Optional<String> = helpMessage.getOptional("helpMessage")

        /**
         * Description of how messages flow in the campaign
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messageFlow(): Optional<String> = messageFlow.getOptional("messageFlow")

        /**
         * Comma-separated keywords that trigger opt-in (e.g., "YES, START, SUBSCRIBE")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optinKeywords(): Optional<String> = optinKeywords.getOptional("optinKeywords")

        /**
         * Message sent when user opts in
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optinMessage(): Optional<String> = optinMessage.getOptional("optinMessage")

        /**
         * Comma-separated keywords that trigger opt-out (e.g., "STOP, UNSUBSCRIBE, END")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optoutKeywords(): Optional<String> = optoutKeywords.getOptional("optoutKeywords")

        /**
         * Message sent when user opts out
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optoutMessage(): Optional<String> = optoutMessage.getOptional("optoutMessage")

        /**
         * URL to privacy policy
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun privacyPolicyLink(): Optional<String> =
            privacyPolicyLink.getOptional("privacyPolicyLink")

        /**
         * URL to terms and conditions
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun termsAndConditionsLink(): Optional<String> =
            termsAndConditionsLink.getOptional("termsAndConditionsLink")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [useCases].
         *
         * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("useCases")
        @ExcludeMissing
        fun _useCases(): JsonField<List<UseCase>> = useCases

        /**
         * Returns the raw JSON value of [helpKeywords].
         *
         * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("helpKeywords")
        @ExcludeMissing
        fun _helpKeywords(): JsonField<String> = helpKeywords

        /**
         * Returns the raw JSON value of [helpMessage].
         *
         * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("helpMessage")
        @ExcludeMissing
        fun _helpMessage(): JsonField<String> = helpMessage

        /**
         * Returns the raw JSON value of [messageFlow].
         *
         * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("messageFlow")
        @ExcludeMissing
        fun _messageFlow(): JsonField<String> = messageFlow

        /**
         * Returns the raw JSON value of [optinKeywords].
         *
         * Unlike [optinKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optinKeywords")
        @ExcludeMissing
        fun _optinKeywords(): JsonField<String> = optinKeywords

        /**
         * Returns the raw JSON value of [optinMessage].
         *
         * Unlike [optinMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optinMessage")
        @ExcludeMissing
        fun _optinMessage(): JsonField<String> = optinMessage

        /**
         * Returns the raw JSON value of [optoutKeywords].
         *
         * Unlike [optoutKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optoutKeywords")
        @ExcludeMissing
        fun _optoutKeywords(): JsonField<String> = optoutKeywords

        /**
         * Returns the raw JSON value of [optoutMessage].
         *
         * Unlike [optoutMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("optoutMessage")
        @ExcludeMissing
        fun _optoutMessage(): JsonField<String> = optoutMessage

        /**
         * Returns the raw JSON value of [privacyPolicyLink].
         *
         * Unlike [privacyPolicyLink], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("privacyPolicyLink")
        @ExcludeMissing
        fun _privacyPolicyLink(): JsonField<String> = privacyPolicyLink

        /**
         * Returns the raw JSON value of [termsAndConditionsLink].
         *
         * Unlike [termsAndConditionsLink], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("termsAndConditionsLink")
        @ExcludeMissing
        fun _termsAndConditionsLink(): JsonField<String> = termsAndConditionsLink

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
             * Returns a mutable builder for constructing an instance of [Campaign].
             *
             * The following fields are required:
             * ```java
             * .description()
             * .name()
             * .type()
             * .useCases()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Campaign]. */
        class Builder internal constructor() {

            private var description: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var type: JsonField<String>? = null
            private var useCases: JsonField<MutableList<UseCase>>? = null
            private var helpKeywords: JsonField<String> = JsonMissing.of()
            private var helpMessage: JsonField<String> = JsonMissing.of()
            private var messageFlow: JsonField<String> = JsonMissing.of()
            private var optinKeywords: JsonField<String> = JsonMissing.of()
            private var optinMessage: JsonField<String> = JsonMissing.of()
            private var optoutKeywords: JsonField<String> = JsonMissing.of()
            private var optoutMessage: JsonField<String> = JsonMissing.of()
            private var privacyPolicyLink: JsonField<String> = JsonMissing.of()
            private var termsAndConditionsLink: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(campaign: Campaign) = apply {
                description = campaign.description
                name = campaign.name
                type = campaign.type
                useCases = campaign.useCases.map { it.toMutableList() }
                helpKeywords = campaign.helpKeywords
                helpMessage = campaign.helpMessage
                messageFlow = campaign.messageFlow
                optinKeywords = campaign.optinKeywords
                optinMessage = campaign.optinMessage
                optoutKeywords = campaign.optoutKeywords
                optoutMessage = campaign.optoutMessage
                privacyPolicyLink = campaign.privacyPolicyLink
                termsAndConditionsLink = campaign.termsAndConditionsLink
                additionalProperties = campaign.additionalProperties.toMutableMap()
            }

            /** Campaign description */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Campaign name */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Campaign type (e.g., "KYC", "App") */
            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            /** List of use cases with sample messages */
            fun useCases(useCases: List<UseCase>) = useCases(JsonField.of(useCases))

            /**
             * Sets [Builder.useCases] to an arbitrary JSON value.
             *
             * You should usually call [Builder.useCases] with a well-typed `List<UseCase>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun useCases(useCases: JsonField<List<UseCase>>) = apply {
                this.useCases = useCases.map { it.toMutableList() }
            }

            /**
             * Adds a single [UseCase] to [useCases].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUseCase(useCase: UseCase) = apply {
                useCases =
                    (useCases ?: JsonField.of(mutableListOf())).also {
                        checkKnown("useCases", it).add(useCase)
                    }
            }

            /** Comma-separated keywords that trigger help message (e.g., "HELP, INFO, SUPPORT") */
            fun helpKeywords(helpKeywords: String?) =
                helpKeywords(JsonField.ofNullable(helpKeywords))

            /** Alias for calling [Builder.helpKeywords] with `helpKeywords.orElse(null)`. */
            fun helpKeywords(helpKeywords: Optional<String>) =
                helpKeywords(helpKeywords.getOrNull())

            /**
             * Sets [Builder.helpKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpKeywords(helpKeywords: JsonField<String>) = apply {
                this.helpKeywords = helpKeywords
            }

            /** Message sent when user requests help */
            fun helpMessage(helpMessage: String?) = helpMessage(JsonField.ofNullable(helpMessage))

            /** Alias for calling [Builder.helpMessage] with `helpMessage.orElse(null)`. */
            fun helpMessage(helpMessage: Optional<String>) = helpMessage(helpMessage.getOrNull())

            /**
             * Sets [Builder.helpMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpMessage(helpMessage: JsonField<String>) = apply {
                this.helpMessage = helpMessage
            }

            /** Description of how messages flow in the campaign */
            fun messageFlow(messageFlow: String?) = messageFlow(JsonField.ofNullable(messageFlow))

            /** Alias for calling [Builder.messageFlow] with `messageFlow.orElse(null)`. */
            fun messageFlow(messageFlow: Optional<String>) = messageFlow(messageFlow.getOrNull())

            /**
             * Sets [Builder.messageFlow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageFlow] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageFlow(messageFlow: JsonField<String>) = apply {
                this.messageFlow = messageFlow
            }

            /** Comma-separated keywords that trigger opt-in (e.g., "YES, START, SUBSCRIBE") */
            fun optinKeywords(optinKeywords: String?) =
                optinKeywords(JsonField.ofNullable(optinKeywords))

            /** Alias for calling [Builder.optinKeywords] with `optinKeywords.orElse(null)`. */
            fun optinKeywords(optinKeywords: Optional<String>) =
                optinKeywords(optinKeywords.getOrNull())

            /**
             * Sets [Builder.optinKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optinKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optinKeywords(optinKeywords: JsonField<String>) = apply {
                this.optinKeywords = optinKeywords
            }

            /** Message sent when user opts in */
            fun optinMessage(optinMessage: String?) =
                optinMessage(JsonField.ofNullable(optinMessage))

            /** Alias for calling [Builder.optinMessage] with `optinMessage.orElse(null)`. */
            fun optinMessage(optinMessage: Optional<String>) =
                optinMessage(optinMessage.getOrNull())

            /**
             * Sets [Builder.optinMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optinMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optinMessage(optinMessage: JsonField<String>) = apply {
                this.optinMessage = optinMessage
            }

            /** Comma-separated keywords that trigger opt-out (e.g., "STOP, UNSUBSCRIBE, END") */
            fun optoutKeywords(optoutKeywords: String?) =
                optoutKeywords(JsonField.ofNullable(optoutKeywords))

            /** Alias for calling [Builder.optoutKeywords] with `optoutKeywords.orElse(null)`. */
            fun optoutKeywords(optoutKeywords: Optional<String>) =
                optoutKeywords(optoutKeywords.getOrNull())

            /**
             * Sets [Builder.optoutKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optoutKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optoutKeywords(optoutKeywords: JsonField<String>) = apply {
                this.optoutKeywords = optoutKeywords
            }

            /** Message sent when user opts out */
            fun optoutMessage(optoutMessage: String?) =
                optoutMessage(JsonField.ofNullable(optoutMessage))

            /** Alias for calling [Builder.optoutMessage] with `optoutMessage.orElse(null)`. */
            fun optoutMessage(optoutMessage: Optional<String>) =
                optoutMessage(optoutMessage.getOrNull())

            /**
             * Sets [Builder.optoutMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optoutMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optoutMessage(optoutMessage: JsonField<String>) = apply {
                this.optoutMessage = optoutMessage
            }

            /** URL to privacy policy */
            fun privacyPolicyLink(privacyPolicyLink: String?) =
                privacyPolicyLink(JsonField.ofNullable(privacyPolicyLink))

            /**
             * Alias for calling [Builder.privacyPolicyLink] with `privacyPolicyLink.orElse(null)`.
             */
            fun privacyPolicyLink(privacyPolicyLink: Optional<String>) =
                privacyPolicyLink(privacyPolicyLink.getOrNull())

            /**
             * Sets [Builder.privacyPolicyLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.privacyPolicyLink] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun privacyPolicyLink(privacyPolicyLink: JsonField<String>) = apply {
                this.privacyPolicyLink = privacyPolicyLink
            }

            /** URL to terms and conditions */
            fun termsAndConditionsLink(termsAndConditionsLink: String?) =
                termsAndConditionsLink(JsonField.ofNullable(termsAndConditionsLink))

            /**
             * Alias for calling [Builder.termsAndConditionsLink] with
             * `termsAndConditionsLink.orElse(null)`.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: Optional<String>) =
                termsAndConditionsLink(termsAndConditionsLink.getOrNull())

            /**
             * Sets [Builder.termsAndConditionsLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: JsonField<String>) = apply {
                this.termsAndConditionsLink = termsAndConditionsLink
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
             * Returns an immutable instance of [Campaign].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .description()
             * .name()
             * .type()
             * .useCases()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Campaign =
                Campaign(
                    checkRequired("description", description),
                    checkRequired("name", name),
                    checkRequired("type", type),
                    checkRequired("useCases", useCases).map { it.toImmutable() },
                    helpKeywords,
                    helpMessage,
                    messageFlow,
                    optinKeywords,
                    optinMessage,
                    optoutKeywords,
                    optoutMessage,
                    privacyPolicyLink,
                    termsAndConditionsLink,
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
        fun validate(): Campaign = apply {
            if (validated) {
                return@apply
            }

            description()
            name()
            type()
            useCases().forEach { it.validate() }
            helpKeywords()
            helpMessage()
            messageFlow()
            optinKeywords()
            optinMessage()
            optoutKeywords()
            optoutMessage()
            privacyPolicyLink()
            termsAndConditionsLink()
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (useCases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (helpKeywords.asKnown().isPresent) 1 else 0) +
                (if (helpMessage.asKnown().isPresent) 1 else 0) +
                (if (messageFlow.asKnown().isPresent) 1 else 0) +
                (if (optinKeywords.asKnown().isPresent) 1 else 0) +
                (if (optinMessage.asKnown().isPresent) 1 else 0) +
                (if (optoutKeywords.asKnown().isPresent) 1 else 0) +
                (if (optoutMessage.asKnown().isPresent) 1 else 0) +
                (if (privacyPolicyLink.asKnown().isPresent) 1 else 0) +
                (if (termsAndConditionsLink.asKnown().isPresent) 1 else 0)

        /** Campaign use case with sample messages */
        class UseCase
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val messagingUseCaseUs: JsonField<MessagingUseCaseUs>,
            private val sampleMessages: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("messagingUseCaseUs")
                @ExcludeMissing
                messagingUseCaseUs: JsonField<MessagingUseCaseUs> = JsonMissing.of(),
                @JsonProperty("sampleMessages")
                @ExcludeMissing
                sampleMessages: JsonField<List<String>> = JsonMissing.of(),
            ) : this(messagingUseCaseUs, sampleMessages, mutableMapOf())

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun messagingUseCaseUs(): MessagingUseCaseUs =
                messagingUseCaseUs.getRequired("messagingUseCaseUs")

            /**
             * Sample messages for this use case (1-5 messages, max 1024 characters each)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun sampleMessages(): List<String> = sampleMessages.getRequired("sampleMessages")

            /**
             * Returns the raw JSON value of [messagingUseCaseUs].
             *
             * Unlike [messagingUseCaseUs], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("messagingUseCaseUs")
            @ExcludeMissing
            fun _messagingUseCaseUs(): JsonField<MessagingUseCaseUs> = messagingUseCaseUs

            /**
             * Returns the raw JSON value of [sampleMessages].
             *
             * Unlike [sampleMessages], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sampleMessages")
            @ExcludeMissing
            fun _sampleMessages(): JsonField<List<String>> = sampleMessages

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
                 * Returns a mutable builder for constructing an instance of [UseCase].
                 *
                 * The following fields are required:
                 * ```java
                 * .messagingUseCaseUs()
                 * .sampleMessages()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UseCase]. */
            class Builder internal constructor() {

                private var messagingUseCaseUs: JsonField<MessagingUseCaseUs>? = null
                private var sampleMessages: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(useCase: UseCase) = apply {
                    messagingUseCaseUs = useCase.messagingUseCaseUs
                    sampleMessages = useCase.sampleMessages.map { it.toMutableList() }
                    additionalProperties = useCase.additionalProperties.toMutableMap()
                }

                fun messagingUseCaseUs(messagingUseCaseUs: MessagingUseCaseUs) =
                    messagingUseCaseUs(JsonField.of(messagingUseCaseUs))

                /**
                 * Sets [Builder.messagingUseCaseUs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.messagingUseCaseUs] with a well-typed
                 * [MessagingUseCaseUs] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun messagingUseCaseUs(messagingUseCaseUs: JsonField<MessagingUseCaseUs>) = apply {
                    this.messagingUseCaseUs = messagingUseCaseUs
                }

                /** Sample messages for this use case (1-5 messages, max 1024 characters each) */
                fun sampleMessages(sampleMessages: List<String>) =
                    sampleMessages(JsonField.of(sampleMessages))

                /**
                 * Sets [Builder.sampleMessages] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sampleMessages] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun sampleMessages(sampleMessages: JsonField<List<String>>) = apply {
                    this.sampleMessages = sampleMessages.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [sampleMessages].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSampleMessage(sampleMessage: String) = apply {
                    sampleMessages =
                        (sampleMessages ?: JsonField.of(mutableListOf())).also {
                            checkKnown("sampleMessages", it).add(sampleMessage)
                        }
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
                 * Returns an immutable instance of [UseCase].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .messagingUseCaseUs()
                 * .sampleMessages()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UseCase =
                    UseCase(
                        checkRequired("messagingUseCaseUs", messagingUseCaseUs),
                        checkRequired("sampleMessages", sampleMessages).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): UseCase = apply {
                if (validated) {
                    return@apply
                }

                messagingUseCaseUs().validate()
                sampleMessages()
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
                (messagingUseCaseUs.asKnown().getOrNull()?.validity() ?: 0) +
                    (sampleMessages.asKnown().getOrNull()?.size ?: 0)

            class MessagingUseCaseUs
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val MARKETING = of("MARKETING")

                    @JvmField val ACCOUNT_NOTIFICATION = of("ACCOUNT_NOTIFICATION")

                    @JvmField val CUSTOMER_CARE = of("CUSTOMER_CARE")

                    @JvmField val FRAUD_ALERT = of("FRAUD_ALERT")

                    @JvmField val TWO_FA = of("TWO_FA")

                    @JvmField val DELIVERY_NOTIFICATION = of("DELIVERY_NOTIFICATION")

                    @JvmField val SECURITY_ALERT = of("SECURITY_ALERT")

                    @JvmField val M2_M = of("M2M")

                    @JvmField val MIXED = of("MIXED")

                    @JvmField val HIGHER_EDUCATION = of("HIGHER_EDUCATION")

                    @JvmField val POLLING_VOTING = of("POLLING_VOTING")

                    @JvmField val PUBLIC_SERVICE_ANNOUNCEMENT = of("PUBLIC_SERVICE_ANNOUNCEMENT")

                    @JvmField val LOW_VOLUME = of("LOW_VOLUME")

                    @JvmStatic fun of(value: String) = MessagingUseCaseUs(JsonField.of(value))
                }

                /** An enum containing [MessagingUseCaseUs]'s known values. */
                enum class Known {
                    MARKETING,
                    ACCOUNT_NOTIFICATION,
                    CUSTOMER_CARE,
                    FRAUD_ALERT,
                    TWO_FA,
                    DELIVERY_NOTIFICATION,
                    SECURITY_ALERT,
                    M2_M,
                    MIXED,
                    HIGHER_EDUCATION,
                    POLLING_VOTING,
                    PUBLIC_SERVICE_ANNOUNCEMENT,
                    LOW_VOLUME,
                }

                /**
                 * An enum containing [MessagingUseCaseUs]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [MessagingUseCaseUs] can contain an unknown value in a couple of
                 * cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    MARKETING,
                    ACCOUNT_NOTIFICATION,
                    CUSTOMER_CARE,
                    FRAUD_ALERT,
                    TWO_FA,
                    DELIVERY_NOTIFICATION,
                    SECURITY_ALERT,
                    M2_M,
                    MIXED,
                    HIGHER_EDUCATION,
                    POLLING_VOTING,
                    PUBLIC_SERVICE_ANNOUNCEMENT,
                    LOW_VOLUME,
                    /**
                     * An enum member indicating that [MessagingUseCaseUs] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        MARKETING -> Value.MARKETING
                        ACCOUNT_NOTIFICATION -> Value.ACCOUNT_NOTIFICATION
                        CUSTOMER_CARE -> Value.CUSTOMER_CARE
                        FRAUD_ALERT -> Value.FRAUD_ALERT
                        TWO_FA -> Value.TWO_FA
                        DELIVERY_NOTIFICATION -> Value.DELIVERY_NOTIFICATION
                        SECURITY_ALERT -> Value.SECURITY_ALERT
                        M2_M -> Value.M2_M
                        MIXED -> Value.MIXED
                        HIGHER_EDUCATION -> Value.HIGHER_EDUCATION
                        POLLING_VOTING -> Value.POLLING_VOTING
                        PUBLIC_SERVICE_ANNOUNCEMENT -> Value.PUBLIC_SERVICE_ANNOUNCEMENT
                        LOW_VOLUME -> Value.LOW_VOLUME
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SentInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        MARKETING -> Known.MARKETING
                        ACCOUNT_NOTIFICATION -> Known.ACCOUNT_NOTIFICATION
                        CUSTOMER_CARE -> Known.CUSTOMER_CARE
                        FRAUD_ALERT -> Known.FRAUD_ALERT
                        TWO_FA -> Known.TWO_FA
                        DELIVERY_NOTIFICATION -> Known.DELIVERY_NOTIFICATION
                        SECURITY_ALERT -> Known.SECURITY_ALERT
                        M2_M -> Known.M2_M
                        MIXED -> Known.MIXED
                        HIGHER_EDUCATION -> Known.HIGHER_EDUCATION
                        POLLING_VOTING -> Known.POLLING_VOTING
                        PUBLIC_SERVICE_ANNOUNCEMENT -> Known.PUBLIC_SERVICE_ANNOUNCEMENT
                        LOW_VOLUME -> Known.LOW_VOLUME
                        else -> throw SentInvalidDataException("Unknown MessagingUseCaseUs: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SentInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        SentInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): MessagingUseCaseUs = apply {
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

                    return other is MessagingUseCaseUs && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UseCase &&
                    messagingUseCaseUs == other.messagingUseCaseUs &&
                    sampleMessages == other.sampleMessages &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(messagingUseCaseUs, sampleMessages, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UseCase{messagingUseCaseUs=$messagingUseCaseUs, sampleMessages=$sampleMessages, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Campaign &&
                description == other.description &&
                name == other.name &&
                type == other.type &&
                useCases == other.useCases &&
                helpKeywords == other.helpKeywords &&
                helpMessage == other.helpMessage &&
                messageFlow == other.messageFlow &&
                optinKeywords == other.optinKeywords &&
                optinMessage == other.optinMessage &&
                optoutKeywords == other.optoutKeywords &&
                optoutMessage == other.optoutMessage &&
                privacyPolicyLink == other.privacyPolicyLink &&
                termsAndConditionsLink == other.termsAndConditionsLink &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                description,
                name,
                type,
                useCases,
                helpKeywords,
                helpMessage,
                messageFlow,
                optinKeywords,
                optinMessage,
                optoutKeywords,
                optoutMessage,
                privacyPolicyLink,
                termsAndConditionsLink,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Campaign{description=$description, name=$name, type=$type, useCases=$useCases, helpKeywords=$helpKeywords, helpMessage=$helpMessage, messageFlow=$messageFlow, optinKeywords=$optinKeywords, optinMessage=$optinMessage, optoutKeywords=$optoutKeywords, optoutMessage=$optoutMessage, privacyPolicyLink=$privacyPolicyLink, termsAndConditionsLink=$termsAndConditionsLink, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CampaignUpdateParams &&
            profileId == other.profileId &&
            campaignId == other.campaignId &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            profileId,
            campaignId,
            idempotencyKey,
            xProfileId,
            body,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "CampaignUpdateParams{profileId=$profileId, campaignId=$campaignId, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
