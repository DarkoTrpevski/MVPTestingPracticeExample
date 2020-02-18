package com.darko.mvptestingpracticeexample.mvp.presenter;

import androidx.annotation.Nullable;

import com.darko.mvptestingpracticeexample.mvp.LoginMVP;
import com.darko.mvptestingpracticeexample.mvp.model.User;

/**
 * This CLASS implements the PRESENTER part of the MVP ARCHITECTURE PATTERN
 */
public class LoginPresenterMVPImpl implements LoginMVP.Presenter {

    @Nullable
    private LoginMVP.View view;
    private LoginMVP.Model model;

    //LoginPresenterMVPImpl CONSTRUCTOR
    public LoginPresenterMVPImpl(LoginMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(@Nullable LoginMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user != null) {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        } else {
            if (view != null) {
                view.showUserNotAvailable();
            }
        }
    }

    @Override
    public void saveUser() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

}
