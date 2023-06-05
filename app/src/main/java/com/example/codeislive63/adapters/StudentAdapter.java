package com.example.codeislive63.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeislive63.R;
import com.example.codeislive63.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    public List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView numberTextView;
        private TextView lastNameTextView;
        private TextView nameTextView;
        private TextView middleNameTextView;
        private TextView birthDateTextView;
        private TextView groupNumberTextView;
        private Button editButton;
        private Button deleteButton;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            lastNameTextView = itemView.findViewById(R.id.lastNameTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            middleNameTextView = itemView.findViewById(R.id.middleNameTextView);
            birthDateTextView = itemView.findViewById(R.id.birthDateTextView);
            groupNumberTextView = itemView.findViewById(R.id.groupNumberTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }

        public void bind(Student student) {
            numberTextView.setText(student.getGroupId());
            lastNameTextView.setText(student.getLastName());
            nameTextView.setText(student.getFirstName());
            middleNameTextView.setText(student.getMiddleName());
            birthDateTextView.setText(student.getBirthDate().toString());
            groupNumberTextView.setText(student.getGroupId());

            editButton.setOnClickListener(sender -> {

            });

            deleteButton.setOnClickListener(sender -> {

            });
        }
    }
}