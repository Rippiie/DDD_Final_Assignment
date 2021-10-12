package com.asd.opdracht3.Identity.Domain.model.role;

public class Role {
    private String description;
    private RoleTypes roleType;
    private RoleId roleId;
    private UserPermissions userPermissions;

    public Role(String description, RoleTypes roleType, RoleId roleId, UserPermissions userPermissions) {
        this.description = description;
        this.roleType = roleType;
        this.roleId = roleId;
        this.userPermissions = userPermissions;
    }

    public String getDescription() {
        return description;
    }

    public RoleTypes getRoleType() {
        return roleType;
    }

    public RoleId getRoleId() {
        return roleId;
    }

    public UserPermissions getUserPermissions() {
        return userPermissions;
    }
}
