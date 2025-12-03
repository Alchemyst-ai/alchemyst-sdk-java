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
            .addDocument(
                ContextAddParams.Document.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
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
            .scope(ContextAddParams.Scope.INTERNAL)
            .source("support-inbox")
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
                .scope(ContextAddParams.Scope.INTERNAL)
                .source("support-inbox")
                .build()

        val body = params._body()

        assertThat(body.contextType()).contains(ContextAddParams.ContextType.RESOURCE)
        assertThat(body.documents().getOrNull())
            .containsExactly(
                ContextAddParams.Document.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
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
        assertThat(body.scope()).contains(ContextAddParams.Scope.INTERNAL)
        assertThat(body.source()).contains("support-inbox")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContextAddParams.builder().build()

        val body = params._body()
    }
}
