// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.client

import com.alchemyst_ai.sdk.core.ClientOptions
import com.alchemyst_ai.sdk.core.getPackageVersion
import com.alchemyst_ai.sdk.services.blocking.V1Service
import com.alchemyst_ai.sdk.services.blocking.V1ServiceImpl
import java.util.function.Consumer

class AlchemystAiClientImpl(private val clientOptions: ClientOptions) : AlchemystAiClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: AlchemystAiClientAsync by lazy { AlchemystAiClientAsyncImpl(clientOptions) }

    private val withRawResponse: AlchemystAiClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val v1: V1Service by lazy { V1ServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): AlchemystAiClientAsync = async

    override fun withRawResponse(): AlchemystAiClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlchemystAiClient =
        AlchemystAiClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun v1(): V1Service = v1

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AlchemystAiClient.WithRawResponse {

        private val v1: V1Service.WithRawResponse by lazy {
            V1ServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlchemystAiClient.WithRawResponse =
            AlchemystAiClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun v1(): V1Service.WithRawResponse = v1
    }
}
