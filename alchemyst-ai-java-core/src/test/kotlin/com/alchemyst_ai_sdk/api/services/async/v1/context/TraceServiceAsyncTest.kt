// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1.context

import com.alchemyst_ai_sdk.api.TestServerExtension
import com.alchemyst_ai_sdk.api.client.okhttp.AlchemystAiOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TraceServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val traceServiceAsync = client.v1().context().traces()

        val tracesFuture = traceServiceAsync.list()

        val traces = tracesFuture.get()
        traces.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val traceServiceAsync = client.v1().context().traces()

        val traceFuture = traceServiceAsync.delete("traceId")

        val trace = traceFuture.get()
        trace.validate()
    }
}
