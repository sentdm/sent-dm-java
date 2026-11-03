// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.models.webhooks.MutationRequest
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Resends a message you already sent, on the same message id, without rebuilding the request. The
 * typical use is recovering a BLOCKED message — for example one refused for insufficient balance —
 * after the account has been topped up.
 *
 * **A resend bills again.** Each accepted resend is a new delivery attempt and records a new charge
 * against the same message id; a client that resends on every failure is charged on every loop.
 *
 * **Every policy runs again.** The resend goes back through the full send pipeline — consent,
 * balance, KYC and channel quota, template approval, quiet hours and channel health — so it can
 * land on BLOCKED, FILTERED or SCHEDULED again rather than being sent, exactly as a fresh send
 * would. Status webhooks (message.sent, message.blocked, message.filtered, message.failed) fire
 * again for the same message id, so consumers keyed on the id will see repeated transitions.
 *
 * **What can be resent.** A message in a terminal state — DELIVERED, FAILED, READ or BLOCKED — or
 * one stuck at SENT for more than 15 minutes. A FILTERED message can never be resent: the recipient
 * opted out or a routing rule refused the send. A message still in flight (QUEUED, PROCESSED,
 * ROUTED), held for quiet hours (SCHEDULED), or SENT less than 15 minutes ago returns 409. Two
 * concurrent resends of one id are serialised: one is accepted, the other gets 409.
 *
 * The resend keeps the channel the message was originally requested on; the channel cannot be
 * changed on a resend — send a new message instead. `Idempotency-Key` is honoured, so a retried
 * request replays the first accepted response instead of resending twice.
 *
 * The response has the same shape as `POST /v3/messages`: `recipients` has a single entry whose
 * `message_id` is the id you resent.
 */
class MessageResendParams
private constructor(
    private val id: String?,
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val mutationRequest: MutationRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    fun mutationRequest(): MutationRequest = mutationRequest

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        mutationRequest._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageResendParams].
         *
         * The following fields are required:
         * ```java
         * .mutationRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageResendParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var mutationRequest: MutationRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(messageResendParams: MessageResendParams) = apply {
            id = messageResendParams.id
            idempotencyKey = messageResendParams.idempotencyKey
            xProfileId = messageResendParams.xProfileId
            mutationRequest = messageResendParams.mutationRequest
            additionalHeaders = messageResendParams.additionalHeaders.toBuilder()
            additionalQueryParams = messageResendParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        fun mutationRequest(mutationRequest: MutationRequest) = apply {
            this.mutationRequest = mutationRequest
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [MessageResendParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .mutationRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageResendParams =
            MessageResendParams(
                id,
                idempotencyKey,
                xProfileId,
                checkRequired("mutationRequest", mutationRequest),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): MutationRequest = mutationRequest

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageResendParams &&
            id == other.id &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            mutationRequest == other.mutationRequest &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            idempotencyKey,
            xProfileId,
            mutationRequest,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "MessageResendParams{id=$id, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, mutationRequest=$mutationRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
