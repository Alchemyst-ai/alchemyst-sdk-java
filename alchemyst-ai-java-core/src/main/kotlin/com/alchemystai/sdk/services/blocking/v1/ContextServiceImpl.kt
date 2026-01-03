// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1

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
import com.alchemystai.sdk.core.prepare
import com.alchemystai.sdk.models.v1.context.ContextAddParams
import com.alchemystai.sdk.models.v1.context.ContextAddResponse
import com.alchemystai.sdk.models.v1.context.ContextDeleteParams
import com.alchemystai.sdk.models.v1.context.ContextDeleteResponse
import com.alchemystai.sdk.services.blocking.v1.context.MemoryService
import com.alchemystai.sdk.services.blocking.v1.context.MemoryServiceImpl
import com.alchemystai.sdk.services.blocking.v1.context.TraceService
import com.alchemystai.sdk.services.blocking.v1.context.TraceServiceImpl
import com.alchemystai.sdk.services.blocking.v1.context.ViewService
import com.alchemystai.sdk.services.blocking.v1.context.ViewServiceImpl
import java.util.function.Consumer

class ContextServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ContextService {

    private val withRawResponse: ContextService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val traces: TraceService by lazy { TraceServiceImpl(clientOptions) }

    private val view: ViewService by lazy { ViewServiceImpl(clientOptions) }

    private val memory: MemoryService by lazy { MemoryServiceImpl(clientOptions) }

    override fun withRawResponse(): ContextService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextService =
        ContextServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun traces(): TraceService = traces

    override fun view(): ViewService = view

    override fun memory(): MemoryService = memory

    override fun delete(
        params: ContextDeleteParams,
        requestOptions: RequestOptions,
    ): ContextDeleteResponse =
        // post /api/v1/context/delete
        withRawResponse().delete(params, requestOptions).parse()

    override fun add(params: ContextAddParams, requestOptions: RequestOptions): ContextAddResponse =
        // post /api/v1/context/add
        withRawResponse().add(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContextService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val traces: TraceService.WithRawResponse by lazy {
            TraceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val view: ViewService.WithRawResponse by lazy {
            ViewServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val memory: MemoryService.WithRawResponse by lazy {
            MemoryServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContextService.WithRawResponse =
            ContextServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun traces(): TraceService.WithRawResponse = traces

        override fun view(): ViewService.WithRawResponse = view

        override fun memory(): MemoryService.WithRawResponse = memory

        private val deleteHandler: Handler<ContextDeleteResponse> =
            jsonHandler<ContextDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: ContextDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContextDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "delete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val addHandler: Handler<ContextAddResponse> =
            jsonHandler<ContextAddResponse>(clientOptions.jsonMapper)

        override fun add(
            params: ContextAddParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContextAddResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "add")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
}
