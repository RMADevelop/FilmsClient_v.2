package com.example.romanm.filmsclientv2.data.source;


import com.example.romanm.filmsclientv2.data.Item;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;
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

    Single<ReviewsWrapper> loadReviews(int idFilm);

    void saveFilmInfo(FilmDetail film);

    void saveItem(Item item);

    Single<Item> checkDb();

}
