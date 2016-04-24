var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    onDeviceReady: function() {
        navigator.geolocation.getCurrentPosition(locationDetected);
        var watchId = navigator.geolocation.watchPosition(locationUpdated);
        shake.startWatch(onShake);
    }
};

app.initialize();

var locationDetected = function(position) {
    updateCoords(position);
    getWeather(latitude, longitude);
};

var locationUpdated = function(position){
    updateCoords(position);
};

var onShake = function () {
  console.log("Shake detected.");
};

function getWeather(latitude, longitude){
    console.log('Fetching weather...');
    $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=e00d6166d5a2cc7acd31371ca9c2b0f9",function(result){
    $('#temp').text(KtoF(result.main.temp) + "F");
    $('#temp_min').text(KtoF(result.main.temp_min) + "F");
    $('#temp_max').text(KtoF(result.main.temp_max) + "F");
    $('#condition').text(result.weather[0].description);
    $('#pressure').text(result.main.pressure + "hPa");
    $('#visibility').text(result.visibility);
    $('#wind_speed').text(result.wind.speed);
    $('#wind_deg').text(result.wind.deg);
    $('#sunrise').text(epochToJsDate(result.sys.sunrise));
    $('#sunset').text(epochToJsDate(results.sys.sunset));
    });
}

function updateCoords(position){
    console.log('Updating Coordinates...');
    latitude = position.coords.latitude;
    longitude = position.coords.longitude
    $('#latitude').text(latitude);
    $('#longitude').text(longitude);
}

function KtoF(k){
    return Math.round((9/5)*(k-273)+32);
}

function epochToJsDate(ts){
    return new Date(ts*1000);
}