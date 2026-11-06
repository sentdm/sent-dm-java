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
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * The map pin a location header drops. Meta wants none of this at creation — the component is just
 * {"type":"header","format":"location"} — so these values exist for Sent: a preview, and the
 * default a StaticResource header falls back to at send.
 */
class TemplateHeaderLocation
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
        @JsonProperty("latitude") @ExcludeMissing latitude: JsonField<String> = JsonMissing.of(),
        @JsonProperty("longitude") @ExcludeMissing longitude: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
    ) : this(address, latitude, longitude, name, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun address(): String = address.getRequired("address")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun latitude(): String = latitude.getRequired("latitude")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun longitude(): String = longitude.getRequired("longitude")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
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
         * Returns a mutable builder for constructing an instance of [TemplateHeaderLocation].
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

    /** A builder for [TemplateHeaderLocation]. */
    class Builder internal constructor() {

        private var address: JsonField<String>? = null
        private var latitude: JsonField<String>? = null
        private var longitude: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateHeaderLocation: TemplateHeaderLocation) = apply {
            address = templateHeaderLocation.address
            latitude = templateHeaderLocation.latitude
            longitude = templateHeaderLocation.longitude
            name = templateHeaderLocation.name
            additionalProperties = templateHeaderLocation.additionalProperties.toMutableMap()
        }

        fun address(address: String) = address(JsonField.of(address))

        /**
         * Sets [Builder.address] to an arbitrary JSON value.
         *
         * You should usually call [Builder.address] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun address(address: JsonField<String>) = apply { this.address = address }

        fun latitude(latitude: String) = latitude(JsonField.of(latitude))

        /**
         * Sets [Builder.latitude] to an arbitrary JSON value.
         *
         * You should usually call [Builder.latitude] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun latitude(latitude: JsonField<String>) = apply { this.latitude = latitude }

        fun longitude(longitude: String) = longitude(JsonField.of(longitude))

        /**
         * Sets [Builder.longitude] to an arbitrary JSON value.
         *
         * You should usually call [Builder.longitude] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun longitude(longitude: JsonField<String>) = apply { this.longitude = longitude }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [TemplateHeaderLocation].
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
        fun build(): TemplateHeaderLocation =
            TemplateHeaderLocation(
                checkRequired("address", address),
                checkRequired("latitude", latitude),
                checkRequired("longitude", longitude),
                checkRequired("name", name),
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
    fun validate(): TemplateHeaderLocation = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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

        return other is TemplateHeaderLocation &&
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
        "TemplateHeaderLocation{address=$address, latitude=$latitude, longitude=$longitude, name=$name, additionalProperties=$additionalProperties}"
}
