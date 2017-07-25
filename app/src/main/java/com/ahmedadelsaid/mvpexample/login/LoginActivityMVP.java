package com.ahmedadelsaid.mvpexample.login;

import com.ahmedadelsaid.mvpexample.mvp.BasePresenter;
import com.ahmedadelsaid.mvpexample.mvp.BaseView;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public interface LoginActivityMVP {

    interface View extends BaseView {

        User getUser();

        void setUser(User user);

        void showUserSavedMessage(User user);

        void showUserNotAvailable();

    }

    interface Presenter extends BasePresenter<View> {

        void loginButtonClicked();

        void getCurrentUser();

    }

    interface Model {

        void createUser(User user);

        User getUser();

    }
}
