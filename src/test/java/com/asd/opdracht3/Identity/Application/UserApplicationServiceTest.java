package com.asd.opdracht3.Identity.Application;

import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.RoleRepositoryImpl;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.UserRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserApplicationServiceTest {

    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private RoleRepositoryImpl roleRepository;

    @Test
    void testUserRoleUpdate(){
        User u = new User("Rida", new UserId("2"), new RoleId("1"));
        userRepository.store(u);

        User u2 = new User("Issy", new UserId("3"), new RoleId("2"));
        userRepository.store(u2);

        userApplicationService.updateUserRole(u.getUserId(), u2.getUserId(), new RoleId("1"));
        assertEquals(new RoleId("1").getRoleIdString(), userRepository.getById(u2.getUserId()).getRoleId().getRoleIdString());
//            assertEquals(2, roleRepository.getDatabase().size());
    }

}