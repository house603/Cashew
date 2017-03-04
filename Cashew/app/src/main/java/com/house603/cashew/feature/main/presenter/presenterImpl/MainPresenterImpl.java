package com.house603.cashew.feature.main.presenter.presenterImpl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.house603.cashew.feature.countryList.view.CountryListActivity;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;
import com.house603.cashew.feature.main.view.MainActivity;

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

    @Override
    public void OpenCountryList() {
        Intent intent=new Intent(mView.getContext(),CountryListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("flag1", "flag1Country");
        bundle.putInt("id", 5);
        intent.putExtras(bundle);
        mView.getActivity().startActivityForResult(intent, 2);// Activity is started with requestCode 2
//        Intent mIntent  = new Intent(mView.getContext(), CountryListActivity.class);
//        mView.getContext().startActivity(mIntent);
    }

    @Override
    public void OpenCountryList2() {
        Intent intent=new Intent(mView.getContext(),CountryListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("flag2", "flag2Country");
        bundle.putInt("id", 6);
        intent.putExtras(bundle);
        mView.getActivity().startActivityForResult(intent, 3);
    }
}
