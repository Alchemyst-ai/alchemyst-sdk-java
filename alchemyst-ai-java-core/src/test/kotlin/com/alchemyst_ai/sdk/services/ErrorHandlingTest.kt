// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.services

import com.alchemyst_ai.sdk.client.AlchemystAiClient
import com.alchemyst_ai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.core.http.Headers
import com.alchemyst_ai.sdk.core.jsonMapper
import com.alchemyst_ai.sdk.errors.AlchemystAiException
import com.alchemyst_ai.sdk.errors.BadRequestException
import com.alchemyst_ai.sdk.errors.InternalServerException
import com.alchemyst_ai.sdk.errors.NotFoundException
import com.alchemyst_ai.sdk.errors.PermissionDeniedException
import com.alchemyst_ai.sdk.errors.RateLimitException
import com.alchemyst_ai.sdk.errors.UnauthorizedException
import com.alchemyst_ai.sdk.errors.UnexpectedStatusCodeException
import com.alchemyst_ai.sdk.errors.UnprocessableEntityException
import com.alchemyst_ai.sdk.models.v1.context.ContextAddParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: AlchemystAiClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            AlchemystAiOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun contextAdd400() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd400WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd401() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd401WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd403() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd403WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd404() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd404WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd422() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd422WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd429() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd429WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd500() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd500WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd999() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAdd999WithRawResponse() {
        val contextService = client.v1().context().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun contextAddInvalidJsonBody() {
        val contextService = client.v1().context()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<AlchemystAiException> {
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
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
