// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.view

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ViewDocsResponseTest {

    @Test
    fun create() {
        val viewDocsResponse =
            ViewDocsResponse.builder()
                .addDocument(
                    ViewDocsResponse.Document.builder()
                        .fileName("fileName")
                        .fileSize(0.0)
                        .fileType("fileType")
                        .addGroupName("string")
                        .lastModified("lastModified")
                        .build()
                )
                .build()

        assertThat(viewDocsResponse.documents())
            .containsExactly(
                ViewDocsResponse.Document.builder()
                    .fileName("fileName")
                    .fileSize(0.0)
                    .fileType("fileType")
                    .addGroupName("string")
                    .lastModified("lastModified")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val viewDocsResponse =
            ViewDocsResponse.builder()
                .addDocument(
                    ViewDocsResponse.Document.builder()
                        .fileName("fileName")
                        .fileSize(0.0)
                        .fileType("fileType")
                        .addGroupName("string")
                        .lastModified("lastModified")
                        .build()
                )
                .build()

        val roundtrippedViewDocsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(viewDocsResponse),
                jacksonTypeRef<ViewDocsResponse>(),
            )

        assertThat(roundtrippedViewDocsResponse).isEqualTo(viewDocsResponse)
    }
}
