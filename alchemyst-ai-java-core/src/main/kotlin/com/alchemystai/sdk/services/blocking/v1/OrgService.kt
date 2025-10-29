// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.services.blocking.v1.org.ContextService
import java.util.function.Consumer

interface OrgService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrgService

    fun context(): ContextService

    /** A view of [OrgService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrgService.WithRawResponse

        fun context(): ContextService.WithRawResponse
    }
}
