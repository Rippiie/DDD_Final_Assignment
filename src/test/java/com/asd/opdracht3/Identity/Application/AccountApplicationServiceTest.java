package com.asd.opdracht3.Identity.Application;

import com.asd.opdracht3.Identity.Domain.model.account.Account;
import com.asd.opdracht3.Identity.Domain.model.account.AccountId;
import com.asd.opdracht3.Identity.Domain.model.account.Email;
import com.asd.opdracht3.Identity.Domain.model.account.PhoneNumber;
import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.AccountRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountApplicationServiceTest {

    @Autowired
    private AccountApplicationService accountApplicationService;

    @Autowired
    private AccountRepositoryImpl accountRepository;

    @Test
    void testAccountCreation() {
        accountApplicationService.createAccount(new AccountId("1"), "BramvM", new Email("bram@gmail.com"), new PhoneNumber("06123456789"), new UserId("1"), "Bram van Mierlo",  new RoleId("1"));
        assertEquals(1, accountRepository.getDatabase().size());
        assertEquals("BramvM", accountRepository.getDatabase().get(0).getUsername());
    }
}