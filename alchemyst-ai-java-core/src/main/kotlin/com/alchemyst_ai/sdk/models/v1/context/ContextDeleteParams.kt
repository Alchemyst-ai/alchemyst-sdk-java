// File generated from our OpenAPI spec by Stainless.

package com.alchemyst_ai.sdk.models.v1.context

import com.alchemyst_ai.sdk.core.ExcludeMissing
import com.alchemyst_ai.sdk.core.JsonField
import com.alchemyst_ai.sdk.core.JsonMissing
import com.alchemyst_ai.sdk.core.JsonValue
import com.alchemyst_ai.sdk.core.Params
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

/** Deletes context data based on provided parameters */
class ContextDeleteParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Flag to delete by document
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun byDoc(): Optional<Boolean> = body.byDoc()

    /**
     * Flag to delete by ID
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun byId(): Optional<Boolean> = body.byId()

    /**
     * Optional organization ID
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = body.organizationId()

    /**
     * Source identifier for the context
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun source(): Optional<String> = body.source()

    /**
     * Optional user ID
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userId(): Optional<String> = body.userId()

    /**
     * Returns the raw JSON value of [byDoc].
     *
     * Unlike [byDoc], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _byDoc(): JsonField<Boolean> = body._byDoc()

    /**
     * Returns the raw JSON value of [byId].
     *
     * Unlike [byId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _byId(): JsonField<Boolean> = body._byId()

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _organizationId(): JsonField<String> = body._organizationId()

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _source(): JsonField<String> = body._source()

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

        @JvmStatic fun none(): ContextDeleteParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ContextDeleteParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContextDeleteParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(contextDeleteParams: ContextDeleteParams) = apply {
            body = contextDeleteParams.body.toBuilder()
            additionalHeaders = contextDeleteParams.additionalHeaders.toBuilder()
            additionalQueryParams = contextDeleteParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [byDoc]
         * - [byId]
         * - [organizationId]
         * - [source]
         * - [userId]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Flag to delete by document */
        fun byDoc(byDoc: Boolean?) = apply { body.byDoc(byDoc) }

        /**
         * Alias for [Builder.byDoc].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun byDoc(byDoc: Boolean) = byDoc(byDoc as Boolean?)

        /** Alias for calling [Builder.byDoc] with `byDoc.orElse(null)`. */
        fun byDoc(byDoc: Optional<Boolean>) = byDoc(byDoc.getOrNull())

        /**
         * Sets [Builder.byDoc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.byDoc] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun byDoc(byDoc: JsonField<Boolean>) = apply { body.byDoc(byDoc) }

        /** Flag to delete by ID */
        fun byId(byId: Boolean?) = apply { body.byId(byId) }

        /**
         * Alias for [Builder.byId].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun byId(byId: Boolean) = byId(byId as Boolean?)

        /** Alias for calling [Builder.byId] with `byId.orElse(null)`. */
        fun byId(byId: Optional<Boolean>) = byId(byId.getOrNull())

        /**
         * Sets [Builder.byId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.byId] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun byId(byId: JsonField<Boolean>) = apply { body.byId(byId) }

        /** Optional organization ID */
        fun organizationId(organizationId: String?) = apply { body.organizationId(organizationId) }

        /** Alias for calling [Builder.organizationId] with `organizationId.orElse(null)`. */
        fun organizationId(organizationId: Optional<String>) =
            organizationId(organizationId.getOrNull())

        /**
         * Sets [Builder.organizationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun organizationId(organizationId: JsonField<String>) = apply {
            body.organizationId(organizationId)
        }

        /** Source identifier for the context */
        fun source(source: String) = apply { body.source(source) }

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { body.source(source) }

        /** Optional user ID */
        fun userId(userId: String?) = apply { body.userId(userId) }

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

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
         * Returns an immutable instance of [ContextDeleteParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContextDeleteParams =
            ContextDeleteParams(
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
        private val byDoc: JsonField<Boolean>,
        private val byId: JsonField<Boolean>,
        private val organizationId: JsonField<String>,
        private val source: JsonField<String>,
        private val userId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("by_doc") @ExcludeMissing byDoc: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("by_id") @ExcludeMissing byId: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("organization_id")
            @ExcludeMissing
            organizationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_id") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
        ) : this(byDoc, byId, organizationId, source, userId, mutableMapOf())

        /**
         * Flag to delete by document
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun byDoc(): Optional<Boolean> = byDoc.getOptional("by_doc")

        /**
         * Flag to delete by ID
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun byId(): Optional<Boolean> = byId.getOptional("by_id")

        /**
         * Optional organization ID
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun organizationId(): Optional<String> = organizationId.getOptional("organization_id")

        /**
         * Source identifier for the context
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun source(): Optional<String> = source.getOptional("source")

        /**
         * Optional user ID
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userId(): Optional<String> = userId.getOptional("user_id")

        /**
         * Returns the raw JSON value of [byDoc].
         *
         * Unlike [byDoc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("by_doc") @ExcludeMissing fun _byDoc(): JsonField<Boolean> = byDoc

        /**
         * Returns the raw JSON value of [byId].
         *
         * Unlike [byId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("by_id") @ExcludeMissing fun _byId(): JsonField<Boolean> = byId

        /**
         * Returns the raw JSON value of [organizationId].
         *
         * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("organization_id")
        @ExcludeMissing
        fun _organizationId(): JsonField<String> = organizationId

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var byDoc: JsonField<Boolean> = JsonMissing.of()
            private var byId: JsonField<Boolean> = JsonMissing.of()
            private var organizationId: JsonField<String> = JsonMissing.of()
            private var source: JsonField<String> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                byDoc = body.byDoc
                byId = body.byId
                organizationId = body.organizationId
                source = body.source
                userId = body.userId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Flag to delete by document */
            fun byDoc(byDoc: Boolean?) = byDoc(JsonField.ofNullable(byDoc))

            /**
             * Alias for [Builder.byDoc].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun byDoc(byDoc: Boolean) = byDoc(byDoc as Boolean?)

            /** Alias for calling [Builder.byDoc] with `byDoc.orElse(null)`. */
            fun byDoc(byDoc: Optional<Boolean>) = byDoc(byDoc.getOrNull())

            /**
             * Sets [Builder.byDoc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byDoc] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun byDoc(byDoc: JsonField<Boolean>) = apply { this.byDoc = byDoc }

            /** Flag to delete by ID */
            fun byId(byId: Boolean?) = byId(JsonField.ofNullable(byId))

            /**
             * Alias for [Builder.byId].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun byId(byId: Boolean) = byId(byId as Boolean?)

            /** Alias for calling [Builder.byId] with `byId.orElse(null)`. */
            fun byId(byId: Optional<Boolean>) = byId(byId.getOrNull())

            /**
             * Sets [Builder.byId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byId] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun byId(byId: JsonField<Boolean>) = apply { this.byId = byId }

            /** Optional organization ID */
            fun organizationId(organizationId: String?) =
                organizationId(JsonField.ofNullable(organizationId))

            /** Alias for calling [Builder.organizationId] with `organizationId.orElse(null)`. */
            fun organizationId(organizationId: Optional<String>) =
                organizationId(organizationId.getOrNull())

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

            /** Source identifier for the context */
            fun source(source: String) = source(JsonField.of(source))

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<String>) = apply { this.source = source }

            /** Optional user ID */
            fun userId(userId: String?) = userId(JsonField.ofNullable(userId))

            /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
            fun userId(userId: Optional<String>) = userId(userId.getOrNull())

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
             */
            fun build(): Body =
                Body(
                    byDoc,
                    byId,
                    organizationId,
                    source,
                    userId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            byDoc()
            byId()
            organizationId()
            source()
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
            (if (byDoc.asKnown().isPresent) 1 else 0) +
                (if (byId.asKnown().isPresent) 1 else 0) +
                (if (organizationId.asKnown().isPresent) 1 else 0) +
                (if (source.asKnown().isPresent) 1 else 0) +
                (if (userId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                byDoc == other.byDoc &&
                byId == other.byId &&
                organizationId == other.organizationId &&
                source == other.source &&
                userId == other.userId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byDoc, byId, organizationId, source, userId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{byDoc=$byDoc, byId=$byId, organizationId=$organizationId, source=$source, userId=$userId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContextDeleteParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ContextDeleteParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
