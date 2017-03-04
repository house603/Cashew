package com.house603.cashew.feature.main.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.house603.cashew.R;
import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;


import com.house603.cashew.di.component.DaggerProjectComponent;
import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.commentary.CommentaryFragment;
import com.house603.cashew.feature.commodity.CommodityFragment;
import com.house603.cashew.feature.currency.CurencyConverterFragment;
import com.house603.cashew.feature.main.adapter.PageAdapter;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActionbarActivity implements MainView {
    @Inject
    MainPresenter mPresenter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private LinearLayout mCountryUp;
    private LinearLayout mCountryDown;
    int flag;
    String country;
    String iso;
    private ImageView mFlagCountryUp;
    private ImageView mFlagCountryDown;
    private TextView mCountryNameUp;
    private TextView mCountryNameDown;

    @Override
    public void initView() {
        mCountryUp = (LinearLayout) findViewById(R.id.ln_country1);
        mCountryDown = (LinearLayout) findViewById(R.id.ln_country2);
        mFlagCountryUp = (ImageView) findViewById(R.id.img_country1);
        mFlagCountryDown = (ImageView) findViewById(R.id.img_country2);
        mCountryNameUp = (TextView) findViewById(R.id.txt_country1);
        mCountryNameDown = (TextView) findViewById(R.id.txt_country2);
        mCountryUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.OpenCountryList();
            }
        });
        mCountryDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.OpenCountryList2();
            }
        });

    }

    @Override
    public void initModel() {

    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  initTabar();
        initView();
        injectInjector();
        initActionbar();


    }


    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder().projectModule(new ProjectModule(this)).build().inject(this);
        mPresenter.setView(this);

    }

    private void initTabar() {
        // mViewPager = (ViewPager) findViewById(R.id.container);
        // tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), getApplicationContext()));
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    private void initActionbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) {
            country = data.getStringExtra("name");
            flag = data.getIntExtra("map", 1);
            iso = data.getStringExtra("iso");
            mCountryNameUp.setText(iso);
            mFlagCountryUp.setImageResource(flag);

        }else if(requestCode == 3){
            country = data.getStringExtra("name");
            flag = data.getIntExtra("map", 1);
            iso = data.getStringExtra("iso");
            mCountryNameDown.setText(iso);
            mFlagCountryDown.setImageResource(flag);

        }
    }


    @Override
    public void showLineLoading() {

    }

    @Override
    public void hideLineLoading() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    public Activity getActivity() {
        return this;
    }
}
