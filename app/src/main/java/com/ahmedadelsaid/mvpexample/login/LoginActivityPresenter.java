package com.ahmedadelsaid.mvpexample.login;

import android.support.annotation.Nullable;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void attach(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            User user = view.getUser();
            if (user.getFirstName().trim().equals("") || user.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(user);
                view.showUserSavedMessage(model.getUser());
            }
        }
    }

    @Override
    public void getCurrentUser() {
        if (view != null) {
            User user = model.getUser();
            if (user == null) {
                view.showUserNotAvailable();
            } else {
                view.setUser(user);
            }
        }
    }
}
