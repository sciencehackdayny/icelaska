var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    onDeviceReady: function() {
        navigator.geolocation.getCurrentPosition(locationDetected, geolocationError);
        shake.startWatch(onShake);
    }
};

app.initialize();

var locationDetected = function(position) {
    var latitude = position.coords.latitude;
    var longitude = position.coords.longitude;
    var heading = position.coords.heading;
    $('#latitude').text(latitude);
    $('#longitude').text(longitude);
};

function geolocationError(error) {
    alert('code: ' + error.code + '\n' + 'message: ' + error.message + '\n');
}

var onShake = function () {
  console.log("Shake detected.");
};