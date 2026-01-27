// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync.status

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatusListResponseTest {

    @Test
    fun create() {
        val statusListResponse =
            StatusListResponse.builder()
                .addJob(
                    StatusListResponse.Job.builder()
                        .attemptsMade(1.0)
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .jobId("12345")
                        .status("active")
                        .failedReason("Some error")
                        .finishedOn(1712345678901.0)
                        .processedOn(1712345678900.0)
                        .build()
                )
                .success(true)
                .build()

        assertThat(statusListResponse.jobs())
            .containsExactly(
                StatusListResponse.Job.builder()
                    .attemptsMade(1.0)
                    .data(JsonValue.from(mapOf<String, Any>()))
                    .jobId("12345")
                    .status("active")
                    .failedReason("Some error")
                    .finishedOn(1712345678901.0)
                    .processedOn(1712345678900.0)
                    .build()
            )
        assertThat(statusListResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val statusListResponse =
            StatusListResponse.builder()
                .addJob(
                    StatusListResponse.Job.builder()
                        .attemptsMade(1.0)
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .jobId("12345")
                        .status("active")
                        .failedReason("Some error")
                        .finishedOn(1712345678901.0)
                        .processedOn(1712345678900.0)
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedStatusListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(statusListResponse),
                jacksonTypeRef<StatusListResponse>(),
            )

        assertThat(roundtrippedStatusListResponse).isEqualTo(statusListResponse)
    }
}
