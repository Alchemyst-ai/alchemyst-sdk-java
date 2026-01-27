// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AddAsyncCreateParamsTest {

    @Test
    fun create() {
        AddAsyncCreateParams.builder()
            .contextType(AddAsyncCreateParams.ContextType.RESOURCE)
            .addDocument(
                AddAsyncCreateParams.Document.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
            .scope(AddAsyncCreateParams.Scope.INTERNAL)
            .source("support-inbox")
            .metadata(
                AddAsyncCreateParams.Metadata.builder()
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
            AddAsyncCreateParams.builder()
                .contextType(AddAsyncCreateParams.ContextType.RESOURCE)
                .addDocument(
                    AddAsyncCreateParams.Document.builder()
                        .content("Customer asked about pricing for the Scale plan.")
                        .build()
                )
                .scope(AddAsyncCreateParams.Scope.INTERNAL)
                .source("support-inbox")
                .metadata(
                    AddAsyncCreateParams.Metadata.builder()
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

        assertThat(body.contextType()).isEqualTo(AddAsyncCreateParams.ContextType.RESOURCE)
        assertThat(body.documents())
            .containsExactly(
                AddAsyncCreateParams.Document.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .build()
            )
        assertThat(body.scope()).isEqualTo(AddAsyncCreateParams.Scope.INTERNAL)
        assertThat(body.source()).isEqualTo("support-inbox")
        assertThat(body.metadata())
            .contains(
                AddAsyncCreateParams.Metadata.builder()
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
            AddAsyncCreateParams.builder()
                .contextType(AddAsyncCreateParams.ContextType.RESOURCE)
                .addDocument(AddAsyncCreateParams.Document.builder().build())
                .scope(AddAsyncCreateParams.Scope.INTERNAL)
                .source("support-inbox")
                .build()

        val body = params._body()

        assertThat(body.contextType()).isEqualTo(AddAsyncCreateParams.ContextType.RESOURCE)
        assertThat(body.documents())
            .containsExactly(AddAsyncCreateParams.Document.builder().build())
        assertThat(body.scope()).isEqualTo(AddAsyncCreateParams.Scope.INTERNAL)
        assertThat(body.source()).isEqualTo("support-inbox")
    }
}
