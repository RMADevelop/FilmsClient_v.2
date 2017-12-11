package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.domain.PaginationState;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by RomanM on 16.11.2017.
 */

public class PremiersInteractorImpl implements PremiersInteractor {


    private final Repository repository;

    private final SchedulersManager schedulersManager;

    private final PaginationState paginationState;
    
    @Inject
    public PremiersInteractorImpl(Repository repository, SchedulersManager schedulersManager, PaginationState paginationState) {
        this.repository = repository;
        this.schedulersManager = schedulersManager;
        this.paginationState = paginationState;
    }



    @Override
    public Single<List<FilmDomain>> loadPopular() {
        return repository.loadPopular(paginationState.getPage())
                .doOnSuccess(movie ->paginationState.nextPage())
                .subscribeOn(schedulersManager.getIo());
    }


}
