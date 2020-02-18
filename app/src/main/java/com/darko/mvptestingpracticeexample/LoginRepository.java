package com.darko.mvptestingpracticeexample;

import com.darko.mvptestingpracticeexample.mvp.model.User;

public interface LoginRepository {
    User getUser();
    void saveUser(User user);
}