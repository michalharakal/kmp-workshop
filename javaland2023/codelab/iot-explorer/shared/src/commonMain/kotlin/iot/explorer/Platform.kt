package iot.explorer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform