// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.org

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.org.context.ContextViewParams
import com.alchemystai.sdk.models.v1.org.context.ContextViewResponse
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

    /** View organization context */
    fun view(params: ContextViewParams): ContextViewResponse = view(params, RequestOptions.none())

    /** @see view */
    fun view(
        params: ContextViewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContextViewResponse

    /** A view of [ContextService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/org/context/view`, but is otherwise the
         * same as [ContextService.view].
         */
        @MustBeClosed
        fun view(params: ContextViewParams): HttpResponseFor<ContextViewResponse> =
            view(params, RequestOptions.none())

        /** @see view */
        @MustBeClosed
        fun view(
            params: ContextViewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContextViewResponse>
    }
}
