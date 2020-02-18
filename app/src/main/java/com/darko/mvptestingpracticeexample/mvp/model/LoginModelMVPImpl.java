package com.darko.mvptestingpracticeexample.mvp.model;

import com.darko.mvptestingpracticeexample.LoginRepository;
import com.darko.mvptestingpracticeexample.mvp.LoginMVP;

/**
 * This CLASS implements the MODEL part of the MVP ARCHITECTURE PATTERN
 */
public class LoginModelMVPImpl implements LoginMVP.Model {

    private LoginRepository repository;

    public LoginModelMVPImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String name, String lastName) {
        repository.saveUser(new User(name, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}