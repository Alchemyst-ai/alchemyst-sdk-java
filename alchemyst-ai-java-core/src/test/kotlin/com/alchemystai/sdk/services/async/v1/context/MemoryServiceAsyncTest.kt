// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemystai.sdk.models.v1.context.memory.MemoryAddParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MemoryServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryServiceAsync = client.v1().context().memory()

        val future =
            memoryServiceAsync.delete(
                MemoryDeleteParams.builder()
                    .memoryId("memoryId")
                    .organizationId("organization_id")
                    .userId("user_id")
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun add() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryServiceAsync = client.v1().context().memory()

        val future =
            memoryServiceAsync.add(
                MemoryAddParams.builder()
                    .addContent(MemoryAddParams.Content.builder().content("content").build())
                    .memoryId("memoryId")
                    .build()
            )

        val response = future.get()
    }
}
