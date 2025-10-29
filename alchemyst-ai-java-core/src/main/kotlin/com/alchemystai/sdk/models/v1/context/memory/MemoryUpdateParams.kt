// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.memory

import com.alchemystai.sdk.core.ExcludeMissing
import com.alchemystai.sdk.core.JsonField
import com.alchemystai.sdk.core.JsonMissing
import com.alchemystai.sdk.core.JsonValue
import com.alchemystai.sdk.core.Params
import com.alchemystai.sdk.core.checkKnown
import com.alchemystai.sdk.core.http.Headers
import com.alchemystai.sdk.core.http.QueryParams
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

/** This endpoint updates memory context data. */
class MemoryUpdateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Array of updated content objects
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contents(): Optional<List<Content>> = body.contents()

    /**
     * The ID of the memory to update
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun memoryId(): Optional<String> = body.memoryId()

    /**
     * Returns the raw JSON value of [contents].
     *
     * Unlike [contents], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _contents(): JsonField<List<Content>> = body._contents()

    /**
     * Returns the raw JSON value of [memoryId].
     *
     * Unlike [memoryId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _memoryId(): JsonField<String> = body._memoryId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): MemoryUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [MemoryUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MemoryUpdateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(memoryUpdateParams: MemoryUpdateParams) = apply {
            body = memoryUpdateParams.body.toBuilder()
            additionalHeaders = memoryUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = memoryUpdateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [contents]
         * - [memoryId]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Array of updated content objects */
        fun contents(contents: List<Content>) = apply { body.contents(contents) }

        /**
         * Sets [Builder.contents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contents] with a well-typed `List<Content>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contents(contents: JsonField<List<Content>>) = apply { body.contents(contents) }

        /**
         * Adds a single [Content] to [contents].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContent(content: Content) = apply { body.addContent(content) }

        /** The ID of the memory to update */
        fun memoryId(memoryId: String) = apply { body.memoryId(memoryId) }

        /**
         * Sets [Builder.memoryId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.memoryId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun memoryId(memoryId: JsonField<String>) = apply { body.memoryId(memoryId) }

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
         * Returns an immutable instance of [MemoryUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MemoryUpdateParams =
            MemoryUpdateParams(
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
        private val contents: JsonField<List<Content>>,
        private val memoryId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("contents")
            @ExcludeMissing
            contents: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("memoryId") @ExcludeMissing memoryId: JsonField<String> = JsonMissing.of(),
        ) : this(contents, memoryId, mutableMapOf())

        /**
         * Array of updated content objects
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun contents(): Optional<List<Content>> = contents.getOptional("contents")

        /**
         * The ID of the memory to update
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun memoryId(): Optional<String> = memoryId.getOptional("memoryId")

        /**
         * Returns the raw JSON value of [contents].
         *
         * Unlike [contents], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contents")
        @ExcludeMissing
        fun _contents(): JsonField<List<Content>> = contents

        /**
         * Returns the raw JSON value of [memoryId].
         *
         * Unlike [memoryId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("memoryId") @ExcludeMissing fun _memoryId(): JsonField<String> = memoryId

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

            private var contents: JsonField<MutableList<Content>>? = null
            private var memoryId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                contents = body.contents.map { it.toMutableList() }
                memoryId = body.memoryId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Array of updated content objects */
            fun contents(contents: List<Content>) = contents(JsonField.of(contents))

            /**
             * Sets [Builder.contents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contents] with a well-typed `List<Content>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contents(contents: JsonField<List<Content>>) = apply {
                this.contents = contents.map { it.toMutableList() }
            }

            /**
             * Adds a single [Content] to [contents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContent(content: Content) = apply {
                contents =
                    (contents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("contents", it).add(content)
                    }
            }

            /** The ID of the memory to update */
            fun memoryId(memoryId: String) = memoryId(JsonField.of(memoryId))

            /**
             * Sets [Builder.memoryId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.memoryId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun memoryId(memoryId: JsonField<String>) = apply { this.memoryId = memoryId }

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
                    (contents ?: JsonMissing.of()).map { it.toImmutable() },
                    memoryId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            contents().ifPresent { it.forEach { it.validate() } }
            memoryId()
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
            (contents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (memoryId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                contents == other.contents &&
                memoryId == other.memoryId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(contents, memoryId, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{contents=$contents, memoryId=$memoryId, additionalProperties=$additionalProperties}"
    }

    class Content
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of()
        ) : this(content, mutableMapOf())

        /**
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun content(): Optional<String> = content.getOptional("content")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

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

            /** Returns a mutable builder for constructing an instance of [Content]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Content]. */
        class Builder internal constructor() {

            private var content: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(content: Content) = apply {
                this.content = content.content
                additionalProperties = content.additionalProperties.toMutableMap()
            }

            fun content(content: String) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<String>) = apply { this.content = content }

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
             * Returns an immutable instance of [Content].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Content = Content(content, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Content = apply {
            if (validated) {
                return@apply
            }

            content()
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
        @JvmSynthetic internal fun validity(): Int = (if (content.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Content &&
                content == other.content &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(content, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Content{content=$content, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MemoryUpdateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MemoryUpdateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
