package com.alchemyst_ai.sdk.errors

open class AlchemystAiException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
