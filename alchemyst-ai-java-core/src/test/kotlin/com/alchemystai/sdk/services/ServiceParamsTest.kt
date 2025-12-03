// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services

import com.alchemystai.sdk.client.AlchemystAiClient
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.models.v1.context.ContextAddParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: AlchemystAiClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun add() {
        val contextService = client.v1().context()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
