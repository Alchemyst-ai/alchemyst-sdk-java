// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.org.context

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextViewParamsTest {

    @Test
    fun create() {
        ContextViewParams.builder().addUserId("string").build()
    }

    @Test
    fun body() {
        val params = ContextViewParams.builder().addUserId("string").build()

        val body = params._body()

        assertThat(body.userIds()).containsExactly("string")
    }
}
