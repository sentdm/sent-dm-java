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
    private val body: JsonField<SentDmServicesCommonContractsPocOsTemplateBody>,
    private val authenticationConfig:
        JsonField<SentDmServicesCommonContractsPocOsAuthenticationConfig>,
    private val buttons: JsonField<List<SentDmServicesCommonContractsPocOsTemplateButton>>,
    private val definitionVersion: JsonField<String>,
    private val footer: JsonField<SentDmServicesCommonContractsPocOsTemplateFooter>,
    private val header: JsonField<SentDmServicesCommonContractsPocOsTemplateHeader>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("body")
        @ExcludeMissing
        body: JsonField<SentDmServicesCommonContractsPocOsTemplateBody> = JsonMissing.of(),
        @JsonProperty("authenticationConfig")
        @ExcludeMissing
        authenticationConfig: JsonField<SentDmServicesCommonContractsPocOsAuthenticationConfig> =
            JsonMissing.of(),
        @JsonProperty("buttons")
        @ExcludeMissing
        buttons: JsonField<List<SentDmServicesCommonContractsPocOsTemplateButton>> =
            JsonMissing.of(),
        @JsonProperty("definitionVersion")
        @ExcludeMissing
        definitionVersion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("footer")
        @ExcludeMissing
        footer: JsonField<SentDmServicesCommonContractsPocOsTemplateFooter> = JsonMissing.of(),
        @JsonProperty("header")
        @ExcludeMissing
        header: JsonField<SentDmServicesCommonContractsPocOsTemplateHeader> = JsonMissing.of(),
    ) : this(body, authenticationConfig, buttons, definitionVersion, footer, header, mutableMapOf())

    /**
     * Required template body with content for different channels (multi-channel, SMS-specific, or
     * WhatsApp-specific)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun body(): SentDmServicesCommonContractsPocOsTemplateBody = body.getRequired("body")

    /**
     * Configuration specific to AUTHENTICATION category templates (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun authenticationConfig(): Optional<SentDmServicesCommonContractsPocOsAuthenticationConfig> =
        authenticationConfig.getOptional("authenticationConfig")

    /**
     * Optional list of interactive buttons (e.g., quick replies, URLs, phone numbers)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun buttons(): Optional<List<SentDmServicesCommonContractsPocOsTemplateButton>> =
        buttons.getOptional("buttons")

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
    fun footer(): Optional<SentDmServicesCommonContractsPocOsTemplateFooter> =
        footer.getOptional("footer")

    /**
     * Optional template header with optional variables
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun header(): Optional<SentDmServicesCommonContractsPocOsTemplateHeader> =
        header.getOptional("header")

    /**
     * Returns the raw JSON value of [body].
     *
     * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("body")
    @ExcludeMissing
    fun _body(): JsonField<SentDmServicesCommonContractsPocOsTemplateBody> = body

    /**
     * Returns the raw JSON value of [authenticationConfig].
     *
     * Unlike [authenticationConfig], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("authenticationConfig")
    @ExcludeMissing
    fun _authenticationConfig(): JsonField<SentDmServicesCommonContractsPocOsAuthenticationConfig> =
        authenticationConfig

    /**
     * Returns the raw JSON value of [buttons].
     *
     * Unlike [buttons], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("buttons")
    @ExcludeMissing
    fun _buttons(): JsonField<List<SentDmServicesCommonContractsPocOsTemplateButton>> = buttons

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
    @JsonProperty("footer")
    @ExcludeMissing
    fun _footer(): JsonField<SentDmServicesCommonContractsPocOsTemplateFooter> = footer

    /**
     * Returns the raw JSON value of [header].
     *
     * Unlike [header], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("header")
    @ExcludeMissing
    fun _header(): JsonField<SentDmServicesCommonContractsPocOsTemplateHeader> = header

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

        private var body: JsonField<SentDmServicesCommonContractsPocOsTemplateBody>? = null
        private var authenticationConfig:
            JsonField<SentDmServicesCommonContractsPocOsAuthenticationConfig> =
            JsonMissing.of()
        private var buttons:
            JsonField<MutableList<SentDmServicesCommonContractsPocOsTemplateButton>>? =
            null
        private var definitionVersion: JsonField<String> = JsonMissing.of()
        private var footer: JsonField<SentDmServicesCommonContractsPocOsTemplateFooter> =
            JsonMissing.of()
        private var header: JsonField<SentDmServicesCommonContractsPocOsTemplateHeader> =
            JsonMissing.of()
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
        fun body(body: SentDmServicesCommonContractsPocOsTemplateBody) = body(JsonField.of(body))

        /**
         * Sets [Builder.body] to an arbitrary JSON value.
         *
         * You should usually call [Builder.body] with a well-typed
         * [SentDmServicesCommonContractsPocOsTemplateBody] value instead. This method is primarily
         * for setting the field to an undocumented or not yet supported value.
         */
        fun body(body: JsonField<SentDmServicesCommonContractsPocOsTemplateBody>) = apply {
            this.body = body
        }

        /** Configuration specific to AUTHENTICATION category templates (optional) */
        fun authenticationConfig(
            authenticationConfig: SentDmServicesCommonContractsPocOsAuthenticationConfig?
        ) = authenticationConfig(JsonField.ofNullable(authenticationConfig))

        /**
         * Alias for calling [Builder.authenticationConfig] with
         * `authenticationConfig.orElse(null)`.
         */
        fun authenticationConfig(
            authenticationConfig: Optional<SentDmServicesCommonContractsPocOsAuthenticationConfig>
        ) = authenticationConfig(authenticationConfig.getOrNull())

        /**
         * Sets [Builder.authenticationConfig] to an arbitrary JSON value.
         *
         * You should usually call [Builder.authenticationConfig] with a well-typed
         * [SentDmServicesCommonContractsPocOsAuthenticationConfig] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun authenticationConfig(
            authenticationConfig: JsonField<SentDmServicesCommonContractsPocOsAuthenticationConfig>
        ) = apply { this.authenticationConfig = authenticationConfig }

        /** Optional list of interactive buttons (e.g., quick replies, URLs, phone numbers) */
        fun buttons(buttons: List<SentDmServicesCommonContractsPocOsTemplateButton>?) =
            buttons(JsonField.ofNullable(buttons))

        /** Alias for calling [Builder.buttons] with `buttons.orElse(null)`. */
        fun buttons(buttons: Optional<List<SentDmServicesCommonContractsPocOsTemplateButton>>) =
            buttons(buttons.getOrNull())

        /**
         * Sets [Builder.buttons] to an arbitrary JSON value.
         *
         * You should usually call [Builder.buttons] with a well-typed
         * `List<SentDmServicesCommonContractsPocOsTemplateButton>` value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun buttons(buttons: JsonField<List<SentDmServicesCommonContractsPocOsTemplateButton>>) =
            apply {
                this.buttons = buttons.map { it.toMutableList() }
            }

        /**
         * Adds a single [SentDmServicesCommonContractsPocOsTemplateButton] to [buttons].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addButton(button: SentDmServicesCommonContractsPocOsTemplateButton) = apply {
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
        fun footer(footer: SentDmServicesCommonContractsPocOsTemplateFooter?) =
            footer(JsonField.ofNullable(footer))

        /** Alias for calling [Builder.footer] with `footer.orElse(null)`. */
        fun footer(footer: Optional<SentDmServicesCommonContractsPocOsTemplateFooter>) =
            footer(footer.getOrNull())

        /**
         * Sets [Builder.footer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.footer] with a well-typed
         * [SentDmServicesCommonContractsPocOsTemplateFooter] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun footer(footer: JsonField<SentDmServicesCommonContractsPocOsTemplateFooter>) = apply {
            this.footer = footer
        }

        /** Optional template header with optional variables */
        fun header(header: SentDmServicesCommonContractsPocOsTemplateHeader?) =
            header(JsonField.ofNullable(header))

        /** Alias for calling [Builder.header] with `header.orElse(null)`. */
        fun header(header: Optional<SentDmServicesCommonContractsPocOsTemplateHeader>) =
            header(header.getOrNull())

        /**
         * Sets [Builder.header] to an arbitrary JSON value.
         *
         * You should usually call [Builder.header] with a well-typed
         * [SentDmServicesCommonContractsPocOsTemplateHeader] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun header(header: JsonField<SentDmServicesCommonContractsPocOsTemplateHeader>) = apply {
            this.header = header
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
