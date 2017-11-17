package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.di.scopes.InteractorScope;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 15.11.2017.
 */

@InteractorScope
public class FilmInfoInteractorImpl implements FilmInfoInteractor {
    private Repository repository;

    private FilmDetail filmDetail;

    @Inject
    public FilmInfoInteractorImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<FilmDetail> getFilmDetail(int idFilm) {
        return repository.getFilmInfo(idFilm)
                .doOnSuccess(filmDetail1 -> this.filmDetail = filmDetail1);
    }

    @Override
    public Single<FilmDetail> getForChild() {
        return Single.just(filmDetail);
    }
}
