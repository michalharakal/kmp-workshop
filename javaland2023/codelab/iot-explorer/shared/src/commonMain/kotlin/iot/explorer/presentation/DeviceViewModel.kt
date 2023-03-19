package iot.explorer.presentation

import iot.explorer.data.MqttReceiver
import iot.explorer.data.PlcDeviceRepository
import iot.explorer.domain.Device
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class DevicePresentationModel(val label: String = "", val temperature: String = "")

class DeviceViewModel : CommonViewModel() {

    private val repository = PlcDeviceRepository()

    private val _state = MutableStateFlow(DevicePresentationModel())
    val state: StateFlow<DevicePresentationModel>
        get() = _state

    init {
        clientScope.launch {
            repository.device.collect { temperature ->
                _state.value = mapToViewData(temperature)
            }
        }
    }

    private fun mapToViewData(homePresenter: Device): DevicePresentationModel =
        DevicePresentationModel(
            label = homePresenter.name,
            temperature = temperatureFormatter(homePresenter.temperature)
        )

    private fun temperatureFormatter(temperature: Float): String = "${temperature}°C"
}