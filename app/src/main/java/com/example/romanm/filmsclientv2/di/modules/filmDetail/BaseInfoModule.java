package com.example.romanm.filmsclientv2.di.modules.filmDetail;

import com.example.romanm.filmsclientv2.di.scopes.PresenterScope;
import com.example.romanm.filmsclientv2.domain.interactors.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.BaseInfoPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PresentersImpl.BaseInfoPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 15.11.2017.
 */
@Module
public class BaseInfoModule {

    @PresenterScope
    @Provides
    BaseInfoPresenterImpl provideBaseInfoPresenter(FilmInfoInteractorImpl filmInfoInteractor){
        return new BaseInfoPresenterImpl(filmInfoInteractor);
    }
}
