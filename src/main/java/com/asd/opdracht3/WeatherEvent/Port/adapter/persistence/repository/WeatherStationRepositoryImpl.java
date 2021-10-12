package com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository;

import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStation;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStationId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WeatherStationRepositoryImpl implements WeatherStationRepository {
    private static List<WeatherStation> database = new ArrayList<>();

    @Override
    public void store(WeatherStation weatherStation) {
        database.add(weatherStation);
    }

    @Override
    public WeatherStation weatherStationOfId(WeatherStationId weatherStationId) {
        return database.stream().filter(weatherStation -> weatherStation.getWeatherStationId() == weatherStationId).findFirst().orElseThrow();
    }
}
