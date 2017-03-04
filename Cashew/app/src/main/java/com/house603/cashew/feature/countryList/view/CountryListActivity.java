package com.house603.cashew.feature.countryList.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.house603.cashew.R;
import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;
import com.house603.cashew.di.component.DaggerProjectComponent;
import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.countryList.adapter.CountryListAdapter;
import com.house603.cashew.feature.countryList.adapter.CountryListAdapterListener;
import com.house603.cashew.feature.countryList.presenter.view.CountryListPresenter;
import com.house603.cashew.feature.countryList.presenter.view.CountryListView;
import com.house603.cashew.model.CurrencyModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.R.id.message;
import static com.house603.cashew.R.id.textView1;

public class CountryListActivity extends BaseActionbarActivity implements CountryListView {
    @Inject
    CountryListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    CurrencyModel mCurrencymodel;

    String[] countryNames = new String[]{
            "India", "Australia", "China", "Indonesia", "Japan", "Newzealand", "Russia", "South Korea"
    };
    int[] flagId = new int[]{
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
//            R.mipmap.flag_india, R.drawable.flag_australia, R.drawable.flag_china, R.drawable.flag_indonesia,
//            R.drawable.flag_japan, R.drawable.flag_newzealand, R.drawable.flag_russia, R.drawable.flag_southkorea
    };
    String[] capital = new String[]{
            "New Delhi", "Sydney", "Beijing", "Jakarta", "Tokyo", "Wellington", "Moscow", "Seoul"
    };

    String[] currency = new String[]{
            "Rupee", "Dollar", "Renminbi", "Rupiah",
            "Yen", "Dollar", "Ruble", "Won"
    };
    private LinearLayoutManager mLayoutManager;
    CountryListAdapter mAdapter;
    private List<CurrencyModel>mCountryList;
    private int id_flag1;
    int id;

    @Override
    public void initView() {
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_country);
        mRecyclerView.setLayoutManager(mLayoutManager);

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
        setContentView(R.layout.activity_country_list);
        initView();
        injectInjector();
    }


    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder().projectModule(new ProjectModule(this)).build().inject(this);
        mPresenter.setView(this);
        Intent intent = getIntent();
        if (intent.getStringExtra("flag1") != null) {
            id_flag1 = intent.getIntExtra("id", 0);
            if (intent.getStringExtra("flag1").equals("flag1Country")) {
                id_flag1 = id;

            }
        } else if (intent.getStringExtra("flag2") != null) {
                id_flag1 = intent.getIntExtra("id", 0);

            if (intent.getStringExtra("flag2").equals("flag2Country")) {
                id_flag1 = id;

            }

            }
        mCountryList = new ArrayList<>();
        for (int i = 0; i < countryNames.length; i++) {
            CurrencyModel country = new CurrencyModel();
            country.setmCountryName(countryNames[i]);
            country.setFlag(flagId[i]);
            country.setmCurrencyiso(currency[i]);
            mCountryList.add(country);

            for(CurrencyModel model : mCountryList){
                setCurrencyModel(model);
            }

            mAdapter = new CountryListAdapter(getContext(), mCountryList, new CountryListAdapterListener() {
                @Override
                public void ItemClick(CurrencyModel model, int p) {
                    if (id==5){
                        Intent intent=new Intent();
                        intent.putExtra("map",model.getFlag());
                        intent.putExtra("name", model.getmCountryName());
                        intent.putExtra("iso", model.getmCurrencyiso());
                        setResult(2,intent);
                        finish();
                    }else{
                        Intent intent=new Intent();
                        intent.putExtra("map",model.getFlag());
                        intent.putExtra("name", model.getmCountryName());
                        intent.putExtra("iso", model.getmCurrencyiso());
                        setResult(3,intent);
                        finish();
                    }


                }


        });
            mRecyclerView.setAdapter(mAdapter);


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
    public void setCurrencyModel(CurrencyModel model) {
        this.mCurrencymodel = model;

    }
}
