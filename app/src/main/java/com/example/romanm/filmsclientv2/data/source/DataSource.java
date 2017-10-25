package com.example.romanm.filmsclientv2.data.source;



import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.SessionId;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;


public interface DataSource {

    Single<Movie> loadMoviesNowPlaying();

    Single<Movie> loadPopular();

    Single<Movie> loadTopRated();

    Single<Movie> loadUpcoming();

    Maybe<FilmDetail> getFilmInfo(int id);

    Single<Movie> loadRecommended(int id);

    void saveFilmInfo(FilmDetail film);

}
