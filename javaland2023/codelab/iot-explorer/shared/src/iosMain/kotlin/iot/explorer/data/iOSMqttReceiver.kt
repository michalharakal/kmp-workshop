package iot.explorer.data

actual class MqttReceiver actual constructor() {

    // mqtt-client subscribe --host=mqtt.kopcek.lan --topic=/home/#
    actual fun connect(
        url: String,
        onMessage: (String) -> Unit,
        onError: (String) -> Unit
    ) {

    }
}