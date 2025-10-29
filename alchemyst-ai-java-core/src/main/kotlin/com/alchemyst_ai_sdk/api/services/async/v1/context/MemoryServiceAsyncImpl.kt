// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1.context

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.core.RequestOptions
import com.alchemyst_ai_sdk.api.core.handlers.emptyHandler
import com.alchemyst_ai_sdk.api.core.handlers.errorBodyHandler
import com.alchemyst_ai_sdk.api.core.handlers.errorHandler
import com.alchemyst_ai_sdk.api.core.http.HttpMethod
import com.alchemyst_ai_sdk.api.core.http.HttpRequest
import com.alchemyst_ai_sdk.api.core.http.HttpResponse
import com.alchemyst_ai_sdk.api.core.http.HttpResponse.Handler
import com.alchemyst_ai_sdk.api.core.http.json
import com.alchemyst_ai_sdk.api.core.http.parseable
import com.alchemyst_ai_sdk.api.core.prepareAsync
import com.alchemyst_ai_sdk.api.models.v1.context.memory.MemoryAddParams
import com.alchemyst_ai_sdk.api.models.v1.context.memory.MemoryDeleteParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class MemoryServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MemoryServiceAsync {

    private val withRawResponse: MemoryServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MemoryServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryServiceAsync =
        MemoryServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun delete(
        params: MemoryDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /api/v1/context/memory/delete
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun add(
        params: MemoryAddParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /api/v1/context/memory/add
        withRawResponse().add(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MemoryServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MemoryServiceAsync.WithRawResponse =
            MemoryServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: MemoryDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "memory", "delete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }

        private val addHandler: Handler<Void?> = emptyHandler()

        override fun add(
            params: MemoryAddParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "memory", "add")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { addHandler.handle(it) }
                    }
                }
        }
    }
}
