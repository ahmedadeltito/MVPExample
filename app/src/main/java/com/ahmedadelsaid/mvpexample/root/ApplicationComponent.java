package com.ahmedadelsaid.mvpexample.root;

import com.ahmedadelsaid.mvpexample.login.LoginActivityView;
import com.ahmedadelsaid.mvpexample.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivityView baseActivity);

}
