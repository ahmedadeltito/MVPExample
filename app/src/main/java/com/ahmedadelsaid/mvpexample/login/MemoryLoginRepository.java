package com.ahmedadelsaid.mvpexample.login;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public class MemoryLoginRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {

        if (user == null) {
            User user = new User("Ahmed", "Adel");
            user.setId(0);
            return user;
        }
        return user;
    }

    @Override
    public void setUser(User user) {
        if (user == null)
            user = getUser();
        this.user = user;
    }
}
