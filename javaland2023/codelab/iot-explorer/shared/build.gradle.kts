plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods") version "1.8.0"
    id("com.android.library")
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

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iOSExplorer/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")
                api("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")
                api("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
                api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
                implementation("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
            }
        }
        val androidUnitTest by getting
        val jvmMain by getting {
            dependencies {
                implementation("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "iot.explorer"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}
