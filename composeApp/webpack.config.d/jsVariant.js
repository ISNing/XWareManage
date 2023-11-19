function jsVariant() {
    const fs = require("fs");
    const path = require("path");

    const outDir = __dirname + "/kotlin/"
    const projecName = path.basename(__dirname);
    const jsVariant = outDir + "JSVARIANT"

    return fs.readFileSync(jsVariant).toString().toUpperCase();
}

function isWasmJsBuild() {
    return jsVariant() == "WASM_JS";
}

function isJsBuild() {
    return jsVariant() == "JS";
}