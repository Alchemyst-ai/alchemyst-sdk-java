// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AddAsyncCancelResponseTest {

    @Test
    fun create() {
        val addAsyncCancelResponse =
            AddAsyncCancelResponse.builder()
                .jobId("job_01HXYZABC")
                .message("Job cancelled successfully")
                .status("cancelled")
                .success(true)
                .build()

        assertThat(addAsyncCancelResponse.jobId()).isEqualTo("job_01HXYZABC")
        assertThat(addAsyncCancelResponse.message()).isEqualTo("Job cancelled successfully")
        assertThat(addAsyncCancelResponse.status()).isEqualTo("cancelled")
        assertThat(addAsyncCancelResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val addAsyncCancelResponse =
            AddAsyncCancelResponse.builder()
                .jobId("job_01HXYZABC")
                .message("Job cancelled successfully")
                .status("cancelled")
                .success(true)
                .build()

        val roundtrippedAddAsyncCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(addAsyncCancelResponse),
                jacksonTypeRef<AddAsyncCancelResponse>(),
            )

        assertThat(roundtrippedAddAsyncCancelResponse).isEqualTo(addAsyncCancelResponse)
    }
}
