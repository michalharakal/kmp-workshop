buildscript {
    val kotlin_version by extra("1.5.10")
    repositories {
        // TODO: remove after new build is published
        mavenLocal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    dependencies {
        // __LATEST_COMPOSE_RELEASE_VERSION__
        classpath("com.android.tools.build:gradle:4.0.1")
        // __KOTLIN_COMPOSE_VERSION__
        classpath(kotlin("gradle-plugin", version = "$kotlin_version"))
        classpath(kotlin("serialization", version = "$kotlin_version"))
        classpath("org.jetbrains.compose:compose-gradle-plugin:0.5.0-build225")

        classpath("dev.icerock.moko:network-generator:0.15.0")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
