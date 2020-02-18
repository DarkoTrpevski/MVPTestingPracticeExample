package com.darko.mvptestingpracticeexample;

import android.app.Application;

import com.darko.mvptestingpracticeexample.di.ApplicationComponent;
import com.darko.mvptestingpracticeexample.di.ApplicationModule;
import com.darko.mvptestingpracticeexample.di.DaggerApplicationComponent;
import com.darko.mvptestingpracticeexample.di.LoginModule;

public class LoginApp extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}