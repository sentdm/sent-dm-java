// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.Params
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import com.sent_dm.api.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Sends a message to one or more recipients using a template. Supports multi-channel broadcast —
 * when multiple channels are specified (e.g. ["sms", "whatsapp"]), a separate message is created
 * for each (recipient, channel) pair. Returns immediately with per-recipient message IDs for async
 * tracking via webhooks or the GET /messages/{id} endpoint.
 */
class MessageSendParams
private constructor(
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    /**
     * Test mode flag - when true, the operation is simulated without side effects Useful for
     * testing integrations without actual execution
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun testMode(): Optional<Boolean> = body.testMode()

    /**
     * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate message
     * per recipient. "sent" = auto-detect, "rcs" = reserved (skipped). Defaults to ["sent"]
     * (auto-detect) if omitted.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channel(): Optional<List<String>> = body.channel()

    /**
     * Template reference (by id or name, with optional parameters)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun template(): Optional<Template> = body.template()

    /**
     * List of recipient phone numbers in E.164 format (multi-recipient fan-out)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun to(): Optional<List<String>> = body.to()

    /**
     * Returns the raw JSON value of [testMode].
     *
     * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _testMode(): JsonField<Boolean> = body._testMode()

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channel(): JsonField<List<String>> = body._channel()

    /**
     * Returns the raw JSON value of [template].
     *
     * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _template(): JsonField<Template> = body._template()

    /**
     * Returns the raw JSON value of [to].
     *
     * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _to(): JsonField<List<String>> = body._to()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): MessageSendParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [MessageSendParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageSendParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(messageSendParams: MessageSendParams) = apply {
            idempotencyKey = messageSendParams.idempotencyKey
            body = messageSendParams.body.toBuilder()
            additionalHeaders = messageSendParams.additionalHeaders.toBuilder()
            additionalQueryParams = messageSendParams.additionalQueryParams.toBuilder()
        }

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [testMode]
         * - [channel]
         * - [template]
         * - [to]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun testMode(testMode: Boolean) = apply { body.testMode(testMode) }

        /**
         * Sets [Builder.testMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun testMode(testMode: JsonField<Boolean>) = apply { body.testMode(testMode) }

        /**
         * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate
         * message per recipient. "sent" = auto-detect, "rcs" = reserved (skipped). Defaults to
         * ["sent"] (auto-detect) if omitted.
         */
        fun channel(channel: List<String>?) = apply { body.channel(channel) }

        /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
        fun channel(channel: Optional<List<String>>) = channel(channel.getOrNull())

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun channel(channel: JsonField<List<String>>) = apply { body.channel(channel) }

        /**
         * Adds a single [String] to [Builder.channel].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChannel(channel: String) = apply { body.addChannel(channel) }

        /** Template reference (by id or name, with optional parameters) */
        fun template(template: Template) = apply { body.template(template) }

        /**
         * Sets [Builder.template] to an arbitrary JSON value.
         *
         * You should usually call [Builder.template] with a well-typed [Template] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun template(template: JsonField<Template>) = apply { body.template(template) }

        /** List of recipient phone numbers in E.164 format (multi-recipient fan-out) */
        fun to(to: List<String>) = apply { body.to(to) }

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed `List<String>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<List<String>>) = apply { body.to(to) }

        /**
         * Adds a single [String] to [Builder.to].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTo(to: String) = apply { body.addTo(to) }

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
         * Returns an immutable instance of [MessageSendParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageSendParams =
            MessageSendParams(
                idempotencyKey,
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
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Request to send a message (v3 SDK-style with multi-recipient and multi-channel broadcast) */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val testMode: JsonField<Boolean>,
        private val channel: JsonField<List<String>>,
        private val template: JsonField<Template>,
        private val to: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("test_mode")
            @ExcludeMissing
            testMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("channel")
            @ExcludeMissing
            channel: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("template")
            @ExcludeMissing
            template: JsonField<Template> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<List<String>> = JsonMissing.of(),
        ) : this(testMode, channel, template, to, mutableMapOf())

        fun toMutationRequest(): MutationRequest =
            MutationRequest.builder().testMode(testMode).build()

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun testMode(): Optional<Boolean> = testMode.getOptional("test_mode")

        /**
         * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate
         * message per recipient. "sent" = auto-detect, "rcs" = reserved (skipped). Defaults to
         * ["sent"] (auto-detect) if omitted.
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channel(): Optional<List<String>> = channel.getOptional("channel")

        /**
         * Template reference (by id or name, with optional parameters)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun template(): Optional<Template> = template.getOptional("template")

        /**
         * List of recipient phone numbers in E.164 format (multi-recipient fan-out)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun to(): Optional<List<String>> = to.getOptional("to")

        /**
         * Returns the raw JSON value of [testMode].
         *
         * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("test_mode") @ExcludeMissing fun _testMode(): JsonField<Boolean> = testMode

        /**
         * Returns the raw JSON value of [channel].
         *
         * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<List<String>> = channel

        /**
         * Returns the raw JSON value of [template].
         *
         * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<Template> = template

        /**
         * Returns the raw JSON value of [to].
         *
         * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<List<String>> = to

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

            private var testMode: JsonField<Boolean> = JsonMissing.of()
            private var channel: JsonField<MutableList<String>>? = null
            private var template: JsonField<Template> = JsonMissing.of()
            private var to: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                testMode = body.testMode
                channel = body.channel.map { it.toMutableList() }
                template = body.template
                to = body.to.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Test mode flag - when true, the operation is simulated without side effects Useful
             * for testing integrations without actual execution
             */
            fun testMode(testMode: Boolean) = testMode(JsonField.of(testMode))

            /**
             * Sets [Builder.testMode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun testMode(testMode: JsonField<Boolean>) = apply { this.testMode = testMode }

            /**
             * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate
             * message per recipient. "sent" = auto-detect, "rcs" = reserved (skipped). Defaults to
             * ["sent"] (auto-detect) if omitted.
             */
            fun channel(channel: List<String>?) = channel(JsonField.ofNullable(channel))

            /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
            fun channel(channel: Optional<List<String>>) = channel(channel.getOrNull())

            /**
             * Sets [Builder.channel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channel] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channel(channel: JsonField<List<String>>) = apply {
                this.channel = channel.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.channel].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addChannel(channel: String) = apply {
                this.channel =
                    (this.channel ?: JsonField.of(mutableListOf())).also {
                        checkKnown("channel", it).add(channel)
                    }
            }

            /** Template reference (by id or name, with optional parameters) */
            fun template(template: Template) = template(JsonField.of(template))

            /**
             * Sets [Builder.template] to an arbitrary JSON value.
             *
             * You should usually call [Builder.template] with a well-typed [Template] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun template(template: JsonField<Template>) = apply { this.template = template }

            /** List of recipient phone numbers in E.164 format (multi-recipient fan-out) */
            fun to(to: List<String>) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed `List<String>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun to(to: JsonField<List<String>>) = apply { this.to = to.map { it.toMutableList() } }

            /**
             * Adds a single [String] to [Builder.to].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTo(to: String) = apply {
                this.to =
                    (this.to ?: JsonField.of(mutableListOf())).also { checkKnown("to", it).add(to) }
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
                    testMode,
                    (channel ?: JsonMissing.of()).map { it.toImmutable() },
                    template,
                    (to ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            testMode()
            channel()
            template().ifPresent { it.validate() }
            to()
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
            (if (testMode.asKnown().isPresent) 1 else 0) +
                (channel.asKnown().getOrNull()?.size ?: 0) +
                (template.asKnown().getOrNull()?.validity() ?: 0) +
                (to.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                testMode == other.testMode &&
                channel == other.channel &&
                template == other.template &&
                to == other.to &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(testMode, channel, template, to, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{testMode=$testMode, channel=$channel, template=$template, to=$to, additionalProperties=$additionalProperties}"
    }

    /** Template reference (by id or name, with optional parameters) */
    class Template
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val parameters: JsonField<Parameters>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parameters")
            @ExcludeMissing
            parameters: JsonField<Parameters> = JsonMissing.of(),
        ) : this(id, name, parameters, mutableMapOf())

        /**
         * Template ID (mutually exclusive with name)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Template name (mutually exclusive with id)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Template variable parameters for personalization
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun parameters(): Optional<Parameters> = parameters.getOptional("parameters")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [parameters].
         *
         * Unlike [parameters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parameters")
        @ExcludeMissing
        fun _parameters(): JsonField<Parameters> = parameters

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

            /** Returns a mutable builder for constructing an instance of [Template]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Template]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var parameters: JsonField<Parameters> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(template: Template) = apply {
                id = template.id
                name = template.name
                parameters = template.parameters
                additionalProperties = template.additionalProperties.toMutableMap()
            }

            /** Template ID (mutually exclusive with name) */
            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Template name (mutually exclusive with id) */
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

            /** Template variable parameters for personalization */
            fun parameters(parameters: Parameters?) = parameters(JsonField.ofNullable(parameters))

            /** Alias for calling [Builder.parameters] with `parameters.orElse(null)`. */
            fun parameters(parameters: Optional<Parameters>) = parameters(parameters.getOrNull())

            /**
             * Sets [Builder.parameters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.parameters] with a well-typed [Parameters] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun parameters(parameters: JsonField<Parameters>) = apply {
                this.parameters = parameters
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
             * Returns an immutable instance of [Template].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Template =
                Template(id, name, parameters, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Template = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
            parameters().ifPresent { it.validate() }
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
                (if (name.asKnown().isPresent) 1 else 0) +
                (parameters.asKnown().getOrNull()?.validity() ?: 0)

        /** Template variable parameters for personalization */
        class Parameters
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Parameters]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Parameters]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(parameters: Parameters) = apply {
                    additionalProperties = parameters.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Parameters].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Parameters = Parameters(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Parameters = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Parameters && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Parameters{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Template &&
                id == other.id &&
                name == other.name &&
                parameters == other.parameters &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, name, parameters, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Template{id=$id, name=$name, parameters=$parameters, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageSendParams &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MessageSendParams{idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
