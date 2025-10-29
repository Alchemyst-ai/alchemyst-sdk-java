// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services.blocking.v1.context

import com.alchemyst_ai.sdk.TestServerExtension
import com.alchemyst_ai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemyst_ai.sdk.models.v1.context.memory.MemoryAddParams
import com.alchemyst_ai.sdk.models.v1.context.memory.MemoryDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MemoryServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryService = client.v1().context().memory()

        memoryService.delete(
            MemoryDeleteParams.builder()
                .memoryId("memoryId")
                .organizationId("organization_id")
                .userId("user_id")
                .build()
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun add() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryService = client.v1().context().memory()

        memoryService.add(
            MemoryAddParams.builder()
                .addContent(MemoryAddParams.Content.builder().content("content").build())
                .memoryId("memoryId")
                .build()
        )
    }
}
