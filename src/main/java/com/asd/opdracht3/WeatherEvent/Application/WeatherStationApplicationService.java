package com.asd.opdracht3.WeatherEvent.Application;

import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStation;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStationId;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherEventRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Port.adapter.persistence.repository.WeatherStationRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Port.adapter.service.WeatherEventServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WeatherStationApplicationService {
    private final WeatherEventServiceImpl weatherEventService;
    private final WeatherStationRepositoryImpl weatherStationRepository;
    private final WeatherEventRepositoryImpl weatherEventRepository;

    public WeatherStationApplicationService(WeatherEventServiceImpl weatherEventService, WeatherStationRepositoryImpl weatherStationRepository, WeatherEventRepositoryImpl weatherEventRepository) {
        this.weatherEventService = weatherEventService;
        this.weatherStationRepository = weatherStationRepository;
        this.weatherEventRepository = weatherEventRepository;
    }

    public void addEventToStation(UserId userId, WeatherEventId weatherEventId, WeatherStationId weatherStationId){
        if (weatherEventService.canEditEvent(userId)) {
            WeatherStation w = weatherStationRepository.weatherStationOfId(weatherStationId);
            w.eventOfId(weatherEventId, weatherEventRepository);
            weatherStationRepository.store(w);
        }
        else {
            throw new RuntimeException();
        }

    }
}
