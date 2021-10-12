package com.asd.opdracht3.Identity.Domain.model.user;

public class UserId {
    private String id;

    public UserId(String anId) {
        this.id = anId;
    }

    public String id() {
        return this.id;
    }
}
