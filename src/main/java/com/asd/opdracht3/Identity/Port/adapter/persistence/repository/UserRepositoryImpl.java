package com.asd.opdracht3.Identity.Port.adapter.persistence.repository;

import com.asd.opdracht3.Identity.Domain.model.role.Role;
import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Domain.model.role.RoleTypes;
import com.asd.opdracht3.Identity.Domain.model.role.UserPermissions;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.Identity.Domain.model.user.UserRepository;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEvent;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static List<User> database = new ArrayList<>(Arrays.asList(new User("enes", new UserId("3"), new RoleId("1"))));

    @Override
    public void store(User user) {
        database.add(user);
    }

    @Override
    public User getById(UserId userId) {
        return database.stream().filter(user -> user.getUserId() == userId).findFirst().orElseThrow();
    }

    public List<User> getDatabase() {
        return database;
    }
}
