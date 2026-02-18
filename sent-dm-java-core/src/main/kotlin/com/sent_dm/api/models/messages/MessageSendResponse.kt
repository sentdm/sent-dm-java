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
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class MessageSendResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<ApiError>,
    private val meta: JsonField<ApiMeta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<ApiError> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<ApiMeta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * The response data (null if error)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error details (null if successful)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<ApiError> = error.getOptional("error")

    /**
     * Metadata about the request and response
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun meta(): Optional<ApiMeta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun success(): Optional<Boolean> = success.getOptional("success")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ApiError> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<ApiMeta> = meta

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

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

        /** Returns a mutable builder for constructing an instance of [MessageSendResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageSendResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<ApiError> = JsonMissing.of()
        private var meta: JsonField<ApiMeta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageSendResponse: MessageSendResponse) = apply {
            data = messageSendResponse.data
            error = messageSendResponse.error
            meta = messageSendResponse.meta
            success = messageSendResponse.success
            additionalProperties = messageSendResponse.additionalProperties.toMutableMap()
        }

        /** The response data (null if error) */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Error details (null if successful) */
        fun error(error: ApiError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ApiError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [ApiError] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<ApiError>) = apply { this.error = error }

        /** Metadata about the request and response */
        fun meta(meta: ApiMeta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [ApiMeta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<ApiMeta>) = apply { this.meta = meta }

        /** Indicates whether the request was successful */
        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

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
         * Returns an immutable instance of [MessageSendResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageSendResponse =
            MessageSendResponse(data, error, meta, success, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): MessageSendResponse = apply {
        if (validated) {
            return@apply
        }

        data().ifPresent { it.validate() }
        error().ifPresent { it.validate() }
        meta().ifPresent { it.validate() }
        success()
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    /** The response data (null if error) */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val body: JsonField<String>,
        private val recipients: JsonField<List<Recipient>>,
        private val status: JsonField<String>,
        private val templateId: JsonField<String>,
        private val templateName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recipients")
            @ExcludeMissing
            recipients: JsonField<List<Recipient>> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("template_id")
            @ExcludeMissing
            templateId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("template_name")
            @ExcludeMissing
            templateName: JsonField<String> = JsonMissing.of(),
        ) : this(body, recipients, status, templateId, templateName, mutableMapOf())

        /**
         * Resolved template body text
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun body(): Optional<String> = body.getOptional("body")

        /**
         * Per-recipient message results
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipients(): Optional<List<Recipient>> = recipients.getOptional("recipients")

        /**
         * Overall request status (e.g. "accepted")
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<String> = status.getOptional("status")

        /**
         * Template ID that was used
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun templateId(): Optional<String> = templateId.getOptional("template_id")

        /**
         * Template display name
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun templateName(): Optional<String> = templateName.getOptional("template_name")

        /**
         * Returns the raw JSON value of [body].
         *
         * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

        /**
         * Returns the raw JSON value of [recipients].
         *
         * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<Recipient>> = recipients

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

        /**
         * Returns the raw JSON value of [templateId].
         *
         * Unlike [templateId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("template_id")
        @ExcludeMissing
        fun _templateId(): JsonField<String> = templateId

        /**
         * Returns the raw JSON value of [templateName].
         *
         * Unlike [templateName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("template_name")
        @ExcludeMissing
        fun _templateName(): JsonField<String> = templateName

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var body: JsonField<String> = JsonMissing.of()
            private var recipients: JsonField<MutableList<Recipient>>? = null
            private var status: JsonField<String> = JsonMissing.of()
            private var templateId: JsonField<String> = JsonMissing.of()
            private var templateName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                body = data.body
                recipients = data.recipients.map { it.toMutableList() }
                status = data.status
                templateId = data.templateId
                templateName = data.templateName
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** Resolved template body text */
            fun body(body: String?) = body(JsonField.ofNullable(body))

            /** Alias for calling [Builder.body] with `body.orElse(null)`. */
            fun body(body: Optional<String>) = body(body.getOrNull())

            /**
             * Sets [Builder.body] to an arbitrary JSON value.
             *
             * You should usually call [Builder.body] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun body(body: JsonField<String>) = apply { this.body = body }

            /** Per-recipient message results */
            fun recipients(recipients: List<Recipient>) = recipients(JsonField.of(recipients))

            /**
             * Sets [Builder.recipients] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipients] with a well-typed `List<Recipient>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun recipients(recipients: JsonField<List<Recipient>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * Adds a single [Recipient] to [recipients].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipient(recipient: Recipient) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /** Overall request status (e.g. "accepted") */
            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            /** Template ID that was used */
            fun templateId(templateId: String) = templateId(JsonField.of(templateId))

            /**
             * Sets [Builder.templateId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.templateId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun templateId(templateId: JsonField<String>) = apply { this.templateId = templateId }

            /** Template display name */
            fun templateName(templateName: String) = templateName(JsonField.of(templateName))

            /**
             * Sets [Builder.templateName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.templateName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun templateName(templateName: JsonField<String>) = apply {
                this.templateName = templateName
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    body,
                    (recipients ?: JsonMissing.of()).map { it.toImmutable() },
                    status,
                    templateId,
                    templateName,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            body()
            recipients().ifPresent { it.forEach { it.validate() } }
            status()
            templateId()
            templateName()
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
            (if (body.asKnown().isPresent) 1 else 0) +
                (recipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (templateId.asKnown().isPresent) 1 else 0) +
                (if (templateName.asKnown().isPresent) 1 else 0)

        /** Per-recipient result in the send message response */
        class Recipient
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val channel: JsonField<String>,
            private val messageId: JsonField<String>,
            private val to: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("channel")
                @ExcludeMissing
                channel: JsonField<String> = JsonMissing.of(),
                @JsonProperty("message_id")
                @ExcludeMissing
                messageId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("to") @ExcludeMissing to: JsonField<String> = JsonMissing.of(),
            ) : this(channel, messageId, to, mutableMapOf())

            /**
             * Channel this message will be sent on (e.g. "sms", "whatsapp"), or null for
             * auto-detect
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun channel(): Optional<String> = channel.getOptional("channel")

            /**
             * Unique message identifier for tracking this recipient's message
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun messageId(): Optional<String> = messageId.getOptional("message_id")

            /**
             * Phone number in E.164 format
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun to(): Optional<String> = to.getOptional("to")

            /**
             * Returns the raw JSON value of [channel].
             *
             * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

            /**
             * Returns the raw JSON value of [messageId].
             *
             * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("message_id")
            @ExcludeMissing
            fun _messageId(): JsonField<String> = messageId

            /**
             * Returns the raw JSON value of [to].
             *
             * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<String> = to

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

                /** Returns a mutable builder for constructing an instance of [Recipient]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Recipient]. */
            class Builder internal constructor() {

                private var channel: JsonField<String> = JsonMissing.of()
                private var messageId: JsonField<String> = JsonMissing.of()
                private var to: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(recipient: Recipient) = apply {
                    channel = recipient.channel
                    messageId = recipient.messageId
                    to = recipient.to
                    additionalProperties = recipient.additionalProperties.toMutableMap()
                }

                /**
                 * Channel this message will be sent on (e.g. "sms", "whatsapp"), or null for
                 * auto-detect
                 */
                fun channel(channel: String?) = channel(JsonField.ofNullable(channel))

                /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
                fun channel(channel: Optional<String>) = channel(channel.getOrNull())

                /**
                 * Sets [Builder.channel] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.channel] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun channel(channel: JsonField<String>) = apply { this.channel = channel }

                /** Unique message identifier for tracking this recipient's message */
                fun messageId(messageId: String) = messageId(JsonField.of(messageId))

                /**
                 * Sets [Builder.messageId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.messageId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

                /** Phone number in E.164 format */
                fun to(to: String) = to(JsonField.of(to))

                /**
                 * Sets [Builder.to] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.to] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun to(to: JsonField<String>) = apply { this.to = to }

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
                 * Returns an immutable instance of [Recipient].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Recipient =
                    Recipient(channel, messageId, to, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Recipient = apply {
                if (validated) {
                    return@apply
                }

                channel()
                messageId()
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
                (if (channel.asKnown().isPresent) 1 else 0) +
                    (if (messageId.asKnown().isPresent) 1 else 0) +
                    (if (to.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Recipient &&
                    channel == other.channel &&
                    messageId == other.messageId &&
                    to == other.to &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(channel, messageId, to, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Recipient{channel=$channel, messageId=$messageId, to=$to, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                body == other.body &&
                recipients == other.recipients &&
                status == other.status &&
                templateId == other.templateId &&
                templateName == other.templateName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(body, recipients, status, templateId, templateName, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{body=$body, recipients=$recipients, status=$status, templateId=$templateId, templateName=$templateName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageSendResponse &&
            data == other.data &&
            error == other.error &&
            meta == other.meta &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, error, meta, success, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageSendResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
