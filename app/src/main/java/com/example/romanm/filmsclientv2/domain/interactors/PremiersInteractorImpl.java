package com.example.romanm.filmsclientv2.domain.interactors;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.repository.Repository;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by RomanM on 16.11.2017.
 */

public class PremiersInteractorImpl implements PremiersInteractor {

    Repository repository;

@Inject
    public PremiersInteractorImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Movie> loadPopular() {
        return repository.loadPopular();
    }
}
