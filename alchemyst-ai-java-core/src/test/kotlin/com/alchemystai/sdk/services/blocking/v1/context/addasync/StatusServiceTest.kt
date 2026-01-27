// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context.addasync

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.models.v1.context.addasync.status.StatusListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StatusServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val statusService = client.v1().context().addAsync().status()

        val status = statusService.retrieve("id")

        status.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val statusService = client.v1().context().addAsync().status()

        val statuses =
            statusService.list(
                StatusListParams.builder()
                    .limit("limit")
                    .offset("offset")
                    .type(StatusListParams.Type.ALL)
                    .build()
            )

        statuses.validate()
    }
}
