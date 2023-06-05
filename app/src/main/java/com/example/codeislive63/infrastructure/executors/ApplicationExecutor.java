package com.example.codeislive63.infrastructure.executors;

import android.os.Handler;
import android.os.Looper;

import com.example.codeislive63.infrastructure.types.DatabaseOperationType;
import com.example.codeislive63.models.Group;
import com.example.codeislive63.models.Student;
import com.example.codeislive63.models.User;
import com.example.codeislive63.models.dao.GroupDao;
import com.example.codeislive63.models.dao.StudentDao;
import com.example.codeislive63.models.dao.UserDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationExecutor {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private final StudentDao students;
    private final GroupDao groups;

    private final UserDao users;

    public ApplicationExecutor(StudentDao students, GroupDao groups, UserDao users) {
        this.students = students;
        this.groups = groups;
        this.users = users;
    }

    public ApplicationExecutor(StudentDao students) {
        this(students, null, null);
    }

    public ApplicationExecutor(GroupDao groups) {
        this(null, groups, null);
    }

    public ApplicationExecutor(UserDao users) {
        this(null, null, users);
    }

    public <T> void executeOperationAsync(T dao, DatabaseOperationType operation) {
        if (dao instanceof Student && students != null) {
            executor.execute(() -> {
                switch (operation) {
                    case Insert -> students.insert((Student) dao);
                    case Update -> students.update((Student) dao);
                    case Delete -> students.delete((Student) dao);
                }
                handler.post(() -> { });
            });
        } else if (dao instanceof Group && groups != null) {
            executor.execute(() -> {
                switch (operation) {
                    case Insert -> groups.insert((Group) dao);
                    case Update -> groups.update((Group) dao);
                    case Delete -> groups.delete((Group) dao);
                }
                handler.post(() -> { });
            });
        } else if (dao instanceof User && users != null) {
            executor.execute(() -> {
                switch (operation) {
                    case Insert -> users.insert((User) dao);
                    case Delete -> users.delete((User) dao);
                    default -> throw new IllegalArgumentException("Невозможно применить операцию");
                }
                handler.post(() -> { });
            });
        }
        else {
            throw new IllegalArgumentException("Данный тип объекта не поддерживается");
        }
    }
}