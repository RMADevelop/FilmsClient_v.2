package com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.filmDetail.FilmInfoInteractorImpl;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmDetailPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmDetailMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.views.FilmInfoView;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManagerImpl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class FilmInfoPresenterImpl extends MvpPresenter<FilmInfoView> implements FilmInfoPresenter {

    private FilmInfoInteractor filmInfoInteractor;

    private FilmDetailMapperPresentation mapper;

    private SchedulersManager schedulersManager;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject

    public FilmInfoPresenterImpl(FilmInfoInteractorImpl filmInfoInteractor, FilmDetailMapperPresentation mapper, SchedulersManagerImpl schedulersManager) {
        this.filmInfoInteractor = filmInfoInteractor;
        this.mapper = mapper;
        this.schedulersManager = schedulersManager;
    }




    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

    @Override
    public void loadFilm(int idFilm) {
        compositeDisposable.add(filmInfoInteractor.getFilmDetail(idFilm)
                .toSingle()
                .map(mapper::transform)
                .observeOn(schedulersManager.getMainThread())
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
                }));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
