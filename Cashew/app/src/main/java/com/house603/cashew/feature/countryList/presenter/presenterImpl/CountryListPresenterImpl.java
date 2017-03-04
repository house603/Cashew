package com.house603.cashew.feature.countryList.presenter.presenterImpl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.house603.cashew.feature.countryList.presenter.view.CountryListPresenter;
import com.house603.cashew.feature.countryList.presenter.view.CountryListView;
import com.house603.cashew.feature.main.view.MainActivity;
import com.house603.cashew.model.CurrencyModel;

/**
 * Created by Admin on 2/25/2017.
 */

public class CountryListPresenterImpl implements CountryListPresenter {
    CountryListView mView;
    public static final int REQUEST_CODE = 100;
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

    @Override
    public void sendValueCountryUp(CurrencyModel model) {
        Intent mIntent = new Intent(mView.getContext(), MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("send", "countryup");
        bundle.putString("name", model.getmCountryName());
        bundle.putString("iso", model.getmCurrencyiso());
//        bundle.putString("time", model.getmReminderTime());
//        bundle.putString("phone", model.getmReminderPhoneNumber());
        mIntent.putExtras(bundle);
    //    mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        mView.getContext().startActivity(mIntent);
    }



    public static void start (Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivityForResult(intent, REQUEST_CODE);
    }
}
