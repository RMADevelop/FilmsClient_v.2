package com.example.romanm.filmsclientv2.di.modules.filmDetail;

import com.example.romanm.filmsclientv2.di.scopes.InteractorScope;
import com.example.romanm.filmsclientv2.domain.interactors.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.FilmInfoPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PresentersImpl.FilmInfoPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 15.11.2017.
 */
@Module
public class FilmDetailModule {

//    @InteractorScope
//    @Provides
//    FilmInfoPresenterImpl provideFilmInfoPresenter(FilmInfoInteractorImpl filmInfoInteractor) {
//        return new FilmInfoPresenterImpl(filmInfoInteractor);
//    }
}
