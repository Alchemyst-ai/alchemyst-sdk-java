// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.traces

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class TraceListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val pagination: JsonField<Pagination>,
    private val traces: JsonField<List<Trace>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("pagination")
        @ExcludeMissing
        pagination: JsonField<Pagination> = JsonMissing.of(),
        @JsonProperty("traces") @ExcludeMissing traces: JsonField<List<Trace>> = JsonMissing.of(),
    ) : this(pagination, traces, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pagination(): Pagination = pagination.getRequired("pagination")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun traces(): List<Trace> = traces.getRequired("traces")

    /**
     * Returns the raw JSON value of [pagination].
     *
     * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pagination")
    @ExcludeMissing
    fun _pagination(): JsonField<Pagination> = pagination

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

        /**
         * Returns a mutable builder for constructing an instance of [TraceListResponse].
         *
         * The following fields are required:
         * ```java
         * .pagination()
         * .traces()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TraceListResponse]. */
    class Builder internal constructor() {

        private var pagination: JsonField<Pagination>? = null
        private var traces: JsonField<MutableList<Trace>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(traceListResponse: TraceListResponse) = apply {
            pagination = traceListResponse.pagination
            traces = traceListResponse.traces.map { it.toMutableList() }
            additionalProperties = traceListResponse.additionalProperties.toMutableMap()
        }

        fun pagination(pagination: Pagination) = pagination(JsonField.of(pagination))

        /**
         * Sets [Builder.pagination] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pagination] with a well-typed [Pagination] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pagination(pagination: JsonField<Pagination>) = apply { this.pagination = pagination }

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
         *
         * The following fields are required:
         * ```java
         * .pagination()
         * .traces()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TraceListResponse =
            TraceListResponse(
                checkRequired("pagination", pagination),
                checkRequired("traces", traces).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TraceListResponse = apply {
        if (validated) {
            return@apply
        }

        pagination().validate()
        traces().forEach { it.validate() }
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
        (pagination.asKnown().getOrNull()?.validity() ?: 0) +
            (traces.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Pagination
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hasNextPage: JsonField<Boolean>,
        private val hasPrevPage: JsonField<Boolean>,
        private val limit: JsonField<Long>,
        private val page: JsonField<Long>,
        private val total: JsonField<Long>,
        private val totalPages: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hasNextPage")
            @ExcludeMissing
            hasNextPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("hasPrevPage")
            @ExcludeMissing
            hasPrevPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("page") @ExcludeMissing page: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("totalPages")
            @ExcludeMissing
            totalPages: JsonField<Long> = JsonMissing.of(),
        ) : this(hasNextPage, hasPrevPage, limit, page, total, totalPages, mutableMapOf())

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hasNextPage(): Boolean = hasNextPage.getRequired("hasNextPage")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hasPrevPage(): Boolean = hasPrevPage.getRequired("hasPrevPage")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun limit(): Long = limit.getRequired("limit")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun page(): Long = page.getRequired("page")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun total(): Long = total.getRequired("total")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalPages(): Long = totalPages.getRequired("totalPages")

        /**
         * Returns the raw JSON value of [hasNextPage].
         *
         * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasNextPage")
        @ExcludeMissing
        fun _hasNextPage(): JsonField<Boolean> = hasNextPage

        /**
         * Returns the raw JSON value of [hasPrevPage].
         *
         * Unlike [hasPrevPage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasPrevPage")
        @ExcludeMissing
        fun _hasPrevPage(): JsonField<Boolean> = hasPrevPage

        /**
         * Returns the raw JSON value of [limit].
         *
         * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

        /**
         * Returns the raw JSON value of [page].
         *
         * Unlike [page], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("page") @ExcludeMissing fun _page(): JsonField<Long> = page

        /**
         * Returns the raw JSON value of [total].
         *
         * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

        /**
         * Returns the raw JSON value of [totalPages].
         *
         * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("totalPages") @ExcludeMissing fun _totalPages(): JsonField<Long> = totalPages

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
             * Returns a mutable builder for constructing an instance of [Pagination].
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .hasPrevPage()
             * .limit()
             * .page()
             * .total()
             * .totalPages()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Pagination]. */
        class Builder internal constructor() {

            private var hasNextPage: JsonField<Boolean>? = null
            private var hasPrevPage: JsonField<Boolean>? = null
            private var limit: JsonField<Long>? = null
            private var page: JsonField<Long>? = null
            private var total: JsonField<Long>? = null
            private var totalPages: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(pagination: Pagination) = apply {
                hasNextPage = pagination.hasNextPage
                hasPrevPage = pagination.hasPrevPage
                limit = pagination.limit
                page = pagination.page
                total = pagination.total
                totalPages = pagination.totalPages
                additionalProperties = pagination.additionalProperties.toMutableMap()
            }

            fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

            /**
             * Sets [Builder.hasNextPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply {
                this.hasNextPage = hasNextPage
            }

            fun hasPrevPage(hasPrevPage: Boolean) = hasPrevPage(JsonField.of(hasPrevPage))

            /**
             * Sets [Builder.hasPrevPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasPrevPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasPrevPage(hasPrevPage: JsonField<Boolean>) = apply {
                this.hasPrevPage = hasPrevPage
            }

            fun limit(limit: Long) = limit(JsonField.of(limit))

            /**
             * Sets [Builder.limit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

            fun page(page: Long) = page(JsonField.of(page))

            /**
             * Sets [Builder.page] to an arbitrary JSON value.
             *
             * You should usually call [Builder.page] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun page(page: JsonField<Long>) = apply { this.page = page }

            fun total(total: Long) = total(JsonField.of(total))

            /**
             * Sets [Builder.total] to an arbitrary JSON value.
             *
             * You should usually call [Builder.total] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun total(total: JsonField<Long>) = apply { this.total = total }

            fun totalPages(totalPages: Long) = totalPages(JsonField.of(totalPages))

            /**
             * Sets [Builder.totalPages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalPages] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalPages(totalPages: JsonField<Long>) = apply { this.totalPages = totalPages }

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
             * Returns an immutable instance of [Pagination].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .hasPrevPage()
             * .limit()
             * .page()
             * .total()
             * .totalPages()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Pagination =
                Pagination(
                    checkRequired("hasNextPage", hasNextPage),
                    checkRequired("hasPrevPage", hasPrevPage),
                    checkRequired("limit", limit),
                    checkRequired("page", page),
                    checkRequired("total", total),
                    checkRequired("totalPages", totalPages),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Pagination = apply {
            if (validated) {
                return@apply
            }

            hasNextPage()
            hasPrevPage()
            limit()
            page()
            total()
            totalPages()
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
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
                (if (hasPrevPage.asKnown().isPresent) 1 else 0) +
                (if (limit.asKnown().isPresent) 1 else 0) +
                (if (page.asKnown().isPresent) 1 else 0) +
                (if (total.asKnown().isPresent) 1 else 0) +
                (if (totalPages.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Pagination &&
                hasNextPage == other.hasNextPage &&
                hasPrevPage == other.hasPrevPage &&
                limit == other.limit &&
                page == other.page &&
                total == other.total &&
                totalPages == other.totalPages &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                hasNextPage,
                hasPrevPage,
                limit,
                page,
                total,
                totalPages,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Pagination{hasNextPage=$hasNextPage, hasPrevPage=$hasPrevPage, limit=$limit, page=$page, total=$total, totalPages=$totalPages, additionalProperties=$additionalProperties}"
    }

    class Trace
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val _id: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val data: JsonValue,
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
            @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
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
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun _id(): String = _id.getRequired("_id")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun organizationId(): String = organizationId.getRequired("organizationId")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): String = type.getRequired("type")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun userId(): String = userId.getRequired("userId")

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

            /**
             * Returns a mutable builder for constructing an instance of [Trace].
             *
             * The following fields are required:
             * ```java
             * ._id()
             * .createdAt()
             * .data()
             * .organizationId()
             * .type()
             * .updatedAt()
             * .userId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Trace]. */
        class Builder internal constructor() {

            private var _id: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var data: JsonValue? = null
            private var organizationId: JsonField<String>? = null
            private var type: JsonField<String>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var userId: JsonField<String>? = null
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

            fun data(data: JsonValue) = apply { this.data = data }

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
             *
             * The following fields are required:
             * ```java
             * ._id()
             * .createdAt()
             * .data()
             * .organizationId()
             * .type()
             * .updatedAt()
             * .userId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Trace =
                Trace(
                    checkRequired("_id", _id),
                    checkRequired("createdAt", createdAt),
                    checkRequired("data", data),
                    checkRequired("organizationId", organizationId),
                    checkRequired("type", type),
                    checkRequired("updatedAt", updatedAt),
                    checkRequired("userId", userId),
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
                (if (organizationId.asKnown().isPresent) 1 else 0) +
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

        return other is TraceListResponse &&
            pagination == other.pagination &&
            traces == other.traces &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(pagination, traces, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TraceListResponse{pagination=$pagination, traces=$traces, additionalProperties=$additionalProperties}"
}
