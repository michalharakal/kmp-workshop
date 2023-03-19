import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import iot.explorer.presentation.DeviceViewModel
import iot.explorer.ui.DeviceView
import kotlinx.cinterop.*
import platform.UIKit.*
import platform.Foundation.*


fun main() {
    val args = emptyArray<String>()
    memScoped {
        val argc = args.size + 1
        val argv = (arrayOf("skikoApp") + args).map { it.cstr.ptr }.toCValues()
        autoreleasepool {
            UIApplicationMain(argc, argv, null, NSStringFromClass(SkikoAppDelegate))
        }
    }
}

class SkikoAppDelegate : UIResponder, UIApplicationDelegateProtocol {
    companion object : UIResponderMeta(), UIApplicationDelegateProtocolMeta

    @ObjCObjectBase.OverrideInit
    constructor() : super()

    private var _window: UIWindow? = null
    override fun window() = _window
    override fun setWindow(window: UIWindow?) {
        _window = window
    }

    override fun application(
        application: UIApplication,
        didFinishLaunchingWithOptions: Map<Any?, *>?
    ): Boolean {

        window = UIWindow(frame = UIScreen.mainScreen.bounds)
        window!!.rootViewController = Application("IoT Explorer") {
            Column {
                // To skip upper part of screen.
                Box(modifier = Modifier.height(48.dp))
                DeviceView(DeviceViewModel())
            }
        }
        window!!.makeKeyAndVisible()
        return true
    }
}

