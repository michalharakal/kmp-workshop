package iot.explorer.data

expect class MqttReceiver constructor() {
    fun connect(
        url: String = "tcp://mqtt.kopcek.lan",
        onMessage: (String) -> Unit,
        onError: (String) -> Unit
    )
}