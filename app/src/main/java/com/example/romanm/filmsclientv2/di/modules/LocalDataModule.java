package com.example.romanm.filmsclientv2.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.romanm.filmsclientv2.data.source.local.LocalDataRoom;
import com.example.romanm.filmsclientv2.data.source.local.LocalRoomDAO;
import com.example.romanm.filmsclientv2.data.source.local.LocalSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 26.10.2017.
 */
@Module
public class LocalDataModule {

    @Provides
    @Singleton
    LocalDataRoom provideLocalDataRoom(Context context) {
        return Room.databaseBuilder(context, LocalDataRoom.class, "database").build();
    }

    @Provides
    @Singleton
    LocalRoomDAO provideLocalRoomDao(LocalDataRoom localDataRoom) {
        return localDataRoom.getDAO();
    }

    @Provides
    @Singleton
    LocalSource provideLocalSource(LocalRoomDAO dao) {
        return new LocalSource(dao);
    }
}
