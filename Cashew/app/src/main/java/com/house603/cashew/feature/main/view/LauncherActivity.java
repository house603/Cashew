package atggroup.tk.iCool.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import atggroup.tk.iCool.R;
import atggroup.tk.iCool.intf.ServerCallback;
import atggroup.tk.iCool.manager.AuthManager;
import atggroup.tk.iCool.manager.ServerManager;
import atggroup.tk.iCool.manager.TopicManager;
import atggroup.tk.iCool.model.Topic;
import atggroup.tk.iCool.utils.HttpUtils;
import atggroup.tk.iCool.utils.URLUtils;

/**
 * Created by admin on 0023, 2/23/2016.
 */
public class LauncherActivity extends FragmentActivity implements ServerCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
        ImageView imageView = (ImageView)findViewById(R.id.logoImage);
        imageView.setImageResource(R.mipmap.logo);
        //Initialize data
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
                //Load topics
                try {
                    URL urlTopic = URLUtils.getTopicsURL(ctx);
                    new ServerManager(urlTopic, ctx).start();
                } catch (MalformedURLException e) {
                    onUnexpectedError();
                }
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
        TopicManager topicManager = TopicManager.getInstance();
        topicManager.initialize(json);
        List<Topic> lstTopics = topicManager.getTopics();
        if (lstTopics == null || lstTopics.size() == 0) {
            onDisconnect();
        }
        else {
            gotoMain();
        }
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

    private void onUnexpectedError() {
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
    }
}
