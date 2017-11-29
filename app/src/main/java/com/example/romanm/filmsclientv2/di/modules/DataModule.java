package com.example.romanm.filmsclientv2.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.romanm.filmsclientv2.data.source.local.LocalDataRoom;
import com.example.romanm.filmsclientv2.data.source.local.LocalRoomDAO;
import com.example.romanm.filmsclientv2.data.source.remote.Server;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RomanM on 14.11.2017.
 */
@Module
public class DataModule {

    private String baseUrl;

    public DataModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    Server provideApi(Retrofit retrofit) {
        return retrofit.create(Server.class);
    }

    @Singleton
    @Provides
    LocalDataRoom provideDatabase(Context context) {
        return Room.databaseBuilder(context, LocalDataRoom.class,"database").build();
    }

    @Singleton
    @Provides
    LocalRoomDAO ptovideDao(LocalDataRoom dataRoom) {
        return dataRoom.getDAO();
    }
}
