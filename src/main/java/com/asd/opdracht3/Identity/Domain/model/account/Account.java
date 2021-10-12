package com.asd.opdracht3.Identity.Domain.model.account;

import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.AccountRepositoryImpl;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.UserRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;

public class Account {
    private AccountId accountId;
    private String username;
    private Email email;
    private PhoneNumber phoneNumber;

    public Account(AccountId accountId, String username, Email email, PhoneNumber phoneNumber, String PersonName, UserId userId, RoleId roleId, AccountRepositoryImpl accountRepository, UserRepositoryImpl userRepository) {
        this.accountId = accountId;
        this.username = username;
        this.checkUserName(accountRepository, this.username);
        this.email = email;
        this.phoneNumber = phoneNumber;
        User u = new User(PersonName, userId, roleId);
        u.setAccountId(this.accountId);
        userRepository.store(u);
    }

    private void checkUserName(AccountRepositoryImpl accountRepository, String username){
        if (!accountRepository.checkUserName(username)){
            throw new RuntimeException();
        }
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}


