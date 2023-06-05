package com.example.codeislive63.infrastructure.di.components;

import com.example.codeislive63.infrastructure.di.modules.ApplicationContainerModule;
import com.example.codeislive63.views.Shared.Account.LoginFragment;
import com.example.codeislive63.views.Shared.Home.IndexFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationContainerModule.class })
public interface IAppComponent {
    void inject(IndexFragment fragment);
    void inject(LoginFragment fragment);

    void inject(com.example.codeislive63.views.Shared.Student.IndexFragment indexFragment);

    void inject(com.example.codeislive63.views.Shared.Group.IndexFragment indexFragment);
}
