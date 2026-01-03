// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemystai.sdk.models.v1.context.traces.TraceListParams
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

        val tracesFuture =
            traceServiceAsync.list(TraceListParams.builder().limit(0L).page(0L).build())

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
