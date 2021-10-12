package com.asd.opdracht3.Identity.Port.adapter.persistence.repository;

import com.asd.opdracht3.Identity.Domain.model.account.Account;
import com.asd.opdracht3.Identity.Domain.model.account.AccountId;
import com.asd.opdracht3.Identity.Domain.model.account.AccountRepository;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEvent;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.WeatherEventId;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private static List<Account> database = new ArrayList<>();

    @Override
    public void store(Account account) {
        database.add(account);
    }

    @Override
    public boolean checkUserName(String name) {
        return database.stream().noneMatch(account -> account.getUsername().equals(name));
    }

    public List<Account> getDatabase() {
        return database;
    }

    @Override
    public Account AccountOfId(AccountId accountId) {
        return database.stream().filter(account -> account.getAccountId() == accountId).findFirst().orElseThrow();
    }


}
