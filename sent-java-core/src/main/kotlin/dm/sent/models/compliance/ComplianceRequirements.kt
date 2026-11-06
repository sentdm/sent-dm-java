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

/** Everything a market expects of a sender, for one channel, country and sender type. */
class ComplianceRequirements
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val channel: JsonField<String>,
    private val country: JsonField<String>,
    private val required: JsonField<Boolean>,
    private val requirements: JsonField<List<ComplianceRequirement>>,
    private val senderIdPattern: JsonField<String>,
    private val setup: JsonField<List<ComplianceSetupStep>>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("required") @ExcludeMissing required: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("requirements")
        @ExcludeMissing
        requirements: JsonField<List<ComplianceRequirement>> = JsonMissing.of(),
        @JsonProperty("sender_id_pattern")
        @ExcludeMissing
        senderIdPattern: JsonField<String> = JsonMissing.of(),
        @JsonProperty("setup")
        @ExcludeMissing
        setup: JsonField<List<ComplianceSetupStep>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(channel, country, required, requirements, senderIdPattern, setup, type, mutableMapOf())

    /**
     * Channel the requirements apply to — sms, whatsapp or rcs.
     *
     * Echoed so the document says which channel it describes. It always described one: setup's last
     * step is a specific channel path, and every type is an SMS sender type — but a caller reading
     * the payload had to infer that from the path to know it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * ISO 3166-1 alpha-2 country the requirements apply to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun country(): Optional<String> = country.getOptional("country")

    /**
     * Whether this market demands anything before a sender can be registered. When false, the
     * compliance array may be omitted entirely and the profile is ready once provisioned.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun required(): Optional<Boolean> = required.getOptional("required")

    /**
     * Values to supply in compliance. Empty when the market demands nothing. Values Sent supplies
     * on your behalf are never listed, and neither are ones it derives from what you send.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun requirements(): Optional<List<ComplianceRequirement>> =
        requirements.getOptional("requirements")

    /**
     * Pattern the sender's own value must match, where the market dictates one — alphanumeric
     * sender ids and short codes. Null when the value is carrier-assigned.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderIdPattern(): Optional<String> = senderIdPattern.getOptional("sender_id_pattern")

    /**
     * The calls that set this market up, in the order they have to be made, each carrying a body
     * that can be sent as it stands.
     *
     * This is the answer to "what do I actually do". Requirements describes each value the market
     * wants; this assembles those descriptions into the requests that supply them, so a caller — or
     * an agent acting for one — copies a body out and sends it rather than building one from a
     * table.
     *
     * The last step is always the channel itself, and it is where the regime's own values are
     * supplied. The one before it, where there is one, is the brand a registering market files
     * against — so it is a step of its own and the channel call refuses until it exists. A market
     * that registers with nobody has one step.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun setup(): Optional<List<ComplianceSetupStep>> = setup.getOptional("setup")

    /**
     * Sender type the requirements apply to.
     *
     * Non-nullable while sms is the only channel answered here, because it is the only channel
     * whose senders have a type — the day another one is answered, this becomes nullable along with
     * it. Not nullable in advance: nothing can emit null today, and publishing a shape the API
     * never sends is the same mistake as publishing a field it does not have.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

    /**
     * Returns the raw JSON value of [required].
     *
     * Unlike [required], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required") @ExcludeMissing fun _required(): JsonField<Boolean> = required

    /**
     * Returns the raw JSON value of [requirements].
     *
     * Unlike [requirements], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requirements")
    @ExcludeMissing
    fun _requirements(): JsonField<List<ComplianceRequirement>> = requirements

    /**
     * Returns the raw JSON value of [senderIdPattern].
     *
     * Unlike [senderIdPattern], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_id_pattern")
    @ExcludeMissing
    fun _senderIdPattern(): JsonField<String> = senderIdPattern

    /**
     * Returns the raw JSON value of [setup].
     *
     * Unlike [setup], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("setup")
    @ExcludeMissing
    fun _setup(): JsonField<List<ComplianceSetupStep>> = setup

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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

        /** Returns a mutable builder for constructing an instance of [ComplianceRequirements]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComplianceRequirements]. */
    class Builder internal constructor() {

        private var channel: JsonField<String> = JsonMissing.of()
        private var country: JsonField<String> = JsonMissing.of()
        private var required: JsonField<Boolean> = JsonMissing.of()
        private var requirements: JsonField<MutableList<ComplianceRequirement>>? = null
        private var senderIdPattern: JsonField<String> = JsonMissing.of()
        private var setup: JsonField<MutableList<ComplianceSetupStep>>? = null
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(complianceRequirements: ComplianceRequirements) = apply {
            channel = complianceRequirements.channel
            country = complianceRequirements.country
            required = complianceRequirements.required
            requirements = complianceRequirements.requirements.map { it.toMutableList() }
            senderIdPattern = complianceRequirements.senderIdPattern
            setup = complianceRequirements.setup.map { it.toMutableList() }
            type = complianceRequirements.type
            additionalProperties = complianceRequirements.additionalProperties.toMutableMap()
        }

        /**
         * Channel the requirements apply to — sms, whatsapp or rcs.
         *
         * Echoed so the document says which channel it describes. It always described one: setup's
         * last step is a specific channel path, and every type is an SMS sender type — but a caller
         * reading the payload had to infer that from the path to know it.
         */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** ISO 3166-1 alpha-2 country the requirements apply to. */
        fun country(country: String) = country(JsonField.of(country))

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<String>) = apply { this.country = country }

        /**
         * Whether this market demands anything before a sender can be registered. When false, the
         * compliance array may be omitted entirely and the profile is ready once provisioned.
         */
        fun required(required: Boolean) = required(JsonField.of(required))

        /**
         * Sets [Builder.required] to an arbitrary JSON value.
         *
         * You should usually call [Builder.required] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun required(required: JsonField<Boolean>) = apply { this.required = required }

        /**
         * Values to supply in compliance. Empty when the market demands nothing. Values Sent
         * supplies on your behalf are never listed, and neither are ones it derives from what you
         * send.
         */
        fun requirements(requirements: List<ComplianceRequirement>) =
            requirements(JsonField.of(requirements))

        /**
         * Sets [Builder.requirements] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requirements] with a well-typed
         * `List<ComplianceRequirement>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun requirements(requirements: JsonField<List<ComplianceRequirement>>) = apply {
            this.requirements = requirements.map { it.toMutableList() }
        }

        /**
         * Adds a single [ComplianceRequirement] to [requirements].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRequirement(requirement: ComplianceRequirement) = apply {
            requirements =
                (requirements ?: JsonField.of(mutableListOf())).also {
                    checkKnown("requirements", it).add(requirement)
                }
        }

        /**
         * Pattern the sender's own value must match, where the market dictates one — alphanumeric
         * sender ids and short codes. Null when the value is carrier-assigned.
         */
        fun senderIdPattern(senderIdPattern: String?) =
            senderIdPattern(JsonField.ofNullable(senderIdPattern))

        /** Alias for calling [Builder.senderIdPattern] with `senderIdPattern.orElse(null)`. */
        fun senderIdPattern(senderIdPattern: Optional<String>) =
            senderIdPattern(senderIdPattern.getOrNull())

        /**
         * Sets [Builder.senderIdPattern] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderIdPattern] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun senderIdPattern(senderIdPattern: JsonField<String>) = apply {
            this.senderIdPattern = senderIdPattern
        }

        /**
         * The calls that set this market up, in the order they have to be made, each carrying a
         * body that can be sent as it stands.
         *
         * This is the answer to "what do I actually do". Requirements describes each value the
         * market wants; this assembles those descriptions into the requests that supply them, so a
         * caller — or an agent acting for one — copies a body out and sends it rather than building
         * one from a table.
         *
         * The last step is always the channel itself, and it is where the regime's own values are
         * supplied. The one before it, where there is one, is the brand a registering market files
         * against — so it is a step of its own and the channel call refuses until it exists. A
         * market that registers with nobody has one step.
         */
        fun setup(setup: List<ComplianceSetupStep>) = setup(JsonField.of(setup))

        /**
         * Sets [Builder.setup] to an arbitrary JSON value.
         *
         * You should usually call [Builder.setup] with a well-typed `List<ComplianceSetupStep>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun setup(setup: JsonField<List<ComplianceSetupStep>>) = apply {
            this.setup = setup.map { it.toMutableList() }
        }

        /**
         * Adds a single [ComplianceSetupStep] to [Builder.setup].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSetup(setup: ComplianceSetupStep) = apply {
            this.setup =
                (this.setup ?: JsonField.of(mutableListOf())).also {
                    checkKnown("setup", it).add(setup)
                }
        }

        /**
         * Sender type the requirements apply to.
         *
         * Non-nullable while sms is the only channel answered here, because it is the only channel
         * whose senders have a type — the day another one is answered, this becomes nullable along
         * with it. Not nullable in advance: nothing can emit null today, and publishing a shape the
         * API never sends is the same mistake as publishing a field it does not have.
         */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

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
         * Returns an immutable instance of [ComplianceRequirements].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ComplianceRequirements =
            ComplianceRequirements(
                channel,
                country,
                required,
                (requirements ?: JsonMissing.of()).map { it.toImmutable() },
                senderIdPattern,
                (setup ?: JsonMissing.of()).map { it.toImmutable() },
                type,
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
    fun validate(): ComplianceRequirements = apply {
        if (validated) {
            return@apply
        }

        channel()
        country()
        required()
        requirements().ifPresent { it.forEach { it.validate() } }
        senderIdPattern()
        setup().ifPresent { it.forEach { it.validate() } }
        type()
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
        (if (channel.asKnown().isPresent) 1 else 0) +
            (if (country.asKnown().isPresent) 1 else 0) +
            (if (required.asKnown().isPresent) 1 else 0) +
            (requirements.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (senderIdPattern.asKnown().isPresent) 1 else 0) +
            (setup.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComplianceRequirements &&
            channel == other.channel &&
            country == other.country &&
            required == other.required &&
            requirements == other.requirements &&
            senderIdPattern == other.senderIdPattern &&
            setup == other.setup &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            channel,
            country,
            required,
            requirements,
            senderIdPattern,
            setup,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComplianceRequirements{channel=$channel, country=$country, required=$required, requirements=$requirements, senderIdPattern=$senderIdPattern, setup=$setup, type=$type, additionalProperties=$additionalProperties}"
}
