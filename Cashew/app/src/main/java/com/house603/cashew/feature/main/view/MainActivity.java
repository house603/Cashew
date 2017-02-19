package com.house603.cashew.feature.main.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.house603.cashew.R;
import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;

import com.house603.cashew.di.component.DaggerProjectComponent;
import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.main.adapter.CustomPagerAdapter;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActionbarActivity implements MainView {
@Inject
    MainPresenter mPresenter;
    private ViewPager mViewPager;

    @Override
    public void initView() {
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
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
        initView();
        injectInjector();

    }


    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder().projectModule(new ProjectModule(this)).build().inject(this);
        mPresenter.setView(this);
        mViewPager.setAdapter(new CustomPagerAdapter(this));
        mViewPager.setOffscreenPageLimit(3);

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
}
