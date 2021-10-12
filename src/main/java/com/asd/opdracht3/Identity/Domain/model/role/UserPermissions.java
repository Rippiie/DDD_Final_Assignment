package com.asd.opdracht3.Identity.Domain.model.role;

public class UserPermissions {
    private boolean canAssignRoles;
    private boolean canAlterDahboard;
    private boolean canSubmitEvent;
    private boolean canEditEvent;
    private boolean canOnlyViewEvents;
    private boolean canEditUser;

    public UserPermissions(boolean canAssignRoles, boolean canAlterDahboard, boolean canSubmitEvent, boolean canEditEvent, boolean canOnlyViewEvents, boolean canEditUser) {
        this.canAssignRoles = canAssignRoles;
        this.canAlterDahboard = canAlterDahboard;
        this.canSubmitEvent = canSubmitEvent;
        this.canEditEvent = canEditEvent;
        this.canOnlyViewEvents = canOnlyViewEvents;
        this.canEditUser = canEditUser;
    }

    public boolean CanAssignRoles() {
        return canAssignRoles;
    }

    public boolean CanAlterDahboard() {
        return canAlterDahboard;
    }

    public boolean CanSubmitEvent() {
        return canSubmitEvent;
    }

    public boolean CanEditEvent() {
        return canEditEvent;
    }

    public boolean CanOnlyViewEvents() {
        return canOnlyViewEvents;
    }

    public boolean CanEditUser() {
        return canEditUser;
    }
}
