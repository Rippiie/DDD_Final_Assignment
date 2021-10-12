package com.asd.opdracht3.Identity.Domain.model.user;

import com.asd.opdracht3.Identity.Domain.model.account.AccountId;
import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.RoleRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;

public class User {
    private String name;
    private UserId userId;
    private RoleId roleId;
    private AccountId accountId;



    public User(String name, UserId userId, RoleId roleId) {
        this.name = name;
        this.userId = userId;
        this.roleId = roleId;
    }

    public void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public UserId getUserId() {
        return userId;
    }

    public RoleId getRoleId() {return roleId;}

    public void setRoleId(RoleId roleId) {
        this.roleId = roleId;
    }

    public boolean canAssignRoles(RoleId roleId, RoleRepositoryImpl roleRepository){
        return roleRepository.getById(roleId).getUserPermissions().CanAssignRoles();
    }
}
