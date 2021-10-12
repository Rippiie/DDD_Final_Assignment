package com.asd.opdracht3.Identity.Domain.model.account;

import java.util.List;

public interface AccountRepository {
     Account AccountOfId(AccountId accountId);
     List<Account> getDatabase();
     void store(Account account);
     boolean checkUserName(String name);
}
