package com.example.romanm.filmsclientv2.di.modules.filmDetail;

import com.example.romanm.filmsclientv2.di.scopes.DetailScope;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmDetailMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.FilmInfoPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 15.11.2017.
 */
@Module
public class FilmDetailModule {

    @DetailScope
    @Provides
    FilmInfoPresenterImpl provideFilmInfoPresenter(FilmInfoInteractorImpl filmInfoInteractor, FilmDetailMapperPresentation mapper) {
        return new FilmInfoPresenterImpl(filmInfoInteractor,mapper);
    }
}
