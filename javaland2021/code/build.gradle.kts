buildscript {
    repositories {
        // TODO: remove after new build is published
        mavenLocal()
        google()
        jcenter()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven {
            url = uri("https://dl.bintray.com/icerockdev/plugins")
        }
    }

    dependencies {
        // __LATEST_COMPOSE_RELEASE_VERSION__
        classpath("org.jetbrains.compose:compose-gradle-plugin:0.3.2")
        classpath("com.android.tools.build:gradle:4.0.1")
        // __KOTLIN_COMPOSE_VERSION__
        classpath(kotlin("gradle-plugin", version = "1.4.31"))

        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.31")
        classpath("dev.icerock.moko:network-generator:0.11.0")

    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven {
            url = uri("https://dl.bintray.com/icerockdev/plugins")
        }
    }
}

