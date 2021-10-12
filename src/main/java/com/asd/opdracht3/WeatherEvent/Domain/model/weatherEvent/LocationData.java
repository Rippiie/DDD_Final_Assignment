package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

public class LocationData {
    private Double longitude;
    private Double latitude;

    public LocationData(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public boolean isLocationValid() {
        return true;
    }
}
