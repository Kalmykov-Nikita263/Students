package com.example.codeislive63.views.Shared.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.codeislive63.R;
import com.example.codeislive63.controllers.GroupController;
import com.example.codeislive63.controllers.StudentController;
import com.example.codeislive63.models.Student;

import java.util.Date;
import java.util.Objects;

import javax.inject.Inject;

public class CreateFragment extends Fragment {

    private EditText lastNameEditText;
    private EditText nameEditText;
    private EditText middleNameEditText;
    private EditText birthDateEditText;

    @Inject
    StudentController studentController;

    @Inject
    GroupController groupController;

    public CreateFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_create, container, false);

        lastNameEditText = view.findViewById(R.id.lastNameEditText);
        nameEditText = view.findViewById(R.id.nameEditText);
        middleNameEditText = view.findViewById(R.id.middleNameEditText);
        birthDateEditText = view.findViewById(R.id.birthDatePicker);
        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(sender -> saveStudent());

        return view;
    }

    private void saveStudent() {
        studentController.insert(new Student(nameEditText.getText().toString(), lastNameEditText.getText().toString(), middleNameEditText.getText().toString(), (Date) birthDateEditText.getText(), Objects.requireNonNull(groupController.getAllGroups().getValue()).get(0).toString()));
    }
}
