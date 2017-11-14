package com.example.romanm.filmsclientv2.repository;

import android.util.Log;

import com.example.romanm.filmsclientv2.data.source.local.Local;
import com.example.romanm.filmsclientv2.data.source.remote.Remote;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by Roma on 09.09.2017.
 */
@Singleton
public class Repository implements DataSource {

    private final Local local;

    private final Remote remote;


    @Inject
    public Repository(Local local, Remote remote) {
        this.local = local;
        this.remote = remote;
    }


    @Override
    public Single<Movie> loadMoviesNowPlaying() {
        return remote.loadMoviesNowPlaying();
    }

    @Override
    public Single<Movie> loadPopular() {
        return remote.loadPopular();
    }

    @Override
    public Single<Movie> loadTopRated() {
        return remote.loadTopRated();
    }

    @Override
    public Single<Movie> loadUpcoming() {
        return remote.loadUpcoming();
    }

    @Override
    public Maybe<FilmDetail> getFilmInfo(int id) {
        return Maybe.concat(
                local.getFilmInfo(id),
                remote.getFilmInfo(id)
                        .doOnSuccess(this::saveFilmInfo)
        )
                .firstElement();
    }

    @Override
    public Single<Movie> loadRecommended(int id) {
        return remote.loadRecommended(id);
    }

    @Override
    public Single<ReviewsWrapper> loadReviews(int idFilm) {
        return remote.loadReviews(idFilm);
    }

    @Override
    public void saveFilmInfo(FilmDetail film) {
        local.saveFilmInfo(film);
        Log.v("remoteLocal", "save film");
    }
}
