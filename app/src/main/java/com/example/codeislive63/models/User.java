package com.example.codeislive63.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.codeislive63.infrastructure.helpers.PasswordHasher;

import java.util.UUID;

@Entity(tableName = "Users")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "UserId")
    private String userId;

    @ColumnInfo(name = "Login")
    private String login;

    @ColumnInfo(name = "PasswordHash")
    private String password;

    public User(String login, String password) {
        this.userId = UUID.randomUUID().toString();
        this.login = login;
        this.password = new PasswordHasher().hashPassword(password);
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
}
