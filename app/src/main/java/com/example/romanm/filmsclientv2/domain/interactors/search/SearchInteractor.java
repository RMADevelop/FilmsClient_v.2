package com.example.romanm.filmsclientv2.domain.interactors.search;

import com.example.romanm.filmsclientv2.domain.models.FilmDomain;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 26.11.2017.
 */

public interface SearchInteractor {

    Single<List<FilmDomain>> getSearchFilms(String query, int page);

}
