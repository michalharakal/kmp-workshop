package iot.explorer.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual open class CommonViewModel actual constructor() {
    actual val clientScope: CoroutineScope = MainScope()

    protected actual open fun onCleared() {
    }
}
