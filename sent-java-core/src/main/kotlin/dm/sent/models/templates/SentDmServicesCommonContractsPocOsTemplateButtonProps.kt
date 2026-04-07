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
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class SentDmServicesCommonContractsPocOsTemplateButtonProps
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val activeFor: JsonField<Int>,
    private val countryCode: JsonField<String>,
    private val offerCode: JsonField<String>,
    private val phoneNumber: JsonField<String>,
    private val quickReplyType: JsonField<String>,
    private val text: JsonField<String>,
    private val url: JsonField<String>,
    private val urlType: JsonField<String>,
    private val autofillText: JsonField<String>,
    private val otpType: JsonField<String>,
    private val packageName: JsonField<String>,
    private val signatureHash: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("activeFor") @ExcludeMissing activeFor: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("countryCode")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("offerCode") @ExcludeMissing offerCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phoneNumber")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quickReplyType")
        @ExcludeMissing
        quickReplyType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("urlType") @ExcludeMissing urlType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("autofillText")
        @ExcludeMissing
        autofillText: JsonField<String> = JsonMissing.of(),
        @JsonProperty("otpType") @ExcludeMissing otpType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("packageName")
        @ExcludeMissing
        packageName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("signatureHash")
        @ExcludeMissing
        signatureHash: JsonField<String> = JsonMissing.of(),
    ) : this(
        activeFor,
        countryCode,
        offerCode,
        phoneNumber,
        quickReplyType,
        text,
        url,
        urlType,
        autofillText,
        otpType,
        packageName,
        signatureHash,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun activeFor(): Int = activeFor.getRequired("activeFor")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun countryCode(): String = countryCode.getRequired("countryCode")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun offerCode(): String = offerCode.getRequired("offerCode")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun phoneNumber(): String = phoneNumber.getRequired("phoneNumber")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quickReplyType(): String = quickReplyType.getRequired("quickReplyType")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = url.getRequired("url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun urlType(): String = urlType.getRequired("urlType")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun autofillText(): Optional<String> = autofillText.getOptional("autofillText")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun otpType(): Optional<String> = otpType.getOptional("otpType")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun packageName(): Optional<String> = packageName.getOptional("packageName")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun signatureHash(): Optional<String> = signatureHash.getOptional("signatureHash")

    /**
     * Returns the raw JSON value of [activeFor].
     *
     * Unlike [activeFor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("activeFor") @ExcludeMissing fun _activeFor(): JsonField<Int> = activeFor

    /**
     * Returns the raw JSON value of [countryCode].
     *
     * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("countryCode") @ExcludeMissing fun _countryCode(): JsonField<String> = countryCode

    /**
     * Returns the raw JSON value of [offerCode].
     *
     * Unlike [offerCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("offerCode") @ExcludeMissing fun _offerCode(): JsonField<String> = offerCode

    /**
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phoneNumber") @ExcludeMissing fun _phoneNumber(): JsonField<String> = phoneNumber

    /**
     * Returns the raw JSON value of [quickReplyType].
     *
     * Unlike [quickReplyType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quickReplyType")
    @ExcludeMissing
    fun _quickReplyType(): JsonField<String> = quickReplyType

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /**
     * Returns the raw JSON value of [urlType].
     *
     * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

    /**
     * Returns the raw JSON value of [autofillText].
     *
     * Unlike [autofillText], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("autofillText")
    @ExcludeMissing
    fun _autofillText(): JsonField<String> = autofillText

    /**
     * Returns the raw JSON value of [otpType].
     *
     * Unlike [otpType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("otpType") @ExcludeMissing fun _otpType(): JsonField<String> = otpType

    /**
     * Returns the raw JSON value of [packageName].
     *
     * Unlike [packageName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("packageName") @ExcludeMissing fun _packageName(): JsonField<String> = packageName

    /**
     * Returns the raw JSON value of [signatureHash].
     *
     * Unlike [signatureHash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("signatureHash")
    @ExcludeMissing
    fun _signatureHash(): JsonField<String> = signatureHash

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
         * [SentDmServicesCommonContractsPocOsTemplateButtonProps].
         *
         * The following fields are required:
         * ```java
         * .activeFor()
         * .countryCode()
         * .offerCode()
         * .phoneNumber()
         * .quickReplyType()
         * .text()
         * .url()
         * .urlType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SentDmServicesCommonContractsPocOsTemplateButtonProps]. */
    class Builder internal constructor() {

        private var activeFor: JsonField<Int>? = null
        private var countryCode: JsonField<String>? = null
        private var offerCode: JsonField<String>? = null
        private var phoneNumber: JsonField<String>? = null
        private var quickReplyType: JsonField<String>? = null
        private var text: JsonField<String>? = null
        private var url: JsonField<String>? = null
        private var urlType: JsonField<String>? = null
        private var autofillText: JsonField<String> = JsonMissing.of()
        private var otpType: JsonField<String> = JsonMissing.of()
        private var packageName: JsonField<String> = JsonMissing.of()
        private var signatureHash: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesCommonContractsPocOsTemplateButtonProps:
                SentDmServicesCommonContractsPocOsTemplateButtonProps
        ) = apply {
            activeFor = sentDmServicesCommonContractsPocOsTemplateButtonProps.activeFor
            countryCode = sentDmServicesCommonContractsPocOsTemplateButtonProps.countryCode
            offerCode = sentDmServicesCommonContractsPocOsTemplateButtonProps.offerCode
            phoneNumber = sentDmServicesCommonContractsPocOsTemplateButtonProps.phoneNumber
            quickReplyType = sentDmServicesCommonContractsPocOsTemplateButtonProps.quickReplyType
            text = sentDmServicesCommonContractsPocOsTemplateButtonProps.text
            url = sentDmServicesCommonContractsPocOsTemplateButtonProps.url
            urlType = sentDmServicesCommonContractsPocOsTemplateButtonProps.urlType
            autofillText = sentDmServicesCommonContractsPocOsTemplateButtonProps.autofillText
            otpType = sentDmServicesCommonContractsPocOsTemplateButtonProps.otpType
            packageName = sentDmServicesCommonContractsPocOsTemplateButtonProps.packageName
            signatureHash = sentDmServicesCommonContractsPocOsTemplateButtonProps.signatureHash
            additionalProperties =
                sentDmServicesCommonContractsPocOsTemplateButtonProps.additionalProperties
                    .toMutableMap()
        }

        fun activeFor(activeFor: Int) = activeFor(JsonField.of(activeFor))

        /**
         * Sets [Builder.activeFor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.activeFor] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun activeFor(activeFor: JsonField<Int>) = apply { this.activeFor = activeFor }

        fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

        /**
         * Sets [Builder.countryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryCode(countryCode: JsonField<String>) = apply { this.countryCode = countryCode }

        fun offerCode(offerCode: String) = offerCode(JsonField.of(offerCode))

        /**
         * Sets [Builder.offerCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.offerCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun offerCode(offerCode: JsonField<String>) = apply { this.offerCode = offerCode }

        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        fun quickReplyType(quickReplyType: String) = quickReplyType(JsonField.of(quickReplyType))

        /**
         * Sets [Builder.quickReplyType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quickReplyType] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun quickReplyType(quickReplyType: JsonField<String>) = apply {
            this.quickReplyType = quickReplyType
        }

        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        fun urlType(urlType: String) = urlType(JsonField.of(urlType))

        /**
         * Sets [Builder.urlType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

        fun autofillText(autofillText: String?) = autofillText(JsonField.ofNullable(autofillText))

        /** Alias for calling [Builder.autofillText] with `autofillText.orElse(null)`. */
        fun autofillText(autofillText: Optional<String>) = autofillText(autofillText.getOrNull())

        /**
         * Sets [Builder.autofillText] to an arbitrary JSON value.
         *
         * You should usually call [Builder.autofillText] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun autofillText(autofillText: JsonField<String>) = apply {
            this.autofillText = autofillText
        }

        fun otpType(otpType: String?) = otpType(JsonField.ofNullable(otpType))

        /** Alias for calling [Builder.otpType] with `otpType.orElse(null)`. */
        fun otpType(otpType: Optional<String>) = otpType(otpType.getOrNull())

        /**
         * Sets [Builder.otpType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.otpType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun otpType(otpType: JsonField<String>) = apply { this.otpType = otpType }

        fun packageName(packageName: String?) = packageName(JsonField.ofNullable(packageName))

        /** Alias for calling [Builder.packageName] with `packageName.orElse(null)`. */
        fun packageName(packageName: Optional<String>) = packageName(packageName.getOrNull())

        /**
         * Sets [Builder.packageName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.packageName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun packageName(packageName: JsonField<String>) = apply { this.packageName = packageName }

        fun signatureHash(signatureHash: String?) =
            signatureHash(JsonField.ofNullable(signatureHash))

        /** Alias for calling [Builder.signatureHash] with `signatureHash.orElse(null)`. */
        fun signatureHash(signatureHash: Optional<String>) =
            signatureHash(signatureHash.getOrNull())

        /**
         * Sets [Builder.signatureHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signatureHash] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signatureHash(signatureHash: JsonField<String>) = apply {
            this.signatureHash = signatureHash
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
         * Returns an immutable instance of [SentDmServicesCommonContractsPocOsTemplateButtonProps].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .activeFor()
         * .countryCode()
         * .offerCode()
         * .phoneNumber()
         * .quickReplyType()
         * .text()
         * .url()
         * .urlType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SentDmServicesCommonContractsPocOsTemplateButtonProps =
            SentDmServicesCommonContractsPocOsTemplateButtonProps(
                checkRequired("activeFor", activeFor),
                checkRequired("countryCode", countryCode),
                checkRequired("offerCode", offerCode),
                checkRequired("phoneNumber", phoneNumber),
                checkRequired("quickReplyType", quickReplyType),
                checkRequired("text", text),
                checkRequired("url", url),
                checkRequired("urlType", urlType),
                autofillText,
                otpType,
                packageName,
                signatureHash,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesCommonContractsPocOsTemplateButtonProps = apply {
        if (validated) {
            return@apply
        }

        activeFor()
        countryCode()
        offerCode()
        phoneNumber()
        quickReplyType()
        text()
        url()
        urlType()
        autofillText()
        otpType()
        packageName()
        signatureHash()
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
        (if (activeFor.asKnown().isPresent) 1 else 0) +
            (if (countryCode.asKnown().isPresent) 1 else 0) +
            (if (offerCode.asKnown().isPresent) 1 else 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (quickReplyType.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (urlType.asKnown().isPresent) 1 else 0) +
            (if (autofillText.asKnown().isPresent) 1 else 0) +
            (if (otpType.asKnown().isPresent) 1 else 0) +
            (if (packageName.asKnown().isPresent) 1 else 0) +
            (if (signatureHash.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SentDmServicesCommonContractsPocOsTemplateButtonProps &&
            activeFor == other.activeFor &&
            countryCode == other.countryCode &&
            offerCode == other.offerCode &&
            phoneNumber == other.phoneNumber &&
            quickReplyType == other.quickReplyType &&
            text == other.text &&
            url == other.url &&
            urlType == other.urlType &&
            autofillText == other.autofillText &&
            otpType == other.otpType &&
            packageName == other.packageName &&
            signatureHash == other.signatureHash &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            activeFor,
            countryCode,
            offerCode,
            phoneNumber,
            quickReplyType,
            text,
            url,
            urlType,
            autofillText,
            otpType,
            packageName,
            signatureHash,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesCommonContractsPocOsTemplateButtonProps{activeFor=$activeFor, countryCode=$countryCode, offerCode=$offerCode, phoneNumber=$phoneNumber, quickReplyType=$quickReplyType, text=$text, url=$url, urlType=$urlType, autofillText=$autofillText, otpType=$otpType, packageName=$packageName, signatureHash=$signatureHash, additionalProperties=$additionalProperties}"
}
