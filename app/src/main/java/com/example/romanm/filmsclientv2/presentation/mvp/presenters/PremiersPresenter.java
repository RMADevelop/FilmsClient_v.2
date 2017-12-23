package com.example.romanm.filmsclientv2.presentation.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.exception.NoNetworkException;
import com.example.romanm.filmsclientv2.domain.interactors.PremiersInteractor;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.views.PremiersView;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by RomanM on 25.10.2017.
 */

@InjectViewState
public class PremiersPresenter extends BasePresenter<PremiersView>{

    private PremiersInteractor premiersInteractor;

    private FilmMapperPresentation mapper;

    private SchedulersManager schedulersManager;

    private boolean isLoad;

    @Inject
    public PremiersPresenter(PremiersInteractor premiersInteractor, FilmMapperPresentation mapper, SchedulersManager schedulersManager) {
        this.premiersInteractor = premiersInteractor;
        this.mapper = mapper;
        this.schedulersManager = schedulersManager;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getPremiersFilms();
    }

    public void getPremiersFilms() {
        if (!isLoad) {
            isLoad = true;
            compositeDisposable.add(premiersInteractor.loadPopular()
                    .map(mapper::transform)
                    .doOnSuccess(filmPresentations -> isLoad = false)
                    .observeOn(schedulersManager.getMainThread())
                    .subscribeWith(new DisposableSingleObserver<List<FilmPresentation>>() {
                        @Override
                        public void onSuccess(List<FilmPresentation> results) {
                            getViewState().showPopulars(results);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e instanceof NoNetworkException) {
                                // error on view
                            } else {
                                e.printStackTrace();
                            }
                        }
                    }));
        }
    }
}
