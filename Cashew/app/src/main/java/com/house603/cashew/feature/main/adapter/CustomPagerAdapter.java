package com.house603.cashew.feature.main.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.house603.cashew.R;

/**
 * Created by Admin on 2/18/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    public CustomPagerAdapter(Context context)
    {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        int resId = 0;
        switch (position) {
            case 0:
                resId = R.id.page_one; //pass id of that view to return, Views will be added in XML.
                break;
            case 1:
                resId = R.id.page_two;
                break;
            case 2:
                resId = R.id.page_three;
                break;
        }
        return collection.findViewById(resId); // return selected view.
    }

    @Override
    public int getCount() {
        return 3;// CustomPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
