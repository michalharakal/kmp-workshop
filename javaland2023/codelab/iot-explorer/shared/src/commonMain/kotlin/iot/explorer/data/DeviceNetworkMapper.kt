package iot.explorer.data

class DeviceNetworkMapper {
    fun toDomain(strValue: String): Float {
        // get regular expression reading temperature from the string sent by B: temp=17
        val regex = Regex("temp=(\\d+)")
        regex.find(strValue)?.groupValues?.get(1)?.toFloat()?.let {
            return it
        }

        return 0f
    }
}