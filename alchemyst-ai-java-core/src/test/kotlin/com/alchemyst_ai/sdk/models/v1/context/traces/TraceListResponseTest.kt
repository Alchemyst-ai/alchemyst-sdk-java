// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.models.v1.context.traces

import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceListResponseTest {

    @Test
    fun create() {
        val traceListResponse =
            TraceListResponse.builder()
                .addTrace(
                    TraceListResponse.Trace.builder()
                        ._id("_id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .type("type")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .userId("userId")
                        .build()
                )
                .build()

        assertThat(traceListResponse.traces().getOrNull())
            .containsExactly(
                TraceListResponse.Trace.builder()
                    ._id("_id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(JsonValue.from(mapOf<String, Any>()))
                    .type("type")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .userId("userId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val traceListResponse =
            TraceListResponse.builder()
                .addTrace(
                    TraceListResponse.Trace.builder()
                        ._id("_id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .type("type")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .userId("userId")
                        .build()
                )
                .build()

        val roundtrippedTraceListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(traceListResponse),
                jacksonTypeRef<TraceListResponse>(),
            )

        assertThat(roundtrippedTraceListResponse).isEqualTo(traceListResponse)
    }
}
