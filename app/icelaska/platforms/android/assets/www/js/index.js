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
        var watchGPS = navigator.geolocation.watchPosition(locationUpdated);
        var watchCompass = navigator.compass.watchHeading(compassSuccess);
        //var watchAcceleration = navigator.accelerometer.watchAcceleration(accelerometerSuccess, null, {frequency: 1000});
        shake.startWatch(onShake, 20);

        initPanels();
    }
};

app.initialize();

var locationDetected = function(position) {
    updateCoords(position);
    getWeather(latitude, longitude);
    updateWeatherDisplay();
};

var locationUpdated = function(position){
    updateCoords(position);
};

var compassSuccess = function(heading){
    $('#compass').text(degToCard(heading.magneticHeading));
}

/* var accelerometerSuccess = function(acceleration){
   console.log('Acceleration X: ' + acceleration.x + '\n' +
          'Acceleration Y: ' + acceleration.y + '\n' +
          'Acceleration Z: ' + acceleration.z + '\n' +
          'Timestamp: '      + acceleration.timestamp + '\n'); 

    if (acceleration.y < -1){
        console.log("up");
        window.scrollBy(9,scrolly*100);
    }

    if (acceleration.y > 9){
        console.log("down");
        window.scrollBy(0,scrolly*20);
    }
} */

var onShake = function () {
    console.log("Shake detected.");
    switchPanel();
};

function initPanels(){
    $('#panel-1').show();
    $('#panel-2').hide();
    $('#panel-3').hide();
}

function switchPanel(){
    if($('#panel-1').is(':visible')){
        $('#panel-1').slideUp();
        $('#panel-2').show();
    }else if($('#panel-2').is(':visible')){
        $('#panel-2').slideUp();
        $('#panel-3').show();
    }else if($('#panel-3').is(':visible')){
        $('#panel-3').slideUp();
        $('#panel-1').show();
    }else{
        initPanels();
    }
}

function getWeather(latitude, longitude){
    console.log('Fetching weather...');
    $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=e00d6166d5a2cc7acd31371ca9c2b0f9&units=imperial",function(result){
    var storage = window.localStorage;
    storage.setItem('temp', result.main.temp);
    storage.setItem('temp_min', result.main.temp_min);
    storage.setItem('temp_max', result.main.temp_max);
    storage.setItem('condition', result.weather[0].description);
    storage.setItem('pressure', result.main.pressure);
    storage.setItem('humidity', result.main.humidity);
    storage.setItem('visibility', result.visibility);
    storage.setItem('wind_speed', result.wind.speed);
    storage.setItem('wind_deg', result.wind.deg);
    storage.setItem('sunrise', result.sys.sunrise);
    storage.setItem('sunset', result.sys.sunset);
    });
}

function updateWeatherDisplay(){
    var storage = window.localStorage;
    $('#temp').text(storage.getItem("temp") + " F");
    $('#temp_min').text(storage.getItem("temp_min") + " F");
    $('#temp_max').text(storage.getItem("temp_max") + " F");
    $('#condition').text(storage.getItem("condition"));
    $('#pressure').text(storage.getItem("pressure") + " hPa");
    $('#humidity').text(storage.getItem("humidity") + "%")
    $('#visibility').text(storage.getItem("visibility"));
    $('#wind_speed').text(storage.getItem("wind_speed") + " mph");
    $('#wind_deg').text(degToCard(storage.getItem("wind_deg")));
    $('#sunrise').text(epochToJsDate(storage.getItem("sunrise")));
    $('#sunset').text(epochToJsDate(storage.getItem("sunset")));
}

function updateCoords(position){
    console.log('Updating Coordinates...');
    latitude = position.coords.latitude;
    longitude = position.coords.longitude
    $('#latitude').text(latitude);
    $('#longitude').text(longitude);
}

function degToCard(deg){
  if (deg>11.25 && deg<33.75){
    return "NNE";
  }else if (deg>33.75 && deg<56.25){
    return "ENE";
  }else if (deg>56.25 && deg<78.75){
    return "E";
  }else if (deg>78.75 && deg<101.25){
    return "ESE";
  }else if (deg>101.25 && deg<123.75){
    return "ESE";
  }else if (deg>123.75 && deg<146.25){
    return "SE";
  }else if (deg>146.25 && deg<168.75){
    return "SSE";
  }else if (deg>168.75 && deg<191.25){
    return "S";
  }else if (deg>191.25 && deg<213.75){
    return "SSW";
  }else if (deg>213.75 && deg<236.25){
    return "SW";
  }else if (deg>236.25 && deg<258.75){
    return "WSW";
  }else if (deg>258.75 && deg<281.25){
    return "W";
  }else if (deg>281.25 && deg<303.75){
    return "WNW";
  }else if (deg>303.75 && deg<326.25){
    return "NW";
  }else if (deg>326.25 && deg<348.75){
    return "NNW";
  }else{
    return "N"; 
  }
}

function epochToJsDate(ts){
    return new Date(ts*1000);
}