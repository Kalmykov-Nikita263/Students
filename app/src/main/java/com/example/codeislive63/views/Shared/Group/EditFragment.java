package com.example.codeislive63.views.Shared.Group;

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
import com.example.codeislive63.models.Group;

import javax.inject.Inject;

public class EditFragment extends Fragment {

    private EditText numberEditText;

    private EditText facultyNameEditText;

    @Inject
    GroupController groupController;

    public EditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_edit, container, false);

        numberEditText = view.findViewById(R.id.numberEditText);
        facultyNameEditText = view.findViewById(R.id.facultyNameEditText);

        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(sender -> saveStudent());

        return view;
    }

    private void saveStudent() {
        groupController.update(new Group(numberEditText.getText().toString(), facultyNameEditText.getText().toString()));
    }
}