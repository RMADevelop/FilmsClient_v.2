package com.example.romanm.filmsclientv2.domain.interactors.search;

import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;

import io.reactivex.Single;

/**
 * Created by RomanM on 26.11.2017.
 */

public interface SearchInteractor {

    Single<Movie> getSearchFilms(String query, int page);

}
