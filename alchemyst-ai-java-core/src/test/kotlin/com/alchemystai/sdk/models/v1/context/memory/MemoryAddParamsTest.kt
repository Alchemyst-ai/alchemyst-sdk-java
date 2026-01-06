// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import com.alchemystai.sdk.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryAddParamsTest {

    @Test
    fun create() {
        MemoryAddParams.builder()
            .addContent(
                MemoryAddParams.Content.builder()
                    .id("msg-1")
                    .content("Customer asked about pricing for the Scale plan.")
                    .createdAt("2025-01-10T12:34:56.000Z")
                    .metadata(
                        MemoryAddParams.Content.Metadata.builder()
                            .putAdditionalProperty("messageId", JsonValue.from("bar"))
                            .build()
                    )
                    .role("user")
                    .build()
            )
            .addContent(
                MemoryAddParams.Content.builder()
                    .id("msg-2")
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
                    .createdAt("2025-01-10T12:35:30.000Z")
                    .metadata(
                        MemoryAddParams.Content.Metadata.builder()
                            .putAdditionalProperty("messageId", JsonValue.from("bar"))
                            .build()
                    )
                    .role("assistant")
                    .build()
            )
            .memoryId("support-thread-TCK-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            MemoryAddParams.builder()
                .addContent(
                    MemoryAddParams.Content.builder()
                        .id("msg-1")
                        .content("Customer asked about pricing for the Scale plan.")
                        .createdAt("2025-01-10T12:34:56.000Z")
                        .metadata(
                            MemoryAddParams.Content.Metadata.builder()
                                .putAdditionalProperty("messageId", JsonValue.from("bar"))
                                .build()
                        )
                        .role("user")
                        .build()
                )
                .addContent(
                    MemoryAddParams.Content.builder()
                        .id("msg-2")
                        .content(
                            "Explained the Scale plan pricing and shared the pricing page link."
                        )
                        .createdAt("2025-01-10T12:35:30.000Z")
                        .metadata(
                            MemoryAddParams.Content.Metadata.builder()
                                .putAdditionalProperty("messageId", JsonValue.from("bar"))
                                .build()
                        )
                        .role("assistant")
                        .build()
                )
                .memoryId("support-thread-TCK-1234")
                .build()

        val body = params._body()

        assertThat(body.contents())
            .containsExactly(
                MemoryAddParams.Content.builder()
                    .id("msg-1")
                    .content("Customer asked about pricing for the Scale plan.")
                    .createdAt("2025-01-10T12:34:56.000Z")
                    .metadata(
                        MemoryAddParams.Content.Metadata.builder()
                            .putAdditionalProperty("messageId", JsonValue.from("bar"))
                            .build()
                    )
                    .role("user")
                    .build(),
                MemoryAddParams.Content.builder()
                    .id("msg-2")
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
                    .createdAt("2025-01-10T12:35:30.000Z")
                    .metadata(
                        MemoryAddParams.Content.Metadata.builder()
                            .putAdditionalProperty("messageId", JsonValue.from("bar"))
                            .build()
                    )
                    .role("assistant")
                    .build(),
            )
        assertThat(body.memoryId()).isEqualTo("support-thread-TCK-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MemoryAddParams.builder()
                .addContent(MemoryAddParams.Content.builder().build())
                .addContent(MemoryAddParams.Content.builder().build())
                .memoryId("support-thread-TCK-1234")
                .build()

        val body = params._body()

        assertThat(body.contents())
            .containsExactly(
                MemoryAddParams.Content.builder().build(),
                MemoryAddParams.Content.builder().build(),
            )
        assertThat(body.memoryId()).isEqualTo("support-thread-TCK-1234")
    }
}
