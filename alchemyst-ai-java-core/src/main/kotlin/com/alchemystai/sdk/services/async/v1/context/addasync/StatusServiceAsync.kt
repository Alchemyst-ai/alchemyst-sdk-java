// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context.addasync

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusListParams
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusListResponse
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusRetrieveParams
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface StatusServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatusServiceAsync

    /** Returns the status and result of a context add job by job id. */
    fun retrieve(id: String): CompletableFuture<StatusRetrieveResponse> =
        retrieve(id, StatusRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: StatusRetrieveParams = StatusRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StatusRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: StatusRetrieveParams = StatusRetrieveParams.none(),
    ): CompletableFuture<StatusRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: StatusRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StatusRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: StatusRetrieveParams): CompletableFuture<StatusRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<StatusRetrieveResponse> =
        retrieve(id, StatusRetrieveParams.none(), requestOptions)

    /**
     * Returns all jobs (active, waiting, delayed, failed, completed) belonging to the authenticated
     * user.
     */
    fun list(): CompletableFuture<StatusListResponse> = list(StatusListParams.none())

    /** @see list */
    fun list(
        params: StatusListParams = StatusListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StatusListResponse>

    /** @see list */
    fun list(
        params: StatusListParams = StatusListParams.none()
    ): CompletableFuture<StatusListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<StatusListResponse> =
        list(StatusListParams.none(), requestOptions)

    /**
     * A view of [StatusServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StatusServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/context/add-async/{id}/status`, but is
         * otherwise the same as [StatusServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<StatusRetrieveResponse>> =
            retrieve(id, StatusRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: StatusRetrieveParams = StatusRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StatusRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: StatusRetrieveParams = StatusRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<StatusRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: StatusRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StatusRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: StatusRetrieveParams
        ): CompletableFuture<HttpResponseFor<StatusRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StatusRetrieveResponse>> =
            retrieve(id, StatusRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/context/add-async/status`, but is otherwise
         * the same as [StatusServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<StatusListResponse>> =
            list(StatusListParams.none())

        /** @see list */
        fun list(
            params: StatusListParams = StatusListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StatusListResponse>>

        /** @see list */
        fun list(
            params: StatusListParams = StatusListParams.none()
        ): CompletableFuture<HttpResponseFor<StatusListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<StatusListResponse>> =
            list(StatusListParams.none(), requestOptions)
    }
}
