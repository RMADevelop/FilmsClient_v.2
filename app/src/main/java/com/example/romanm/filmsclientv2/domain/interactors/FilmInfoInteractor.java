package com.example.romanm.filmsclientv2.domain.interactors;

import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 15.11.2017.
 */

public interface FilmInfoInteractor {

    Maybe<FilmDetail> getFilmDetail(int idFilm);

    Single<FilmDetail> getForChild();
}
