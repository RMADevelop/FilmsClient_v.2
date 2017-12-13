package com.example.romanm.filmsclientv2.domain.interactors.search;

import com.example.romanm.filmsclientv2.di.scopes.SearchScope;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by RomanM on 26.11.2017.
 */
@SearchScope
public class SearchInteractorImpl implements SearchInteractor {

    private final Repository repository;

    private final SchedulersManager schedulersManager;

    @Inject
    public SearchInteractorImpl(Repository repository, SchedulersManager schedulersManager) {
        this.repository = repository;
        this.schedulersManager = schedulersManager;
    }

    @Override
    public Single<List<FilmDomain>> getSearchFilms(String query, int page) {
        return repository.getSearchFilms(query, page)
                .subscribeOn(schedulersManager.getIo());
    }
}
