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

/** Configuration for AUTHENTICATION category templates */
class SentDmServicesCommonContractsPocOsAuthenticationConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val addSecurityRecommendation: JsonField<Boolean>,
    private val codeExpirationMinutes: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("addSecurityRecommendation")
        @ExcludeMissing
        addSecurityRecommendation: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("codeExpirationMinutes")
        @ExcludeMissing
        codeExpirationMinutes: JsonField<Int> = JsonMissing.of(),
    ) : this(addSecurityRecommendation, codeExpirationMinutes, mutableMapOf())

    /**
     * Whether to add the security recommendation text: "For your security, do not share this code."
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addSecurityRecommendation(): Optional<Boolean> =
        addSecurityRecommendation.getOptional("addSecurityRecommendation")

    /**
     * Code expiration time in minutes (1-90). If set, adds footer: "This code expires in X
     * minutes."
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun codeExpirationMinutes(): Optional<Int> =
        codeExpirationMinutes.getOptional("codeExpirationMinutes")

    /**
     * Returns the raw JSON value of [addSecurityRecommendation].
     *
     * Unlike [addSecurityRecommendation], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("addSecurityRecommendation")
    @ExcludeMissing
    fun _addSecurityRecommendation(): JsonField<Boolean> = addSecurityRecommendation

    /**
     * Returns the raw JSON value of [codeExpirationMinutes].
     *
     * Unlike [codeExpirationMinutes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("codeExpirationMinutes")
    @ExcludeMissing
    fun _codeExpirationMinutes(): JsonField<Int> = codeExpirationMinutes

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
         * [SentDmServicesCommonContractsPocOsAuthenticationConfig].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SentDmServicesCommonContractsPocOsAuthenticationConfig]. */
    class Builder internal constructor() {

        private var addSecurityRecommendation: JsonField<Boolean> = JsonMissing.of()
        private var codeExpirationMinutes: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesCommonContractsPocOsAuthenticationConfig:
                SentDmServicesCommonContractsPocOsAuthenticationConfig
        ) = apply {
            addSecurityRecommendation =
                sentDmServicesCommonContractsPocOsAuthenticationConfig.addSecurityRecommendation
            codeExpirationMinutes =
                sentDmServicesCommonContractsPocOsAuthenticationConfig.codeExpirationMinutes
            additionalProperties =
                sentDmServicesCommonContractsPocOsAuthenticationConfig.additionalProperties
                    .toMutableMap()
        }

        /**
         * Whether to add the security recommendation text: "For your security, do not share this
         * code."
         */
        fun addSecurityRecommendation(addSecurityRecommendation: Boolean) =
            addSecurityRecommendation(JsonField.of(addSecurityRecommendation))

        /**
         * Sets [Builder.addSecurityRecommendation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addSecurityRecommendation] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun addSecurityRecommendation(addSecurityRecommendation: JsonField<Boolean>) = apply {
            this.addSecurityRecommendation = addSecurityRecommendation
        }

        /**
         * Code expiration time in minutes (1-90). If set, adds footer: "This code expires in X
         * minutes."
         */
        fun codeExpirationMinutes(codeExpirationMinutes: Int?) =
            codeExpirationMinutes(JsonField.ofNullable(codeExpirationMinutes))

        /**
         * Alias for [Builder.codeExpirationMinutes].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun codeExpirationMinutes(codeExpirationMinutes: Int) =
            codeExpirationMinutes(codeExpirationMinutes as Int?)

        /**
         * Alias for calling [Builder.codeExpirationMinutes] with
         * `codeExpirationMinutes.orElse(null)`.
         */
        fun codeExpirationMinutes(codeExpirationMinutes: Optional<Int>) =
            codeExpirationMinutes(codeExpirationMinutes.getOrNull())

        /**
         * Sets [Builder.codeExpirationMinutes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.codeExpirationMinutes] with a well-typed [Int] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun codeExpirationMinutes(codeExpirationMinutes: JsonField<Int>) = apply {
            this.codeExpirationMinutes = codeExpirationMinutes
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
         * Returns an immutable instance of
         * [SentDmServicesCommonContractsPocOsAuthenticationConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SentDmServicesCommonContractsPocOsAuthenticationConfig =
            SentDmServicesCommonContractsPocOsAuthenticationConfig(
                addSecurityRecommendation,
                codeExpirationMinutes,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesCommonContractsPocOsAuthenticationConfig = apply {
        if (validated) {
            return@apply
        }

        addSecurityRecommendation()
        codeExpirationMinutes()
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
        (if (addSecurityRecommendation.asKnown().isPresent) 1 else 0) +
            (if (codeExpirationMinutes.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SentDmServicesCommonContractsPocOsAuthenticationConfig &&
            addSecurityRecommendation == other.addSecurityRecommendation &&
            codeExpirationMinutes == other.codeExpirationMinutes &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(addSecurityRecommendation, codeExpirationMinutes, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesCommonContractsPocOsAuthenticationConfig{addSecurityRecommendation=$addSecurityRecommendation, codeExpirationMinutes=$codeExpirationMinutes, additionalProperties=$additionalProperties}"
}
