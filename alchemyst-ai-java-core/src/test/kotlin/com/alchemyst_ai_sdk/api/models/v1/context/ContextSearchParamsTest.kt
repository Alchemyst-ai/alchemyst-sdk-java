// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context

import com.alchemyst_ai_sdk.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextSearchParamsTest {

    @Test
    fun create() {
        ContextSearchParams.builder()
            .minimumSimilarityThreshold(0.5)
            .query("search query for user preferences")
            .similarityThreshold(0.8)
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .scope(ContextSearchParams.Scope.INTERNAL)
            .userId("user123")
            .build()
    }

    @Test
    fun body() {
        val params =
            ContextSearchParams.builder()
                .minimumSimilarityThreshold(0.5)
                .query("search query for user preferences")
                .similarityThreshold(0.8)
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .scope(ContextSearchParams.Scope.INTERNAL)
                .userId("user123")
                .build()

        val body = params._body()

        assertThat(body.minimumSimilarityThreshold()).isEqualTo(0.5)
        assertThat(body.query()).isEqualTo("search query for user preferences")
        assertThat(body.similarityThreshold()).isEqualTo(0.8)
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.scope()).contains(ContextSearchParams.Scope.INTERNAL)
        assertThat(body.userId()).contains("user123")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContextSearchParams.builder()
                .minimumSimilarityThreshold(0.5)
                .query("search query for user preferences")
                .similarityThreshold(0.8)
                .build()

        val body = params._body()

        assertThat(body.minimumSimilarityThreshold()).isEqualTo(0.5)
        assertThat(body.query()).isEqualTo("search query for user preferences")
        assertThat(body.similarityThreshold()).isEqualTo(0.8)
    }
}
