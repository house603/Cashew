package com.house603.cashew.feature.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.house603.cashew.R;
import com.house603.cashew.base.BaseFragmentActivity;
import com.house603.cashew.feature.commentary.CommentaryFragment;
import com.house603.cashew.feature.commodity.CommodityFragment;

public class CommodityActivity extends BaseFragmentActivity implements CommodityFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity);
        switchContent(R.id.add_commodity_container, CommodityFragment.newInstance());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
