package com.house603.cashew.feature.countryList.presenter.presenterImpl;

import android.support.annotation.NonNull;

import com.house603.cashew.feature.countryList.presenter.view.CountryListPresenter;
import com.house603.cashew.feature.countryList.presenter.view.CountryListView;

/**
 * Created by Admin on 2/25/2017.
 */

public class CountryListPresenterImpl implements CountryListPresenter {
    CountryListView mView;
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
    public void setView(@NonNull CountryListView view) {
        this.mView = view;

    }
}
