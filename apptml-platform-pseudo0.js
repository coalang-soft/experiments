//sample platform
{
    "name": "myPlatform", //for apptml-lib; apptml-myPlatform
    "launcher": { //how to launch the app
        "show": undefined, //show the application, load the browser
        "setupJS": undefined, //set up the Platform library for JavaScript
        "onMainTag": undefined //what to do when the main tag occurs (apptml-myPlatform)
    },
    "features": { //standard features this platform supports
        "menu": undefined //lets say there is a standard menu feature. Describes what to do if <suitefx-menu> occurs
    }
}
