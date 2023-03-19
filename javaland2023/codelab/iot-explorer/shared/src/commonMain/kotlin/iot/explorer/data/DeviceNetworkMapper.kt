package iot.explorer.data

class DeviceNetworkMapper {
    fun toDomain(strValue: String): Float {
        return strValue.toFloat()
    }
}