package com.house603.cashew.feature.main.Utils;

import android.content.Context;
import android.net.ConnectivityManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 0023, 2/23/2016.
 */
public class HttpUtils {
    public static String getDataFromUrl(URL url, boolean isTest) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection)url.openConnection();
            if (isTest) {
                connection.setConnectTimeout(Constants.TEST_CONNECTION_TIMEOUT);
                connection.setReadTimeout(Constants.TEST_INTERNET_READ_TIMEOUT);
            }
            else {
                connection.setConnectTimeout(Constants.CONNECTION_TIMEOUT);
                connection.setReadTimeout(Constants.INTERNET_READ_TIMEOUT);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                sb.append(strLine);
            }
            bufferedReader.close();
        }
        finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return sb.toString();
    }

    public static void checkNetworkAvailable(final Context context, final Runnable runOnFailed, final Runnable runOnSuccess) {
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isConnected = connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        if (isConnected) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL("http://www.google.com");
                        String result = HttpUtils.getDataFromUrl(url, true);
                        if (result != null && result.length() > 0) {
                            if (runOnSuccess != null) {
                                runOnSuccess.run();
                            }
                        }
                        else {
                            if (runOnFailed != null) {
                                runOnFailed.run();
                            }
                        }
                    } catch (MalformedURLException e) {
                        if (runOnFailed != null) {
                            runOnFailed.run();
                        }
                    } catch (IOException e) {
                        if (runOnFailed != null) {
                            runOnFailed.run();
                        }
                    }
                }
            }).start();
        }
        else {
            if (runOnFailed != null) {
                runOnFailed.run();
            }
        }
    }
}