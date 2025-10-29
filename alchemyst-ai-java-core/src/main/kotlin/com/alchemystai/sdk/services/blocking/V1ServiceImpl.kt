// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.services.blocking.v1.ContextService
import com.alchemystai.sdk.services.blocking.v1.ContextServiceImpl
import com.alchemystai.sdk.services.blocking.v1.OrgService
import com.alchemystai.sdk.services.blocking.v1.OrgServiceImpl
import java.util.function.Consumer

class V1ServiceImpl internal constructor(private val clientOptions: ClientOptions) : V1Service {

    private val withRawResponse: V1Service.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val context: ContextService by lazy { ContextServiceImpl(clientOptions) }

    private val org: OrgService by lazy { OrgServiceImpl(clientOptions) }

    override fun withRawResponse(): V1Service.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): V1Service =
        V1ServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun context(): ContextService = context

    override fun org(): OrgService = org

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V1Service.WithRawResponse {

        private val context: ContextService.WithRawResponse by lazy {
            ContextServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val org: OrgService.WithRawResponse by lazy {
            OrgServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): V1Service.WithRawResponse =
            V1ServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun context(): ContextService.WithRawResponse = context

        override fun org(): OrgService.WithRawResponse = org
    }
}
