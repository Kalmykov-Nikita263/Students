package com.example.codeislive63.models;

import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import com.example.codeislive63.infrastructure.converters.DateTimeConverter;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "Students", foreignKeys = @ForeignKey(entity = Group.class, parentColumns = "GroupId", childColumns = "GroupId", onDelete = ForeignKey.RESTRICT))
public class Student {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "StudentId")
    private String studentId;

    @ColumnInfo(name = "Name")
    private String firstName;

    @ColumnInfo(name = "LastName")
    private String lastName;

    @ColumnInfo(name = "MiddleName")
    private String middleName;

    @ColumnInfo(name = "BirthDate")
    @TypeConverters(DateTimeConverter.class)
    private Date birthDate;

    @ColumnInfo(name = "GroupId")
    private String groupId;

    public Student(String firstName, String lastName, String middleName, Date birthDate, String groupId) {
        this.studentId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.groupId = groupId;
    }

    @NonNull
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}