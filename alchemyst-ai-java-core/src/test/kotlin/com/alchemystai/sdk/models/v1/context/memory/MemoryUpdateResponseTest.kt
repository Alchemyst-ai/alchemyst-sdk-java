// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryUpdateResponseTest {

    @Test
    fun create() {
        val memoryUpdateResponse =
            MemoryUpdateResponse.builder()
                .memoryId("support-thread-TCK-1234")
                .success(true)
                .updatedEntries(2.0)
                .build()

        assertThat(memoryUpdateResponse.memoryId()).isEqualTo("support-thread-TCK-1234")
        assertThat(memoryUpdateResponse.success()).isEqualTo(true)
        assertThat(memoryUpdateResponse.updatedEntries()).isEqualTo(2.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val memoryUpdateResponse =
            MemoryUpdateResponse.builder()
                .memoryId("support-thread-TCK-1234")
                .success(true)
                .updatedEntries(2.0)
                .build()

        val roundtrippedMemoryUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(memoryUpdateResponse),
                jacksonTypeRef<MemoryUpdateResponse>(),
            )

        assertThat(roundtrippedMemoryUpdateResponse).isEqualTo(memoryUpdateResponse)
    }
}
