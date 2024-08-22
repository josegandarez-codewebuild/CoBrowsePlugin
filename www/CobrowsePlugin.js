var exec = require('cordova/exec');

var CobrowsePlugin = {
    startSession: function(licenseKey, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "CobrowsePlugin", "startSession", [licenseKey]);
    }
};

module.exports = CobrowsePlugin;