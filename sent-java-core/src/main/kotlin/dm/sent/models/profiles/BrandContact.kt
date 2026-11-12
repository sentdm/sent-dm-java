// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BrandContact
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val businessName: JsonField<String>,
    private val email: JsonField<String>,
    private val name: JsonField<String>,
    private val phone: JsonField<String>,
    private val phoneCountryCode: JsonField<String>,
    private val role: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("business_name")
        @ExcludeMissing
        businessName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_country_code")
        @ExcludeMissing
        phoneCountryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
    ) : this(businessName, email, name, phone, phoneCountryCode, role, mutableMapOf())

    /**
     * Business/brand name
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun businessName(): Optional<String> = businessName.getOptional("business_name")

    /**
     * Contact email address
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * Primary contact name
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Contact phone number in E.164 format
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phone(): Optional<String> = phone.getOptional("phone")

    /**
     * Contact phone country code (e.g., "1" for US)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneCountryCode(): Optional<String> = phoneCountryCode.getOptional("phone_country_code")

    /**
     * Contact's role in the business
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun role(): Optional<String> = role.getOptional("role")

    /**
     * Returns the raw JSON value of [businessName].
     *
     * Unlike [businessName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("business_name")
    @ExcludeMissing
    fun _businessName(): JsonField<String> = businessName

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [phone].
     *
     * Unlike [phone], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

    /**
     * Returns the raw JSON value of [phoneCountryCode].
     *
     * Unlike [phoneCountryCode], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("phone_country_code")
    @ExcludeMissing
    fun _phoneCountryCode(): JsonField<String> = phoneCountryCode

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

        /** Returns a mutable builder for constructing an instance of [BrandContact]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandContact]. */
    class Builder internal constructor() {

        private var businessName: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var phone: JsonField<String> = JsonMissing.of()
        private var phoneCountryCode: JsonField<String> = JsonMissing.of()
        private var role: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandContact: BrandContact) = apply {
            businessName = brandContact.businessName
            email = brandContact.email
            name = brandContact.name
            phone = brandContact.phone
            phoneCountryCode = brandContact.phoneCountryCode
            role = brandContact.role
            additionalProperties = brandContact.additionalProperties.toMutableMap()
        }

        /** Business/brand name */
        fun businessName(businessName: String?) = businessName(JsonField.ofNullable(businessName))

        /** Alias for calling [Builder.businessName] with `businessName.orElse(null)`. */
        fun businessName(businessName: Optional<String>) = businessName(businessName.getOrNull())

        /**
         * Sets [Builder.businessName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.businessName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun businessName(businessName: JsonField<String>) = apply {
            this.businessName = businessName
        }

        /** Contact email address */
        fun email(email: String?) = email(JsonField.ofNullable(email))

        /** Alias for calling [Builder.email] with `email.orElse(null)`. */
        fun email(email: Optional<String>) = email(email.getOrNull())

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** Primary contact name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Contact phone number in E.164 format */
        fun phone(phone: String?) = phone(JsonField.ofNullable(phone))

        /** Alias for calling [Builder.phone] with `phone.orElse(null)`. */
        fun phone(phone: Optional<String>) = phone(phone.getOrNull())

        /**
         * Sets [Builder.phone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun phone(phone: JsonField<String>) = apply { this.phone = phone }

        /** Contact phone country code (e.g., "1" for US) */
        fun phoneCountryCode(phoneCountryCode: String?) =
            phoneCountryCode(JsonField.ofNullable(phoneCountryCode))

        /** Alias for calling [Builder.phoneCountryCode] with `phoneCountryCode.orElse(null)`. */
        fun phoneCountryCode(phoneCountryCode: Optional<String>) =
            phoneCountryCode(phoneCountryCode.getOrNull())

        /**
         * Sets [Builder.phoneCountryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneCountryCode] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun phoneCountryCode(phoneCountryCode: JsonField<String>) = apply {
            this.phoneCountryCode = phoneCountryCode
        }

        /** Contact's role in the business */
        fun role(role: String?) = role(JsonField.ofNullable(role))

        /** Alias for calling [Builder.role] with `role.orElse(null)`. */
        fun role(role: Optional<String>) = role(role.getOrNull())

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<String>) = apply { this.role = role }

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
         * Returns an immutable instance of [BrandContact].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BrandContact =
            BrandContact(
                businessName,
                email,
                name,
                phone,
                phoneCountryCode,
                role,
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
    fun validate(): BrandContact = apply {
        if (validated) {
            return@apply
        }

        businessName()
        email()
        name()
        phone()
        phoneCountryCode()
        role()
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
        (if (businessName.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (phone.asKnown().isPresent) 1 else 0) +
            (if (phoneCountryCode.asKnown().isPresent) 1 else 0) +
            (if (role.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandContact &&
            businessName == other.businessName &&
            email == other.email &&
            name == other.name &&
            phone == other.phone &&
            phoneCountryCode == other.phoneCountryCode &&
            role == other.role &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(businessName, email, name, phone, phoneCountryCode, role, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandContact{businessName=$businessName, email=$email, name=$name, phone=$phone, phoneCountryCode=$phoneCountryCode, role=$role, additionalProperties=$additionalProperties}"
}
