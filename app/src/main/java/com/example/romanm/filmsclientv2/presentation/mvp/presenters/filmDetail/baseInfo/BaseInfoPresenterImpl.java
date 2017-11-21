package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.baseInfo;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.BaseInfoView;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 28.10.2017.
 */
@InjectViewState
public class BaseInfoPresenterImpl extends MvpPresenter<BaseInfoView> implements BaseInfoPresenter {

    private FilmInfoInteractorImpl filmInfoInteractor;

    public BaseInfoPresenterImpl(FilmInfoInteractorImpl filmInfoInteractor) {
        this.filmInfoInteractor = filmInfoInteractor;
        Log.d("dssdfsdfsfsdfsd", "BaseInfoPresenterImpl() called with: filmInfoInteractor = [" + this + "]");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void getFilmDetail(int idFilm) {
//        Log.v("filmId", "idFilm   " + idFilm);
//        filmInfoInteractor.getFilmDetail(idFilm)
//                .toSingle()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSingleObserver<FilmDetail>() {
//                    @Override
//                    public void onSuccess(FilmDetail filmDetail) {
//                        getViewState().setInfo(filmDetail);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//                });
    }
}
