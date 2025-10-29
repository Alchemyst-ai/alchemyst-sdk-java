// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryUpdateParamsTest {

    @Test
    fun create() {
        MemoryUpdateParams.builder()
            .addContent(MemoryUpdateParams.Content.builder().content("content").build())
            .memoryId("memoryId")
            .build()
    }

    @Test
    fun body() {
        val params =
            MemoryUpdateParams.builder()
                .addContent(MemoryUpdateParams.Content.builder().content("content").build())
                .memoryId("memoryId")
                .build()

        val body = params._body()

        assertThat(body.contents().getOrNull())
            .containsExactly(MemoryUpdateParams.Content.builder().content("content").build())
        assertThat(body.memoryId()).contains("memoryId")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MemoryUpdateParams.builder().build()

        val body = params._body()
    }
}
