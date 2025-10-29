// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.services.blocking.v1.ContextService
import com.alchemystai.sdk.services.blocking.v1.OrgService
import java.util.function.Consumer

interface V1Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): V1Service

    fun context(): ContextService

    fun org(): OrgService

    /** A view of [V1Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): V1Service.WithRawResponse

        fun context(): ContextService.WithRawResponse

        fun org(): OrgService.WithRawResponse
    }
}
