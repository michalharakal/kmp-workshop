package org.dukecon.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope

actual open class CommonViewModel actual constructor() {
    actual val clientScope: CoroutineScope = GlobalScope

    protected actual open fun onCleared() {
    }
}