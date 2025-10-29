// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.services.async.v1.org.ContextServiceAsync
import com.alchemystai.sdk.services.async.v1.org.ContextServiceAsyncImpl
import java.util.function.Consumer

class OrgServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OrgServiceAsync {

    private val withRawResponse: OrgServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val context: ContextServiceAsync by lazy { ContextServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): OrgServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrgServiceAsync =
        OrgServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun context(): ContextServiceAsync = context

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrgServiceAsync.WithRawResponse {

        private val context: ContextServiceAsync.WithRawResponse by lazy {
            ContextServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrgServiceAsync.WithRawResponse =
            OrgServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun context(): ContextServiceAsync.WithRawResponse = context
    }
}
