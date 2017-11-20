package com.example.romanm.filmsclientv2.data.source.local;

import android.util.Log;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;
import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.ReviewsWrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class Local implements LocalSource {

    private LocalRoomDAO dao;

    @Inject
    public Local(LocalRoomDAO dao) {
        this.dao = dao;
    }

    @Override
    public Single<Movie> loadMoviesNowPlaying() {
        return null;
    }

    @Override
    public Single<Movie> loadPopular() {
        return null;
    }

    @Override
    public Single<Movie> loadTopRated() {
        return null;
    }

    @Override
    public Single<Movie> loadUpcoming() {
        return null;
    }

    @Override
    public Maybe<FilmDetailLocal> getFilmInfo(int id) {
        Log.v("remoteLocal", "getLocal");
        return dao.getFilmInfo(id);
    }

    @Override
    public Single<Movie> loadRecommended(int id) {
        return null;
    }

    @Override
    public Single<ReviewsWrapper> loadReviews(int idFilm) {
        return null;
    }

    @Override
    public void saveFilmInfo(FilmDetailLocal film) {
        dao.saveFilmDeatail(film);
        Log.v("remoteLocal", "save dao film");

    }
}
