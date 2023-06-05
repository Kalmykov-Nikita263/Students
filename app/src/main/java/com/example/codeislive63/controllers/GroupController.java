package com.example.codeislive63.controllers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeislive63.infrastructure.executors.ApplicationExecutor;
import com.example.codeislive63.infrastructure.types.DatabaseOperationType;
import com.example.codeislive63.models.Group;
import com.example.codeislive63.models.dao.GroupDao;

import java.util.List;

import javax.inject.Inject;

public class GroupController extends ViewModel {

    private final GroupDao groups;

    @Inject
    public GroupController(GroupDao groups) {
        this.groups = groups;
    }

    public LiveData<List<Group>> getAllGroups() {
        return groups.getAllGroups();
    }

    public void insert(Group group) {
        new ApplicationExecutor(groups).executeOperationAsync(group, DatabaseOperationType.Insert);
    }

    public void update(Group group) {
        new ApplicationExecutor(groups).executeOperationAsync(group, DatabaseOperationType.Update);
    }

    public void delete(Group group) {
        new ApplicationExecutor(groups).executeOperationAsync(group, DatabaseOperationType.Delete);
    }
}
