// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context.addasync

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StatusServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val statusServiceAsync = client.v1().context().addAsync().status()

        val statusFuture = statusServiceAsync.retrieve("id")

        val status = statusFuture.get()
        status.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val statusServiceAsync = client.v1().context().addAsync().status()

        val statusesFuture =
            statusServiceAsync.list(
                StatusListParams.builder()
                    .limit("limit")
                    .offset("offset")
                    .type(StatusListParams.Type.ALL)
                    .build()
            )

        val statuses = statusesFuture.get()
        statuses.validate()
    }
}
