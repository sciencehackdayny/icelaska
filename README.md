# Icelaska

## TEAM

* Vishnu Ravi
* Jaya Kasa

### PURPOSE

Icelaska is a cross-platform mobile app built for Alaskan ice hunters to get access to information about weather, ocean currents, sea ice temperatures, and safe paths to take while hunting. The app is controlled using gestures so that the hunters do not need to remove their gloves and risk frostbite.

Hunters can easily log information about hazards in the terrain such as pressure ridges and cracks, which are then shared with other users and can also serve as a local record of climate change. The app also logs the hunter's position as they are trekking across the ice and records paths that are known to be safe.

We have built the app to have a minimal user interface and minimize the amount of interaction that the hunter needs to have with the device, so as to limit distractions from the treacherous terrain. Keeping in mind that a data connection will not always be available, our app preloads and stores data locally, updating when possible.

## INSTRUCTIONS (APP)
1. Install [Apache Cordova CLI](https://cordova.apache.org/docs/en/latest/guide/cli/index.html#installing-the-cordova-cli).
2. Open the 'app/icelaska' directory in your terminal and add the platform you want to build for, e.g. ```cordova add platform ios```
3. Run ```cordova build <platform>```
3. Connect device and run ```cordova run <platform>```.

## EXTERNAL LINKS
* [CartoDB](http://www.cartodb.com)
* [Apache Cordova](http://cordova.apache.org)
* [Spring](https://spring.io)

Data Sources:
* http://www.ncdc.noaa.gov/cdo-web/api/v2
* http://feeder.gina.alaska.edu/radar-uaf-barrow-seaice-images/
* http://polarportal.dk/forsiden/

