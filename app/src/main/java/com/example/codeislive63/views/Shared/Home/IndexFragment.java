package com.example.codeislive63.views.Shared.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeislive63.R;
import com.example.codeislive63.adapters.GroupAdapter;
import com.example.codeislive63.controllers.GroupController;
import com.example.codeislive63.infrastructure.di.DaggerConfigurationBuilder;
import com.example.codeislive63.infrastructure.helpers.DataRenderer;

import java.util.ArrayList;

import javax.inject.Inject;

public class IndexFragment extends Fragment {

    private Button groupsBtn;
    private Button studentsBtn;

    @Inject
    GroupController groupController;

    public IndexFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activity = inflater.inflate(R.layout.home_partial, container, false);

        ((DaggerConfigurationBuilder) requireActivity().getApplication()).getComponent().inject(this);

        return activity;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.dataGrid);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        GroupAdapter adapter = new GroupAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        groupController.getAllGroups().observe(getViewLifecycleOwner(), groups -> {
            adapter.groupList = groups;
            adapter.notifyDataSetChanged();
        });
    }
}
