package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.domain.models.FilmDomain;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 16.11.2017.
 */

public interface PremiersInteractor {
    Single<List<FilmDomain>> loadPopular();
}
