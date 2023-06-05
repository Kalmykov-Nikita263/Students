package com.example.codeislive63.infrastructure.di;

import android.app.Application;

import com.example.codeislive63.infrastructure.di.components.DaggerIAppComponent;
import com.example.codeislive63.infrastructure.di.components.IAppComponent;
import com.example.codeislive63.infrastructure.di.modules.ApplicationContainerModule;

public class DaggerConfigurationBuilder extends Application {

    public IAppComponent component;

    public DaggerConfigurationBuilder() {

    }

    public DaggerConfigurationBuilder(IAppComponent component) {
        this.component = component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerIAppComponent
                .builder()
                .applicationContainerModule(new ApplicationContainerModule(this))
                .build();
    }

    public IAppComponent getComponent() {
        return component;
    }
}
