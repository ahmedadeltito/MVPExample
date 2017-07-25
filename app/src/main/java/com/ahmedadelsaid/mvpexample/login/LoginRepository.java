package com.ahmedadelsaid.mvpexample.login;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public interface LoginRepository {

    User getUser();

    void setUser(User user);

}
