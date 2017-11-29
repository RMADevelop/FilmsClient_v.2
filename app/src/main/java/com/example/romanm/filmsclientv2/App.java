package com.example.romanm.filmsclientv2;

import android.app.Application;

import com.example.romanm.filmsclientv2.di.component.AppComponent;
import com.example.romanm.filmsclientv2.di.component.BaseInfoComponent;
import com.example.romanm.filmsclientv2.di.component.DaggerAppComponent;
import com.example.romanm.filmsclientv2.di.component.FilmInfoComponent;
import com.example.romanm.filmsclientv2.di.component.SearchComponent;
import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.DataModule;

import static com.example.romanm.filmsclientv2.utils.Const.URL_TMDb;

/**
 * Created by RomanM on 25.10.2017.
 */

public class App extends Application {

    private static AppComponent appComponent;

    private static FilmInfoComponent filmInfoComponent;

    private static BaseInfoComponent baseInfoComponent;

    private static SearchComponent searchComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule(URL_TMDb))
                .build();


    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static FilmInfoComponent plusFilmInfoComponent() {
        if (filmInfoComponent == null) {
            filmInfoComponent = appComponent.plusFilmInfoComponent();
        }

        return filmInfoComponent;
    }

    public static BaseInfoComponent plusBaseInfoComponent() {
        if (baseInfoComponent == null) {
            baseInfoComponent = filmInfoComponent.plusBaseInfoComponent();
        }

        return baseInfoComponent;
    }

    public static SearchComponent plusSearchComponent() {
        if (searchComponent == null) {
            searchComponent = appComponent.plusSearchComponent();
        }
        return searchComponent;
    }

    public static void clearFilmInfoComponent() {
        filmInfoComponent = null;
    }

    public static void clearBaseInfoComponent() {
        baseInfoComponent = null;
    }

    public static void clearSearchComponent() {
        searchComponent = null;
    }


}
