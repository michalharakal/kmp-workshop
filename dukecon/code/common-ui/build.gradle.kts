import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version "0.4.0-build182"
    id("maven-publish")
}

group = "org.dukecon.common.ui"
version = "0.0.1"

kotlin {
    android(){
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                implementation(project(":common"))

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2-native-mt") {
                    version {
                        strictly("1.4.3")
                    }
                }
                implementation("io.ktor:ktor-utils:1.5.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")

                implementation("io.ktor:ktor-client-core:1.5.4")
                implementation("io.ktor:ktor-client-json:1.5.2")
                implementation("io.ktor:ktor-client-logging:1.5.2")
                implementation("io.ktor:ktor-client-serialization:1.5.2")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.3.0")
                api("androidx.core:core-ktx:1.5.0")
                implementation("io.ktor:ktor-client-okhttp:1.5.2")

                val lifecycleVersion = "2.2.0"
                implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-apache:1.5.2")
            }
        }
        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.3")
                implementation("junit:junit:4.13.2")
                implementation("io.mockk:mockk:1.11.0")
            }
        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}
