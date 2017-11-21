package com.example.romanm.filmsclientv2.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.Maybe;


@Dao
public interface LocalRoomDAO  {

    @Insert
    void saveFilmDeatail(FilmDetailLocal film);

    @Query("SELECT * FROM FilmDetailLocal WHERE id = :id")
    Maybe<FilmDetailLocal> getFilmInfo(int id);
}
//