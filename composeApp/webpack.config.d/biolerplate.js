if (isWasmJsBuild()) {// Only for WasmJs target
    const fs = require("fs");
    const path = require("path");

    const outDir = __dirname + "/kotlin/"
    const projecName = path.basename(__dirname);
    const mjsFile = outDir + projecName + ".mjs"

    config.entry = {
        main: [require('path').resolve(__dirname, "kotlin/load.mjs")]
    };

    config.resolve ?? (config.resolve = {});
    config.resolve.alias ?? (config.resolve.alias = {});
    config.resolve.alias.skia = false;
}