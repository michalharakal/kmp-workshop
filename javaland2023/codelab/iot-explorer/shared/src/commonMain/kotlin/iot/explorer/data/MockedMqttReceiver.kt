package iot.explorer.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class Timer(private val updateInterface: () -> Unit) {
    private var timer: Job? = null

    fun start(seconds: Int) {
        val callback = updateInterface
        timer = CoroutineScope(EmptyCoroutineContext).launch {
            while (true) {
                callback()
                delay(seconds * 1000L)
            }
        }
    }

    fun stop() {
        timer?.cancel()
    }
}

// Mocked MQTT Receiver sending a new value every second
open class MockedqttReceiver constructor(val handler: (String) -> Unit) {
    fun start() {
        Timer {
            handler(Random.nextDouble(-20.0, 20.0).toString())
        }.start(1)
    }
}