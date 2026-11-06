// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * One call to make, with a body that can be sent as it stands.
 *
 * The steps are ordered and the order is load-bearing: a channel that registers with a regime is
 * filed against a brand, so the brand call comes first and the channel call refuses until it has
 * been made. Doing them in order is the whole of setting a market up.
 */
class ComplianceSetupStep
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val attachments: JsonField<List<ComplianceAttachmentTemplate>>,
    private val body: JsonValue,
    private val method: JsonField<String>,
    private val path: JsonField<String>,
    private val resource: JsonField<String>,
    private val step: JsonField<Int>,
    private val why: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("attachments")
        @ExcludeMissing
        attachments: JsonField<List<ComplianceAttachmentTemplate>> = JsonMissing.of(),
        @JsonProperty("body") @ExcludeMissing body: JsonValue = JsonMissing.of(),
        @JsonProperty("method") @ExcludeMissing method: JsonField<String> = JsonMissing.of(),
        @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
        @JsonProperty("resource") @ExcludeMissing resource: JsonField<String> = JsonMissing.of(),
        @JsonProperty("step") @ExcludeMissing step: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("why") @ExcludeMissing why: JsonField<String> = JsonMissing.of(),
    ) : this(attachments, body, method, path, resource, step, why, mutableMapOf())

    /**
     * Files to attach as multipart, when this call takes any. Absent when it does not.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun attachments(): Optional<List<ComplianceAttachmentTemplate>> =
        attachments.getOptional("attachments")

    /**
     * The request body, with every key this market wants already present and the values left blank.
     * Send it as it stands and the response names each blank that still has to be filled.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = complianceSetupStep.body().convert(MyClass.class);
     * ```
     */
    @JsonProperty("body") @ExcludeMissing fun _body(): JsonValue = body

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun method(): Optional<String> = method.getOptional("method")

    /**
     * Path to call. Add the x-profile-id header with an organization key to make the same call for
     * one of your sender profiles — there is no separate path for that.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun path(): Optional<String> = path.getOptional("path")

    /**
     * What this call sets up: brand or channel.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun resource(): Optional<String> = resource.getOptional("resource")

    /**
     * Position in the sequence, from 1. Steps must be performed in this order.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun step(): Optional<Int> = step.getOptional("step")

    /**
     * Why this market needs this call, in one sentence.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun why(): Optional<String> = why.getOptional("why")

    /**
     * Returns the raw JSON value of [attachments].
     *
     * Unlike [attachments], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attachments")
    @ExcludeMissing
    fun _attachments(): JsonField<List<ComplianceAttachmentTemplate>> = attachments

    /**
     * Returns the raw JSON value of [method].
     *
     * Unlike [method], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<String> = method

    /**
     * Returns the raw JSON value of [path].
     *
     * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

    /**
     * Returns the raw JSON value of [resource].
     *
     * Unlike [resource], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("resource") @ExcludeMissing fun _resource(): JsonField<String> = resource

    /**
     * Returns the raw JSON value of [step].
     *
     * Unlike [step], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("step") @ExcludeMissing fun _step(): JsonField<Int> = step

    /**
     * Returns the raw JSON value of [why].
     *
     * Unlike [why], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("why") @ExcludeMissing fun _why(): JsonField<String> = why

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

        /** Returns a mutable builder for constructing an instance of [ComplianceSetupStep]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComplianceSetupStep]. */
    class Builder internal constructor() {

        private var attachments: JsonField<MutableList<ComplianceAttachmentTemplate>>? = null
        private var body: JsonValue = JsonMissing.of()
        private var method: JsonField<String> = JsonMissing.of()
        private var path: JsonField<String> = JsonMissing.of()
        private var resource: JsonField<String> = JsonMissing.of()
        private var step: JsonField<Int> = JsonMissing.of()
        private var why: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(complianceSetupStep: ComplianceSetupStep) = apply {
            attachments = complianceSetupStep.attachments.map { it.toMutableList() }
            body = complianceSetupStep.body
            method = complianceSetupStep.method
            path = complianceSetupStep.path
            resource = complianceSetupStep.resource
            step = complianceSetupStep.step
            why = complianceSetupStep.why
            additionalProperties = complianceSetupStep.additionalProperties.toMutableMap()
        }

        /** Files to attach as multipart, when this call takes any. Absent when it does not. */
        fun attachments(attachments: List<ComplianceAttachmentTemplate>?) =
            attachments(JsonField.ofNullable(attachments))

        /** Alias for calling [Builder.attachments] with `attachments.orElse(null)`. */
        fun attachments(attachments: Optional<List<ComplianceAttachmentTemplate>>) =
            attachments(attachments.getOrNull())

        /**
         * Sets [Builder.attachments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attachments] with a well-typed
         * `List<ComplianceAttachmentTemplate>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun attachments(attachments: JsonField<List<ComplianceAttachmentTemplate>>) = apply {
            this.attachments = attachments.map { it.toMutableList() }
        }

        /**
         * Adds a single [ComplianceAttachmentTemplate] to [attachments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAttachment(attachment: ComplianceAttachmentTemplate) = apply {
            attachments =
                (attachments ?: JsonField.of(mutableListOf())).also {
                    checkKnown("attachments", it).add(attachment)
                }
        }

        /**
         * The request body, with every key this market wants already present and the values left
         * blank. Send it as it stands and the response names each blank that still has to be
         * filled.
         */
        fun body(body: JsonValue) = apply { this.body = body }

        fun method(method: String) = method(JsonField.of(method))

        /**
         * Sets [Builder.method] to an arbitrary JSON value.
         *
         * You should usually call [Builder.method] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun method(method: JsonField<String>) = apply { this.method = method }

        /**
         * Path to call. Add the x-profile-id header with an organization key to make the same call
         * for one of your sender profiles — there is no separate path for that.
         */
        fun path(path: String) = path(JsonField.of(path))

        /**
         * Sets [Builder.path] to an arbitrary JSON value.
         *
         * You should usually call [Builder.path] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun path(path: JsonField<String>) = apply { this.path = path }

        /** What this call sets up: brand or channel. */
        fun resource(resource: String) = resource(JsonField.of(resource))

        /**
         * Sets [Builder.resource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resource] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun resource(resource: JsonField<String>) = apply { this.resource = resource }

        /** Position in the sequence, from 1. Steps must be performed in this order. */
        fun step(step: Int) = step(JsonField.of(step))

        /**
         * Sets [Builder.step] to an arbitrary JSON value.
         *
         * You should usually call [Builder.step] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun step(step: JsonField<Int>) = apply { this.step = step }

        /** Why this market needs this call, in one sentence. */
        fun why(why: String) = why(JsonField.of(why))

        /**
         * Sets [Builder.why] to an arbitrary JSON value.
         *
         * You should usually call [Builder.why] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun why(why: JsonField<String>) = apply { this.why = why }

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
         * Returns an immutable instance of [ComplianceSetupStep].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ComplianceSetupStep =
            ComplianceSetupStep(
                (attachments ?: JsonMissing.of()).map { it.toImmutable() },
                body,
                method,
                path,
                resource,
                step,
                why,
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
    fun validate(): ComplianceSetupStep = apply {
        if (validated) {
            return@apply
        }

        attachments().ifPresent { it.forEach { it.validate() } }
        method()
        path()
        resource()
        step()
        why()
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
        (attachments.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (method.asKnown().isPresent) 1 else 0) +
            (if (path.asKnown().isPresent) 1 else 0) +
            (if (resource.asKnown().isPresent) 1 else 0) +
            (if (step.asKnown().isPresent) 1 else 0) +
            (if (why.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComplianceSetupStep &&
            attachments == other.attachments &&
            body == other.body &&
            method == other.method &&
            path == other.path &&
            resource == other.resource &&
            step == other.step &&
            why == other.why &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(attachments, body, method, path, resource, step, why, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComplianceSetupStep{attachments=$attachments, body=$body, method=$method, path=$path, resource=$resource, step=$step, why=$why, additionalProperties=$additionalProperties}"
}
