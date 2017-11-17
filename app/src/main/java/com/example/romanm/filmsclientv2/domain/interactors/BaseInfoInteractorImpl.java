package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.di.scopes.PresenterScope;
import com.example.romanm.filmsclientv2.repository.Repository;

import javax.inject.Inject;

/**
 * Created by RomanM on 16.11.2017.
 */
@PresenterScope
public class BaseInfoInteractorImpl implements BaseInfoInteractor {

    private Repository repository;

    @Inject
    public BaseInfoInteractorImpl(Repository repository) {
        this.repository = repository;
    }
}
