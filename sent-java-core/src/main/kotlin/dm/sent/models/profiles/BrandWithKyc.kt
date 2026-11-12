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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Brand response with nested contact, business, and compliance sections — mirrors the request
 * structure.
 */
class BrandWithKyc
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val business: JsonField<BrandBusiness>,
    private val compliance: JsonField<BrandCompliance>,
    private val contact: JsonField<BrandContact>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val cspId: JsonField<String>,
    private val identityStatus: JsonField<TcrBrandIdentityStatus>,
    private val isInherited: JsonField<Boolean>,
    private val status: JsonField<TcrBrandStatus>,
    private val submittedAt: JsonField<OffsetDateTime>,
    private val submittedToTcr: JsonField<Boolean>,
    private val tcrBrandId: JsonField<String>,
    private val universalEin: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("business")
        @ExcludeMissing
        business: JsonField<BrandBusiness> = JsonMissing.of(),
        @JsonProperty("compliance")
        @ExcludeMissing
        compliance: JsonField<BrandCompliance> = JsonMissing.of(),
        @JsonProperty("contact")
        @ExcludeMissing
        contact: JsonField<BrandContact> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("csp_id") @ExcludeMissing cspId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("identity_status")
        @ExcludeMissing
        identityStatus: JsonField<TcrBrandIdentityStatus> = JsonMissing.of(),
        @JsonProperty("is_inherited")
        @ExcludeMissing
        isInherited: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<TcrBrandStatus> = JsonMissing.of(),
        @JsonProperty("submitted_at")
        @ExcludeMissing
        submittedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("submitted_to_tcr")
        @ExcludeMissing
        submittedToTcr: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("tcr_brand_id")
        @ExcludeMissing
        tcrBrandId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("universal_ein")
        @ExcludeMissing
        universalEin: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        business,
        compliance,
        contact,
        createdAt,
        cspId,
        identityStatus,
        isInherited,
        status,
        submittedAt,
        submittedToTcr,
        tcrBrandId,
        universalEin,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the brand
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Business details and address information
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun business(): Optional<BrandBusiness> = business.getOptional("business")

    /**
     * Compliance and TCR-related information
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<BrandCompliance> = compliance.getOptional("compliance")

    /**
     * Contact information for the brand
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contact(): Optional<BrandContact> = contact.getOptional("contact")

    /**
     * When the brand was created
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Deprecated and scheduled for removal. Identifies the Campaign Service Provider that
     * registered the brand, which is Sent, so the value is the same for every brand and every
     * account. Nothing on your side can act on it and there is no replacement. Stop reading it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    @Deprecated("deprecated") fun cspId(): Optional<String> = cspId.getOptional("csp_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun identityStatus(): Optional<TcrBrandIdentityStatus> =
        identityStatus.getOptional("identity_status")

    /**
     * Whether this brand is inherited from the parent organization
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun isInherited(): Optional<Boolean> = isInherited.getOptional("is_inherited")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<TcrBrandStatus> = status.getOptional("status")

    /**
     * When the brand was submitted to TCR
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun submittedAt(): Optional<OffsetDateTime> = submittedAt.getOptional("submitted_at")

    /**
     * Whether this brand has been submitted to TCR
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun submittedToTcr(): Optional<Boolean> = submittedToTcr.getOptional("submitted_to_tcr")

    /**
     * TCR brand ID (populated after TCR submission)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun tcrBrandId(): Optional<String> = tcrBrandId.getOptional("tcr_brand_id")

    /**
     * Universal EIN from TCR
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun universalEin(): Optional<String> = universalEin.getOptional("universal_ein")

    /**
     * When the brand was last updated
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [business].
     *
     * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("business") @ExcludeMissing fun _business(): JsonField<BrandBusiness> = business

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compliance")
    @ExcludeMissing
    fun _compliance(): JsonField<BrandCompliance> = compliance

    /**
     * Returns the raw JSON value of [contact].
     *
     * Unlike [contact], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact") @ExcludeMissing fun _contact(): JsonField<BrandContact> = contact

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [cspId].
     *
     * Unlike [cspId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated")
    @JsonProperty("csp_id")
    @ExcludeMissing
    fun _cspId(): JsonField<String> = cspId

    /**
     * Returns the raw JSON value of [identityStatus].
     *
     * Unlike [identityStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("identity_status")
    @ExcludeMissing
    fun _identityStatus(): JsonField<TcrBrandIdentityStatus> = identityStatus

    /**
     * Returns the raw JSON value of [isInherited].
     *
     * Unlike [isInherited], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_inherited")
    @ExcludeMissing
    fun _isInherited(): JsonField<Boolean> = isInherited

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<TcrBrandStatus> = status

    /**
     * Returns the raw JSON value of [submittedAt].
     *
     * Unlike [submittedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("submitted_at")
    @ExcludeMissing
    fun _submittedAt(): JsonField<OffsetDateTime> = submittedAt

    /**
     * Returns the raw JSON value of [submittedToTcr].
     *
     * Unlike [submittedToTcr], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("submitted_to_tcr")
    @ExcludeMissing
    fun _submittedToTcr(): JsonField<Boolean> = submittedToTcr

    /**
     * Returns the raw JSON value of [tcrBrandId].
     *
     * Unlike [tcrBrandId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tcr_brand_id") @ExcludeMissing fun _tcrBrandId(): JsonField<String> = tcrBrandId

    /**
     * Returns the raw JSON value of [universalEin].
     *
     * Unlike [universalEin], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("universal_ein")
    @ExcludeMissing
    fun _universalEin(): JsonField<String> = universalEin

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
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

        /** Returns a mutable builder for constructing an instance of [BrandWithKyc]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandWithKyc]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var business: JsonField<BrandBusiness> = JsonMissing.of()
        private var compliance: JsonField<BrandCompliance> = JsonMissing.of()
        private var contact: JsonField<BrandContact> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var cspId: JsonField<String> = JsonMissing.of()
        private var identityStatus: JsonField<TcrBrandIdentityStatus> = JsonMissing.of()
        private var isInherited: JsonField<Boolean> = JsonMissing.of()
        private var status: JsonField<TcrBrandStatus> = JsonMissing.of()
        private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var submittedToTcr: JsonField<Boolean> = JsonMissing.of()
        private var tcrBrandId: JsonField<String> = JsonMissing.of()
        private var universalEin: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandWithKyc: BrandWithKyc) = apply {
            id = brandWithKyc.id
            business = brandWithKyc.business
            compliance = brandWithKyc.compliance
            contact = brandWithKyc.contact
            createdAt = brandWithKyc.createdAt
            cspId = brandWithKyc.cspId
            identityStatus = brandWithKyc.identityStatus
            isInherited = brandWithKyc.isInherited
            status = brandWithKyc.status
            submittedAt = brandWithKyc.submittedAt
            submittedToTcr = brandWithKyc.submittedToTcr
            tcrBrandId = brandWithKyc.tcrBrandId
            universalEin = brandWithKyc.universalEin
            updatedAt = brandWithKyc.updatedAt
            additionalProperties = brandWithKyc.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the brand */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Business details and address information */
        fun business(business: BrandBusiness?) = business(JsonField.ofNullable(business))

        /** Alias for calling [Builder.business] with `business.orElse(null)`. */
        fun business(business: Optional<BrandBusiness>) = business(business.getOrNull())

        /**
         * Sets [Builder.business] to an arbitrary JSON value.
         *
         * You should usually call [Builder.business] with a well-typed [BrandBusiness] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun business(business: JsonField<BrandBusiness>) = apply { this.business = business }

        /** Compliance and TCR-related information */
        fun compliance(compliance: BrandCompliance?) = compliance(JsonField.ofNullable(compliance))

        /** Alias for calling [Builder.compliance] with `compliance.orElse(null)`. */
        fun compliance(compliance: Optional<BrandCompliance>) = compliance(compliance.getOrNull())

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [BrandCompliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<BrandCompliance>) = apply {
            this.compliance = compliance
        }

        /** Contact information for the brand */
        fun contact(contact: BrandContact?) = contact(JsonField.ofNullable(contact))

        /** Alias for calling [Builder.contact] with `contact.orElse(null)`. */
        fun contact(contact: Optional<BrandContact>) = contact(contact.getOrNull())

        /**
         * Sets [Builder.contact] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contact] with a well-typed [BrandContact] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contact(contact: JsonField<BrandContact>) = apply { this.contact = contact }

        /** When the brand was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /**
         * Deprecated and scheduled for removal. Identifies the Campaign Service Provider that
         * registered the brand, which is Sent, so the value is the same for every brand and every
         * account. Nothing on your side can act on it and there is no replacement. Stop reading it.
         */
        @Deprecated("deprecated") fun cspId(cspId: String?) = cspId(JsonField.ofNullable(cspId))

        /** Alias for calling [Builder.cspId] with `cspId.orElse(null)`. */
        @Deprecated("deprecated") fun cspId(cspId: Optional<String>) = cspId(cspId.getOrNull())

        /**
         * Sets [Builder.cspId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cspId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        @Deprecated("deprecated") fun cspId(cspId: JsonField<String>) = apply { this.cspId = cspId }

        fun identityStatus(identityStatus: TcrBrandIdentityStatus?) =
            identityStatus(JsonField.ofNullable(identityStatus))

        /** Alias for calling [Builder.identityStatus] with `identityStatus.orElse(null)`. */
        fun identityStatus(identityStatus: Optional<TcrBrandIdentityStatus>) =
            identityStatus(identityStatus.getOrNull())

        /**
         * Sets [Builder.identityStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.identityStatus] with a well-typed
         * [TcrBrandIdentityStatus] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun identityStatus(identityStatus: JsonField<TcrBrandIdentityStatus>) = apply {
            this.identityStatus = identityStatus
        }

        /** Whether this brand is inherited from the parent organization */
        fun isInherited(isInherited: Boolean) = isInherited(JsonField.of(isInherited))

        /**
         * Sets [Builder.isInherited] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isInherited] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isInherited(isInherited: JsonField<Boolean>) = apply { this.isInherited = isInherited }

        fun status(status: TcrBrandStatus?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<TcrBrandStatus>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [TcrBrandStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<TcrBrandStatus>) = apply { this.status = status }

        /** When the brand was submitted to TCR */
        fun submittedAt(submittedAt: OffsetDateTime?) =
            submittedAt(JsonField.ofNullable(submittedAt))

        /** Alias for calling [Builder.submittedAt] with `submittedAt.orElse(null)`. */
        fun submittedAt(submittedAt: Optional<OffsetDateTime>) =
            submittedAt(submittedAt.getOrNull())

        /**
         * Sets [Builder.submittedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.submittedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
            this.submittedAt = submittedAt
        }

        /** Whether this brand has been submitted to TCR */
        fun submittedToTcr(submittedToTcr: Boolean) = submittedToTcr(JsonField.of(submittedToTcr))

        /**
         * Sets [Builder.submittedToTcr] to an arbitrary JSON value.
         *
         * You should usually call [Builder.submittedToTcr] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun submittedToTcr(submittedToTcr: JsonField<Boolean>) = apply {
            this.submittedToTcr = submittedToTcr
        }

        /** TCR brand ID (populated after TCR submission) */
        fun tcrBrandId(tcrBrandId: String?) = tcrBrandId(JsonField.ofNullable(tcrBrandId))

        /** Alias for calling [Builder.tcrBrandId] with `tcrBrandId.orElse(null)`. */
        fun tcrBrandId(tcrBrandId: Optional<String>) = tcrBrandId(tcrBrandId.getOrNull())

        /**
         * Sets [Builder.tcrBrandId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tcrBrandId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tcrBrandId(tcrBrandId: JsonField<String>) = apply { this.tcrBrandId = tcrBrandId }

        /** Universal EIN from TCR */
        fun universalEin(universalEin: String?) = universalEin(JsonField.ofNullable(universalEin))

        /** Alias for calling [Builder.universalEin] with `universalEin.orElse(null)`. */
        fun universalEin(universalEin: Optional<String>) = universalEin(universalEin.getOrNull())

        /**
         * Sets [Builder.universalEin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.universalEin] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun universalEin(universalEin: JsonField<String>) = apply {
            this.universalEin = universalEin
        }

        /** When the brand was last updated */
        fun updatedAt(updatedAt: OffsetDateTime?) = updatedAt(JsonField.ofNullable(updatedAt))

        /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
        fun updatedAt(updatedAt: Optional<OffsetDateTime>) = updatedAt(updatedAt.getOrNull())

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [BrandWithKyc].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BrandWithKyc =
            BrandWithKyc(
                id,
                business,
                compliance,
                contact,
                createdAt,
                cspId,
                identityStatus,
                isInherited,
                status,
                submittedAt,
                submittedToTcr,
                tcrBrandId,
                universalEin,
                updatedAt,
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
    fun validate(): BrandWithKyc = apply {
        if (validated) {
            return@apply
        }

        id()
        business().ifPresent { it.validate() }
        compliance().ifPresent { it.validate() }
        contact().ifPresent { it.validate() }
        createdAt()
        cspId()
        identityStatus().ifPresent { it.validate() }
        isInherited()
        status().ifPresent { it.validate() }
        submittedAt()
        submittedToTcr()
        tcrBrandId()
        universalEin()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (business.asKnown().getOrNull()?.validity() ?: 0) +
            (compliance.asKnown().getOrNull()?.validity() ?: 0) +
            (contact.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (cspId.asKnown().isPresent) 1 else 0) +
            (identityStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isInherited.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (submittedAt.asKnown().isPresent) 1 else 0) +
            (if (submittedToTcr.asKnown().isPresent) 1 else 0) +
            (if (tcrBrandId.asKnown().isPresent) 1 else 0) +
            (if (universalEin.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandWithKyc &&
            id == other.id &&
            business == other.business &&
            compliance == other.compliance &&
            contact == other.contact &&
            createdAt == other.createdAt &&
            cspId == other.cspId &&
            identityStatus == other.identityStatus &&
            isInherited == other.isInherited &&
            status == other.status &&
            submittedAt == other.submittedAt &&
            submittedToTcr == other.submittedToTcr &&
            tcrBrandId == other.tcrBrandId &&
            universalEin == other.universalEin &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            business,
            compliance,
            contact,
            createdAt,
            cspId,
            identityStatus,
            isInherited,
            status,
            submittedAt,
            submittedToTcr,
            tcrBrandId,
            universalEin,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandWithKyc{id=$id, business=$business, compliance=$compliance, contact=$contact, createdAt=$createdAt, cspId=$cspId, identityStatus=$identityStatus, isInherited=$isInherited, status=$status, submittedAt=$submittedAt, submittedToTcr=$submittedToTcr, tcrBrandId=$tcrBrandId, universalEin=$universalEin, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
