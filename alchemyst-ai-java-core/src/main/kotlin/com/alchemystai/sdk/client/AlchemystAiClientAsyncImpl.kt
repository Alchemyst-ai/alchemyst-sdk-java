// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.client

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.getPackageVersion
import com.alchemystai.sdk.services.async.V1ServiceAsync
import com.alchemystai.sdk.services.async.V1ServiceAsyncImpl
import java.util.function.Consumer

class AlchemystAiClientAsyncImpl(private val clientOptions: ClientOptions) :
    AlchemystAiClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: AlchemystAiClient by lazy { AlchemystAiClientImpl(clientOptions) }

    private val withRawResponse: AlchemystAiClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val v1: V1ServiceAsync by lazy { V1ServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): AlchemystAiClient = sync

    override fun withRawResponse(): AlchemystAiClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlchemystAiClientAsync =
        AlchemystAiClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun v1(): V1ServiceAsync = v1

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AlchemystAiClientAsync.WithRawResponse {

        private val v1: V1ServiceAsync.WithRawResponse by lazy {
            V1ServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlchemystAiClientAsync.WithRawResponse =
            AlchemystAiClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun v1(): V1ServiceAsync.WithRawResponse = v1
    }
}
