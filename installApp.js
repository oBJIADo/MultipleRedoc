const fs = require("fs");

const magicTwo = 2;

function initFromArg(index, defaultValue) {
    if (process.argv[index + magicTwo])
        return process.argv[index + magicTwo];
    else
        return defaultValue;
}

const requiredTypes = [".yaml", ".yml", ".json"];

const publicDir = initFromArg(0, ".");

const apiFromPath = initFromArg(1, "./api");
const apiDestinationPath = publicDir + "/api";

const propsDestinationPath = publicDir + "/static/js";
const propsFileName = "properties.js";

const imageFromPath = initFromArg(2, "./img");
const imageDestinationPath = publicDir + "/static/img";


function convertFileToProp(files) {
    return "const properties = { apiMap: " + JSON.stringify(files) + "};"
}

function makeFullPath(path) {
    if (!fs.existsSync(path)) {
        let folders = path.split("/");
        let combinedPath = "";
        folders.forEach(value => {
            if (value && value.length > 0)
                if (value === "." || value === "..") {
                    combinedPath += value + "/";
                } else {
                    if (!fs.existsSync(combinedPath + value)) {
                        fs.mkdirSync(combinedPath + value);
                    }
                    combinedPath += value + "/";
                }
        })
    }
}

function mapToObject(inputMap) {
    let obj = [];

    inputMap.forEach((mapValue, mapKey) => {
        obj.push({key: mapKey, value: mapValue})
    });

    return obj;
}

function copyDir(fromDir, toDir, files) {
    if (fromDir === toDir) {
        return;
    }
    if (!fs.existsSync(fromDir)) {
        console.warn("Directory: '" + fromDir + "'","doesn't exist!", "Cannot copy files.");
        return;
    }
    if (fs.readdirSync(fromDir).length === 0) {
        console.warn("Directory: '" + fromDir + "'","is empty!", "Files not copied!");
        return;
    }

    let copiedFiles;
    if (!files) {
        copiedFiles = fs.readdirSync(fromDir);
    } else {
        copiedFiles = files
    }

    makeFullPath(toDir);
    copiedFiles.forEach((value) => {
        fs.copyFileSync(fromDir + "/" + value, toDir + "/" + value);
    });
}

function createProperties(files) {
    const mapAsObject = mapToObject(files);
    makeFullPath(propsDestinationPath);
    fs.writeFileSync(propsDestinationPath + "/" + propsFileName, convertFileToProp(mapAsObject));
}

let dirFiles;
if (fs.existsSync(apiFromPath)) {
    dirFiles = fs.readdirSync(apiFromPath);
    let files = new Map();
    if (dirFiles && dirFiles.length !== 0) {
        dirFiles.forEach((value) => {
            let lastDotIndex = value.lastIndexOf(".");
            if (lastDotIndex !== 0) {
                let type = value.substr(lastDotIndex);
                if (requiredTypes.includes(type)) {
                    files.set(value.substring(0, lastDotIndex), type)
                }
            }
        })
    }
    console.log("resulted files: ", files);

    createProperties(files);
    //copy APIs
    copyDir(apiFromPath, apiDestinationPath, dirFiles);
} else {
    createProperties([]);
    console.warn("Api files not found!")
}

//copy Images
copyDir(imageFromPath, imageDestinationPath);