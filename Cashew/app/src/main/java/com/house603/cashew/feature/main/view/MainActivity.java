package com.house603.cashew.feature.main.view;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;


import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.commentary.CommentaryFragment;
import com.house603.cashew.feature.commodity.CommodityFragment;
import com.house603.cashew.feature.currency.CurencyConverterFragment;
import com.house603.cashew.feature.main.adapter.PageAdapter;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActionbarActivity implements MainView, CurencyConverterFragment.OnFragmentInteractionListener,
        CommentaryFragment.OnFragmentInteractionListener,CommodityFragment.OnFragmentInteractionListener {
@Inject
    MainPresenter mPresenter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    public void initView() {

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

        initTabar();
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
        mViewPager = (ViewPager) findViewById(R.id.container);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),getApplicationContext()));
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    public void onFragmentInteraction(Uri uri) {

    }
}
