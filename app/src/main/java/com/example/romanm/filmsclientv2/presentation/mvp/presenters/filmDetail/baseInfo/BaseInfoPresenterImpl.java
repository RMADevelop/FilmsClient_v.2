package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.baseInfo;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.BaseInfoView;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManagerImpl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 28.10.2017.
 */
@InjectViewState
public class BaseInfoPresenterImpl extends MvpPresenter<BaseInfoView>{

    private FilmInfoInteractor filmInfoInteractor;

    private SchedulersManager schedulersManager;

    @Inject

    public BaseInfoPresenterImpl(FilmInfoInteractorImpl filmInfoInteractor, SchedulersManagerImpl schedulersManager) {
        this.filmInfoInteractor = filmInfoInteractor;
        this.schedulersManager = schedulersManager;
    }

}
