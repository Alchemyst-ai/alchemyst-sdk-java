// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.addasync.status

import com.alchemystai.sdk.core.ExcludeMissing
import com.alchemystai.sdk.core.JsonField
import com.alchemystai.sdk.core.JsonMissing
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.checkKnown
import com.alchemystai.sdk.core.checkRequired
import com.alchemystai.sdk.core.toImmutable
import com.alchemystai.sdk.errors.AlchemystAiInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class StatusListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val jobs: JsonField<List<Job>>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("jobs") @ExcludeMissing jobs: JsonField<List<Job>> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(jobs, success, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun jobs(): List<Job> = jobs.getRequired("jobs")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * Returns the raw JSON value of [jobs].
     *
     * Unlike [jobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("jobs") @ExcludeMissing fun _jobs(): JsonField<List<Job>> = jobs

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

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
         * Returns a mutable builder for constructing an instance of [StatusListResponse].
         *
         * The following fields are required:
         * ```java
         * .jobs()
         * .success()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StatusListResponse]. */
    class Builder internal constructor() {

        private var jobs: JsonField<MutableList<Job>>? = null
        private var success: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(statusListResponse: StatusListResponse) = apply {
            jobs = statusListResponse.jobs.map { it.toMutableList() }
            success = statusListResponse.success
            additionalProperties = statusListResponse.additionalProperties.toMutableMap()
        }

        fun jobs(jobs: List<Job>) = jobs(JsonField.of(jobs))

        /**
         * Sets [Builder.jobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.jobs] with a well-typed `List<Job>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun jobs(jobs: JsonField<List<Job>>) = apply { this.jobs = jobs.map { it.toMutableList() } }

        /**
         * Adds a single [Job] to [jobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addJob(job: Job) = apply {
            jobs = (jobs ?: JsonField.of(mutableListOf())).also { checkKnown("jobs", it).add(job) }
        }

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

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
         * Returns an immutable instance of [StatusListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .jobs()
         * .success()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StatusListResponse =
            StatusListResponse(
                checkRequired("jobs", jobs).map { it.toImmutable() },
                checkRequired("success", success),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StatusListResponse = apply {
        if (validated) {
            return@apply
        }

        jobs().forEach { it.validate() }
        success()
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
        (jobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    class Job
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attemptsMade: JsonField<Double>,
        private val data: JsonValue,
        private val jobId: JsonField<String>,
        private val status: JsonField<String>,
        private val failedReason: JsonField<String>,
        private val finishedOn: JsonField<Double>,
        private val processedOn: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attemptsMade")
            @ExcludeMissing
            attemptsMade: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
            @JsonProperty("jobId") @ExcludeMissing jobId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("failedReason")
            @ExcludeMissing
            failedReason: JsonField<String> = JsonMissing.of(),
            @JsonProperty("finishedOn")
            @ExcludeMissing
            finishedOn: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("processedOn")
            @ExcludeMissing
            processedOn: JsonField<Double> = JsonMissing.of(),
        ) : this(
            attemptsMade,
            data,
            jobId,
            status,
            failedReason,
            finishedOn,
            processedOn,
            mutableMapOf(),
        )

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun attemptsMade(): Double = attemptsMade.getRequired("attemptsMade")

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

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
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun failedReason(): Optional<String> = failedReason.getOptional("failedReason")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun finishedOn(): Optional<Double> = finishedOn.getOptional("finishedOn")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun processedOn(): Optional<Double> = processedOn.getOptional("processedOn")

        /**
         * Returns the raw JSON value of [attemptsMade].
         *
         * Unlike [attemptsMade], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("attemptsMade")
        @ExcludeMissing
        fun _attemptsMade(): JsonField<Double> = attemptsMade

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
         * Returns the raw JSON value of [failedReason].
         *
         * Unlike [failedReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("failedReason")
        @ExcludeMissing
        fun _failedReason(): JsonField<String> = failedReason

        /**
         * Returns the raw JSON value of [finishedOn].
         *
         * Unlike [finishedOn], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("finishedOn")
        @ExcludeMissing
        fun _finishedOn(): JsonField<Double> = finishedOn

        /**
         * Returns the raw JSON value of [processedOn].
         *
         * Unlike [processedOn], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("processedOn")
        @ExcludeMissing
        fun _processedOn(): JsonField<Double> = processedOn

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
             * Returns a mutable builder for constructing an instance of [Job].
             *
             * The following fields are required:
             * ```java
             * .attemptsMade()
             * .data()
             * .jobId()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Job]. */
        class Builder internal constructor() {

            private var attemptsMade: JsonField<Double>? = null
            private var data: JsonValue? = null
            private var jobId: JsonField<String>? = null
            private var status: JsonField<String>? = null
            private var failedReason: JsonField<String> = JsonMissing.of()
            private var finishedOn: JsonField<Double> = JsonMissing.of()
            private var processedOn: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(job: Job) = apply {
                attemptsMade = job.attemptsMade
                data = job.data
                jobId = job.jobId
                status = job.status
                failedReason = job.failedReason
                finishedOn = job.finishedOn
                processedOn = job.processedOn
                additionalProperties = job.additionalProperties.toMutableMap()
            }

            fun attemptsMade(attemptsMade: Double) = attemptsMade(JsonField.of(attemptsMade))

            /**
             * Sets [Builder.attemptsMade] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attemptsMade] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun attemptsMade(attemptsMade: JsonField<Double>) = apply {
                this.attemptsMade = attemptsMade
            }

            fun data(data: JsonValue) = apply { this.data = data }

            fun jobId(jobId: String) = jobId(JsonField.of(jobId))

            /**
             * Sets [Builder.jobId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.jobId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun jobId(jobId: JsonField<String>) = apply { this.jobId = jobId }

            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            fun failedReason(failedReason: String) = failedReason(JsonField.of(failedReason))

            /**
             * Sets [Builder.failedReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failedReason] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun failedReason(failedReason: JsonField<String>) = apply {
                this.failedReason = failedReason
            }

            fun finishedOn(finishedOn: Double) = finishedOn(JsonField.of(finishedOn))

            /**
             * Sets [Builder.finishedOn] to an arbitrary JSON value.
             *
             * You should usually call [Builder.finishedOn] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun finishedOn(finishedOn: JsonField<Double>) = apply { this.finishedOn = finishedOn }

            fun processedOn(processedOn: Double) = processedOn(JsonField.of(processedOn))

            /**
             * Sets [Builder.processedOn] to an arbitrary JSON value.
             *
             * You should usually call [Builder.processedOn] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun processedOn(processedOn: JsonField<Double>) = apply {
                this.processedOn = processedOn
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
             * Returns an immutable instance of [Job].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .attemptsMade()
             * .data()
             * .jobId()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Job =
                Job(
                    checkRequired("attemptsMade", attemptsMade),
                    checkRequired("data", data),
                    checkRequired("jobId", jobId),
                    checkRequired("status", status),
                    failedReason,
                    finishedOn,
                    processedOn,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Job = apply {
            if (validated) {
                return@apply
            }

            attemptsMade()
            jobId()
            status()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (attemptsMade.asKnown().isPresent) 1 else 0) +
                (if (jobId.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (failedReason.asKnown().isPresent) 1 else 0) +
                (if (finishedOn.asKnown().isPresent) 1 else 0) +
                (if (processedOn.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Job &&
                attemptsMade == other.attemptsMade &&
                data == other.data &&
                jobId == other.jobId &&
                status == other.status &&
                failedReason == other.failedReason &&
                finishedOn == other.finishedOn &&
                processedOn == other.processedOn &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                attemptsMade,
                data,
                jobId,
                status,
                failedReason,
                finishedOn,
                processedOn,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Job{attemptsMade=$attemptsMade, data=$data, jobId=$jobId, status=$status, failedReason=$failedReason, finishedOn=$finishedOn, processedOn=$processedOn, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StatusListResponse &&
            jobs == other.jobs &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(jobs, success, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StatusListResponse{jobs=$jobs, success=$success, additionalProperties=$additionalProperties}"
}
