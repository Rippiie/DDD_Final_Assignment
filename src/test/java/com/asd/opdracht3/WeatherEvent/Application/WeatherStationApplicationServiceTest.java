package com.asd.opdracht3.WeatherEvent.Application;

import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.RoleRepositoryImpl;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.UserRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.*;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStation;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStationId;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherEventRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherStationRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherStationApplicationServiceTest {

    @Autowired
    private WeatherStationApplicationService weatherStationApplicationService;

    @Autowired
    private WeatherStationRepositoryImpl weatherStationRepository;

    @Autowired
    private WeatherEventRepositoryImpl weatherEventRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    void testAddEventToStation(){

        WeatherStation weatherStation = new WeatherStation("Weerstation 1", new WeatherStationId("1"));
        weatherStationRepository.store(weatherStation);

        WeatherEvent weatherEvent= new WeatherEvent("Weerevent 1", new WeatherEventId("1"), new UserId("3"), new PictureData("hbfhbgfb", "desc"), new LocationData(122121.7, 454545454.6), Arrays.asList(new EventAttribute("Temp", Arrays.asList(new Unit("K", "50", SystemOfUnit.IMPERIAL)))));
        weatherEventRepository.store(weatherEvent);

        User u = new User("Rida", new UserId("2"), new RoleId("1"));
        userRepository.store(u);
        weatherStationApplicationService.addEventToStation(u.getUserId(), weatherEvent.getWeatherEventId(), weatherStation.getWeatherStationId());
        assertEquals(1, weatherStation.getWeatherEventList().size());

    }
}