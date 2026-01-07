// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryAddResponseTest {

    @Test
    fun create() {
        val memoryAddResponse =
            MemoryAddResponse.builder()
                .contextId("ctx_01HXYZABC")
                .success(true)
                .processedDocuments(2.0)
                .build()

        assertThat(memoryAddResponse.contextId()).isEqualTo("ctx_01HXYZABC")
        assertThat(memoryAddResponse.success()).isEqualTo(true)
        assertThat(memoryAddResponse.processedDocuments()).contains(2.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val memoryAddResponse =
            MemoryAddResponse.builder()
                .contextId("ctx_01HXYZABC")
                .success(true)
                .processedDocuments(2.0)
                .build()

        val roundtrippedMemoryAddResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(memoryAddResponse),
                jacksonTypeRef<MemoryAddResponse>(),
            )

        assertThat(roundtrippedMemoryAddResponse).isEqualTo(memoryAddResponse)
    }
}
