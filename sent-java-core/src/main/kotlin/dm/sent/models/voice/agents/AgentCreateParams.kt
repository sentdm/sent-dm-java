// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.checkKnown
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
 * Creates an agent that answers phone calls through the Sent Voice Gateway. `session_type` says
 * whether Sent carries the call as text (the caller's speech recognised for the agent, the agent's
 * text spoken) or as audio. With `websocket_url` the gateway dials your agent for each call and
 * signs the handshake with the `signing_secret` this response returns; without it, your agent dials
 * in with your API key and this agent's `id`.
 *
 * `tools`, `transfer_targets`, `fallback` and `limits` say what the agent may do on a call. Voices
 * and languages for text sessions come from `GET /v3/voice/voices`. Calls reach the agent once a
 * number is bound to it on `/v3/channels/voice`.
 *
 * `signing_secret` is shown here and on `POST /v3/voice/agents/{id}/rotate-secret` only; store it
 * now. With `sandbox: true` the request is validated and the agent reported with `202`; nothing is
 * written.
 */
class AgentCreateParams
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
     * Audio sessions only: the sound format.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun audio(): Optional<VoiceAgentAudioSpec> = body.audio()

    /**
     * Who takes the call when the agent cannot: a phone number (kind: number). Omit it and such a
     * call hangs up.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun fallback(): Optional<VoiceAgentPartySpec> = body.fallback()

    /**
     * Text sessions only: what the caller hears as soon as the call is answered, before the agent's
     * first turn. 1 to 4,096 characters. Omit it and the agent speaks first.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun greeting(): Optional<String> = body.greeting()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun limits(): Optional<VoiceAgentLimitsSpec> = body.limits()

    /**
     * A name for your own reference, 1 to 100 characters.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * text: Sent turns the caller's speech into text and the agent's text into speech, so the agent
     * exchanges text frames. audio: the agent receives and sends the sound itself.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sessionType(): Optional<String> = body.sessionType()

    /**
     * Text sessions only: how the caller is spoken to and listened to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun speech(): Optional<VoiceAgentSpeechSpec> = body.speech()

    /**
     * What the agent may do to the call: any of transfer, hangup, send_dtmf and hold. Default
     * ["hangup"]. transfer needs at least one transfer_targets entry.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun tools(): Optional<List<String>> = body.tools()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun transcripts(): Optional<VoiceAgentTranscriptsSpec> = body.transcripts()

    /**
     * Where the agent may transfer a call to, up to 20 parties: a phone number (kind: number,
     * E.164), one of your app users (kind: user, the identity) or another of your agents (kind:
     * agent, its id). The agent can only transfer to a party listed here.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun transferTargets(): Optional<List<VoiceAgentPartySpec>> = body.transferTargets()

    /**
     * Where the gateway connects to the agent for each call: an absolute wss:// URL on a public
     * host, at most 2,048 characters. The handshake is signed with the agent's signing_secret.
     * Leave it out and the agent dials in instead, connecting to the gateway with your API key.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun websocketUrl(): Optional<String> = body.websocketUrl()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _audio(): JsonField<VoiceAgentAudioSpec> = body._audio()

    /**
     * Returns the raw JSON value of [fallback].
     *
     * Unlike [fallback], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fallback(): JsonField<VoiceAgentPartySpec> = body._fallback()

    /**
     * Returns the raw JSON value of [greeting].
     *
     * Unlike [greeting], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _greeting(): JsonField<String> = body._greeting()

    /**
     * Returns the raw JSON value of [limits].
     *
     * Unlike [limits], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _limits(): JsonField<VoiceAgentLimitsSpec> = body._limits()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [sessionType].
     *
     * Unlike [sessionType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sessionType(): JsonField<String> = body._sessionType()

    /**
     * Returns the raw JSON value of [speech].
     *
     * Unlike [speech], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _speech(): JsonField<VoiceAgentSpeechSpec> = body._speech()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<String>> = body._tools()

    /**
     * Returns the raw JSON value of [transcripts].
     *
     * Unlike [transcripts], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transcripts(): JsonField<VoiceAgentTranscriptsSpec> = body._transcripts()

    /**
     * Returns the raw JSON value of [transferTargets].
     *
     * Unlike [transferTargets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transferTargets(): JsonField<List<VoiceAgentPartySpec>> = body._transferTargets()

    /**
     * Returns the raw JSON value of [websocketUrl].
     *
     * Unlike [websocketUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _websocketUrl(): JsonField<String> = body._websocketUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): AgentCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [AgentCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(agentCreateParams: AgentCreateParams) = apply {
            idempotencyKey = agentCreateParams.idempotencyKey
            xProfileId = agentCreateParams.xProfileId
            body = agentCreateParams.body.toBuilder()
            additionalHeaders = agentCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = agentCreateParams.additionalQueryParams.toBuilder()
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
         * - [audio]
         * - [fallback]
         * - [greeting]
         * - [limits]
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

        /** Audio sessions only: the sound format. */
        fun audio(audio: VoiceAgentAudioSpec?) = apply { body.audio(audio) }

        /** Alias for calling [Builder.audio] with `audio.orElse(null)`. */
        fun audio(audio: Optional<VoiceAgentAudioSpec>) = audio(audio.getOrNull())

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [VoiceAgentAudioSpec] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun audio(audio: JsonField<VoiceAgentAudioSpec>) = apply { body.audio(audio) }

        /**
         * Who takes the call when the agent cannot: a phone number (kind: number). Omit it and such
         * a call hangs up.
         */
        fun fallback(fallback: VoiceAgentPartySpec?) = apply { body.fallback(fallback) }

        /** Alias for calling [Builder.fallback] with `fallback.orElse(null)`. */
        fun fallback(fallback: Optional<VoiceAgentPartySpec>) = fallback(fallback.getOrNull())

        /**
         * Sets [Builder.fallback] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fallback] with a well-typed [VoiceAgentPartySpec] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fallback(fallback: JsonField<VoiceAgentPartySpec>) = apply { body.fallback(fallback) }

        /**
         * Text sessions only: what the caller hears as soon as the call is answered, before the
         * agent's first turn. 1 to 4,096 characters. Omit it and the agent speaks first.
         */
        fun greeting(greeting: String?) = apply { body.greeting(greeting) }

        /** Alias for calling [Builder.greeting] with `greeting.orElse(null)`. */
        fun greeting(greeting: Optional<String>) = greeting(greeting.getOrNull())

        /**
         * Sets [Builder.greeting] to an arbitrary JSON value.
         *
         * You should usually call [Builder.greeting] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun greeting(greeting: JsonField<String>) = apply { body.greeting(greeting) }

        fun limits(limits: VoiceAgentLimitsSpec?) = apply { body.limits(limits) }

        /** Alias for calling [Builder.limits] with `limits.orElse(null)`. */
        fun limits(limits: Optional<VoiceAgentLimitsSpec>) = limits(limits.getOrNull())

        /**
         * Sets [Builder.limits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limits] with a well-typed [VoiceAgentLimitsSpec] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun limits(limits: JsonField<VoiceAgentLimitsSpec>) = apply { body.limits(limits) }

        /** A name for your own reference, 1 to 100 characters. */
        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * text: Sent turns the caller's speech into text and the agent's text into speech, so the
         * agent exchanges text frames. audio: the agent receives and sends the sound itself.
         */
        fun sessionType(sessionType: String?) = apply { body.sessionType(sessionType) }

        /** Alias for calling [Builder.sessionType] with `sessionType.orElse(null)`. */
        fun sessionType(sessionType: Optional<String>) = sessionType(sessionType.getOrNull())

        /**
         * Sets [Builder.sessionType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionType(sessionType: JsonField<String>) = apply { body.sessionType(sessionType) }

        /** Text sessions only: how the caller is spoken to and listened to. */
        fun speech(speech: VoiceAgentSpeechSpec?) = apply { body.speech(speech) }

        /** Alias for calling [Builder.speech] with `speech.orElse(null)`. */
        fun speech(speech: Optional<VoiceAgentSpeechSpec>) = speech(speech.getOrNull())

        /**
         * Sets [Builder.speech] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speech] with a well-typed [VoiceAgentSpeechSpec] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun speech(speech: JsonField<VoiceAgentSpeechSpec>) = apply { body.speech(speech) }

        /**
         * What the agent may do to the call: any of transfer, hangup, send_dtmf and hold. Default
         * ["hangup"]. transfer needs at least one transfer_targets entry.
         */
        fun tools(tools: List<String>?) = apply { body.tools(tools) }

        /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
        fun tools(tools: Optional<List<String>>) = tools(tools.getOrNull())

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<String>>) = apply { body.tools(tools) }

        /**
         * Adds a single [String] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: String) = apply { body.addTool(tool) }

        fun transcripts(transcripts: VoiceAgentTranscriptsSpec?) = apply {
            body.transcripts(transcripts)
        }

        /** Alias for calling [Builder.transcripts] with `transcripts.orElse(null)`. */
        fun transcripts(transcripts: Optional<VoiceAgentTranscriptsSpec>) =
            transcripts(transcripts.getOrNull())

        /**
         * Sets [Builder.transcripts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transcripts] with a well-typed
         * [VoiceAgentTranscriptsSpec] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun transcripts(transcripts: JsonField<VoiceAgentTranscriptsSpec>) = apply {
            body.transcripts(transcripts)
        }

        /**
         * Where the agent may transfer a call to, up to 20 parties: a phone number (kind: number,
         * E.164), one of your app users (kind: user, the identity) or another of your agents (kind:
         * agent, its id). The agent can only transfer to a party listed here.
         */
        fun transferTargets(transferTargets: List<VoiceAgentPartySpec>?) = apply {
            body.transferTargets(transferTargets)
        }

        /** Alias for calling [Builder.transferTargets] with `transferTargets.orElse(null)`. */
        fun transferTargets(transferTargets: Optional<List<VoiceAgentPartySpec>>) =
            transferTargets(transferTargets.getOrNull())

        /**
         * Sets [Builder.transferTargets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transferTargets] with a well-typed
         * `List<VoiceAgentPartySpec>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun transferTargets(transferTargets: JsonField<List<VoiceAgentPartySpec>>) = apply {
            body.transferTargets(transferTargets)
        }

        /**
         * Adds a single [VoiceAgentPartySpec] to [transferTargets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTransferTarget(transferTarget: VoiceAgentPartySpec) = apply {
            body.addTransferTarget(transferTarget)
        }

        /**
         * Where the gateway connects to the agent for each call: an absolute wss:// URL on a public
         * host, at most 2,048 characters. The handshake is signed with the agent's signing_secret.
         * Leave it out and the agent dials in instead, connecting to the gateway with your API key.
         */
        fun websocketUrl(websocketUrl: String?) = apply { body.websocketUrl(websocketUrl) }

        /** Alias for calling [Builder.websocketUrl] with `websocketUrl.orElse(null)`. */
        fun websocketUrl(websocketUrl: Optional<String>) = websocketUrl(websocketUrl.getOrNull())

        /**
         * Sets [Builder.websocketUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.websocketUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun websocketUrl(websocketUrl: JsonField<String>) = apply {
            body.websocketUrl(websocketUrl)
        }

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
         * Returns an immutable instance of [AgentCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AgentCreateParams =
            AgentCreateParams(
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
     * Creates a voice agent: what it takes for your agent to answer phone calls through the Sent
     * Voice Gateway. Only name and session_type are required; every other field has a default.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val audio: JsonField<VoiceAgentAudioSpec>,
        private val fallback: JsonField<VoiceAgentPartySpec>,
        private val greeting: JsonField<String>,
        private val limits: JsonField<VoiceAgentLimitsSpec>,
        private val name: JsonField<String>,
        private val sessionType: JsonField<String>,
        private val speech: JsonField<VoiceAgentSpeechSpec>,
        private val tools: JsonField<List<String>>,
        private val transcripts: JsonField<VoiceAgentTranscriptsSpec>,
        private val transferTargets: JsonField<List<VoiceAgentPartySpec>>,
        private val websocketUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("audio")
            @ExcludeMissing
            audio: JsonField<VoiceAgentAudioSpec> = JsonMissing.of(),
            @JsonProperty("fallback")
            @ExcludeMissing
            fallback: JsonField<VoiceAgentPartySpec> = JsonMissing.of(),
            @JsonProperty("greeting")
            @ExcludeMissing
            greeting: JsonField<String> = JsonMissing.of(),
            @JsonProperty("limits")
            @ExcludeMissing
            limits: JsonField<VoiceAgentLimitsSpec> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("session_type")
            @ExcludeMissing
            sessionType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("speech")
            @ExcludeMissing
            speech: JsonField<VoiceAgentSpeechSpec> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("transcripts")
            @ExcludeMissing
            transcripts: JsonField<VoiceAgentTranscriptsSpec> = JsonMissing.of(),
            @JsonProperty("transfer_targets")
            @ExcludeMissing
            transferTargets: JsonField<List<VoiceAgentPartySpec>> = JsonMissing.of(),
            @JsonProperty("websocket_url")
            @ExcludeMissing
            websocketUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            sandbox,
            audio,
            fallback,
            greeting,
            limits,
            name,
            sessionType,
            speech,
            tools,
            transcripts,
            transferTargets,
            websocketUrl,
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
         * Audio sessions only: the sound format.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audio(): Optional<VoiceAgentAudioSpec> = audio.getOptional("audio")

        /**
         * Who takes the call when the agent cannot: a phone number (kind: number). Omit it and such
         * a call hangs up.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fallback(): Optional<VoiceAgentPartySpec> = fallback.getOptional("fallback")

        /**
         * Text sessions only: what the caller hears as soon as the call is answered, before the
         * agent's first turn. 1 to 4,096 characters. Omit it and the agent speaks first.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun greeting(): Optional<String> = greeting.getOptional("greeting")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun limits(): Optional<VoiceAgentLimitsSpec> = limits.getOptional("limits")

        /**
         * A name for your own reference, 1 to 100 characters.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * text: Sent turns the caller's speech into text and the agent's text into speech, so the
         * agent exchanges text frames. audio: the agent receives and sends the sound itself.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sessionType(): Optional<String> = sessionType.getOptional("session_type")

        /**
         * Text sessions only: how the caller is spoken to and listened to.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun speech(): Optional<VoiceAgentSpeechSpec> = speech.getOptional("speech")

        /**
         * What the agent may do to the call: any of transfer, hangup, send_dtmf and hold. Default
         * ["hangup"]. transfer needs at least one transfer_targets entry.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<String>> = tools.getOptional("tools")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun transcripts(): Optional<VoiceAgentTranscriptsSpec> =
            transcripts.getOptional("transcripts")

        /**
         * Where the agent may transfer a call to, up to 20 parties: a phone number (kind: number,
         * E.164), one of your app users (kind: user, the identity) or another of your agents (kind:
         * agent, its id). The agent can only transfer to a party listed here.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun transferTargets(): Optional<List<VoiceAgentPartySpec>> =
            transferTargets.getOptional("transfer_targets")

        /**
         * Where the gateway connects to the agent for each call: an absolute wss:// URL on a public
         * host, at most 2,048 characters. The handshake is signed with the agent's signing_secret.
         * Leave it out and the agent dials in instead, connecting to the gateway with your API key.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun websocketUrl(): Optional<String> = websocketUrl.getOptional("websocket_url")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [audio].
         *
         * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<VoiceAgentAudioSpec> = audio

        /**
         * Returns the raw JSON value of [fallback].
         *
         * Unlike [fallback], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fallback")
        @ExcludeMissing
        fun _fallback(): JsonField<VoiceAgentPartySpec> = fallback

        /**
         * Returns the raw JSON value of [greeting].
         *
         * Unlike [greeting], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("greeting") @ExcludeMissing fun _greeting(): JsonField<String> = greeting

        /**
         * Returns the raw JSON value of [limits].
         *
         * Unlike [limits], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limits")
        @ExcludeMissing
        fun _limits(): JsonField<VoiceAgentLimitsSpec> = limits

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [sessionType].
         *
         * Unlike [sessionType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session_type")
        @ExcludeMissing
        fun _sessionType(): JsonField<String> = sessionType

        /**
         * Returns the raw JSON value of [speech].
         *
         * Unlike [speech], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("speech")
        @ExcludeMissing
        fun _speech(): JsonField<VoiceAgentSpeechSpec> = speech

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<String>> = tools

        /**
         * Returns the raw JSON value of [transcripts].
         *
         * Unlike [transcripts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("transcripts")
        @ExcludeMissing
        fun _transcripts(): JsonField<VoiceAgentTranscriptsSpec> = transcripts

        /**
         * Returns the raw JSON value of [transferTargets].
         *
         * Unlike [transferTargets], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transfer_targets")
        @ExcludeMissing
        fun _transferTargets(): JsonField<List<VoiceAgentPartySpec>> = transferTargets

        /**
         * Returns the raw JSON value of [websocketUrl].
         *
         * Unlike [websocketUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("websocket_url")
        @ExcludeMissing
        fun _websocketUrl(): JsonField<String> = websocketUrl

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

            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var audio: JsonField<VoiceAgentAudioSpec> = JsonMissing.of()
            private var fallback: JsonField<VoiceAgentPartySpec> = JsonMissing.of()
            private var greeting: JsonField<String> = JsonMissing.of()
            private var limits: JsonField<VoiceAgentLimitsSpec> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var sessionType: JsonField<String> = JsonMissing.of()
            private var speech: JsonField<VoiceAgentSpeechSpec> = JsonMissing.of()
            private var tools: JsonField<MutableList<String>>? = null
            private var transcripts: JsonField<VoiceAgentTranscriptsSpec> = JsonMissing.of()
            private var transferTargets: JsonField<MutableList<VoiceAgentPartySpec>>? = null
            private var websocketUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                audio = body.audio
                fallback = body.fallback
                greeting = body.greeting
                limits = body.limits
                name = body.name
                sessionType = body.sessionType
                speech = body.speech
                tools = body.tools.map { it.toMutableList() }
                transcripts = body.transcripts
                transferTargets = body.transferTargets.map { it.toMutableList() }
                websocketUrl = body.websocketUrl
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

            /** Audio sessions only: the sound format. */
            fun audio(audio: VoiceAgentAudioSpec?) = audio(JsonField.ofNullable(audio))

            /** Alias for calling [Builder.audio] with `audio.orElse(null)`. */
            fun audio(audio: Optional<VoiceAgentAudioSpec>) = audio(audio.getOrNull())

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [VoiceAgentAudioSpec] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audio(audio: JsonField<VoiceAgentAudioSpec>) = apply { this.audio = audio }

            /**
             * Who takes the call when the agent cannot: a phone number (kind: number). Omit it and
             * such a call hangs up.
             */
            fun fallback(fallback: VoiceAgentPartySpec?) = fallback(JsonField.ofNullable(fallback))

            /** Alias for calling [Builder.fallback] with `fallback.orElse(null)`. */
            fun fallback(fallback: Optional<VoiceAgentPartySpec>) = fallback(fallback.getOrNull())

            /**
             * Sets [Builder.fallback] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fallback] with a well-typed [VoiceAgentPartySpec]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun fallback(fallback: JsonField<VoiceAgentPartySpec>) = apply {
                this.fallback = fallback
            }

            /**
             * Text sessions only: what the caller hears as soon as the call is answered, before the
             * agent's first turn. 1 to 4,096 characters. Omit it and the agent speaks first.
             */
            fun greeting(greeting: String?) = greeting(JsonField.ofNullable(greeting))

            /** Alias for calling [Builder.greeting] with `greeting.orElse(null)`. */
            fun greeting(greeting: Optional<String>) = greeting(greeting.getOrNull())

            /**
             * Sets [Builder.greeting] to an arbitrary JSON value.
             *
             * You should usually call [Builder.greeting] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun greeting(greeting: JsonField<String>) = apply { this.greeting = greeting }

            fun limits(limits: VoiceAgentLimitsSpec?) = limits(JsonField.ofNullable(limits))

            /** Alias for calling [Builder.limits] with `limits.orElse(null)`. */
            fun limits(limits: Optional<VoiceAgentLimitsSpec>) = limits(limits.getOrNull())

            /**
             * Sets [Builder.limits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limits] with a well-typed [VoiceAgentLimitsSpec]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun limits(limits: JsonField<VoiceAgentLimitsSpec>) = apply { this.limits = limits }

            /** A name for your own reference, 1 to 100 characters. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * text: Sent turns the caller's speech into text and the agent's text into speech, so
             * the agent exchanges text frames. audio: the agent receives and sends the sound
             * itself.
             */
            fun sessionType(sessionType: String?) = sessionType(JsonField.ofNullable(sessionType))

            /** Alias for calling [Builder.sessionType] with `sessionType.orElse(null)`. */
            fun sessionType(sessionType: Optional<String>) = sessionType(sessionType.getOrNull())

            /**
             * Sets [Builder.sessionType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionType(sessionType: JsonField<String>) = apply {
                this.sessionType = sessionType
            }

            /** Text sessions only: how the caller is spoken to and listened to. */
            fun speech(speech: VoiceAgentSpeechSpec?) = speech(JsonField.ofNullable(speech))

            /** Alias for calling [Builder.speech] with `speech.orElse(null)`. */
            fun speech(speech: Optional<VoiceAgentSpeechSpec>) = speech(speech.getOrNull())

            /**
             * Sets [Builder.speech] to an arbitrary JSON value.
             *
             * You should usually call [Builder.speech] with a well-typed [VoiceAgentSpeechSpec]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun speech(speech: JsonField<VoiceAgentSpeechSpec>) = apply { this.speech = speech }

            /**
             * What the agent may do to the call: any of transfer, hangup, send_dtmf and hold.
             * Default ["hangup"]. transfer needs at least one transfer_targets entry.
             */
            fun tools(tools: List<String>?) = tools(JsonField.ofNullable(tools))

            /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
            fun tools(tools: Optional<List<String>>) = tools(tools.getOrNull())

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<String>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: String) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            fun transcripts(transcripts: VoiceAgentTranscriptsSpec?) =
                transcripts(JsonField.ofNullable(transcripts))

            /** Alias for calling [Builder.transcripts] with `transcripts.orElse(null)`. */
            fun transcripts(transcripts: Optional<VoiceAgentTranscriptsSpec>) =
                transcripts(transcripts.getOrNull())

            /**
             * Sets [Builder.transcripts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transcripts] with a well-typed
             * [VoiceAgentTranscriptsSpec] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun transcripts(transcripts: JsonField<VoiceAgentTranscriptsSpec>) = apply {
                this.transcripts = transcripts
            }

            /**
             * Where the agent may transfer a call to, up to 20 parties: a phone number (kind:
             * number, E.164), one of your app users (kind: user, the identity) or another of your
             * agents (kind: agent, its id). The agent can only transfer to a party listed here.
             */
            fun transferTargets(transferTargets: List<VoiceAgentPartySpec>?) =
                transferTargets(JsonField.ofNullable(transferTargets))

            /** Alias for calling [Builder.transferTargets] with `transferTargets.orElse(null)`. */
            fun transferTargets(transferTargets: Optional<List<VoiceAgentPartySpec>>) =
                transferTargets(transferTargets.getOrNull())

            /**
             * Sets [Builder.transferTargets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transferTargets] with a well-typed
             * `List<VoiceAgentPartySpec>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun transferTargets(transferTargets: JsonField<List<VoiceAgentPartySpec>>) = apply {
                this.transferTargets = transferTargets.map { it.toMutableList() }
            }

            /**
             * Adds a single [VoiceAgentPartySpec] to [transferTargets].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTransferTarget(transferTarget: VoiceAgentPartySpec) = apply {
                transferTargets =
                    (transferTargets ?: JsonField.of(mutableListOf())).also {
                        checkKnown("transferTargets", it).add(transferTarget)
                    }
            }

            /**
             * Where the gateway connects to the agent for each call: an absolute wss:// URL on a
             * public host, at most 2,048 characters. The handshake is signed with the agent's
             * signing_secret. Leave it out and the agent dials in instead, connecting to the
             * gateway with your API key.
             */
            fun websocketUrl(websocketUrl: String?) =
                websocketUrl(JsonField.ofNullable(websocketUrl))

            /** Alias for calling [Builder.websocketUrl] with `websocketUrl.orElse(null)`. */
            fun websocketUrl(websocketUrl: Optional<String>) =
                websocketUrl(websocketUrl.getOrNull())

            /**
             * Sets [Builder.websocketUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.websocketUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun websocketUrl(websocketUrl: JsonField<String>) = apply {
                this.websocketUrl = websocketUrl
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
                Body(
                    sandbox,
                    audio,
                    fallback,
                    greeting,
                    limits,
                    name,
                    sessionType,
                    speech,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    transcripts,
                    (transferTargets ?: JsonMissing.of()).map { it.toImmutable() },
                    websocketUrl,
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
            audio().ifPresent { it.validate() }
            fallback().ifPresent { it.validate() }
            greeting()
            limits().ifPresent { it.validate() }
            name()
            sessionType()
            speech().ifPresent { it.validate() }
            tools()
            transcripts().ifPresent { it.validate() }
            transferTargets().ifPresent { it.forEach { it.validate() } }
            websocketUrl()
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
                (audio.asKnown().getOrNull()?.validity() ?: 0) +
                (fallback.asKnown().getOrNull()?.validity() ?: 0) +
                (if (greeting.asKnown().isPresent) 1 else 0) +
                (limits.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (sessionType.asKnown().isPresent) 1 else 0) +
                (speech.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.size ?: 0) +
                (transcripts.asKnown().getOrNull()?.validity() ?: 0) +
                (transferTargets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (websocketUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                audio == other.audio &&
                fallback == other.fallback &&
                greeting == other.greeting &&
                limits == other.limits &&
                name == other.name &&
                sessionType == other.sessionType &&
                speech == other.speech &&
                tools == other.tools &&
                transcripts == other.transcripts &&
                transferTargets == other.transferTargets &&
                websocketUrl == other.websocketUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                audio,
                fallback,
                greeting,
                limits,
                name,
                sessionType,
                speech,
                tools,
                transcripts,
                transferTargets,
                websocketUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, audio=$audio, fallback=$fallback, greeting=$greeting, limits=$limits, name=$name, sessionType=$sessionType, speech=$speech, tools=$tools, transcripts=$transcripts, transferTargets=$transferTargets, websocketUrl=$websocketUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AgentCreateParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
