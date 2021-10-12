package com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation;

import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventId;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherEventRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private String name;
    private WeatherStationId weatherStationId;
    private List<WeatherEventId> weatherEventList = new ArrayList<>();


    public WeatherStation(String name, WeatherStationId weatherStationId) {
        this.name = name;
        this.weatherStationId = weatherStationId;
    }

    public WeatherStationId getWeatherStationId() {
        return weatherStationId;
    }

    public void eventOfId(WeatherEventId weatherEventId, WeatherEventRepositoryImpl weatherEventRepository){
        weatherEventList.add(weatherEventRepository.weatherEventOfId(weatherEventId).getWeatherEventId());
    }

    public List<WeatherEventId> getWeatherEventList() {
        return weatherEventList;
    }
}
