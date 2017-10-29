package com.example.romanm.filmsclientv2.data.source;

import android.util.Log;

import com.example.romanm.filmsclientv2.data.Item;
import com.example.romanm.filmsclientv2.data.source.local.LocalSource;
import com.example.romanm.filmsclientv2.data.source.remote.RemoteSource;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.ReviewsWrapper;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Roma on 09.09.2017.
 */

public class Repository implements DataSource {

    LocalSource local;

    RemoteSource remote;


    private static Repository INSTANCE;

    public Repository(LocalSource local, RemoteSource remote) {
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

    @Override
    public void saveItem(Item item) {
        local.saveItem(item);
    }

    @Override
    public Single<Item> checkDb() {
        return local.checkDb();
    }

}
