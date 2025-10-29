// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services.blocking.v1.context

import com.alchemyst_ai.sdk.core.ClientOptions
import com.alchemyst_ai.sdk.core.RequestOptions
import com.alchemyst_ai.sdk.core.http.HttpResponse
import com.alchemyst_ai.sdk.models.v1.context.memory.MemoryAddParams
import com.alchemyst_ai.sdk.models.v1.context.memory.MemoryDeleteParams
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

    /** Deletes memory context data based on provided parameters */
    fun delete() = delete(MemoryDeleteParams.none())

    /** @see delete */
    fun delete(
        params: MemoryDeleteParams = MemoryDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    fun delete(params: MemoryDeleteParams = MemoryDeleteParams.none()) =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(requestOptions: RequestOptions) = delete(MemoryDeleteParams.none(), requestOptions)

    /** This endpoint adds memory context data, fetching chat history if needed. */
    fun add() = add(MemoryAddParams.none())

    /** @see add */
    fun add(
        params: MemoryAddParams = MemoryAddParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see add */
    fun add(params: MemoryAddParams = MemoryAddParams.none()) = add(params, RequestOptions.none())

    /** @see add */
    fun add(requestOptions: RequestOptions) = add(MemoryAddParams.none(), requestOptions)

    /** A view of [MemoryService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/delete`, but is otherwise
         * the same as [MemoryService.delete].
         */
        @MustBeClosed fun delete(): HttpResponse = delete(MemoryDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: MemoryDeleteParams = MemoryDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: MemoryDeleteParams = MemoryDeleteParams.none()): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(requestOptions: RequestOptions): HttpResponse =
            delete(MemoryDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/add`, but is otherwise the
         * same as [MemoryService.add].
         */
        @MustBeClosed fun add(): HttpResponse = add(MemoryAddParams.none())

        /** @see add */
        @MustBeClosed
        fun add(
            params: MemoryAddParams = MemoryAddParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see add */
        @MustBeClosed
        fun add(params: MemoryAddParams = MemoryAddParams.none()): HttpResponse =
            add(params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(requestOptions: RequestOptions): HttpResponse =
            add(MemoryAddParams.none(), requestOptions)
    }
}
