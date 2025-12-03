// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.org

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemystai.sdk.models.v1.org.context.ContextViewParams
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
            contextServiceAsync.view(
                ContextViewParams.builder().addUserId("user_123").addUserId("user_456").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
