// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryDeleteParamsTest {

    @Test
    fun create() {
        MemoryDeleteParams.builder()
            .memoryId("support-thread-TCK-1234")
            .organizationId("org_01HXYZABC")
            .byDoc(true)
            .byId(false)
            .userId("user_id")
            .build()
    }

    @Test
    fun body() {
        val params =
            MemoryDeleteParams.builder()
                .memoryId("support-thread-TCK-1234")
                .organizationId("org_01HXYZABC")
                .byDoc(true)
                .byId(false)
                .userId("user_id")
                .build()

        val body = params._body()

        assertThat(body.memoryId()).isEqualTo("support-thread-TCK-1234")
        assertThat(body.organizationId()).contains("org_01HXYZABC")
        assertThat(body.byDoc()).contains(true)
        assertThat(body.byId()).contains(false)
        assertThat(body.userId()).contains("user_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MemoryDeleteParams.builder()
                .memoryId("support-thread-TCK-1234")
                .organizationId("org_01HXYZABC")
                .build()

        val body = params._body()

        assertThat(body.memoryId()).isEqualTo("support-thread-TCK-1234")
        assertThat(body.organizationId()).contains("org_01HXYZABC")
    }
}
