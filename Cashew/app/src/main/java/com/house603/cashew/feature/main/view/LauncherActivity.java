package com.house603.cashew.feature.main.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import com.house603.cashew.R;
import com.house603.cashew.feature.main.Utils.HttpUtils;
import com.house603.cashew.feature.main.view.MainActivity;
import com.house603.cashew.feature.main.view.ServerCallback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.house603.cashew.feature.main.view.MainActivity;
import com.house603.cashew.feature.main.view.ServerCallback;


/**
 * Created by admin on 0023, 2/23/2016.
 */
public class LauncherActivity extends FragmentActivity implements ServerCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ImageView imageView = (ImageView)findViewById(R.id.logoImage);
        //when the logo is ready this would work.
        imageView.setImageResource(R.mipmap.ic_launcher);

        initData();

    }

    private void initData() {
        final LauncherActivity ctx = this;
        HttpUtils.checkNetworkAvailable(this, new Runnable() {
            @Override
            public void run() { //Failed
                onDisconnect();
            }
        }, new Runnable() {
            @Override
            public void run() { //Success
            //There would be a try and catch error here to load from a URL of the data
                //we will make use of the Unextected error code here.
                gotoMain();
            }
        });
    }

    private void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onCompleted(String json) {

            gotoMain();
    }

    @Override
    public void onFailed(int code) {
        onDisconnect();
    }

    private void onDisconnect() {
        final LauncherActivity activity = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(activity).setIcon(R.mipmap.warning).setMessage(R.string.disconnected)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.finish();
                            }
                        }).setCancelable(false).create().show();
            }
        });
    }
    //This code would be implemented later on to detect any error that might occur later.
   /* private void onUnexpectedError() {
        final LauncherActivity activity = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(activity).setIcon(R.mipmap.warning).setMessage(R.string.unexpected_error)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.finish();
                            }
                        }).setCancelable(false).create().show();
            }
        });
    }*/
}
