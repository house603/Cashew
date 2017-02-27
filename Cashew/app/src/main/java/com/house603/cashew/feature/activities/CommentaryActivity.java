package com.house603.cashew.feature.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.house603.cashew.R;
import com.house603.cashew.base.BaseFragmentActivity;
import com.house603.cashew.feature.commentary.CommentaryFragment;

public class CommentaryActivity extends BaseFragmentActivity implements CommentaryFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentary);
        switchContent(R.id.add_commentary_container, CommentaryFragment.newInstance());
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
