package com.example.romanm.filmsclientv2.data.source.local;

import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 14.11.2017.
 */

public interface LocalSource {
    public Single<Movie> loadMoviesNowPlaying();

    public Single<Movie> loadPopular();

    public Single<Movie> loadTopRated();

    public Single<Movie> loadUpcoming();

    public Maybe<FilmDetail> getFilmInfo(int id);

    public Single<Movie> loadRecommended(int id);

    public Single<ReviewsWrapper> loadReviews(int idFilm);

    public void saveFilmInfo(FilmDetail film);

}
