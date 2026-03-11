// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.me.MeRetrieveParams
import dm.sent.models.me.MeRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Retrieve account details */
interface MeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MeServiceAsync

    /**
     * Returns the account associated with the provided API key. The response includes account
     * identity, contact information, messaging channel configuration, and — depending on the
     * account type — either a list of child profiles or the profile's own settings.
     *
     * **Account types:**
     * - `organization` — Has child profiles. The `profiles` array is populated.
     * - `user` — Standalone account with no profiles.
     * - `profile` — Child of an organization. Includes `organization_id`, `short_name`, `status`,
     *   and `settings`.
     *
     * **Channels:** The `channels` object always includes `sms`, `whatsapp`, and `rcs`. Each
     * channel has a `configured` boolean. Configured channels expose additional details such as
     * `phone_number`.
     */
    fun retrieve(): CompletableFuture<MeRetrieveResponse> = retrieve(MeRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: MeRetrieveParams = MeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MeRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: MeRetrieveParams = MeRetrieveParams.none()
    ): CompletableFuture<MeRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<MeRetrieveResponse> =
        retrieve(MeRetrieveParams.none(), requestOptions)

    /** A view of [MeServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/me`, but is otherwise the same as
         * [MeServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<MeRetrieveResponse>> =
            retrieve(MeRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: MeRetrieveParams = MeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: MeRetrieveParams = MeRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<MeRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MeRetrieveResponse>> =
            retrieve(MeRetrieveParams.none(), requestOptions)
    }
}
