// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1.org

import com.alchemyst_ai_sdk.api.TestServerExtension
import com.alchemyst_ai_sdk.api.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemyst_ai_sdk.api.models.v1.org.context.ContextViewParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContextServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun view() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextServiceAsync = client.v1().org().context()

        val responseFuture =
            contextServiceAsync.view(ContextViewParams.builder().addUserId("string").build())

        val response = responseFuture.get()
        response.validate()
    }
}
