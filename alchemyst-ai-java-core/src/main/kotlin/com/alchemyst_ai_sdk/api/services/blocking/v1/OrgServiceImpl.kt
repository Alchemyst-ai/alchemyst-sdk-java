// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.blocking.v1

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.services.blocking.v1.org.ContextService
import com.alchemyst_ai_sdk.api.services.blocking.v1.org.ContextServiceImpl
import java.util.function.Consumer

class OrgServiceImpl internal constructor(private val clientOptions: ClientOptions) : OrgService {

    private val withRawResponse: OrgService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val context: ContextService by lazy { ContextServiceImpl(clientOptions) }

    override fun withRawResponse(): OrgService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrgService =
        OrgServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun context(): ContextService = context

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrgService.WithRawResponse {

        private val context: ContextService.WithRawResponse by lazy {
            ContextServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrgService.WithRawResponse =
            OrgServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun context(): ContextService.WithRawResponse = context
    }
}
