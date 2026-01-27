// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import com.alchemystai.sdk.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryUpdateParamsTest {

    @Test
    fun create() {
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
            .sessionId("support-thread-TCK-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
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
                .sessionId("support-thread-TCK-1234")
                .build()

        val body = params._body()

        assertThat(body.contents())
            .containsExactly(
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
                    .build(),
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
                    .build(),
            )
        assertThat(body.sessionId()).isEqualTo("support-thread-TCK-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MemoryUpdateParams.builder()
                .addContent(MemoryUpdateParams.Content.builder().build())
                .addContent(MemoryUpdateParams.Content.builder().build())
                .sessionId("support-thread-TCK-1234")
                .build()

        val body = params._body()

        assertThat(body.contents())
            .containsExactly(
                MemoryUpdateParams.Content.builder().build(),
                MemoryUpdateParams.Content.builder().build(),
            )
        assertThat(body.sessionId()).isEqualTo("support-thread-TCK-1234")
    }
}
