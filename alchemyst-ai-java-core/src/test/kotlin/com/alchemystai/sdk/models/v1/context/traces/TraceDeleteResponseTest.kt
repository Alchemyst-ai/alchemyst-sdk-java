// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceDeleteResponseTest {

    @Test
    fun create() {
        val traceDeleteResponse =
            TraceDeleteResponse.builder().trace(JsonValue.from(mapOf<String, Any>())).build()

        assertThat(traceDeleteResponse._trace()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val traceDeleteResponse =
            TraceDeleteResponse.builder().trace(JsonValue.from(mapOf<String, Any>())).build()

        val roundtrippedTraceDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(traceDeleteResponse),
                jacksonTypeRef<TraceDeleteResponse>(),
            )

        assertThat(roundtrippedTraceDeleteResponse).isEqualTo(traceDeleteResponse)
    }
}
