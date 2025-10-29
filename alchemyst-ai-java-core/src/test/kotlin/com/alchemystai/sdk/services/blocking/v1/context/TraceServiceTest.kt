// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TraceServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val traceService = client.v1().context().traces()

        val traces = traceService.list()

        traces.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val traceService = client.v1().context().traces()

        val trace = traceService.delete("traceId")

        trace.validate()
    }
}
