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
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Header section of a message template */
class TemplateHeader
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val template: JsonField<String>,
    private val exampleUrl: JsonField<String>,
    private val location: JsonField<Location>,
    private val staticResource: JsonField<Boolean>,
    private val type: JsonField<String>,
    private val variables: JsonField<List<TemplateVariable>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("template") @ExcludeMissing template: JsonField<String> = JsonMissing.of(),
        @JsonProperty("example_url")
        @ExcludeMissing
        exampleUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("location") @ExcludeMissing location: JsonField<Location> = JsonMissing.of(),
        @JsonProperty("static_resource")
        @ExcludeMissing
        staticResource: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("variables")
        @ExcludeMissing
        variables: JsonField<List<TemplateVariable>> = JsonMissing.of(),
    ) : this(template, exampleUrl, location, staticResource, type, variables, mutableMapOf())

    /**
     * The header template text with optional variable placeholders (e.g., "Welcome to
     * {{0:variable}}")
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun template(): String = template.getRequired("template")

    /**
     * Request-only. The s.dm URL of the asset Meta's reviewers see — https://s.dm/s/{ID}, eight
     * uppercase characters, uploaded to s.dm out of band. NormalizeRichHeader folds it into the
     * synthesized media variable's Props.Sample and clears it, so it never persists and a stored
     * definition is indistinguishable from an imported one.
     *
     * Stricter than the send path on purpose: TemplateUtils.ValidateMediaVariableValues accepts any
     * absolute https URL for the per-send asset, because that one is the customer's and may live
     * behind a signed CDN link. This one is the review sample, has to outlive every resubmission,
     * and so must be ours. Do not "fix" one to match the other.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun exampleUrl(): Optional<String> = exampleUrl.getOptional("example_url")

    /**
     * The map pin a location header drops. Meta wants none of this at creation — the component is
     * just {"type":"header","format":"location"} — so these values exist for Sent: a preview, and
     * the default a StaticResource header falls back to at send.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun location(): Optional<Location> = location.getOptional("location")

    /**
     * Whether the asset registered at creation is reused when a caller omits the header's variable
     * at send time. Default false — the caller must supply it per message, which is the behaviour
     * every existing template has. Written only when true, so a default-valued header serializes
     * byte-identically to one imported from Meta.
     *
     * Stored and validated but not yet honoured at send: that lands with the Resumable Upload work,
     * alongside the code that lets such a template be approved in the first place.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun staticResource(): Optional<Boolean> = staticResource.getOptional("static_resource")

    /**
     * The kind of header. One of:
     *
     * text — up to 60 characters, at most one variable. image — png, jpg or jpeg. Needs ExampleUrl.
     * video — mp4. Needs ExampleUrl. gif — mp4, max 3.5MB. WhatsApp renders larger files as an
     * ordinary video. Needs ExampleUrl. document — pdf or docx; only the first page is shown as a
     * thumbnail, so pdf is the practical choice. Needs ExampleUrl. location — a map pin, supplied
     * through Location.
     *
     * Kept lowercase because MetaToTemplateConverter writes Meta's format through
     * ToLowerInvariant() into this field on import, and the two are compared directly.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * List of variables used in the header template
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun variables(): Optional<List<TemplateVariable>> = variables.getOptional("variables")

    /**
     * Returns the raw JSON value of [template].
     *
     * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<String> = template

    /**
     * Returns the raw JSON value of [exampleUrl].
     *
     * Unlike [exampleUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("example_url") @ExcludeMissing fun _exampleUrl(): JsonField<String> = exampleUrl

    /**
     * Returns the raw JSON value of [location].
     *
     * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<Location> = location

    /**
     * Returns the raw JSON value of [staticResource].
     *
     * Unlike [staticResource], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("static_resource")
    @ExcludeMissing
    fun _staticResource(): JsonField<Boolean> = staticResource

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

        /**
         * Returns a mutable builder for constructing an instance of [TemplateHeader].
         *
         * The following fields are required:
         * ```java
         * .template()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateHeader]. */
    class Builder internal constructor() {

        private var template: JsonField<String>? = null
        private var exampleUrl: JsonField<String> = JsonMissing.of()
        private var location: JsonField<Location> = JsonMissing.of()
        private var staticResource: JsonField<Boolean> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var variables: JsonField<MutableList<TemplateVariable>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateHeader: TemplateHeader) = apply {
            template = templateHeader.template
            exampleUrl = templateHeader.exampleUrl
            location = templateHeader.location
            staticResource = templateHeader.staticResource
            type = templateHeader.type
            variables = templateHeader.variables.map { it.toMutableList() }
            additionalProperties = templateHeader.additionalProperties.toMutableMap()
        }

        /**
         * The header template text with optional variable placeholders (e.g., "Welcome to
         * {{0:variable}}")
         */
        fun template(template: String) = template(JsonField.of(template))

        /**
         * Sets [Builder.template] to an arbitrary JSON value.
         *
         * You should usually call [Builder.template] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun template(template: JsonField<String>) = apply { this.template = template }

        /**
         * Request-only. The s.dm URL of the asset Meta's reviewers see — https://s.dm/s/{ID}, eight
         * uppercase characters, uploaded to s.dm out of band. NormalizeRichHeader folds it into the
         * synthesized media variable's Props.Sample and clears it, so it never persists and a
         * stored definition is indistinguishable from an imported one.
         *
         * Stricter than the send path on purpose: TemplateUtils.ValidateMediaVariableValues accepts
         * any absolute https URL for the per-send asset, because that one is the customer's and may
         * live behind a signed CDN link. This one is the review sample, has to outlive every
         * resubmission, and so must be ours. Do not "fix" one to match the other.
         */
        fun exampleUrl(exampleUrl: String?) = exampleUrl(JsonField.ofNullable(exampleUrl))

        /** Alias for calling [Builder.exampleUrl] with `exampleUrl.orElse(null)`. */
        fun exampleUrl(exampleUrl: Optional<String>) = exampleUrl(exampleUrl.getOrNull())

        /**
         * Sets [Builder.exampleUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exampleUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exampleUrl(exampleUrl: JsonField<String>) = apply { this.exampleUrl = exampleUrl }

        /**
         * The map pin a location header drops. Meta wants none of this at creation — the component
         * is just {"type":"header","format":"location"} — so these values exist for Sent: a
         * preview, and the default a StaticResource header falls back to at send.
         */
        fun location(location: Location?) = location(JsonField.ofNullable(location))

        /** Alias for calling [Builder.location] with `location.orElse(null)`. */
        fun location(location: Optional<Location>) = location(location.getOrNull())

        /**
         * Sets [Builder.location] to an arbitrary JSON value.
         *
         * You should usually call [Builder.location] with a well-typed [Location] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun location(location: JsonField<Location>) = apply { this.location = location }

        /**
         * Whether the asset registered at creation is reused when a caller omits the header's
         * variable at send time. Default false — the caller must supply it per message, which is
         * the behaviour every existing template has. Written only when true, so a default-valued
         * header serializes byte-identically to one imported from Meta.
         *
         * Stored and validated but not yet honoured at send: that lands with the Resumable Upload
         * work, alongside the code that lets such a template be approved in the first place.
         */
        fun staticResource(staticResource: Boolean) = staticResource(JsonField.of(staticResource))

        /**
         * Sets [Builder.staticResource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.staticResource] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun staticResource(staticResource: JsonField<Boolean>) = apply {
            this.staticResource = staticResource
        }

        /**
         * The kind of header. One of:
         *
         * text — up to 60 characters, at most one variable. image — png, jpg or jpeg. Needs
         * ExampleUrl. video — mp4. Needs ExampleUrl. gif — mp4, max 3.5MB. WhatsApp renders larger
         * files as an ordinary video. Needs ExampleUrl. document — pdf or docx; only the first page
         * is shown as a thumbnail, so pdf is the practical choice. Needs ExampleUrl. location — a
         * map pin, supplied through Location.
         *
         * Kept lowercase because MetaToTemplateConverter writes Meta's format through
         * ToLowerInvariant() into this field on import, and the two are compared directly.
         */
        fun type(type: String?) = type(JsonField.ofNullable(type))

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.variables] with a well-typed `List<TemplateVariable>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
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
         * Returns an immutable instance of [TemplateHeader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .template()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TemplateHeader =
            TemplateHeader(
                checkRequired("template", template),
                exampleUrl,
                location,
                staticResource,
                type,
                (variables ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): TemplateHeader = apply {
        if (validated) {
            return@apply
        }

        template()
        exampleUrl()
        location().ifPresent { it.validate() }
        staticResource()
        type()
        variables().ifPresent { it.forEach { it.validate() } }
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
        (if (template.asKnown().isPresent) 1 else 0) +
            (if (exampleUrl.asKnown().isPresent) 1 else 0) +
            (location.asKnown().getOrNull()?.validity() ?: 0) +
            (if (staticResource.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /**
     * The map pin a location header drops. Meta wants none of this at creation — the component is
     * just {"type":"header","format":"location"} — so these values exist for Sent: a preview, and
     * the default a StaticResource header falls back to at send.
     */
    class Location
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val address: JsonField<String>,
        private val latitude: JsonField<String>,
        private val longitude: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("latitude")
            @ExcludeMissing
            latitude: JsonField<String> = JsonMissing.of(),
            @JsonProperty("longitude")
            @ExcludeMissing
            longitude: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(address, latitude, longitude, name, mutableMapOf())

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun address(): String = address.getRequired("address")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun latitude(): String = latitude.getRequired("latitude")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun longitude(): String = longitude.getRequired("longitude")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

        /**
         * Returns the raw JSON value of [latitude].
         *
         * Unlike [latitude], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("latitude") @ExcludeMissing fun _latitude(): JsonField<String> = latitude

        /**
         * Returns the raw JSON value of [longitude].
         *
         * Unlike [longitude], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("longitude") @ExcludeMissing fun _longitude(): JsonField<String> = longitude

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * Returns a mutable builder for constructing an instance of [Location].
             *
             * The following fields are required:
             * ```java
             * .address()
             * .latitude()
             * .longitude()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Location]. */
        class Builder internal constructor() {

            private var address: JsonField<String>? = null
            private var latitude: JsonField<String>? = null
            private var longitude: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(location: Location) = apply {
                address = location.address
                latitude = location.latitude
                longitude = location.longitude
                name = location.name
                additionalProperties = location.additionalProperties.toMutableMap()
            }

            fun address(address: String) = address(JsonField.of(address))

            /**
             * Sets [Builder.address] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address(address: JsonField<String>) = apply { this.address = address }

            fun latitude(latitude: String) = latitude(JsonField.of(latitude))

            /**
             * Sets [Builder.latitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.latitude] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun latitude(latitude: JsonField<String>) = apply { this.latitude = latitude }

            fun longitude(longitude: String) = longitude(JsonField.of(longitude))

            /**
             * Sets [Builder.longitude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.longitude] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun longitude(longitude: JsonField<String>) = apply { this.longitude = longitude }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [Location].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .address()
             * .latitude()
             * .longitude()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Location =
                Location(
                    checkRequired("address", address),
                    checkRequired("latitude", latitude),
                    checkRequired("longitude", longitude),
                    checkRequired("name", name),
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
        fun validate(): Location = apply {
            if (validated) {
                return@apply
            }

            address()
            latitude()
            longitude()
            name()
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
            (if (address.asKnown().isPresent) 1 else 0) +
                (if (latitude.asKnown().isPresent) 1 else 0) +
                (if (longitude.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Location &&
                address == other.address &&
                latitude == other.latitude &&
                longitude == other.longitude &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(address, latitude, longitude, name, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Location{address=$address, latitude=$latitude, longitude=$longitude, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateHeader &&
            template == other.template &&
            exampleUrl == other.exampleUrl &&
            location == other.location &&
            staticResource == other.staticResource &&
            type == other.type &&
            variables == other.variables &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            template,
            exampleUrl,
            location,
            staticResource,
            type,
            variables,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateHeader{template=$template, exampleUrl=$exampleUrl, location=$location, staticResource=$staticResource, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
}
