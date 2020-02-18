package com.darko.mvptestingpracticeexample.di;

import com.darko.mvptestingpracticeexample.mvp.presenter.LoginPresenterMVPImpl;
import com.darko.mvptestingpracticeexample.LoginRepository;
import com.darko.mvptestingpracticeexample.LoginRepositoryImpl;
import com.darko.mvptestingpracticeexample.mvp.LoginMVP;
import com.darko.mvptestingpracticeexample.mvp.model.LoginModelMVPImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginMVP.Presenter provideLoginActivityPresenter(LoginMVP.Model model) {
        return new LoginPresenterMVPImpl(model);
    }

    @Provides
    public LoginMVP.Model provideLoginActivityModel(LoginRepository repository) {
        return new LoginModelMVPImpl(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new LoginRepositoryImpl();
    }
}