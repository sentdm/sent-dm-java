// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.calls

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.calls.ApiResponseOfCall
import dm.sent.models.calls.participants.ApiResponseOfListOfCallParticipant
import dm.sent.models.calls.participants.ParticipantAddParams
import dm.sent.models.calls.participants.ParticipantListParams
import dm.sent.models.calls.participants.ParticipantRemoveAllParams
import dm.sent.models.calls.participants.ParticipantRemoveParams
import dm.sent.models.calls.participants.ParticipantUpdateParams
import java.util.function.Consumer

/**
 * Phone calls from the numbers you hold, driven by your own callback URL.
 *
 * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to do
 * with each call on it, and `POST /v3/channels/voice/tokens` mints a short-lived token that lets a
 * user of your app place and receive calls as that number. When a call arrives or a caller presses
 * a key, a signed question is POSTed to the callback URL and the answer decides the call; `POST
 * /v3/channels/voice/{number}/test` checks the URL answers the way we need before a real call
 * reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The
 * call events themselves (`call.completed` and the rest) arrive through your webhooks.
 *
 * Every call is a record under `/v3/calls`: read it, list its recordings once one is ready, hang it
 * up, start or stop recording, and add, mute or remove conference participants while it is live. A
 * leg to a phone number runs for at most what your balance affords at the destination's rate.
 */
