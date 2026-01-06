// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryAddParamsTest {

    @Test
    fun create() {
        MemoryAddParams.builder()
            .addContent(
                MemoryAddParams.Content.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .metadata(MemoryAddParams.Content.Metadata.builder().messageId("msg-1").build())
                    .build()
            )
            .addContent(
                MemoryAddParams.Content.builder()
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
                    .metadata(MemoryAddParams.Content.Metadata.builder().messageId("msg-2").build())
                    .build()
            )
            .memoryId("support-thread-TCK-1234")
            .metadata(
                MemoryAddParams.Metadata.builder()
                    .addGroupName("support")
                    .addGroupName("pricing")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MemoryAddParams.builder()
                .addContent(
                    MemoryAddParams.Content.builder()
                        .content("Customer asked about pricing for the Scale plan.")
                        .metadata(
                            MemoryAddParams.Content.Metadata.builder().messageId("msg-1").build()
                        )
                        .build()
                )
                .addContent(
                    MemoryAddParams.Content.builder()
                        .content(
                            "Explained the Scale plan pricing and shared the pricing page link."
                        )
                        .metadata(
                            MemoryAddParams.Content.Metadata.builder().messageId("msg-2").build()
                        )
                        .build()
                )
                .memoryId("support-thread-TCK-1234")
                .metadata(
                    MemoryAddParams.Metadata.builder()
                        .addGroupName("support")
                        .addGroupName("pricing")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.contents())
            .containsExactly(
                MemoryAddParams.Content.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .metadata(MemoryAddParams.Content.Metadata.builder().messageId("msg-1").build())
                    .build(),
                MemoryAddParams.Content.builder()
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
                    .metadata(MemoryAddParams.Content.Metadata.builder().messageId("msg-2").build())
                    .build(),
            )
        assertThat(body.memoryId()).isEqualTo("support-thread-TCK-1234")
        assertThat(body.metadata())
            .contains(
                MemoryAddParams.Metadata.builder()
                    .addGroupName("support")
                    .addGroupName("pricing")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MemoryAddParams.builder()
                .addContent(
                    MemoryAddParams.Content.builder()
                        .content("Customer asked about pricing for the Scale plan.")
                        .metadata(
                            MemoryAddParams.Content.Metadata.builder().messageId("msg-1").build()
                        )
                        .build()
                )
                .addContent(
                    MemoryAddParams.Content.builder()
                        .content(
                            "Explained the Scale plan pricing and shared the pricing page link."
                        )
                        .metadata(
                            MemoryAddParams.Content.Metadata.builder().messageId("msg-2").build()
                        )
                        .build()
                )
                .memoryId("support-thread-TCK-1234")
                .build()

        val body = params._body()

        assertThat(body.contents())
            .containsExactly(
                MemoryAddParams.Content.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .metadata(MemoryAddParams.Content.Metadata.builder().messageId("msg-1").build())
                    .build(),
                MemoryAddParams.Content.builder()
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
                    .metadata(MemoryAddParams.Content.Metadata.builder().messageId("msg-2").build())
                    .build(),
            )
        assertThat(body.memoryId()).isEqualTo("support-thread-TCK-1234")
    }
}
