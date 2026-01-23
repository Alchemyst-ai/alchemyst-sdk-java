// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync.status

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

class StatusRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val jobId: JsonField<String>,
    private val status: JsonField<String>,
    private val success: JsonField<Boolean>,
    private val attemptsMade: JsonField<Double>,
    private val failedReason: JsonField<String>,
    private val finishedOn: JsonField<Double>,
    private val processedOn: JsonField<Double>,
    private val result: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("jobId") @ExcludeMissing jobId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("attemptsMade")
        @ExcludeMissing
        attemptsMade: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("failedReason")
        @ExcludeMissing
        failedReason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("finishedOn")
        @ExcludeMissing
        finishedOn: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("processedOn")
        @ExcludeMissing
        processedOn: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("result") @ExcludeMissing result: JsonValue = JsonMissing.of(),
    ) : this(
        jobId,
        status,
        success,
        attemptsMade,
        failedReason,
        finishedOn,
        processedOn,
        result,
        mutableMapOf(),
    )

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun jobId(): String = jobId.getRequired("jobId")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attemptsMade(): Optional<Double> = attemptsMade.getOptional("attemptsMade")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun failedReason(): Optional<String> = failedReason.getOptional("failedReason")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun finishedOn(): Optional<Double> = finishedOn.getOptional("finishedOn")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun processedOn(): Optional<Double> = processedOn.getOptional("processedOn")

    /**
     * Result of the job (if available)
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = statusRetrieveResponse.result().convert(MyClass.class);
     * ```
     */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonValue = result

    /**
     * Returns the raw JSON value of [jobId].
     *
     * Unlike [jobId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("jobId") @ExcludeMissing fun _jobId(): JsonField<String> = jobId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

    /**
     * Returns the raw JSON value of [attemptsMade].
     *
     * Unlike [attemptsMade], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attemptsMade")
    @ExcludeMissing
    fun _attemptsMade(): JsonField<Double> = attemptsMade

    /**
     * Returns the raw JSON value of [failedReason].
     *
     * Unlike [failedReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failedReason")
    @ExcludeMissing
    fun _failedReason(): JsonField<String> = failedReason

    /**
     * Returns the raw JSON value of [finishedOn].
     *
     * Unlike [finishedOn], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("finishedOn") @ExcludeMissing fun _finishedOn(): JsonField<Double> = finishedOn

    /**
     * Returns the raw JSON value of [processedOn].
     *
     * Unlike [processedOn], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("processedOn") @ExcludeMissing fun _processedOn(): JsonField<Double> = processedOn

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
         * Returns a mutable builder for constructing an instance of [StatusRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .jobId()
         * .status()
         * .success()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StatusRetrieveResponse]. */
    class Builder internal constructor() {

        private var jobId: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var success: JsonField<Boolean>? = null
        private var attemptsMade: JsonField<Double> = JsonMissing.of()
        private var failedReason: JsonField<String> = JsonMissing.of()
        private var finishedOn: JsonField<Double> = JsonMissing.of()
        private var processedOn: JsonField<Double> = JsonMissing.of()
        private var result: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(statusRetrieveResponse: StatusRetrieveResponse) = apply {
            jobId = statusRetrieveResponse.jobId
            status = statusRetrieveResponse.status
            success = statusRetrieveResponse.success
            attemptsMade = statusRetrieveResponse.attemptsMade
            failedReason = statusRetrieveResponse.failedReason
            finishedOn = statusRetrieveResponse.finishedOn
            processedOn = statusRetrieveResponse.processedOn
            result = statusRetrieveResponse.result
            additionalProperties = statusRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun jobId(jobId: String) = jobId(JsonField.of(jobId))

        /**
         * Sets [Builder.jobId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.jobId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun jobId(jobId: JsonField<String>) = apply { this.jobId = jobId }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

        fun attemptsMade(attemptsMade: Double) = attemptsMade(JsonField.of(attemptsMade))

        /**
         * Sets [Builder.attemptsMade] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attemptsMade] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun attemptsMade(attemptsMade: JsonField<Double>) = apply {
            this.attemptsMade = attemptsMade
        }

        fun failedReason(failedReason: String) = failedReason(JsonField.of(failedReason))

        /**
         * Sets [Builder.failedReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failedReason] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun failedReason(failedReason: JsonField<String>) = apply {
            this.failedReason = failedReason
        }

        fun finishedOn(finishedOn: Double) = finishedOn(JsonField.of(finishedOn))

        /**
         * Sets [Builder.finishedOn] to an arbitrary JSON value.
         *
         * You should usually call [Builder.finishedOn] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun finishedOn(finishedOn: JsonField<Double>) = apply { this.finishedOn = finishedOn }

        fun processedOn(processedOn: Double) = processedOn(JsonField.of(processedOn))

        /**
         * Sets [Builder.processedOn] to an arbitrary JSON value.
         *
         * You should usually call [Builder.processedOn] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun processedOn(processedOn: JsonField<Double>) = apply { this.processedOn = processedOn }

        /** Result of the job (if available) */
        fun result(result: JsonValue) = apply { this.result = result }

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
         * Returns an immutable instance of [StatusRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .jobId()
         * .status()
         * .success()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StatusRetrieveResponse =
            StatusRetrieveResponse(
                checkRequired("jobId", jobId),
                checkRequired("status", status),
                checkRequired("success", success),
                attemptsMade,
                failedReason,
                finishedOn,
                processedOn,
                result,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StatusRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        jobId()
        status()
        success()
        attemptsMade()
        failedReason()
        finishedOn()
        processedOn()
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
        (if (jobId.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (success.asKnown().isPresent) 1 else 0) +
            (if (attemptsMade.asKnown().isPresent) 1 else 0) +
            (if (failedReason.asKnown().isPresent) 1 else 0) +
            (if (finishedOn.asKnown().isPresent) 1 else 0) +
            (if (processedOn.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StatusRetrieveResponse &&
            jobId == other.jobId &&
            status == other.status &&
            success == other.success &&
            attemptsMade == other.attemptsMade &&
            failedReason == other.failedReason &&
            finishedOn == other.finishedOn &&
            processedOn == other.processedOn &&
            result == other.result &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            jobId,
            status,
            success,
            attemptsMade,
            failedReason,
            finishedOn,
            processedOn,
            result,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StatusRetrieveResponse{jobId=$jobId, status=$status, success=$success, attemptsMade=$attemptsMade, failedReason=$failedReason, finishedOn=$finishedOn, processedOn=$processedOn, result=$result, additionalProperties=$additionalProperties}"
}
