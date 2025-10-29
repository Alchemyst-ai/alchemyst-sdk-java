// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context.view

import com.alchemyst_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ViewDocsResponseTest {

    @Test
    fun create() {
        val viewDocsResponse = ViewDocsResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val viewDocsResponse = ViewDocsResponse.builder().build()

        val roundtrippedViewDocsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(viewDocsResponse),
                jacksonTypeRef<ViewDocsResponse>(),
            )

        assertThat(roundtrippedViewDocsResponse).isEqualTo(viewDocsResponse)
    }
}
