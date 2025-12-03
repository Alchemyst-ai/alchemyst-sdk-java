// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryDeleteParamsTest {

    @Test
    fun create() {
        MemoryDeleteParams.builder()
            .memoryId("support-thread-TCK-1234")
            .organizationId("organization_id")
            .userId("user_id")
            .build()
    }

    @Test
    fun body() {
        val params =
            MemoryDeleteParams.builder()
                .memoryId("support-thread-TCK-1234")
                .organizationId("organization_id")
                .userId("user_id")
                .build()

        val body = params._body()

        assertThat(body.memoryId()).contains("support-thread-TCK-1234")
        assertThat(body.organizationId()).contains("organization_id")
        assertThat(body.userId()).contains("user_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MemoryDeleteParams.builder().build()

        val body = params._body()
    }
}
