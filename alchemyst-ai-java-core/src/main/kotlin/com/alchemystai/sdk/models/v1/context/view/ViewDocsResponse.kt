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
import kotlin.jvm.optionals.getOrNull

class ViewDocsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val documents: JsonField<List<Document>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("documents")
        @ExcludeMissing
        documents: JsonField<List<Document>> = JsonMissing.of()
    ) : this(documents, mutableMapOf())

    /**
     * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun documents(): List<Document> = documents.getRequired("documents")

    /**
     * Returns the raw JSON value of [documents].
     *
     * Unlike [documents], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("documents")
    @ExcludeMissing
    fun _documents(): JsonField<List<Document>> = documents

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
         * Returns a mutable builder for constructing an instance of [ViewDocsResponse].
         *
         * The following fields are required:
         * ```java
         * .documents()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ViewDocsResponse]. */
    class Builder internal constructor() {

        private var documents: JsonField<MutableList<Document>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(viewDocsResponse: ViewDocsResponse) = apply {
            documents = viewDocsResponse.documents.map { it.toMutableList() }
            additionalProperties = viewDocsResponse.additionalProperties.toMutableMap()
        }

        fun documents(documents: List<Document>) = documents(JsonField.of(documents))

        /**
         * Sets [Builder.documents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.documents] with a well-typed `List<Document>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun documents(documents: JsonField<List<Document>>) = apply {
            this.documents = documents.map { it.toMutableList() }
        }

        /**
         * Adds a single [Document] to [documents].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDocument(document: Document) = apply {
            documents =
                (documents ?: JsonField.of(mutableListOf())).also {
                    checkKnown("documents", it).add(document)
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
         * Returns an immutable instance of [ViewDocsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .documents()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ViewDocsResponse =
            ViewDocsResponse(
                checkRequired("documents", documents).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ViewDocsResponse = apply {
        if (validated) {
            return@apply
        }

        documents().forEach { it.validate() }
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
        (documents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Document
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
         * Name of the file
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileName(): String = fileName.getRequired("fileName")

        /**
         * Size of the file in bytes
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileSize(): Double = fileSize.getRequired("fileSize")

        /**
         * Type/MIME of the file
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileType(): String = fileType.getRequired("fileType")

        /**
         * Array of group names to which the file belongs
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun groupName(): List<String> = groupName.getRequired("groupName")

        /**
         * Last modified timestamp (ISO format)
         *
         * @throws AlchemystAiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lastModified(): String = lastModified.getRequired("lastModified")

        /**
         * Returns the raw JSON value of [fileName].
         *
         * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fileName") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

        /**
         * Returns the raw JSON value of [fileSize].
         *
         * Unlike [fileSize], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fileSize") @ExcludeMissing fun _fileSize(): JsonField<Double> = fileSize

        /**
         * Returns the raw JSON value of [fileType].
         *
         * Unlike [fileType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fileType") @ExcludeMissing fun _fileType(): JsonField<String> = fileType

        /**
         * Returns the raw JSON value of [groupName].
         *
         * Unlike [groupName], this method doesn't throw if the JSON field has an unexpected type.
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

            /**
             * Returns a mutable builder for constructing an instance of [Document].
             *
             * The following fields are required:
             * ```java
             * .fileName()
             * .fileSize()
             * .fileType()
             * .groupName()
             * .lastModified()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Document]. */
        class Builder internal constructor() {

            private var fileName: JsonField<String>? = null
            private var fileSize: JsonField<Double>? = null
            private var fileType: JsonField<String>? = null
            private var groupName: JsonField<MutableList<String>>? = null
            private var lastModified: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(document: Document) = apply {
                fileName = document.fileName
                fileSize = document.fileSize
                fileType = document.fileType
                groupName = document.groupName.map { it.toMutableList() }
                lastModified = document.lastModified
                additionalProperties = document.additionalProperties.toMutableMap()
            }

            /** Name of the file */
            fun fileName(fileName: String) = fileName(JsonField.of(fileName))

            /**
             * Sets [Builder.fileName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

            /** Size of the file in bytes */
            fun fileSize(fileSize: Double) = fileSize(JsonField.of(fileSize))

            /**
             * Sets [Builder.fileSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileSize] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileSize(fileSize: JsonField<Double>) = apply { this.fileSize = fileSize }

            /** Type/MIME of the file */
            fun fileType(fileType: String) = fileType(JsonField.of(fileType))

            /**
             * Sets [Builder.fileType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileType(fileType: JsonField<String>) = apply { this.fileType = fileType }

            /** Array of group names to which the file belongs */
            fun groupName(groupName: List<String>) = groupName(JsonField.of(groupName))

            /**
             * Sets [Builder.groupName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.groupName] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /** Last modified timestamp (ISO format) */
            fun lastModified(lastModified: String) = lastModified(JsonField.of(lastModified))

            /**
             * Sets [Builder.lastModified] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lastModified] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Document].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .fileName()
             * .fileSize()
             * .fileType()
             * .groupName()
             * .lastModified()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Document =
                Document(
                    checkRequired("fileName", fileName),
                    checkRequired("fileSize", fileSize),
                    checkRequired("fileType", fileType),
                    checkRequired("groupName", groupName).map { it.toImmutable() },
                    checkRequired("lastModified", lastModified),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Document = apply {
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

            return other is Document &&
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
            "Document{fileName=$fileName, fileSize=$fileSize, fileType=$fileType, groupName=$groupName, lastModified=$lastModified, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ViewDocsResponse &&
            documents == other.documents &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(documents, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ViewDocsResponse{documents=$documents, additionalProperties=$additionalProperties}"
}
