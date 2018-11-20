package org.myluk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class User {
    private int users_id;
    private String username, email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
