const scrollEventParams = {};
const scrollFactor = 2;
let lastTouchY = 0;
function touchStartHandler(event) {
    console.error("touchStartHandler");
    console.error(event);
    lastTouchY = event.touches[0].clientY;
    scrollEventParams.clientX = event.touches[0].clientX;
    scrollEventParams.clientY = event.touches[0].clientY;
    scrollEventParams.pageX = event.touches[0].pageX;
    scrollEventParams.pageY = event.touches[0].pageY;
    scrollEventParams.screenX = event.touches[0].screenX;
    scrollEventParams.screenY = event.touches[0].screenY;
}

function touchMoveHandler(event) {
    console.error("touchMoveHandler");
    console.error(event);
    let deltaY = lastTouchY - event.touches[0].clientY;
    deltaY *= scrollFactor;
    scrollEventParams.deltaX = 0;
    scrollEventParams.deltaY = deltaY;
    scrollEventParams.deltaMode = 0;
    const scrollEvent = new WheelEvent("wheel", scrollEventParams);
    console.error("scrollEvent");
    console.error(scrollEvent);

    event.target.dispatchEvent(scrollEvent);

    lastTouchY = event.touches[0].clientY;

    event.preventDefault();
}

function initTouchHandler(element) {
    window.addEventListener("scroll", (event) => {
        console.error("scroll Comon");
        console.error(event);
    })
    element.addEventListener("touchstart", touchStartHandler, { passive: false });
    element.addEventListener("touchmove", touchMoveHandler, { passive: false });
}