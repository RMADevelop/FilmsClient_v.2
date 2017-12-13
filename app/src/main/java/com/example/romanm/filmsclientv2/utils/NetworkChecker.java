package com.example.romanm.filmsclientv2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by RomanM on 13.12.2017.
 */

@Singleton
public class NetworkChecker {

    private final Context applicationContext;

    @Inject
    public NetworkChecker(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
