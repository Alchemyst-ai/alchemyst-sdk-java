// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryAddParamsTest {

    @Test
    fun create() {
        MemoryAddParams.builder()
            .addContent(
                MemoryAddParams.Content.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
            .addContent(
                MemoryAddParams.Content.builder()
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
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

        val body = params._body()

        assertThat(body.contents().getOrNull())
            .containsExactly(
                MemoryAddParams.Content.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build(),
                MemoryAddParams.Content.builder()
                    .content("Explained the Scale plan pricing and shared the pricing page link.")
                    .build(),
            )
        assertThat(body.memoryId()).contains("support-thread-TCK-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MemoryAddParams.builder().build()

        val body = params._body()
    }
}
