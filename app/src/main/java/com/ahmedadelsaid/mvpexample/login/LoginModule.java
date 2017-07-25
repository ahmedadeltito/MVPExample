package com.ahmedadelsaid.mvpexample.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository loginRepository) {
        return new LoginActivityModel(loginRepository);
    }

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryLoginRepository();
    }

}
