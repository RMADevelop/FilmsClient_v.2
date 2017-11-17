package com.example.romanm.filmsclientv2.data.source.remote;


import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class Remote implements RemoteSource {


    private Server server;

    @Inject
    public Remote(Server server) {
        this.server = server;
    }

    @Override
    public Single<Movie> loadMoviesNowPlaying() {
        return server.getMovie();
    }

    @Override
    public Single<Movie> loadPopular() {
        return server.getPopular();
    }

    @Override
    public Single<Movie> loadTopRated() {
        return server.getTopRated();
    }

    @Override
    public Single<Movie> loadUpcoming() {
        return server.getUpcoming();
    }

    @Override
    public Maybe<FilmDetail> getFilmInfo(int id) {
        return server.getFilmInfo(id);
    }

    @Override
    public Single<Movie> loadRecommended(int id) {

        return server.getRecommended(id);
    }

    @Override
    public Single<ReviewsWrapper> loadReviews(int idFilm) {
        return server.getReviews(idFilm);
    }

}
