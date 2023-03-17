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
    private inner class TemperatureValueModel : ValueModel<Device>(
        Device("Javaland", 0f)
    )

    private val _temperature = TemperatureValueModel()
    val temperature: Flow<Device>
        get() = _temperature.model
}
