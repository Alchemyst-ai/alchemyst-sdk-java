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

class MemoryUpdateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val memoryId: JsonField<String>,
    private val success: JsonField<Boolean>,
    private val updatedEntries: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("memory_id") @ExcludeMissing memoryId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("updated_entries")
        @ExcludeMissing
        updatedEntries: JsonField<Double> = JsonMissing.of(),
    ) : this(memoryId, success, updatedEntries, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun memoryId(): String = memoryId.getRequired("memory_id")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedEntries(): Double = updatedEntries.getRequired("updated_entries")

    /**
     * Returns the raw JSON value of [memoryId].
     *
     * Unlike [memoryId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("memory_id") @ExcludeMissing fun _memoryId(): JsonField<String> = memoryId

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

    /**
     * Returns the raw JSON value of [updatedEntries].
     *
     * Unlike [updatedEntries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_entries")
    @ExcludeMissing
    fun _updatedEntries(): JsonField<Double> = updatedEntries

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
         * Returns a mutable builder for constructing an instance of [MemoryUpdateResponse].
         *
         * The following fields are required:
         * ```java
         * .memoryId()
         * .success()
         * .updatedEntries()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MemoryUpdateResponse]. */
    class Builder internal constructor() {

        private var memoryId: JsonField<String>? = null
        private var success: JsonField<Boolean>? = null
        private var updatedEntries: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(memoryUpdateResponse: MemoryUpdateResponse) = apply {
            memoryId = memoryUpdateResponse.memoryId
            success = memoryUpdateResponse.success
            updatedEntries = memoryUpdateResponse.updatedEntries
            additionalProperties = memoryUpdateResponse.additionalProperties.toMutableMap()
        }

        fun memoryId(memoryId: String) = memoryId(JsonField.of(memoryId))

        /**
         * Sets [Builder.memoryId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.memoryId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun memoryId(memoryId: JsonField<String>) = apply { this.memoryId = memoryId }

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

        fun updatedEntries(updatedEntries: Double) = updatedEntries(JsonField.of(updatedEntries))

        /**
         * Sets [Builder.updatedEntries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedEntries] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedEntries(updatedEntries: JsonField<Double>) = apply {
            this.updatedEntries = updatedEntries
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
         * Returns an immutable instance of [MemoryUpdateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .memoryId()
         * .success()
         * .updatedEntries()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MemoryUpdateResponse =
            MemoryUpdateResponse(
                checkRequired("memoryId", memoryId),
                checkRequired("success", success),
                checkRequired("updatedEntries", updatedEntries),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MemoryUpdateResponse = apply {
        if (validated) {
            return@apply
        }

        memoryId()
        success()
        updatedEntries()
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
        (if (memoryId.asKnown().isPresent) 1 else 0) +
            (if (success.asKnown().isPresent) 1 else 0) +
            (if (updatedEntries.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MemoryUpdateResponse &&
            memoryId == other.memoryId &&
            success == other.success &&
            updatedEntries == other.updatedEntries &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(memoryId, success, updatedEntries, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MemoryUpdateResponse{memoryId=$memoryId, success=$success, updatedEntries=$updatedEntries, additionalProperties=$additionalProperties}"
}
