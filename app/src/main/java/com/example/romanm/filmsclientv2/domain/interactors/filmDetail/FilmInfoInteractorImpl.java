package com.example.romanm.filmsclientv2.domain.interactors.filmDetail;

import com.example.romanm.filmsclientv2.di.scopes.DetailScope;
import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;
import com.example.romanm.filmsclientv2.repository.Repository;

import javax.inject.Inject;

import io.reactivex.Maybe;

/**
 * Created by RomanM on 15.11.2017.
 */

@DetailScope
public class FilmInfoInteractorImpl implements FilmInfoInteractor {
    private Repository repository;


    @Inject
    public FilmInfoInteractorImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<FilmDetailDomain> getFilmDetail(int idFilm) {
        return repository.getFilmInfo(idFilm);
    }


}
