package com.example.romanm.filmsclientv2.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.romanm.filmsclientv2.data.source.Repository;
import com.example.romanm.filmsclientv2.data.source.local.LocalDataRoom;
import com.example.romanm.filmsclientv2.data.source.local.LocalRoomDAO;
import com.example.romanm.filmsclientv2.data.source.local.LocalSource;
import com.example.romanm.filmsclientv2.data.source.remote.RemoteSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RomanM on 25.10.2017.
 */
@Module
public class DataModule {

    LocalDataRoom localDataRoom;

//    public DataModule(Context context) {
//        localDataRoom = Room.databaseBuilder(context,LocalDataRoom.class,"database").build();
//    }

    @Provides
    @Singleton
    public LocalDataRoom provideLocalDataRoom(Context context) {
        return Room.databaseBuilder(context,LocalDataRoom.class,"database").build();
    }

    @Provides
    @Singleton
    public LocalRoomDAO provideLocalRoomDao(LocalDataRoom localDataRoom) {
        return localDataRoom.getDAO();
    }

    @Provides
    @Singleton
    public RemoteSource provideRemoteSource(){
        return new RemoteSource();
    }

    @Provides
    @Singleton
    public LocalSource provideLocalSource(LocalRoomDAO dao) {
        return new LocalSource(dao);
    }

    @Provides
    @Singleton
    public Repository provideRepository(LocalSource local, RemoteSource remote) {
        return new Repository(local,remote);
    }

}
