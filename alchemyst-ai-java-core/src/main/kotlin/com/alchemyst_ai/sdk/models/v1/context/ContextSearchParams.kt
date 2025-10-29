// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.models.v1.context

import com.alchemyst_ai.sdk.core.Enum
import com.alchemyst_ai.sdk.core.ExcludeMissing
import com.alchemyst_ai.sdk.core.JsonField
import com.alchemyst_ai.sdk.core.JsonMissing
import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.core.Params
import com.alchemyst_ai.sdk.core.checkRequired
import com.alchemyst_ai.sdk.core.http.Headers
import com.alchemyst_ai.sdk.core.http.QueryParams
import com.alchemyst_ai.sdk.errors.AlchemystAiInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * This endpoint sends a search request to the context processor to retrieve relevant context data
 * based on the provided query.
 */
class ContextSearchParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Minimum similarity threshold
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun minimumSimilarityThreshold(): Double = body.minimumSimilarityThreshold()

    /**
     * The search query used to search for context data
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun query(): String = body.query()

    /**
     * Maximum similarity threshold (must be >= minimum_similarity_threshold)
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun similarityThreshold(): Double = body.similarityThreshold()

    /** Additional metadata for the search */
    fun _metadata(): JsonValue = body._metadata()

    /**
     * Search scope
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scope(): Optional<Scope> = body.scope()

    /**
     * The ID of the user making the request
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userId(): Optional<String> = body.userId()

    /**
     * Returns the raw JSON value of [minimumSimilarityThreshold].
     *
     * Unlike [minimumSimilarityThreshold], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _minimumSimilarityThreshold(): JsonField<Double> = body._minimumSimilarityThreshold()

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _query(): JsonField<String> = body._query()

    /**
     * Returns the raw JSON value of [similarityThreshold].
     *
     * Unlike [similarityThreshold], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _similarityThreshold(): JsonField<Double> = body._similarityThreshold()

    /**
     * Returns the raw JSON value of [scope].
     *
     * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scope(): JsonField<Scope> = body._scope()

    /**
     * Returns the raw JSON value of [userId].
     *
     * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _userId(): JsonField<String> = body._userId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContextSearchParams].
         *
         * The following fields are required:
         * ```java
         * .minimumSimilarityThreshold()
         * .query()
         * .similarityThreshold()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContextSearchParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(contextSearchParams: ContextSearchParams) = apply {
            body = contextSearchParams.body.toBuilder()
            additionalHeaders = contextSearchParams.additionalHeaders.toBuilder()
            additionalQueryParams = contextSearchParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [minimumSimilarityThreshold]
         * - [query]
         * - [similarityThreshold]
         * - [metadata]
         * - [scope]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Minimum similarity threshold */
        fun minimumSimilarityThreshold(minimumSimilarityThreshold: Double) = apply {
            body.minimumSimilarityThreshold(minimumSimilarityThreshold)
        }

        /**
         * Sets [Builder.minimumSimilarityThreshold] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minimumSimilarityThreshold] with a well-typed [Double]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun minimumSimilarityThreshold(minimumSimilarityThreshold: JsonField<Double>) = apply {
            body.minimumSimilarityThreshold(minimumSimilarityThreshold)
        }

        /** The search query used to search for context data */
        fun query(query: String) = apply { body.query(query) }

        /**
         * Sets [Builder.query] to an arbitrary JSON value.
         *
         * You should usually call [Builder.query] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun query(query: JsonField<String>) = apply { body.query(query) }

        /** Maximum similarity threshold (must be >= minimum_similarity_threshold) */
        fun similarityThreshold(similarityThreshold: Double) = apply {
            body.similarityThreshold(similarityThreshold)
        }

        /**
         * Sets [Builder.similarityThreshold] to an arbitrary JSON value.
         *
         * You should usually call [Builder.similarityThreshold] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun similarityThreshold(similarityThreshold: JsonField<Double>) = apply {
            body.similarityThreshold(similarityThreshold)
        }

        /** Additional metadata for the search */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /** Search scope */
        fun scope(scope: Scope) = apply { body.scope(scope) }

        /**
         * Sets [Builder.scope] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scope] with a well-typed [Scope] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun scope(scope: JsonField<Scope>) = apply { body.scope(scope) }

        /** The ID of the user making the request */
        fun userId(userId: String) = apply { body.userId(userId) }

        /**
         * Sets [Builder.userId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun userId(userId: JsonField<String>) = apply { body.userId(userId) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ContextSearchParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .minimumSimilarityThreshold()
         * .query()
         * .similarityThreshold()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContextSearchParams =
            ContextSearchParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val minimumSimilarityThreshold: JsonField<Double>,
        private val query: JsonField<String>,
        private val similarityThreshold: JsonField<Double>,
        private val metadata: JsonValue,
        private val scope: JsonField<Scope>,
        private val userId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("minimum_similarity_threshold")
            @ExcludeMissing
            minimumSimilarityThreshold: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
            @JsonProperty("similarity_threshold")
            @ExcludeMissing
            similarityThreshold: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("metadata") @ExcludeMissing metadata: JsonValue = JsonMissing.of(),
            @JsonProperty("scope") @ExcludeMissing scope: JsonField<Scope> = JsonMissing.of(),
            @JsonProperty("user_id") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
        ) : this(
            minimumSimilarityThreshold,
            query,
            similarityThreshold,
            metadata,
            scope,
            userId,
            mutableMapOf(),
        )

        /**
         * Minimum similarity threshold
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun minimumSimilarityThreshold(): Double =
            minimumSimilarityThreshold.getRequired("minimum_similarity_threshold")

        /**
         * The search query used to search for context data
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun query(): String = query.getRequired("query")

        /**
         * Maximum similarity threshold (must be >= minimum_similarity_threshold)
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun similarityThreshold(): Double = similarityThreshold.getRequired("similarity_threshold")

        /** Additional metadata for the search */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /**
         * Search scope
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun scope(): Optional<Scope> = scope.getOptional("scope")

        /**
         * The ID of the user making the request
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userId(): Optional<String> = userId.getOptional("user_id")

        /**
         * Returns the raw JSON value of [minimumSimilarityThreshold].
         *
         * Unlike [minimumSimilarityThreshold], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("minimum_similarity_threshold")
        @ExcludeMissing
        fun _minimumSimilarityThreshold(): JsonField<Double> = minimumSimilarityThreshold

        /**
         * Returns the raw JSON value of [query].
         *
         * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

        /**
         * Returns the raw JSON value of [similarityThreshold].
         *
         * Unlike [similarityThreshold], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("similarity_threshold")
        @ExcludeMissing
        fun _similarityThreshold(): JsonField<Double> = similarityThreshold

        /**
         * Returns the raw JSON value of [scope].
         *
         * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scope") @ExcludeMissing fun _scope(): JsonField<Scope> = scope

        /**
         * Returns the raw JSON value of [userId].
         *
         * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .minimumSimilarityThreshold()
             * .query()
             * .similarityThreshold()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var minimumSimilarityThreshold: JsonField<Double>? = null
            private var query: JsonField<String>? = null
            private var similarityThreshold: JsonField<Double>? = null
            private var metadata: JsonValue = JsonMissing.of()
            private var scope: JsonField<Scope> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                minimumSimilarityThreshold = body.minimumSimilarityThreshold
                query = body.query
                similarityThreshold = body.similarityThreshold
                metadata = body.metadata
                scope = body.scope
                userId = body.userId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Minimum similarity threshold */
            fun minimumSimilarityThreshold(minimumSimilarityThreshold: Double) =
                minimumSimilarityThreshold(JsonField.of(minimumSimilarityThreshold))

            /**
             * Sets [Builder.minimumSimilarityThreshold] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minimumSimilarityThreshold] with a well-typed
             * [Double] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun minimumSimilarityThreshold(minimumSimilarityThreshold: JsonField<Double>) = apply {
                this.minimumSimilarityThreshold = minimumSimilarityThreshold
            }

            /** The search query used to search for context data */
            fun query(query: String) = query(JsonField.of(query))

            /**
             * Sets [Builder.query] to an arbitrary JSON value.
             *
             * You should usually call [Builder.query] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun query(query: JsonField<String>) = apply { this.query = query }

            /** Maximum similarity threshold (must be >= minimum_similarity_threshold) */
            fun similarityThreshold(similarityThreshold: Double) =
                similarityThreshold(JsonField.of(similarityThreshold))

            /**
             * Sets [Builder.similarityThreshold] to an arbitrary JSON value.
             *
             * You should usually call [Builder.similarityThreshold] with a well-typed [Double]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun similarityThreshold(similarityThreshold: JsonField<Double>) = apply {
                this.similarityThreshold = similarityThreshold
            }

            /** Additional metadata for the search */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /** Search scope */
            fun scope(scope: Scope) = scope(JsonField.of(scope))

            /**
             * Sets [Builder.scope] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scope] with a well-typed [Scope] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun scope(scope: JsonField<Scope>) = apply { this.scope = scope }

            /** The ID of the user making the request */
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .minimumSimilarityThreshold()
             * .query()
             * .similarityThreshold()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("minimumSimilarityThreshold", minimumSimilarityThreshold),
                    checkRequired("query", query),
                    checkRequired("similarityThreshold", similarityThreshold),
                    metadata,
                    scope,
                    userId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            minimumSimilarityThreshold()
            query()
            similarityThreshold()
            scope().ifPresent { it.validate() }
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
            (if (minimumSimilarityThreshold.asKnown().isPresent) 1 else 0) +
                (if (query.asKnown().isPresent) 1 else 0) +
                (if (similarityThreshold.asKnown().isPresent) 1 else 0) +
                (scope.asKnown().getOrNull()?.validity() ?: 0) +
                (if (userId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                minimumSimilarityThreshold == other.minimumSimilarityThreshold &&
                query == other.query &&
                similarityThreshold == other.similarityThreshold &&
                metadata == other.metadata &&
                scope == other.scope &&
                userId == other.userId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                minimumSimilarityThreshold,
                query,
                similarityThreshold,
                metadata,
                scope,
                userId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{minimumSimilarityThreshold=$minimumSimilarityThreshold, query=$query, similarityThreshold=$similarityThreshold, metadata=$metadata, scope=$scope, userId=$userId, additionalProperties=$additionalProperties}"
    }

    /** Search scope */
    class Scope @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INTERNAL = of("internal")

            @JvmField val EXTERNAL = of("external")

            @JvmStatic fun of(value: String) = Scope(JsonField.of(value))
        }

        /** An enum containing [Scope]'s known values. */
        enum class Known {
            INTERNAL,
            EXTERNAL,
        }

        /**
         * An enum containing [Scope]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Scope] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INTERNAL,
            EXTERNAL,
            /** An enum member indicating that [Scope] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INTERNAL -> Value.INTERNAL
                EXTERNAL -> Value.EXTERNAL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws AlchemystAiInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                INTERNAL -> Known.INTERNAL
                EXTERNAL -> Known.EXTERNAL
                else -> throw AlchemystAiInvalidDataException("Unknown Scope: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws AlchemystAiInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                AlchemystAiInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Scope = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Scope && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContextSearchParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ContextSearchParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
