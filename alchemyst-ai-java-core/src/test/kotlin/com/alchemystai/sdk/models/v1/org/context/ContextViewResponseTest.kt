// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.org.context

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextViewResponseTest {

    @Test
    fun create() {
        val contextViewResponse =
            ContextViewResponse.builder().contexts(JsonValue.from(mapOf<String, Any>())).build()

        assertThat(contextViewResponse._contexts()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contextViewResponse =
            ContextViewResponse.builder().contexts(JsonValue.from(mapOf<String, Any>())).build()

        val roundtrippedContextViewResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextViewResponse),
                jacksonTypeRef<ContextViewResponse>(),
            )

        assertThat(roundtrippedContextViewResponse).isEqualTo(contextViewResponse)
    }
}
