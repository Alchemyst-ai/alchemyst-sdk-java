// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryUpdateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.contents().getOrNull())
            .containsExactly(
                MemoryUpdateParams.Content.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build(),
                MemoryUpdateParams.Content.builder()
                    .content("Updated answer about the Scale plan pricing after discounts.")
                    .build(),
            )
        assertThat(body.memoryId()).contains("support-thread-TCK-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MemoryUpdateParams.builder().build()

        val body = params._body()
    }
}
