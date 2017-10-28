package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.ContextModule;
import com.example.romanm.filmsclientv2.di.modules.LocalDataModule;
import com.example.romanm.filmsclientv2.di.modules.RemoteDataModule;
import com.example.romanm.filmsclientv2.di.modules.RepositoryModule;
import com.example.romanm.filmsclientv2.mvp.presenters.PresentersImpl.FilmInfoPresenterImpl;
import com.example.romanm.filmsclientv2.mvp.presenters.PresentersImpl.PremiersPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        ContextModule.class,
        RepositoryModule.class,
        LocalDataModule.class,
        RemoteDataModule.class})

public interface AppComponent {
    void inject(PremiersPresenterImpl premiersPresenterImpl);

    void inject(FilmInfoPresenterImpl filmInfoPresenterImpl);
}
