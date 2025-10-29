// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.blocking.v1.context

import com.alchemyst_ai_sdk.api.TestServerExtension
import com.alchemyst_ai_sdk.api.client.okhttp.AlchemystAiOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ViewServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val viewService = client.v1().context().view()

        val view = viewService.retrieve()

        view.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun docs() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val viewService = client.v1().context().view()

        val response = viewService.docs()

        response.validate()
    }
}
