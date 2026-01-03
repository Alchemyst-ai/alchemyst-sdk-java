// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import com.alchemystai.sdk.core.ExcludeMissing
import com.alchemystai.sdk.core.JsonField
import com.alchemystai.sdk.core.JsonMissing
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.checkRequired
import com.alchemystai.sdk.errors.AlchemystAiInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional

class MemoryAddResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val contextId: JsonField<String>,
    private val success: JsonField<Boolean>,
    private val processedDocuments: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("context_id") @ExcludeMissing contextId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("processed_documents")
        @ExcludeMissing
        processedDocuments: JsonField<Double> = JsonMissing.of(),
    ) : this(contextId, success, processedDocuments, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contextId(): String = contextId.getRequired("context_id")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun processedDocuments(): Optional<Double> =
        processedDocuments.getOptional("processed_documents")

    /**
     * Returns the raw JSON value of [contextId].
     *
     * Unlike [contextId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("context_id") @ExcludeMissing fun _contextId(): JsonField<String> = contextId

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

    /**
     * Returns the raw JSON value of [processedDocuments].
     *
     * Unlike [processedDocuments], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("processed_documents")
    @ExcludeMissing
    fun _processedDocuments(): JsonField<Double> = processedDocuments

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

        /**
         * Returns a mutable builder for constructing an instance of [MemoryAddResponse].
         *
         * The following fields are required:
         * ```java
         * .contextId()
         * .success()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MemoryAddResponse]. */
    class Builder internal constructor() {

        private var contextId: JsonField<String>? = null
        private var success: JsonField<Boolean>? = null
        private var processedDocuments: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(memoryAddResponse: MemoryAddResponse) = apply {
            contextId = memoryAddResponse.contextId
            success = memoryAddResponse.success
            processedDocuments = memoryAddResponse.processedDocuments
            additionalProperties = memoryAddResponse.additionalProperties.toMutableMap()
        }

        fun contextId(contextId: String) = contextId(JsonField.of(contextId))

        /**
         * Sets [Builder.contextId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contextId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contextId(contextId: JsonField<String>) = apply { this.contextId = contextId }

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

        fun processedDocuments(processedDocuments: Double) =
            processedDocuments(JsonField.of(processedDocuments))

        /**
         * Sets [Builder.processedDocuments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.processedDocuments] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun processedDocuments(processedDocuments: JsonField<Double>) = apply {
            this.processedDocuments = processedDocuments
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
         * Returns an immutable instance of [MemoryAddResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contextId()
         * .success()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MemoryAddResponse =
            MemoryAddResponse(
                checkRequired("contextId", contextId),
                checkRequired("success", success),
                processedDocuments,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MemoryAddResponse = apply {
        if (validated) {
            return@apply
        }

        contextId()
        success()
        processedDocuments()
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
    @JvmSynthetic
    internal fun validity(): Int =
        (if (contextId.asKnown().isPresent) 1 else 0) +
            (if (success.asKnown().isPresent) 1 else 0) +
            (if (processedDocuments.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MemoryAddResponse &&
            contextId == other.contextId &&
            success == other.success &&
            processedDocuments == other.processedDocuments &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(contextId, success, processedDocuments, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MemoryAddResponse{contextId=$contextId, success=$success, processedDocuments=$processedDocuments, additionalProperties=$additionalProperties}"
}
