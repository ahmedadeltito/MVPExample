package com.ahmedadelsaid.mvpexample.mvp;

/**
 * Created by Ahmed Adel on 24/07/2017.
 */

public interface BasePresenter<V> {

    void attach(V view);

    void detach();

}
