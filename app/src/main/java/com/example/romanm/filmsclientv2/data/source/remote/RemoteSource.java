package com.example.romanm.filmsclientv2.data.source.remote;

import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.ReviewsWrapper;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 14.11.2017.
 */

public interface RemoteSource {

    Single<Movie> loadMoviesNowPlaying();

    Single<Movie> loadPopular(int id);

    Single<Movie> loadTopRated();

    Single<Movie> loadUpcoming();

    Single<Movie> getSearchFilms(String query, int page);

    Maybe<FilmDetail> getFilmInfo(int id);

    Single<Movie> loadRecommended(int id);

    Single<ReviewsWrapper> loadReviews(int idFilm);
}
