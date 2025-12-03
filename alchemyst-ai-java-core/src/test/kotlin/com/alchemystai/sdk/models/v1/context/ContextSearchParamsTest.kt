// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context

import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextSearchParamsTest {

    @Test
    fun create() {
        ContextSearchParams.builder()
            .queryMetadata(ContextSearchParams.Metadata.TRUE)
            .mode(ContextSearchParams.Mode.FAST)
            .minimumSimilarityThreshold(0.5)
            .query("What did the customer ask about pricing for the Scale plan?")
            .similarityThreshold(0.8)
            .bodyMetadata(JsonValue.from(mapOf<String, Any>()))
            .scope(ContextSearchParams.Scope.INTERNAL)
            .userId("user123")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ContextSearchParams.builder()
                .queryMetadata(ContextSearchParams.Metadata.TRUE)
                .mode(ContextSearchParams.Mode.FAST)
                .minimumSimilarityThreshold(0.5)
                .query("What did the customer ask about pricing for the Scale plan?")
                .similarityThreshold(0.8)
                .bodyMetadata(JsonValue.from(mapOf<String, Any>()))
                .scope(ContextSearchParams.Scope.INTERNAL)
                .userId("user123")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("metadata", "true").put("mode", "fast").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ContextSearchParams.builder()
                .minimumSimilarityThreshold(0.5)
                .query("What did the customer ask about pricing for the Scale plan?")
                .similarityThreshold(0.8)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            ContextSearchParams.builder()
                .queryMetadata(ContextSearchParams.Metadata.TRUE)
                .mode(ContextSearchParams.Mode.FAST)
                .minimumSimilarityThreshold(0.5)
                .query("What did the customer ask about pricing for the Scale plan?")
                .similarityThreshold(0.8)
                .bodyMetadata(JsonValue.from(mapOf<String, Any>()))
                .scope(ContextSearchParams.Scope.INTERNAL)
                .userId("user123")
                .build()

        val body = params._body()

        assertThat(body.minimumSimilarityThreshold()).isEqualTo(0.5)
        assertThat(body.query())
            .isEqualTo("What did the customer ask about pricing for the Scale plan?")
        assertThat(body.similarityThreshold()).isEqualTo(0.8)
        assertThat(body._bodyMetadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.scope()).contains(ContextSearchParams.Scope.INTERNAL)
        assertThat(body.userId()).contains("user123")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContextSearchParams.builder()
                .minimumSimilarityThreshold(0.5)
                .query("What did the customer ask about pricing for the Scale plan?")
                .similarityThreshold(0.8)
                .build()

        val body = params._body()

        assertThat(body.minimumSimilarityThreshold()).isEqualTo(0.5)
        assertThat(body.query())
            .isEqualTo("What did the customer ask about pricing for the Scale plan?")
        assertThat(body.similarityThreshold()).isEqualTo(0.8)
    }
}
