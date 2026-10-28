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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A voice agent as stored: what was written with every default filled in, plus the signing secret
 * the one time it is shown (on create, and on rotate). The one shape every read of an agent answers
 * with, on /v3/voice/agents and on the admin API the dashboard uses, so the two cannot drift.
 */
class VoiceAgent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val audio: JsonField<VoiceAgentAudio>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val fallback: JsonField<VoiceAgentParty>,
    private val greeting: JsonField<String>,
    private val limits: JsonField<VoiceAgentLimits>,
    private val name: JsonField<String>,
    private val sessionType: JsonField<String>,
    private val signingSecret: JsonField<String>,
    private val speech: JsonField<VoiceAgentSpeech>,
    private val tools: JsonField<List<String>>,
    private val transcripts: JsonField<VoiceAgentTranscripts>,
    private val transferTargets: JsonField<List<VoiceAgentParty>>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val websocketUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<VoiceAgentAudio> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("fallback")
        @ExcludeMissing
        fallback: JsonField<VoiceAgentParty> = JsonMissing.of(),
        @JsonProperty("greeting") @ExcludeMissing greeting: JsonField<String> = JsonMissing.of(),
        @JsonProperty("limits")
        @ExcludeMissing
        limits: JsonField<VoiceAgentLimits> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("session_type")
        @ExcludeMissing
        sessionType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("signing_secret")
        @ExcludeMissing
        signingSecret: JsonField<String> = JsonMissing.of(),
        @JsonProperty("speech")
        @ExcludeMissing
        speech: JsonField<VoiceAgentSpeech> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("transcripts")
        @ExcludeMissing
        transcripts: JsonField<VoiceAgentTranscripts> = JsonMissing.of(),
        @JsonProperty("transfer_targets")
        @ExcludeMissing
        transferTargets: JsonField<List<VoiceAgentParty>> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("websocket_url")
        @ExcludeMissing
        websocketUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        audio,
        createdAt,
        fallback,
        greeting,
        limits,
        name,
        sessionType,
        signingSecret,
        speech,
        tools,
        transcripts,
        transferTargets,
        updatedAt,
        websocketUrl,
        mutableMapOf(),
    )

    /**
     * The agent's id, agent_ and a UUID. It is also what the agent connects to the gateway as.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Audio sessions: the sample rate in use.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun audio(): Optional<VoiceAgentAudio> = audio.getOptional("audio")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun fallback(): Optional<VoiceAgentParty> = fallback.getOptional("fallback")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun greeting(): Optional<String> = greeting.getOptional("greeting")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun limits(): Optional<VoiceAgentLimits> = limits.getOptional("limits")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * text or audio.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sessionType(): Optional<String> = sessionType.getOptional("session_type")

    /**
     * The whsec_ secret the gateway signs its handshake to websocket_url with. Present on create
     * and after a rotate-secret; absent on every other read. Store it now.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun signingSecret(): Optional<String> = signingSecret.getOptional("signing_secret")

    /**
     * Text sessions: the speech setting, voice and language in use.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun speech(): Optional<VoiceAgentSpeech> = speech.getOptional("speech")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun tools(): Optional<List<String>> = tools.getOptional("tools")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun transcripts(): Optional<VoiceAgentTranscripts> = transcripts.getOptional("transcripts")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun transferTargets(): Optional<List<VoiceAgentParty>> =
        transferTargets.getOptional("transfer_targets")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

    /**
     * Where the gateway dials the agent; null when the agent dials in with your API key.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun websocketUrl(): Optional<String> = websocketUrl.getOptional("websocket_url")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<VoiceAgentAudio> = audio

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [fallback].
     *
     * Unlike [fallback], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fallback") @ExcludeMissing fun _fallback(): JsonField<VoiceAgentParty> = fallback

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
    @JsonProperty("limits") @ExcludeMissing fun _limits(): JsonField<VoiceAgentLimits> = limits

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
     * Returns the raw JSON value of [signingSecret].
     *
     * Unlike [signingSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("signing_secret")
    @ExcludeMissing
    fun _signingSecret(): JsonField<String> = signingSecret

    /**
     * Returns the raw JSON value of [speech].
     *
     * Unlike [speech], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("speech") @ExcludeMissing fun _speech(): JsonField<VoiceAgentSpeech> = speech

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
    fun _transcripts(): JsonField<VoiceAgentTranscripts> = transcripts

    /**
     * Returns the raw JSON value of [transferTargets].
     *
     * Unlike [transferTargets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transfer_targets")
    @ExcludeMissing
    fun _transferTargets(): JsonField<List<VoiceAgentParty>> = transferTargets

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [websocketUrl].
     *
     * Unlike [websocketUrl], this method doesn't throw if the JSON field has an unexpected type.
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

        /** Returns a mutable builder for constructing an instance of [VoiceAgent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceAgent]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var audio: JsonField<VoiceAgentAudio> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var fallback: JsonField<VoiceAgentParty> = JsonMissing.of()
        private var greeting: JsonField<String> = JsonMissing.of()
        private var limits: JsonField<VoiceAgentLimits> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var sessionType: JsonField<String> = JsonMissing.of()
        private var signingSecret: JsonField<String> = JsonMissing.of()
        private var speech: JsonField<VoiceAgentSpeech> = JsonMissing.of()
        private var tools: JsonField<MutableList<String>>? = null
        private var transcripts: JsonField<VoiceAgentTranscripts> = JsonMissing.of()
        private var transferTargets: JsonField<MutableList<VoiceAgentParty>>? = null
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var websocketUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceAgent: VoiceAgent) = apply {
            id = voiceAgent.id
            audio = voiceAgent.audio
            createdAt = voiceAgent.createdAt
            fallback = voiceAgent.fallback
            greeting = voiceAgent.greeting
            limits = voiceAgent.limits
            name = voiceAgent.name
            sessionType = voiceAgent.sessionType
            signingSecret = voiceAgent.signingSecret
            speech = voiceAgent.speech
            tools = voiceAgent.tools.map { it.toMutableList() }
            transcripts = voiceAgent.transcripts
            transferTargets = voiceAgent.transferTargets.map { it.toMutableList() }
            updatedAt = voiceAgent.updatedAt
            websocketUrl = voiceAgent.websocketUrl
            additionalProperties = voiceAgent.additionalProperties.toMutableMap()
        }

        /**
         * The agent's id, agent_ and a UUID. It is also what the agent connects to the gateway as.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Audio sessions: the sample rate in use. */
        fun audio(audio: VoiceAgentAudio?) = audio(JsonField.ofNullable(audio))

        /** Alias for calling [Builder.audio] with `audio.orElse(null)`. */
        fun audio(audio: Optional<VoiceAgentAudio>) = audio(audio.getOrNull())

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [VoiceAgentAudio] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun audio(audio: JsonField<VoiceAgentAudio>) = apply { this.audio = audio }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun fallback(fallback: VoiceAgentParty?) = fallback(JsonField.ofNullable(fallback))

        /** Alias for calling [Builder.fallback] with `fallback.orElse(null)`. */
        fun fallback(fallback: Optional<VoiceAgentParty>) = fallback(fallback.getOrNull())

        /**
         * Sets [Builder.fallback] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fallback] with a well-typed [VoiceAgentParty] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fallback(fallback: JsonField<VoiceAgentParty>) = apply { this.fallback = fallback }

        fun greeting(greeting: String?) = greeting(JsonField.ofNullable(greeting))

        /** Alias for calling [Builder.greeting] with `greeting.orElse(null)`. */
        fun greeting(greeting: Optional<String>) = greeting(greeting.getOrNull())

        /**
         * Sets [Builder.greeting] to an arbitrary JSON value.
         *
         * You should usually call [Builder.greeting] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun greeting(greeting: JsonField<String>) = apply { this.greeting = greeting }

        fun limits(limits: VoiceAgentLimits) = limits(JsonField.of(limits))

        /**
         * Sets [Builder.limits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limits] with a well-typed [VoiceAgentLimits] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun limits(limits: JsonField<VoiceAgentLimits>) = apply { this.limits = limits }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** text or audio. */
        fun sessionType(sessionType: String) = sessionType(JsonField.of(sessionType))

        /**
         * Sets [Builder.sessionType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionType(sessionType: JsonField<String>) = apply { this.sessionType = sessionType }

        /**
         * The whsec_ secret the gateway signs its handshake to websocket_url with. Present on
         * create and after a rotate-secret; absent on every other read. Store it now.
         */
        fun signingSecret(signingSecret: String?) =
            signingSecret(JsonField.ofNullable(signingSecret))

        /** Alias for calling [Builder.signingSecret] with `signingSecret.orElse(null)`. */
        fun signingSecret(signingSecret: Optional<String>) =
            signingSecret(signingSecret.getOrNull())

        /**
         * Sets [Builder.signingSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signingSecret] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signingSecret(signingSecret: JsonField<String>) = apply {
            this.signingSecret = signingSecret
        }

        /** Text sessions: the speech setting, voice and language in use. */
        fun speech(speech: VoiceAgentSpeech?) = speech(JsonField.ofNullable(speech))

        /** Alias for calling [Builder.speech] with `speech.orElse(null)`. */
        fun speech(speech: Optional<VoiceAgentSpeech>) = speech(speech.getOrNull())

        /**
         * Sets [Builder.speech] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speech] with a well-typed [VoiceAgentSpeech] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun speech(speech: JsonField<VoiceAgentSpeech>) = apply { this.speech = speech }

        fun tools(tools: List<String>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        fun transcripts(transcripts: VoiceAgentTranscripts) = transcripts(JsonField.of(transcripts))

        /**
         * Sets [Builder.transcripts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transcripts] with a well-typed [VoiceAgentTranscripts]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun transcripts(transcripts: JsonField<VoiceAgentTranscripts>) = apply {
            this.transcripts = transcripts
        }

        fun transferTargets(transferTargets: List<VoiceAgentParty>) =
            transferTargets(JsonField.of(transferTargets))

        /**
         * Sets [Builder.transferTargets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transferTargets] with a well-typed
         * `List<VoiceAgentParty>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun transferTargets(transferTargets: JsonField<List<VoiceAgentParty>>) = apply {
            this.transferTargets = transferTargets.map { it.toMutableList() }
        }

        /**
         * Adds a single [VoiceAgentParty] to [transferTargets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTransferTarget(transferTarget: VoiceAgentParty) = apply {
            transferTargets =
                (transferTargets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("transferTargets", it).add(transferTarget)
                }
        }

        fun updatedAt(updatedAt: OffsetDateTime?) = updatedAt(JsonField.ofNullable(updatedAt))

        /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
        fun updatedAt(updatedAt: Optional<OffsetDateTime>) = updatedAt(updatedAt.getOrNull())

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** Where the gateway dials the agent; null when the agent dials in with your API key. */
        fun websocketUrl(websocketUrl: String?) = websocketUrl(JsonField.ofNullable(websocketUrl))

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
         * Returns an immutable instance of [VoiceAgent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceAgent =
            VoiceAgent(
                id,
                audio,
                createdAt,
                fallback,
                greeting,
                limits,
                name,
                sessionType,
                signingSecret,
                speech,
                (tools ?: JsonMissing.of()).map { it.toImmutable() },
                transcripts,
                (transferTargets ?: JsonMissing.of()).map { it.toImmutable() },
                updatedAt,
                websocketUrl,
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
    fun validate(): VoiceAgent = apply {
        if (validated) {
            return@apply
        }

        id()
        audio().ifPresent { it.validate() }
        createdAt()
        fallback().ifPresent { it.validate() }
        greeting()
        limits().ifPresent { it.validate() }
        name()
        sessionType()
        signingSecret()
        speech().ifPresent { it.validate() }
        tools()
        transcripts().ifPresent { it.validate() }
        transferTargets().ifPresent { it.forEach { it.validate() } }
        updatedAt()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (fallback.asKnown().getOrNull()?.validity() ?: 0) +
            (if (greeting.asKnown().isPresent) 1 else 0) +
            (limits.asKnown().getOrNull()?.validity() ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (sessionType.asKnown().isPresent) 1 else 0) +
            (if (signingSecret.asKnown().isPresent) 1 else 0) +
            (speech.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.size ?: 0) +
            (transcripts.asKnown().getOrNull()?.validity() ?: 0) +
            (transferTargets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (websocketUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceAgent &&
            id == other.id &&
            audio == other.audio &&
            createdAt == other.createdAt &&
            fallback == other.fallback &&
            greeting == other.greeting &&
            limits == other.limits &&
            name == other.name &&
            sessionType == other.sessionType &&
            signingSecret == other.signingSecret &&
            speech == other.speech &&
            tools == other.tools &&
            transcripts == other.transcripts &&
            transferTargets == other.transferTargets &&
            updatedAt == other.updatedAt &&
            websocketUrl == other.websocketUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            audio,
            createdAt,
            fallback,
            greeting,
            limits,
            name,
            sessionType,
            signingSecret,
            speech,
            tools,
            transcripts,
            transferTargets,
            updatedAt,
            websocketUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceAgent{id=$id, audio=$audio, createdAt=$createdAt, fallback=$fallback, greeting=$greeting, limits=$limits, name=$name, sessionType=$sessionType, signingSecret=$signingSecret, speech=$speech, tools=$tools, transcripts=$transcripts, transferTargets=$transferTargets, updatedAt=$updatedAt, websocketUrl=$websocketUrl, additionalProperties=$additionalProperties}"
}
