// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Complete definition of a message template including header, body, footer, and buttons */
class TemplateDefinition
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val body: JsonField<Body>,
    private val authenticationConfig: JsonField<AuthenticationConfig>,
    private val buttons: JsonField<List<Button>>,
    private val definitionVersion: JsonField<String>,
    private val footer: JsonField<Footer>,
    private val header: JsonField<Header>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("body") @ExcludeMissing body: JsonField<Body> = JsonMissing.of(),
        @JsonProperty("authenticationConfig")
        @ExcludeMissing
        authenticationConfig: JsonField<AuthenticationConfig> = JsonMissing.of(),
        @JsonProperty("buttons")
        @ExcludeMissing
        buttons: JsonField<List<Button>> = JsonMissing.of(),
        @JsonProperty("definitionVersion")
        @ExcludeMissing
        definitionVersion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("footer") @ExcludeMissing footer: JsonField<Footer> = JsonMissing.of(),
        @JsonProperty("header") @ExcludeMissing header: JsonField<Header> = JsonMissing.of(),
    ) : this(body, authenticationConfig, buttons, definitionVersion, footer, header, mutableMapOf())

    /**
     * Required template body with content for different channels (multi-channel, SMS-specific, or
     * WhatsApp-specific)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun body(): Body = body.getRequired("body")

    /**
     * Configuration specific to AUTHENTICATION category templates (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun authenticationConfig(): Optional<AuthenticationConfig> =
        authenticationConfig.getOptional("authenticationConfig")

    /**
     * Optional list of interactive buttons (e.g., quick replies, URLs, phone numbers)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun buttons(): Optional<List<Button>> = buttons.getOptional("buttons")

    /**
     * The version of the template definition format
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun definitionVersion(): Optional<String> = definitionVersion.getOptional("definitionVersion")

    /**
     * Optional template footer with optional variables
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun footer(): Optional<Footer> = footer.getOptional("footer")

    /**
     * Optional template header with optional variables
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun header(): Optional<Header> = header.getOptional("header")

    /**
     * Returns the raw JSON value of [body].
     *
     * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<Body> = body

    /**
     * Returns the raw JSON value of [authenticationConfig].
     *
     * Unlike [authenticationConfig], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("authenticationConfig")
    @ExcludeMissing
    fun _authenticationConfig(): JsonField<AuthenticationConfig> = authenticationConfig

    /**
     * Returns the raw JSON value of [buttons].
     *
     * Unlike [buttons], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("buttons") @ExcludeMissing fun _buttons(): JsonField<List<Button>> = buttons

    /**
     * Returns the raw JSON value of [definitionVersion].
     *
     * Unlike [definitionVersion], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("definitionVersion")
    @ExcludeMissing
    fun _definitionVersion(): JsonField<String> = definitionVersion

    /**
     * Returns the raw JSON value of [footer].
     *
     * Unlike [footer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("footer") @ExcludeMissing fun _footer(): JsonField<Footer> = footer

    /**
     * Returns the raw JSON value of [header].
     *
     * Unlike [header], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("header") @ExcludeMissing fun _header(): JsonField<Header> = header

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
         * Returns a mutable builder for constructing an instance of [TemplateDefinition].
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateDefinition]. */
    class Builder internal constructor() {

        private var body: JsonField<Body>? = null
        private var authenticationConfig: JsonField<AuthenticationConfig> = JsonMissing.of()
        private var buttons: JsonField<MutableList<Button>>? = null
        private var definitionVersion: JsonField<String> = JsonMissing.of()
        private var footer: JsonField<Footer> = JsonMissing.of()
        private var header: JsonField<Header> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateDefinition: TemplateDefinition) = apply {
            body = templateDefinition.body
            authenticationConfig = templateDefinition.authenticationConfig
            buttons = templateDefinition.buttons.map { it.toMutableList() }
            definitionVersion = templateDefinition.definitionVersion
            footer = templateDefinition.footer
            header = templateDefinition.header
            additionalProperties = templateDefinition.additionalProperties.toMutableMap()
        }

        /**
         * Required template body with content for different channels (multi-channel, SMS-specific,
         * or WhatsApp-specific)
         */
        fun body(body: Body) = body(JsonField.of(body))

        /**
         * Sets [Builder.body] to an arbitrary JSON value.
         *
         * You should usually call [Builder.body] with a well-typed [Body] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun body(body: JsonField<Body>) = apply { this.body = body }

        /** Configuration specific to AUTHENTICATION category templates (optional) */
        fun authenticationConfig(authenticationConfig: AuthenticationConfig?) =
            authenticationConfig(JsonField.ofNullable(authenticationConfig))

        /**
         * Alias for calling [Builder.authenticationConfig] with
         * `authenticationConfig.orElse(null)`.
         */
        fun authenticationConfig(authenticationConfig: Optional<AuthenticationConfig>) =
            authenticationConfig(authenticationConfig.getOrNull())

        /**
         * Sets [Builder.authenticationConfig] to an arbitrary JSON value.
         *
         * You should usually call [Builder.authenticationConfig] with a well-typed
         * [AuthenticationConfig] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun authenticationConfig(authenticationConfig: JsonField<AuthenticationConfig>) = apply {
            this.authenticationConfig = authenticationConfig
        }

        /** Optional list of interactive buttons (e.g., quick replies, URLs, phone numbers) */
        fun buttons(buttons: List<Button>?) = buttons(JsonField.ofNullable(buttons))

        /** Alias for calling [Builder.buttons] with `buttons.orElse(null)`. */
        fun buttons(buttons: Optional<List<Button>>) = buttons(buttons.getOrNull())

        /**
         * Sets [Builder.buttons] to an arbitrary JSON value.
         *
         * You should usually call [Builder.buttons] with a well-typed `List<Button>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun buttons(buttons: JsonField<List<Button>>) = apply {
            this.buttons = buttons.map { it.toMutableList() }
        }

        /**
         * Adds a single [Button] to [buttons].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addButton(button: Button) = apply {
            buttons =
                (buttons ?: JsonField.of(mutableListOf())).also {
                    checkKnown("buttons", it).add(button)
                }
        }

        /** The version of the template definition format */
        fun definitionVersion(definitionVersion: String?) =
            definitionVersion(JsonField.ofNullable(definitionVersion))

        /** Alias for calling [Builder.definitionVersion] with `definitionVersion.orElse(null)`. */
        fun definitionVersion(definitionVersion: Optional<String>) =
            definitionVersion(definitionVersion.getOrNull())

        /**
         * Sets [Builder.definitionVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.definitionVersion] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun definitionVersion(definitionVersion: JsonField<String>) = apply {
            this.definitionVersion = definitionVersion
        }

        /** Optional template footer with optional variables */
        fun footer(footer: Footer?) = footer(JsonField.ofNullable(footer))

        /** Alias for calling [Builder.footer] with `footer.orElse(null)`. */
        fun footer(footer: Optional<Footer>) = footer(footer.getOrNull())

        /**
         * Sets [Builder.footer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.footer] with a well-typed [Footer] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun footer(footer: JsonField<Footer>) = apply { this.footer = footer }

        /** Optional template header with optional variables */
        fun header(header: Header?) = header(JsonField.ofNullable(header))

        /** Alias for calling [Builder.header] with `header.orElse(null)`. */
        fun header(header: Optional<Header>) = header(header.getOrNull())

        /**
         * Sets [Builder.header] to an arbitrary JSON value.
         *
         * You should usually call [Builder.header] with a well-typed [Header] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun header(header: JsonField<Header>) = apply { this.header = header }

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
         * Returns an immutable instance of [TemplateDefinition].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TemplateDefinition =
            TemplateDefinition(
                checkRequired("body", body),
                authenticationConfig,
                (buttons ?: JsonMissing.of()).map { it.toImmutable() },
                definitionVersion,
                footer,
                header,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TemplateDefinition = apply {
        if (validated) {
            return@apply
        }

        body().validate()
        authenticationConfig().ifPresent { it.validate() }
        buttons().ifPresent { it.forEach { it.validate() } }
        definitionVersion()
        footer().ifPresent { it.validate() }
        header().ifPresent { it.validate() }
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
        (body.asKnown().getOrNull()?.validity() ?: 0) +
            (authenticationConfig.asKnown().getOrNull()?.validity() ?: 0) +
            (buttons.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (definitionVersion.asKnown().isPresent) 1 else 0) +
            (footer.asKnown().getOrNull()?.validity() ?: 0) +
            (header.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Required template body with content for different channels (multi-channel, SMS-specific, or
     * WhatsApp-specific)
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val multiChannel: JsonField<TemplateBodyContent>,
        private val sms: JsonField<TemplateBodyContent>,
        private val whatsapp: JsonField<TemplateBodyContent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("multiChannel")
            @ExcludeMissing
            multiChannel: JsonField<TemplateBodyContent> = JsonMissing.of(),
            @JsonProperty("sms")
            @ExcludeMissing
            sms: JsonField<TemplateBodyContent> = JsonMissing.of(),
            @JsonProperty("whatsapp")
            @ExcludeMissing
            whatsapp: JsonField<TemplateBodyContent> = JsonMissing.of(),
        ) : this(multiChannel, sms, whatsapp, mutableMapOf())

        /**
         * Content that will be used for all channels (SMS and WhatsApp) unless channel-specific
         * content is provided
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun multiChannel(): Optional<TemplateBodyContent> = multiChannel.getOptional("multiChannel")

        /**
         * SMS-specific content that overrides multi-channel content for SMS messages
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sms(): Optional<TemplateBodyContent> = sms.getOptional("sms")

        /**
         * WhatsApp-specific content that overrides multi-channel content for WhatsApp messages
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun whatsapp(): Optional<TemplateBodyContent> = whatsapp.getOptional("whatsapp")

        /**
         * Returns the raw JSON value of [multiChannel].
         *
         * Unlike [multiChannel], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("multiChannel")
        @ExcludeMissing
        fun _multiChannel(): JsonField<TemplateBodyContent> = multiChannel

        /**
         * Returns the raw JSON value of [sms].
         *
         * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<TemplateBodyContent> = sms

        /**
         * Returns the raw JSON value of [whatsapp].
         *
         * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("whatsapp")
        @ExcludeMissing
        fun _whatsapp(): JsonField<TemplateBodyContent> = whatsapp

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

            private var multiChannel: JsonField<TemplateBodyContent> = JsonMissing.of()
            private var sms: JsonField<TemplateBodyContent> = JsonMissing.of()
            private var whatsapp: JsonField<TemplateBodyContent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                multiChannel = body.multiChannel
                sms = body.sms
                whatsapp = body.whatsapp
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Content that will be used for all channels (SMS and WhatsApp) unless channel-specific
             * content is provided
             */
            fun multiChannel(multiChannel: TemplateBodyContent?) =
                multiChannel(JsonField.ofNullable(multiChannel))

            /** Alias for calling [Builder.multiChannel] with `multiChannel.orElse(null)`. */
            fun multiChannel(multiChannel: Optional<TemplateBodyContent>) =
                multiChannel(multiChannel.getOrNull())

            /**
             * Sets [Builder.multiChannel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.multiChannel] with a well-typed
             * [TemplateBodyContent] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun multiChannel(multiChannel: JsonField<TemplateBodyContent>) = apply {
                this.multiChannel = multiChannel
            }

            /** SMS-specific content that overrides multi-channel content for SMS messages */
            fun sms(sms: TemplateBodyContent?) = sms(JsonField.ofNullable(sms))

            /** Alias for calling [Builder.sms] with `sms.orElse(null)`. */
            fun sms(sms: Optional<TemplateBodyContent>) = sms(sms.getOrNull())

            /**
             * Sets [Builder.sms] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sms] with a well-typed [TemplateBodyContent] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sms(sms: JsonField<TemplateBodyContent>) = apply { this.sms = sms }

            /**
             * WhatsApp-specific content that overrides multi-channel content for WhatsApp messages
             */
            fun whatsapp(whatsapp: TemplateBodyContent?) = whatsapp(JsonField.ofNullable(whatsapp))

            /** Alias for calling [Builder.whatsapp] with `whatsapp.orElse(null)`. */
            fun whatsapp(whatsapp: Optional<TemplateBodyContent>) = whatsapp(whatsapp.getOrNull())

            /**
             * Sets [Builder.whatsapp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.whatsapp] with a well-typed [TemplateBodyContent]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun whatsapp(whatsapp: JsonField<TemplateBodyContent>) = apply {
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(multiChannel, sms, whatsapp, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            multiChannel().ifPresent { it.validate() }
            sms().ifPresent { it.validate() }
            whatsapp().ifPresent { it.validate() }
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
            (multiChannel.asKnown().getOrNull()?.validity() ?: 0) +
                (sms.asKnown().getOrNull()?.validity() ?: 0) +
                (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                multiChannel == other.multiChannel &&
                sms == other.sms &&
                whatsapp == other.whatsapp &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(multiChannel, sms, whatsapp, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{multiChannel=$multiChannel, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
    }

    /** Configuration specific to AUTHENTICATION category templates (optional) */
    class AuthenticationConfig
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val addSecurityRecommendation: JsonField<Boolean>,
        private val codeExpirationMinutes: JsonField<Int>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("addSecurityRecommendation")
            @ExcludeMissing
            addSecurityRecommendation: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("codeExpirationMinutes")
            @ExcludeMissing
            codeExpirationMinutes: JsonField<Int> = JsonMissing.of(),
        ) : this(addSecurityRecommendation, codeExpirationMinutes, mutableMapOf())

        /**
         * Whether to add the security recommendation text: "For your security, do not share this
         * code."
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun addSecurityRecommendation(): Optional<Boolean> =
            addSecurityRecommendation.getOptional("addSecurityRecommendation")

        /**
         * Code expiration time in minutes (1-90). If set, adds footer: "This code expires in X
         * minutes."
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun codeExpirationMinutes(): Optional<Int> =
            codeExpirationMinutes.getOptional("codeExpirationMinutes")

        /**
         * Returns the raw JSON value of [addSecurityRecommendation].
         *
         * Unlike [addSecurityRecommendation], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("addSecurityRecommendation")
        @ExcludeMissing
        fun _addSecurityRecommendation(): JsonField<Boolean> = addSecurityRecommendation

        /**
         * Returns the raw JSON value of [codeExpirationMinutes].
         *
         * Unlike [codeExpirationMinutes], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("codeExpirationMinutes")
        @ExcludeMissing
        fun _codeExpirationMinutes(): JsonField<Int> = codeExpirationMinutes

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

            /** Returns a mutable builder for constructing an instance of [AuthenticationConfig]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AuthenticationConfig]. */
        class Builder internal constructor() {

            private var addSecurityRecommendation: JsonField<Boolean> = JsonMissing.of()
            private var codeExpirationMinutes: JsonField<Int> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(authenticationConfig: AuthenticationConfig) = apply {
                addSecurityRecommendation = authenticationConfig.addSecurityRecommendation
                codeExpirationMinutes = authenticationConfig.codeExpirationMinutes
                additionalProperties = authenticationConfig.additionalProperties.toMutableMap()
            }

            /**
             * Whether to add the security recommendation text: "For your security, do not share
             * this code."
             */
            fun addSecurityRecommendation(addSecurityRecommendation: Boolean) =
                addSecurityRecommendation(JsonField.of(addSecurityRecommendation))

            /**
             * Sets [Builder.addSecurityRecommendation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.addSecurityRecommendation] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun addSecurityRecommendation(addSecurityRecommendation: JsonField<Boolean>) = apply {
                this.addSecurityRecommendation = addSecurityRecommendation
            }

            /**
             * Code expiration time in minutes (1-90). If set, adds footer: "This code expires in X
             * minutes."
             */
            fun codeExpirationMinutes(codeExpirationMinutes: Int?) =
                codeExpirationMinutes(JsonField.ofNullable(codeExpirationMinutes))

            /**
             * Alias for [Builder.codeExpirationMinutes].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun codeExpirationMinutes(codeExpirationMinutes: Int) =
                codeExpirationMinutes(codeExpirationMinutes as Int?)

            /**
             * Alias for calling [Builder.codeExpirationMinutes] with
             * `codeExpirationMinutes.orElse(null)`.
             */
            fun codeExpirationMinutes(codeExpirationMinutes: Optional<Int>) =
                codeExpirationMinutes(codeExpirationMinutes.getOrNull())

            /**
             * Sets [Builder.codeExpirationMinutes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.codeExpirationMinutes] with a well-typed [Int] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun codeExpirationMinutes(codeExpirationMinutes: JsonField<Int>) = apply {
                this.codeExpirationMinutes = codeExpirationMinutes
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
             * Returns an immutable instance of [AuthenticationConfig].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AuthenticationConfig =
                AuthenticationConfig(
                    addSecurityRecommendation,
                    codeExpirationMinutes,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AuthenticationConfig = apply {
            if (validated) {
                return@apply
            }

            addSecurityRecommendation()
            codeExpirationMinutes()
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
            (if (addSecurityRecommendation.asKnown().isPresent) 1 else 0) +
                (if (codeExpirationMinutes.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AuthenticationConfig &&
                addSecurityRecommendation == other.addSecurityRecommendation &&
                codeExpirationMinutes == other.codeExpirationMinutes &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(addSecurityRecommendation, codeExpirationMinutes, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AuthenticationConfig{addSecurityRecommendation=$addSecurityRecommendation, codeExpirationMinutes=$codeExpirationMinutes, additionalProperties=$additionalProperties}"
    }

    /** Interactive button in a message template */
    class Button
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<Int>,
        private val props: JsonField<Props>,
        private val type: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("props") @ExcludeMissing props: JsonField<Props> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        ) : this(id, props, type, mutableMapOf())

        /**
         * The unique identifier of the button (1-based index)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<Int> = id.getOptional("id")

        /**
         * Properties specific to the button type
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun props(): Optional<Props> = props.getOptional("props")

        /**
         * The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

        /**
         * Returns the raw JSON value of [props].
         *
         * Unlike [props], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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

            /** Returns a mutable builder for constructing an instance of [Button]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Button]. */
        class Builder internal constructor() {

            private var id: JsonField<Int> = JsonMissing.of()
            private var props: JsonField<Props> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(button: Button) = apply {
                id = button.id
                props = button.props
                type = button.type
                additionalProperties = button.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the button (1-based index) */
            fun id(id: Int) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [Int] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<Int>) = apply { this.id = id }

            /** Properties specific to the button type */
            fun props(props: Props) = props(JsonField.of(props))

            /**
             * Sets [Builder.props] to an arbitrary JSON value.
             *
             * You should usually call [Builder.props] with a well-typed [Props] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun props(props: JsonField<Props>) = apply { this.props = props }

            /** The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE) */
            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

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
             * Returns an immutable instance of [Button].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Button = Button(id, props, type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Button = apply {
            if (validated) {
                return@apply
            }

            id()
            props().ifPresent { it.validate() }
            type()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (props.asKnown().getOrNull()?.validity() ?: 0) +
                (if (type.asKnown().isPresent) 1 else 0)

        /** Properties specific to the button type */
        class Props
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val activeFor: JsonField<Int>,
            private val autofillText: JsonField<String>,
            private val countryCode: JsonField<String>,
            private val offerCode: JsonField<String>,
            private val otpType: JsonField<String>,
            private val packageName: JsonField<String>,
            private val phoneNumber: JsonField<String>,
            private val quickReplyType: JsonField<String>,
            private val signatureHash: JsonField<String>,
            private val text: JsonField<String>,
            private val url: JsonField<String>,
            private val urlType: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("activeFor")
                @ExcludeMissing
                activeFor: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("autofillText")
                @ExcludeMissing
                autofillText: JsonField<String> = JsonMissing.of(),
                @JsonProperty("countryCode")
                @ExcludeMissing
                countryCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("offerCode")
                @ExcludeMissing
                offerCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("otpType")
                @ExcludeMissing
                otpType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("packageName")
                @ExcludeMissing
                packageName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phoneNumber")
                @ExcludeMissing
                phoneNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("quickReplyType")
                @ExcludeMissing
                quickReplyType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("signatureHash")
                @ExcludeMissing
                signatureHash: JsonField<String> = JsonMissing.of(),
                @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("urlType")
                @ExcludeMissing
                urlType: JsonField<String> = JsonMissing.of(),
            ) : this(
                activeFor,
                autofillText,
                countryCode,
                offerCode,
                otpType,
                packageName,
                phoneNumber,
                quickReplyType,
                signatureHash,
                text,
                url,
                urlType,
                mutableMapOf(),
            )

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun activeFor(): Optional<Int> = activeFor.getOptional("activeFor")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun autofillText(): Optional<String> = autofillText.getOptional("autofillText")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun offerCode(): Optional<String> = offerCode.getOptional("offerCode")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun otpType(): Optional<String> = otpType.getOptional("otpType")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun packageName(): Optional<String> = packageName.getOptional("packageName")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phoneNumber")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun quickReplyType(): Optional<String> = quickReplyType.getOptional("quickReplyType")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun signatureHash(): Optional<String> = signatureHash.getOptional("signatureHash")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun text(): Optional<String> = text.getOptional("text")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun urlType(): Optional<String> = urlType.getOptional("urlType")

            /**
             * Returns the raw JSON value of [activeFor].
             *
             * Unlike [activeFor], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("activeFor") @ExcludeMissing fun _activeFor(): JsonField<Int> = activeFor

            /**
             * Returns the raw JSON value of [autofillText].
             *
             * Unlike [autofillText], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("autofillText")
            @ExcludeMissing
            fun _autofillText(): JsonField<String> = autofillText

            /**
             * Returns the raw JSON value of [countryCode].
             *
             * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("countryCode")
            @ExcludeMissing
            fun _countryCode(): JsonField<String> = countryCode

            /**
             * Returns the raw JSON value of [offerCode].
             *
             * Unlike [offerCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("offerCode")
            @ExcludeMissing
            fun _offerCode(): JsonField<String> = offerCode

            /**
             * Returns the raw JSON value of [otpType].
             *
             * Unlike [otpType], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("otpType") @ExcludeMissing fun _otpType(): JsonField<String> = otpType

            /**
             * Returns the raw JSON value of [packageName].
             *
             * Unlike [packageName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("packageName")
            @ExcludeMissing
            fun _packageName(): JsonField<String> = packageName

            /**
             * Returns the raw JSON value of [phoneNumber].
             *
             * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("phoneNumber")
            @ExcludeMissing
            fun _phoneNumber(): JsonField<String> = phoneNumber

            /**
             * Returns the raw JSON value of [quickReplyType].
             *
             * Unlike [quickReplyType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("quickReplyType")
            @ExcludeMissing
            fun _quickReplyType(): JsonField<String> = quickReplyType

            /**
             * Returns the raw JSON value of [signatureHash].
             *
             * Unlike [signatureHash], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("signatureHash")
            @ExcludeMissing
            fun _signatureHash(): JsonField<String> = signatureHash

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            /**
             * Returns the raw JSON value of [urlType].
             *
             * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

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

                /** Returns a mutable builder for constructing an instance of [Props]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Props]. */
            class Builder internal constructor() {

                private var activeFor: JsonField<Int> = JsonMissing.of()
                private var autofillText: JsonField<String> = JsonMissing.of()
                private var countryCode: JsonField<String> = JsonMissing.of()
                private var offerCode: JsonField<String> = JsonMissing.of()
                private var otpType: JsonField<String> = JsonMissing.of()
                private var packageName: JsonField<String> = JsonMissing.of()
                private var phoneNumber: JsonField<String> = JsonMissing.of()
                private var quickReplyType: JsonField<String> = JsonMissing.of()
                private var signatureHash: JsonField<String> = JsonMissing.of()
                private var text: JsonField<String> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var urlType: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(props: Props) = apply {
                    activeFor = props.activeFor
                    autofillText = props.autofillText
                    countryCode = props.countryCode
                    offerCode = props.offerCode
                    otpType = props.otpType
                    packageName = props.packageName
                    phoneNumber = props.phoneNumber
                    quickReplyType = props.quickReplyType
                    signatureHash = props.signatureHash
                    text = props.text
                    url = props.url
                    urlType = props.urlType
                    additionalProperties = props.additionalProperties.toMutableMap()
                }

                fun activeFor(activeFor: Int?) = activeFor(JsonField.ofNullable(activeFor))

                /**
                 * Alias for [Builder.activeFor].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun activeFor(activeFor: Int) = activeFor(activeFor as Int?)

                /** Alias for calling [Builder.activeFor] with `activeFor.orElse(null)`. */
                fun activeFor(activeFor: Optional<Int>) = activeFor(activeFor.getOrNull())

                /**
                 * Sets [Builder.activeFor] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.activeFor] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun activeFor(activeFor: JsonField<Int>) = apply { this.activeFor = activeFor }

                fun autofillText(autofillText: String?) =
                    autofillText(JsonField.ofNullable(autofillText))

                /** Alias for calling [Builder.autofillText] with `autofillText.orElse(null)`. */
                fun autofillText(autofillText: Optional<String>) =
                    autofillText(autofillText.getOrNull())

                /**
                 * Sets [Builder.autofillText] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.autofillText] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun autofillText(autofillText: JsonField<String>) = apply {
                    this.autofillText = autofillText
                }

                fun countryCode(countryCode: String?) =
                    countryCode(JsonField.ofNullable(countryCode))

                /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
                fun countryCode(countryCode: Optional<String>) =
                    countryCode(countryCode.getOrNull())

                /**
                 * Sets [Builder.countryCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.countryCode] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun countryCode(countryCode: JsonField<String>) = apply {
                    this.countryCode = countryCode
                }

                fun offerCode(offerCode: String?) = offerCode(JsonField.ofNullable(offerCode))

                /** Alias for calling [Builder.offerCode] with `offerCode.orElse(null)`. */
                fun offerCode(offerCode: Optional<String>) = offerCode(offerCode.getOrNull())

                /**
                 * Sets [Builder.offerCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.offerCode] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun offerCode(offerCode: JsonField<String>) = apply { this.offerCode = offerCode }

                fun otpType(otpType: String?) = otpType(JsonField.ofNullable(otpType))

                /** Alias for calling [Builder.otpType] with `otpType.orElse(null)`. */
                fun otpType(otpType: Optional<String>) = otpType(otpType.getOrNull())

                /**
                 * Sets [Builder.otpType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.otpType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun otpType(otpType: JsonField<String>) = apply { this.otpType = otpType }

                fun packageName(packageName: String?) =
                    packageName(JsonField.ofNullable(packageName))

                /** Alias for calling [Builder.packageName] with `packageName.orElse(null)`. */
                fun packageName(packageName: Optional<String>) =
                    packageName(packageName.getOrNull())

                /**
                 * Sets [Builder.packageName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.packageName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun packageName(packageName: JsonField<String>) = apply {
                    this.packageName = packageName
                }

                fun phoneNumber(phoneNumber: String?) =
                    phoneNumber(JsonField.ofNullable(phoneNumber))

                /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
                fun phoneNumber(phoneNumber: Optional<String>) =
                    phoneNumber(phoneNumber.getOrNull())

                /**
                 * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.phoneNumber] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                    this.phoneNumber = phoneNumber
                }

                fun quickReplyType(quickReplyType: String?) =
                    quickReplyType(JsonField.ofNullable(quickReplyType))

                /**
                 * Alias for calling [Builder.quickReplyType] with `quickReplyType.orElse(null)`.
                 */
                fun quickReplyType(quickReplyType: Optional<String>) =
                    quickReplyType(quickReplyType.getOrNull())

                /**
                 * Sets [Builder.quickReplyType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.quickReplyType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun quickReplyType(quickReplyType: JsonField<String>) = apply {
                    this.quickReplyType = quickReplyType
                }

                fun signatureHash(signatureHash: String?) =
                    signatureHash(JsonField.ofNullable(signatureHash))

                /** Alias for calling [Builder.signatureHash] with `signatureHash.orElse(null)`. */
                fun signatureHash(signatureHash: Optional<String>) =
                    signatureHash(signatureHash.getOrNull())

                /**
                 * Sets [Builder.signatureHash] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.signatureHash] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun signatureHash(signatureHash: JsonField<String>) = apply {
                    this.signatureHash = signatureHash
                }

                fun text(text: String?) = text(JsonField.ofNullable(text))

                /** Alias for calling [Builder.text] with `text.orElse(null)`. */
                fun text(text: Optional<String>) = text(text.getOrNull())

                /**
                 * Sets [Builder.text] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.text] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun text(text: JsonField<String>) = apply { this.text = text }

                fun url(url: String?) = url(JsonField.ofNullable(url))

                /** Alias for calling [Builder.url] with `url.orElse(null)`. */
                fun url(url: Optional<String>) = url(url.getOrNull())

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun urlType(urlType: String?) = urlType(JsonField.ofNullable(urlType))

                /** Alias for calling [Builder.urlType] with `urlType.orElse(null)`. */
                fun urlType(urlType: Optional<String>) = urlType(urlType.getOrNull())

                /**
                 * Sets [Builder.urlType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.urlType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

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
                 * Returns an immutable instance of [Props].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Props =
                    Props(
                        activeFor,
                        autofillText,
                        countryCode,
                        offerCode,
                        otpType,
                        packageName,
                        phoneNumber,
                        quickReplyType,
                        signatureHash,
                        text,
                        url,
                        urlType,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Props = apply {
                if (validated) {
                    return@apply
                }

                activeFor()
                autofillText()
                countryCode()
                offerCode()
                otpType()
                packageName()
                phoneNumber()
                quickReplyType()
                signatureHash()
                text()
                url()
                urlType()
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
                (if (activeFor.asKnown().isPresent) 1 else 0) +
                    (if (autofillText.asKnown().isPresent) 1 else 0) +
                    (if (countryCode.asKnown().isPresent) 1 else 0) +
                    (if (offerCode.asKnown().isPresent) 1 else 0) +
                    (if (otpType.asKnown().isPresent) 1 else 0) +
                    (if (packageName.asKnown().isPresent) 1 else 0) +
                    (if (phoneNumber.asKnown().isPresent) 1 else 0) +
                    (if (quickReplyType.asKnown().isPresent) 1 else 0) +
                    (if (signatureHash.asKnown().isPresent) 1 else 0) +
                    (if (text.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (if (urlType.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Props &&
                    activeFor == other.activeFor &&
                    autofillText == other.autofillText &&
                    countryCode == other.countryCode &&
                    offerCode == other.offerCode &&
                    otpType == other.otpType &&
                    packageName == other.packageName &&
                    phoneNumber == other.phoneNumber &&
                    quickReplyType == other.quickReplyType &&
                    signatureHash == other.signatureHash &&
                    text == other.text &&
                    url == other.url &&
                    urlType == other.urlType &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    activeFor,
                    autofillText,
                    countryCode,
                    offerCode,
                    otpType,
                    packageName,
                    phoneNumber,
                    quickReplyType,
                    signatureHash,
                    text,
                    url,
                    urlType,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Props{activeFor=$activeFor, autofillText=$autofillText, countryCode=$countryCode, offerCode=$offerCode, otpType=$otpType, packageName=$packageName, phoneNumber=$phoneNumber, quickReplyType=$quickReplyType, signatureHash=$signatureHash, text=$text, url=$url, urlType=$urlType, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Button &&
                id == other.id &&
                props == other.props &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, props, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Button{id=$id, props=$props, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Optional template footer with optional variables */
    class Footer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val template: JsonField<String>,
        private val type: JsonField<String>,
        private val variables: JsonField<List<TemplateVariable>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("template")
            @ExcludeMissing
            template: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variables")
            @ExcludeMissing
            variables: JsonField<List<TemplateVariable>> = JsonMissing.of(),
        ) : this(template, type, variables, mutableMapOf())

        /**
         * The footer template text with optional variable placeholders
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun template(): Optional<String> = template.getOptional("template")

        /**
         * The type of footer (typically "text")
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * List of variables used in the footer template
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun variables(): Optional<List<TemplateVariable>> = variables.getOptional("variables")

        /**
         * Returns the raw JSON value of [template].
         *
         * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<String> = template

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [variables].
         *
         * Unlike [variables], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("variables")
        @ExcludeMissing
        fun _variables(): JsonField<List<TemplateVariable>> = variables

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

            /** Returns a mutable builder for constructing an instance of [Footer]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Footer]. */
        class Builder internal constructor() {

            private var template: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var variables: JsonField<MutableList<TemplateVariable>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(footer: Footer) = apply {
                template = footer.template
                type = footer.type
                variables = footer.variables.map { it.toMutableList() }
                additionalProperties = footer.additionalProperties.toMutableMap()
            }

            /** The footer template text with optional variable placeholders */
            fun template(template: String) = template(JsonField.of(template))

            /**
             * Sets [Builder.template] to an arbitrary JSON value.
             *
             * You should usually call [Builder.template] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun template(template: JsonField<String>) = apply { this.template = template }

            /** The type of footer (typically "text") */
            fun type(type: String?) = type(JsonField.ofNullable(type))

            /** Alias for calling [Builder.type] with `type.orElse(null)`. */
            fun type(type: Optional<String>) = type(type.getOrNull())

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            /** List of variables used in the footer template */
            fun variables(variables: List<TemplateVariable>?) =
                variables(JsonField.ofNullable(variables))

            /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
            fun variables(variables: Optional<List<TemplateVariable>>) =
                variables(variables.getOrNull())

            /**
             * Sets [Builder.variables] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variables] with a well-typed
             * `List<TemplateVariable>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun variables(variables: JsonField<List<TemplateVariable>>) = apply {
                this.variables = variables.map { it.toMutableList() }
            }

            /**
             * Adds a single [TemplateVariable] to [variables].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addVariable(variable: TemplateVariable) = apply {
                variables =
                    (variables ?: JsonField.of(mutableListOf())).also {
                        checkKnown("variables", it).add(variable)
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
             * Returns an immutable instance of [Footer].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Footer =
                Footer(
                    template,
                    type,
                    (variables ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Footer = apply {
            if (validated) {
                return@apply
            }

            template()
            type()
            variables().ifPresent { it.forEach { it.validate() } }
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
            (if (template.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Footer &&
                template == other.template &&
                type == other.type &&
                variables == other.variables &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(template, type, variables, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Footer{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
    }

    /** Optional template header with optional variables */
    class Header
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val template: JsonField<String>,
        private val type: JsonField<String>,
        private val variables: JsonField<List<TemplateVariable>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("template")
            @ExcludeMissing
            template: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variables")
            @ExcludeMissing
            variables: JsonField<List<TemplateVariable>> = JsonMissing.of(),
        ) : this(template, type, variables, mutableMapOf())

        /**
         * The header template text with optional variable placeholders (e.g., "Welcome to
         * {{0:variable}}")
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun template(): Optional<String> = template.getOptional("template")

        /**
         * The type of header (e.g., "text", "image", "video", "document")
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * List of variables used in the header template
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun variables(): Optional<List<TemplateVariable>> = variables.getOptional("variables")

        /**
         * Returns the raw JSON value of [template].
         *
         * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<String> = template

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [variables].
         *
         * Unlike [variables], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("variables")
        @ExcludeMissing
        fun _variables(): JsonField<List<TemplateVariable>> = variables

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

            /** Returns a mutable builder for constructing an instance of [Header]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Header]. */
        class Builder internal constructor() {

            private var template: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var variables: JsonField<MutableList<TemplateVariable>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(header: Header) = apply {
                template = header.template
                type = header.type
                variables = header.variables.map { it.toMutableList() }
                additionalProperties = header.additionalProperties.toMutableMap()
            }

            /**
             * The header template text with optional variable placeholders (e.g., "Welcome to
             * {{0:variable}}")
             */
            fun template(template: String) = template(JsonField.of(template))

            /**
             * Sets [Builder.template] to an arbitrary JSON value.
             *
             * You should usually call [Builder.template] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun template(template: JsonField<String>) = apply { this.template = template }

            /** The type of header (e.g., "text", "image", "video", "document") */
            fun type(type: String?) = type(JsonField.ofNullable(type))

            /** Alias for calling [Builder.type] with `type.orElse(null)`. */
            fun type(type: Optional<String>) = type(type.getOrNull())

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            /** List of variables used in the header template */
            fun variables(variables: List<TemplateVariable>?) =
                variables(JsonField.ofNullable(variables))

            /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
            fun variables(variables: Optional<List<TemplateVariable>>) =
                variables(variables.getOrNull())

            /**
             * Sets [Builder.variables] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variables] with a well-typed
             * `List<TemplateVariable>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun variables(variables: JsonField<List<TemplateVariable>>) = apply {
                this.variables = variables.map { it.toMutableList() }
            }

            /**
             * Adds a single [TemplateVariable] to [variables].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addVariable(variable: TemplateVariable) = apply {
                variables =
                    (variables ?: JsonField.of(mutableListOf())).also {
                        checkKnown("variables", it).add(variable)
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
             * Returns an immutable instance of [Header].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Header =
                Header(
                    template,
                    type,
                    (variables ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Header = apply {
            if (validated) {
                return@apply
            }

            template()
            type()
            variables().ifPresent { it.forEach { it.validate() } }
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
            (if (template.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Header &&
                template == other.template &&
                type == other.type &&
                variables == other.variables &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(template, type, variables, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Header{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateDefinition &&
            body == other.body &&
            authenticationConfig == other.authenticationConfig &&
            buttons == other.buttons &&
            definitionVersion == other.definitionVersion &&
            footer == other.footer &&
            header == other.header &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            body,
            authenticationConfig,
            buttons,
            definitionVersion,
            footer,
            header,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateDefinition{body=$body, authenticationConfig=$authenticationConfig, buttons=$buttons, definitionVersion=$definitionVersion, footer=$footer, header=$header, additionalProperties=$additionalProperties}"
}
