package com.house603.cashew.feature.main.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;


import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;


import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActionbarActivity implements MainView {
@Inject
    MainPresenter mPresenter;
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
        initView();
        injectInjector();
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
        viewPager.setOffscreenPageLimit(3);
    }
    public class CustomPagerAdapter extends PagerAdapter
    {
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
            return findViewById(resId); // return selected view.
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

    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder().projectModule(new ProjectModule(this)).build().inject(this);
        mPresenter.setView(this);

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
