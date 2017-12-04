package com.example.romanm.filmsclientv2;

import android.app.Application;

import com.example.romanm.filmsclientv2.di.ComponentManager;

/**
 * Created by RomanM on 25.10.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ComponentManager.getInstance().initComponentManager(this);

    }
}
