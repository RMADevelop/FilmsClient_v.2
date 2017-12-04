package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.baseInfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.BaseInfoView;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;
import com.example.romanm.filmsclientv2.utils.Schedulers.AppSchedulers;

import javax.inject.Inject;

/**
 * Created by RomanM on 28.10.2017.
 */
@InjectViewState
public class BaseInfoPresenter extends MvpPresenter<BaseInfoView>{

    private FilmInfoInteractor filmInfoInteractor;

    private SchedulersManager schedulersManager;

    @Inject

    public BaseInfoPresenter(FilmInfoInteractorImpl filmInfoInteractor, SchedulersManager schedulersManager) {
        this.filmInfoInteractor = filmInfoInteractor;
        this.schedulersManager = schedulersManager;
    }

}
