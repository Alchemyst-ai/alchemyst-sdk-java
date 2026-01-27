// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.view

import com.alchemystai.sdk.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ViewRetrieveResponseTest {

    @Test
    fun create() {
        val viewRetrieveResponse =
            ViewRetrieveResponse.builder()
                .addContext(
                    ViewRetrieveResponse.Context.builder()
                        .content("Customer asked about pricing for the Scale plan.")
                        .metadata(
                            ViewRetrieveResponse.Context.Metadata.builder()
                                .fileName("support_thread_TCK-1234.txt")
                                .fileSize(2048.0)
                                .fileType("text/plain")
                                .addGroupName("support")
                                .addGroupName("pricing")
                                .lastModified("2025-01-10T12:34:56.000Z")
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        assertThat(viewRetrieveResponse.contexts())
            .containsExactly(
                ViewRetrieveResponse.Context.builder()
                    .content("Customer asked about pricing for the Scale plan.")
                    .metadata(
                        ViewRetrieveResponse.Context.Metadata.builder()
                            .fileName("support_thread_TCK-1234.txt")
                            .fileSize(2048.0)
                            .fileType("text/plain")
                            .addGroupName("support")
                            .addGroupName("pricing")
                            .lastModified("2025-01-10T12:34:56.000Z")
                            .build()
                    )
                    .build()
            )
        assertThat(viewRetrieveResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val viewRetrieveResponse =
            ViewRetrieveResponse.builder()
                .addContext(
                    ViewRetrieveResponse.Context.builder()
                        .content("Customer asked about pricing for the Scale plan.")
                        .metadata(
                            ViewRetrieveResponse.Context.Metadata.builder()
                                .fileName("support_thread_TCK-1234.txt")
                                .fileSize(2048.0)
                                .fileType("text/plain")
                                .addGroupName("support")
                                .addGroupName("pricing")
                                .lastModified("2025-01-10T12:34:56.000Z")
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedViewRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(viewRetrieveResponse),
                jacksonTypeRef<ViewRetrieveResponse>(),
            )

        assertThat(roundtrippedViewRetrieveResponse).isEqualTo(viewRetrieveResponse)
    }
}
