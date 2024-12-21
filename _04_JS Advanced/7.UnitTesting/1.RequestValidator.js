function solve(pObj) {
    let validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    if (!(pObj.method && validMethods.includes(pObj.method))) {
        throw new Error("Invalid request header: Invalid Method");
    }

    let uriRegex = /^[\w.]+$/;

    if (!(pObj.uri && (uriRegex.test(pObj.uri) || pObj.uri == "*"))) {
        throw new Error("Invalid request header: Invalid URI");
    }

    let validVerisons = ["HTTP/0.9", "HTTP/1.0", "HTTP/1.1", "HTTP/2.0"];

    if (!(pObj.version && validVerisons.includes(pObj.version))) {
        throw new Error("Invalid request header: Invalid Version");
    }

    let messageRegex = /^[^<>\\&'"]*$/;

    if (!(pObj.hasOwnProperty("message") && (messageRegex.test(pObj.message) || pObj.message == ""))) {
        throw new Error("Invalid request header: Invalid Message");
    }

    return pObj;

}