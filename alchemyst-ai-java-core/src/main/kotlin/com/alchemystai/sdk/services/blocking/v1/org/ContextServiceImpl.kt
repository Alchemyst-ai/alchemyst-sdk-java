// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.org

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
import com.alchemystai.sdk.models.v1.org.context.ContextViewParams
import com.alchemystai.sdk.models.v1.org.context.ContextViewResponse
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
