package com.asd.opdracht3.WeatherEvent.Application;

import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.*;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherEventRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Port.adapter.service.WeatherEventServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherEventApplicationService {
    private final WeatherEventServiceImpl weatherEventService;
    private final WeatherEventRepositoryImpl weatherEventRepository;

    public WeatherEventApplicationService(WeatherEventServiceImpl weatherEventService, WeatherEventRepositoryImpl weatherEventRepository) {
        this.weatherEventService = weatherEventService;
        this.weatherEventRepository = weatherEventRepository;
    }

    public void createWeatherEvent(UserId userId, String name, WeatherEventId weatherEventId, PictureData pictureData, LocationData locationData, List<EventAttribute> eventAttributes) {
        if (weatherEventService.canSubmitEvent(userId)){
            WeatherEvent w = new WeatherEvent(name, weatherEventId, userId, pictureData, locationData, eventAttributes);
            weatherEventRepository.store(w);
        }
        else {
            throw new RuntimeException();
        }
    }

    public void updatePictureData(UserId userId, WeatherEventId weatherEventId, String pictureBase64, String description) {
        if (weatherEventService.canEditEvent(userId)){
            WeatherEvent w = weatherEventRepository.weatherEventOfId(weatherEventId);
            w.updatePictureData(pictureBase64, description);
            weatherEventRepository.store(w);
        }
        else {
            throw new RuntimeException();
        }
    }

    public void addEventAttribute(UserId userId, WeatherEventId weatherEventId, EventAttribute eventAttribute) {
        if (weatherEventService.canEditEvent(userId)) {
            WeatherEvent w = weatherEventRepository.weatherEventOfId(weatherEventId);
            w.addEventAttribute(eventAttribute);
            weatherEventRepository.store(w);
        }
        else {
            throw new RuntimeException();
        }
    }


}
