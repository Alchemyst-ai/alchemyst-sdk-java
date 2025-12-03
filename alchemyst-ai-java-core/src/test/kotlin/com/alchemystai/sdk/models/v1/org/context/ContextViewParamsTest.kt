// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.org.context

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextViewParamsTest {

    @Test
    fun create() {
        ContextViewParams.builder().addUserId("user_123").addUserId("user_456").build()
    }

    @Test
    fun body() {
        val params = ContextViewParams.builder().addUserId("user_123").addUserId("user_456").build()

        val body = params._body()

        assertThat(body.userIds()).containsExactly("user_123", "user_456")
    }
}
