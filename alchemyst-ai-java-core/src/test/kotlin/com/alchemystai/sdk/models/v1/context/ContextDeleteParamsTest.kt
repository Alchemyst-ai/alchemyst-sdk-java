// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextDeleteParamsTest {

    @Test
    fun create() {
        ContextDeleteParams.builder()
            .organizationId("org_01HXYZABC")
            .source("support-inbox")
            .byDoc(true)
            .byId(false)
            .userId("user_id")
            .build()
    }

    @Test
    fun body() {
        val params =
            ContextDeleteParams.builder()
                .organizationId("org_01HXYZABC")
                .source("support-inbox")
                .byDoc(true)
                .byId(false)
                .userId("user_id")
                .build()

        val body = params._body()

        assertThat(body.organizationId()).isEqualTo("org_01HXYZABC")
        assertThat(body.source()).isEqualTo("support-inbox")
        assertThat(body.byDoc()).contains(true)
        assertThat(body.byId()).contains(false)
        assertThat(body.userId()).contains("user_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContextDeleteParams.builder()
                .organizationId("org_01HXYZABC")
                .source("support-inbox")
                .build()

        val body = params._body()

        assertThat(body.organizationId()).isEqualTo("org_01HXYZABC")
        assertThat(body.source()).isEqualTo("support-inbox")
    }
}
