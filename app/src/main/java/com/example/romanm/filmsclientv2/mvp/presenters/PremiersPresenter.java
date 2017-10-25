package com.example.romanm.filmsclientv2.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.filmsclientv2.App;
import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.mvp.views.PremiersView;

import javax.inject.Inject;

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

}
