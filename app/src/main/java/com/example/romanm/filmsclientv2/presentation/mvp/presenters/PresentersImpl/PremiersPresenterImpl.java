package com.example.romanm.filmsclientv2.presentation.mvp.presenters.PresentersImpl;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.domain.interactors.PremiersInteractorImpl;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;
import com.example.romanm.filmsclientv2.presentation.mvp.model.FilmPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.model.mapper.FilmMapperPresentation;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.PremiersPresenter;
import com.example.romanm.filmsclientv2.presentation.mvp.views.PremiersView;
import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.Result;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 25.10.2017.
 */
@InjectViewState
public class PremiersPresenterImpl extends MvpPresenter<PremiersView> implements PremiersPresenter {

    private PremiersInteractorImpl premiersInteractor;

    private FilmMapperPresentation mapper;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public PremiersPresenterImpl(PremiersInteractorImpl premiersInteractor, FilmMapperPresentation mapper) {
        this.premiersInteractor = premiersInteractor;
        this.mapper = mapper;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getPremiersFilms();
    }

    @Override
    public void getPremiersFilms() {
        compositeDisposable.add(premiersInteractor.loadPopular()
                .map(mapper::transform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<FilmPresentation>>() {
                    @Override
                    public void onSuccess(List<FilmPresentation> results) {
                        getViewState().showPopulars(results);
                        if (getViewState() == null) {
                            Log.d(TAG, "onSuccess() returned: " + getViewState());
                        }
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
