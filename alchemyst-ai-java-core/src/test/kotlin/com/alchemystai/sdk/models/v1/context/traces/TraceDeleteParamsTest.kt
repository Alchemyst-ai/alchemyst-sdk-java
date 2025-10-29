// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceDeleteParamsTest {

    @Test
    fun create() {
        TraceDeleteParams.builder().traceId("traceId").build()
    }

    @Test
    fun pathParams() {
        val params = TraceDeleteParams.builder().traceId("traceId").build()

        assertThat(params._pathParam(0)).isEqualTo("traceId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
