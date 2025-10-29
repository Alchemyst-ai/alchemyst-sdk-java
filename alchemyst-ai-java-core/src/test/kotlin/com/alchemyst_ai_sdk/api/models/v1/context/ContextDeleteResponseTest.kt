// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context

import com.alchemyst_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextDeleteResponseTest {

    @Test
    fun create() {
        val contextDeleteResponse = ContextDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contextDeleteResponse = ContextDeleteResponse.builder().build()

        val roundtrippedContextDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextDeleteResponse),
                jacksonTypeRef<ContextDeleteResponse>(),
            )

        assertThat(roundtrippedContextDeleteResponse).isEqualTo(contextDeleteResponse)
    }
}
