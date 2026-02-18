// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.lookup

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.errors.SentDmInvalidDataException
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class LookupRetrievePhoneInfoResponse
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

        /**
         * Returns a mutable builder for constructing an instance of
         * [LookupRetrievePhoneInfoResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LookupRetrievePhoneInfoResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<ApiError> = JsonMissing.of()
        private var meta: JsonField<ApiMeta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(lookupRetrievePhoneInfoResponse: LookupRetrievePhoneInfoResponse) =
            apply {
                data = lookupRetrievePhoneInfoResponse.data
                error = lookupRetrievePhoneInfoResponse.error
                meta = lookupRetrievePhoneInfoResponse.meta
                success = lookupRetrievePhoneInfoResponse.success
                additionalProperties =
                    lookupRetrievePhoneInfoResponse.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [LookupRetrievePhoneInfoResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): LookupRetrievePhoneInfoResponse =
            LookupRetrievePhoneInfoResponse(
                data,
                error,
                meta,
                success,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): LookupRetrievePhoneInfoResponse = apply {
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
        private val carrierName: JsonField<String>,
        private val isPorted: JsonField<Boolean>,
        private val isValid: JsonField<Boolean>,
        private val isVoip: JsonField<Boolean>,
        private val lineType: JsonField<String>,
        private val mobileCountryCode: JsonField<String>,
        private val mobileNetworkCode: JsonField<String>,
        private val phoneNumber: JsonField<String>,
        private val provider: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("carrierName")
            @ExcludeMissing
            carrierName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isPorted")
            @ExcludeMissing
            isPorted: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isValid") @ExcludeMissing isValid: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isVoip") @ExcludeMissing isVoip: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("lineType")
            @ExcludeMissing
            lineType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mobileCountryCode")
            @ExcludeMissing
            mobileCountryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mobileNetworkCode")
            @ExcludeMissing
            mobileNetworkCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phoneNumber")
            @ExcludeMissing
            phoneNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("provider") @ExcludeMissing provider: JsonField<String> = JsonMissing.of(),
        ) : this(
            carrierName,
            isPorted,
            isValid,
            isVoip,
            lineType,
            mobileCountryCode,
            mobileNetworkCode,
            phoneNumber,
            provider,
            mutableMapOf(),
        )

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun carrierName(): Optional<String> = carrierName.getOptional("carrierName")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isPorted(): Optional<Boolean> = isPorted.getOptional("isPorted")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isValid(): Optional<Boolean> = isValid.getOptional("isValid")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isVoip(): Optional<Boolean> = isVoip.getOptional("isVoip")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun lineType(): Optional<String> = lineType.getOptional("lineType")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mobileCountryCode(): Optional<String> =
            mobileCountryCode.getOptional("mobileCountryCode")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mobileNetworkCode(): Optional<String> =
            mobileNetworkCode.getOptional("mobileNetworkCode")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phoneNumber")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun provider(): Optional<String> = provider.getOptional("provider")

        /**
         * Returns the raw JSON value of [carrierName].
         *
         * Unlike [carrierName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("carrierName")
        @ExcludeMissing
        fun _carrierName(): JsonField<String> = carrierName

        /**
         * Returns the raw JSON value of [isPorted].
         *
         * Unlike [isPorted], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isPorted") @ExcludeMissing fun _isPorted(): JsonField<Boolean> = isPorted

        /**
         * Returns the raw JSON value of [isValid].
         *
         * Unlike [isValid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isValid") @ExcludeMissing fun _isValid(): JsonField<Boolean> = isValid

        /**
         * Returns the raw JSON value of [isVoip].
         *
         * Unlike [isVoip], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isVoip") @ExcludeMissing fun _isVoip(): JsonField<Boolean> = isVoip

        /**
         * Returns the raw JSON value of [lineType].
         *
         * Unlike [lineType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lineType") @ExcludeMissing fun _lineType(): JsonField<String> = lineType

        /**
         * Returns the raw JSON value of [mobileCountryCode].
         *
         * Unlike [mobileCountryCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("mobileCountryCode")
        @ExcludeMissing
        fun _mobileCountryCode(): JsonField<String> = mobileCountryCode

        /**
         * Returns the raw JSON value of [mobileNetworkCode].
         *
         * Unlike [mobileNetworkCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("mobileNetworkCode")
        @ExcludeMissing
        fun _mobileNetworkCode(): JsonField<String> = mobileNetworkCode

        /**
         * Returns the raw JSON value of [phoneNumber].
         *
         * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phoneNumber")
        @ExcludeMissing
        fun _phoneNumber(): JsonField<String> = phoneNumber

        /**
         * Returns the raw JSON value of [provider].
         *
         * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

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

            private var carrierName: JsonField<String> = JsonMissing.of()
            private var isPorted: JsonField<Boolean> = JsonMissing.of()
            private var isValid: JsonField<Boolean> = JsonMissing.of()
            private var isVoip: JsonField<Boolean> = JsonMissing.of()
            private var lineType: JsonField<String> = JsonMissing.of()
            private var mobileCountryCode: JsonField<String> = JsonMissing.of()
            private var mobileNetworkCode: JsonField<String> = JsonMissing.of()
            private var phoneNumber: JsonField<String> = JsonMissing.of()
            private var provider: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                carrierName = data.carrierName
                isPorted = data.isPorted
                isValid = data.isValid
                isVoip = data.isVoip
                lineType = data.lineType
                mobileCountryCode = data.mobileCountryCode
                mobileNetworkCode = data.mobileNetworkCode
                phoneNumber = data.phoneNumber
                provider = data.provider
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun carrierName(carrierName: String?) = carrierName(JsonField.ofNullable(carrierName))

            /** Alias for calling [Builder.carrierName] with `carrierName.orElse(null)`. */
            fun carrierName(carrierName: Optional<String>) = carrierName(carrierName.getOrNull())

            /**
             * Sets [Builder.carrierName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.carrierName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun carrierName(carrierName: JsonField<String>) = apply {
                this.carrierName = carrierName
            }

            fun isPorted(isPorted: Boolean?) = isPorted(JsonField.ofNullable(isPorted))

            /**
             * Alias for [Builder.isPorted].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun isPorted(isPorted: Boolean) = isPorted(isPorted as Boolean?)

            /** Alias for calling [Builder.isPorted] with `isPorted.orElse(null)`. */
            fun isPorted(isPorted: Optional<Boolean>) = isPorted(isPorted.getOrNull())

            /**
             * Sets [Builder.isPorted] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isPorted] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPorted(isPorted: JsonField<Boolean>) = apply { this.isPorted = isPorted }

            fun isValid(isValid: Boolean) = isValid(JsonField.of(isValid))

            /**
             * Sets [Builder.isValid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isValid] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isValid(isValid: JsonField<Boolean>) = apply { this.isValid = isValid }

            fun isVoip(isVoip: Boolean?) = isVoip(JsonField.ofNullable(isVoip))

            /**
             * Alias for [Builder.isVoip].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun isVoip(isVoip: Boolean) = isVoip(isVoip as Boolean?)

            /** Alias for calling [Builder.isVoip] with `isVoip.orElse(null)`. */
            fun isVoip(isVoip: Optional<Boolean>) = isVoip(isVoip.getOrNull())

            /**
             * Sets [Builder.isVoip] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isVoip] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isVoip(isVoip: JsonField<Boolean>) = apply { this.isVoip = isVoip }

            fun lineType(lineType: String?) = lineType(JsonField.ofNullable(lineType))

            /** Alias for calling [Builder.lineType] with `lineType.orElse(null)`. */
            fun lineType(lineType: Optional<String>) = lineType(lineType.getOrNull())

            /**
             * Sets [Builder.lineType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lineType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lineType(lineType: JsonField<String>) = apply { this.lineType = lineType }

            fun mobileCountryCode(mobileCountryCode: String?) =
                mobileCountryCode(JsonField.ofNullable(mobileCountryCode))

            /**
             * Alias for calling [Builder.mobileCountryCode] with `mobileCountryCode.orElse(null)`.
             */
            fun mobileCountryCode(mobileCountryCode: Optional<String>) =
                mobileCountryCode(mobileCountryCode.getOrNull())

            /**
             * Sets [Builder.mobileCountryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mobileCountryCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mobileCountryCode(mobileCountryCode: JsonField<String>) = apply {
                this.mobileCountryCode = mobileCountryCode
            }

            fun mobileNetworkCode(mobileNetworkCode: String?) =
                mobileNetworkCode(JsonField.ofNullable(mobileNetworkCode))

            /**
             * Alias for calling [Builder.mobileNetworkCode] with `mobileNetworkCode.orElse(null)`.
             */
            fun mobileNetworkCode(mobileNetworkCode: Optional<String>) =
                mobileNetworkCode(mobileNetworkCode.getOrNull())

            /**
             * Sets [Builder.mobileNetworkCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mobileNetworkCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mobileNetworkCode(mobileNetworkCode: JsonField<String>) = apply {
                this.mobileNetworkCode = mobileNetworkCode
            }

            fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

            /**
             * Sets [Builder.phoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phoneNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                this.phoneNumber = phoneNumber
            }

            fun provider(provider: String) = provider(JsonField.of(provider))

            /**
             * Sets [Builder.provider] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provider] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provider(provider: JsonField<String>) = apply { this.provider = provider }

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
                    carrierName,
                    isPorted,
                    isValid,
                    isVoip,
                    lineType,
                    mobileCountryCode,
                    mobileNetworkCode,
                    phoneNumber,
                    provider,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            carrierName()
            isPorted()
            isValid()
            isVoip()
            lineType()
            mobileCountryCode()
            mobileNetworkCode()
            phoneNumber()
            provider()
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
            (if (carrierName.asKnown().isPresent) 1 else 0) +
                (if (isPorted.asKnown().isPresent) 1 else 0) +
                (if (isValid.asKnown().isPresent) 1 else 0) +
                (if (isVoip.asKnown().isPresent) 1 else 0) +
                (if (lineType.asKnown().isPresent) 1 else 0) +
                (if (mobileCountryCode.asKnown().isPresent) 1 else 0) +
                (if (mobileNetworkCode.asKnown().isPresent) 1 else 0) +
                (if (phoneNumber.asKnown().isPresent) 1 else 0) +
                (if (provider.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                carrierName == other.carrierName &&
                isPorted == other.isPorted &&
                isValid == other.isValid &&
                isVoip == other.isVoip &&
                lineType == other.lineType &&
                mobileCountryCode == other.mobileCountryCode &&
                mobileNetworkCode == other.mobileNetworkCode &&
                phoneNumber == other.phoneNumber &&
                provider == other.provider &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                carrierName,
                isPorted,
                isValid,
                isVoip,
                lineType,
                mobileCountryCode,
                mobileNetworkCode,
                phoneNumber,
                provider,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{carrierName=$carrierName, isPorted=$isPorted, isValid=$isValid, isVoip=$isVoip, lineType=$lineType, mobileCountryCode=$mobileCountryCode, mobileNetworkCode=$mobileNetworkCode, phoneNumber=$phoneNumber, provider=$provider, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LookupRetrievePhoneInfoResponse &&
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
        "LookupRetrievePhoneInfoResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
