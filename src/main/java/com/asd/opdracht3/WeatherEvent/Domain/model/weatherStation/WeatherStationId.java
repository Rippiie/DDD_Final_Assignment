package com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation;

public class WeatherStationId {
    private String id;

    public WeatherStationId(String anId) {
        this.id = anId;
    }

    public String id() {
        return this.id;
    }
}
