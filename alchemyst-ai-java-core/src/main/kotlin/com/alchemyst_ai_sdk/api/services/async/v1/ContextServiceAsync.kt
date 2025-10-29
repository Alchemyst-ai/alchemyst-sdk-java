// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.core.RequestOptions
import com.alchemyst_ai_sdk.api.core.http.HttpResponseFor
import com.alchemyst_ai_sdk.api.models.v1.context.ContextAddParams
import com.alchemyst_ai_sdk.api.models.v1.context.ContextAddResponse
import com.alchemyst_ai_sdk.api.models.v1.context.ContextDeleteParams
import com.alchemyst_ai_sdk.api.models.v1.context.ContextDeleteResponse
import com.alchemyst_ai_sdk.api.models.v1.context.ContextSearchParams
import com.alchemyst_ai_sdk.api.models.v1.context.ContextSearchResponse
import com.alchemyst_ai_sdk.api.services.async.v1.context.MemoryServiceAsync
import com.alchemyst_ai_sdk.api.services.async.v1.context.TraceServiceAsync
import com.alchemyst_ai_sdk.api.services.async.v1.context.ViewServiceAsync
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

    /** Deletes context data based on provided parameters */
    fun delete(): CompletableFuture<ContextDeleteResponse> = delete(ContextDeleteParams.none())

    /** @see delete */
    fun delete(
        params: ContextDeleteParams = ContextDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContextDeleteResponse>

    /** @see delete */
    fun delete(
        params: ContextDeleteParams = ContextDeleteParams.none()
    ): CompletableFuture<ContextDeleteResponse> = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(requestOptions: RequestOptions): CompletableFuture<ContextDeleteResponse> =
        delete(ContextDeleteParams.none(), requestOptions)

    /**
     * This endpoint accepts context data and sends it to a context processor for further handling.
     * It returns a success or error response depending on the result from the context processor.
     */
    fun add(): CompletableFuture<ContextAddResponse> = add(ContextAddParams.none())

    /** @see add */
    fun add(
        params: ContextAddParams = ContextAddParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContextAddResponse>

    /** @see add */
    fun add(
        params: ContextAddParams = ContextAddParams.none()
    ): CompletableFuture<ContextAddResponse> = add(params, RequestOptions.none())

    /** @see add */
    fun add(requestOptions: RequestOptions): CompletableFuture<ContextAddResponse> =
        add(ContextAddParams.none(), requestOptions)

    /**
     * This endpoint sends a search request to the context processor to retrieve relevant context
     * data based on the provided query.
     */
    fun search(params: ContextSearchParams): CompletableFuture<ContextSearchResponse> =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: ContextSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContextSearchResponse>

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
        fun delete(): CompletableFuture<HttpResponseFor<ContextDeleteResponse>> =
            delete(ContextDeleteParams.none())

        /** @see delete */
        fun delete(
            params: ContextDeleteParams = ContextDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContextDeleteResponse>>

        /** @see delete */
        fun delete(
            params: ContextDeleteParams = ContextDeleteParams.none()
        ): CompletableFuture<HttpResponseFor<ContextDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ContextDeleteResponse>> =
            delete(ContextDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/context/add`, but is otherwise the same as
         * [ContextServiceAsync.add].
         */
        fun add(): CompletableFuture<HttpResponseFor<ContextAddResponse>> =
            add(ContextAddParams.none())

        /** @see add */
        fun add(
            params: ContextAddParams = ContextAddParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContextAddResponse>>

        /** @see add */
        fun add(
            params: ContextAddParams = ContextAddParams.none()
        ): CompletableFuture<HttpResponseFor<ContextAddResponse>> =
            add(params, RequestOptions.none())

        /** @see add */
        fun add(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ContextAddResponse>> =
            add(ContextAddParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/context/search`, but is otherwise the same
         * as [ContextServiceAsync.search].
         */
        fun search(
            params: ContextSearchParams
        ): CompletableFuture<HttpResponseFor<ContextSearchResponse>> =
            search(params, RequestOptions.none())

        /** @see search */
        fun search(
            params: ContextSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContextSearchResponse>>
    }
}
