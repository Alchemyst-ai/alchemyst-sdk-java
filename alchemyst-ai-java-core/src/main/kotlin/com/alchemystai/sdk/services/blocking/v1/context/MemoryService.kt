// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponse
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.memory.MemoryDeleteParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryUpdateParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryUpdateResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface MemoryService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryService

    /** This endpoint updates memory context data. */
    fun update(params: MemoryUpdateParams): MemoryUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: MemoryUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MemoryUpdateResponse

    /** Deletes memory context data based on provided parameters. */
    fun delete(params: MemoryDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(params: MemoryDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** A view of [MemoryService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/update`, but is otherwise
         * the same as [MemoryService.update].
         */
        @MustBeClosed
        fun update(params: MemoryUpdateParams): HttpResponseFor<MemoryUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: MemoryUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MemoryUpdateResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/delete`, but is otherwise
         * the same as [MemoryService.delete].
         */
        @MustBeClosed
        fun delete(params: MemoryDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: MemoryDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
