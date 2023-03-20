package iot.explorer.data

expect class MqttReceiver constructor() {
    fun connect(
        url: String = "tcp://192.168.3.156",
        onMessage: (String) -> Unit,
        onError: (String) -> Unit
    )
}