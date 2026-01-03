// File generated from our OpenAPI spec by Stainless.

package com.alchemystai.sdk.models.v1.context.view

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

class ViewRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val contexts: JsonField<List<Context>>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("contexts")
        @ExcludeMissing
        contexts: JsonField<List<Context>> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(contexts, success, mutableMapOf())

    /**
     * List of context items
     *
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contexts(): List<Context> = contexts.getRequired("contexts")

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * Returns the raw JSON value of [contexts].
     *
     * Unlike [contexts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contexts") @ExcludeMissing fun _contexts(): JsonField<List<Context>> = contexts

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
         * Returns a mutable builder for constructing an instance of [ViewRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .contexts()
         * .success()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ViewRetrieveResponse]. */
    class Builder internal constructor() {

        private var contexts: JsonField<MutableList<Context>>? = null
        private var success: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(viewRetrieveResponse: ViewRetrieveResponse) = apply {
            contexts = viewRetrieveResponse.contexts.map { it.toMutableList() }
            success = viewRetrieveResponse.success
            additionalProperties = viewRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** List of context items */
        fun contexts(contexts: List<Context>) = contexts(JsonField.of(contexts))

        /**
         * Sets [Builder.contexts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contexts] with a well-typed `List<Context>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contexts(contexts: JsonField<List<Context>>) = apply {
            this.contexts = contexts.map { it.toMutableList() }
        }

        /**
         * Adds a single [Context] to [contexts].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContext(context: Context) = apply {
            contexts =
                (contexts ?: JsonField.of(mutableListOf())).also {
                    checkKnown("contexts", it).add(context)
                }
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
         * Returns an immutable instance of [ViewRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contexts()
         * .success()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ViewRetrieveResponse =
            ViewRetrieveResponse(
                checkRequired("contexts", contexts).map { it.toImmutable() },
                checkRequired("success", success),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ViewRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        contexts().forEach { it.validate() }
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
        (contexts.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    class Context
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<String>,
        private val metadata: JsonField<Metadata>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
        ) : this(content, metadata, mutableMapOf())

        /**
         * The content of the context item
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun content(): Optional<String> = content.getOptional("content")

        /**
         * Additional metadata for the context
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

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

            /** Returns a mutable builder for constructing an instance of [Context]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Context]. */
        class Builder internal constructor() {

            private var content: JsonField<String> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(context: Context) = apply {
                content = context.content
                metadata = context.metadata
                additionalProperties = context.additionalProperties.toMutableMap()
            }

            /** The content of the context item */
            fun content(content: String) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<String>) = apply { this.content = content }

            /** Additional metadata for the context */
            fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
             * Returns an immutable instance of [Context].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Context = Context(content, metadata, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Context = apply {
            if (validated) {
                return@apply
            }

            content()
            metadata().ifPresent { it.validate() }
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
            (if (content.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0)

        /** Additional metadata for the context */
        class Metadata
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val fileName: JsonField<String>,
            private val fileSize: JsonField<Double>,
            private val fileType: JsonField<String>,
            private val groupName: JsonField<List<String>>,
            private val lastModified: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("fileName")
                @ExcludeMissing
                fileName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("fileSize")
                @ExcludeMissing
                fileSize: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("fileType")
                @ExcludeMissing
                fileType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("groupName")
                @ExcludeMissing
                groupName: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("lastModified")
                @ExcludeMissing
                lastModified: JsonField<String> = JsonMissing.of(),
            ) : this(fileName, fileSize, fileType, groupName, lastModified, mutableMapOf())

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun fileName(): Optional<String> = fileName.getOptional("fileName")

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun fileSize(): Optional<Double> = fileSize.getOptional("fileSize")

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun fileType(): Optional<String> = fileType.getOptional("fileType")

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun groupName(): Optional<List<String>> = groupName.getOptional("groupName")

            /**
             * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun lastModified(): Optional<String> = lastModified.getOptional("lastModified")

            /**
             * Returns the raw JSON value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fileName") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * Returns the raw JSON value of [fileSize].
             *
             * Unlike [fileSize], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fileSize") @ExcludeMissing fun _fileSize(): JsonField<Double> = fileSize

            /**
             * Returns the raw JSON value of [fileType].
             *
             * Unlike [fileType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fileType") @ExcludeMissing fun _fileType(): JsonField<String> = fileType

            /**
             * Returns the raw JSON value of [groupName].
             *
             * Unlike [groupName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("groupName")
            @ExcludeMissing
            fun _groupName(): JsonField<List<String>> = groupName

            /**
             * Returns the raw JSON value of [lastModified].
             *
             * Unlike [lastModified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("lastModified")
            @ExcludeMissing
            fun _lastModified(): JsonField<String> = lastModified

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

                /** Returns a mutable builder for constructing an instance of [Metadata]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Metadata]. */
            class Builder internal constructor() {

                private var fileName: JsonField<String> = JsonMissing.of()
                private var fileSize: JsonField<Double> = JsonMissing.of()
                private var fileType: JsonField<String> = JsonMissing.of()
                private var groupName: JsonField<MutableList<String>>? = null
                private var lastModified: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(metadata: Metadata) = apply {
                    fileName = metadata.fileName
                    fileSize = metadata.fileSize
                    fileType = metadata.fileType
                    groupName = metadata.groupName.map { it.toMutableList() }
                    lastModified = metadata.lastModified
                    additionalProperties = metadata.additionalProperties.toMutableMap()
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

                fun fileSize(fileSize: Double) = fileSize(JsonField.of(fileSize))

                /**
                 * Sets [Builder.fileSize] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileSize] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileSize(fileSize: JsonField<Double>) = apply { this.fileSize = fileSize }

                fun fileType(fileType: String) = fileType(JsonField.of(fileType))

                /**
                 * Sets [Builder.fileType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileType(fileType: JsonField<String>) = apply { this.fileType = fileType }

                fun groupName(groupName: List<String>) = groupName(JsonField.of(groupName))

                /**
                 * Sets [Builder.groupName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.groupName] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun groupName(groupName: JsonField<List<String>>) = apply {
                    this.groupName = groupName.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.groupName].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addGroupName(groupName: String) = apply {
                    this.groupName =
                        (this.groupName ?: JsonField.of(mutableListOf())).also {
                            checkKnown("groupName", it).add(groupName)
                        }
                }

                fun lastModified(lastModified: String) = lastModified(JsonField.of(lastModified))

                /**
                 * Sets [Builder.lastModified] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.lastModified] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun lastModified(lastModified: JsonField<String>) = apply {
                    this.lastModified = lastModified
                }

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
                 * Returns an immutable instance of [Metadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Metadata =
                    Metadata(
                        fileName,
                        fileSize,
                        fileType,
                        (groupName ?: JsonMissing.of()).map { it.toImmutable() },
                        lastModified,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Metadata = apply {
                if (validated) {
                    return@apply
                }

                fileName()
                fileSize()
                fileType()
                groupName()
                lastModified()
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
                    (if (fileSize.asKnown().isPresent) 1 else 0) +
                    (if (fileType.asKnown().isPresent) 1 else 0) +
                    (groupName.asKnown().getOrNull()?.size ?: 0) +
                    (if (lastModified.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Metadata &&
                    fileName == other.fileName &&
                    fileSize == other.fileSize &&
                    fileType == other.fileType &&
                    groupName == other.groupName &&
                    lastModified == other.lastModified &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    fileName,
                    fileSize,
                    fileType,
                    groupName,
                    lastModified,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Metadata{fileName=$fileName, fileSize=$fileSize, fileType=$fileType, groupName=$groupName, lastModified=$lastModified, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Context &&
                content == other.content &&
                metadata == other.metadata &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(content, metadata, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Context{content=$content, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ViewRetrieveResponse &&
            contexts == other.contexts &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(contexts, success, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ViewRetrieveResponse{contexts=$contexts, success=$success, additionalProperties=$additionalProperties}"
}
