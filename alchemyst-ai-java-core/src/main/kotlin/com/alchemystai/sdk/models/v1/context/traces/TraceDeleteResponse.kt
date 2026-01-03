// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TraceDeleteResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val trace: JsonField<Trace>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("trace") @ExcludeMissing trace: JsonField<Trace> = JsonMissing.of()
    ) : this(trace, mutableMapOf())

    /**
     * The deleted trace data
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun trace(): Trace = trace.getRequired("trace")

    /**
     * Returns the raw JSON value of [trace].
     *
     * Unlike [trace], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("trace") @ExcludeMissing fun _trace(): JsonField<Trace> = trace

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
         * Returns a mutable builder for constructing an instance of [TraceDeleteResponse].
         *
         * The following fields are required:
         * ```java
         * .trace()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TraceDeleteResponse]. */
    class Builder internal constructor() {

        private var trace: JsonField<Trace>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(traceDeleteResponse: TraceDeleteResponse) = apply {
            trace = traceDeleteResponse.trace
            additionalProperties = traceDeleteResponse.additionalProperties.toMutableMap()
        }

        /** The deleted trace data */
        fun trace(trace: Trace) = trace(JsonField.of(trace))

        /**
         * Sets [Builder.trace] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trace] with a well-typed [Trace] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun trace(trace: JsonField<Trace>) = apply { this.trace = trace }

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
         *
         * The following fields are required:
         * ```java
         * .trace()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TraceDeleteResponse =
            TraceDeleteResponse(checkRequired("trace", trace), additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): TraceDeleteResponse = apply {
        if (validated) {
            return@apply
        }

        trace().validate()
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
    @JvmSynthetic internal fun validity(): Int = (trace.asKnown().getOrNull()?.validity() ?: 0)

    /** The deleted trace data */
    class Trace
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val _id: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val data: JsonField<Data>,
        private val organizationId: JsonField<String>,
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
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("organizationId")
            @ExcludeMissing
            organizationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
        ) : this(_id, createdAt, data, organizationId, type, updatedAt, userId, mutableMapOf())

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

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun organizationId(): Optional<String> = organizationId.getOptional("organizationId")

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
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        /**
         * Returns the raw JSON value of [organizationId].
         *
         * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("organizationId")
        @ExcludeMissing
        fun _organizationId(): JsonField<String> = organizationId

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
            private var data: JsonField<Data> = JsonMissing.of()
            private var organizationId: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(trace: Trace) = apply {
                _id = trace._id
                createdAt = trace.createdAt
                data = trace.data
                organizationId = trace.organizationId
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

            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            fun organizationId(organizationId: String) =
                organizationId(JsonField.of(organizationId))

            /**
             * Sets [Builder.organizationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.organizationId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun organizationId(organizationId: JsonField<String>) = apply {
                this.organizationId = organizationId
            }

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
                    organizationId,
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
            data().ifPresent { it.validate() }
            organizationId()
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
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (if (organizationId.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0) +
                (if (userId.asKnown().isPresent) 1 else 0)

        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val fileName: JsonField<String>,
            private val query: JsonField<String>,
            private val source: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("fileName")
                @ExcludeMissing
                fileName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
                @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            ) : this(fileName, query, source, mutableMapOf())

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun fileName(): Optional<String> = fileName.getOptional("fileName")

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun query(): Optional<String> = query.getOptional("query")

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun source(): Optional<String> = source.getOptional("source")

            /**
             * Returns the raw JSON value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fileName") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * Returns the raw JSON value of [query].
             *
             * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

            /**
             * Returns the raw JSON value of [source].
             *
             * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var fileName: JsonField<String> = JsonMissing.of()
                private var query: JsonField<String> = JsonMissing.of()
                private var source: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    fileName = data.fileName
                    query = data.query
                    source = data.source
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                fun fileName(fileName: String) = fileName(JsonField.of(fileName))

                /**
                 * Sets [Builder.fileName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                fun query(query: String) = query(JsonField.of(query))

                /**
                 * Sets [Builder.query] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.query] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun query(query: JsonField<String>) = apply { this.query = query }

                fun source(source: String) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<String>) = apply { this.source = source }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data =
                    Data(fileName, query, source, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                fileName()
                query()
                source()
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
                (if (fileName.asKnown().isPresent) 1 else 0) +
                    (if (query.asKnown().isPresent) 1 else 0) +
                    (if (source.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    fileName == other.fileName &&
                    query == other.query &&
                    source == other.source &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(fileName, query, source, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{fileName=$fileName, query=$query, source=$source, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Trace &&
                _id == other._id &&
                createdAt == other.createdAt &&
                data == other.data &&
                organizationId == other.organizationId &&
                type == other.type &&
                updatedAt == other.updatedAt &&
                userId == other.userId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                _id,
                createdAt,
                data,
                organizationId,
                type,
                updatedAt,
                userId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Trace{_id=$_id, createdAt=$createdAt, data=$data, organizationId=$organizationId, type=$type, updatedAt=$updatedAt, userId=$userId, additionalProperties=$additionalProperties}"
    }

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
