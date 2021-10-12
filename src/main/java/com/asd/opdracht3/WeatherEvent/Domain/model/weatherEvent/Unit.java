package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

public class Unit {
    private String unit;
    private String value;
    private SystemOfUnit systemOfUnit;

    public Unit(String unit, String value, SystemOfUnit systemOfUnit) {
        this.unit = unit;
        this.value = value;
        this.systemOfUnit = systemOfUnit;
    }
}
