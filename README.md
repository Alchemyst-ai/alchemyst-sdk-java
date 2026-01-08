# Alchemyst AI Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.alchemystai.sdk/alchemyst-ai-java)](https://central.sonatype.com/artifact/com.alchemystai.sdk/alchemyst-ai-java/0.0.1)
[![javadoc](https://javadoc.io/badge2/com.alchemystai.sdk/alchemyst-ai-java/0.0.1/javadoc.svg)](https://javadoc.io/doc/com.alchemystai.sdk/alchemyst-ai-java/0.0.1)

<!-- x-release-please-end -->

The Alchemyst AI Java SDK provides convenient access to the [Alchemyst AI REST API](https://getalchemystai.com/docs) from applications written in Java.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [getalchemystai.com](https://getalchemystai.com/docs). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.alchemystai.sdk/alchemyst-ai-java/0.0.1).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.alchemystai.sdk:alchemyst-ai-java:0.0.1")
```

### Maven

```xml
<dependency>
  <groupId>com.alchemystai.sdk</groupId>
  <artifactId>alchemyst-ai-java</artifactId>
  <version>0.0.1</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;

// Configures using the `alchemystai.apiKey` and `alchemystai.baseUrl` system properties
// Or configures using the `ALCHEMYST_AI_API_KEY` and `ALCHEMYST_AI_BASE_URL` environment variables
AlchemystAiClient client = AlchemystAiOkHttpClient.fromEnv();

ContextAddParams params = ContextAddParams.builder()
    .contextType(ContextAddParams.ContextType.RESOURCE)
    .addDocument(ContextAddParams.Document.builder()
        .content("The content of the document")
        .build())
    .scope(ContextAddParams.Scope.INTERNAL)
    .source("platform.api.context.add")
    .metadata(ContextAddParams.Metadata.builder()
        .fileName("notes.txt")
        .fileType("text/plain")
        .lastModified("2025-10-01T18:42:40.419Z")
        .fileSize(1024.0)
        .build())
    .build();
ContextAddResponse response = client.v1().context().add(params);
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;

// Configures using the `alchemystai.apiKey` and `alchemystai.baseUrl` system properties
// Or configures using the `ALCHEMYST_AI_API_KEY` and `ALCHEMYST_AI_BASE_URL` environment variables
AlchemystAiClient client = AlchemystAiOkHttpClient.fromEnv();
```

Or manually:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    // Configures using the `alchemystai.apiKey` and `alchemystai.baseUrl` system properties
    // Or configures using the `ALCHEMYST_AI_API_KEY` and `ALCHEMYST_AI_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter    | System property       | Environment variable    | Required | Default value                                   |
| --------- | --------------------- | ----------------------- | -------- | ----------------------------------------------- |
| `apiKey`  | `alchemystai.apiKey`  | `ALCHEMYST_AI_API_KEY`  | false    | -                                               |
| `baseUrl` | `alchemystai.baseUrl` | `ALCHEMYST_AI_BASE_URL` | true     | `"https://platform-backend.getalchemystai.com"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;

AlchemystAiClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Alchemyst AI API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.v1().context().add(...)` should be called with an instance of `ContextAddParams`, and it will return an instance of `ContextAddResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `alchemystai.apiKey` and `alchemystai.baseUrl` system properties
// Or configures using the `ALCHEMYST_AI_API_KEY` and `ALCHEMYST_AI_BASE_URL` environment variables
AlchemystAiClient client = AlchemystAiOkHttpClient.fromEnv();

ContextAddParams params = ContextAddParams.builder()
    .contextType(ContextAddParams.ContextType.RESOURCE)
    .addDocument(ContextAddParams.Document.builder()
        .content("The content of the document")
        .build())
    .scope(ContextAddParams.Scope.INTERNAL)
    .source("platform.api.context.add")
    .metadata(ContextAddParams.Metadata.builder()
        .fileName("notes.txt")
        .fileType("text/plain")
        .lastModified("2025-10-01T18:42:40.419Z")
        .fileSize(1024.0)
        .build())
    .build();
CompletableFuture<ContextAddResponse> response = client.async().v1().context().add(params);
```

Or create an asynchronous client from the beginning:

```java
import com.alchemystai.sdk.client.AlchemystAiClientAsync;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClientAsync;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `alchemystai.apiKey` and `alchemystai.baseUrl` system properties
// Or configures using the `ALCHEMYST_AI_API_KEY` and `ALCHEMYST_AI_BASE_URL` environment variables
AlchemystAiClientAsync client = AlchemystAiOkHttpClientAsync.fromEnv();

ContextAddParams params = ContextAddParams.builder()
    .contextType(ContextAddParams.ContextType.RESOURCE)
    .addDocument(ContextAddParams.Document.builder()
        .content("The content of the document")
        .build())
    .scope(ContextAddParams.Scope.INTERNAL)
    .source("platform.api.context.add")
    .metadata(ContextAddParams.Metadata.builder()
        .fileName("notes.txt")
        .fileType("text/plain")
        .lastModified("2025-10-01T18:42:40.419Z")
        .fileSize(1024.0)
        .build())
    .build();
CompletableFuture<ContextAddResponse> response = client.v1().context().add(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.alchemystai.sdk.core.http.Headers;
import com.alchemystai.sdk.core.http.HttpResponseFor;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;

ContextAddParams params = ContextAddParams.builder()
    .contextType(ContextAddParams.ContextType.RESOURCE)
    .addDocument(ContextAddParams.Document.builder()
        .content("The content of the document")
        .build())
    .scope(ContextAddParams.Scope.INTERNAL)
    .source("platform.api.context.add")
    .metadata(ContextAddParams.Metadata.builder()
        .fileName("notes.txt")
        .fileType("text/plain")
        .lastModified("2025-10-01T18:42:40.419Z")
        .fileSize(1024.0)
        .build())
    .build();
HttpResponseFor<ContextAddResponse> response = client.v1().context().withRawResponse().add(params);

int statusCode = response.statusCode();
Headers headers = response.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;

ContextAddResponse parsedResponse = response.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`AlchemystAiServiceException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/AlchemystAiServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                             |
  | ------ | ------------------------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/UnexpectedStatusCodeException.kt) |

- [`AlchemystAiIoException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/AlchemystAiIoException.kt): I/O networking errors.

- [`AlchemystAiRetryableException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/AlchemystAiRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`AlchemystAiInvalidDataException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/AlchemystAiInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`AlchemystAiException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/AlchemystAiException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `ALCHEMYST_AI_LOG` environment variable to `info`:

```sh
export ALCHEMYST_AI_LOG=info
```

Or to `debug` for more verbose logging:

```sh
export ALCHEMYST_AI_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `alchemyst-ai-java-core` is published with a [configuration file](alchemyst-ai-java-core/src/main/resources/META-INF/proguard/alchemyst-ai-java-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`AlchemystAiOkHttpClient`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClient.kt) or [`AlchemystAiOkHttpClientAsync`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;

ContextAddResponse response = client.v1().context().add(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;
import java.time.Duration;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `alchemyst-ai-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`AlchemystAiClient`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClient.kt), [`AlchemystAiClientAsync`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientAsync.kt), [`AlchemystAiClientImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientImpl.kt), and [`AlchemystAiClientAsyncImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientAsyncImpl.kt), all of which can work with any HTTP client
- `alchemyst-ai-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`AlchemystAiOkHttpClient`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClient.kt) and [`AlchemystAiOkHttpClientAsync`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClientAsync.kt), which provide a way to construct [`AlchemystAiClientImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientImpl.kt) and [`AlchemystAiClientAsyncImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientAsyncImpl.kt), respectively, using OkHttp
- `alchemyst-ai-java`
  - Depends on and exposes the APIs of both `alchemyst-ai-java-core` and `alchemyst-ai-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`alchemyst-ai-java` dependency](#installation) with `alchemyst-ai-java-core`
2. Copy `alchemyst-ai-java-client-okhttp`'s [`OkHttpClient`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`AlchemystAiClientImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientImpl.kt) or [`AlchemystAiClientAsyncImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientAsyncImpl.kt), similarly to [`AlchemystAiOkHttpClient`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClient.kt) or [`AlchemystAiOkHttpClientAsync`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`alchemyst-ai-java` dependency](#installation) with `alchemyst-ai-java-core`
2. Write a class that implements the [`HttpClient`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/core/http/HttpClient.kt) interface
3. Construct [`AlchemystAiClientImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientImpl.kt) or [`AlchemystAiClientAsyncImpl`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/client/AlchemystAiClientAsyncImpl.kt), similarly to [`AlchemystAiOkHttpClient`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClient.kt) or [`AlchemystAiOkHttpClientAsync`](alchemyst-ai-java-client-okhttp/src/main/kotlin/com/alchemystai/sdk/client/okhttp/AlchemystAiOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.alchemystai.sdk.core.JsonValue;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;

ContextAddParams params = ContextAddParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```java
import com.alchemystai.sdk.core.JsonValue;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;

ContextAddParams params = ContextAddParams.builder()
    .metadata(ContextAddParams.Metadata.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build();
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/core/Values.kt) object to its setter:

```java
import com.alchemystai.sdk.core.JsonValue;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;

ContextAddParams params = ContextAddParams.builder()
    .contextType(JsonValue.from(42))
    .addDocument(ContextAddParams.Document.builder()
        .content("The content of the document")
        .build())
    .scope(ContextAddParams.Scope.INTERNAL)
    .source("platform.api.context.add")
    .metadata(ContextAddParams.Metadata.builder()
        .fileName("notes.txt")
        .fileType("text/plain")
        .lastModified("2025-10-01T18:42:40.419Z")
        .fileSize(1024.0)
        .build())
    .build();
```

The most straightforward way to create a [`JsonValue`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/core/Values.kt) is using its `from(...)` method:

```java
import com.alchemystai.sdk.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/core/Values.kt):

```java
import com.alchemystai.sdk.core.JsonMissing;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;

ContextAddParams params = ContextAddParams.builder()
    .addDocument(ContextAddParams.Document.builder().build())
    .scope(ContextAddParams.Scope.INTERNAL)
    .source("support-inbox")
    .contextType(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.alchemystai.sdk.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.v1().context().add(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.alchemystai.sdk.core.JsonField;
import com.alchemystai.sdk.models.v1.context.ContextAddParams;
import java.util.Optional;

JsonField<ContextAddParams.ContextType> contextType = client.v1().context().add(params)._contextType();

if (contextType.isMissing()) {
  // The property is absent from the JSON response
} else if (contextType.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = contextType.asString();

  // Try to deserialize into a custom type
  MyClass myObject = contextType.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`AlchemystAiInvalidDataException`](alchemyst-ai-java-core/src/main/kotlin/com/alchemystai/sdk/errors/AlchemystAiInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;

ContextAddResponse response = client.v1().context().add(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.alchemystai.sdk.models.v1.context.ContextAddResponse;

ContextAddResponse response = client.v1().context().add(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.alchemystai.sdk.client.AlchemystAiClient;
import com.alchemystai.sdk.client.okhttp.AlchemystAiOkHttpClient;

AlchemystAiClient client = AlchemystAiOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/Alchemyst-ai/alchemyst-sdk-java/issues) with questions, bugs, or suggestions.
