package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmDetailMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class FilmInfoPresenterImpl extends MvpPresenter<FilmInfoView> implements FilmInfoPresenter {

    private FilmInfoInteractorImpl filmInfoInteractor;

    private FilmDetailMapperPresentation mapper;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public FilmInfoPresenterImpl(FilmInfoInteractorImpl filmInfoInteractor, FilmDetailMapperPresentation mapper) {
        this.filmInfoInteractor = filmInfoInteractor;
        this.mapper = mapper;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    @Override
    public void loadFilm(int idFilm) {
        Log.d("DSFDDSFDFS", "loadFilm() called with: idFilm = [" + idFilm + "]");
        filmInfoInteractor.getFilmDetail(idFilm)
                .toSingle()
                .map(mapper::transform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<FilmDetailPresentation>() {
                    @Override
                    public void onSuccess(FilmDetailPresentation filmDetailPresentation) {
                        getViewState().setFilmInfo(filmDetailPresentation);
                        getViewState().setItemViewPager(filmDetailPresentation);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
