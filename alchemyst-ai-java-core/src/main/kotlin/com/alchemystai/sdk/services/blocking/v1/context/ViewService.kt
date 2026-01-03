// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.view.ViewDocsParams
import com.alchemystai.sdk.models.v1.context.view.ViewDocsResponse
import com.alchemystai.sdk.models.v1.context.view.ViewRetrieveParams
import com.alchemystai.sdk.models.v1.context.view.ViewRetrieveResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface ViewService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ViewService

    /** Gets the context information for the authenticated user. */
    fun retrieve(): ViewRetrieveResponse = retrieve(ViewRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: ViewRetrieveParams = ViewRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ViewRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ViewRetrieveParams = ViewRetrieveParams.none()): ViewRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): ViewRetrieveResponse =
        retrieve(ViewRetrieveParams.none(), requestOptions)

    /** Fetches documents view for authenticated user with optional organization context. */
    fun docs(): ViewDocsResponse = docs(ViewDocsParams.none())

    /** @see docs */
    fun docs(
        params: ViewDocsParams = ViewDocsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ViewDocsResponse

    /** @see docs */
    fun docs(params: ViewDocsParams = ViewDocsParams.none()): ViewDocsResponse =
        docs(params, RequestOptions.none())

    /** @see docs */
    fun docs(requestOptions: RequestOptions): ViewDocsResponse =
        docs(ViewDocsParams.none(), requestOptions)

    /** A view of [ViewService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ViewService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/context/view`, but is otherwise the same as
         * [ViewService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<ViewRetrieveResponse> = retrieve(ViewRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ViewRetrieveParams = ViewRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ViewRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ViewRetrieveParams = ViewRetrieveParams.none()
        ): HttpResponseFor<ViewRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<ViewRetrieveResponse> =
            retrieve(ViewRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/context/view/docs`, but is otherwise the
         * same as [ViewService.docs].
         */
        @MustBeClosed fun docs(): HttpResponseFor<ViewDocsResponse> = docs(ViewDocsParams.none())

        /** @see docs */
        @MustBeClosed
        fun docs(
            params: ViewDocsParams = ViewDocsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ViewDocsResponse>

        /** @see docs */
        @MustBeClosed
        fun docs(
            params: ViewDocsParams = ViewDocsParams.none()
        ): HttpResponseFor<ViewDocsResponse> = docs(params, RequestOptions.none())

        /** @see docs */
        @MustBeClosed
        fun docs(requestOptions: RequestOptions): HttpResponseFor<ViewDocsResponse> =
            docs(ViewDocsParams.none(), requestOptions)
    }
}
