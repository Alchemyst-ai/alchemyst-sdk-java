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

    /** Deletes context data based on provided parameters */
    fun delete(): ContextDeleteResponse = delete(ContextDeleteParams.none())

    /** @see delete */
    fun delete(
        params: ContextDeleteParams = ContextDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContextDeleteResponse

    /** @see delete */
    fun delete(params: ContextDeleteParams = ContextDeleteParams.none()): ContextDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(requestOptions: RequestOptions): ContextDeleteResponse =
        delete(ContextDeleteParams.none(), requestOptions)

    /**
     * This endpoint accepts context data and sends it to a context processor for further handling.
     * It returns a success or error response depending on the result from the context processor.
     */
    fun add(): ContextAddResponse = add(ContextAddParams.none())

    /** @see add */
    fun add(
        params: ContextAddParams = ContextAddParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContextAddResponse

    /** @see add */
    fun add(params: ContextAddParams = ContextAddParams.none()): ContextAddResponse =
        add(params, RequestOptions.none())

    /** @see add */
    fun add(requestOptions: RequestOptions): ContextAddResponse =
        add(ContextAddParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `post /api/v1/context/delete`, but is otherwise the same
         * as [ContextService.delete].
         */
        @MustBeClosed
        fun delete(): HttpResponseFor<ContextDeleteResponse> = delete(ContextDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ContextDeleteParams = ContextDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContextDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ContextDeleteParams = ContextDeleteParams.none()
        ): HttpResponseFor<ContextDeleteResponse> = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(requestOptions: RequestOptions): HttpResponseFor<ContextDeleteResponse> =
            delete(ContextDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/context/add`, but is otherwise the same as
         * [ContextService.add].
         */
        @MustBeClosed fun add(): HttpResponseFor<ContextAddResponse> = add(ContextAddParams.none())

        /** @see add */
        @MustBeClosed
        fun add(
            params: ContextAddParams = ContextAddParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContextAddResponse>

        /** @see add */
        @MustBeClosed
        fun add(
            params: ContextAddParams = ContextAddParams.none()
        ): HttpResponseFor<ContextAddResponse> = add(params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(requestOptions: RequestOptions): HttpResponseFor<ContextAddResponse> =
            add(ContextAddParams.none(), requestOptions)

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
