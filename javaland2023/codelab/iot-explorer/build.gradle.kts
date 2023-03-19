buildscript {
    val kotlinVersion: String by project
    println(kotlinVersion)

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(uri("https://plugins.gradle.org/m2/")) // For kotlinter-gradle
    }

    dependencies {
        // keeping this here to allow AS to automatically update
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")
        classpath("com.vanniktech:gradle-dependency-graph-generator-plugin:0.8.0")
        classpath("app.cash.molecule:molecule-gradle-plugin:0.7.0")

        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.8.0-1.0.8")
        classpath("com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin:1.0.0-ALPHA-4")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
