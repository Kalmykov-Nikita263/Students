package com.example.codeislive63.infrastructure.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.example.codeislive63.infrastructure.ApplicationDbContext;
import com.example.codeislive63.models.dao.GroupDao;
import com.example.codeislive63.models.dao.StudentDao;
import com.example.codeislive63.models.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContainerModule {

    private final Application application;

    public ApplicationContainerModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    ApplicationDbContext provideApplicationDbContext(Application application) {
        return Room.databaseBuilder(application, ApplicationDbContext.class, "institute")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    GroupDao provideGroupDao(ApplicationDbContext context) {
        return context.groupDao();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(ApplicationDbContext context) {
        return context.userDao();
    }

    @Provides
    @Singleton
    StudentDao provideStudentDao(ApplicationDbContext context) {
        return context.studentDao();
    }
}
