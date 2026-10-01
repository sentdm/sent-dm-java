// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** What your endpoint answered */
class VoiceCallbackTestResponseInfo
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val body: JsonField<String>,
    private val statusCode: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("body") @ExcludeMissing body: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status_code") @ExcludeMissing statusCode: JsonField<Int> = JsonMissing.of(),
    ) : this(body, statusCode, mutableMapOf())

    /**
     * The start of the raw response body, capped at 2048 characters
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun body(): Optional<String> = body.getOptional("body")

    /**
     * The HTTP status your endpoint returned
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun statusCode(): Optional<Int> = statusCode.getOptional("status_code")

    /**
     * Returns the raw JSON value of [body].
     *
     * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

    /**
     * Returns the raw JSON value of [statusCode].
     *
     * Unlike [statusCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status_code") @ExcludeMissing fun _statusCode(): JsonField<Int> = statusCode

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
         * Returns a mutable builder for constructing an instance of
         * [VoiceCallbackTestResponseInfo].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceCallbackTestResponseInfo]. */
    class Builder internal constructor() {

        private var body: JsonField<String> = JsonMissing.of()
        private var statusCode: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceCallbackTestResponseInfo: VoiceCallbackTestResponseInfo) = apply {
            body = voiceCallbackTestResponseInfo.body
            statusCode = voiceCallbackTestResponseInfo.statusCode
            additionalProperties = voiceCallbackTestResponseInfo.additionalProperties.toMutableMap()
        }

        /** The start of the raw response body, capped at 2048 characters */
        fun body(body: String?) = body(JsonField.ofNullable(body))

        /** Alias for calling [Builder.body] with `body.orElse(null)`. */
        fun body(body: Optional<String>) = body(body.getOrNull())

        /**
         * Sets [Builder.body] to an arbitrary JSON value.
         *
         * You should usually call [Builder.body] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun body(body: JsonField<String>) = apply { this.body = body }

        /** The HTTP status your endpoint returned */
        fun statusCode(statusCode: Int) = statusCode(JsonField.of(statusCode))

        /**
         * Sets [Builder.statusCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusCode] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun statusCode(statusCode: JsonField<Int>) = apply { this.statusCode = statusCode }

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
         * Returns an immutable instance of [VoiceCallbackTestResponseInfo].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceCallbackTestResponseInfo =
            VoiceCallbackTestResponseInfo(body, statusCode, additionalProperties.toMutableMap())
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
    fun validate(): VoiceCallbackTestResponseInfo = apply {
        if (validated) {
            return@apply
        }

        body()
        statusCode()
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
        (if (body.asKnown().isPresent) 1 else 0) + (if (statusCode.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceCallbackTestResponseInfo &&
            body == other.body &&
            statusCode == other.statusCode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(body, statusCode, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceCallbackTestResponseInfo{body=$body, statusCode=$statusCode, additionalProperties=$additionalProperties}"
}
