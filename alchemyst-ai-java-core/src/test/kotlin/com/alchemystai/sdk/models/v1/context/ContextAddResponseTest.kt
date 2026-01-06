// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextAddResponseTest {

    @Test
    fun create() {
        val contextAddResponse =
            ContextAddResponse.builder()
                .contextId("01HXYZABC")
                .success(true)
                .processedDocuments(1.0)
                .build()

        assertThat(contextAddResponse.contextId()).isEqualTo("01HXYZABC")
        assertThat(contextAddResponse.success()).isEqualTo(true)
        assertThat(contextAddResponse.processedDocuments()).contains(1.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contextAddResponse =
            ContextAddResponse.builder()
                .contextId("01HXYZABC")
                .success(true)
                .processedDocuments(1.0)
                .build()

        val roundtrippedContextAddResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextAddResponse),
                jacksonTypeRef<ContextAddResponse>(),
            )

        assertThat(roundtrippedContextAddResponse).isEqualTo(contextAddResponse)
    }
}
