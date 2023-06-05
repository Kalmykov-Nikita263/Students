package com.example.codeislive63.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeislive63.R;
import com.example.codeislive63.models.Group;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {
    public List<Group> groupList;

    public GroupAdapter(List<Group> groupList) {
        this.groupList = groupList;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        Group group = groupList.get(position);
        holder.bind(group);
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        private final TextView facultyNameTextView;
        private final TextView groupNumberTextView;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            facultyNameTextView = itemView.findViewById(R.id.facultyNameTextView);
            groupNumberTextView = itemView.findViewById(R.id.groupNumberTextView);
        }

        public void bind(Group group) {
            facultyNameTextView.setText(group.getFacultyName());
            groupNumberTextView.setText(group.getNumber());
        }
    }
}