package com.example.romanm.filmsclientv2.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.romanm.filmsclientv2.data.source.local.models.FilmDetailLocal;


@Database(entities = {FilmDetailLocal.class}, version = 1)
public abstract class LocalDataRoom extends RoomDatabase {
    public abstract LocalRoomDAO getDAO();
}
