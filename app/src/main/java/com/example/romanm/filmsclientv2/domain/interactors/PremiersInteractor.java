package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.pojo.Movie;

import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by RomanM on 16.11.2017.
 */

public interface PremiersInteractor {
    Single<Movie> loadPopular();
}
