package iot.explorer.data

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

actual class MqttReceiver actual constructor() {
    private lateinit var client: MqttClient

    // mqtt-client subscribe --host=mqtt.kopcek.lan --topic=/home/#
    actual fun connect(
        url: String,
        onMessage: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        val persistence =  MemoryPersistence()
        client = MqttClient(url, "test", persistence)
        client.connect()

        client.subscribe("sensor/btemp", 0)
        client.setCallback(object : MqttCallback {
            override fun messageArrived(topic: String?, message: MqttMessage?) {
                try {
                    onMessage(message.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun connectionLost(cause: Throwable?) {
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
            }
        })
    }

    fun disconnect() {
        client.disconnect()
    }
}