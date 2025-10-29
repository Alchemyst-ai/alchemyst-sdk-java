// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context

import com.alchemyst_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextAddResponseTest {

    @Test
    fun create() {
        val contextAddResponse = ContextAddResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contextAddResponse = ContextAddResponse.builder().build()

        val roundtrippedContextAddResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextAddResponse),
                jacksonTypeRef<ContextAddResponse>(),
            )

        assertThat(roundtrippedContextAddResponse).isEqualTo(contextAddResponse)
    }
}
