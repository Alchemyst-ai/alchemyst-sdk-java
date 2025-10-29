package com.alchemyst_ai.sdk.errors

class AlchemystAiInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    AlchemystAiException(message, cause)
