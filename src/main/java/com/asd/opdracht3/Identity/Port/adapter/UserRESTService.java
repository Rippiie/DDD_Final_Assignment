package com.asd.opdracht3.Identity.Port.adapter;

import com.asd.opdracht3.Identity.Application.UserApplicationService;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import org.springframework.stereotype.Service;

@Service
public class UserRESTService {
    private final UserApplicationService userApplicationService;

    public UserRESTService(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    public boolean canSubmitEvent(UserId userId){
        //applicatie service aanspreken
        return userApplicationService.canSubmitEvent(userId);
    }

    public boolean canEditEvent(UserId userId){
        return userApplicationService.canEditEvent(userId);
    }
}
