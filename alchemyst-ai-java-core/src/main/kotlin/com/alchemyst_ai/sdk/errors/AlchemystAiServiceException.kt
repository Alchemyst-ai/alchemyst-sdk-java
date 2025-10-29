// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.errors

import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.core.http.Headers

abstract class AlchemystAiServiceException
protected constructor(message: String, cause: Throwable? = null) :
    AlchemystAiException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
