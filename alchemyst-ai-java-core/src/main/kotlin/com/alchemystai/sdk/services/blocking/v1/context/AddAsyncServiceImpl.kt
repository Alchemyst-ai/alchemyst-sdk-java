// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

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
import com.alchemystai.sdk.core.prepare
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCancelParams
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCancelResponse
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateParams
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateResponse
import com.alchemystai.sdk.services.blocking.v1.context.addasync.StatusService
import com.alchemystai.sdk.services.blocking.v1.context.addasync.StatusServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class AddAsyncServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AddAsyncService {

    private val withRawResponse: AddAsyncService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val status: StatusService by lazy { StatusServiceImpl(clientOptions) }

    override fun withRawResponse(): AddAsyncService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AddAsyncService =
        AddAsyncServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun status(): StatusService = status

    override fun create(
        params: AddAsyncCreateParams,
        requestOptions: RequestOptions,
    ): AddAsyncCreateResponse =
        // post /api/v1/context/add-async
        withRawResponse().create(params, requestOptions).parse()

    override fun cancel(
        params: AddAsyncCancelParams,
        requestOptions: RequestOptions,
    ): AddAsyncCancelResponse =
        // delete /api/v1/context/add-async/{id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AddAsyncService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val status: StatusService.WithRawResponse by lazy {
            StatusServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AddAsyncService.WithRawResponse =
            AddAsyncServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun status(): StatusService.WithRawResponse = status

        private val createHandler: Handler<AddAsyncCreateResponse> =
            jsonHandler<AddAsyncCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: AddAsyncCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddAsyncCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "context", "add-async")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val cancelHandler: Handler<AddAsyncCancelResponse> =
            jsonHandler<AddAsyncCancelResponse>(clientOptions.jsonMapper)

        override fun cancel(
            params: AddAsyncCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddAsyncCancelResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "context",
                        "add-async",
                        params._pathParam(0),
                        "cancel",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
