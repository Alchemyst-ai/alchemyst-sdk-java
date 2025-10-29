// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.org

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.models.v1.org.context.ContextViewParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContextServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun view() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextService = client.v1().org().context()

        val response = contextService.view(ContextViewParams.builder().addUserId("string").build())

        response.validate()
    }
}
