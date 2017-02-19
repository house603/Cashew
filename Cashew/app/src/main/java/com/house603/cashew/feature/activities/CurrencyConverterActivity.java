package com.house603.cashew.feature.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.house603.cashew.R;
import com.house603.cashew.base.BaseFragmentActivity;
import com.house603.cashew.feature.commentary.CommentaryFragment;
import com.house603.cashew.feature.currency.CurencyConverterFragment;

public class CurrencyConverterActivity extends BaseFragmentActivity implements CurencyConverterFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        switchContent(R.id.add_currency_container, CurencyConverterFragment.newInstance());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
