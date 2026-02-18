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
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Body section of a message template with channel-specific content */
class SentDmServicesCommonContractsPocOsTemplateBody
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val multiChannel: JsonField<TemplateBodyContent>,
    private val sms: JsonField<TemplateBodyContent>,
    private val whatsapp: JsonField<TemplateBodyContent>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("multiChannel")
        @ExcludeMissing
        multiChannel: JsonField<TemplateBodyContent> = JsonMissing.of(),
        @JsonProperty("sms") @ExcludeMissing sms: JsonField<TemplateBodyContent> = JsonMissing.of(),
        @JsonProperty("whatsapp")
        @ExcludeMissing
        whatsapp: JsonField<TemplateBodyContent> = JsonMissing.of(),
    ) : this(multiChannel, sms, whatsapp, mutableMapOf())

    /**
     * Content that will be used for all channels (SMS and WhatsApp) unless channel-specific content
     * is provided
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun multiChannel(): Optional<TemplateBodyContent> = multiChannel.getOptional("multiChannel")

    /**
     * SMS-specific content that overrides multi-channel content for SMS messages
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sms(): Optional<TemplateBodyContent> = sms.getOptional("sms")

    /**
     * WhatsApp-specific content that overrides multi-channel content for WhatsApp messages
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun whatsapp(): Optional<TemplateBodyContent> = whatsapp.getOptional("whatsapp")

    /**
     * Returns the raw JSON value of [multiChannel].
     *
     * Unlike [multiChannel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("multiChannel")
    @ExcludeMissing
    fun _multiChannel(): JsonField<TemplateBodyContent> = multiChannel

    /**
     * Returns the raw JSON value of [sms].
     *
     * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<TemplateBodyContent> = sms

    /**
     * Returns the raw JSON value of [whatsapp].
     *
     * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("whatsapp")
    @ExcludeMissing
    fun _whatsapp(): JsonField<TemplateBodyContent> = whatsapp

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
         * [SentDmServicesCommonContractsPocOsTemplateBody].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SentDmServicesCommonContractsPocOsTemplateBody]. */
    class Builder internal constructor() {

        private var multiChannel: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var sms: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var whatsapp: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesCommonContractsPocOsTemplateBody:
                SentDmServicesCommonContractsPocOsTemplateBody
        ) = apply {
            multiChannel = sentDmServicesCommonContractsPocOsTemplateBody.multiChannel
            sms = sentDmServicesCommonContractsPocOsTemplateBody.sms
            whatsapp = sentDmServicesCommonContractsPocOsTemplateBody.whatsapp
            additionalProperties =
                sentDmServicesCommonContractsPocOsTemplateBody.additionalProperties.toMutableMap()
        }

        /**
         * Content that will be used for all channels (SMS and WhatsApp) unless channel-specific
         * content is provided
         */
        fun multiChannel(multiChannel: TemplateBodyContent?) =
            multiChannel(JsonField.ofNullable(multiChannel))

        /** Alias for calling [Builder.multiChannel] with `multiChannel.orElse(null)`. */
        fun multiChannel(multiChannel: Optional<TemplateBodyContent>) =
            multiChannel(multiChannel.getOrNull())

        /**
         * Sets [Builder.multiChannel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.multiChannel] with a well-typed [TemplateBodyContent]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun multiChannel(multiChannel: JsonField<TemplateBodyContent>) = apply {
            this.multiChannel = multiChannel
        }

        /** SMS-specific content that overrides multi-channel content for SMS messages */
        fun sms(sms: TemplateBodyContent?) = sms(JsonField.ofNullable(sms))

        /** Alias for calling [Builder.sms] with `sms.orElse(null)`. */
        fun sms(sms: Optional<TemplateBodyContent>) = sms(sms.getOrNull())

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed [TemplateBodyContent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sms(sms: JsonField<TemplateBodyContent>) = apply { this.sms = sms }

        /** WhatsApp-specific content that overrides multi-channel content for WhatsApp messages */
        fun whatsapp(whatsapp: TemplateBodyContent?) = whatsapp(JsonField.ofNullable(whatsapp))

        /** Alias for calling [Builder.whatsapp] with `whatsapp.orElse(null)`. */
        fun whatsapp(whatsapp: Optional<TemplateBodyContent>) = whatsapp(whatsapp.getOrNull())

        /**
         * Sets [Builder.whatsapp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsapp] with a well-typed [TemplateBodyContent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun whatsapp(whatsapp: JsonField<TemplateBodyContent>) = apply { this.whatsapp = whatsapp }

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
         * Returns an immutable instance of [SentDmServicesCommonContractsPocOsTemplateBody].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SentDmServicesCommonContractsPocOsTemplateBody =
            SentDmServicesCommonContractsPocOsTemplateBody(
                multiChannel,
                sms,
                whatsapp,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesCommonContractsPocOsTemplateBody = apply {
        if (validated) {
            return@apply
        }

        multiChannel().ifPresent { it.validate() }
        sms().ifPresent { it.validate() }
        whatsapp().ifPresent { it.validate() }
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
        (multiChannel.asKnown().getOrNull()?.validity() ?: 0) +
            (sms.asKnown().getOrNull()?.validity() ?: 0) +
            (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SentDmServicesCommonContractsPocOsTemplateBody &&
            multiChannel == other.multiChannel &&
            sms == other.sms &&
            whatsapp == other.whatsapp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(multiChannel, sms, whatsapp, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesCommonContractsPocOsTemplateBody{multiChannel=$multiChannel, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
}
