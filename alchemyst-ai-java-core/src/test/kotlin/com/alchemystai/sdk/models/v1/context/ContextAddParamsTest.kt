// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextAddParamsTest {

    @Test
    fun create() {
        ContextAddParams.builder()
            .contextType(ContextAddParams.ContextType.RESOURCE)
            .addDocument(
                ContextAddParams.Document.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
            .scope(ContextAddParams.Scope.INTERNAL)
            .source("support-inbox")
            .metadata(
                ContextAddParams.Metadata.builder()
                    .fileName("support_thread_TCK-1234.txt")
                    .fileSize(2048.0)
                    .fileType("text/plain")
                    .addGroupName("support")
                    .addGroupName("pricing")
                    .lastModified("2025-01-10T12:34:56.000Z")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ContextAddParams.builder()
                .contextType(ContextAddParams.ContextType.RESOURCE)
                .addDocument(
                    ContextAddParams.Document.builder()
                        .content("Customer asked about pricing for the Scale plan.")
                        .build()
                )
                .scope(ContextAddParams.Scope.INTERNAL)
                .source("support-inbox")
                .metadata(
                    ContextAddParams.Metadata.builder()
                        .fileName("support_thread_TCK-1234.txt")
                        .fileSize(2048.0)
                        .fileType("text/plain")
                        .addGroupName("support")
                        .addGroupName("pricing")
                        .lastModified("2025-01-10T12:34:56.000Z")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.contextType()).isEqualTo(ContextAddParams.ContextType.RESOURCE)
        assertThat(body.documents())
            .containsExactly(
                ContextAddParams.Document.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
        assertThat(body.scope()).isEqualTo(ContextAddParams.Scope.INTERNAL)
        assertThat(body.source()).isEqualTo("support-inbox")
        assertThat(body.metadata())
            .contains(
                ContextAddParams.Metadata.builder()
                    .fileName("support_thread_TCK-1234.txt")
                    .fileSize(2048.0)
                    .fileType("text/plain")
                    .addGroupName("support")
                    .addGroupName("pricing")
                    .lastModified("2025-01-10T12:34:56.000Z")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContextAddParams.builder()
                .contextType(ContextAddParams.ContextType.RESOURCE)
                .addDocument(ContextAddParams.Document.builder().build())
                .scope(ContextAddParams.Scope.INTERNAL)
                .source("support-inbox")
                .build()

        val body = params._body()

        assertThat(body.contextType()).isEqualTo(ContextAddParams.ContextType.RESOURCE)
        assertThat(body.documents()).containsExactly(ContextAddParams.Document.builder().build())
        assertThat(body.scope()).isEqualTo(ContextAddParams.Scope.INTERNAL)
        assertThat(body.source()).isEqualTo("support-inbox")
    }
}
