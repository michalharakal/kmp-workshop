plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = "me.miso"
version = "1.0"

repositories {
    google()
}

dependencies {
    implementation(project(":common"))

    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("io.ktor:ktor-client-okhttp:1.5.2")

    implementation("androidx.activity:activity-compose:1.3.0-alpha04")

    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "me.miso.android"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }
}