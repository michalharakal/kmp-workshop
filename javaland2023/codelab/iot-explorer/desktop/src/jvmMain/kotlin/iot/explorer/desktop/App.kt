package iot.explorer.desktop

import androidx.compose.runtime.Composable
import iot.explorer.ui.DeviceView
import iot.explorer.presentation.DeviceViewModel

@Composable
fun App() {
    DeviceView(DeviceViewModel())
}
