// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services.blocking.v1.context

import com.alchemystai.sdk.TestServerExtension
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.models.v1.context.addasync.AddAsyncCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AddAsyncServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val addAsyncService = client.v1().context().addAsync()

        val addAsync =
            addAsyncService.create(
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
            )

        addAsync.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun cancel() {
        val client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val addAsyncService = client.v1().context().addAsync()

        val response = addAsyncService.cancel("id")

        response.validate()
    }
}
