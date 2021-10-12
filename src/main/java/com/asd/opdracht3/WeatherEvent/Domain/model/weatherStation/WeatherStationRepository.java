package com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation;

import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEvent;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventId;

public interface WeatherStationRepository {
    void store(WeatherStation weatherStation);
    public WeatherStation weatherStationOfId(WeatherStationId weatherStationId);
}
