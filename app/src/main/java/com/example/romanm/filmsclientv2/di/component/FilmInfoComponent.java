package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.FilmDetailModule;
import com.example.romanm.filmsclientv2.di.scopes.FilmInfoScope;
import com.example.romanm.filmsclientv2.presentation.mvp.presenters.filmDetail.FilmInfoPresenter;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.FilmDetailFragment;

import dagger.Subcomponent;

/**
 * Created by RomanM on 15.11.2017.
 */

@FilmInfoScope
@Subcomponent(modules = FilmDetailModule.class)
public interface FilmInfoComponent {

    FilmInfoPresenter getPresenter();
    void inject(FilmDetailFragment filmDetailFragment);
}
