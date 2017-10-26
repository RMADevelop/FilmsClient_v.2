package com.example.romanm.filmsclientv2.mvp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.data.Item;
import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.mvp.views.PremiersView;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 25.10.2017.
 */
@InjectViewState
public class PremiersPresenter extends MvpPresenter<PremiersView> {

    @Inject
    Repository repository;


    public PremiersPresenter() {
        App.getAppComponent().inject(this);
    }

    public void testSave() {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                for (int i = 0; i < 10; i++) {
                    repository.saveItem(new Item());
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .subscribe();
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
}
