// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1.context

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.core.RequestOptions
import com.alchemyst_ai_sdk.api.core.http.HttpResponse
import com.alchemyst_ai_sdk.api.models.v1.context.memory.MemoryAddParams
import com.alchemyst_ai_sdk.api.models.v1.context.memory.MemoryDeleteParams
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

    /** Deletes memory context data based on provided parameters */
    fun delete(): CompletableFuture<Void?> = delete(MemoryDeleteParams.none())

    /** @see delete */
    fun delete(
        params: MemoryDeleteParams = MemoryDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: MemoryDeleteParams = MemoryDeleteParams.none()): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(MemoryDeleteParams.none(), requestOptions)

    /** This endpoint adds memory context data, fetching chat history if needed. */
    fun add(): CompletableFuture<Void?> = add(MemoryAddParams.none())

    /** @see add */
    fun add(
        params: MemoryAddParams = MemoryAddParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see add */
    fun add(params: MemoryAddParams = MemoryAddParams.none()): CompletableFuture<Void?> =
        add(params, RequestOptions.none())

    /** @see add */
    fun add(requestOptions: RequestOptions): CompletableFuture<Void?> =
        add(MemoryAddParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `post /api/v1/context/memory/delete`, but is otherwise
         * the same as [MemoryServiceAsync.delete].
         */
        fun delete(): CompletableFuture<HttpResponse> = delete(MemoryDeleteParams.none())

        /** @see delete */
        fun delete(
            params: MemoryDeleteParams = MemoryDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(
            params: MemoryDeleteParams = MemoryDeleteParams.none()
        ): CompletableFuture<HttpResponse> = delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(MemoryDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/context/memory/add`, but is otherwise the
         * same as [MemoryServiceAsync.add].
         */
        fun add(): CompletableFuture<HttpResponse> = add(MemoryAddParams.none())

        /** @see add */
        fun add(
            params: MemoryAddParams = MemoryAddParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see add */
        fun add(params: MemoryAddParams = MemoryAddParams.none()): CompletableFuture<HttpResponse> =
            add(params, RequestOptions.none())

        /** @see add */
        fun add(requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            add(MemoryAddParams.none(), requestOptions)
    }
}
