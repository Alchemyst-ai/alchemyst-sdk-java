// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.proguard

import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.jsonMapper
import com.alchemystai.sdk.models.v1.context.ContextSearchResponse
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/alchemyst-ai-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = AlchemystAiOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.v1()).isNotNull()
    }

    @Test
    fun contextSearchResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val contextSearchResponse =
            ContextSearchResponse.builder()
                .addContext(
                    ContextSearchResponse.Context.builder()
                        .content("content")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .score(0.001)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val roundtrippedContextSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextSearchResponse),
                jacksonTypeRef<ContextSearchResponse>(),
            )

        assertThat(roundtrippedContextSearchResponse).isEqualTo(contextSearchResponse)
    }
}
