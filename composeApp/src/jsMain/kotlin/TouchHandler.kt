import org.w3c.dom.TouchEvent
import org.w3c.dom.events.EventTarget
import org.w3c.dom.events.WheelEvent
import org.w3c.dom.events.WheelEventInit
import org.w3c.dom.get

val SCROLL_EVENT_PARAMS = WheelEventInit()
const val SCROLL_FACTOR = 2
var lastTouchY = 0
fun touchStartHandler(event: TouchEvent) {
    lastTouchY = event.touches[0]?.clientY as Int
    SCROLL_EVENT_PARAMS.clientX = event.touches[0]?.clientX
    SCROLL_EVENT_PARAMS.clientY = event.touches[0]?.clientY
    SCROLL_EVENT_PARAMS.screenX = event.touches[0]?.screenX
    SCROLL_EVENT_PARAMS.screenY = event.touches[0]?.screenY
}

fun touchMoveHandler(event: TouchEvent) {
    var deltaY = lastTouchY - event.touches[0]?.clientY!!
    deltaY *= SCROLL_FACTOR
    SCROLL_EVENT_PARAMS.deltaX = 0.toDouble()
    SCROLL_EVENT_PARAMS.deltaY = deltaY.toDouble()
    SCROLL_EVENT_PARAMS.deltaMode = 0
    val scrollEvent = WheelEvent("wheel", SCROLL_EVENT_PARAMS)

    event.target?.dispatchEvent(scrollEvent)

    lastTouchY = event.touches[0]?.clientY!!

    event.preventDefault()
}

fun initTouchHandler(element: EventTarget) {
    element.addEventListener(
        "touchstart",
        { event -> touchStartHandler(event.unsafeCast<TouchEvent>()) },
        mapOf("passive" to false)
    )
    element.addEventListener(
        "touchmove",
        { event -> touchMoveHandler(event.unsafeCast<TouchEvent>()) },
        mapOf("passive" to false)
    )
}
