package com.example.romanm.filmsclientv2.repository;


import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.ReviewsWrapper;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;
import com.example.romanm.filmsclientv2.domain.models.FilmDetailDomain;
import com.example.romanm.filmsclientv2.domain.models.FilmDomain;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;


public interface DataSource {

    Single<Movie> loadMoviesNowPlaying();

    Single<List<FilmDomain>> loadPopular(int page);

    Single<Movie> loadTopRated();

    Single<Movie> loadUpcoming();

    Single<Movie> getSearchFilms(String query, int page);

    Maybe<FilmDetailDomain> getFilmInfo(int id);

    Single<Movie> loadRecommended(int id);

    Single<ReviewsWrapper> loadReviews(int idFilm);

    void saveFilmInfo(FilmDetail film);

}
