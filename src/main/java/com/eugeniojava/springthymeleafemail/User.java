package com.eugeniojava.springthymeleafemail;

public class User {
    private final String name;
    private final String username;
    private final String email;

    public User(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
