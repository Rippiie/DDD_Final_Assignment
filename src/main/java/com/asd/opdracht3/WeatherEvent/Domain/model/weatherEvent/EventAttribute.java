package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

import java.util.List;

public class EventAttribute {
    private String name;
    private List<Unit> units;

    public EventAttribute(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }
}
