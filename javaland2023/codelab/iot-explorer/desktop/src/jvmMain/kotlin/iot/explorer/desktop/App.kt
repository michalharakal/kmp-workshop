package iot.explorer.desktop

import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import iot.explorer.getPlatform

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, JavaLand 2023!") }
    val platformName = getPlatform().name

    Button(onClick = {
        text = "Hello, $platformName"
    }) {
        Text(text)
    }
}
