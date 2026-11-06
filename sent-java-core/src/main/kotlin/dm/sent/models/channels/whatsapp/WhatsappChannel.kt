// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.whatsapp

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The profile's WhatsApp account. Its status is Meta's verification state. */
class WhatsappChannel
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val ownerBusinessId: JsonField<String>,
    private val phoneNumberId: JsonField<String>,
    private val reason: JsonField<String>,
    private val reasonCode: JsonField<String>,
    private val solutionId: JsonField<String>,
    private val status: JsonField<Status>,
    private val wabaId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("owner_business_id")
        @ExcludeMissing
        ownerBusinessId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_number_id")
        @ExcludeMissing
        phoneNumberId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason_code")
        @ExcludeMissing
        reasonCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("solution_id")
        @ExcludeMissing
        solutionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("waba_id") @ExcludeMissing wabaId: JsonField<String> = JsonMissing.of(),
    ) : this(
        ownerBusinessId,
        phoneNumberId,
        reason,
        reasonCode,
        solutionId,
        status,
        wabaId,
        mutableMapOf(),
    )

    /**
     * Derived from the organization's shared-account listing, like SolutionId.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun ownerBusinessId(): Optional<String> = ownerBusinessId.getOptional("owner_business_id")

    /**
     * The Meta phone-number id the profile sends from, or null when the account is connected but no
     * number has been named yet — which is what a provisioning status means here.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneNumberId(): Optional<String> = phoneNumberId.getOptional("phone_number_id")

    /**
     * A sentence for reason_code, saying what to do where it is yours. Omitted while ACTIVE.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Why the account is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
     * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than on
     * reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
     * generic reason for the status.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reasonCode(): Optional<String> = reasonCode.getOptional("reason_code")

    /**
     * Derived, not echoed. The request no longer accepts this — it is read off the organization's
     * shared-account listing at connect time and reported back so a caller can see which
     * partnership the account actually arrived through.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun solutionId(): Optional<String> = solutionId.getOptional("solution_id")

    /**
     * Read-only. Never carries a token — the row holds that and it is not returned. ACTION_NEEDED
     * when no account is connected or the account has no phone number: both are yours to do.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun wabaId(): Optional<String> = wabaId.getOptional("waba_id")

    /**
     * Returns the raw JSON value of [ownerBusinessId].
     *
     * Unlike [ownerBusinessId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("owner_business_id")
    @ExcludeMissing
    fun _ownerBusinessId(): JsonField<String> = ownerBusinessId

    /**
     * Returns the raw JSON value of [phoneNumberId].
     *
     * Unlike [phoneNumberId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone_number_id")
    @ExcludeMissing
    fun _phoneNumberId(): JsonField<String> = phoneNumberId

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [reasonCode].
     *
     * Unlike [reasonCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason_code") @ExcludeMissing fun _reasonCode(): JsonField<String> = reasonCode

    /**
     * Returns the raw JSON value of [solutionId].
     *
     * Unlike [solutionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("solution_id") @ExcludeMissing fun _solutionId(): JsonField<String> = solutionId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [wabaId].
     *
     * Unlike [wabaId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waba_id") @ExcludeMissing fun _wabaId(): JsonField<String> = wabaId

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

        /** Returns a mutable builder for constructing an instance of [WhatsappChannel]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WhatsappChannel]. */
    class Builder internal constructor() {

        private var ownerBusinessId: JsonField<String> = JsonMissing.of()
        private var phoneNumberId: JsonField<String> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var reasonCode: JsonField<String> = JsonMissing.of()
        private var solutionId: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var wabaId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(whatsappChannel: WhatsappChannel) = apply {
            ownerBusinessId = whatsappChannel.ownerBusinessId
            phoneNumberId = whatsappChannel.phoneNumberId
            reason = whatsappChannel.reason
            reasonCode = whatsappChannel.reasonCode
            solutionId = whatsappChannel.solutionId
            status = whatsappChannel.status
            wabaId = whatsappChannel.wabaId
            additionalProperties = whatsappChannel.additionalProperties.toMutableMap()
        }

        /** Derived from the organization's shared-account listing, like SolutionId. */
        fun ownerBusinessId(ownerBusinessId: String?) =
            ownerBusinessId(JsonField.ofNullable(ownerBusinessId))

        /** Alias for calling [Builder.ownerBusinessId] with `ownerBusinessId.orElse(null)`. */
        fun ownerBusinessId(ownerBusinessId: Optional<String>) =
            ownerBusinessId(ownerBusinessId.getOrNull())

        /**
         * Sets [Builder.ownerBusinessId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ownerBusinessId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun ownerBusinessId(ownerBusinessId: JsonField<String>) = apply {
            this.ownerBusinessId = ownerBusinessId
        }

        /**
         * The Meta phone-number id the profile sends from, or null when the account is connected
         * but no number has been named yet — which is what a provisioning status means here.
         */
        fun phoneNumberId(phoneNumberId: String?) =
            phoneNumberId(JsonField.ofNullable(phoneNumberId))

        /** Alias for calling [Builder.phoneNumberId] with `phoneNumberId.orElse(null)`. */
        fun phoneNumberId(phoneNumberId: Optional<String>) =
            phoneNumberId(phoneNumberId.getOrNull())

        /**
         * Sets [Builder.phoneNumberId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumberId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumberId(phoneNumberId: JsonField<String>) = apply {
            this.phoneNumberId = phoneNumberId
        }

        /**
         * A sentence for reason_code, saying what to do where it is yours. Omitted while ACTIVE.
         */
        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        /**
         * Why the account is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
         * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than
         * on reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
         * generic reason for the status.
         */
        fun reasonCode(reasonCode: String?) = reasonCode(JsonField.ofNullable(reasonCode))

        /** Alias for calling [Builder.reasonCode] with `reasonCode.orElse(null)`. */
        fun reasonCode(reasonCode: Optional<String>) = reasonCode(reasonCode.getOrNull())

        /**
         * Sets [Builder.reasonCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasonCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasonCode(reasonCode: JsonField<String>) = apply { this.reasonCode = reasonCode }

        /**
         * Derived, not echoed. The request no longer accepts this — it is read off the
         * organization's shared-account listing at connect time and reported back so a caller can
         * see which partnership the account actually arrived through.
         */
        fun solutionId(solutionId: String?) = solutionId(JsonField.ofNullable(solutionId))

        /** Alias for calling [Builder.solutionId] with `solutionId.orElse(null)`. */
        fun solutionId(solutionId: Optional<String>) = solutionId(solutionId.getOrNull())

        /**
         * Sets [Builder.solutionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.solutionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun solutionId(solutionId: JsonField<String>) = apply { this.solutionId = solutionId }

        /**
         * Read-only. Never carries a token — the row holds that and it is not returned.
         * ACTION_NEEDED when no account is connected or the account has no phone number: both are
         * yours to do.
         */
        fun status(status: Status?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun wabaId(wabaId: String?) = wabaId(JsonField.ofNullable(wabaId))

        /** Alias for calling [Builder.wabaId] with `wabaId.orElse(null)`. */
        fun wabaId(wabaId: Optional<String>) = wabaId(wabaId.getOrNull())

        /**
         * Sets [Builder.wabaId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.wabaId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun wabaId(wabaId: JsonField<String>) = apply { this.wabaId = wabaId }

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
         * Returns an immutable instance of [WhatsappChannel].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WhatsappChannel =
            WhatsappChannel(
                ownerBusinessId,
                phoneNumberId,
                reason,
                reasonCode,
                solutionId,
                status,
                wabaId,
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
    fun validate(): WhatsappChannel = apply {
        if (validated) {
            return@apply
        }

        ownerBusinessId()
        phoneNumberId()
        reason()
        reasonCode()
        solutionId()
        status().ifPresent { it.validate() }
        wabaId()
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
        (if (ownerBusinessId.asKnown().isPresent) 1 else 0) +
            (if (phoneNumberId.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (reasonCode.asKnown().isPresent) 1 else 0) +
            (if (solutionId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (wabaId.asKnown().isPresent) 1 else 0)

    /**
     * Read-only. Never carries a token — the row holds that and it is not returned. ACTION_NEEDED
     * when no account is connected or the account has no phone number: both are yours to do.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            /**
             * We are working on it and there is nothing for you to do — a number is being procured,
             * or a registration is being assembled. Minutes to hours.
             */
            @JvmField val PROVISIONING = of("PROVISIONING")

            /**
             * **Waiting on you.** Something the market asks for has not been supplied, a regulator
             * rejected what was, or we have asked you to correct and resubmit your identity data.
             * Nothing progresses until you act. For an SMS market, `GET
             * /v3/channels/sms/{country}/{type}` names what it wants and `PATCH` on the same path
             * supplies it — compliance values, documents and numbers alike.
             */
            @JvmField val ACTION_NEEDED = of("ACTION_NEEDED")

            /**
             * With a regulator or carrier — filed, or assembled and queued for us to file — and
             * their answer is what moves it, to `ACTIVE` or back to `ACTION_NEEDED`. Nothing on
             * your side changes it. Days for SMS, weeks for RCS.
             */
            @JvmField val PENDING_REVIEW = of("PENDING_REVIEW")

            /**
             * Can carry traffic now. A channel a sender profile runs on its organization's reads
             * `ACTIVE` too — it sends, which is what the field is about.
             */
            @JvmField val ACTIVE = of("ACTIVE")

            /**
             * **It had a working sender and no longer does** — the number was released, or the
             * campaign it carried lapsed. Distinct from `PROVISIONING`, which means it has never
             * sent yet: the same absence of a sender, opposite news. Sends will fail until it
             * returns to `ACTIVE`.
             */
            @JvmField val INACTIVE = of("INACTIVE")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            /**
             * We are working on it and there is nothing for you to do — a number is being procured,
             * or a registration is being assembled. Minutes to hours.
             */
            PROVISIONING,
            /**
             * **Waiting on you.** Something the market asks for has not been supplied, a regulator
             * rejected what was, or we have asked you to correct and resubmit your identity data.
             * Nothing progresses until you act. For an SMS market, `GET
             * /v3/channels/sms/{country}/{type}` names what it wants and `PATCH` on the same path
             * supplies it — compliance values, documents and numbers alike.
             */
            ACTION_NEEDED,
            /**
             * With a regulator or carrier — filed, or assembled and queued for us to file — and
             * their answer is what moves it, to `ACTIVE` or back to `ACTION_NEEDED`. Nothing on
             * your side changes it. Days for SMS, weeks for RCS.
             */
            PENDING_REVIEW,
            /**
             * Can carry traffic now. A channel a sender profile runs on its organization's reads
             * `ACTIVE` too — it sends, which is what the field is about.
             */
            ACTIVE,
            /**
             * **It had a working sender and no longer does** — the number was released, or the
             * campaign it carried lapsed. Distinct from `PROVISIONING`, which means it has never
             * sent yet: the same absence of a sender, opposite news. Sends will fail until it
             * returns to `ACTIVE`.
             */
            INACTIVE,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /**
             * We are working on it and there is nothing for you to do — a number is being procured,
             * or a registration is being assembled. Minutes to hours.
             */
            PROVISIONING,
            /**
             * **Waiting on you.** Something the market asks for has not been supplied, a regulator
             * rejected what was, or we have asked you to correct and resubmit your identity data.
             * Nothing progresses until you act. For an SMS market, `GET
             * /v3/channels/sms/{country}/{type}` names what it wants and `PATCH` on the same path
             * supplies it — compliance values, documents and numbers alike.
             */
            ACTION_NEEDED,
            /**
             * With a regulator or carrier — filed, or assembled and queued for us to file — and
             * their answer is what moves it, to `ACTIVE` or back to `ACTION_NEEDED`. Nothing on
             * your side changes it. Days for SMS, weeks for RCS.
             */
            PENDING_REVIEW,
            /**
             * Can carry traffic now. A channel a sender profile runs on its organization's reads
             * `ACTIVE` too — it sends, which is what the field is about.
             */
            ACTIVE,
            /**
             * **It had a working sender and no longer does** — the number was released, or the
             * campaign it carried lapsed. Distinct from `PROVISIONING`, which means it has never
             * sent yet: the same absence of a sender, opposite news. Sends will fail until it
             * returns to `ACTIVE`.
             */
            INACTIVE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PROVISIONING -> Value.PROVISIONING
                ACTION_NEEDED -> Value.ACTION_NEEDED
                PENDING_REVIEW -> Value.PENDING_REVIEW
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                PROVISIONING -> Known.PROVISIONING
                ACTION_NEEDED -> Known.ACTION_NEEDED
                PENDING_REVIEW -> Known.PENDING_REVIEW
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                else -> throw SentInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentInvalidDataException("Value is not a String") }

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
        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WhatsappChannel &&
            ownerBusinessId == other.ownerBusinessId &&
            phoneNumberId == other.phoneNumberId &&
            reason == other.reason &&
            reasonCode == other.reasonCode &&
            solutionId == other.solutionId &&
            status == other.status &&
            wabaId == other.wabaId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            ownerBusinessId,
            phoneNumberId,
            reason,
            reasonCode,
            solutionId,
            status,
            wabaId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WhatsappChannel{ownerBusinessId=$ownerBusinessId, phoneNumberId=$phoneNumberId, reason=$reason, reasonCode=$reasonCode, solutionId=$solutionId, status=$status, wabaId=$wabaId, additionalProperties=$additionalProperties}"
}
