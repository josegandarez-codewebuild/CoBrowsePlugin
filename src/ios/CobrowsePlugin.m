/********* CobrowsePlugin.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
@import CobrowseIO;

@interface CobrowsePlugin : CDVPlugin {
  // Member variables go here.
}

- (void)startSession:(CDVInvokedUrlCommand*)command;
@end

@implementation CobrowsePlugin

- (void)startSession:(CDVInvokedUrlCommand*)command
{
    NSString* licenseKey = [command.arguments objectAtIndex:0]; 
    CDVPluginResult* pluginResult = nil;

    if (echo != licenseKey && [licenseKey length] > 0) {
        // Initialize Cobrowse SDK with the license key
        CobrowseIO.instance.license = licenseKey;
        [CobrowseIO.instance start];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:licenseKey];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
