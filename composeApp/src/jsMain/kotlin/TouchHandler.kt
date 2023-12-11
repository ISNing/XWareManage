import org.w3c.dom.TouchEvent
import org.w3c.dom.events.EventTarget
import org.w3c.dom.events.WheelEvent
import org.w3c.dom.events.WheelEventInit
import org.w3c.dom.get

val scrollEventParams = WheelEventInit()
const val scrollFactor = 2
var lastTouchY = 0
fun touchStartHandler(event: TouchEvent) {
    lastTouchY = event.touches[0]?.clientY as Int
    scrollEventParams.clientX = event.touches[0]?.clientX
    scrollEventParams.clientY = event.touches[0]?.clientY
    scrollEventParams.screenX = event.touches[0]?.screenX
    scrollEventParams.screenY = event.touches[0]?.screenY
}

fun touchMoveHandler(event: TouchEvent) {
    var deltaY = lastTouchY - event.touches[0]?.clientY!!
    deltaY *= scrollFactor
    scrollEventParams.deltaX = 0.toDouble()
    scrollEventParams.deltaY = deltaY.toDouble()
    scrollEventParams.deltaMode = 0
    val scrollEvent = WheelEvent("wheel", scrollEventParams)

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