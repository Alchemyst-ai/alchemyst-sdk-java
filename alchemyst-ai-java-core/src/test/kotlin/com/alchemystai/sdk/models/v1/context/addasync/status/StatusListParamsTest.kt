// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync.status

import com.alchemystai.sdk.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatusListParamsTest {

    @Test
    fun create() {
        StatusListParams.builder()
            .limit("limit")
            .offset("offset")
            .type(StatusListParams.Type.ALL)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            StatusListParams.builder()
                .limit("limit")
                .offset("offset")
                .type(StatusListParams.Type.ALL)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "limit")
                    .put("offset", "offset")
                    .put("type", "all")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = StatusListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
