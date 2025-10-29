// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1.org

import com.alchemyst_ai_sdk.api.core.ClientOptions
import com.alchemyst_ai_sdk.api.core.RequestOptions
import com.alchemyst_ai_sdk.api.core.handlers.errorBodyHandler
import com.alchemyst_ai_sdk.api.core.handlers.errorHandler
import com.alchemyst_ai_sdk.api.core.handlers.jsonHandler
import com.alchemyst_ai_sdk.api.core.http.HttpMethod
import com.alchemyst_ai_sdk.api.core.http.HttpRequest
import com.alchemyst_ai_sdk.api.core.http.HttpResponse
import com.alchemyst_ai_sdk.api.core.http.HttpResponse.Handler
import com.alchemyst_ai_sdk.api.core.http.HttpResponseFor
import com.alchemyst_ai_sdk.api.core.http.json
import com.alchemyst_ai_sdk.api.core.http.parseable
import com.alchemyst_ai_sdk.api.core.prepareAsync
import com.alchemyst_ai_sdk.api.models.v1.org.context.ContextViewParams
import com.alchemyst_ai_sdk.api.models.v1.org.context.ContextViewResponse
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
