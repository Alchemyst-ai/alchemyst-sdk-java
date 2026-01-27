// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.ContextAddParams
import com.alchemystai.sdk.models.v1.context.ContextAddResponse
import com.alchemystai.sdk.models.v1.context.ContextDeleteParams
import com.alchemystai.sdk.models.v1.context.ContextDeleteResponse
import com.alchemystai.sdk.models.v1.context.ContextSearchParams
import com.alchemystai.sdk.models.v1.context.ContextSearchResponse
import com.alchemystai.sdk.services.blocking.v1.context.AddAsyncService
import com.alchemystai.sdk.services.blocking.v1.context.MemoryService
import com.alchemystai.sdk.services.blocking.v1.context.TraceService
import com.alchemystai.sdk.services.blocking.v1.context.ViewService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface ContextService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextService

    fun traces(): TraceService

    fun view(): ViewService

    fun memory(): MemoryService

    fun addAsync(): AddAsyncService

    /**
     * This endpoint deletes context data based on the provided parameters. It returns a success or
     * error response depending on the result from the context processor.
     */
    fun delete(params: ContextDeleteParams): ContextDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ContextDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContextDeleteResponse

    /**
     * This endpoint accepts context data and sends it to a context processor for further handling.
     * It returns a success or error response depending on the result from the context processor.
     */
    fun add(params: ContextAddParams): ContextAddResponse = add(params, RequestOptions.none())

    /** @see add */
    fun add(
        params: ContextAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContextAddResponse

    /**
     * This endpoint sends a search request to the context processor to retrieve relevant context
     * data based on the provided query.
     */
    fun search(params: ContextSearchParams): ContextSearchResponse =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: ContextSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContextSearchResponse

    /** A view of [ContextService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextService.WithRawResponse

        fun traces(): TraceService.WithRawResponse

        fun view(): ViewService.WithRawResponse

        fun memory(): MemoryService.WithRawResponse

        fun addAsync(): AddAsyncService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/delete`, but is otherwise the same
         * as [ContextService.delete].
         */
        @MustBeClosed
        fun delete(params: ContextDeleteParams): HttpResponseFor<ContextDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ContextDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContextDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/context/add`, but is otherwise the same as
         * [ContextService.add].
         */
        @MustBeClosed
        fun add(params: ContextAddParams): HttpResponseFor<ContextAddResponse> =
            add(params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(
            params: ContextAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContextAddResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/context/search`, but is otherwise the same
         * as [ContextService.search].
         */
        @MustBeClosed
        fun search(params: ContextSearchParams): HttpResponseFor<ContextSearchResponse> =
            search(params, RequestOptions.none())

        /** @see search */
        @MustBeClosed
        fun search(
            params: ContextSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContextSearchResponse>
    }
}
