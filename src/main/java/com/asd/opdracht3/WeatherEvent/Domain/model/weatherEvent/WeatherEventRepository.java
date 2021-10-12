package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

public interface WeatherEventRepository {
    void store(WeatherEvent weatherEvent);
    public WeatherEvent weatherEventOfId(WeatherEventId weatherEventId);
}
