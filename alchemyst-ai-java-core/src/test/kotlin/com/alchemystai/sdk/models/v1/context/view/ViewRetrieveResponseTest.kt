// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.view

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ViewRetrieveResponseTest {

    @Test
    fun create() {
        val viewRetrieveResponse =
            ViewRetrieveResponse.builder().addContext(JsonValue.from(mapOf<String, Any>())).build()

        assertThat(viewRetrieveResponse.context().getOrNull())
            .containsExactly(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val viewRetrieveResponse =
            ViewRetrieveResponse.builder().addContext(JsonValue.from(mapOf<String, Any>())).build()

        val roundtrippedViewRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(viewRetrieveResponse),
                jacksonTypeRef<ViewRetrieveResponse>(),
            )

        assertThat(roundtrippedViewRetrieveResponse).isEqualTo(viewRetrieveResponse)
    }
}
