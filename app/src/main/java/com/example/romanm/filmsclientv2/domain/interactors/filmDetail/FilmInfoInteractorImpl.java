package com.example.romanm.filmsclientv2.domain.interactors.filmDetail;

import com.example.romanm.filmsclientv2.di.scopes.FilmInfoScope;
import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;
import com.example.romanm.filmsclientv2.repository.Repository;
import com.example.romanm.filmsclientv2.utils.Schedulers.SchedulersManager;

import javax.inject.Inject;

import io.reactivex.Maybe;

/**
 * Created by RomanM on 15.11.2017.
 */

@FilmInfoScope
public class FilmInfoInteractorImpl implements FilmInfoInteractor {
    private final Repository repository;

    private final SchedulersManager schedulersManager;

    @Inject
    public FilmInfoInteractorImpl(Repository repository, SchedulersManager schedulersManager) {
        this.repository = repository;
        this.schedulersManager = schedulersManager;
    }


    @Override
    public Maybe<FilmDetailDomain> getFilmDetail(int idFilm) {
        return repository.getFilmInfo(idFilm)
                .subscribeOn(schedulersManager.getIo());
    }
}
