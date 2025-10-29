// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.blocking.v1.context

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.core.RequestOptions
import com.alchemyst_ai_sdk.api.core.http.HttpResponseFor
import com.alchemyst_ai_sdk.api.models.v1.context.traces.TraceDeleteParams
import com.alchemyst_ai_sdk.api.models.v1.context.traces.TraceDeleteResponse
import com.alchemyst_ai_sdk.api.models.v1.context.traces.TraceListParams
import com.alchemyst_ai_sdk.api.models.v1.context.traces.TraceListResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface TraceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceService

    /** Retrieves a list of traces for the authenticated user */
    fun list(): TraceListResponse = list(TraceListParams.none())

    /** @see list */
    fun list(
        params: TraceListParams = TraceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TraceListResponse

    /** @see list */
    fun list(params: TraceListParams = TraceListParams.none()): TraceListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): TraceListResponse =
        list(TraceListParams.none(), requestOptions)

    /** Deletes a data trace for the authenticated user with the specified trace ID */
    fun delete(traceId: String): TraceDeleteResponse = delete(traceId, TraceDeleteParams.none())

    /** @see delete */
    fun delete(
        traceId: String,
        params: TraceDeleteParams = TraceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TraceDeleteResponse = delete(params.toBuilder().traceId(traceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        traceId: String,
        params: TraceDeleteParams = TraceDeleteParams.none(),
    ): TraceDeleteResponse = delete(traceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TraceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TraceDeleteResponse

    /** @see delete */
    fun delete(params: TraceDeleteParams): TraceDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(traceId: String, requestOptions: RequestOptions): TraceDeleteResponse =
        delete(traceId, TraceDeleteParams.none(), requestOptions)

    /** A view of [TraceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/context/traces`, but is otherwise the same
         * as [TraceService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<TraceListResponse> = list(TraceListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TraceListParams = TraceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TraceListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: TraceListParams = TraceListParams.none()
        ): HttpResponseFor<TraceListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TraceListResponse> =
            list(TraceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api/v1/context/traces/{traceId}/delete`, but is
         * otherwise the same as [TraceService.delete].
         */
        @MustBeClosed
        fun delete(traceId: String): HttpResponseFor<TraceDeleteResponse> =
            delete(traceId, TraceDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            traceId: String,
            params: TraceDeleteParams = TraceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TraceDeleteResponse> =
            delete(params.toBuilder().traceId(traceId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            traceId: String,
            params: TraceDeleteParams = TraceDeleteParams.none(),
        ): HttpResponseFor<TraceDeleteResponse> = delete(traceId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: TraceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TraceDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: TraceDeleteParams): HttpResponseFor<TraceDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            traceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TraceDeleteResponse> =
            delete(traceId, TraceDeleteParams.none(), requestOptions)
    }
}
