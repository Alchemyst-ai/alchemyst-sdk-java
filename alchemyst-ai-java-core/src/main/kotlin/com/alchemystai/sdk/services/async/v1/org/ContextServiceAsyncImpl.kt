// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.org

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
import com.alchemystai.sdk.models.v1.org.context.ContextViewParams
import com.alchemystai.sdk.models.v1.org.context.ContextViewResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ContextServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ContextServiceAsync {

    private val withRawResponse: ContextServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContextServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextServiceAsync =
        ContextServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun view(
        params: ContextViewParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContextViewResponse> =
        // post /api/v1/org/context/view
        withRawResponse().view(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContextServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContextServiceAsync.WithRawResponse =
            ContextServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val viewHandler: Handler<ContextViewResponse> =
            jsonHandler<ContextViewResponse>(clientOptions.jsonMapper)

        override fun view(
            params: ContextViewParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContextViewResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "org", "context", "view")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { viewHandler.handle(it) }
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
