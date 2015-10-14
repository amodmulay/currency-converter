function createRequest() {
    try {
        request = new XMLHttpRequest();
    } catch (tryMS) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (otherMS) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }
    return request;
}
 
function callAJAXPOST(url, params, callBack) {
    var http = createRequest();
    http.open("POST", url, true);
    http.onreadystatechange = callBack(request.responseText);
    http.send(params);
}
 
function callAJAXGET(url, callBack) {
    var http = createRequest();
    http.open("GET", url, true);
    http.onreadystatechange = function(){
        if (request.readyState == 4) {
            if (request.status == 200) {
                callBack(request.responseText);
            }
        }
    }
    http.send(null);
}