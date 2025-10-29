// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.services.async.v1

import com.alchemyst_ai_sdk.api.TestServerExtension
import com.alchemyst_ai_sdk.api.client.okhttp.AlchemystAiOkHttpClientAsync
import com.alchemyst_ai_sdk.api.core.JsonValue
import com.alchemyst_ai_sdk.api.models.v1.context.ContextAddParams
import com.alchemyst_ai_sdk.api.models.v1.context.ContextDeleteParams
import com.alchemyst_ai_sdk.api.models.v1.context.ContextSearchParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContextServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextServiceAsync = client.v1().context()

        val contextFuture =
            contextServiceAsync.delete(
                ContextDeleteParams.builder()
                    .byDoc(true)
                    .byId(true)
                    .organizationId("organization_id")
                    .source("source")
                    .userId("user_id")
                    .build()
            )

        val context = contextFuture.get()
        context.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun add() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextServiceAsync = client.v1().context()

        val responseFuture =
            contextServiceAsync.add(
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
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun search() {
        val client =
            AlchemystAiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contextServiceAsync = client.v1().context()

        val responseFuture =
            contextServiceAsync.search(
                ContextSearchParams.builder()
                    .minimumSimilarityThreshold(0.5)
                    .query("search query for user preferences")
                    .similarityThreshold(0.8)
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .scope(ContextSearchParams.Scope.INTERNAL)
                    .userId("user123")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
