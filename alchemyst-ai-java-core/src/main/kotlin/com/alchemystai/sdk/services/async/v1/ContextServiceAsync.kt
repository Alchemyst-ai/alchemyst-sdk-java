// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.ContextAddParams
import com.alchemystai.sdk.models.v1.context.ContextAddResponse
import com.alchemystai.sdk.models.v1.context.ContextDeleteParams
import com.alchemystai.sdk.models.v1.context.ContextDeleteResponse
import com.alchemystai.sdk.services.async.v1.context.MemoryServiceAsync
import com.alchemystai.sdk.services.async.v1.context.TraceServiceAsync
import com.alchemystai.sdk.services.async.v1.context.ViewServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ContextServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextServiceAsync

    fun traces(): TraceServiceAsync

    fun view(): ViewServiceAsync

    fun memory(): MemoryServiceAsync

    /**
     * This endpoint deletes context data based on the provided parameters. It returns a success or
     * error response depending on the result from the context processor.
     */
    fun delete(params: ContextDeleteParams): CompletableFuture<ContextDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ContextDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContextDeleteResponse>

    /**
     * This endpoint accepts context data and sends it to a context processor for further handling.
     * It returns a success or error response depending on the result from the context processor.
     */
    fun add(params: ContextAddParams): CompletableFuture<ContextAddResponse> =
        add(params, RequestOptions.none())

    /** @see add */
    fun add(
        params: ContextAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContextAddResponse>

    /**
     * A view of [ContextServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContextServiceAsync.WithRawResponse

        fun traces(): TraceServiceAsync.WithRawResponse

        fun view(): ViewServiceAsync.WithRawResponse

        fun memory(): MemoryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/delete`, but is otherwise the same
         * as [ContextServiceAsync.delete].
         */
        fun delete(
            params: ContextDeleteParams
        ): CompletableFuture<HttpResponseFor<ContextDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ContextDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContextDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /api/v1/context/add`, but is otherwise the same as
         * [ContextServiceAsync.add].
         */
        fun add(params: ContextAddParams): CompletableFuture<HttpResponseFor<ContextAddResponse>> =
            add(params, RequestOptions.none())

        /** @see add */
        fun add(
            params: ContextAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContextAddResponse>>
    }
}
