// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.view

import com.alchemystai.sdk.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ViewDocsParamsTest {

    @Test
    fun create() {
        ViewDocsParams.builder().magicKey("magic_key").build()
    }

    @Test
    fun queryParams() {
        val params = ViewDocsParams.builder().magicKey("magic_key").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("magic_key", "magic_key").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ViewDocsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
