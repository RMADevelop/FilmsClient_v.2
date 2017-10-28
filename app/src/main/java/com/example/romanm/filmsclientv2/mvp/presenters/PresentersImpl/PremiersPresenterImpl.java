package com.example.romanm.filmsclientv2.mvp.presenters.PresentersImpl;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.data.Item;
import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.mvp.presenters.PremiersPresenter;
import com.example.romanm.filmsclientv2.mvp.views.PremiersView;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.Result;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 25.10.2017.
 */
@InjectViewState
public class PremiersPresenterImpl extends MvpPresenter<PremiersView> implements PremiersPresenter {

    @Inject
    Repository repository;


    public PremiersPresenterImpl() {
        App.getAppComponent().inject(this);
    }

    public void checkDb() {
        repository.checkDb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Item>() {
                    @Override
                    public void onSuccess(Item item) {
                        Log.v("DFSD", "Check " + item.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void getPremiersFilms() {
        repository.loadPopular()
                .subscribeOn(Schedulers.io())
                .map(Movie::getResults)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Result>>() {
                    @Override
                    public void onSuccess(List<Result> results) {
                        getViewState().showPopulars(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
