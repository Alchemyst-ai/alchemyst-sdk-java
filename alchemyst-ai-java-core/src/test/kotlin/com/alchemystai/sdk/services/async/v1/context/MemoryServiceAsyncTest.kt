// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.async.v1.context

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemystai.sdk.core.JsonValue
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

        val memoryFuture =
            memoryServiceAsync.update(
                MemoryUpdateParams.builder()
                    .addContent(
                        MemoryUpdateParams.Content.builder()
                            .id("msg-1")
                            .content("Customer asked about pricing for the Scale plan.")
                            .createdAt("2025-01-10T12:34:56.000Z")
                            .metadata(
                                MemoryUpdateParams.Content.Metadata.builder()
                                    .putAdditionalProperty("messageId", JsonValue.from("bar"))
                                    .build()
                            )
                            .role("user")
                            .build()
                    )
                    .addContent(
                        MemoryUpdateParams.Content.builder()
                            .id("msg-2")
                            .content("Updated answer about the Scale plan pricing after discounts.")
                            .createdAt("2025-01-10T12:36:00.000Z")
                            .metadata(
                                MemoryUpdateParams.Content.Metadata.builder()
                                    .putAdditionalProperty("messageId", JsonValue.from("bar"))
                                    .build()
                            )
                            .role("assistant")
                            .build()
                    )
                    .memoryId("support-thread-TCK-1234")
                    .build()
            )

        val memory = memoryFuture.get()
        memory.validate()
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
                    .organizationId("org_01HXYZABC")
                    .byDoc(true)
                    .byId(false)
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

        val responseFuture =
            memoryServiceAsync.add(
                MemoryAddParams.builder()
                    .addContent(
                        MemoryAddParams.Content.builder()
                            .content("Customer asked about pricing for the Scale plan.")
                            .metadata(
                                MemoryAddParams.Content.Metadata.builder()
                                    .messageId("messageId")
                                    .build()
                            )
                            .build()
                    )
                    .memoryId("support-thread-TCK-1234")
                    .metadata(MemoryAddParams.Metadata.builder().addGroupName("string").build())
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
