package com.example.codeislive63.infrastructure;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.codeislive63.models.Group;
import com.example.codeislive63.models.Student;
import com.example.codeislive63.models.User;
import com.example.codeislive63.models.dao.GroupDao;
import com.example.codeislive63.models.dao.StudentDao;
import com.example.codeislive63.models.dao.UserDao;

@Database(entities = { Student.class, Group.class, User.class }, version = 3)
public abstract class ApplicationDbContext extends RoomDatabase {
    public abstract StudentDao studentDao();
    public abstract GroupDao groupDao();
    public abstract UserDao userDao();
}
