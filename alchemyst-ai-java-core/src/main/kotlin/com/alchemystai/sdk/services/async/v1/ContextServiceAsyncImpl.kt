// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.handlers.errorBodyHandler
import com.alchemystai.sdk.core.handlers.errorHandler
import com.alchemystai.sdk.core.handlers.jsonHandler
import com.alchemystai.sdk.core.http.HttpMethod
import com.alchemystai.sdk.core.http.HttpRequest
import com.alchemystai.sdk.core.http.HttpResponse
import com.alchemystai.sdk.core.http.HttpResponse.Handler
import com.alchemystai.sdk.core.http.HttpResponseFor
import com.alchemystai.sdk.core.http.json
import com.alchemystai.sdk.core.http.parseable
import com.alchemystai.sdk.core.prepareAsync
import com.alchemystai.sdk.models.v1.context.ContextAddParams
import com.alchemystai.sdk.models.v1.context.ContextAddResponse
import com.alchemystai.sdk.models.v1.context.ContextDeleteParams
import com.alchemystai.sdk.models.v1.context.ContextDeleteResponse
import com.alchemystai.sdk.models.v1.context.ContextSearchParams
import com.alchemystai.sdk.models.v1.context.ContextSearchResponse
import com.alchemystai.sdk.services.async.v1.context.AddAsyncServiceAsync
import com.alchemystai.sdk.services.async.v1.context.AddAsyncServiceAsyncImpl
import com.alchemystai.sdk.services.async.v1.context.MemoryServiceAsync
import com.alchemystai.sdk.services.async.v1.context.MemoryServiceAsyncImpl
import com.alchemystai.sdk.services.async.v1.context.TraceServiceAsync
import com.alchemystai.sdk.services.async.v1.context.TraceServiceAsyncImpl
import com.alchemystai.sdk.services.async.v1.context.ViewServiceAsync
import com.alchemystai.sdk.services.async.v1.context.ViewServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ContextServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ContextServiceAsync {

    private val withRawResponse: ContextServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val traces: TraceServiceAsync by lazy { TraceServiceAsyncImpl(clientOptions) }

    private val view: ViewServiceAsync by lazy { ViewServiceAsyncImpl(clientOptions) }

    private val memory: MemoryServiceAsync by lazy { MemoryServiceAsyncImpl(clientOptions) }

    private val addAsync: AddAsyncServiceAsync by lazy { AddAsyncServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ContextServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextServiceAsync =
        ContextServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun traces(): TraceServiceAsync = traces

    override fun view(): ViewServiceAsync = view

    override fun memory(): MemoryServiceAsync = memory

    override fun addAsync(): AddAsyncServiceAsync = addAsync

    override fun delete(
        params: ContextDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContextDeleteResponse> =
        // post /api/v1/context/delete
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun add(
        params: ContextAddParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContextAddResponse> =
        // post /api/v1/context/add
        withRawResponse().add(params, requestOptions).thenApply { it.parse() }

    override fun search(
        params: ContextSearchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContextSearchResponse> =
        // post /api/v1/context/search
        withRawResponse().search(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContextServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val traces: TraceServiceAsync.WithRawResponse by lazy {
            TraceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val view: ViewServiceAsync.WithRawResponse by lazy {
            ViewServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val memory: MemoryServiceAsync.WithRawResponse by lazy {
            MemoryServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val addAsync: AddAsyncServiceAsync.WithRawResponse by lazy {
            AddAsyncServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContextServiceAsync.WithRawResponse =
            ContextServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun traces(): TraceServiceAsync.WithRawResponse = traces

        override fun view(): ViewServiceAsync.WithRawResponse = view

        override fun memory(): MemoryServiceAsync.WithRawResponse = memory

        override fun addAsync(): AddAsyncServiceAsync.WithRawResponse = addAsync

        private val deleteHandler: Handler<ContextDeleteResponse> =
            jsonHandler<ContextDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: ContextDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContextDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "delete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deleteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val addHandler: Handler<ContextAddResponse> =
            jsonHandler<ContextAddResponse>(clientOptions.jsonMapper)

        override fun add(
            params: ContextAddParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContextAddResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "add")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { addHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val searchHandler: Handler<ContextSearchResponse> =
            jsonHandler<ContextSearchResponse>(clientOptions.jsonMapper)

        override fun search(
            params: ContextSearchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContextSearchResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "search")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { searchHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
