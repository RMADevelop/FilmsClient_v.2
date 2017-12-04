package com.example.romanm.filmsclientv2.di.modules;

import com.example.romanm.filmsclientv2.domain.interactors.PremiersInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.PremiersInteractorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by RomanM on 30.11.2017.
 */
@Module
public abstract class ListModule {

    @Binds
    public abstract PremiersInteractor providePremiersInteractor(PremiersInteractorImpl premiersInteractor);
}
