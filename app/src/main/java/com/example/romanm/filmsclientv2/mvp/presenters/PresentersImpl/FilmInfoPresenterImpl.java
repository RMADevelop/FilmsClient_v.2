package com.example.romanm.filmsclientv2.mvp.presenters.PresentersImpl;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.mvp.presenters.FilmInfoPresenter;
import com.example.romanm.filmsclientv2.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class FilmInfoPresenterImpl extends MvpPresenter<FilmInfoView> implements FilmInfoPresenter {

    @Inject
    Repository repository;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public FilmInfoPresenterImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void loadFilm(int idFilm) {
        compositeDisposable.add(repository.getFilmInfo(idFilm)
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

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        compositeDisposable.dispose();
    }
}
