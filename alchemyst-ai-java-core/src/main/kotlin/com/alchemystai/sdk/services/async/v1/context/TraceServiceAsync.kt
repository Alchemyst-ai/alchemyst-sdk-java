// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.traces.TraceDeleteParams
import com.alchemystai.sdk.models.v1.context.traces.TraceDeleteResponse
import com.alchemystai.sdk.models.v1.context.traces.TraceListParams
import com.alchemystai.sdk.models.v1.context.traces.TraceListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TraceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceServiceAsync

    /** Returns paginated traces for the authenticated user within their organization. */
    fun list(): CompletableFuture<TraceListResponse> = list(TraceListParams.none())

    /** @see list */
    fun list(
        params: TraceListParams = TraceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TraceListResponse>

    /** @see list */
    fun list(
        params: TraceListParams = TraceListParams.none()
    ): CompletableFuture<TraceListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<TraceListResponse> =
        list(TraceListParams.none(), requestOptions)

    /** Deletes a data trace for the authenticated user with the specified trace ID. */
    fun delete(traceId: String): CompletableFuture<TraceDeleteResponse> =
        delete(traceId, TraceDeleteParams.none())

    /** @see delete */
    fun delete(
        traceId: String,
        params: TraceDeleteParams = TraceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TraceDeleteResponse> =
        delete(params.toBuilder().traceId(traceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        traceId: String,
        params: TraceDeleteParams = TraceDeleteParams.none(),
    ): CompletableFuture<TraceDeleteResponse> = delete(traceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TraceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TraceDeleteResponse>

    /** @see delete */
    fun delete(params: TraceDeleteParams): CompletableFuture<TraceDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        traceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TraceDeleteResponse> =
        delete(traceId, TraceDeleteParams.none(), requestOptions)

    /** A view of [TraceServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TraceServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/context/traces`, but is otherwise the same
         * as [TraceServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<TraceListResponse>> =
            list(TraceListParams.none())

        /** @see list */
        fun list(
            params: TraceListParams = TraceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TraceListResponse>>

        /** @see list */
        fun list(
            params: TraceListParams = TraceListParams.none()
        ): CompletableFuture<HttpResponseFor<TraceListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TraceListResponse>> =
            list(TraceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api/v1/context/traces/{traceId}/delete`, but is
         * otherwise the same as [TraceServiceAsync.delete].
         */
        fun delete(traceId: String): CompletableFuture<HttpResponseFor<TraceDeleteResponse>> =
            delete(traceId, TraceDeleteParams.none())

        /** @see delete */
        fun delete(
            traceId: String,
            params: TraceDeleteParams = TraceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TraceDeleteResponse>> =
            delete(params.toBuilder().traceId(traceId).build(), requestOptions)

        /** @see delete */
        fun delete(
            traceId: String,
            params: TraceDeleteParams = TraceDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<TraceDeleteResponse>> =
            delete(traceId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: TraceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TraceDeleteResponse>>

        /** @see delete */
        fun delete(
            params: TraceDeleteParams
        ): CompletableFuture<HttpResponseFor<TraceDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            traceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TraceDeleteResponse>> =
            delete(traceId, TraceDeleteParams.none(), requestOptions)
    }
}
