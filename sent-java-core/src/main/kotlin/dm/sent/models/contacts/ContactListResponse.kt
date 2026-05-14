// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class ContactListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<Error>,
    private val meta: JsonField<Meta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<Meta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * Paginated list of contacts response
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error information
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun error(): Optional<Error> = error.getOptional("error")

    /**
     * Request and response metadata
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun meta(): Optional<Meta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
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
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<Meta> = meta

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

        /** Returns a mutable builder for constructing an instance of [ContactListResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactListResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<Error> = JsonMissing.of()
        private var meta: JsonField<Meta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contactListResponse: ContactListResponse) = apply {
            data = contactListResponse.data
            error = contactListResponse.error
            meta = contactListResponse.meta
            success = contactListResponse.success
            additionalProperties = contactListResponse.additionalProperties.toMutableMap()
        }

        /** Paginated list of contacts response */
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

        /** Error information */
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<Error>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /** Request and response metadata */
        fun meta(meta: Meta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [Meta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<Meta>) = apply { this.meta = meta }

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
         * Returns an immutable instance of [ContactListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContactListResponse =
            ContactListResponse(data, error, meta, success, additionalProperties.toMutableMap())
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
    fun validate(): ContactListResponse = apply {
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    /** Paginated list of contacts response */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contacts: JsonField<List<Contact>>,
        private val pagination: JsonField<Pagination>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("contacts")
            @ExcludeMissing
            contacts: JsonField<List<Contact>> = JsonMissing.of(),
            @JsonProperty("pagination")
            @ExcludeMissing
            pagination: JsonField<Pagination> = JsonMissing.of(),
        ) : this(contacts, pagination, mutableMapOf())

        /**
         * List of contacts
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contacts(): Optional<List<Contact>> = contacts.getOptional("contacts")

        /**
         * Pagination metadata for list responses
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun pagination(): Optional<Pagination> = pagination.getOptional("pagination")

        /**
         * Returns the raw JSON value of [contacts].
         *
         * Unlike [contacts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contacts")
        @ExcludeMissing
        fun _contacts(): JsonField<List<Contact>> = contacts

        /**
         * Returns the raw JSON value of [pagination].
         *
         * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pagination")
        @ExcludeMissing
        fun _pagination(): JsonField<Pagination> = pagination

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

            private var contacts: JsonField<MutableList<Contact>>? = null
            private var pagination: JsonField<Pagination> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                contacts = data.contacts.map { it.toMutableList() }
                pagination = data.pagination
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** List of contacts */
            fun contacts(contacts: List<Contact>) = contacts(JsonField.of(contacts))

            /**
             * Sets [Builder.contacts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contacts] with a well-typed `List<Contact>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contacts(contacts: JsonField<List<Contact>>) = apply {
                this.contacts = contacts.map { it.toMutableList() }
            }

            /**
             * Adds a single [Contact] to [contacts].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContact(contact: Contact) = apply {
                contacts =
                    (contacts ?: JsonField.of(mutableListOf())).also {
                        checkKnown("contacts", it).add(contact)
                    }
            }

            /** Pagination metadata for list responses */
            fun pagination(pagination: Pagination) = pagination(JsonField.of(pagination))

            /**
             * Sets [Builder.pagination] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pagination] with a well-typed [Pagination] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pagination(pagination: JsonField<Pagination>) = apply {
                this.pagination = pagination
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
                    (contacts ?: JsonMissing.of()).map { it.toImmutable() },
                    pagination,
                    additionalProperties.toMutableMap(),
                )
        }

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
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            contacts().ifPresent { it.forEach { it.validate() } }
            pagination().ifPresent { it.validate() }
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
        @JvmSynthetic
        internal fun validity(): Int =
            (contacts.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (pagination.asKnown().getOrNull()?.validity() ?: 0)

        /** Contact response for v3 API Uses snake_case for JSON property names */
        class Contact
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val availableChannels: JsonField<String>,
            private val countryCode: JsonField<String>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val defaultChannel: JsonField<String>,
            private val formatE164: JsonField<String>,
            private val formatInternational: JsonField<String>,
            private val formatNational: JsonField<String>,
            private val formatRfc: JsonField<String>,
            private val isInherited: JsonField<Boolean>,
            private val optOut: JsonField<Boolean>,
            private val phoneNumber: JsonField<String>,
            private val regionCode: JsonField<String>,
            private val updatedAt: JsonField<OffsetDateTime>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("available_channels")
                @ExcludeMissing
                availableChannels: JsonField<String> = JsonMissing.of(),
                @JsonProperty("country_code")
                @ExcludeMissing
                countryCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("created_at")
                @ExcludeMissing
                createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("default_channel")
                @ExcludeMissing
                defaultChannel: JsonField<String> = JsonMissing.of(),
                @JsonProperty("format_e164")
                @ExcludeMissing
                formatE164: JsonField<String> = JsonMissing.of(),
                @JsonProperty("format_international")
                @ExcludeMissing
                formatInternational: JsonField<String> = JsonMissing.of(),
                @JsonProperty("format_national")
                @ExcludeMissing
                formatNational: JsonField<String> = JsonMissing.of(),
                @JsonProperty("format_rfc")
                @ExcludeMissing
                formatRfc: JsonField<String> = JsonMissing.of(),
                @JsonProperty("is_inherited")
                @ExcludeMissing
                isInherited: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("opt_out")
                @ExcludeMissing
                optOut: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("phone_number")
                @ExcludeMissing
                phoneNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("region_code")
                @ExcludeMissing
                regionCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("updated_at")
                @ExcludeMissing
                updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            ) : this(
                id,
                availableChannels,
                countryCode,
                createdAt,
                defaultChannel,
                formatE164,
                formatInternational,
                formatNational,
                formatRfc,
                isInherited,
                optOut,
                phoneNumber,
                regionCode,
                updatedAt,
                mutableMapOf(),
            )

            /**
             * Unique identifier for the contact
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * Comma-separated list of available messaging channels (e.g., "sms,whatsapp")
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun availableChannels(): Optional<String> =
                availableChannels.getOptional("available_channels")

            /**
             * Country calling code (e.g., 1 for US/Canada)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

            /**
             * When the contact was created
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

            /**
             * Default messaging channel to use (e.g., "sms" or "whatsapp")
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun defaultChannel(): Optional<String> = defaultChannel.getOptional("default_channel")

            /**
             * Phone number in E.164 format (e.g., +1234567890)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun formatE164(): Optional<String> = formatE164.getOptional("format_e164")

            /**
             * Phone number in international format (e.g., +1 234-567-890)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun formatInternational(): Optional<String> =
                formatInternational.getOptional("format_international")

            /**
             * Phone number in national format (e.g., (234) 567-890)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun formatNational(): Optional<String> = formatNational.getOptional("format_national")

            /**
             * Phone number in RFC 3966 format (e.g., tel:+1-234-567-890)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun formatRfc(): Optional<String> = formatRfc.getOptional("format_rfc")

            /**
             * Whether this is an inherited contact (read-only)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun isInherited(): Optional<Boolean> = isInherited.getOptional("is_inherited")

            /**
             * Whether the contact has opted out of messaging. Single source of truth — opt-out is
             * per-contact, not per-channel.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun optOut(): Optional<Boolean> = optOut.getOptional("opt_out")

            /**
             * Phone number in original format
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

            /**
             * ISO 3166-1 alpha-2 country code (e.g., US, CA, GB)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun regionCode(): Optional<String> = regionCode.getOptional("region_code")

            /**
             * When the contact was last updated
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [availableChannels].
             *
             * Unlike [availableChannels], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("available_channels")
            @ExcludeMissing
            fun _availableChannels(): JsonField<String> = availableChannels

            /**
             * Returns the raw JSON value of [countryCode].
             *
             * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("country_code")
            @ExcludeMissing
            fun _countryCode(): JsonField<String> = countryCode

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [defaultChannel].
             *
             * Unlike [defaultChannel], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("default_channel")
            @ExcludeMissing
            fun _defaultChannel(): JsonField<String> = defaultChannel

            /**
             * Returns the raw JSON value of [formatE164].
             *
             * Unlike [formatE164], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("format_e164")
            @ExcludeMissing
            fun _formatE164(): JsonField<String> = formatE164

            /**
             * Returns the raw JSON value of [formatInternational].
             *
             * Unlike [formatInternational], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("format_international")
            @ExcludeMissing
            fun _formatInternational(): JsonField<String> = formatInternational

            /**
             * Returns the raw JSON value of [formatNational].
             *
             * Unlike [formatNational], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("format_national")
            @ExcludeMissing
            fun _formatNational(): JsonField<String> = formatNational

            /**
             * Returns the raw JSON value of [formatRfc].
             *
             * Unlike [formatRfc], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("format_rfc")
            @ExcludeMissing
            fun _formatRfc(): JsonField<String> = formatRfc

            /**
             * Returns the raw JSON value of [isInherited].
             *
             * Unlike [isInherited], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("is_inherited")
            @ExcludeMissing
            fun _isInherited(): JsonField<Boolean> = isInherited

            /**
             * Returns the raw JSON value of [optOut].
             *
             * Unlike [optOut], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("opt_out") @ExcludeMissing fun _optOut(): JsonField<Boolean> = optOut

            /**
             * Returns the raw JSON value of [phoneNumber].
             *
             * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("phone_number")
            @ExcludeMissing
            fun _phoneNumber(): JsonField<String> = phoneNumber

            /**
             * Returns the raw JSON value of [regionCode].
             *
             * Unlike [regionCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("region_code")
            @ExcludeMissing
            fun _regionCode(): JsonField<String> = regionCode

            /**
             * Returns the raw JSON value of [updatedAt].
             *
             * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("updated_at")
            @ExcludeMissing
            fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

                /** Returns a mutable builder for constructing an instance of [Contact]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Contact]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var availableChannels: JsonField<String> = JsonMissing.of()
                private var countryCode: JsonField<String> = JsonMissing.of()
                private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var defaultChannel: JsonField<String> = JsonMissing.of()
                private var formatE164: JsonField<String> = JsonMissing.of()
                private var formatInternational: JsonField<String> = JsonMissing.of()
                private var formatNational: JsonField<String> = JsonMissing.of()
                private var formatRfc: JsonField<String> = JsonMissing.of()
                private var isInherited: JsonField<Boolean> = JsonMissing.of()
                private var optOut: JsonField<Boolean> = JsonMissing.of()
                private var phoneNumber: JsonField<String> = JsonMissing.of()
                private var regionCode: JsonField<String> = JsonMissing.of()
                private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(contact: Contact) = apply {
                    id = contact.id
                    availableChannels = contact.availableChannels
                    countryCode = contact.countryCode
                    createdAt = contact.createdAt
                    defaultChannel = contact.defaultChannel
                    formatE164 = contact.formatE164
                    formatInternational = contact.formatInternational
                    formatNational = contact.formatNational
                    formatRfc = contact.formatRfc
                    isInherited = contact.isInherited
                    optOut = contact.optOut
                    phoneNumber = contact.phoneNumber
                    regionCode = contact.regionCode
                    updatedAt = contact.updatedAt
                    additionalProperties = contact.additionalProperties.toMutableMap()
                }

                /** Unique identifier for the contact */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Comma-separated list of available messaging channels (e.g., "sms,whatsapp") */
                fun availableChannels(availableChannels: String) =
                    availableChannels(JsonField.of(availableChannels))

                /**
                 * Sets [Builder.availableChannels] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.availableChannels] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun availableChannels(availableChannels: JsonField<String>) = apply {
                    this.availableChannels = availableChannels
                }

                /** Country calling code (e.g., 1 for US/Canada) */
                fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

                /**
                 * Sets [Builder.countryCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.countryCode] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun countryCode(countryCode: JsonField<String>) = apply {
                    this.countryCode = countryCode
                }

                /** When the contact was created */
                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                /** Default messaging channel to use (e.g., "sms" or "whatsapp") */
                fun defaultChannel(defaultChannel: String) =
                    defaultChannel(JsonField.of(defaultChannel))

                /**
                 * Sets [Builder.defaultChannel] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.defaultChannel] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun defaultChannel(defaultChannel: JsonField<String>) = apply {
                    this.defaultChannel = defaultChannel
                }

                /** Phone number in E.164 format (e.g., +1234567890) */
                fun formatE164(formatE164: String) = formatE164(JsonField.of(formatE164))

                /**
                 * Sets [Builder.formatE164] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.formatE164] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun formatE164(formatE164: JsonField<String>) = apply {
                    this.formatE164 = formatE164
                }

                /** Phone number in international format (e.g., +1 234-567-890) */
                fun formatInternational(formatInternational: String) =
                    formatInternational(JsonField.of(formatInternational))

                /**
                 * Sets [Builder.formatInternational] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.formatInternational] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun formatInternational(formatInternational: JsonField<String>) = apply {
                    this.formatInternational = formatInternational
                }

                /** Phone number in national format (e.g., (234) 567-890) */
                fun formatNational(formatNational: String) =
                    formatNational(JsonField.of(formatNational))

                /**
                 * Sets [Builder.formatNational] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.formatNational] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun formatNational(formatNational: JsonField<String>) = apply {
                    this.formatNational = formatNational
                }

                /** Phone number in RFC 3966 format (e.g., tel:+1-234-567-890) */
                fun formatRfc(formatRfc: String) = formatRfc(JsonField.of(formatRfc))

                /**
                 * Sets [Builder.formatRfc] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.formatRfc] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun formatRfc(formatRfc: JsonField<String>) = apply { this.formatRfc = formatRfc }

                /** Whether this is an inherited contact (read-only) */
                fun isInherited(isInherited: Boolean) = isInherited(JsonField.of(isInherited))

                /**
                 * Sets [Builder.isInherited] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isInherited] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isInherited(isInherited: JsonField<Boolean>) = apply {
                    this.isInherited = isInherited
                }

                /**
                 * Whether the contact has opted out of messaging. Single source of truth — opt-out
                 * is per-contact, not per-channel.
                 */
                fun optOut(optOut: Boolean) = optOut(JsonField.of(optOut))

                /**
                 * Sets [Builder.optOut] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.optOut] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun optOut(optOut: JsonField<Boolean>) = apply { this.optOut = optOut }

                /** Phone number in original format */
                fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

                /**
                 * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.phoneNumber] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                    this.phoneNumber = phoneNumber
                }

                /** ISO 3166-1 alpha-2 country code (e.g., US, CA, GB) */
                fun regionCode(regionCode: String) = regionCode(JsonField.of(regionCode))

                /**
                 * Sets [Builder.regionCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.regionCode] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun regionCode(regionCode: JsonField<String>) = apply {
                    this.regionCode = regionCode
                }

                /** When the contact was last updated */
                fun updatedAt(updatedAt: OffsetDateTime?) =
                    updatedAt(JsonField.ofNullable(updatedAt))

                /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
                fun updatedAt(updatedAt: Optional<OffsetDateTime>) =
                    updatedAt(updatedAt.getOrNull())

                /**
                 * Sets [Builder.updatedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                    this.updatedAt = updatedAt
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
                 * Returns an immutable instance of [Contact].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Contact =
                    Contact(
                        id,
                        availableChannels,
                        countryCode,
                        createdAt,
                        defaultChannel,
                        formatE164,
                        formatInternational,
                        formatNational,
                        formatRfc,
                        isInherited,
                        optOut,
                        phoneNumber,
                        regionCode,
                        updatedAt,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Contact = apply {
                if (validated) {
                    return@apply
                }

                id()
                availableChannels()
                countryCode()
                createdAt()
                defaultChannel()
                formatE164()
                formatInternational()
                formatNational()
                formatRfc()
                isInherited()
                optOut()
                phoneNumber()
                regionCode()
                updatedAt()
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
            @JvmSynthetic
            internal fun validity(): Int =
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (availableChannels.asKnown().isPresent) 1 else 0) +
                    (if (countryCode.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (defaultChannel.asKnown().isPresent) 1 else 0) +
                    (if (formatE164.asKnown().isPresent) 1 else 0) +
                    (if (formatInternational.asKnown().isPresent) 1 else 0) +
                    (if (formatNational.asKnown().isPresent) 1 else 0) +
                    (if (formatRfc.asKnown().isPresent) 1 else 0) +
                    (if (isInherited.asKnown().isPresent) 1 else 0) +
                    (if (optOut.asKnown().isPresent) 1 else 0) +
                    (if (phoneNumber.asKnown().isPresent) 1 else 0) +
                    (if (regionCode.asKnown().isPresent) 1 else 0) +
                    (if (updatedAt.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Contact &&
                    id == other.id &&
                    availableChannels == other.availableChannels &&
                    countryCode == other.countryCode &&
                    createdAt == other.createdAt &&
                    defaultChannel == other.defaultChannel &&
                    formatE164 == other.formatE164 &&
                    formatInternational == other.formatInternational &&
                    formatNational == other.formatNational &&
                    formatRfc == other.formatRfc &&
                    isInherited == other.isInherited &&
                    optOut == other.optOut &&
                    phoneNumber == other.phoneNumber &&
                    regionCode == other.regionCode &&
                    updatedAt == other.updatedAt &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    availableChannels,
                    countryCode,
                    createdAt,
                    defaultChannel,
                    formatE164,
                    formatInternational,
                    formatNational,
                    formatRfc,
                    isInherited,
                    optOut,
                    phoneNumber,
                    regionCode,
                    updatedAt,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Contact{id=$id, availableChannels=$availableChannels, countryCode=$countryCode, createdAt=$createdAt, defaultChannel=$defaultChannel, formatE164=$formatE164, formatInternational=$formatInternational, formatNational=$formatNational, formatRfc=$formatRfc, isInherited=$isInherited, optOut=$optOut, phoneNumber=$phoneNumber, regionCode=$regionCode, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
        }

        /** Pagination metadata for list responses */
        class Pagination
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val cursors: JsonField<Cursors>,
            private val hasMore: JsonField<Boolean>,
            private val page: JsonField<Int>,
            private val pageSize: JsonField<Int>,
            private val totalCount: JsonField<Int>,
            private val totalPages: JsonField<Int>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cursors")
                @ExcludeMissing
                cursors: JsonField<Cursors> = JsonMissing.of(),
                @JsonProperty("has_more")
                @ExcludeMissing
                hasMore: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("page") @ExcludeMissing page: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("page_size")
                @ExcludeMissing
                pageSize: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("total_count")
                @ExcludeMissing
                totalCount: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("total_pages")
                @ExcludeMissing
                totalPages: JsonField<Int> = JsonMissing.of(),
            ) : this(cursors, hasMore, page, pageSize, totalCount, totalPages, mutableMapOf())

            /**
             * Cursor-based pagination pointers
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun cursors(): Optional<Cursors> = cursors.getOptional("cursors")

            /**
             * Whether there are more pages after this one
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun hasMore(): Optional<Boolean> = hasMore.getOptional("has_more")

            /**
             * Current page number (1-indexed)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun page(): Optional<Int> = page.getOptional("page")

            /**
             * Number of items per page
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun pageSize(): Optional<Int> = pageSize.getOptional("page_size")

            /**
             * Total number of items across all pages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun totalCount(): Optional<Int> = totalCount.getOptional("total_count")

            /**
             * Total number of pages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun totalPages(): Optional<Int> = totalPages.getOptional("total_pages")

            /**
             * Returns the raw JSON value of [cursors].
             *
             * Unlike [cursors], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cursors") @ExcludeMissing fun _cursors(): JsonField<Cursors> = cursors

            /**
             * Returns the raw JSON value of [hasMore].
             *
             * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

            /**
             * Returns the raw JSON value of [page].
             *
             * Unlike [page], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("page") @ExcludeMissing fun _page(): JsonField<Int> = page

            /**
             * Returns the raw JSON value of [pageSize].
             *
             * Unlike [pageSize], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("page_size") @ExcludeMissing fun _pageSize(): JsonField<Int> = pageSize

            /**
             * Returns the raw JSON value of [totalCount].
             *
             * Unlike [totalCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("total_count")
            @ExcludeMissing
            fun _totalCount(): JsonField<Int> = totalCount

            /**
             * Returns the raw JSON value of [totalPages].
             *
             * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("total_pages")
            @ExcludeMissing
            fun _totalPages(): JsonField<Int> = totalPages

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

                /** Returns a mutable builder for constructing an instance of [Pagination]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Pagination]. */
            class Builder internal constructor() {

                private var cursors: JsonField<Cursors> = JsonMissing.of()
                private var hasMore: JsonField<Boolean> = JsonMissing.of()
                private var page: JsonField<Int> = JsonMissing.of()
                private var pageSize: JsonField<Int> = JsonMissing.of()
                private var totalCount: JsonField<Int> = JsonMissing.of()
                private var totalPages: JsonField<Int> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(pagination: Pagination) = apply {
                    cursors = pagination.cursors
                    hasMore = pagination.hasMore
                    page = pagination.page
                    pageSize = pagination.pageSize
                    totalCount = pagination.totalCount
                    totalPages = pagination.totalPages
                    additionalProperties = pagination.additionalProperties.toMutableMap()
                }

                /** Cursor-based pagination pointers */
                fun cursors(cursors: Cursors?) = cursors(JsonField.ofNullable(cursors))

                /** Alias for calling [Builder.cursors] with `cursors.orElse(null)`. */
                fun cursors(cursors: Optional<Cursors>) = cursors(cursors.getOrNull())

                /**
                 * Sets [Builder.cursors] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cursors] with a well-typed [Cursors] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun cursors(cursors: JsonField<Cursors>) = apply { this.cursors = cursors }

                /** Whether there are more pages after this one */
                fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

                /**
                 * Sets [Builder.hasMore] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.hasMore] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

                /** Current page number (1-indexed) */
                fun page(page: Int) = page(JsonField.of(page))

                /**
                 * Sets [Builder.page] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.page] with a well-typed [Int] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun page(page: JsonField<Int>) = apply { this.page = page }

                /** Number of items per page */
                fun pageSize(pageSize: Int) = pageSize(JsonField.of(pageSize))

                /**
                 * Sets [Builder.pageSize] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pageSize] with a well-typed [Int] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun pageSize(pageSize: JsonField<Int>) = apply { this.pageSize = pageSize }

                /** Total number of items across all pages */
                fun totalCount(totalCount: Int) = totalCount(JsonField.of(totalCount))

                /**
                 * Sets [Builder.totalCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.totalCount] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun totalCount(totalCount: JsonField<Int>) = apply { this.totalCount = totalCount }

                /** Total number of pages */
                fun totalPages(totalPages: Int) = totalPages(JsonField.of(totalPages))

                /**
                 * Sets [Builder.totalPages] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.totalPages] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun totalPages(totalPages: JsonField<Int>) = apply { this.totalPages = totalPages }

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
                 * Returns an immutable instance of [Pagination].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Pagination =
                    Pagination(
                        cursors,
                        hasMore,
                        page,
                        pageSize,
                        totalCount,
                        totalPages,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Pagination = apply {
                if (validated) {
                    return@apply
                }

                cursors().ifPresent { it.validate() }
                hasMore()
                page()
                pageSize()
                totalCount()
                totalPages()
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
            @JvmSynthetic
            internal fun validity(): Int =
                (cursors.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (hasMore.asKnown().isPresent) 1 else 0) +
                    (if (page.asKnown().isPresent) 1 else 0) +
                    (if (pageSize.asKnown().isPresent) 1 else 0) +
                    (if (totalCount.asKnown().isPresent) 1 else 0) +
                    (if (totalPages.asKnown().isPresent) 1 else 0)

            /** Cursor-based pagination pointers */
            class Cursors
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val after: JsonField<String>,
                private val before: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("after")
                    @ExcludeMissing
                    after: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("before")
                    @ExcludeMissing
                    before: JsonField<String> = JsonMissing.of(),
                ) : this(after, before, mutableMapOf())

                /**
                 * Cursor to fetch the next page
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun after(): Optional<String> = after.getOptional("after")

                /**
                 * Cursor to fetch the previous page
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun before(): Optional<String> = before.getOptional("before")

                /**
                 * Returns the raw JSON value of [after].
                 *
                 * Unlike [after], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("after") @ExcludeMissing fun _after(): JsonField<String> = after

                /**
                 * Returns the raw JSON value of [before].
                 *
                 * Unlike [before], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("before") @ExcludeMissing fun _before(): JsonField<String> = before

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

                    /** Returns a mutable builder for constructing an instance of [Cursors]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Cursors]. */
                class Builder internal constructor() {

                    private var after: JsonField<String> = JsonMissing.of()
                    private var before: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(cursors: Cursors) = apply {
                        after = cursors.after
                        before = cursors.before
                        additionalProperties = cursors.additionalProperties.toMutableMap()
                    }

                    /** Cursor to fetch the next page */
                    fun after(after: String?) = after(JsonField.ofNullable(after))

                    /** Alias for calling [Builder.after] with `after.orElse(null)`. */
                    fun after(after: Optional<String>) = after(after.getOrNull())

                    /**
                     * Sets [Builder.after] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.after] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun after(after: JsonField<String>) = apply { this.after = after }

                    /** Cursor to fetch the previous page */
                    fun before(before: String?) = before(JsonField.ofNullable(before))

                    /** Alias for calling [Builder.before] with `before.orElse(null)`. */
                    fun before(before: Optional<String>) = before(before.getOrNull())

                    /**
                     * Sets [Builder.before] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.before] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun before(before: JsonField<String>) = apply { this.before = before }

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
                     * Returns an immutable instance of [Cursors].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Cursors =
                        Cursors(after, before, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Cursors = apply {
                    if (validated) {
                        return@apply
                    }

                    after()
                    before()
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
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (after.asKnown().isPresent) 1 else 0) +
                        (if (before.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Cursors &&
                        after == other.after &&
                        before == other.before &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(after, before, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Cursors{after=$after, before=$before, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Pagination &&
                    cursors == other.cursors &&
                    hasMore == other.hasMore &&
                    page == other.page &&
                    pageSize == other.pageSize &&
                    totalCount == other.totalCount &&
                    totalPages == other.totalPages &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    cursors,
                    hasMore,
                    page,
                    pageSize,
                    totalCount,
                    totalPages,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Pagination{cursors=$cursors, hasMore=$hasMore, page=$page, pageSize=$pageSize, totalCount=$totalCount, totalPages=$totalPages, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                contacts == other.contacts &&
                pagination == other.pagination &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(contacts, pagination, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{contacts=$contacts, pagination=$pagination, additionalProperties=$additionalProperties}"
    }

    /** Error information */
    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val details: JsonField<Details>,
        private val docUrl: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
            @JsonProperty("doc_url") @ExcludeMissing docUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(code, details, docUrl, message, mutableMapOf())

        /**
         * Machine-readable error code (e.g., "RESOURCE_001")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun code(): Optional<String> = code.getOptional("code")

        /**
         * Additional validation error details (field-level errors)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun details(): Optional<Details> = details.getOptional("details")

        /**
         * URL to documentation about this error
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun docUrl(): Optional<String> = docUrl.getOptional("doc_url")

        /**
         * Human-readable error message
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun message(): Optional<String> = message.getOptional("message")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [details].
         *
         * Unlike [details], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

        /**
         * Returns the raw JSON value of [docUrl].
         *
         * Unlike [docUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("doc_url") @ExcludeMissing fun _docUrl(): JsonField<String> = docUrl

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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

            /** Returns a mutable builder for constructing an instance of [Error]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var code: JsonField<String> = JsonMissing.of()
            private var details: JsonField<Details> = JsonMissing.of()
            private var docUrl: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                details = error.details
                docUrl = error.docUrl
                message = error.message
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /** Machine-readable error code (e.g., "RESOURCE_001") */
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Additional validation error details (field-level errors) */
            fun details(details: Details?) = details(JsonField.ofNullable(details))

            /** Alias for calling [Builder.details] with `details.orElse(null)`. */
            fun details(details: Optional<Details>) = details(details.getOrNull())

            /**
             * Sets [Builder.details] to an arbitrary JSON value.
             *
             * You should usually call [Builder.details] with a well-typed [Details] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun details(details: JsonField<Details>) = apply { this.details = details }

            /** URL to documentation about this error */
            fun docUrl(docUrl: String?) = docUrl(JsonField.ofNullable(docUrl))

            /** Alias for calling [Builder.docUrl] with `docUrl.orElse(null)`. */
            fun docUrl(docUrl: Optional<String>) = docUrl(docUrl.getOrNull())

            /**
             * Sets [Builder.docUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.docUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun docUrl(docUrl: JsonField<String>) = apply { this.docUrl = docUrl }

            /** Human-readable error message */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

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
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Error =
                Error(code, details, docUrl, message, additionalProperties.toMutableMap())
        }

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
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            code()
            details().ifPresent { it.validate() }
            docUrl()
            message()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (code.asKnown().isPresent) 1 else 0) +
                (details.asKnown().getOrNull()?.validity() ?: 0) +
                (if (docUrl.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0)

        /** Additional validation error details (field-level errors) */
        class Details
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

                /** Returns a mutable builder for constructing an instance of [Details]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Details]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(details: Details) = apply {
                    additionalProperties = details.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Details].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Details = Details(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Details = apply {
                if (validated) {
                    return@apply
                }

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
            @JvmSynthetic
            internal fun validity(): Int =
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Details && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Details{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                details == other.details &&
                docUrl == other.docUrl &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, details, docUrl, message, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, details=$details, docUrl=$docUrl, message=$message, additionalProperties=$additionalProperties}"
    }

    /** Request and response metadata */
    class Meta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val requestId: JsonField<String>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val version: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
        ) : this(requestId, timestamp, version, mutableMapOf())

        /**
         * Unique identifier for this request (for tracing and support)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

        /**
         * Server timestamp when the response was generated
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

        /**
         * API version used for this request
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun version(): Optional<String> = version.getOptional("version")

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [timestamp].
         *
         * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timestamp")
        @ExcludeMissing
        fun _timestamp(): JsonField<OffsetDateTime> = timestamp

        /**
         * Returns the raw JSON value of [version].
         *
         * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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

            /** Returns a mutable builder for constructing an instance of [Meta]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Meta]. */
        class Builder internal constructor() {

            private var requestId: JsonField<String> = JsonMissing.of()
            private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
            private var version: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(meta: Meta) = apply {
                requestId = meta.requestId
                timestamp = meta.timestamp
                version = meta.version
                additionalProperties = meta.additionalProperties.toMutableMap()
            }

            /** Unique identifier for this request (for tracing and support) */
            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            /** Server timestamp when the response was generated */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
            }

            /** API version used for this request */
            fun version(version: String) = version(JsonField.of(version))

            /**
             * Sets [Builder.version] to an arbitrary JSON value.
             *
             * You should usually call [Builder.version] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun version(version: JsonField<String>) = apply { this.version = version }

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
             * Returns an immutable instance of [Meta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Meta =
                Meta(requestId, timestamp, version, additionalProperties.toMutableMap())
        }

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
        fun validate(): Meta = apply {
            if (validated) {
                return@apply
            }

            requestId()
            timestamp()
            version()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (requestId.asKnown().isPresent) 1 else 0) +
                (if (timestamp.asKnown().isPresent) 1 else 0) +
                (if (version.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Meta &&
                requestId == other.requestId &&
                timestamp == other.timestamp &&
                version == other.version &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(requestId, timestamp, version, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Meta{requestId=$requestId, timestamp=$timestamp, version=$version, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactListResponse &&
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
        "ContactListResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
