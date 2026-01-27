// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCancelParams
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCancelResponse
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateParams
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateResponse
import com.alchemystai.sdk.services.blocking.v1.context.addasync.StatusService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface AddAsyncService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AddAsyncService

    fun status(): StatusService

    /**
     * This endpoint accepts context data and queues it for asynchronous processing by the context
     * processor. It returns a success or error response depending on the queuing result.
     */
    fun create(params: AddAsyncCreateParams): AddAsyncCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AddAsyncCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddAsyncCreateResponse

    /**
     * Attempts to cancel a context add job by job id.
     * - If the job is already completed or failed, returns 404.
     * - If the job is currently running ("active"), returns 409 and cannot be cancelled.
     * - Only jobs in "waiting" or "delayed" state can be cancelled.
     */
    fun cancel(id: String): AddAsyncCancelResponse = cancel(id, AddAsyncCancelParams.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddAsyncCancelResponse = cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        id: String,
        params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
    ): AddAsyncCancelResponse = cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: AddAsyncCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddAsyncCancelResponse

    /** @see cancel */
    fun cancel(params: AddAsyncCancelParams): AddAsyncCancelResponse =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(id: String, requestOptions: RequestOptions): AddAsyncCancelResponse =
        cancel(id, AddAsyncCancelParams.none(), requestOptions)

    /** A view of [AddAsyncService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AddAsyncService.WithRawResponse

        fun status(): StatusService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/add-async`, but is otherwise the
         * same as [AddAsyncService.create].
         */
        @MustBeClosed
        fun create(params: AddAsyncCreateParams): HttpResponseFor<AddAsyncCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AddAsyncCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddAsyncCreateResponse>

        /**
         * Returns a raw HTTP response for `delete /api/v1/context/add-async/{id}/cancel`, but is
         * otherwise the same as [AddAsyncService.cancel].
         */
        @MustBeClosed
        fun cancel(id: String): HttpResponseFor<AddAsyncCancelResponse> =
            cancel(id, AddAsyncCancelParams.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddAsyncCancelResponse> =
            cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
        ): HttpResponseFor<AddAsyncCancelResponse> = cancel(id, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: AddAsyncCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddAsyncCancelResponse>

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: AddAsyncCancelParams): HttpResponseFor<AddAsyncCancelResponse> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddAsyncCancelResponse> =
            cancel(id, AddAsyncCancelParams.none(), requestOptions)
    }
}
