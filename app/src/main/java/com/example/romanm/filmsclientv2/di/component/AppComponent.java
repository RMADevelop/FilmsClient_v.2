package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.DataModule;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.FilmInfoPresenterImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PremiersPresenterImpl;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.PremiersFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        ContextModule.class,
        DataModule.class})

public interface AppComponent {
    void inject(PremiersPresenterImpl premiersPresenterImpl);

    void inject(FilmInfoPresenterImpl filmInfoPresenterImpl);

    void inject(PremiersFragment premiersFragment);

    FilmInfoComponent plusFilmInfoComponent();

    SearchComponent plusSearchComponent();
}
