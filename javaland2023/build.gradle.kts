import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") apply false
    id("java")
}

val dokka_version: String by project

allprojects {

    group = "org.kmp.workshop"

    val language_version: String by project
    tasks.withType(KotlinCompile::class).all {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-Xjsr305=strict",
                "-Xskip-metadata-version-check",
                // need 1.4 support, otherwise there might be problems with Gradle 6.x (it's bundling Kotlin 1.4)
                "-Xsuppress-version-warnings"
            )
            allWarningsAsErrors = true
            languageVersion = language_version
            apiVersion = language_version
            jvmTarget = "1.8"
        }
    }

    repositories {
        mavenCentral()
    }
}
