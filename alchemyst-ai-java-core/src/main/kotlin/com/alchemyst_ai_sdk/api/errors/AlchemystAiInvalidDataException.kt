package com.alchemyst_ai_sdk.api.errors

class AlchemystAiInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    AlchemystAiException(message, cause)
