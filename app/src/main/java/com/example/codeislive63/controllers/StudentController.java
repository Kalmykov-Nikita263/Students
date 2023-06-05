package com.example.codeislive63.controllers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeislive63.infrastructure.executors.ApplicationExecutor;
import com.example.codeislive63.infrastructure.types.DatabaseOperationType;
import com.example.codeislive63.models.Student;
import com.example.codeislive63.models.dao.StudentDao;

import java.util.List;

import javax.inject.Inject;

public class StudentController extends ViewModel {

    private final StudentDao students;

    @Inject
    public StudentController(StudentDao students) {
        this.students = students;
    }

    public LiveData<List<Student>> getAllStudents() {
        return students.getAllStudents();
    }

    public void insert(Student student) {
        new ApplicationExecutor(students).executeOperationAsync(student, DatabaseOperationType.Insert);
    }

    public void update(Student student) {
        new ApplicationExecutor(students).executeOperationAsync(student, DatabaseOperationType.Update);
    }

    public void delete(Student student) {
        new ApplicationExecutor(students).executeOperationAsync(student, DatabaseOperationType.Delete);
    }
}
