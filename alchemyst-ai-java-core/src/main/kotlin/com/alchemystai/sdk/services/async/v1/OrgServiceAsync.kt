// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.services.async.v1.org.ContextServiceAsync
import java.util.function.Consumer

interface OrgServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrgServiceAsync

    fun context(): ContextServiceAsync

    /** A view of [OrgServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrgServiceAsync.WithRawResponse

        fun context(): ContextServiceAsync.WithRawResponse
    }
}
