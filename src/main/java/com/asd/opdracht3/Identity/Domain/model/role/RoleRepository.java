package com.asd.opdracht3.Identity.Domain.model.role;

import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;

public interface RoleRepository {

    public Role getById(RoleId roleId);
    public void store(Role role);
}
