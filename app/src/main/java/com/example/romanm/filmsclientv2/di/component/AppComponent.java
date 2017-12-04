package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.DataModule;
import com.example.romanm.filmsclientv2.di.modules.SchedulersModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        ContextModule.class,
        DataModule.class,
        SchedulersModule.class})

public interface AppComponent {

    ListComponent plusListComponent();

    FilmInfoComponent plusFilmInfoComponent();

    SearchComponent plusSearchComponent();

}
