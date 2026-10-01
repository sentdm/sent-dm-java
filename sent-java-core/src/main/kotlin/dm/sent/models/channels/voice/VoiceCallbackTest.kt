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

/** The verdict of a test question sent to your callback URL */
class VoiceCallbackTest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val answer: JsonValue,
    private val callId: JsonField<String>,
    private val error: JsonField<VoiceCallbackTestErrorInfo>,
    private val outcome: JsonField<String>,
    private val request: JsonField<VoiceCallbackTestRequestInfo>,
    private val response: JsonField<VoiceCallbackTestResponseInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("answer") @ExcludeMissing answer: JsonValue = JsonMissing.of(),
        @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("error")
        @ExcludeMissing
        error: JsonField<VoiceCallbackTestErrorInfo> = JsonMissing.of(),
        @JsonProperty("outcome") @ExcludeMissing outcome: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request")
        @ExcludeMissing
        request: JsonField<VoiceCallbackTestRequestInfo> = JsonMissing.of(),
        @JsonProperty("response")
        @ExcludeMissing
        response: JsonField<VoiceCallbackTestResponseInfo> = JsonMissing.of(),
    ) : this(answer, callId, error, outcome, request, response, mutableMapOf())

    /**
     * Your answer as Sent read it, with numbers in E.164 and a missing caller id filled in. Set
     * only when the outcome is ok.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = voiceCallbackTest.answer().convert(MyClass.class);
     * ```
     */
    @JsonProperty("answer") @ExcludeMissing fun _answer(): JsonValue = answer

    /**
     * The call id the test question carried. It does not exist anywhere else and cannot be looked
     * up.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun callId(): Optional<String> = callId.getOptional("call_id")

    /**
     * Why the test did not end with ok
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun error(): Optional<VoiceCallbackTestErrorInfo> = error.getOptional("error")

    /**
     * What happened: ok, timeout, connection_failed, http_error or invalid_answer
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun outcome(): Optional<String> = outcome.getOptional("outcome")

    /**
     * The test question exactly as it was sent
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun request(): Optional<VoiceCallbackTestRequestInfo> = request.getOptional("request")

    /**
     * What your endpoint answered
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun response(): Optional<VoiceCallbackTestResponseInfo> = response.getOptional("response")

    /**
     * Returns the raw JSON value of [callId].
     *
     * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error")
    @ExcludeMissing
    fun _error(): JsonField<VoiceCallbackTestErrorInfo> = error

    /**
     * Returns the raw JSON value of [outcome].
     *
     * Unlike [outcome], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("outcome") @ExcludeMissing fun _outcome(): JsonField<String> = outcome

    /**
     * Returns the raw JSON value of [request].
     *
     * Unlike [request], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request")
    @ExcludeMissing
    fun _request(): JsonField<VoiceCallbackTestRequestInfo> = request

    /**
     * Returns the raw JSON value of [response].
     *
     * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response")
    @ExcludeMissing
    fun _response(): JsonField<VoiceCallbackTestResponseInfo> = response

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

        /** Returns a mutable builder for constructing an instance of [VoiceCallbackTest]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceCallbackTest]. */
    class Builder internal constructor() {

        private var answer: JsonValue = JsonMissing.of()
        private var callId: JsonField<String> = JsonMissing.of()
        private var error: JsonField<VoiceCallbackTestErrorInfo> = JsonMissing.of()
        private var outcome: JsonField<String> = JsonMissing.of()
        private var request: JsonField<VoiceCallbackTestRequestInfo> = JsonMissing.of()
        private var response: JsonField<VoiceCallbackTestResponseInfo> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceCallbackTest: VoiceCallbackTest) = apply {
            answer = voiceCallbackTest.answer
            callId = voiceCallbackTest.callId
            error = voiceCallbackTest.error
            outcome = voiceCallbackTest.outcome
            request = voiceCallbackTest.request
            response = voiceCallbackTest.response
            additionalProperties = voiceCallbackTest.additionalProperties.toMutableMap()
        }

        /**
         * Your answer as Sent read it, with numbers in E.164 and a missing caller id filled in. Set
         * only when the outcome is ok.
         */
        fun answer(answer: JsonValue) = apply { this.answer = answer }

        /**
         * The call id the test question carried. It does not exist anywhere else and cannot be
         * looked up.
         */
        fun callId(callId: String) = callId(JsonField.of(callId))

        /**
         * Sets [Builder.callId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun callId(callId: JsonField<String>) = apply { this.callId = callId }

        /** Why the test did not end with ok */
        fun error(error: VoiceCallbackTestErrorInfo?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<VoiceCallbackTestErrorInfo>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [VoiceCallbackTestErrorInfo]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun error(error: JsonField<VoiceCallbackTestErrorInfo>) = apply { this.error = error }

        /** What happened: ok, timeout, connection_failed, http_error or invalid_answer */
        fun outcome(outcome: String) = outcome(JsonField.of(outcome))

        /**
         * Sets [Builder.outcome] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outcome] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun outcome(outcome: JsonField<String>) = apply { this.outcome = outcome }

        /** The test question exactly as it was sent */
        fun request(request: VoiceCallbackTestRequestInfo?) = request(JsonField.ofNullable(request))

        /** Alias for calling [Builder.request] with `request.orElse(null)`. */
        fun request(request: Optional<VoiceCallbackTestRequestInfo>) = request(request.getOrNull())

        /**
         * Sets [Builder.request] to an arbitrary JSON value.
         *
         * You should usually call [Builder.request] with a well-typed
         * [VoiceCallbackTestRequestInfo] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun request(request: JsonField<VoiceCallbackTestRequestInfo>) = apply {
            this.request = request
        }

        /** What your endpoint answered */
        fun response(response: VoiceCallbackTestResponseInfo?) =
            response(JsonField.ofNullable(response))

        /** Alias for calling [Builder.response] with `response.orElse(null)`. */
        fun response(response: Optional<VoiceCallbackTestResponseInfo>) =
            response(response.getOrNull())

        /**
         * Sets [Builder.response] to an arbitrary JSON value.
         *
         * You should usually call [Builder.response] with a well-typed
         * [VoiceCallbackTestResponseInfo] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun response(response: JsonField<VoiceCallbackTestResponseInfo>) = apply {
            this.response = response
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
         * Returns an immutable instance of [VoiceCallbackTest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceCallbackTest =
            VoiceCallbackTest(
                answer,
                callId,
                error,
                outcome,
                request,
                response,
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
    fun validate(): VoiceCallbackTest = apply {
        if (validated) {
            return@apply
        }

        callId()
        error().ifPresent { it.validate() }
        outcome()
        request().ifPresent { it.validate() }
        response().ifPresent { it.validate() }
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
        (if (callId.asKnown().isPresent) 1 else 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outcome.asKnown().isPresent) 1 else 0) +
            (request.asKnown().getOrNull()?.validity() ?: 0) +
            (response.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceCallbackTest &&
            answer == other.answer &&
            callId == other.callId &&
            error == other.error &&
            outcome == other.outcome &&
            request == other.request &&
            response == other.response &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(answer, callId, error, outcome, request, response, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceCallbackTest{answer=$answer, callId=$callId, error=$error, outcome=$outcome, request=$request, response=$response, additionalProperties=$additionalProperties}"
}
