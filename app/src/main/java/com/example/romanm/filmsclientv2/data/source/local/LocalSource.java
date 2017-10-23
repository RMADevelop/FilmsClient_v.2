package com.example.romanm.filmsclientv2.data.source.local;

import android.util.Log;

import com.example.romanm.filmsclientv2.data.source.DataSource;
import com.example.romanm.filmsclientv2.pojo.Movie;
import com.example.romanm.filmsclientv2.pojo.SessionId;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;


public class LocalSource implements DataSource {

    private static LocalSource INSTANCE;
    private LocalRoomDAO dao;

    private LocalSource(LocalRoomDAO dao) {
        this.dao = dao;
    }

    public static LocalSource getInstance(LocalRoomDAO dao) {
        if (INSTANCE == null)
            INSTANCE = new LocalSource(dao);
        return INSTANCE;
    }


    @Override
    public void saveSessionId(SessionId sessionId) {

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
    public Maybe<FilmDetail> getFilmInfo(int id) {
        Log.v("remoteLocal", "getLocal");
        return dao.getFilmInfo(id);
    }

    @Override
    public Single<Movie> loadRecommended(int id) {
        return null;
    }

    @Override
    public void saveFilmInfo(FilmDetail film) {
        dao.saveFilmDeatail(film);
        Log.v("remoteLocal", "save dao film");

    }


}
