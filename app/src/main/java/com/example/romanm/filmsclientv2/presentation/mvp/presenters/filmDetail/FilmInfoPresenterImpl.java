package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class FilmInfoPresenterImpl extends MvpPresenter<FilmInfoView> implements FilmInfoPresenter {

    FilmInfoInteractorImpl filmInfoInteractor;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public FilmInfoPresenterImpl(FilmInfoInteractorImpl filmInfoInteractor) {
        this.filmInfoInteractor = filmInfoInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    @Override
    public void loadFilm(int idFilm) {
        Log.d("DSFDDSFDFS", "loadFilm() called with: idFilm = [" + idFilm + "]");
        compositeDisposable.add(filmInfoInteractor.getFilmDetail(idFilm)
                .toSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<FilmDetail>() {
                    @Override
                    public void onSuccess(FilmDetail filmDetail) {
                        getViewState().setFilmInfo(filmDetail);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                }));
    }

}
