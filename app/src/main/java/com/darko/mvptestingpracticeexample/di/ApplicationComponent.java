package com.darko.mvptestingpracticeexample.di;

import com.darko.mvptestingpracticeexample.mvp.view.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}