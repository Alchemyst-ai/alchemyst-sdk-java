// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context.addasync

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusListParams
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusListResponse
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusRetrieveParams
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusRetrieveResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface StatusService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatusService

    /** Returns the status and result of a context add job by job id. */
    fun retrieve(id: String): StatusRetrieveResponse = retrieve(id, StatusRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: StatusRetrieveParams = StatusRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StatusRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: StatusRetrieveParams = StatusRetrieveParams.none(),
    ): StatusRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: StatusRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StatusRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: StatusRetrieveParams): StatusRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): StatusRetrieveResponse =
        retrieve(id, StatusRetrieveParams.none(), requestOptions)

    /**
     * Returns all jobs (active, waiting, delayed, failed, completed) belonging to the authenticated
     * user.
     */
    fun list(): StatusListResponse = list(StatusListParams.none())

    /** @see list */
    fun list(
        params: StatusListParams = StatusListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StatusListResponse

    /** @see list */
    fun list(params: StatusListParams = StatusListParams.none()): StatusListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): StatusListResponse =
        list(StatusListParams.none(), requestOptions)

    /** A view of [StatusService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatusService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/context/add-async/{id}/status`, but is
         * otherwise the same as [StatusService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<StatusRetrieveResponse> =
            retrieve(id, StatusRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: StatusRetrieveParams = StatusRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StatusRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: StatusRetrieveParams = StatusRetrieveParams.none(),
        ): HttpResponseFor<StatusRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: StatusRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StatusRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: StatusRetrieveParams): HttpResponseFor<StatusRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StatusRetrieveResponse> =
            retrieve(id, StatusRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/context/add-async/status`, but is otherwise
         * the same as [StatusService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<StatusListResponse> = list(StatusListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: StatusListParams = StatusListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StatusListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: StatusListParams = StatusListParams.none()
        ): HttpResponseFor<StatusListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<StatusListResponse> =
            list(StatusListParams.none(), requestOptions)
    }
}
