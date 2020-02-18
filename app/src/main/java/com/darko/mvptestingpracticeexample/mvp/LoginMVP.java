package com.darko.mvptestingpracticeexample.mvp;

import com.darko.mvptestingpracticeexample.mvp.model.User;

public interface LoginMVP {

    interface View {
        String getFirstName();

        String getLastName();

        void showUserNotAvailable();

        void showUserAvailable();

        void showInputError();

        void setFirstName(String firstName);

        void setLastName(String lastName);

        void showUserSavedMessage();
    }

    interface Presenter {
        void setView(LoginMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();

        void saveUser();
    }

    interface Model {
        void createUser(String name, String lastName);

        User getUser();
    }
}