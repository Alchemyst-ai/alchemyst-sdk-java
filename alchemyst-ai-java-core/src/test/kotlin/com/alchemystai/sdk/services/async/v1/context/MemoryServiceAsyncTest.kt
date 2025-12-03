// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemystai.sdk.models.v1.context.memory.MemoryAddParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryDeleteParams
import com.alchemystai.sdk.models.v1.context.memory.MemoryUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MemoryServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryServiceAsync = client.v1().context().memory()

        val future =
            memoryServiceAsync.update(
                MemoryUpdateParams.builder()
                    .addContent(
                        MemoryUpdateParams.Content.builder()
                            .content("Customer asked about pricing for the Scale plan.")
                            .build()
                    )
                    .addContent(
                        MemoryUpdateParams.Content.builder()
                            .content("Updated answer about the Scale plan pricing after discounts.")
                            .build()
                    )
                    .memoryId("support-thread-TCK-1234")
                    .build()
            )

        val response = future.get()
    }

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
                    .memoryId("support-thread-TCK-1234")
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
                    .addContent(
                        MemoryAddParams.Content.builder()
                            .content("Customer asked about pricing for the Scale plan.")
                            .build()
                    )
                    .addContent(
                        MemoryAddParams.Content.builder()
                            .content(
                                "Explained the Scale plan pricing and shared the pricing page link."
                            )
                            .build()
                    )
                    .memoryId("support-thread-TCK-1234")
                    .build()
            )

        val response = future.get()
    }
}
