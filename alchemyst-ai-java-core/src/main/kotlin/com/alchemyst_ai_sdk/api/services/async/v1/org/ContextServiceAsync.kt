// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1.org

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.core.RequestOptions
import com.alchemyst_ai_sdk.api.core.http.HttpResponseFor
import com.alchemyst_ai_sdk.api.models.v1.org.context.ContextViewParams
import com.alchemyst_ai_sdk.api.models.v1.org.context.ContextViewResponse
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

    /** View organization context */
    fun view(params: ContextViewParams): CompletableFuture<ContextViewResponse> =
        view(params, RequestOptions.none())

    /** @see view */
    fun view(
        params: ContextViewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContextViewResponse>

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

        /**
         * Returns a raw HTTP response for `post /api/v1/org/context/view`, but is otherwise the
         * same as [ContextServiceAsync.view].
         */
        fun view(
            params: ContextViewParams
        ): CompletableFuture<HttpResponseFor<ContextViewResponse>> =
            view(params, RequestOptions.none())

        /** @see view */
        fun view(
            params: ContextViewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContextViewResponse>>
    }
}
