package com.example.romanm.filmsclientv2.presentation.mvp.presenters.PresentersImpl;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.domain.interactors.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.BaseInfoPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.views.BaseInfoView;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 28.10.2017.
 */
@InjectViewState
public class BaseInfoPresenterImpl extends MvpPresenter<BaseInfoView> implements BaseInfoPresenter {

    private FilmInfoInteractorImpl filmInfoInteractor;

    @Inject
    public BaseInfoPresenterImpl(FilmInfoInteractorImpl filmInfoInteractor) {
        this.filmInfoInteractor = filmInfoInteractor;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getFilmDetail(int idFilm) {
        Log.v("filmId", "idFilm   " + idFilm);
        filmInfoInteractor.getForChild()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<FilmDetail>() {
                    @Override
                    public void onSuccess(FilmDetail filmDetail) {
                        getViewState().setInfo(filmDetail);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
