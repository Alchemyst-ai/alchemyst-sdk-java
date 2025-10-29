plugins {
    id("alchemyst-ai.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":alchemyst-ai-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :alchemyst-ai-java-example:run` to run `Main`
    // Use `./gradlew :alchemyst-ai-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.alchemyst_ai_sdk.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
