// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services.blocking.v1.org

import com.alchemyst_ai.sdk.core.ClientOptions
import com.alchemyst_ai.sdk.core.RequestOptions
import com.alchemyst_ai.sdk.core.handlers.errorBodyHandler
import com.alchemyst_ai.sdk.core.handlers.errorHandler
import com.alchemyst_ai.sdk.core.handlers.jsonHandler
import com.alchemyst_ai.sdk.core.http.HttpMethod
import com.alchemyst_ai.sdk.core.http.HttpRequest
import com.alchemyst_ai.sdk.core.http.HttpResponse
import com.alchemyst_ai.sdk.core.http.HttpResponse.Handler
import com.alchemyst_ai.sdk.core.http.HttpResponseFor
import com.alchemyst_ai.sdk.core.http.json
import com.alchemyst_ai.sdk.core.http.parseable
import com.alchemyst_ai.sdk.core.prepare
import com.alchemyst_ai.sdk.models.v1.org.context.ContextViewParams
import com.alchemyst_ai.sdk.models.v1.org.context.ContextViewResponse
import java.util.function.Consumer

class ContextServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ContextService {

    private val withRawResponse: ContextService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContextService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContextService =
        ContextServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun view(
        params: ContextViewParams,
        requestOptions: RequestOptions,
    ): ContextViewResponse =
        // post /api/v1/org/context/view
        withRawResponse().view(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContextService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContextService.WithRawResponse =
            ContextServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val viewHandler: Handler<ContextViewResponse> =
            jsonHandler<ContextViewResponse>(clientOptions.jsonMapper)

        override fun view(
            params: ContextViewParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContextViewResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "org", "context", "view")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
