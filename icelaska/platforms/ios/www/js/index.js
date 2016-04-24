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

var compassSuccess = function(heading){
    $('#compass').text(degToCard(heading.magneticHeading));
}

var onShake = function () {
  console.log("Shake detected.");
};

function getWeather(latitude, longitude){
    console.log('Fetching weather...');
    $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=e00d6166d5a2cc7acd31371ca9c2b0f9&units=imperial",function(result){
    $('#temp').text(result.main.temp + " F");
    $('#temp_min').text(result.main.temp_min + " F");
    $('#temp_max').text(result.main.temp_max + " F");
    $('#condition').text(result.weather[0].description);
    $('#pressure').text(result.main.pressure + " hPa");
    $('#humidity').text(result.main.humidity + "%")
    $('#visibility').text(result.visibility);
    $('#wind_speed').text(result.wind.speed + " mph");
    $('#wind_deg').text(degToCard(result.wind.deg));
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