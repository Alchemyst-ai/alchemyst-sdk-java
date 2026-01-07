// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponse
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.memory.MemoryAddParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryAddResponse
import com.alchemystai.sdk.models.v1.context.memory.MemoryDeleteParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryUpdateParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MemoryServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryServiceAsync

    /** This endpoint updates memory context data. */
    fun update(params: MemoryUpdateParams): CompletableFuture<MemoryUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: MemoryUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MemoryUpdateResponse>

    /** Deletes memory context data based on provided parameters. */
    fun delete(params: MemoryDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: MemoryDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** This endpoint adds memory (chat history) as context. */
    fun add(params: MemoryAddParams): CompletableFuture<MemoryAddResponse> =
        add(params, RequestOptions.none())

    /** @see add */
    fun add(
        params: MemoryAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MemoryAddResponse>

    /**
     * A view of [MemoryServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MemoryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/update`, but is otherwise
         * the same as [MemoryServiceAsync.update].
         */
        fun update(
            params: MemoryUpdateParams
        ): CompletableFuture<HttpResponseFor<MemoryUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: MemoryUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MemoryUpdateResponse>>

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/delete`, but is otherwise
         * the same as [MemoryServiceAsync.delete].
         */
        fun delete(params: MemoryDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: MemoryDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/add`, but is otherwise the
         * same as [MemoryServiceAsync.add].
         */
        fun add(params: MemoryAddParams): CompletableFuture<HttpResponseFor<MemoryAddResponse>> =
            add(params, RequestOptions.none())

        /** @see add */
        fun add(
            params: MemoryAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MemoryAddResponse>>
    }
}
