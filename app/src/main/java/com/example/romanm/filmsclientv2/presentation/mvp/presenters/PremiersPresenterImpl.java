package com.example.romanm.filmsclientv2.presentation.mvp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.PremiersInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.PremiersInteractorImpl;
import com.example.romanm.filmsclientv2.domain.interactors.search.SearchInteractor;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.views.PremiersView;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManagerImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 25.10.2017.
 */
@InjectViewState
public class PremiersPresenterImpl extends MvpPresenter<PremiersView>{

    private PremiersInteractor premiersInteractor;

    private FilmMapperPresentation mapper;

    private SchedulersManager schedulersManager;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Inject

    public PremiersPresenterImpl(PremiersInteractorImpl premiersInteractor, FilmMapperPresentation mapper, SchedulersManagerImpl schedulersManager) {
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
        compositeDisposable.add(premiersInteractor.loadPopular()
                .map(mapper::transform)
                .observeOn(schedulersManager.getMainThread())
                .subscribeWith(new DisposableSingleObserver<List<FilmPresentation>>() {
                    @Override
                    public void onSuccess(List<FilmPresentation> results) {
                        getViewState().showPopulars(results);
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
