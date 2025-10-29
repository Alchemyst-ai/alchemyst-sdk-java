@file:JvmName("EmptyHandler")

package com.alchemyst_ai.sdk.core.handlers

import com.alchemyst_ai.sdk.core.http.HttpResponse
import com.alchemyst_ai.sdk.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
