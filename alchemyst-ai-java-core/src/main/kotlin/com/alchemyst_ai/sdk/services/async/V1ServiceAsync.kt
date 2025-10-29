// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services.async

import com.alchemyst_ai.sdk.core.ClientOptions
import com.alchemyst_ai.sdk.services.async.v1.ContextServiceAsync
import com.alchemyst_ai.sdk.services.async.v1.OrgServiceAsync
import java.util.function.Consumer

interface V1ServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): V1ServiceAsync

    fun context(): ContextServiceAsync

    fun org(): OrgServiceAsync

    /** A view of [V1ServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): V1ServiceAsync.WithRawResponse

        fun context(): ContextServiceAsync.WithRawResponse

        fun org(): OrgServiceAsync.WithRawResponse
    }
}
