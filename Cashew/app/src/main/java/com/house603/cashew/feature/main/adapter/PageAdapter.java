package com.house603.cashew.feature.main.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.house603.cashew.feature.commentary.CommentaryFragment;
import com.house603.cashew.feature.commodity.CommodityFragment;
import com.house603.cashew.feature.currency.CurencyConverterFragment;

/**
 * Created by Admin on 2/18/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private String fragments [] = {"CURRENCYCONVERTER","COMMODITY", "COMMENTARY"};

    public PageAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CurencyConverterFragment();
            case 1:
                return new CommodityFragment();
            case 2:
                return new CommentaryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}


