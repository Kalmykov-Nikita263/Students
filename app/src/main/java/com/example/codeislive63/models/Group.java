package com.example.codeislive63.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "Groups")
public class Group {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "GroupId")
    private String groupId;

    @ColumnInfo(name = "Number")
    private String number;

    @ColumnInfo(name = "Faculty")
    private String facultyName;

    public Group(String number, String facultyName) {
        this.groupId = UUID.randomUUID().toString();
        this.number = number;
        this.facultyName = facultyName;
    }

    @NonNull
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(@NonNull String groupId) {
        this.groupId = groupId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
