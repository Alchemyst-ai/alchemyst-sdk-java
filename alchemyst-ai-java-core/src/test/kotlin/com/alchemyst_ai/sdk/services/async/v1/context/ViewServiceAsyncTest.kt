// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services.async.v1.context

import com.alchemyst_ai.sdk.TestServerExtension
import com.alchemyst_ai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ViewServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val viewServiceAsync = client.v1().context().view()

        val viewFuture = viewServiceAsync.retrieve()

        val view = viewFuture.get()
        view.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun docs() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val viewServiceAsync = client.v1().context().view()

        val responseFuture = viewServiceAsync.docs()

        val response = responseFuture.get()
        response.validate()
    }
}
