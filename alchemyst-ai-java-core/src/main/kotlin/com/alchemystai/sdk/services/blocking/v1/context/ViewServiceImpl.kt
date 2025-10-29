// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

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
import com.alchemystai.sdk.core.http.parseable
import com.alchemystai.sdk.core.prepare
import com.alchemystai.sdk.models.v1.context.view.ViewDocsParams
import com.alchemystai.sdk.models.v1.context.view.ViewDocsResponse
import com.alchemystai.sdk.models.v1.context.view.ViewRetrieveParams
import com.alchemystai.sdk.models.v1.context.view.ViewRetrieveResponse
import java.util.function.Consumer

class ViewServiceImpl internal constructor(private val clientOptions: ClientOptions) : ViewService {

    private val withRawResponse: ViewService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ViewService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ViewService =
        ViewServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ViewRetrieveParams,
        requestOptions: RequestOptions,
    ): ViewRetrieveResponse =
        // get /api/v1/context/view
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun docs(params: ViewDocsParams, requestOptions: RequestOptions): ViewDocsResponse =
        // get /api/v1/context/view/docs
        withRawResponse().docs(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ViewService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ViewService.WithRawResponse =
            ViewServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ViewRetrieveResponse> =
            jsonHandler<ViewRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ViewRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ViewRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "view")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val docsHandler: Handler<ViewDocsResponse> =
            jsonHandler<ViewDocsResponse>(clientOptions.jsonMapper)

        override fun docs(
            params: ViewDocsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ViewDocsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "view", "docs")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { docsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
