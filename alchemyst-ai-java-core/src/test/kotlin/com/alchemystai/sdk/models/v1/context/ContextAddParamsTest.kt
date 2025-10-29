// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextAddParamsTest {

    @Test
    fun create() {
        ContextAddParams.builder()
            .contextType(ContextAddParams.ContextType.RESOURCE)
            .addDocument(ContextAddParams.Document.builder().content("content").build())
            .metadata(
                ContextAddParams.Metadata.builder()
                    .fileName("fileName")
                    .fileSize(0.0)
                    .fileType("fileType")
                    .addGroupName("string")
                    .lastModified("lastModified")
                    .build()
            )
            .scope(ContextAddParams.Scope.INTERNAL)
            .source("source")
            .build()
    }

    @Test
    fun body() {
        val params =
            ContextAddParams.builder()
                .contextType(ContextAddParams.ContextType.RESOURCE)
                .addDocument(ContextAddParams.Document.builder().content("content").build())
                .metadata(
                    ContextAddParams.Metadata.builder()
                        .fileName("fileName")
                        .fileSize(0.0)
                        .fileType("fileType")
                        .addGroupName("string")
                        .lastModified("lastModified")
                        .build()
                )
                .scope(ContextAddParams.Scope.INTERNAL)
                .source("source")
                .build()

        val body = params._body()

        assertThat(body.contextType()).contains(ContextAddParams.ContextType.RESOURCE)
        assertThat(body.documents().getOrNull())
            .containsExactly(ContextAddParams.Document.builder().content("content").build())
        assertThat(body.metadata())
            .contains(
                ContextAddParams.Metadata.builder()
                    .fileName("fileName")
                    .fileSize(0.0)
                    .fileType("fileType")
                    .addGroupName("string")
                    .lastModified("lastModified")
                    .build()
            )
        assertThat(body.scope()).contains(ContextAddParams.Scope.INTERNAL)
        assertThat(body.source()).contains("source")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContextAddParams.builder().build()

        val body = params._body()
    }
}
