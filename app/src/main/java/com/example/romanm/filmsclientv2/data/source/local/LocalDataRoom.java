package com.example.romanm.filmsclientv2.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.romanm.filmsclientv2.data.Item;
import com.example.romanm.filmsclientv2.pojo.filmDetail.FilmDetail;


@Database(entities = {FilmDetail.class, Item.class},version = 1)
public abstract class LocalDataRoom  extends RoomDatabase{

    public abstract LocalRoomDAO getDAO();


}
