// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands.campaigns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Campaign data for create or update operation */
class CampaignData
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
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun description(): String = description.getRequired("description")

    /**
     * Campaign name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Campaign type (e.g., "KYC", "App")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * List of use cases with sample messages
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun useCases(): List<UseCase> = useCases.getRequired("useCases")

    /**
     * Comma-separated keywords that trigger help message (e.g., "HELP, INFO, SUPPORT")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun helpKeywords(): Optional<String> = helpKeywords.getOptional("helpKeywords")

    /**
     * Message sent when user requests help
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun helpMessage(): Optional<String> = helpMessage.getOptional("helpMessage")

    /**
     * Description of how messages flow in the campaign
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun messageFlow(): Optional<String> = messageFlow.getOptional("messageFlow")

    /**
     * Comma-separated keywords that trigger opt-in (e.g., "YES, START, SUBSCRIBE")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optinKeywords(): Optional<String> = optinKeywords.getOptional("optinKeywords")

    /**
     * Message sent when user opts in
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optinMessage(): Optional<String> = optinMessage.getOptional("optinMessage")

    /**
     * Comma-separated keywords that trigger opt-out (e.g., "STOP, UNSUBSCRIBE, END")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optoutKeywords(): Optional<String> = optoutKeywords.getOptional("optoutKeywords")

    /**
     * Message sent when user opts out
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun optoutMessage(): Optional<String> = optoutMessage.getOptional("optoutMessage")

    /**
     * URL to privacy policy
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun privacyPolicyLink(): Optional<String> = privacyPolicyLink.getOptional("privacyPolicyLink")

    /**
     * URL to terms and conditions
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun termsAndConditionsLink(): Optional<String> =
        termsAndConditionsLink.getOptional("termsAndConditionsLink")

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

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
    @JsonProperty("useCases") @ExcludeMissing fun _useCases(): JsonField<List<UseCase>> = useCases

    /**
     * Returns the raw JSON value of [helpKeywords].
     *
     * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("helpKeywords")
    @ExcludeMissing
    fun _helpKeywords(): JsonField<String> = helpKeywords

    /**
     * Returns the raw JSON value of [helpMessage].
     *
     * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("helpMessage") @ExcludeMissing fun _helpMessage(): JsonField<String> = helpMessage

    /**
     * Returns the raw JSON value of [messageFlow].
     *
     * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageFlow") @ExcludeMissing fun _messageFlow(): JsonField<String> = messageFlow

    /**
     * Returns the raw JSON value of [optinKeywords].
     *
     * Unlike [optinKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optinKeywords")
    @ExcludeMissing
    fun _optinKeywords(): JsonField<String> = optinKeywords

    /**
     * Returns the raw JSON value of [optinMessage].
     *
     * Unlike [optinMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optinMessage")
    @ExcludeMissing
    fun _optinMessage(): JsonField<String> = optinMessage

    /**
     * Returns the raw JSON value of [optoutKeywords].
     *
     * Unlike [optoutKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optoutKeywords")
    @ExcludeMissing
    fun _optoutKeywords(): JsonField<String> = optoutKeywords

    /**
     * Returns the raw JSON value of [optoutMessage].
     *
     * Unlike [optoutMessage], this method doesn't throw if the JSON field has an unexpected type.
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
         * Returns a mutable builder for constructing an instance of [CampaignData].
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

    /** A builder for [CampaignData]. */
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
        internal fun from(campaignData: CampaignData) = apply {
            description = campaignData.description
            name = campaignData.name
            type = campaignData.type
            useCases = campaignData.useCases.map { it.toMutableList() }
            helpKeywords = campaignData.helpKeywords
            helpMessage = campaignData.helpMessage
            messageFlow = campaignData.messageFlow
            optinKeywords = campaignData.optinKeywords
            optinMessage = campaignData.optinMessage
            optoutKeywords = campaignData.optoutKeywords
            optoutMessage = campaignData.optoutMessage
            privacyPolicyLink = campaignData.privacyPolicyLink
            termsAndConditionsLink = campaignData.termsAndConditionsLink
            additionalProperties = campaignData.additionalProperties.toMutableMap()
        }

        /** Campaign description */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Campaign name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Campaign type (e.g., "KYC", "App") */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
        fun helpKeywords(helpKeywords: String?) = helpKeywords(JsonField.ofNullable(helpKeywords))

        /** Alias for calling [Builder.helpKeywords] with `helpKeywords.orElse(null)`. */
        fun helpKeywords(helpKeywords: Optional<String>) = helpKeywords(helpKeywords.getOrNull())

        /**
         * Sets [Builder.helpKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.helpKeywords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.helpMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun helpMessage(helpMessage: JsonField<String>) = apply { this.helpMessage = helpMessage }

        /** Description of how messages flow in the campaign */
        fun messageFlow(messageFlow: String?) = messageFlow(JsonField.ofNullable(messageFlow))

        /** Alias for calling [Builder.messageFlow] with `messageFlow.orElse(null)`. */
        fun messageFlow(messageFlow: Optional<String>) = messageFlow(messageFlow.getOrNull())

        /**
         * Sets [Builder.messageFlow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageFlow] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageFlow(messageFlow: JsonField<String>) = apply { this.messageFlow = messageFlow }

        /** Comma-separated keywords that trigger opt-in (e.g., "YES, START, SUBSCRIBE") */
        fun optinKeywords(optinKeywords: String?) =
            optinKeywords(JsonField.ofNullable(optinKeywords))

        /** Alias for calling [Builder.optinKeywords] with `optinKeywords.orElse(null)`. */
        fun optinKeywords(optinKeywords: Optional<String>) =
            optinKeywords(optinKeywords.getOrNull())

        /**
         * Sets [Builder.optinKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optinKeywords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optinKeywords(optinKeywords: JsonField<String>) = apply {
            this.optinKeywords = optinKeywords
        }

        /** Message sent when user opts in */
        fun optinMessage(optinMessage: String?) = optinMessage(JsonField.ofNullable(optinMessage))

        /** Alias for calling [Builder.optinMessage] with `optinMessage.orElse(null)`. */
        fun optinMessage(optinMessage: Optional<String>) = optinMessage(optinMessage.getOrNull())

        /**
         * Sets [Builder.optinMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optinMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.optoutMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optoutMessage(optoutMessage: JsonField<String>) = apply {
            this.optoutMessage = optoutMessage
        }

        /** URL to privacy policy */
        fun privacyPolicyLink(privacyPolicyLink: String?) =
            privacyPolicyLink(JsonField.ofNullable(privacyPolicyLink))

        /** Alias for calling [Builder.privacyPolicyLink] with `privacyPolicyLink.orElse(null)`. */
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
         * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * Returns an immutable instance of [CampaignData].
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
        fun build(): CampaignData =
            CampaignData(
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

    fun validate(): CampaignData = apply {
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
        } catch (e: SentDmInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
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
         * US messaging use case category
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun messagingUseCaseUs(): MessagingUseCaseUs =
            messagingUseCaseUs.getRequired("messagingUseCaseUs")

        /**
         * Sample messages for this use case (1-5 messages, max 1024 characters each)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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
         * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected
         * type.
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

            /** US messaging use case category */
            fun messagingUseCaseUs(messagingUseCaseUs: MessagingUseCaseUs) =
                messagingUseCaseUs(JsonField.of(messagingUseCaseUs))

            /**
             * Sets [Builder.messagingUseCaseUs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messagingUseCaseUs] with a well-typed
             * [MessagingUseCaseUs] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
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
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
            } catch (e: SentDmInvalidDataException) {
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

        return other is CampaignData &&
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
        "CampaignData{description=$description, name=$name, type=$type, useCases=$useCases, helpKeywords=$helpKeywords, helpMessage=$helpMessage, messageFlow=$messageFlow, optinKeywords=$optinKeywords, optinMessage=$optinMessage, optoutKeywords=$optoutKeywords, optoutMessage=$optoutMessage, privacyPolicyLink=$privacyPolicyLink, termsAndConditionsLink=$termsAndConditionsLink, additionalProperties=$additionalProperties}"
}
