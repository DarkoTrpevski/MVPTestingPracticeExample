package com.darko.mvptestingpracticeexample;

import com.darko.mvptestingpracticeexample.mvp.model.User;

public class LoginRepositoryImpl implements LoginRepository {

    private User user;

    //We are trying to avoid NullPointerException by adding our own default User(Fox, Mulder)
    @Override
    public User getUser() {
        if (user == null) {
            User user = new User("Fox", "Mulder");
            user.setId(0);
            this.user = user;
            return this.user;
        } else {
            return user;
        }
    }

    //We are trying to avoid NullPointerException by adding our own default User(Fox, Mulder)
    @Override
    public void saveUser(User user) {
        this.user.setFirstName(user.getFirstName());
        this.user.setLastName(user.getLastName());
    }
}