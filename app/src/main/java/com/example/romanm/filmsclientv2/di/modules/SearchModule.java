package com.example.romanm.filmsclientv2.di.modules;

import com.example.romanm.filmsclientv2.di.scopes.SearchScope;
import com.example.romanm.filmsclientv2.domain.interactors.search.SearchInteractor;
import com.example.romanm.filmsclientv2.domain.interactors.search.SearchInteractorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by RomanM on 30.11.2017.
 */
@Module
public abstract class SearchModule {

    @SearchScope
    @Binds
    public abstract SearchInteractor provideSearchInteractor(SearchInteractorImpl searchInteractor);
}
