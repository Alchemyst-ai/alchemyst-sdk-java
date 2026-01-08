// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.proguard

import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient
import com.alchemystai.sdk.core.jsonMapper
import com.alchemystai.sdk.models.v1.context.ContextAddResponse
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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
    fun contextAddResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val contextAddResponse =
            ContextAddResponse.builder()
                .contextId("ctx_01HXYZABC")
                .success(true)
                .processedDocuments(2.0)
                .build()

        val roundtrippedContextAddResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contextAddResponse),
                jacksonTypeRef<ContextAddResponse>(),
            )

        assertThat(roundtrippedContextAddResponse).isEqualTo(contextAddResponse)
    }
}
