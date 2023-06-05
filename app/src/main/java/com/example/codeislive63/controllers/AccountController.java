package com.example.codeislive63.controllers;

import androidx.lifecycle.LiveData;

import com.example.codeislive63.infrastructure.executors.ApplicationExecutor;
import com.example.codeislive63.infrastructure.types.DatabaseOperationType;
import com.example.codeislive63.models.User;
import com.example.codeislive63.models.dao.UserDao;

import java.util.List;

import javax.inject.Inject;

public class AccountController {

    private final UserDao users;

    @Inject
    public AccountController(UserDao users) {
        this.users = users;
    }

    public void insert(User user) {
        new ApplicationExecutor(users).executeOperationAsync(user, DatabaseOperationType.Insert);
    }

    public void delete(User user) {
        new ApplicationExecutor(users).executeOperationAsync(user, DatabaseOperationType.Delete);
    }

    public LiveData<List<User>> findUserByLoginAndPassword(String login, String password) {
        return users.findUserByLoginAndPassword(login, password);
    }
}
