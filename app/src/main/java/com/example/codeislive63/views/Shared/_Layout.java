package com.example.codeislive63.views.Shared;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.codeislive63.R;
import com.example.codeislive63.infrastructure.helpers.DataRenderer;
import com.example.codeislive63.views.Shared.Account.LoginFragment;

public class _Layout extends AppCompatActivity {

    static boolean isAuthorized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._layout);
        replaceFragment(new LoginFragment());

        if(isAuthorized)
        {
            Button groupsBtn = findViewById(R.id.groups_btn);
            Button studentsBtn = findViewById(R.id.students_btn);

            groupsBtn.setOnClickListener(sender -> DataRenderer.RenderBody(getSupportFragmentManager(), new com.example.codeislive63.views.Shared.Group.IndexFragment(), R.id.RenderBody));

            studentsBtn.setOnClickListener(sender -> DataRenderer.RenderBody(getSupportFragmentManager(), new com.example.codeislive63.views.Shared.Student.IndexFragment(), R.id.RenderBody));
        }
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.RenderBody, fragment)
                .commit();
    }

    public static void SetAuthorize() {
        isAuthorized = true;
    }
}