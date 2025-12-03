// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.models.v1.context.ContextAddParams
import com.alchemystai.sdk.models.v1.context.ContextDeleteParams
import com.alchemystai.sdk.models.v1.context.ContextSearchParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContextServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextService = client.v1().context()

        val context =
            contextService.delete(
                ContextDeleteParams.builder()
                    .byDoc(true)
                    .byId(false)
                    .organizationId("organization_id")
                    .source("support-inbox")
                    .userId("user_id")
                    .build()
            )

        context.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun add() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextService = client.v1().context()

        val response =
            contextService.add(
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
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun search() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextService = client.v1().context()

        val response =
            contextService.search(
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
            )

        response.validate()
    }
}
