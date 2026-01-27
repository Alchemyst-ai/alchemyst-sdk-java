// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync.status

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatusRetrieveResponseTest {

    @Test
    fun create() {
        val statusRetrieveResponse =
            StatusRetrieveResponse.builder()
                .jobId("job_01HXYZABC")
                .status("completed")
                .success(true)
                .attemptsMade(1.0)
                .failedReason("")
                .finishedOn(1712345678901.0)
                .processedOn(1712345670000.0)
                .result(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(statusRetrieveResponse.jobId()).isEqualTo("job_01HXYZABC")
        assertThat(statusRetrieveResponse.status()).isEqualTo("completed")
        assertThat(statusRetrieveResponse.success()).isEqualTo(true)
        assertThat(statusRetrieveResponse.attemptsMade()).contains(1.0)
        assertThat(statusRetrieveResponse.failedReason()).contains("")
        assertThat(statusRetrieveResponse.finishedOn()).contains(1712345678901.0)
        assertThat(statusRetrieveResponse.processedOn()).contains(1712345670000.0)
        assertThat(statusRetrieveResponse._result()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val statusRetrieveResponse =
            StatusRetrieveResponse.builder()
                .jobId("job_01HXYZABC")
                .status("completed")
                .success(true)
                .attemptsMade(1.0)
                .failedReason("")
                .finishedOn(1712345678901.0)
                .processedOn(1712345670000.0)
                .result(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedStatusRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(statusRetrieveResponse),
                jacksonTypeRef<StatusRetrieveResponse>(),
            )

        assertThat(roundtrippedStatusRetrieveResponse).isEqualTo(statusRetrieveResponse)
    }
}
