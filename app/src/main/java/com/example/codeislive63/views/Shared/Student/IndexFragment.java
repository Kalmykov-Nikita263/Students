package com.example.codeislive63.views.Shared.Student;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeislive63.R;
import com.example.codeislive63.adapters.StudentAdapter;
import com.example.codeislive63.controllers.StudentController;
import com.example.codeislive63.infrastructure.di.DaggerConfigurationBuilder;

import java.util.ArrayList;

import javax.inject.Inject;

public class IndexFragment extends Fragment {

    @Inject
    StudentController studentController;

    public IndexFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activity = inflater.inflate(R.layout.students_index, container, false);

        ((DaggerConfigurationBuilder) requireActivity().getApplication()).getComponent().inject(this);

        return activity;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.studentsDataGrid);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        StudentAdapter adapter = new StudentAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        studentController.getAllStudents().observe(getViewLifecycleOwner(), students -> {
            adapter.studentList = students;
            adapter.notifyDataSetChanged();
        });
    }
}
