package com.example.romanm.filmsclientv2.di.modules;

import com.example.romanm.filmsclientv2.di.scopes.FilmInfoScope;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by RomanM on 30.11.2017.
 */


@Module
public abstract class FilmDetailModule {

    @FilmInfoScope
    @Binds
    public abstract FilmInfoInteractor provideFilmInfoInteractor (FilmInfoInteractorImpl filmInfoInteractor);

}
