// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCancelParams
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCancelResponse
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateParams
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateResponse
import com.alchemystai.sdk.services.async.v1.context.addasync.StatusServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AddAsyncServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AddAsyncServiceAsync

    fun status(): StatusServiceAsync

    /**
     * This endpoint accepts context data and queues it for asynchronous processing by the context
     * processor. It returns a success or error response depending on the queuing result.
     */
    fun create(params: AddAsyncCreateParams): CompletableFuture<AddAsyncCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AddAsyncCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AddAsyncCreateResponse>

    /**
     * Attempts to cancel a context add job by job id.
     * - If the job is already completed or failed, returns 404.
     * - If the job is currently running ("active"), returns 409 and cannot be cancelled.
     * - Only jobs in "waiting" or "delayed" state can be cancelled.
     */
    fun cancel(id: String): CompletableFuture<AddAsyncCancelResponse> =
        cancel(id, AddAsyncCancelParams.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AddAsyncCancelResponse> =
        cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        id: String,
        params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
    ): CompletableFuture<AddAsyncCancelResponse> = cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: AddAsyncCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AddAsyncCancelResponse>

    /** @see cancel */
    fun cancel(params: AddAsyncCancelParams): CompletableFuture<AddAsyncCancelResponse> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AddAsyncCancelResponse> =
        cancel(id, AddAsyncCancelParams.none(), requestOptions)

    /**
     * A view of [AddAsyncServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AddAsyncServiceAsync.WithRawResponse

        fun status(): StatusServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/add-async`, but is otherwise the
         * same as [AddAsyncServiceAsync.create].
         */
        fun create(
            params: AddAsyncCreateParams
        ): CompletableFuture<HttpResponseFor<AddAsyncCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AddAsyncCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AddAsyncCreateResponse>>

        /**
         * Returns a raw HTTP response for `delete /api/v1/context/add-async/{id}/cancel`, but is
         * otherwise the same as [AddAsyncServiceAsync.cancel].
         */
        fun cancel(id: String): CompletableFuture<HttpResponseFor<AddAsyncCancelResponse>> =
            cancel(id, AddAsyncCancelParams.none())

        /** @see cancel */
        fun cancel(
            id: String,
            params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AddAsyncCancelResponse>> =
            cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        fun cancel(
            id: String,
            params: AddAsyncCancelParams = AddAsyncCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<AddAsyncCancelResponse>> =
            cancel(id, params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            params: AddAsyncCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AddAsyncCancelResponse>>

        /** @see cancel */
        fun cancel(
            params: AddAsyncCancelParams
        ): CompletableFuture<HttpResponseFor<AddAsyncCancelResponse>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AddAsyncCancelResponse>> =
            cancel(id, AddAsyncCancelParams.none(), requestOptions)
    }
}
