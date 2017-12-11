package com.example.romanm.filmsclientv2.data.source.local;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;
import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.ReviewsWrapper;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 14.11.2017.
 */

public interface LocalSource {

    Maybe<FilmDetailLocal> getFilmInfo(int id);

    void saveFilmInfo(FilmDetailLocal film);

}
