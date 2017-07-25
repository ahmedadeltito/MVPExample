package com.ahmedadelsaid.mvpexample.root;

import android.app.Application;

import com.ahmedadelsaid.mvpexample.login.LoginModule;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