interface ParticipantService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ParticipantService

    /**
     * Mutes or unmutes one participant of the conference room a live call is in, named by the
     * participant's own call id from the participants list: send muted true to silence them, muted
     * false to let them be heard again. Muting a participant who is already muted succeeds, as does
     * unmuting one who is not. A participant who is not in this call's room answers 404. A call
     * that has ended answers 409, as does a call that is not in a conference.
     */
    fun update(participantId: String, params: ParticipantUpdateParams) =
        update(participantId, params, RequestOptions.none())

    /** @see update */
    fun update(
        participantId: String,
        params: ParticipantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = update(params.toBuilder().participantId(participantId).build(), requestOptions)

    /** @see update */
    fun update(params: ParticipantUpdateParams) = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ParticipantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * Lists who is in the conference room one of your live calls is in: each participant's own call
     * id, who they are, whether the room mutes them, and how long they have been connected. The
     * call itself is one of the participants. Use a participant's id to mute or remove them; it is
     * also a call id, so GET /v3/calls/{id} accepts it. A call that has ended answers 409, as does
     * a call that is not in a conference.
     */
    fun list(id: String): ApiResponseOfListOfCallParticipant =
        list(id, ParticipantListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: ParticipantListParams = ParticipantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfCallParticipant = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: ParticipantListParams = ParticipantListParams.none(),
    ): ApiResponseOfListOfCallParticipant = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ParticipantListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfCallParticipant

    /** @see list */
    fun list(params: ParticipantListParams): ApiResponseOfListOfCallParticipant =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): ApiResponseOfListOfCallParticipant =
        list(id, ParticipantListParams.none(), requestOptions)

    /**
     * Dials one of your app users or a phone number into a call that is in a conference room, and
     * answers with the participant's own call record. The participant is a call of their own: it
     * has its own id, can be looked up and hung up, and is billed and reported through
     * call.completed and call.failed like any other call. Every participant needs a positive
     * balance. A phone participant is called from caller_id, which must be one of your numbers, or
     * from the call's owning number when omitted, and needs a destination you may call. Only a call
     * your answer connected to a conference can take participants: a call connected to a user or a
     * number answers 409.
     */
    fun add(id: String): ApiResponseOfCall = add(id, ParticipantAddParams.none())

    /** @see add */
    fun add(
        id: String,
        params: ParticipantAddParams = ParticipantAddParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfCall = add(params.toBuilder().id(id).build(), requestOptions)

    /** @see add */
    fun add(
        id: String,
        params: ParticipantAddParams = ParticipantAddParams.none(),
    ): ApiResponseOfCall = add(id, params, RequestOptions.none())

    /** @see add */
    fun add(
        params: ParticipantAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfCall

    /** @see add */
    fun add(params: ParticipantAddParams): ApiResponseOfCall = add(params, RequestOptions.none())

    /** @see add */
    fun add(id: String, requestOptions: RequestOptions): ApiResponseOfCall =
        add(id, ParticipantAddParams.none(), requestOptions)

    /**
     * Removes one participant from the conference room a live call is in, named by the
     * participant's own call id from the participants list. Their leg ends and is reported through
     * call.completed like any other call; everyone else stays connected. A participant who is not
     * in this call's room answers 404. A call that has ended answers 409, as does a call that is
     * not in a conference.
     */
    fun remove(participantId: String, params: ParticipantRemoveParams) =
        remove(participantId, params, RequestOptions.none())

    /** @see remove */
    fun remove(
        participantId: String,
        params: ParticipantRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = remove(params.toBuilder().participantId(participantId).build(), requestOptions)

    /** @see remove */
    fun remove(params: ParticipantRemoveParams) = remove(params, RequestOptions.none())

    /** @see remove */
    fun remove(
        params: ParticipantRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * Removes every participant from the conference room a live call is in, the call itself
     * included. Every leg ends and is reported through call.completed like any other call. A room
     * that is already empty answers 204 as well. A call that has ended answers 409, as does a call
     * that is not in a conference.
     */
    fun removeAll(id: String, params: ParticipantRemoveAllParams) =
        removeAll(id, params, RequestOptions.none())

    /** @see removeAll */
    fun removeAll(
        id: String,
        params: ParticipantRemoveAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = removeAll(params.toBuilder().id(id).build(), requestOptions)

    /** @see removeAll */
    fun removeAll(params: ParticipantRemoveAllParams) = removeAll(params, RequestOptions.none())

    /** @see removeAll */
    fun removeAll(
        params: ParticipantRemoveAllParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [ParticipantService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ParticipantService.WithRawResponse

        /**
         * Returns a raw HTTP response for `patch /v3/calls/{id}/participants/{participantId}`, but
         * is otherwise the same as [ParticipantService.update].
         */
        @MustBeClosed
        fun update(participantId: String, params: ParticipantUpdateParams): HttpResponse =
            update(participantId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            participantId: String,
            params: ParticipantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            update(params.toBuilder().participantId(participantId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: ParticipantUpdateParams): HttpResponse =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ParticipantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get /v3/calls/{id}/participants`, but is otherwise the
         * same as [ParticipantService.list].
         */
        @MustBeClosed
        fun list(id: String): HttpResponseFor<ApiResponseOfListOfCallParticipant> =
            list(id, ParticipantListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: ParticipantListParams = ParticipantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfCallParticipant> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: ParticipantListParams = ParticipantListParams.none(),
        ): HttpResponseFor<ApiResponseOfListOfCallParticipant> =
            list(id, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ParticipantListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfCallParticipant>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ParticipantListParams
        ): HttpResponseFor<ApiResponseOfListOfCallParticipant> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfCallParticipant> =
            list(id, ParticipantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/calls/{id}/participants`, but is otherwise the
         * same as [ParticipantService.add].
         */
        @MustBeClosed
        fun add(id: String): HttpResponseFor<ApiResponseOfCall> =
            add(id, ParticipantAddParams.none())

        /** @see add */
        @MustBeClosed
        fun add(
            id: String,
            params: ParticipantAddParams = ParticipantAddParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfCall> =
            add(params.toBuilder().id(id).build(), requestOptions)

        /** @see add */
        @MustBeClosed
        fun add(
            id: String,
            params: ParticipantAddParams = ParticipantAddParams.none(),
        ): HttpResponseFor<ApiResponseOfCall> = add(id, params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(
            params: ParticipantAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfCall>

        /** @see add */
        @MustBeClosed
        fun add(params: ParticipantAddParams): HttpResponseFor<ApiResponseOfCall> =
            add(params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(id: String, requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfCall> =
            add(id, ParticipantAddParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/calls/{id}/participants/{participantId}`, but
         * is otherwise the same as [ParticipantService.remove].
         */
        @MustBeClosed
        fun remove(participantId: String, params: ParticipantRemoveParams): HttpResponse =
            remove(participantId, params, RequestOptions.none())

        /** @see remove */
        @MustBeClosed
        fun remove(
            participantId: String,
            params: ParticipantRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            remove(params.toBuilder().participantId(participantId).build(), requestOptions)

        /** @see remove */
        @MustBeClosed
        fun remove(params: ParticipantRemoveParams): HttpResponse =
            remove(params, RequestOptions.none())

        /** @see remove */
        @MustBeClosed
        fun remove(
            params: ParticipantRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `delete /v3/calls/{id}/participants`, but is otherwise
         * the same as [ParticipantService.removeAll].
         */
        @MustBeClosed
        fun removeAll(id: String, params: ParticipantRemoveAllParams): HttpResponse =
            removeAll(id, params, RequestOptions.none())

        /** @see removeAll */
        @MustBeClosed
        fun removeAll(
            id: String,
            params: ParticipantRemoveAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = removeAll(params.toBuilder().id(id).build(), requestOptions)

        /** @see removeAll */
        @MustBeClosed
        fun removeAll(params: ParticipantRemoveAllParams): HttpResponse =
            removeAll(params, RequestOptions.none())

        /** @see removeAll */
        @MustBeClosed
        fun removeAll(
            params: ParticipantRemoveAllParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
