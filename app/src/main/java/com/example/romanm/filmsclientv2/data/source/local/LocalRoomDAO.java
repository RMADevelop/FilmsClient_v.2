package com.example.romanm.filmsclientv2.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.roma.filmsclient.pojo.filmDetail.FilmDetail;

import io.reactivex.Maybe;


@Dao
public interface LocalRoomDAO  {

    @Insert
    void saveFilmDeatail(FilmDetail film);

    @Query("SELECT * FROM FilmDetail WHERE id = :id")
    Maybe<FilmDetail> getFilmInfo(int id);
}
//