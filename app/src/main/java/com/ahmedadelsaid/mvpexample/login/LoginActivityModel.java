package com.ahmedadelsaid.mvpexample.login;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository loginRepository;

    public LoginActivityModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void createUser(User user) {
        loginRepository.setUser(user);
    }

    @Override
    public User getUser() {
        return loginRepository.getUser();
    }
}
