// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceListResponseTest {

    @Test
    fun create() {
        val traceListResponse =
            TraceListResponse.builder()
                .pagination(
                    TraceListResponse.Pagination.builder()
                        .hasNextPage(true)
                        .hasPrevPage(true)
                        .limit(0L)
                        .page(0L)
                        .total(0L)
                        .totalPages(0L)
                        .build()
                )
                .addTrace(
                    TraceListResponse.Trace.builder()
                        ._id("_id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .organizationId("organizationId")
                        .type("type")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .userId("userId")
                        .build()
                )
                .build()

        assertThat(traceListResponse.pagination())
            .isEqualTo(
                TraceListResponse.Pagination.builder()
                    .hasNextPage(true)
                    .hasPrevPage(true)
                    .limit(0L)
                    .page(0L)
                    .total(0L)
                    .totalPages(0L)
                    .build()
            )
        assertThat(traceListResponse.traces())
            .containsExactly(
                TraceListResponse.Trace.builder()
                    ._id("_id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(JsonValue.from(mapOf<String, Any>()))
                    .organizationId("organizationId")
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
                .pagination(
                    TraceListResponse.Pagination.builder()
                        .hasNextPage(true)
                        .hasPrevPage(true)
                        .limit(0L)
                        .page(0L)
                        .total(0L)
                        .totalPages(0L)
                        .build()
                )
                .addTrace(
                    TraceListResponse.Trace.builder()
                        ._id("_id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .organizationId("organizationId")
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
