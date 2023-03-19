plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version "1.3.0"
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm { compilations.all { kotlinOptions.jvmTarget = "11" } }

    iosX64()
    iosArm64()
    iosSimulatorArm64()


    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(project(":shared"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
    }
}

android {
    namespace = "iot.explorer.ui"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}