package com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository;

import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEvent;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WeatherEventRepositoryImpl implements WeatherEventRepository {
    private static List<WeatherEvent> database = new ArrayList<>();

    @Override
    public void store(WeatherEvent weatherEvent) {
        database.add(weatherEvent);
    }

    public List<WeatherEvent> getDatabase() {
        return database;
    }

    @Override
    public WeatherEvent weatherEventOfId(WeatherEventId weatherEventId) {
        return database.stream().filter(weatherEvent -> weatherEvent.getWeatherEventId() == weatherEventId).findFirst().orElseThrow();
    }

    public void clearDatabase() {
        database.clear();
    }


}
