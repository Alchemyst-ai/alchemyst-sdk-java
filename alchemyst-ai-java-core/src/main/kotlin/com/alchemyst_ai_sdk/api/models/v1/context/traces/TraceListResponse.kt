// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai_sdk.api.models.v1.context.traces

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TraceListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val traces: JsonField<List<Trace>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("traces") @ExcludeMissing traces: JsonField<List<Trace>> = JsonMissing.of()
    ) : this(traces, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun traces(): Optional<List<Trace>> = traces.getOptional("traces")

    /**
     * Returns the raw JSON value of [traces].
     *
     * Unlike [traces], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("traces") @ExcludeMissing fun _traces(): JsonField<List<Trace>> = traces

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

        /** Returns a mutable builder for constructing an instance of [TraceListResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TraceListResponse]. */
    class Builder internal constructor() {

        private var traces: JsonField<MutableList<Trace>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(traceListResponse: TraceListResponse) = apply {
            traces = traceListResponse.traces.map { it.toMutableList() }
            additionalProperties = traceListResponse.additionalProperties.toMutableMap()
        }

        fun traces(traces: List<Trace>) = traces(JsonField.of(traces))

        /**
         * Sets [Builder.traces] to an arbitrary JSON value.
         *
         * You should usually call [Builder.traces] with a well-typed `List<Trace>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun traces(traces: JsonField<List<Trace>>) = apply {
            this.traces = traces.map { it.toMutableList() }
        }

        /**
         * Adds a single [Trace] to [traces].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTrace(trace: Trace) = apply {
            traces =
                (traces ?: JsonField.of(mutableListOf())).also {
                    checkKnown("traces", it).add(trace)
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
         * Returns an immutable instance of [TraceListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TraceListResponse =
            TraceListResponse(
                (traces ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TraceListResponse = apply {
        if (validated) {
            return@apply
        }

        traces().ifPresent { it.forEach { it.validate() } }
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
        (traces.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Trace
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val _id: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val data: JsonValue,
        private val type: JsonField<String>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val userId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("_id") @ExcludeMissing _id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
        ) : this(_id, createdAt, data, type, updatedAt, userId, mutableMapOf())

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun _id(): Optional<String> = _id.getOptional("_id")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userId(): Optional<String> = userId.getOptional("userId")

        /**
         * Returns the raw JSON value of [_id].
         *
         * Unlike [_id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("_id") @ExcludeMissing fun __id(): JsonField<String> = _id

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

        /**
         * Returns the raw JSON value of [userId].
         *
         * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

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

            /** Returns a mutable builder for constructing an instance of [Trace]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Trace]. */
        class Builder internal constructor() {

            private var _id: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var data: JsonValue = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(trace: Trace) = apply {
                _id = trace._id
                createdAt = trace.createdAt
                data = trace.data
                type = trace.type
                updatedAt = trace.updatedAt
                userId = trace.userId
                additionalProperties = trace.additionalProperties.toMutableMap()
            }

            fun _id(_id: String) = _id(JsonField.of(_id))

            /**
             * Sets [Builder._id] to an arbitrary JSON value.
             *
             * You should usually call [Builder._id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun _id(_id: JsonField<String>) = apply { this._id = _id }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun data(data: JsonValue) = apply { this.data = data }

            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
            }

            fun userId(userId: String) = userId(JsonField.of(userId))

            /**
             * Sets [Builder.userId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userId(userId: JsonField<String>) = apply { this.userId = userId }

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
             * Returns an immutable instance of [Trace].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Trace =
                Trace(
                    _id,
                    createdAt,
                    data,
                    type,
                    updatedAt,
                    userId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Trace = apply {
            if (validated) {
                return@apply
            }

            _id()
            createdAt()
            type()
            updatedAt()
            userId()
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
            (if (_id.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0) +
                (if (userId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Trace &&
                _id == other._id &&
                createdAt == other.createdAt &&
                data == other.data &&
                type == other.type &&
                updatedAt == other.updatedAt &&
                userId == other.userId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(_id, createdAt, data, type, updatedAt, userId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Trace{_id=$_id, createdAt=$createdAt, data=$data, type=$type, updatedAt=$updatedAt, userId=$userId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TraceListResponse &&
            traces == other.traces &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(traces, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TraceListResponse{traces=$traces, additionalProperties=$additionalProperties}"
}
