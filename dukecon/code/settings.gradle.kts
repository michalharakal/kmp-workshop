pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
include(":android")
include(":desktop")
include(":web")
include(":common")
include(":common-ui")

