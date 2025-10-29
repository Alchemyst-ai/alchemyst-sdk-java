// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services.async.v1.context

import com.alchemyst_ai.sdk.core.ClientOptions
import com.alchemyst_ai.sdk.core.RequestOptions
import com.alchemyst_ai.sdk.core.http.HttpResponseFor
import com.alchemyst_ai.sdk.models.v1.context.view.ViewDocsParams
import com.alchemyst_ai.sdk.models.v1.context.view.ViewDocsResponse
import com.alchemyst_ai.sdk.models.v1.context.view.ViewRetrieveParams
import com.alchemyst_ai.sdk.models.v1.context.view.ViewRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ViewServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ViewServiceAsync

    /** Gets the context information for the authenticated user */
    fun retrieve(): CompletableFuture<ViewRetrieveResponse> = retrieve(ViewRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: ViewRetrieveParams = ViewRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ViewRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: ViewRetrieveParams = ViewRetrieveParams.none()
    ): CompletableFuture<ViewRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<ViewRetrieveResponse> =
        retrieve(ViewRetrieveParams.none(), requestOptions)

    /** Fetches documents view for authenticated user with optional organization context */
    fun docs(): CompletableFuture<ViewDocsResponse> = docs(ViewDocsParams.none())

    /** @see docs */
    fun docs(
        params: ViewDocsParams = ViewDocsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ViewDocsResponse>

    /** @see docs */
    fun docs(params: ViewDocsParams = ViewDocsParams.none()): CompletableFuture<ViewDocsResponse> =
        docs(params, RequestOptions.none())

    /** @see docs */
    fun docs(requestOptions: RequestOptions): CompletableFuture<ViewDocsResponse> =
        docs(ViewDocsParams.none(), requestOptions)

    /** A view of [ViewServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ViewServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/context/view`, but is otherwise the same as
         * [ViewServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<ViewRetrieveResponse>> =
            retrieve(ViewRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: ViewRetrieveParams = ViewRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ViewRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ViewRetrieveParams = ViewRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<ViewRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ViewRetrieveResponse>> =
            retrieve(ViewRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/context/view/docs`, but is otherwise the
         * same as [ViewServiceAsync.docs].
         */
        fun docs(): CompletableFuture<HttpResponseFor<ViewDocsResponse>> =
            docs(ViewDocsParams.none())

        /** @see docs */
        fun docs(
            params: ViewDocsParams = ViewDocsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ViewDocsResponse>>

        /** @see docs */
        fun docs(
            params: ViewDocsParams = ViewDocsParams.none()
        ): CompletableFuture<HttpResponseFor<ViewDocsResponse>> =
            docs(params, RequestOptions.none())

        /** @see docs */
        fun docs(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ViewDocsResponse>> =
            docs(ViewDocsParams.none(), requestOptions)
    }
}
