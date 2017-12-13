package com.example.romanm.filmsclientv2.data.source.local;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;

import io.reactivex.Maybe;

/**
 * Created by RomanM on 14.11.2017.
 */

public interface LocalSource {

    Maybe<FilmDetailLocal> getFilmInfo(int id);

    void saveFilmInfo(FilmDetailLocal film);
}
