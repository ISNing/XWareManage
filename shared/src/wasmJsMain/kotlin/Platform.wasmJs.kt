

class WasmJsPlatform : Platform {
    override val name: String = "Wasm JS"
}

actual fun getPlatform(): Platform = WasmJsPlatform()