package com.house603.cashew.model;

import java.io.Serializable;

/**
 * Created by Admin on 2/25/2017.
 */

public class CurrencyModel implements Serializable {
    private String mCountryName, mCurrencyiso;
    private int flag;

    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    public String getmCurrencyiso() {
        return mCurrencyiso;
    }

    public void setmCurrencyiso(String mCurrencyiso) {
        this.mCurrencyiso = mCurrencyiso;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
