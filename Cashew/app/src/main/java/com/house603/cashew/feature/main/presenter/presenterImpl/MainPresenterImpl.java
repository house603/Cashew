package com.house603.cashew.feature.main.presenter.presenterImpl;

import android.support.annotation.NonNull;

import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;

/**
 * Created by Admin on 2/16/2017.
 */

public class MainPresenterImpl implements MainPresenter {
    MainView mView;
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setView(@NonNull MainView view) {
        this.mView = view;

    }
}
