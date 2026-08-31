// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

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
class MessageRetrieveActivitiesResponse
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
     * Response for GET /messages/{id}/activities
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

        /**
         * Returns a mutable builder for constructing an instance of
         * [MessageRetrieveActivitiesResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageRetrieveActivitiesResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<Error> = JsonMissing.of()
        private var meta: JsonField<Meta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageRetrieveActivitiesResponse: MessageRetrieveActivitiesResponse) =
            apply {
                data = messageRetrieveActivitiesResponse.data
                error = messageRetrieveActivitiesResponse.error
                meta = messageRetrieveActivitiesResponse.meta
                success = messageRetrieveActivitiesResponse.success
                additionalProperties =
                    messageRetrieveActivitiesResponse.additionalProperties.toMutableMap()
            }

        /** Response for GET /messages/{id}/activities */
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
         * Returns an immutable instance of [MessageRetrieveActivitiesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageRetrieveActivitiesResponse =
            MessageRetrieveActivitiesResponse(
                data,
                error,
                meta,
                success,
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
    fun validate(): MessageRetrieveActivitiesResponse = apply {
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

    /** Response for GET /messages/{id}/activities */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val activities: JsonField<List<Activity>>,
        private val messageId: JsonField<String>,
        private val pagination: JsonField<Pagination>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("activities")
            @ExcludeMissing
            activities: JsonField<List<Activity>> = JsonMissing.of(),
            @JsonProperty("message_id")
            @ExcludeMissing
            messageId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pagination")
            @ExcludeMissing
            pagination: JsonField<Pagination> = JsonMissing.of(),
        ) : this(activities, messageId, pagination, mutableMapOf())

        /**
         * List of activity events ordered by most recent first
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun activities(): Optional<List<Activity>> = activities.getOptional("activities")

        /**
         * The message ID these activities belong to
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messageId(): Optional<String> = messageId.getOptional("message_id")

        /**
         * Pagination metadata for list responses
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun pagination(): Optional<Pagination> = pagination.getOptional("pagination")

        /**
         * Returns the raw JSON value of [activities].
         *
         * Unlike [activities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("activities")
        @ExcludeMissing
        fun _activities(): JsonField<List<Activity>> = activities

        /**
         * Returns the raw JSON value of [messageId].
         *
         * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

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

            private var activities: JsonField<MutableList<Activity>>? = null
            private var messageId: JsonField<String> = JsonMissing.of()
            private var pagination: JsonField<Pagination> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                activities = data.activities.map { it.toMutableList() }
                messageId = data.messageId
                pagination = data.pagination
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** List of activity events ordered by most recent first */
            fun activities(activities: List<Activity>) = activities(JsonField.of(activities))

            /**
             * Sets [Builder.activities] to an arbitrary JSON value.
             *
             * You should usually call [Builder.activities] with a well-typed `List<Activity>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun activities(activities: JsonField<List<Activity>>) = apply {
                this.activities = activities.map { it.toMutableList() }
            }

            /**
             * Adds a single [Activity] to [activities].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addActivity(activity: Activity) = apply {
                activities =
                    (activities ?: JsonField.of(mutableListOf())).also {
                        checkKnown("activities", it).add(activity)
                    }
            }

            /** The message ID these activities belong to */
            fun messageId(messageId: String) = messageId(JsonField.of(messageId))

            /**
             * Sets [Builder.messageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

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
                    (activities ?: JsonMissing.of()).map { it.toImmutable() },
                    messageId,
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

            activities().ifPresent { it.forEach { it.validate() } }
            messageId()
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
            (activities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (messageId.asKnown().isPresent) 1 else 0) +
                (pagination.asKnown().getOrNull()?.validity() ?: 0)

        /** A single message activity event for v3 API */
        class Activity
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val activeContactPrice: JsonField<String>,
            private val description: JsonField<String>,
            private val from: JsonField<String>,
            private val price: JsonField<String>,
            private val status: JsonField<String>,
            private val timestamp: JsonField<OffsetDateTime>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("active_contact_price")
                @ExcludeMissing
                activeContactPrice: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
                @JsonProperty("price") @ExcludeMissing price: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status")
                @ExcludeMissing
                status: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            ) : this(
                activeContactPrice,
                description,
                from,
                price,
                status,
                timestamp,
                mutableMapOf(),
            )

            /**
             * Active contact markup applied on top of the channel cost, formatted to 4 decimal
             * places.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun activeContactPrice(): Optional<String> =
                activeContactPrice.getOptional("active_contact_price")

            /**
             * Human-readable description of the activity
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Sender phone number for this activity (the customer's sending number for outbound,
             * the external sender for inbound). Null when not reported by the provider.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun from(): Optional<String> = from.getOptional("from")

            /**
             * Channel cost for this activity (e.g., SMS/WhatsApp provider cost), formatted to 4
             * decimal places.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun price(): Optional<String> = price.getOptional("price")

            /**
             * Activity status. Outbound: QUEUED, PROCESSED, ROUTED, SENT, DELIVERED, READ, FAILED.
             * Inbound (from contact): RECEIVED (terminal).
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun status(): Optional<String> = status.getOptional("status")

            /**
             * When this activity occurred
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [activeContactPrice].
             *
             * Unlike [activeContactPrice], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("active_contact_price")
            @ExcludeMissing
            fun _activeContactPrice(): JsonField<String> = activeContactPrice

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [from].
             *
             * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

            /**
             * Returns the raw JSON value of [price].
             *
             * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<String> = price

            /**
             * Returns the raw JSON value of [status].
             *
             * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<OffsetDateTime> = timestamp

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

                /** Returns a mutable builder for constructing an instance of [Activity]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Activity]. */
            class Builder internal constructor() {

                private var activeContactPrice: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var from: JsonField<String> = JsonMissing.of()
                private var price: JsonField<String> = JsonMissing.of()
                private var status: JsonField<String> = JsonMissing.of()
                private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(activity: Activity) = apply {
                    activeContactPrice = activity.activeContactPrice
                    description = activity.description
                    from = activity.from
                    price = activity.price
                    status = activity.status
                    timestamp = activity.timestamp
                    additionalProperties = activity.additionalProperties.toMutableMap()
                }

                /**
                 * Active contact markup applied on top of the channel cost, formatted to 4 decimal
                 * places.
                 */
                fun activeContactPrice(activeContactPrice: String?) =
                    activeContactPrice(JsonField.ofNullable(activeContactPrice))

                /**
                 * Alias for calling [Builder.activeContactPrice] with
                 * `activeContactPrice.orElse(null)`.
                 */
                fun activeContactPrice(activeContactPrice: Optional<String>) =
                    activeContactPrice(activeContactPrice.getOrNull())

                /**
                 * Sets [Builder.activeContactPrice] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.activeContactPrice] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun activeContactPrice(activeContactPrice: JsonField<String>) = apply {
                    this.activeContactPrice = activeContactPrice
                }

                /** Human-readable description of the activity */
                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /**
                 * Sender phone number for this activity (the customer's sending number for
                 * outbound, the external sender for inbound). Null when not reported by the
                 * provider.
                 */
                fun from(from: String?) = from(JsonField.ofNullable(from))

                /** Alias for calling [Builder.from] with `from.orElse(null)`. */
                fun from(from: Optional<String>) = from(from.getOrNull())

                /**
                 * Sets [Builder.from] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.from] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun from(from: JsonField<String>) = apply { this.from = from }

                /**
                 * Channel cost for this activity (e.g., SMS/WhatsApp provider cost), formatted to 4
                 * decimal places.
                 */
                fun price(price: String?) = price(JsonField.ofNullable(price))

                /** Alias for calling [Builder.price] with `price.orElse(null)`. */
                fun price(price: Optional<String>) = price(price.getOrNull())

                /**
                 * Sets [Builder.price] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.price] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun price(price: JsonField<String>) = apply { this.price = price }

                /**
                 * Activity status. Outbound: QUEUED, PROCESSED, ROUTED, SENT, DELIVERED, READ,
                 * FAILED. Inbound (from contact): RECEIVED (terminal).
                 */
                fun status(status: String) = status(JsonField.of(status))

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<String>) = apply { this.status = status }

                /** When this activity occurred */
                fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                    this.timestamp = timestamp
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
                 * Returns an immutable instance of [Activity].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Activity =
                    Activity(
                        activeContactPrice,
                        description,
                        from,
                        price,
                        status,
                        timestamp,
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
            fun validate(): Activity = apply {
                if (validated) {
                    return@apply
                }

                activeContactPrice()
                description()
                from()
                price()
                status()
                timestamp()
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
                (if (activeContactPrice.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (from.asKnown().isPresent) 1 else 0) +
                    (if (price.asKnown().isPresent) 1 else 0) +
                    (if (status.asKnown().isPresent) 1 else 0) +
                    (if (timestamp.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Activity &&
                    activeContactPrice == other.activeContactPrice &&
                    description == other.description &&
                    from == other.from &&
                    price == other.price &&
                    status == other.status &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    activeContactPrice,
                    description,
                    from,
                    price,
                    status,
                    timestamp,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Activity{activeContactPrice=$activeContactPrice, description=$description, from=$from, price=$price, status=$status, timestamp=$timestamp, additionalProperties=$additionalProperties}"
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
             * Cursor-based pagination. Never populated — see Cursors.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            @Deprecated("deprecated")
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
            @Deprecated("deprecated")
            @JsonProperty("cursors")
            @ExcludeMissing
            fun _cursors(): JsonField<Cursors> = cursors

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

                /** Cursor-based pagination. Never populated — see Cursors. */
                @Deprecated("deprecated")
                fun cursors(cursors: Cursors?) = cursors(JsonField.ofNullable(cursors))

                /** Alias for calling [Builder.cursors] with `cursors.orElse(null)`. */
                @Deprecated("deprecated")
                fun cursors(cursors: Optional<Cursors>) = cursors(cursors.getOrNull())

                /**
                 * Sets [Builder.cursors] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cursors] with a well-typed [Cursors] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                @Deprecated("deprecated")
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

            /** Cursor-based pagination. Never populated — see Cursors. */
            @Deprecated("deprecated")
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
                 * Cursor to fetch the next page.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun after(): Optional<String> = after.getOptional("after")

                /**
                 * Cursor to fetch the previous page.
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

                    /** Cursor to fetch the next page. */
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

                    /** Cursor to fetch the previous page. */
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
                activities == other.activities &&
                messageId == other.messageId &&
                pagination == other.pagination &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(activities, messageId, pagination, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{activities=$activities, messageId=$messageId, pagination=$pagination, additionalProperties=$additionalProperties}"
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

        return other is MessageRetrieveActivitiesResponse &&
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
        "MessageRetrieveActivitiesResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
