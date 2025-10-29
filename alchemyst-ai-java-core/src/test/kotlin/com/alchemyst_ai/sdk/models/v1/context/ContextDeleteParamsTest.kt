// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.models.v1.context

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextDeleteParamsTest {

    @Test
    fun create() {
        ContextDeleteParams.builder()
            .byDoc(true)
            .byId(true)
            .organizationId("organization_id")
            .source("source")
            .userId("user_id")
            .build()
    }

    @Test
    fun body() {
        val params =
            ContextDeleteParams.builder()
                .byDoc(true)
                .byId(true)
                .organizationId("organization_id")
                .source("source")
                .userId("user_id")
                .build()

        val body = params._body()

        assertThat(body.byDoc()).contains(true)
        assertThat(body.byId()).contains(true)
        assertThat(body.organizationId()).contains("organization_id")
        assertThat(body.source()).contains("source")
        assertThat(body.userId()).contains("user_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContextDeleteParams.builder().build()

        val body = params._body()
    }
}
