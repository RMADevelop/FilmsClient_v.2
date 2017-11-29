package com.example.romanm.filmsclientv2.domain.interactors.search;

import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.di.scopes.SearchScope;
import com.example.romanm.filmsclientv2.domain.interactors.search.SearchInteractor;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManagerImpl;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by RomanM on 26.11.2017.
 */
@SearchScope
public class SeaerchInteractorImpl implements SearchInteractor {
    private final Repository repository;

    private final SchedulersManager schedulersManager;

    @Inject

    public SeaerchInteractorImpl(Repository repository, SchedulersManagerImpl schedulersManager) {
        this.repository = repository;
        this.schedulersManager = schedulersManager;
    }



    @Override
    public Single<Movie> getSearchFilms(String query, int page) {
        return repository.getSearchFilms(query, page);
    }
}
