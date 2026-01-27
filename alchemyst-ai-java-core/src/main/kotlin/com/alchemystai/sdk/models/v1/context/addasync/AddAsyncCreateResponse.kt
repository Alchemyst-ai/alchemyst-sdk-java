// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync

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

class AddAsyncCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val jobId: JsonField<String>,
    private val queued: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("jobId") @ExcludeMissing jobId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("queued") @ExcludeMissing queued: JsonField<Boolean> = JsonMissing.of(),
    ) : this(jobId, queued, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun jobId(): String = jobId.getRequired("jobId")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun queued(): Boolean = queued.getRequired("queued")

    /**
     * Returns the raw JSON value of [jobId].
     *
     * Unlike [jobId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("jobId") @ExcludeMissing fun _jobId(): JsonField<String> = jobId

    /**
     * Returns the raw JSON value of [queued].
     *
     * Unlike [queued], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("queued") @ExcludeMissing fun _queued(): JsonField<Boolean> = queued

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
         * Returns a mutable builder for constructing an instance of [AddAsyncCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .jobId()
         * .queued()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AddAsyncCreateResponse]. */
    class Builder internal constructor() {

        private var jobId: JsonField<String>? = null
        private var queued: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(addAsyncCreateResponse: AddAsyncCreateResponse) = apply {
            jobId = addAsyncCreateResponse.jobId
            queued = addAsyncCreateResponse.queued
            additionalProperties = addAsyncCreateResponse.additionalProperties.toMutableMap()
        }

        fun jobId(jobId: String) = jobId(JsonField.of(jobId))

        /**
         * Sets [Builder.jobId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.jobId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun jobId(jobId: JsonField<String>) = apply { this.jobId = jobId }

        fun queued(queued: Boolean) = queued(JsonField.of(queued))

        /**
         * Sets [Builder.queued] to an arbitrary JSON value.
         *
         * You should usually call [Builder.queued] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun queued(queued: JsonField<Boolean>) = apply { this.queued = queued }

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
         * Returns an immutable instance of [AddAsyncCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .jobId()
         * .queued()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AddAsyncCreateResponse =
            AddAsyncCreateResponse(
                checkRequired("jobId", jobId),
                checkRequired("queued", queued),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AddAsyncCreateResponse = apply {
        if (validated) {
            return@apply
        }

        jobId()
        queued()
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
        (if (jobId.asKnown().isPresent) 1 else 0) + (if (queued.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AddAsyncCreateResponse &&
            jobId == other.jobId &&
            queued == other.queued &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(jobId, queued, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AddAsyncCreateResponse{jobId=$jobId, queued=$queued, additionalProperties=$additionalProperties}"
}
