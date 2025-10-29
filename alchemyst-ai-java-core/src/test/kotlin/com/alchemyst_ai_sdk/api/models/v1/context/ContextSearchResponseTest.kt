// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context

import com.alchemyst_ai_sdk.api.core.JsonValue
import com.alchemyst_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextSearchResponseTest {

    @Test
    fun create() {
        val contextSearchResponse =
            ContextSearchResponse.builder()
                .addContext(
                    ContextSearchResponse.Context.builder()
                        .content("content")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .score(0.001)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        assertThat(contextSearchResponse.contexts().getOrNull())
            .containsExactly(
                ContextSearchResponse.Context.builder()
                    .content("content")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .score(0.001)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contextSearchResponse =
            ContextSearchResponse.builder()
                .addContext(
                    ContextSearchResponse.Context.builder()
                        .content("content")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .score(0.001)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val roundtrippedContextSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextSearchResponse),
                jacksonTypeRef<ContextSearchResponse>(),
            )

        assertThat(roundtrippedContextSearchResponse).isEqualTo(contextSearchResponse)
    }
}
