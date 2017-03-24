package com.house603.cashew.feature.main.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import com.house603.cashew.R;
import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;

import com.house603.cashew.di.component.DaggerProjectComponent;
import com.house603.cashew.di.module.ProjectModule;

import com.house603.cashew.feature.main.adapter.PageAdapter;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;
import com.house603.cashew.feature.main.presenter.view.MainView;
import com.house603.cashew.feature.main.retrofit.CurrencyExchangeService;
import com.house603.cashew.model.CurrencyModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.IOException;

import javax.inject.Inject;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.loopj.android.http.*;

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
    public int to;
    public int from;
    public String s;
    String isoUp, isoDown;
    private EditText mEdCountryUp;
    private EditText mEdCountryDown;
    private Button mCalculate;
    Double IsoUpRate, IsoDownRate;
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=4691eb36ebce42a9ac5db9d977231aed";
    private String mValueCountryUp;
    private Double mDoubValueCountryUp;
    JSONObject ratesObject;
    JSONObject jsonObj = null;
    private String mValueCountryDown;
    private Double mDoubValueCountryDown;

    @Override
    public void initView() {
        mCountryUp = (LinearLayout) findViewById(R.id.ln_country1);
        mCountryDown = (LinearLayout) findViewById(R.id.ln_country2);
        mFlagCountryUp = (ImageView) findViewById(R.id.img_country1);
        mFlagCountryDown = (ImageView) findViewById(R.id.img_country2);
        mCountryNameUp = (TextView) findViewById(R.id.txt_country1);
        mCountryNameDown = (TextView) findViewById(R.id.txt_country2);
        mEdCountryUp = (EditText) findViewById(R.id.edt_country_up);
        mEdCountryDown = (EditText) findViewById(R.id.edt_country_down);
        mCalculate = (Button) findViewById(R.id.btn_cal);

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
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValueToString();
                if (isoUp != null && isoDown != null){
                    try {
                        IsoUpRate= ratesObject.getDouble(isoUp);
                        IsoDownRate = ratesObject.getDouble(isoDown);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast.makeText(getContext(),"Pick country",Toast.LENGTH_SHORT).show();
                }

                if (!mValueCountryUp.isEmpty()& mValueCountryDown.isEmpty()){
                    mDoubValueCountryUp = Double.valueOf(mValueCountryUp);
                   Double ans1ConVert = mDoubValueCountryUp/IsoUpRate;
                    Double ans = ans1ConVert*IsoDownRate;
                    String finalAns = String.valueOf(ans);
                    mEdCountryDown.setText(finalAns);

                }else if (!mValueCountryDown.isEmpty() & mValueCountryUp.isEmpty()){
                    mDoubValueCountryDown = Double.valueOf(mValueCountryDown);
                    Double ans1ConVert = mDoubValueCountryDown/IsoDownRate;
                    Double ans = ans1ConVert*IsoUpRate;
                    String finalAns = String.valueOf(ans);
                    mEdCountryUp.setText(finalAns);
                }else if (!mValueCountryUp.isEmpty() & !mValueCountryDown.isEmpty()){
                    Toast.makeText(getContext(),"Clear screen",Toast.LENGTH_LONG).show();
                }

            }



        });


    }
    private  void setValueToString(){
        mValueCountryUp = mEdCountryUp.getText().toString();
        mValueCountryDown = mEdCountryDown.getText().toString();

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
        initActionbar();
    }


    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder().projectModule(new ProjectModule(this)).build().inject(this);
        mPresenter.setView(this);
        setValueToString();
        loadCurrencyExchangeData();


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
    @Override
    protected void onStart() {
        super.onStart();
        loadCurrencyExchangeData();
    }
    private void initActionbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void loadCurrencyExchangeData(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(API_URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String decodedData = new String(responseBody);
                Log.d("result", "" + decodedData);

                try {
                    jsonObj = new JSONObject(decodedData);
                    ratesObject = jsonObj.getJSONObject("rates");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

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
            isoUp = mCountryNameUp.getText().toString();

        } else if (requestCode == 3) {
            country = data.getStringExtra("name");
            flag = data.getIntExtra("map", 1);
            iso = data.getStringExtra("iso");
            mCountryNameDown.setText(iso);
            mFlagCountryDown.setImageResource(flag);
            isoDown = mCountryNameDown.getText().toString();


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
