package com.asd.opdracht3.WeatherEvent.Application;

import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.UserRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.*;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherEventRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherEventApplicationServiceTest {

    @Autowired
    private WeatherEventApplicationService weatherEventApplicationService;

    @Autowired
    private WeatherEventRepositoryImpl weatherEventRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setup() {
        weatherEventRepository.clearDatabase();
    }

    @Test
    void testCreationWeatherEvent() {
        User u = new User("Rida", new UserId("3"), new RoleId("1"));
        userRepository.store(u);
        weatherEventApplicationService.createWeatherEvent(u.getUserId(), "Weerevent 2", new WeatherEventId("3"), new PictureData("hbfhbgfb", "desc"), new LocationData(122121.7, 454545454.6), Arrays.asList(new EventAttribute("Temp", Arrays.asList(new Unit("K", "50", SystemOfUnit.IMPERIAL)))));
        assertEquals(1, weatherEventRepository.getDatabase().size());
    }

    @Test
    void testUpdatePictureData() {
        User u = new User("Rida", new UserId("3"), new RoleId("1"));
        userRepository.store(u);

        WeatherEvent weatherEvent= new WeatherEvent("Weerevent 1", new WeatherEventId("1"), new UserId("3"), new PictureData("hbfhbgfb", "desc"), new LocationData(122121.7, 454545454.6), Arrays.asList(new EventAttribute("Temp", Arrays.asList(new Unit("K", "50", SystemOfUnit.IMPERIAL)))));
        weatherEventRepository.store(weatherEvent);

        weatherEventApplicationService.updatePictureData(u.getUserId(), weatherEvent.getWeatherEventId(), "new string", "new desc");
        assertEquals("new string", weatherEventRepository.weatherEventOfId(weatherEvent.getWeatherEventId()).getPictureData().getPictureBase64());
    }

    @Test
    void testAddEventAttribute() {
        User u = new User("Rida", new UserId("3"), new RoleId("1"));
        userRepository.store(u);

        WeatherEvent weatherEvent= new WeatherEvent("Weerevent 1", new WeatherEventId("1"), new UserId("3"), new PictureData("hbfhbgfb", "desc"), new LocationData(122121.7, 454545454.6), new ArrayList<>(Arrays.asList(new EventAttribute("Temp", Arrays.asList(new Unit("K", "50", SystemOfUnit.IMPERIAL))))));
        weatherEventRepository.store(weatherEvent);

        EventAttribute eventAttribute = new EventAttribute("Temperatuur", Collections.singletonList(new Unit("C", "12", SystemOfUnit.IMPERIAL)));
        weatherEventApplicationService.addEventAttribute(u.getUserId(), weatherEvent.getWeatherEventId(), eventAttribute);
        assertEquals(2, weatherEventRepository.weatherEventOfId(weatherEvent.getWeatherEventId()).getEventAttributes().size());
    }

}