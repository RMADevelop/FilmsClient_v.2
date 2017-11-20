package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;

import io.reactivex.Single;

/**
 * Created by RomanM on 16.11.2017.
 */

public interface PremiersInteractor {
    Single<Movie> loadPopular();
}
