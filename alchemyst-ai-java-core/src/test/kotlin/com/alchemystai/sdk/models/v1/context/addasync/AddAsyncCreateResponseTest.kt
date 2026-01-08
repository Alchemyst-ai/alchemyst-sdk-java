// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AddAsyncCreateResponseTest {

    @Test
    fun create() {
        val addAsyncCreateResponse =
            AddAsyncCreateResponse.builder().jobId("context-add-123456").queued(true).build()

        assertThat(addAsyncCreateResponse.jobId()).isEqualTo("context-add-123456")
        assertThat(addAsyncCreateResponse.queued()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val addAsyncCreateResponse =
            AddAsyncCreateResponse.builder().jobId("context-add-123456").queued(true).build()

        val roundtrippedAddAsyncCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(addAsyncCreateResponse),
                jacksonTypeRef<AddAsyncCreateResponse>(),
            )

        assertThat(roundtrippedAddAsyncCreateResponse).isEqualTo(addAsyncCreateResponse)
    }
}
