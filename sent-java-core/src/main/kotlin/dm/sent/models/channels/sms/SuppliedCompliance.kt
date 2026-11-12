// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

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

/**
 * What a market has been given: the identity it registers under, its programme, and any documents
 * attached.
 *
 * What it does not carry is what the market asks for. That is the subject of GET
 * /v3/compliance/requirements, and it is the same answer for every caller — a description of what a
 * compliance regime wants, not a record of one customer's progress through it. It was reported here
 * as well for a while, which put the same array in six response shapes and left a caller deciding
 * which of two sources to believe.
 *
 * Present on a list read for markets that register (carrying brand and campaign), but with
 * documents absent — documents are not fetched for a list, because a catalog lookup and a document
 * read per market would multiply across a page. Absent documents is distinct from an empty list:
 * absent says they were not fetched; empty says the market has been given none. The parent object
 * is null only when the market registers with nobody and compliance was not computed — nothing to
 * show at all.
 */
class SuppliedCompliance
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val brand: JsonField<Brand>,
    private val campaign: JsonField<Campaign>,
    private val campaigns: JsonField<List<Campaign>>,
    private val documents: JsonField<List<SuppliedDocument>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("brand") @ExcludeMissing brand: JsonField<Brand> = JsonMissing.of(),
        @JsonProperty("campaign") @ExcludeMissing campaign: JsonField<Campaign> = JsonMissing.of(),
        @JsonProperty("campaigns")
        @ExcludeMissing
        campaigns: JsonField<List<Campaign>> = JsonMissing.of(),
        @JsonProperty("documents")
        @ExcludeMissing
        documents: JsonField<List<SuppliedDocument>> = JsonMissing.of(),
    ) : this(brand, campaign, campaigns, documents, mutableMapOf())

    /**
     * The identity this market registers under, with inherit saying whose it is.
     *
     * Reported here rather than on the profile because it belongs to the registration this market
     * files, and only one market files one. It was a top-level block for a while, which put a
     * per-registration value beside a list of markets and left a caller to work out which market it
     * belonged to.
     *
     * Absent for a market that registers with nobody — such a market asks for no identity, so there
     * is none to report. Absent and null mean different things: absent says this market does not
     * ask, null would say it asks and nothing was supplied.
     *
     * Untyped, like the request side, because its members are declared by the market's own schema
     * rather than by a C# class. A typed pair here would be a second definition of what a market
     * wants, free to drift from the one that validates.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brand(): Optional<Brand> = brand.getOptional("brand")

    /**
     * The programme this market registers, with inherit saying whose it is.
     *
     * One, not a list. TcrCampaigns permits several and an account built on the admin side may hold
     * them, but this surface offers one — which is what lets the market's PATCH be an upsert rather
     * than a collection with an addressable create behind it. An account holding several is
     * reported as its first and refused on write, rather than half-edited.
     *
     * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if the
     * caller sent this object back — which it is meant to be able to do.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun campaign(): Optional<Campaign> = campaign.getOptional("campaign")

    /**
     * Every campaign this market registers, each with inherit saying whose it is — oldest first.
     *
     * A list, because a market can now be on more than one. POST
     * /v3/channels/sms/compliances/US/TEN_DLC/campaigns adds a campaign of the customer's own
     * beside the one it has, and a profile running on its organization's campaign keeps that one
     * when it adds its own. Campaign can only show one of them, so it stays as it was, for callers
     * that read it, and this is where the rest are.
     *
     * The organization's campaign reads "inherit": true and the customer's own read "inherit":
     * false. Each entry is the shape of Campaign plus id, the campaign's own id, so several can be
     * told apart. Campaign carries no id, because it is sent back to PATCH, which refuses a key it
     * does not declare; this list is read-only.
     *
     * Absent for a market that registers with nobody; empty for one that registers and has no
     * campaign yet.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun campaigns(): Optional<List<Campaign>> = campaigns.getOptional("campaigns")

    /**
     * What has been supplied for this market.
     *
     * Files, not values — the declared halves above carry the values. A document cannot be a JSON
     * value, so it is sent as multipart on the channel call and reported here as a reference.
     *
     * Absent on a list read, which fetches identity but does not compute compliance documents per
     * market. Absent and empty mean different things: absent says the documents were not fetched;
     * empty says the market has been given none.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun documents(): Optional<List<SuppliedDocument>> = documents.getOptional("documents")

    /**
     * Returns the raw JSON value of [brand].
     *
     * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<Brand> = brand

    /**
     * Returns the raw JSON value of [campaign].
     *
     * Unlike [campaign], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("campaign") @ExcludeMissing fun _campaign(): JsonField<Campaign> = campaign

    /**
     * Returns the raw JSON value of [campaigns].
     *
     * Unlike [campaigns], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("campaigns")
    @ExcludeMissing
    fun _campaigns(): JsonField<List<Campaign>> = campaigns

    /**
     * Returns the raw JSON value of [documents].
     *
     * Unlike [documents], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("documents")
    @ExcludeMissing
    fun _documents(): JsonField<List<SuppliedDocument>> = documents

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

        /** Returns a mutable builder for constructing an instance of [SuppliedCompliance]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SuppliedCompliance]. */
    class Builder internal constructor() {

        private var brand: JsonField<Brand> = JsonMissing.of()
        private var campaign: JsonField<Campaign> = JsonMissing.of()
        private var campaigns: JsonField<MutableList<Campaign>>? = null
        private var documents: JsonField<MutableList<SuppliedDocument>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(suppliedCompliance: SuppliedCompliance) = apply {
            brand = suppliedCompliance.brand
            campaign = suppliedCompliance.campaign
            campaigns = suppliedCompliance.campaigns.map { it.toMutableList() }
            documents = suppliedCompliance.documents.map { it.toMutableList() }
            additionalProperties = suppliedCompliance.additionalProperties.toMutableMap()
        }

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         */
        fun brand(brand: Brand?) = brand(JsonField.ofNullable(brand))

        /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
        fun brand(brand: Optional<Brand>) = brand(brand.getOrNull())

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun brand(brand: JsonField<Brand>) = apply { this.brand = brand }

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         */
        fun campaign(campaign: Campaign?) = campaign(JsonField.ofNullable(campaign))

        /** Alias for calling [Builder.campaign] with `campaign.orElse(null)`. */
        fun campaign(campaign: Optional<Campaign>) = campaign(campaign.getOrNull())

        /**
         * Sets [Builder.campaign] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaign] with a well-typed [Campaign] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun campaign(campaign: JsonField<Campaign>) = apply { this.campaign = campaign }

        /**
         * Every campaign this market registers, each with inherit saying whose it is — oldest
         * first.
         *
         * A list, because a market can now be on more than one. POST
         * /v3/channels/sms/compliances/US/TEN_DLC/campaigns adds a campaign of the customer's own
         * beside the one it has, and a profile running on its organization's campaign keeps that
         * one when it adds its own. Campaign can only show one of them, so it stays as it was, for
         * callers that read it, and this is where the rest are.
         *
         * The organization's campaign reads "inherit": true and the customer's own read "inherit":
         * false. Each entry is the shape of Campaign plus id, the campaign's own id, so several can
         * be told apart. Campaign carries no id, because it is sent back to PATCH, which refuses a
         * key it does not declare; this list is read-only.
         *
         * Absent for a market that registers with nobody; empty for one that registers and has no
         * campaign yet.
         */
        fun campaigns(campaigns: List<Campaign>?) = campaigns(JsonField.ofNullable(campaigns))

        /** Alias for calling [Builder.campaigns] with `campaigns.orElse(null)`. */
        fun campaigns(campaigns: Optional<List<Campaign>>) = campaigns(campaigns.getOrNull())

        /**
         * Sets [Builder.campaigns] to an arbitrary JSON value.
         *
         * You should usually call [Builder.campaigns] with a well-typed `List<Campaign>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun campaigns(campaigns: JsonField<List<Campaign>>) = apply {
            this.campaigns = campaigns.map { it.toMutableList() }
        }

        /**
         * Adds a single [Campaign] to [campaigns].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCampaign(campaign: Campaign) = apply {
            campaigns =
                (campaigns ?: JsonField.of(mutableListOf())).also {
                    checkKnown("campaigns", it).add(campaign)
                }
        }

        /**
         * What has been supplied for this market.
         *
         * Files, not values — the declared halves above carry the values. A document cannot be a
         * JSON value, so it is sent as multipart on the channel call and reported here as a
         * reference.
         *
         * Absent on a list read, which fetches identity but does not compute compliance documents
         * per market. Absent and empty mean different things: absent says the documents were not
         * fetched; empty says the market has been given none.
         */
        fun documents(documents: List<SuppliedDocument>?) =
            documents(JsonField.ofNullable(documents))

        /** Alias for calling [Builder.documents] with `documents.orElse(null)`. */
        fun documents(documents: Optional<List<SuppliedDocument>>) =
            documents(documents.getOrNull())

        /**
         * Sets [Builder.documents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.documents] with a well-typed `List<SuppliedDocument>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun documents(documents: JsonField<List<SuppliedDocument>>) = apply {
            this.documents = documents.map { it.toMutableList() }
        }

        /**
         * Adds a single [SuppliedDocument] to [documents].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDocument(document: SuppliedDocument) = apply {
            documents =
                (documents ?: JsonField.of(mutableListOf())).also {
                    checkKnown("documents", it).add(document)
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
         * Returns an immutable instance of [SuppliedCompliance].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SuppliedCompliance =
            SuppliedCompliance(
                brand,
                campaign,
                (campaigns ?: JsonMissing.of()).map { it.toImmutable() },
                (documents ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): SuppliedCompliance = apply {
        if (validated) {
            return@apply
        }

        brand().ifPresent { it.validate() }
        campaign().ifPresent { it.validate() }
        campaigns().ifPresent { it.forEach { it.validate() } }
        documents().ifPresent { it.forEach { it.validate() } }
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
        (brand.asKnown().getOrNull()?.validity() ?: 0) +
            (campaign.asKnown().getOrNull()?.validity() ?: 0) +
            (campaigns.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (documents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /**
     * The identity this market registers under, with inherit saying whose it is.
     *
     * Reported here rather than on the profile because it belongs to the registration this market
     * files, and only one market files one. It was a top-level block for a while, which put a
     * per-registration value beside a list of markets and left a caller to work out which market it
     * belonged to.
     *
     * Absent for a market that registers with nobody — such a market asks for no identity, so there
     * is none to report. Absent and null mean different things: absent says this market does not
     * ask, null would say it asks and nothing was supplied.
     *
     * Untyped, like the request side, because its members are declared by the market's own schema
     * rather than by a C# class. A typed pair here would be a second definition of what a market
     * wants, free to drift from the one that validates.
     */
    class Brand
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

            /** Returns a mutable builder for constructing an instance of [Brand]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Brand]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(brand: Brand) = apply {
                additionalProperties = brand.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Brand].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Brand = Brand(additionalProperties.toImmutable())
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
        fun validate(): Brand = apply {
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

            return other is Brand && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Brand{additionalProperties=$additionalProperties}"
    }

    /**
     * The programme this market registers, with inherit saying whose it is.
     *
     * One, not a list. TcrCampaigns permits several and an account built on the admin side may hold
     * them, but this surface offers one — which is what lets the market's PATCH be an upsert rather
     * than a collection with an addressable create behind it. An account holding several is
     * reported as its first and refused on write, rather than half-edited.
     *
     * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if the
     * caller sent this object back — which it is meant to be able to do.
     */
    class Campaign
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

            /** Returns a mutable builder for constructing an instance of [Campaign]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Campaign]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(campaign: Campaign) = apply {
                additionalProperties = campaign.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Campaign].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Campaign = Campaign(additionalProperties.toImmutable())
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
        fun validate(): Campaign = apply {
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

            return other is Campaign && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Campaign{additionalProperties=$additionalProperties}"
    }

    class Campaign
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

            /** Returns a mutable builder for constructing an instance of [Campaign]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Campaign]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(campaign: Campaign) = apply {
                additionalProperties = campaign.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Campaign].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Campaign = Campaign(additionalProperties.toImmutable())
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
        fun validate(): Campaign = apply {
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

            return other is Campaign && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Campaign{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SuppliedCompliance &&
            brand == other.brand &&
            campaign == other.campaign &&
            campaigns == other.campaigns &&
            documents == other.documents &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(brand, campaign, campaigns, documents, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SuppliedCompliance{brand=$brand, campaign=$campaign, campaigns=$campaigns, documents=$documents, additionalProperties=$additionalProperties}"
}
