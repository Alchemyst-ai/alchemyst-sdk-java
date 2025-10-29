plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Alchemyst AI API v1 documentation")
                description.set("v1 API documentation for Alchemyst AI")
                url.set("https://docs.getalchemystai.com")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Alchemyst AI")
                        email.set("anuran@getalchemystai.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Alchemyst-ai/alchemyst-sdk-java.git")
                    developerConnection.set("scm:git:git://github.com/Alchemyst-ai/alchemyst-sdk-java.git")
                    url.set("https://github.com/Alchemyst-ai/alchemyst-sdk-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
