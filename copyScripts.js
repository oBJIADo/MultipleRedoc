const fs = require("fs");
if (!fs.existsSync("./build")) {
    fs.mkdirSync("./build")
}
fs.copyFileSync("./installApp.js", "./build/installApp.js");