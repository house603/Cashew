package com.house603.cashew.feature.main.view;

/**
 * Created by JEROFAD on 2/17/2017.
 */
public interface ServerCallback {
    void onCompleted(String result);
    void onFailed(int code);

}
