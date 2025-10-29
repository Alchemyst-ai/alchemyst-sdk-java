@file:JvmName("JsonHandler")

package com.alchemyst_ai.sdk.core.handlers

import com.alchemyst_ai.sdk.core.http.HttpResponse
import com.alchemyst_ai.sdk.core.http.HttpResponse.Handler
import com.alchemyst_ai.sdk.errors.AlchemystAiInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw AlchemystAiInvalidDataException("Error reading response", e)
            }
    }
