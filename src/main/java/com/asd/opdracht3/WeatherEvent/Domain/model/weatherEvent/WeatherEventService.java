package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

public interface WeatherEventService {
    public boolean canSubmitEvent(UserId userId);
    public boolean canEditEvent(UserId userId);


}
