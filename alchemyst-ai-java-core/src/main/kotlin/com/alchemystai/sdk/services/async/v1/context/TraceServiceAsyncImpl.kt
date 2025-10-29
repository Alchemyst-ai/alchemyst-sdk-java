// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.core.ClientOptions
import com.alchemystai.sdk.core.RequestOptions
import com.alchemystai.sdk.core.checkRequired
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
import com.alchemystai.sdk.models.v1.context.traces.TraceDeleteParams
import com.alchemystai.sdk.models.v1.context.traces.TraceDeleteResponse
import com.alchemystai.sdk.models.v1.context.traces.TraceListParams
import com.alchemystai.sdk.models.v1.context.traces.TraceListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class TraceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TraceServiceAsync {

    private val withRawResponse: TraceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TraceServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TraceServiceAsync =
        TraceServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: TraceListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TraceListResponse> =
        // get /api/v1/context/traces
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: TraceDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TraceDeleteResponse> =
        // delete /api/v1/context/traces/{traceId}/delete
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TraceServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TraceServiceAsync.WithRawResponse =
            TraceServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<TraceListResponse> =
            jsonHandler<TraceListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: TraceListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TraceListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "traces")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val deleteHandler: Handler<TraceDeleteResponse> =
            jsonHandler<TraceDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: TraceDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TraceDeleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("traceId", params.traceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "context",
                        "traces",
                        params._pathParam(0),
                        "delete",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
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
    }
}
