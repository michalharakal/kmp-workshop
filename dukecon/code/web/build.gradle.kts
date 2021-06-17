plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
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
      }
    }
    val jsMain by getting {
      dependencies {
        implementation(compose.web.widgets)
        implementation(compose.web.core)
        implementation(compose.runtime)
      }
    }
  }
}

compose.desktop {
  application {
    mainClass = ""
  }
}