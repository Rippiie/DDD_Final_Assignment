package com.asd.opdracht3.Identity.Application;

import com.asd.opdracht3.Identity.Domain.model.account.Account;
import com.asd.opdracht3.Identity.Domain.model.account.AccountId;
import com.asd.opdracht3.Identity.Domain.model.account.Email;
import com.asd.opdracht3.Identity.Domain.model.account.PhoneNumber;
import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.AccountRepositoryImpl;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.UserRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationService {
    private final AccountRepositoryImpl accountRepository;
    private final UserRepositoryImpl userRepository;

    public AccountApplicationService(AccountRepositoryImpl accountRepository, UserRepositoryImpl userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void createAccount(AccountId accountId, String username, Email email, PhoneNumber phoneNumber, UserId userId, String PersonName, RoleId roleId){
        Account a = new Account(accountId, username, email, phoneNumber, PersonName, userId, roleId, accountRepository, userRepository);
        accountRepository.store(a);
    }
}
