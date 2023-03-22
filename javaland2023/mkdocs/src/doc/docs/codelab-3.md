# Sharing is caring

You can start directly here by cloning the results from previous
step [codelab 2 Branch](https://github.com/michalharakal/kmp-workshop/tree/javaland2023/codelab-2/javaland2023/codelab/iot-explorer)

## Goal
The main goal of this code lab add codewhich can be shared between supported platform. It can be:

* remote communication
* caching
* busisines logic
* ViewModels

## Notes on software architecture

A well define architecture helps to create componets, which can be shared for various targets.

![alt text](clean_code_data.png)

Blocks in the image are grouped by columns into the following 3 layers:

* data
* domain
* presentation

## Domain

```kotlin
package iot.explorer.domain

data class Device(val name: String, val temperature: Float)
```

## Data - repository

```kotlin
package iot.explorer.data

import iot.explorer.domain.Device
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class ValueModel<T : Any>(initialValue: T) {

    // private data flow
    private val _internalMutableFlow = MutableStateFlow(initialValue)

    // publicly exposed as a flow
    val model: StateFlow<T>
        get() = _internalMutableFlow

    fun setValue(newValue: T) {
        if (newValue != _internalMutableFlow.value) {
            _internalMutableFlow.value = newValue
        }
    }
}

class PlcDeviceRepository {

    private val networkMapper = DeviceNetworkMapper()

    init {
        val mqttReceiver = MqttReceiver { temperature ->
            updateTemperature(networkMapper.toDomain(temperature))
        }.start()
    }

    private inner class TemperatureValueModel : ValueModel<Device>(
        Device("Javaland", 0f)
    )

    private val _device = TemperatureValueModel()
    val device: Flow<Device>
        get() = _device.model

    fun updateTemperature(temperature: Float) {
        _device.setValue(Device(_device.model.value.name, temperature))
    }
}
```

## Remote communication - Mocked MQTT Receiver

```kotlin
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
open class MqttReceiver constructor(val handler: (String) -> Unit) {
    fun start() {
        Timer {
            handler(Random.nextDouble(-20.0, 20.0).toString())
        }.start(1)
    }
}
```

## ViewModel

### Common

```kotlin
expect open class CommonViewModel() {
    val clientScope: CoroutineScope
    protected open fun onCleared()
}
```

**iOS Support**
```kotlin
fun interface Closeable {
    fun close()
}

fun <T> Flow<T>.asCommonFlow(): CFlow<T> = CFlow(this)

fun <T> Flow<T>.wrap(): CFlow<T> = CFlow(this)

class CFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): Closeable {
        val job = Job(/*ConferenceService.coroutineContext[Job]*/)

        onEach {
            block(it)
        }.launchIn(CoroutineScope(Dispatchers.Main + job))

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }
}
````

### Android

```kotlin
actual open class CommonViewModel actual constructor() : ViewModel() {
    actual val clientScope: CoroutineScope = viewModelScope
    actual override fun onCleared() {
        super.onCleared()
    }
}
```

### iOS

```kotlin
actual open class CommonViewModel actual constructor() {
    actual val clientScope: CoroutineScope = MainScope()

    protected actual open fun onCleared() {
    }
}   
```

* Couroutines
* Android Lifecycle for handling in ViewModel

## Result

TBD

If you want check an expected results,
checkout [codelab 3 Branch](https://github.com/michalharakal/kmp-workshop/tree/javaland2023/codelab-3/javaland2023/codelab/iot-explorer)