package com.asd.opdracht3.WeatherEvent.Port.adapter.service;

import com.asd.opdracht3.Identity.Port.adapter.UserRESTService;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventService;
import org.springframework.stereotype.Service;

@Service
public class WeatherEventServiceImpl implements WeatherEventService {
    private final UserRESTService userRESTService;

    public WeatherEventServiceImpl(UserRESTService userRESTService) {
        this.userRESTService = userRESTService;
    }

    @Override
    public boolean canSubmitEvent(UserId userId) {
        return userRESTService.canSubmitEvent(userId);
    }

    @Override
    public boolean canEditEvent(UserId userId) {
        return userRESTService.canEditEvent(userId);
    }
}
