plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "0.0.0-web-dev-12"
}

// Enable JS(IR) target and add dependencies
kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }
  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(project(":common"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
      }
    }
    val jsMain by getting {
      dependencies {
        implementation(compose.web.web)
        implementation(compose.runtime)
      }
    }
  }
}