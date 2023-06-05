package com.example.codeislive63.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.codeislive63.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM Users WHERE Login = :login AND PasswordHash = :password")
    LiveData<List<User>> findUserByLoginAndPassword(String login, String password);
}
