package com.example.romanm.filmsclientv2;

import android.app.Application;

import com.example.romanm.filmsclientv2.di.component.AppComponent;
import com.example.romanm.filmsclientv2.di.component.DaggerAppComponent;
import com.example.romanm.filmsclientv2.di.modules.ContextModule;

/**
 * Created by RomanM on 25.10.2017.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();


    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

}
