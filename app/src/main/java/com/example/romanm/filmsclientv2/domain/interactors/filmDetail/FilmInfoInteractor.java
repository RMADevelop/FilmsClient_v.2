package com.example.romanm.filmsclientv2.domain.interactors.filmDetail;

import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;

import io.reactivex.Maybe;

/**
 * Created by RomanM on 15.11.2017.
 */

public interface FilmInfoInteractor {

    Maybe<FilmDetailDomain> getFilmDetail(int idFilm);

}
