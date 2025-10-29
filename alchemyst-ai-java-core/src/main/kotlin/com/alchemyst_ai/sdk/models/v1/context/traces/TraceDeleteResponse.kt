// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.models.v1.context.traces

import com.alchemyst_ai.sdk.core.ExcludeMissing
import com.alchemyst_ai.sdk.core.JsonMissing
import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.errors.AlchemystAiInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects

class TraceDeleteResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val trace: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("trace") @ExcludeMissing trace: JsonValue = JsonMissing.of()
    ) : this(trace, mutableMapOf())

    /** The deleted trace data */
    @JsonProperty("trace") @ExcludeMissing fun _trace(): JsonValue = trace

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [TraceDeleteResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TraceDeleteResponse]. */
    class Builder internal constructor() {

        private var trace: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(traceDeleteResponse: TraceDeleteResponse) = apply {
            trace = traceDeleteResponse.trace
            additionalProperties = traceDeleteResponse.additionalProperties.toMutableMap()
        }

        /** The deleted trace data */
        fun trace(trace: JsonValue) = apply { this.trace = trace }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [TraceDeleteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TraceDeleteResponse =
            TraceDeleteResponse(trace, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): TraceDeleteResponse = apply {
        if (validated) {
            return@apply
        }

        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: AlchemystAiInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TraceDeleteResponse &&
            trace == other.trace &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(trace, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TraceDeleteResponse{trace=$trace, additionalProperties=$additionalProperties}"
}
