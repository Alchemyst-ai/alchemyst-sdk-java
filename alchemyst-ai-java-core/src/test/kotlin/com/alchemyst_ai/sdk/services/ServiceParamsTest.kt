// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services

import com.alchemyst_ai.sdk.client.AlchemystAiClient
import com.alchemyst_ai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.models.v1.context.ContextAddParams
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
