package iot.explorer

class JvmPlatform : Platform {
    override val name: String = "Desktop JVM"
}

actual fun getPlatform(): Platform = JvmPlatform()