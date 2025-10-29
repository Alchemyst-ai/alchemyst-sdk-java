// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.services.async.v1.ContextServiceAsync
import com.alchemystai.sdk.services.async.v1.ContextServiceAsyncImpl
import com.alchemystai.sdk.services.async.v1.OrgServiceAsync
import com.alchemystai.sdk.services.async.v1.OrgServiceAsyncImpl
import java.util.function.Consumer

class V1ServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    V1ServiceAsync {

    private val withRawResponse: V1ServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val context: ContextServiceAsync by lazy { ContextServiceAsyncImpl(clientOptions) }

    private val org: OrgServiceAsync by lazy { OrgServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): V1ServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): V1ServiceAsync =
        V1ServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun context(): ContextServiceAsync = context

    override fun org(): OrgServiceAsync = org

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        V1ServiceAsync.WithRawResponse {

        private val context: ContextServiceAsync.WithRawResponse by lazy {
            ContextServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val org: OrgServiceAsync.WithRawResponse by lazy {
            OrgServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): V1ServiceAsync.WithRawResponse =
            V1ServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun context(): ContextServiceAsync.WithRawResponse = context

        override fun org(): OrgServiceAsync.WithRawResponse = org
    }
}
