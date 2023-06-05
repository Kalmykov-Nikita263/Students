package com.example.codeislive63.views.Shared.Account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.codeislive63.R;
import com.example.codeislive63.controllers.AccountController;
import com.example.codeislive63.infrastructure.di.DaggerConfigurationBuilder;
import com.example.codeislive63.infrastructure.helpers.DataRenderer;
import com.example.codeislive63.infrastructure.helpers.PasswordHasher;
import com.example.codeislive63.models.User;
import com.example.codeislive63.views.Shared.Home.IndexFragment;
import com.example.codeislive63.views.Shared._Layout;

import javax.inject.Inject;

public class LoginFragment extends Fragment {

    @Inject
    AccountController accountController;

    public LoginFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activity = inflater.inflate(R.layout.login_partial, container, false);

        ((DaggerConfigurationBuilder) requireActivity().getApplication()).getComponent().inject(this);

        accountController.insert(new User("user", "user"));

        Button _signInBtn = activity.findViewById(R.id.sign_in_btn);
        _signInBtn.setOnClickListener(this::PasswordSignIn);
        return activity;
    }

    private void PasswordSignIn(View sender) {
        EditText login = requireView().findViewById(R.id.userLoginEditText);
        EditText password = requireView().findViewById(R.id.passwordEditText);

        var user = accountController.findUserByLoginAndPassword("user", "user");

        user.observe(getViewLifecycleOwner(), users -> {
            if(users.stream().anyMatch(u -> u.getLogin().equals(login.getText().toString()) && u.getPassword().equals(new PasswordHasher().hashPassword(password.getText().toString())))) {
                _Layout.SetAuthorize();
                DataRenderer.RenderBody(requireActivity().getSupportFragmentManager(), new IndexFragment(), R.id.RenderBody);
            } else {
                Toast.makeText(getContext(), "Неправильный логин или пароль", Toast.LENGTH_LONG).show();
            }
        });
    }
}
