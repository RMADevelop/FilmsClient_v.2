package com.example.romanm.filmsclientv2.di.modules.filmDetail;

import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.baseInfo.BaseInfoPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.baseInfo.BaseInfoPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 15.11.2017.
 */
@Module
public class BaseInfoModule {

    @Provides
    BaseInfoPresenterImpl provideBaseInfoPresenter(FilmInfoInteractorImpl filmInfoInteractor){
        return new BaseInfoPresenterImpl(filmInfoInteractor);
    }
}
