package com.codewebuild.cobrowseplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.cobrowse.CobrowseIO;


/**
 * This class echoes a string called from JavaScript.
 */
public class CobrowsePlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startSession")) {
            String licenseKey  = args.getString(0);
            this.startSession(licenseKey, callbackContext);
            return true;
        }
        return false;
    }

    private void startSession(String licenseKey, CallbackContext callbackContext) {
        if (licenseKey != null && licenseKey.length() > 0) {
            // Initialize Cobrowse SDK with the license key
            CobrowseIO.instance().license(licenseKey);
            CobrowseIO.instance().start(this.cordova.getActivity().getApplication());
            callbackContext.success("Cobrowse session started");
        } else {
            callbackContext.error("Failed to start Cobrowse session");
        }
    }
}
