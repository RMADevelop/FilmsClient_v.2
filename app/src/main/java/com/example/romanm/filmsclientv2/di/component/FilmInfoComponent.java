package com.example.romanm.filmsclientv2.di.component;

import com.example.romanm.filmsclientv2.di.modules.filmDetail.BaseInfoModule;
import com.example.romanm.filmsclientv2.di.modules.filmDetail.FilmDetailModule;
import com.example.romanm.filmsclientv2.di.scopes.InteractorScope;
import com.example.romanm.filmsclientv2.presentation.ui.fragments.FilmDetailFragment;

import dagger.Subcomponent;

/**
 * Created by RomanM on 15.11.2017.
 */
@InteractorScope
@Subcomponent(modules = {FilmDetailModule.class})
public interface FilmInfoComponent {

    void inject(FilmDetailFragment filmDetailFragment);

    BaseInfoComponent plusBaseInfoComponent(BaseInfoModule baseInfoModule);


}
