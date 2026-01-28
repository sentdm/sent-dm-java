// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class OrganizationRetrieveProfilesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val organizationId: JsonField<String>,
    private val profiles: JsonField<List<ProfileSummary>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("organizationId")
        @ExcludeMissing
        organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("profiles")
        @ExcludeMissing
        profiles: JsonField<List<ProfileSummary>> = JsonMissing.of(),
    ) : this(organizationId, profiles, mutableMapOf())

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = organizationId.getOptional("organizationId")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun profiles(): Optional<List<ProfileSummary>> = profiles.getOptional("profiles")

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("organizationId")
    @ExcludeMissing
    fun _organizationId(): JsonField<String> = organizationId

    /**
     * Returns the raw JSON value of [profiles].
     *
     * Unlike [profiles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("profiles")
    @ExcludeMissing
    fun _profiles(): JsonField<List<ProfileSummary>> = profiles

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
         * [OrganizationRetrieveProfilesResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrganizationRetrieveProfilesResponse]. */
    class Builder internal constructor() {

        private var organizationId: JsonField<String> = JsonMissing.of()
        private var profiles: JsonField<MutableList<ProfileSummary>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            organizationRetrieveProfilesResponse: OrganizationRetrieveProfilesResponse
        ) = apply {
            organizationId = organizationRetrieveProfilesResponse.organizationId
            profiles = organizationRetrieveProfilesResponse.profiles.map { it.toMutableList() }
            additionalProperties =
                organizationRetrieveProfilesResponse.additionalProperties.toMutableMap()
        }

        fun organizationId(organizationId: String) = organizationId(JsonField.of(organizationId))

        /**
         * Sets [Builder.organizationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun organizationId(organizationId: JsonField<String>) = apply {
            this.organizationId = organizationId
        }

        fun profiles(profiles: List<ProfileSummary>) = profiles(JsonField.of(profiles))

        /**
         * Sets [Builder.profiles] to an arbitrary JSON value.
         *
         * You should usually call [Builder.profiles] with a well-typed `List<ProfileSummary>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun profiles(profiles: JsonField<List<ProfileSummary>>) = apply {
            this.profiles = profiles.map { it.toMutableList() }
        }

        /**
         * Adds a single [ProfileSummary] to [profiles].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addProfile(profile: ProfileSummary) = apply {
            profiles =
                (profiles ?: JsonField.of(mutableListOf())).also {
                    checkKnown("profiles", it).add(profile)
                }
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
         * Returns an immutable instance of [OrganizationRetrieveProfilesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): OrganizationRetrieveProfilesResponse =
            OrganizationRetrieveProfilesResponse(
                organizationId,
                (profiles ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrganizationRetrieveProfilesResponse = apply {
        if (validated) {
            return@apply
        }

        organizationId()
        profiles().ifPresent { it.forEach { it.validate() } }
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
        (if (organizationId.asKnown().isPresent) 1 else 0) +
            (profiles.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrganizationRetrieveProfilesResponse &&
            organizationId == other.organizationId &&
            profiles == other.profiles &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(organizationId, profiles, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrganizationRetrieveProfilesResponse{organizationId=$organizationId, profiles=$profiles, additionalProperties=$additionalProperties}"
}
