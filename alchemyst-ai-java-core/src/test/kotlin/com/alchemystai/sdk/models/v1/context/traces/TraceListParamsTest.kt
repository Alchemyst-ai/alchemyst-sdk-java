// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

import com.alchemystai.sdk.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceListParamsTest {

    @Test
    fun create() {
        TraceListParams.builder().limit(0L).page(0L).build()
    }

    @Test
    fun queryParams() {
        val params = TraceListParams.builder().limit(0L).page(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("limit", "0").put("page", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TraceListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
