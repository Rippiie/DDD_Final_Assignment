package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

public class WeatherEventId {
    private String id;

    public WeatherEventId(String anId) {
        this.id = anId;
    }

    public String id() {
        return this.id;
    }
}
