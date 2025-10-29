package com.alchemyst_ai_sdk.api.errors

open class AlchemystAiException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
