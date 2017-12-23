package com.example.romanm.filmsclientv2.presentation.mvp.presenters;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by RomanM on 23.12.2017.
 */

public class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }
}
