package com.house603.cashew.feature.main.presenter.view;

import com.house603.cashew.base.presenter.Presenter;

/**
 * Created by Admin on 2/16/2017.
 */

public interface MainPresenter extends Presenter<MainView> {
    void OpenCountryList();
    void OpenCountryList2();
    String getJson(String url);

}
