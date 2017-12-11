package com.example.romanm.filmsclientv2.di;

import android.app.Application;
import android.content.Context;

import com.example.romanm.filmsclientv2.di.component.AppComponent;
import com.example.romanm.filmsclientv2.di.component.DaggerAppComponent;
import com.example.romanm.filmsclientv2.di.component.FilmInfoComponent;
import com.example.romanm.filmsclientv2.di.component.ListComponent;
import com.example.romanm.filmsclientv2.di.component.SearchComponent;
import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.DataModule;

import static com.example.romanm.filmsclientv2.utils.Const.URL_TMDb;

/**
 * Created by RomanM on 02.12.2017.
 */

public class ComponentManager {

    private static ComponentManager instance;

    private AppComponent appComponent;

    public static ComponentManager getInstance() {
        if (instance == null) {
            instance = new ComponentManager();
        }
        return instance;
    }

    private ComponentManager() {
    }

    public void initComponentManager(Application application) {
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(application))
                .dataModule(new DataModule(URL_TMDb))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public FilmInfoComponent getFilmInfoComponent() {
        return appComponent.plusFilmInfoComponent();
    }

    public ListComponent createListComponent() {

        return appComponent.plusListComponent();
    }

    public SearchComponent createSearchComponent() {

        return appComponent.plusSearchComponent();
    }
}
