package com.asd.opdracht3.Identity.Port.adapter.persistence.repository;

import com.asd.opdracht3.Identity.Domain.model.role.*;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherStation.WeatherStation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    private static List<Role> database = new ArrayList<Role>(Arrays.asList(new Role("Role 1", RoleTypes.SYSTEMADMIN, new RoleId("1"), new UserPermissions(true, true, true, true, true, true)), new Role("Role 2", RoleTypes.ORGANIZATIONADMIN, new RoleId("2"), new UserPermissions(true, true, true, true, true, true))));

    @Override
    public Role getById(RoleId roleId) {
        return database.stream().filter(role -> role.getRoleId().getRoleIdString() == roleId.getRoleIdString()).findFirst().orElseThrow();
    }

    @Override
    public void store(Role role) {
        database.add(role);
    }

    public List<Role> getDatabase() {
        return database;
    }
}
