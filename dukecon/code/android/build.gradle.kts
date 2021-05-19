plugins {
    id("org.jetbrains.compose") version "0.4.0-build182"
    id("com.android.application")
    kotlin("android")
}

group = "me.miso"
version = "1.0"

dependencies {
    implementation(project(":common"))
    implementation(project(":common-ui"))


    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("io.ktor:ktor-client-okhttp:1.5.2")

    implementation("androidx.activity:activity-compose:1.3.0-alpha08")

    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.appcompat:appcompat:1.3.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        pickFirst("META-INF/DEPENDENCIES")
        // exclude "META-INF/DEPENDENCIES"
    }
}
