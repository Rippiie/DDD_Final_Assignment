package com.asd.opdracht3.Identity.Domain.model.user;

import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;

public interface UserRepository {
    public void store(User user);

    public User getById(UserId userId);

}
