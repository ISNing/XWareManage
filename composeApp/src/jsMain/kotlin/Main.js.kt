import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cn.edu.buct.snc.xware.manage.App
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.HTMLCanvasElement

private const val canvasElementId = "ComposeTarget"

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    window.onload = {
        // Initialize touch handler for the canvas element
        initTouchHandler(
            document.getElementById(canvasElementId) as HTMLCanvasElement?
                ?: error("No canvas element found!")
        )
    }
    onWasmReady {
        CanvasBasedWindow("Compose Wow", canvasElementId = canvasElementId) {
            App()
        }
    }
}
