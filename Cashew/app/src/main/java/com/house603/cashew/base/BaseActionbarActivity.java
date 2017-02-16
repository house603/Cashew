package com.house603.cashew.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;

import com.house603.cashew.base.presenter.Presenter;


/**
 * Created by Enny on 29/11/2016.
 */
public abstract class BaseActionbarActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    private FragmentManager mFragmentManager;
    public View mRoot;

    public abstract void initView();

    public abstract void initModel();

    public abstract Presenter getPresenter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTransaction();
        mFragmentManager = getSupportFragmentManager();

    }

    /**
     * Switch content tab
     *
     * @param fragment
     */
    public void switchContent(int contentId, Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(contentId, fragment);
        transaction.commit();
    }

    private void initTransaction() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Transition enterTrans = new Explode();
            getWindow().setEnterTransition(enterTrans);
        }
    }


    @Override
    public void onClick(View v) {

    }

    abstract protected void injectInjector() ;


    @Override
    public void onResume() {
        super.onResume();

        if (null != getPresenter()) {
            getPresenter().resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != getPresenter()) {
            getPresenter().pause();
        }
    }

    @Override
    public void onDestroy() {
        if (null != getPresenter()) {
            getPresenter().destroy();
        }
        super.onDestroy();
    }

}
