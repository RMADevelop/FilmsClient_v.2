package com.example.romanm.filmsclientv2;

import android.app.Application;

import com.example.romanm.filmsclientv2.di.component.AppComponent;
import com.example.romanm.filmsclientv2.di.component.DaggerAppComponent;
import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.RemoteDataModule;

import static com.example.romanm.filmsclientv2.utils.Const.URL_TMDb;

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
                .remoteDataModule(new RemoteDataModule(URL_TMDb))
                .build();


    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

}
