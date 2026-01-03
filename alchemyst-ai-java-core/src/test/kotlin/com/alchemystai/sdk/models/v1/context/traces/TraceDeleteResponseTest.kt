// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceDeleteResponseTest {

    @Test
    fun create() {
        val traceDeleteResponse =
            TraceDeleteResponse.builder()
                .trace(
                    TraceDeleteResponse.Trace.builder()
                        ._id("trace_123")
                        .createdAt(OffsetDateTime.parse("2025-01-10T12:35:10.000Z"))
                        .data(
                            TraceDeleteResponse.Trace.Data.builder()
                                .fileName("support_thread_TCK-1234.txt")
                                .query(
                                    "What did the customer ask about pricing for the Scale plan?"
                                )
                                .source("support-inbox")
                                .build()
                        )
                        .organizationId("org_123")
                        .type("context.search")
                        .updatedAt(OffsetDateTime.parse("2025-01-10T12:35:10.000Z"))
                        .userId("user_123")
                        .build()
                )
                .build()

        assertThat(traceDeleteResponse.trace())
            .isEqualTo(
                TraceDeleteResponse.Trace.builder()
                    ._id("trace_123")
                    .createdAt(OffsetDateTime.parse("2025-01-10T12:35:10.000Z"))
                    .data(
                        TraceDeleteResponse.Trace.Data.builder()
                            .fileName("support_thread_TCK-1234.txt")
                            .query("What did the customer ask about pricing for the Scale plan?")
                            .source("support-inbox")
                            .build()
                    )
                    .organizationId("org_123")
                    .type("context.search")
                    .updatedAt(OffsetDateTime.parse("2025-01-10T12:35:10.000Z"))
                    .userId("user_123")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val traceDeleteResponse =
            TraceDeleteResponse.builder()
                .trace(
                    TraceDeleteResponse.Trace.builder()
                        ._id("trace_123")
                        .createdAt(OffsetDateTime.parse("2025-01-10T12:35:10.000Z"))
                        .data(
                            TraceDeleteResponse.Trace.Data.builder()
                                .fileName("support_thread_TCK-1234.txt")
                                .query(
                                    "What did the customer ask about pricing for the Scale plan?"
                                )
                                .source("support-inbox")
                                .build()
                        )
                        .organizationId("org_123")
                        .type("context.search")
                        .updatedAt(OffsetDateTime.parse("2025-01-10T12:35:10.000Z"))
                        .userId("user_123")
                        .build()
                )
                .build()

        val roundtrippedTraceDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(traceDeleteResponse),
                jacksonTypeRef<TraceDeleteResponse>(),
            )

        assertThat(roundtrippedTraceDeleteResponse).isEqualTo(traceDeleteResponse)
    }
}
