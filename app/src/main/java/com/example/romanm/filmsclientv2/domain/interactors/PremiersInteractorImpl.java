package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.domain.common.PaginationState;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;
import com.example.romanm.filmsclientv2.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 16.11.2017.
 */

public class PremiersInteractorImpl implements PremiersInteractor {


    private Repository repository;

    private PaginationState paginationState;

    @Inject
    public PremiersInteractorImpl(Repository repository, PaginationState paginationState) {
        this.repository = repository;
        this.paginationState = paginationState;
    }

    @Override
    public Single<List<FilmDomain>> loadPopular() {
        return repository.loadPopular(paginationState.getPage())
                .doOnSuccess(movie ->paginationState.nextPage())
                .subscribeOn(Schedulers.io())
        ;
    }


}
