// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context.view

import com.alchemyst_ai_sdk.api.core.ExcludeMissing
import com.alchemyst_ai_sdk.api.core.JsonField
import com.alchemyst_ai_sdk.api.core.JsonMissing
import com.alchemyst_ai_sdk.api.core.JsonValue
import com.alchemyst_ai_sdk.api.core.checkKnown
import com.alchemyst_ai_sdk.api.core.toImmutable
import com.alchemyst_ai_sdk.api.errors.AlchemystAiInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ViewRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val context: JsonField<List<JsonValue>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("context")
        @ExcludeMissing
        context: JsonField<List<JsonValue>> = JsonMissing.of()
    ) : this(context, mutableMapOf())

    /**
     * List of context items
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun context(): Optional<List<JsonValue>> = context.getOptional("context")

    /**
     * Returns the raw JSON value of [context].
     *
     * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<List<JsonValue>> = context

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

        /** Returns a mutable builder for constructing an instance of [ViewRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ViewRetrieveResponse]. */
    class Builder internal constructor() {

        private var context: JsonField<MutableList<JsonValue>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(viewRetrieveResponse: ViewRetrieveResponse) = apply {
            context = viewRetrieveResponse.context.map { it.toMutableList() }
            additionalProperties = viewRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** List of context items */
        fun context(context: List<JsonValue>) = context(JsonField.of(context))

        /**
         * Sets [Builder.context] to an arbitrary JSON value.
         *
         * You should usually call [Builder.context] with a well-typed `List<JsonValue>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun context(context: JsonField<List<JsonValue>>) = apply {
            this.context = context.map { it.toMutableList() }
        }

        /**
         * Adds a single [JsonValue] to [Builder.context].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContext(context: JsonValue) = apply {
            this.context =
                (this.context ?: JsonField.of(mutableListOf())).also {
                    checkKnown("context", it).add(context)
                }
        }

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
         * Returns an immutable instance of [ViewRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ViewRetrieveResponse =
            ViewRetrieveResponse(
                (context ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ViewRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        context()
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
    @JvmSynthetic internal fun validity(): Int = (context.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ViewRetrieveResponse &&
            context == other.context &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(context, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ViewRetrieveResponse{context=$context, additionalProperties=$additionalProperties}"
}
