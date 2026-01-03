// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.services

import com.alchemystai.sdk.client.AlchemystAiClient
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.http.Headers
import com.alchemystai.sdk.core.jsonMapper
import com.alchemystai.sdk.errors.AlchemystAiException
import com.alchemystai.sdk.errors.BadRequestException
import com.alchemystai.sdk.errors.InternalServerException
import com.alchemystai.sdk.errors.NotFoundException
import com.alchemystai.sdk.errors.PermissionDeniedException
import com.alchemystai.sdk.errors.RateLimitException
import com.alchemystai.sdk.errors.UnauthorizedException
import com.alchemystai.sdk.errors.UnexpectedStatusCodeException
import com.alchemystai.sdk.errors.UnprocessableEntityException
import com.alchemystai.sdk.models.v1.context.ContextAddParams
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
                        .addDocument(
                            ContextAddParams.Document.builder()
                                .content("Customer asked about pricing for the Scale plan.")
                                .build()
                        )
                        .scope(ContextAddParams.Scope.INTERNAL)
                        .source("support-inbox")
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
