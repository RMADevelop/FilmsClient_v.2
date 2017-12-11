package com.example.romanm.filmsclientv2.data.source.local;

import android.util.Log;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;

@Singleton
public class Local implements LocalSource {

    private LocalRoomDAO dao;

    @Inject
    public Local(LocalRoomDAO dao) {
        this.dao = dao;
    }

    @Override
    public Maybe<FilmDetailLocal> getFilmInfo(int id) {
        Log.v("remoteLocal", "getLocal");
        return dao.getFilmInfo(id);
    }

    @Override
    public void saveFilmInfo(FilmDetailLocal film) {
        dao.saveFilmDeatail(film);
        Log.v("remoteLocal", "save dao film");

    }
}
